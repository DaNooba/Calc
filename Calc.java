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

        String inNum;
        String res;

        var in = simplify(cIn);
        var out = simplify(cOut);

        var convert = in.concat(out);

        switch (convert) {
            case "22":      //done
                print(input(false, "Binär"));
                break;
            case "210":     //done
                inNum = input(false, "Binär");
                res = BiDec(inNum);
                print(res);
                break;
            case "216":     //done
                inNum = input(false, "Binär");
                res = DecHex(BiDec(inNum));
                print(res);
                break;
            case "102":     //done
                inNum = input(false, "Dezimal");
                res = DecBin(inNum);
                print(res);
                break;
            case "1010":    //done
                print(input(false, "Dezimal"));
                break;
            case "1016":    //done
                inNum = input(false, "Dezimal");
                res = DecHex(inNum);
                print(res);
                break;
            case "162":     //done
                inNum = input(false, "Hexadezimal");
                res = DecBin(HexDec(inNum));
                print(res);
                break;
            case "1610":    //done
                inNum = input(false, "Hexadezimal");
                res = HexDec(inNum);
                print(res);
                break;
            case "1616":    //done
                print(input(false, "Hexadezimal"));

        }

    }

    private static String simplify(String cIn) {

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

    private static String BiDec(String in) {

        var bin = Integer.parseInt(in);
        var i = 0;
        var dec = 0;

        for (var j = 0; j < in.length(); j++) {
            if (in.charAt(j) != '1' && in.charAt(j) != '0') {
                throw new InputMismatchException();
            }
        }

        while(true){
            if(bin == 0){
                break;
            }
            else {
                var tmp = bin%10;
                dec += tmp * Math.pow(2, i);
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
        var hex = new StringBuilder(16);
        hex.setLength(16);
        var zero = true;

        for (var i = 15; i >= 0; --i)
        {
            var j = dec & hb;
            hex.setCharAt(i, hexChart[j]);
            dec >>= 4;
        }

        var tmp = hex.toString();

        for (var i = 0; i<tmp.length() && zero; i++)
        {
            if (tmp.charAt(i)!='0')
                zero = false;
        }

        if (zero) {
            return "0";
        }
        else {
            while (tmp.indexOf("0") == 0)
                tmp = tmp.substring(1);
            return tmp;
        }

    }

    private static String HexDec(String in) {
        var digits = "0123456789ABCDEF";
        in = in.toUpperCase();

        for (var j = 0; j < in.length(); j++) {
            if (!digits.contains(Character.toString(in.charAt(j)))) {
                throw new InputMismatchException();
            }
        }

        var tmp = 0;

        for (var i = 0; i < in.length(); i++) {
            var c = in.charAt(i);
            var d = digits.indexOf(c);
            tmp = 16 * tmp + d;
        }

        var dec = Integer.toString(tmp);

        return dec;
    }

    private static String DecBin(String in) {

        var dec = Integer.parseInt(in);
        var res = "";
        int tmp;

        int bin[] = new int[32];
        var i = 0;
        while(dec > 0){
            bin[i++] = dec%2;
            dec = dec/2;
        }
        for(var j = i-1; j >= 0; j--){
            tmp = bin[j];
            res = res.concat(Integer.toString(tmp));
        }

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

    private static void print(String num) {
        System.out.printf("Das Ergebnis ist: %s%n", num);
    }

    private static void restart() {

        while (true) {
            System.out.println("Wollen Sie eine weitere Zahl eingeben? y/n");
            var in = scn().toLowerCase();
            if (in.equals("y")) {
                return;
            }
            else if (in.equals("n")) {
                System.exit(0);
            }
            else {
                System.out.println("Bitte geben sie y für das weitere ausführen oder n zum beenden des Programms ein.");
            }

        }

    }

    private static String scn() {
        var sc = new Scanner(System.in);
        var in = sc.next();
        return in;
    }

}
