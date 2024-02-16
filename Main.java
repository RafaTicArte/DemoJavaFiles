package DemoJavaFiles;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        String userText;
        String lineFile;

        System.out.println("Creando archivo mediante bytes...");
        try {
            FileOutputStream fileOut = new FileOutputStream("demo.txt");
            do {
                System.out.println("Introduce el texto a guardar (hasta que escribas 'exit'):");
                userText = keyboard.nextLine();
                fileOut.write(userText.getBytes());
                fileOut.write("\n".getBytes());
            } while (!userText.equals("exit"));
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Añadiendo al archivo mediante cadenas...");
        try {
            FileWriter fileWriter = new FileWriter("demo.txt", true);
            do {
                System.out.println("Introduce el texto a guardar (hasta que escribas 'exit'):");
                userText = keyboard.nextLine();
                fileWriter.write(userText + "\n");
            } while (!userText.equals("exit"));
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Añadiendo al archivo mediante buffer...");
        try {
            FileWriter fileWriter = new FileWriter("demo.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            do {
                System.out.println("Introduce el texto a guardar (hasta que escribas 'exit'):");
                userText = keyboard.nextLine();
                bufferedWriter.write(userText);
                bufferedWriter.newLine();
            } while (!userText.equals("exit"));
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Leyendo archivo mediante buffer...");
        try {
            FileInputStream fileIn = new FileInputStream("demo.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileIn));
            while ((lineFile = bufferedReader.readLine()) != null) {
                System.out.println(lineFile);
            }
            bufferedReader.close();
            fileIn.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
