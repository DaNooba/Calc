package AprilProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {

        start();

    }

    private static void start() {

        while (true) {
            try {
                var in = input(true, "Eingabe");
                var out = input(true, "Ausgabe");
                select(in, out);
            } catch (Exception ex) {
                if (ex instanceof InputMismatchException) {
                    System.out.println("Bitte geben Sie eine gültigen Eingabe ein.");
                } else {
                    System.out.printf("An error occured: %s%n", ex);
                }
            }
        }

    }

    private static String input(boolean set, String type) {

        if (set) {
            System.out.printf("Bitte wählen sie ihr %s Zahlensystem aus: %n", type);
        }
        else {
            System.out.printf("Geben sie eine %s Zahl ein: %n", type);
        }

        var sc = new Scanner(System.in);
        var in = sc.next();

        return in;

    }

    private static void select(String cIn, String cOut) {

        var in = simplify(cIn);
        var out = simplify(cOut);

        switch (in) {
            case "2":
                
        }

    }

    private static String simplify(String in) {

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

    private static int BiDec(String in) {

        var res = 0;

        return res;

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
