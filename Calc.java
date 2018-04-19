package AprilProject;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.StringBuilder;

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
            restart();
        }

    }

    private static String input(boolean set, String type) {

        if (set) {
            System.out.printf("Bitte wählen sie ihr %s Zahlensystem aus: %n", type);
        }
        else {
            System.out.printf("Geben sie eine %s Zahl ein: %n", type);
        }

        return scn();

    }

    private static void select(String cIn, String cOut) {

        var inNum = "";
        var res = "";

        var in = simplify(cIn);
        var out = simplify(cOut);

        var convert = in.concat(out);

        switch (convert) {
            case "22":
                print(input(false, "Binär"));
                break;
            case "210":
                inNum = input(false, "Binär");
                res = BiDec(inNum);
                print(res);
                break;
            case "216":
                inNum = input(false, "Binär");
                break;
            case "102":
                break;
            case "1010":
                print(input(false, "Dezimal"));
                break;
            case "1016":
                inNum = input(false, "Dezimal");
                res = DecHex(inNum);
                print(res);
                break;

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

    private static String BiDec(String in) {

        var bin = Integer.parseInt(in);
        var i = 0;
        var dec = 0;

        while(true){
            if(bin == 0){
                break;
            } else {
                var tmp = bin%10;
                dec += tmp*Math.pow(2, i);
                bin = bin/10;
                i++;
            }
        }

        var res = Integer.toString(dec);
        return res;

    }

    private static String DecHex(String in) {

        var dec = Integer.parseInt(in);

        char[] hexChart = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        var hb = 0x0F;
        var hex = new StringBuilder(8);
        hex.setLength(8);

        for (var i = 7; i >= 0; --i)
        {
            var j = dec & hb;
            hex.setCharAt(i, hexChart[j]);
            dec >>= 4;
        }

        return hex.toString();

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

    private static void print(String num) {
        System.out.printf("Das Ergebnis ist: %s%n", num);
    }

    private static void restart() {

        while (true) {
            System.out.println("Wollen Sie eine weitere Zahl eingeben? y/n");
            var in = scn();
            if (in.equals("y")) {
                return;
            }
            else if (in.equals("n")) {
                System.exit(0);
            }
            else {
                System.out.println("Bitte geben sie y für ja oder n zum beenden des Programms ein.");
            }

        }

    }

    private static String scn() {
        var sc = new Scanner(System.in);
        var in = sc.next();
        return in;
    }

}