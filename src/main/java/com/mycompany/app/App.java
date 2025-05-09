package com.mycompany.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 */
public class App {

    private static final String MESSAGE = "Hello World !!!";

    // 1. Hardcoded credentials (Security issue)
    private static final String PASSWORD = "admin123";

    public App() {}

    public static void main(String[] args) {
        // 2. Null pointer dereference risk (Reliability issue)
        String value = null;
        System.out.println(value.toLowerCase());

        // 3. Unclosed resource (Reliability issue)
        try {
            BufferedReader reader = new BufferedReader(new FileReader("config.txt"));
            String line = reader.readLine(); // Resource not closed
            System.out.println("Line: " + line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. System.out used in production code (Maintainability)
        System.out.println(MESSAGE);
    }

    // 5. Unused method (Maintainability)
    private void doNothing() {}

    // 6. Exposing internal data (Security issue)
    public String getPassword() {
        return PASSWORD;
    }

    public String getMessage() {
        return MESSAGE;
    }
}
