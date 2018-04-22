package InterfaceProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class program implements Converter {

    public static void main(String[] args) {
        var p = new program();
        p.start();
    }

    public void start() {

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

    private String input(String type) {
        System.out.printf("Geben sie eine %s Zahl ein: %n", type);
        return scn();
    }

    private String input(String type, boolean set) {
        System.out.printf("Bitte wählen sie ihr %s Zahlensystem aus: %n", type);
        return scn();
    }

    public void select(String cIn, String cOut) {

        String inNum;
        String res;

        var in = simplify(cIn);
        var out = simplify(cOut);

        var convert = in.concat(out);

        switch (convert) {
            case "22":      //done
                print(input("Binär"));
                break;
            case "210":     //done
                inNum = input("Binär");
                res = BiDec(inNum);
                print(res);
                break;
            case "216":     //done
                inNum = input("Binär");
                res = DecHex(BiDec(inNum));
                print(res);
                break;
            case "102":     //done
                inNum = input("Dezimal");
                res = DecBin(inNum);
                print(res);
                break;
            case "1010":    //done
                print(input("Dezimal"));
                break;
            case "1016":    //done
                inNum = input("Dezimal");
                res = DecHex(inNum);
                print(res);
                break;
            case "162":     //done
                inNum = input("Hexadezimal");
                res = DecBin(HexDec(inNum));
                print(res);
                break;
            case "1610":    //done
                inNum = input("Hexadezimal");
                res = HexDec(inNum);
                print(res);
                break;
            case "1616":    //done
                print(input("Hexadezimal"));

        }

    }

    @Override
    public String simplify(String cIn) {
        return null;
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

    private void print(String num) {
        System.out.printf("Das Ergebnis ist: %s%n", num);
    }

    private void restart() {

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

    private String scn() {
        var sc = new Scanner(System.in);
        var in = sc.next();
        return in;
    }

}