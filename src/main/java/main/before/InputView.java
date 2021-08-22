package main.before;

import java.util.Scanner;

public class InputView {

    public String getUserInputLine(String announce) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(announce);
        return scanner.nextLine();
    }

    public Integer getUserInputInteger(String announce) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(announce);
        return scanner.nextInt();
    }
}
