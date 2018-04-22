package InterfaceProject;

import java.util.InputMismatchException;

public class checking implements Converter {

    @Override
    public void start() {

    }

    @Override
    public void select(String cIn, String cOut) {

    }

    public String simplify(String cIn) {

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

    @Override
    public String BiDec(String in) {
        return null;
    }

    @Override
    public String DecHex(String in) {
        return null;
    }

    @Override
    public String DecBin(String in) {
        return null;
    }

    @Override
    public String HexDec(String in) {
        return null;
    }

    private boolean bincheck(String in) {
        if (in.equals("2") || in.equals("bin") || in.equals("binary") || in.equals("binär")) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean deccheck(String in) {
        if (in.equals("10") || in.equals("dec") || in.equals("decimal") || in.equals("dezimal")) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean hexcheck(String in) {
        if (in.equals("16") || in.equals("hex") || in.equals("hexadecimal") || in.equals("hexadezimal")) {
            return true;
        }
        else {
            return false;
        }
    }

}
