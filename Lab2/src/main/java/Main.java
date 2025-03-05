import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static final String PATH_TO_INPUT = "src/main/resources/";

    public static void main(String[] args) {
        if (args.length > 1) {
            System.err.println("Too many arguments");
        }

        // Opening config.properties
        InputStream fis;
        Properties properties;
        try {
            fis = Main.class.getResourceAsStream("config.properties");
            properties = new Properties();
            try {
                properties.load(fis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        // Creating Reader
        BufferedReader reader;
        try {
            if (args.length == 0) {
                reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            }
            else {
                reader = new BufferedReader(new FileReader(PATH_TO_INPUT + args[0]));
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }

        Calculator calculator = new Calculator();
        calculator.executeCommands(properties, reader);
    }
}