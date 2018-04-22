package InterfaceProject;

interface Converter {
    void start();
    void select(String cIn, String cOut);
    String simplify(String cIn);
    String BiDec(String in);
    String DecHex(String in);
    String DecBin(String in);
    String HexDec(String in);
}