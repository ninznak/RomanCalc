import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;
import Processing.*;
import Converter.*;

public class tests {

    public static String[] romanSimple = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public static String[] arabic = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String question = reader.readLine();

        String[] splittedArray = splitFunction(question);

        if (splittedArray.length !=3){
            throw new ArithmeticException("неверное число аргументов");
        } else {
            System.out.println(arrayNormal(splittedArray));
        }
    }


    public static String arrayNormal (String[] args) {
        String[] arrayNormal;
        arrayNormal = args;
        String result = "";

        if (Arrays.asList(romanSimple).indexOf(args[0]) > 0 || Arrays.asList(romanSimple).indexOf(args[2]) > 0){
            arrayNormal[0] = String.valueOf(Arrays.asList(romanSimple).indexOf(args[0]));
            arrayNormal[2] = String.valueOf(Arrays.asList(romanSimple).indexOf(args[2]));
            result = Converter.convert(Processing.processing(arrayNormal));
        } else if (Arrays.asList(arabic).indexOf(args[0]) < 0 || Arrays.asList(arabic).indexOf(args[2]) < 0) {
            throw new ArithmeticException("Используйте числа от 1 до 10");
        } else {
            result = String.valueOf(Processing.processing(arrayNormal));
        }

        if ((Arrays.asList(arabic).indexOf(args[0]) > 0 && Arrays.asList(romanSimple).indexOf(args[2]) > 0)){
            throw new ArithmeticException("Используйте числа от 1 до 10");
        } else if ((Arrays.asList(arabic).indexOf(args[2]) > 0 && Arrays.asList(romanSimple).indexOf(args[0]) > 0)){
            throw new ArithmeticException("Используйте числа от 1 до 10");
        }
        return result;
    }


    public static String[] splitFunction(String question){
        String[] splittedArray = question.split(Pattern.quote(" "));
        return splittedArray;
    }
}
