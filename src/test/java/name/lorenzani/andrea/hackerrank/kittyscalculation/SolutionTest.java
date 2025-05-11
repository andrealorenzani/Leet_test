package name.lorenzani.andrea.hackerrank.kittyscalculation;

import junit.framework.TestCase;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SolutionTest extends TestCase {

    public void testEasy() {
        String newLine = System.getProperty("line.separator");
        String input = "7 3".concat(newLine)
                .concat("1 2").concat(newLine)
                .concat("1 3").concat(newLine)
                .concat("1 4").concat(newLine)
                .concat("3 5").concat(newLine)
                .concat("3 6").concat(newLine)
                .concat("3 7").concat(newLine)
                .concat("2").concat(newLine)
                .concat("2 4").concat(newLine)
                .concat("1").concat(newLine)
                .concat("5").concat(newLine)
                .concat("3").concat(newLine)
                .concat("2 4 5").concat(newLine);
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(input.getBytes())));
        Solution.main(new String[]{});
    }




}