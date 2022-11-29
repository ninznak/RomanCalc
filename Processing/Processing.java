package Processing;

public class Processing {

    public static int processing (String[] splittedArray) {

        int result = 0;

        if (splittedArray[1].equals("+")) {
            result = (Integer.parseInt(splittedArray[0])) + (Integer.parseInt(splittedArray[2]));
        } else if (splittedArray[1].equals("-")) {
            result = (Integer.parseInt(splittedArray[0])) - (Integer.parseInt(splittedArray[2]));
        } else if (splittedArray[1].equals("*")) {
            result = (Integer.parseInt(splittedArray[0])) * (Integer.parseInt(splittedArray[2]));
            return result;
        } else if (splittedArray[1].equals("/")) {
            result = (Integer.parseInt(splittedArray[0])) / (Integer.parseInt(splittedArray[2]));
            return result;
        }
        return result;
    }
}


