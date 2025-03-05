import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

class CountWordsTest {
    private static Object[] paramTesting(){
        return new Object[][] {
                // input/output
                {"",0},
                {"hello world",0},
                {"lightning mcqueen", 1},
                {"gas lighting",2},
                {"cars are cool",1},
                {"hello cards",1},
                {"cats! and dogs! swimming???",3}
        };
    }
    @Test
    @DisplayName("Nullpointer Thrown Test")
    void testNull(){
        assertThrows(NullPointerException.class,() ->CountWords.count(null));
    }

    @DisplayName("String Input Tests")
    @ParameterizedTest(name="Test #{index}: input={0}, expectedOut={1}")
    @MethodSource("paramTesting")
    void countTest(String input,int expectedOut){
        int count = CountWords.count(input);
        assertEquals(expectedOut,count);
    }
}