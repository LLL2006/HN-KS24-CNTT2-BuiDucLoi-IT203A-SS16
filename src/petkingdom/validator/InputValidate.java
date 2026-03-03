package petkingdom.validator;

import java.util.Scanner;

public class InputValidate {
    public static String getString(Scanner sc){
        String input = sc.nextLine();
        if(input.trim().isEmpty()){
            return null;
        }
        return input;

    }
}
