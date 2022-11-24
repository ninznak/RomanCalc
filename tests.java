import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class tests {

    public static String[] romanSimple = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public static String[] romanSimple2 = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
    public static String[] romanBig = new String[]{"", "C", "CC", "CC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M"};


    public static void main(String[] args) throws IOException {
        System.out.println("Введите ваше выражение. НАПРИМЕР: 55+789 (без пробелов) и нажмите ENTER");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String quest = reader.readLine();
        splitFunct(quest);
        System.out.println("Вашъ отъветъ: ");
        String[] splitted;
        char[] charToSearch = {'I', 'X', 'V', 'L', 'C', 'D'};
        char[] digitToSearch = {'1','2', '3', '4', '5', '6', '7', '8', '9', '0'};

        for(int i=0; i<quest.length(); i++) {
            char ch = quest.charAt(i);
            for(int j=0; j<charToSearch.length; j++) {
                if(charToSearch[j] == ch) {
                    System.out.println(charToSearch[j]);
                }
            }
        }


        if (quest.indexOf('+') > 0) {
            splitted = quest.split(Pattern.quote("+"));
            /*System.out.println(Arrays.toString(splitted));
            firstArg = Integer.parseInt(splitted[0]);
            secondArg = Integer.parseInt(splitted[1]); */
            System.out.println(summa(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1])));

        } else if (quest.indexOf('-') > 0) {
            splitted = quest.split(Pattern.quote("-"));
            System.out.println(difference(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1])));

        } else if (quest.indexOf('*') > 0) {
            splitted = quest.split(Pattern.quote("*"));
            System.out.println(multiply(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1])));

        } else if (quest.indexOf('/') > 0) {
            splitted = quest.split(Pattern.quote("/"));
            System.out.println(division(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1])));

        } else System.out.println("Такого действия не предусмотрено!!");
    }


    public static int summa(int firstArg, int secondArg) {
        int reply = firstArg + secondArg;
        System.out.println(romanConvert(reply));
        return reply;
    }


    public static int difference(int firstArg, int secondArg) {
        int reply = firstArg - secondArg;
        System.out.println(romanConvert(reply));
        return reply;
    }


    public static int multiply(int firstArg, int secondArg) {
        int reply = firstArg * secondArg;
        System.out.println(romanConvert(reply));
        return reply;
    }


    public static int division(int firstArg, int secondArg) {
        int reply = firstArg / secondArg;
        System.out.println(romanConvert(reply));
        return reply;
    }


    public static String[] splitFunct(String quest) {
        String[] splitted = new String[2];
        if (quest.indexOf('+') > 0) {
            splitted = quest.split(Pattern.quote("+"));
        } else if (quest.indexOf('-') > 0) {
            splitted = quest.split(Pattern.quote("-"));
        } else if (quest.indexOf('*') >0) {
            splitted = quest.split(Pattern.quote("*"));
        } else if (quest.indexOf('/') >0) {
            splitted = quest.split(Pattern.quote("/"));
        } else {
            System.out.println("Такого действия нет в данном калькуляторе! только +, -, *, / ");
        }
        return splitted;
    }
    public static String romanConvert(int reply) {
        int xx = reply;
        String returnRoman = "";

        if (xx > 0){
            if (xx > 0 && xx <= 10) {
                returnRoman = romanSimple[xx - 1];
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