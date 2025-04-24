package org.example.test;

import org.example.pages.CarCheckPOM;
import org.example.pages.googlePOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCarReg {

    public static WebDriver driver = null;
    private static final String UK_REGEX = "\\b[A-Z]{2}\\d{2}\\s?[A-Z]{3}\\b";

    public static List<String> extractUKRegistrations(String filePath) {
        List<String> registrations = new ArrayList<>();
        Pattern pattern = Pattern.compile(UK_REGEX);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    // Optional: Format to standard space-separated form
                    String reg = matcher.group().replaceAll("([A-Z]{2}\\d{2})([A-Z]{3})", "$1 $2");
                    registrations.add(reg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return registrations;
    }

    public static void Carsearch(String[] cararry)
    {

      //  Arrays.stream(cararry).foreach(System.out::println);

        System.out.println("Inside CarSearch method");

      //  for (int i = 0; i < cararry.length(); i++) {
    //        System.out.println(cararry[i]);
     //   }


        driver = new ChromeDriver();
        driver.get("https://car-checking.com/");
        driver.manage().window().maximize();

        CarCheckPOM cpom = new CarCheckPOM(driver);
     //   gpom.btclick();
      //  gpom.gsearch("Automation");

        //  driver.quit();
       // driver.close();
    }


    public static void main(String[] args) {
        File file = new File("C:\\Users\\ebomm\\IdentityE2E\\car_input.txt");
        List<String> numbers = extractUKRegistrations(String.valueOf(file));

        System.out.println("Found UK registration numbers:");

        driver = new ChromeDriver();
        driver.get("https://car-checking.com/");
        driver.manage().window().maximize();

        CarCheckPOM cpom = new CarCheckPOM(driver);

        for (int i = 0; i < numbers.size(); i++) {
            String reg = numbers.get(i);
            System.out.println("car reg no " + i + ": " + reg);

           cpom.carsearch(reg);
           cpom.btclick();
        //    cpom.cardetails();


                    }



    }
}