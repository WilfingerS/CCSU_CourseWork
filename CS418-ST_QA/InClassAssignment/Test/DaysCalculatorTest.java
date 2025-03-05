import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.*;

class DaysCalculatorTest {

    @Test
    @DisplayName("Illegal Exception Test")
    void illegalTest(){
        assertAll(
                ()->assertThrows(
                        IllegalArgumentException.class,
                        () -> DaysCalculator.getNumberOfDays(-1,1,1,1,2000),
                        "Negative Month"
                ),
                ()-> assertThrows(
                        IllegalArgumentException.class,
                        () -> DaysCalculator.getNumberOfDays(1,1,-1,1,2000),
                        "Negative Month"
                ),
                ()->assertThrows(
                        IllegalArgumentException.class,
                        () -> DaysCalculator.getNumberOfDays(1,1,999,1,2000),
                        "Large Month"
                ),
                ()->assertThrows(
                        IllegalArgumentException.class,
                        () -> DaysCalculator.getNumberOfDays(999,1,1,1,2000),
                        "Large Month"
                ),
                ()->assertThrows(
                        IllegalArgumentException.class,
                        () -> DaysCalculator.getNumberOfDays(12,1,1,1,2000),
                        "Month 1 > Month 2"
                ),
                ()->assertThrows(
                        IllegalArgumentException.class,
                        () -> DaysCalculator.getNumberOfDays(1,-1,2,1,2000),
                        "Days outside range"
                ),
                ()->assertThrows(
                        IllegalArgumentException.class,
                        () -> DaysCalculator.getNumberOfDays(1,1,2,-1,2000),
                        "Days outside range"
                ),
                ()->assertThrows(
                        IllegalArgumentException.class,
                        () -> DaysCalculator.getNumberOfDays(1,32,2,1,2000),
                        "Days outside range"
                ),
                ()->assertThrows(
                        IllegalArgumentException.class,
                        () -> DaysCalculator.getNumberOfDays(1,1,2,32,2000),
                        "Days outside range"
                ),
                ()->assertThrows(
                        IllegalArgumentException.class,
                        () -> DaysCalculator.getNumberOfDays(1,-1,2,1,0),
                        "Year outside range"
                ),
                ()->assertThrows(
                        IllegalArgumentException.class,
                        () -> DaysCalculator.getNumberOfDays(1,-1,2,1,10001),
                        "Year outside range"
                ),
                ()->assertThrows(
                        IllegalArgumentException.class,
                        () -> DaysCalculator.getNumberOfDays(2,29,2,30,2024),
                        "Invalid Date"
                ),
                ()->assertThrows(
                        IllegalArgumentException.class,
                        () -> DaysCalculator.getNumberOfDays(1,1,2,29,2025),
                        "Invalid Date"
                ),
                ()->assertThrows(
                        IllegalArgumentException.class,
                        () -> DaysCalculator.getNumberOfDays(2,2,2,1,2025),
                        "Same Month"
                )
        );
    }

    private static Object[] paramTesting(){
        return new Object[][] {
                // ...,expected
                {1,15,1,20,2000,5},
                {3,3,3,3,2024,0},
                {2,29,2,29,2024,0},
                {1,1,12,31,2025,364} // 365 days in a year
        };
    }


    @ParameterizedTest(name="Test #{index}: expected={5},m1={0},d1={1},m2={2},d2={3},year={4}")
    @MethodSource("paramTesting")
    void getNumberTest(int m1, int d1, int m2, int d2,int year,int output){
        int dayCount = DaysCalculator.getNumberOfDays(m1,d1,m2,d2,year);
        assertEquals(output,dayCount);
    }

}