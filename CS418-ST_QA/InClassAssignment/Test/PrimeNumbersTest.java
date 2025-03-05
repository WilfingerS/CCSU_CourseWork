import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
public class PrimeNumbersTest {
    static public Object[] expectedTest(){
        return new Object[][]{
                {3,"[2, 3, 5]"},
                {4,"[2, 3, 5, 7]"},
                {5,"[2, 3, 5, 7, 11]"},
                {6,"[2, 3, 5, 7, 11, 13]"},
                {7,"[2, 3, 5, 7, 11, 13, 17]"}
        };
    }
    @ParameterizedTest(name="Test{index}: n={0},out={1}")
    @MethodSource("expectedTest")
    void test_toStringMethod(int n,String out) {
        PrimeNumbers test = new PrimeNumbers();
        test.computePrimes(n);
        assertEquals(out,test.toString());
    }
}
