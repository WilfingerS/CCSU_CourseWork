public class Date {
    public static int numberOfDays(int month, int year){
        if (month <= 0 || month > 12){
            throw new IllegalArgumentException("Months must be in range 1..12");
        }

        if (month == 2){ // Februrary
            if (year %400 == 0 || (year %4==0 && year%100 !=0)){
                return 29; // Leap Year
            }else{
                return 28;
            }
        }

        if (month <= 7){ // 31 Day month
            if (month%2 == 1){
                return 31;
            }
            return 30;
        }

        if (month %2 == 0){  // 30 days
            return 31;
        }
        return 30;
    }
}
