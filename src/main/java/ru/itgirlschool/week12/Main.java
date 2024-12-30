package ru.itgirlschool.week12;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (FileWriter name1 = new FileWriter("data/nameCat1.txt")) {
            System.out.println("Введите имя кота:");
            String nameCat = scanner.nextLine();
            name1.write(nameCat);
        }

        StringBuilder nameCat1 = new StringBuilder();
        try (FileReader name2 = new FileReader("data/nameCat1.txt");
             FileWriter name3 = new FileWriter("data/nameCat2.txt")) {
            int inChar1 = name2.read();
            while (inChar1 != -1) {
                nameCat1.append((char) inChar1);
                inChar1 = name2.read();
            }
            name3.write(nameCat1.toString());
            System.out.println("В первый файл записано имя кота: " + nameCat1);
        }

        StringBuilder nameCat2 = new StringBuilder();
        try (FileReader name4 = new FileReader("data/nameCat2.txt")) {
            int inChar3 = name4.read();
            while (inChar3 != -1) {
                nameCat2.append((char) inChar3);
                inChar3 = name4.read();
            }
            System.out.println("Во второй файл скопировано имя кота: " + nameCat2);
        }
    }
}