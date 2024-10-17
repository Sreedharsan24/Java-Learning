import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! \n Enter Car Brand you're Looking for! ");
        String brand = scanner.nextLine();
        System.out.println("Enter Car Model");
        String model = scanner.nextLine();
        System.out.println("Enter Car Colour");
        String color = scanner.nextLine();
        System.out.println("Enter Car Price");
        double price = scanner.nextDouble();

        String Json = convertToJson(brand, model, color, price);

        try(
                FileWriter writer = new FileWriter("Car.json");
                BufferedReader bf = new BufferedReader(new FileReader("Car.json"))

        ) {
            writer.write(Json);
            writer.flush();
            System.out.println("Writing JSON File Successful");

            String line;
            System.out.println("Reading JSON from file:");
            while((line = bf.readLine()) != null){
                System.out.println(line);
            }
            System.out.println("Reading JSON File Successful");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static String convertToJson(String brand, String model, String color, double price) {
        return "{\n" +
                "  \"brand\": \"" + brand + "\",\n" +
                "  \"model\": \"" + model + "\",\n" +
                "  \"color\": \"" + color + "\",\n" +
                "  \"price\": " + price + "\n" +
                "}";
    }
}
