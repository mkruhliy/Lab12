import atm.Handler;
import atm.Handler20;
import atm.Handler5;
import atm.Handler50;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TestAtm {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    @Test
    public void testAtm(){
        Handler handler5 = new Handler5();
        Handler handler20 = new Handler20();
        Handler handler50 = new Handler50();
        handler50.setNext(handler20);
        handler20.setNext(handler5);
        handler50.process(125);
        Assertions.assertEquals("1 * 5\n" +
                "1 * 20\n" +
                "2 * 50\n", outContent.toString() );
    }


}