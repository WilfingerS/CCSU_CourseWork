import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;



public class MinTest {
    private List<String> list; //Text fixture
    @BeforeEach
    void setUp(){
        list = new ArrayList<String>();
    }
    @AfterEach
    void tearDown(){
        list = null; // redudant for now
    }

    @Test
    void testForNullList(){
        list = null;
        assertThrows(NullPointerException.class,() ->Min.min(list));
    }

    @Test
    void testForSoloNullElement(){
        list.add(null);
        assertThrows(NullPointerException.class,() -> Min.min(list));
    }

    @Test
    void testForNullElement() {
        list.add("dog");
        list.add(null);
        list.add("cat");
        assertThrows(NullPointerException.class,() -> Min.min(list));
    }

    @Test
    void testEmptyList(){
        assertThrows(IllegalArgumentException.class,()->Min.min(list));
    }

    @Test
    @SuppressWarnings("unchecked")
    void testMutallyIncomparable(){
        List list = new ArrayList();
        list.add("cat");
        list.add("dog");
        list.add(1);
        assertThrows(ClassCastException.class,()->Min.min(list));
    }

    @Test
    void testSingleElement(){
        list.add("cat");
        Object obj = Min.min(list);
        assertEquals("cat",obj,"SingleElementList");
    }

    @Test
    void testDoubleElement(){
        list.add("dog");
        list.add("cat");
        Object obj = Min.min(list);
        assertEquals("cat",obj,"Double Element List");
    }

}
