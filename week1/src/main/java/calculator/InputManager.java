package calculator;

import java.util.Scanner;

public class InputManager {
    public String inputStr() {
        System.out.println(Constant.INPUT_MESSAGE);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
