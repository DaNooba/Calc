package InterfaceProject;

import java.util.InputMismatchException;

public class maths implements Converter {

    public String BiDec(String in) {

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

    public String DecHex(String in) {

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

    public String HexDec(String in) {
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

    public String DecBin(String in) {

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

    @Override
    public void start() {

    }

    @Override
    public void select(String cIn, String cOut) {

    }

    @Override
    public String simplify(String cIn) {
        return null;
    }
}
