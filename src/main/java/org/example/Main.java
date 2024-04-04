package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        String newCountryCode = "+1";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            FileWriter writer = new FileWriter(outputFile);

            String line;
            while ((line = reader.readLine()) != null) {
                String modifiedLine = modifyPhoneNumbers(line, newCountryCode);
                writer.write(modifiedLine + "\n");
            }

            reader.close();
            writer.close();
            System.out.println("Текст успешно обработан и записан в файл: " + outputFile);
        } catch (IOException e) {
            System.out.println("Ошибка при обработке файла: " + e.getMessage());
        }
    }

    public static String modifyPhoneNumbers(String text, String countryCode) {
        String regex = "( \\+?\\d{0,3}[-.\\s]?\\d{3}[-.\\s]?\\d{3}[-.\\s]?\\d{2}[-.\\s]?\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String phoneNumber = matcher.group();

            phoneNumber = phoneNumber.replaceAll("[\\s\\-\\(]", "");
            if (phoneNumber.length() < 10)
                throw new RuntimeException("Некорректная длина номера");
            phoneNumber = countryCode + phoneNumber.substring(phoneNumber.length() - 10);
            phoneNumber = phoneNumber.replaceAll("(\\d{1,3})(\\d{3})(\\d{3})(\\d{2})(\\d{2})", "$1 ($2) $3-$4-$5");
            matcher.appendReplacement(stringBuffer, " " + phoneNumber);
        }

        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}