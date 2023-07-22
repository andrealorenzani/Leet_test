package name.lorenzani.andrea.hackerrank.xyzreality.Test1;

import java.util.Locale;
import java.util.Scanner;


class Encrypter {
    static Validator validator = new Validator();

    static String getEncryptedName(String name) {
        if(validator.validate(name)) {
            return reverseAndUncapitalise(name);
        }
        else {
            throw new IllegalArgumentException("Try again with valid name");
        }
    }

    static String reverseAndUncapitalise(String input) {
        if(input.isEmpty()) return "";

        StringBuilder builder = new StringBuilder(input.length());
        for(int i=input.length()-1; i>=0; i--) {
            builder.append(input.charAt(i));
        }
        return builder.toString().toLowerCase(Locale.ROOT);
    }
}

class Validator {
    public boolean validate(String name) {
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);

            if (ch != ' ' && !(Character.isLowerCase(ch) || Character.isUpperCase(ch))) {
                return false;
            }
        }

        return true;
    }
}

public class Solution {
    private static final Scanner INPUT_READER = new Scanner(System.in);

    public static void main(String[] args) {
        String name = INPUT_READER.nextLine();

        try {
            System.out.println(Encrypter.getEncryptedName(name));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
