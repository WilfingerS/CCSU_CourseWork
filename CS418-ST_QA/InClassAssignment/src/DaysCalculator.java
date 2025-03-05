public class DaysCalculator {

    /**
     * Calculates the number of days between two given dates in the same year.
     *
     * @param month1 the month of the first date
     * @param day1   the day of the first date
     * @param month2 the month of the second date
     * @param day2   the day of the second date
     * @param year   the year in which the dates occur
     * @return the number of days between the two given dates
     * @throws IllegalArgumentException if the input parameters are invalid
     */
    public static int getNumberOfDays (int month1, int day1, int month2, int day2, int year) {

        if (month1 < 1 || month1 > 12 || month2 < 1 || month2 > 12) {
            throw new IllegalArgumentException("Months must be in range 1..12");
        }

        if (month1 > month2) {
            throw new IllegalArgumentException("month1 must be prior or equals to month2");
        }

        if ((day1 < 1) || (day1 > 31) || (day2 < 1) || (day2 > 31)) {
            throw new IllegalArgumentException("Days must be in range 1..31");
        }

        if ((year < 1) || (year > 10000)) {
            throw new IllegalArgumentException("Years must be in range 1..10000");
        }



        if (!checkDayIsValid(month1, day1, year) || !checkDayIsValid(month2, day2, year)) {
            throw new IllegalArgumentException("Days must be valid in their respective months");
        }


        int numDays = 0;

        // in the same month
        if (month1 == month2) {
            numDays = day2 - day1;
            if (numDays < 0) {
                throw new IllegalArgumentException("The second date must be later than the first date if both dates are within the same month");
            }
        } else {
            // Fill the daysIn array with the number of days in each month of the specified year, accounting for leap years
            int[] daysIn = getNumberOfDaysInYear(year);

            // start with days in the two months
            numDays = day2 + (daysIn[month1 - 1] - day1);

            // add the days in the intervening months
            for (int i = month1; i < month2 - 1; i++) {
                numDays += daysIn[i];
            }
        }
        return numDays;
    }


    /**
     * Retrieves the number of days in each month of a specified year.
     *
     * @param year the year for which to retrieve the number of days in each month
     * @return an array containing the number of days in each month of the specified year
     */
    public static int[] getNumberOfDaysInYear(int year) {
        int[] daysIn = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // Are we in a leap year? If so, update February (i.e., index number 1)
        if (isLeapYear(year)) {
            daysIn[1] = 29; // Leap year
        }
        return daysIn;
    }

    /**
     * Checks if the given year is a leap year.
     *
     * @param year the year to be checked for leap year
     * @return true if the year is a leap year, otherwise false
     */
    public static boolean isLeapYear(int year) {
        // Are we in a leap year?
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    /**
     * Checks if the provided day is valid for the given month and year.
     *
     * @param month the month for which to check the day validity
     * @param day   the day to be checked for validity
     * @param year  the year for which to check the day validity
     * @return true if the day is valid for the given month and year, otherwise false
     */
    private static boolean checkDayIsValid(int month, int day, int year) {
        // Check if the days are within valid ranges for their respective months

        // Check for February
        if (month == 2) {
            // Leap year and February
            if (isLeapYear(year)) {
                return day >= 1 && day <= 29;
            } else {
                return day >= 1 && day <= 28;
            }
        }
        // April, June, September, November
        else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day >= 1 && day <= 30;
        }
        // All other months
        else {
            return day >= 1 && day <= 31;
        }
    }

}