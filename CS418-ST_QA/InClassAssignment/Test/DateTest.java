import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void numberOfDays() {
        assertAll(
            // Illegal Argument Testing
            () -> assertThrows(IllegalArgumentException.class,() ->Date.numberOfDays(13,2000)),
            () -> assertThrows(IllegalArgumentException.class,() ->Date.numberOfDays(-1,2000)),
            // Leap Year
            () -> assertEquals(28,Date.numberOfDays(2,2025),"Februrary 28th"),
            () -> assertEquals(28,Date.numberOfDays(2,2001), "Februrary 28th"),
            () -> assertEquals(29,Date.numberOfDays(2,2024), "Februrary 29th"),
            () -> assertEquals(29,Date.numberOfDays(2,2000), "Februrary 29th"),
            // 31 Day Testing
            () -> assertEquals(31,Date.numberOfDays(1,2025),"31 Days"),
            () -> assertEquals(31,Date.numberOfDays(3,2025),"31 Days"),
            () -> assertEquals(31,Date.numberOfDays(5,2025),"31 Days"),
            () -> assertEquals(31,Date.numberOfDays(7,2025),"31 Days"),
            () -> assertEquals(31,Date.numberOfDays(8,2025),"31 Days"),
            () -> assertEquals(31,Date.numberOfDays(10,2025),"31 Days"),
            () -> assertEquals(31,Date.numberOfDays(12,2025),"31 Days"),
            // 30 Days
            () -> assertEquals(30,Date.numberOfDays(4,2025),"30 Days"),
            () -> assertEquals(30,Date.numberOfDays(6,2025),"30 Days"),
            () -> assertEquals(30,Date.numberOfDays(9,2025),"30 Days"),
            () -> assertEquals(30,Date.numberOfDays(11,2025),"30 Days")
        );
    }
}