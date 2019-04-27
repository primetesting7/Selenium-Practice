import org.junit.*;

/**
 * Created by Jay Vaghani on 26/04/2019.
 */
public class JUnitIntroduction {

    @BeforeClass
    public static void setUpBeforeClass()  {
        System.out.println("Executed before class...");
    }

    @AfterClass
    public static void tearDownAfterClass()  {
        System.out.println("Executed after class...");
    }

    @Before
    public void setUp()  {
        System.out.println("Executed before...");
    }

    @After
    public void tearDown()  {
        System.out.println("Executed after...");
    }

    @Test
    public void test1() {
        System.out.println("Executed Test1...");
    }

    @Test
    public void test2() {
        System.out.println("Executed Test2...");
    }
}
