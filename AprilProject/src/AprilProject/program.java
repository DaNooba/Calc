package AprilProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class program {

    public static void start() {

        while (true) {
            try {
                var in = input("Eingabe", true);
                var out = input("Ausgabe", true);
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

    private static String input(String type) {
        System.out.printf("Geben sie eine %s Zahl ein: %n", type);
        return scn();
    }

    private static String input(String type, boolean set) {
        System.out.printf("Bitte wählen sie ihr %s Zahlensystem aus: %n", type);
        return scn();
    }

    private static void select(String cIn, String cOut) {

        String inNum;
        String res;

        var in = checking.simplify(cIn);
        var out = checking.simplify(cOut);

        var convert = in.concat(out);

        switch (convert) {
            case "22":      //done
                print(input("Binär"));
                break;
            case "210":     //done
                inNum = input("Binär");
                res = maths.BiDec(inNum);
                print(res);
                break;
            case "216":     //done
                inNum = input("Binär");
                res = maths.DecHex(maths.BiDec(inNum));
                print(res);
                break;
            case "102":     //done
                inNum = input("Dezimal");
                res = maths.DecBin(inNum);
                print(res);
                break;
            case "1010":    //done
                print(input("Dezimal"));
                break;
            case "1016":    //done
                inNum = input("Dezimal");
                res = maths.DecHex(inNum);
                print(res);
                break;
            case "162":     //done
                inNum = input("Hexadezimal");
                res = maths.DecBin(maths.HexDec(inNum));
                print(res);
                break;
            case "1610":    //done
                inNum = input("Hexadezimal");
                res = maths.HexDec(inNum);
                print(res);
                break;
            case "1616":    //done
                print(input("Hexadezimal"));

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