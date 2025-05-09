package com.mycompany.app;

import java.io.*;
import java.util.Scanner;

public class App {

    private static final String MESSAGE = "Hello World !!!";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password123";
    public static String globalState = "ACTIVE";

    public App() {}

    public static void main(String[] args) {
        String data = null;
        if (data.length() > 0) {
            System.out.println("Length: " + data.length());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);

        int result = 10 / 0;

        if ("exit".equals(name)) {
            System.exit(1);
        }

        Thread thread = new Thread();
        thread.stop();

        try {
            FileReader file = new FileReader("C:\\temp\\data.txt");
            BufferedReader reader = new BufferedReader(file);
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Debug: App started");

        try {
            File temp = File.createTempFile("tempData", ".tmp");
            FileWriter writer = new FileWriter(temp);
            writer.write("sensitive data");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDbPassword() {
        return DB_PASS;
    }

    private void unusedMethod() {
        System.out.println("Never used");
    }

    public String getMessage() {
        return MESSAGE;
    }
}
