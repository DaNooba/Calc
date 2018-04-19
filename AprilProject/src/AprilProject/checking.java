package AprilProject;

import java.util.InputMismatchException;

public class checking {

    protected static String simplify(String cIn) {

        var in = cIn.toLowerCase();

        if (bincheck(in)) {
            var sIn = "2";
            return sIn;
        }
        else if (deccheck(in)) {
            var sIn = "10";
            return sIn;
        }
        else if (hexcheck(in)) {
            var sIn = "16";
            return sIn;
        }
        else {
            throw new InputMismatchException();
        }

    }

    private static boolean bincheck(String in) {
        if (in.equals("2") || in.equals("bin") || in.equals("binary") || in.equals("binär")) {
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean deccheck(String in) {
        if (in.equals("10") || in.equals("dec") || in.equals("decimal") || in.equals("dezimal")) {
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean hexcheck(String in) {
        if (in.equals("16") || in.equals("hex") || in.equals("hexadecimal") || in.equals("hexadezimal")) {
            return true;
        }
        else {
            return false;
        }
    }

}
