package com.infoshareacademy.zieloni.utils;

@SuppressWarnings({"squid:S106"})
public class ConsoleTools {

    private ConsoleTools() {
    }

    private static final String RED = "\u001B[31m";
    private static final String WHITE = "\u001B[0m";

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printAlert(String message) throws InterruptedException {
        System.out.println("\n" +
                RED +
                message +
                WHITE +
                "\n");
        Thread.sleep(3000);
    }
}
