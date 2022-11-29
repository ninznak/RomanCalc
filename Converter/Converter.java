package Converter;

public class Converter {

    public static String[] romanSimple = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public static String[] romanSimple2 = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
    public static String[] romanBig = new String[]{"", "C", "CC", "CC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M"};

    public static String convert(int xx) {
        String returnRoman = "";

        if (xx > 0){
            if (xx > 0 && xx <= 10) {
                returnRoman = romanSimple[xx];
            } else if ((xx > 10 && xx < 100)) {
                returnRoman = romanSimple2[xx / 10] + romanSimple[xx % 10];
            } else if (xx == 100 || xx > 100 && xx <= 1000) {
                returnRoman = romanBig[xx / 100] + romanSimple2[(xx % 100) / 10] + romanSimple[xx % 10];
            }
        } else {
            throw new ArithmeticException("throws Exception //т.к. в римской системе нет отрицательных чисел");
        }
        return returnRoman;
    }
}
