package baseball;

import java.util.Scanner;

public class InputView {

    public static Integer getIntegerUserInput(String announce) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(announce);
        return scanner.nextInt();
    }

    public static String getStringUserInput(String announce) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(announce);
        return scanner.nextLine();
    }
}
