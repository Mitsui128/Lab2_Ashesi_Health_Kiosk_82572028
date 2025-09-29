
//Lab 2
// Eyram Awo Tenge
//Task 0
import java.util.Scanner;
public class HealthKiosk {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
        double bmi = 0.0;
        int metric = 0;
            System.out.print("Welcome to the Health Kiosk!\n");
//            Task 1
        System.out.print("Please enter a service code (P/L/T/C) ");
        char service_code = input.next().charAt(0); // This will help read a single character
        service_code = Character.toUpperCase(service_code); //Helping with case sensitivity
        switch (service_code) {

            case 'P':
                System.out.print("Go to:Pharmacy Desk");   //Options
                break;
            case 'L':
                System.out.print("Go to:Lab Desk");
                break;
            case 'T':
                System.out.print("Go to:Triage Desk");
                break;
            case 'C':
                System.out.print("Go to:Counselling Desk");
                break;
            default:
                System.out.print("Invalid input");
                break;
        }
//        Task 2

        System.out.print("\n Please enter a health metric: ");
        System.out.print("BM1: 1 ");
        System.out.print("Dosage Round-up: 2 ");
        System.out.print("Simple trig helper: 3 ");
        int health_metric = input.nextInt();
//           Option A

        if(health_metric == 1) {
            System.out.print("Please put in your weight(kg): ");
            double weight = input.nextDouble();
            System.out.print("Please put in your height(m): ");
            double height = input.nextDouble();

            bmi = weight / Math.pow(height, 2);
            bmi= Math.round(bmi * 10) / 10.0;    // Rounding specifications
            if (bmi < 18.5) {
                System.out.print("Underweight");
            } else if (bmi < 25) {
                System.out.print("Normal");
            }  else if (bmi < 30) {
                System.out.print("Overweight");
            }  else {
                System.out.print("Obese");
            }
        }
//            Option B
        else if (health_metric == 2) {
            System.out.print("Please put in your required dosage(mg): ");
            double dosage = input.nextDouble();

            double tablets = Math.ceil(dosage / 250.0);
            System.out.println("Number of tablets: " + (int) tablets);
        }
//           Option C
        else if (health_metric == 3) {
            System.out.print("Please put in an angle(degrees): ");
            double degrees = input.nextDouble();
//                     Radian conversions
            double radian=Math.toRadians(degrees);
            double sin_value= Math.round(Math.sin(radian) * 1000) / 1000.0;
            double cos_value= Math.round(Math.cos(radian) * 1000) / 1000.0;

            System.out.println("sin(" + degrees + ") = " + sin_value);
            System.out.println("cos(" + degrees + ") = " + cos_value);
        }else {
            System.out.print("Invalid input");
        }
//        Task 3

        char letter=(char)('A'+ (int)(Math.random()*26) );
//        Generating the numbers after the letters
        int number_1= 3 + (int)(Math.random()*7);
        int number_2= 3 + (int)(Math.random()*7);
        int number_3= 3 + (int)(Math.random()*7);
        int number_4= 3 + (int)(Math.random()*7);
//        Concatenating
        String short_ID = " " + letter+number_1+number_2+number_3+number_4;

        if (short_ID.length() != 5){
            System.out.println("Invalid length");
        } else if (!Character.isLetter(short_ID.charAt(0))){
            System.out.println("Invalid first Character");
        }else if (!(Character.isDigit(short_ID.charAt(1)) && Character.isDigit(short_ID.charAt(2)) && Character.isDigit(short_ID.charAt(3)) && Character.isDigit(short_ID.charAt(4)))){
            System.out.println("Invalid Character");
        }else{
            System.out.print("ID OK");
        }
//        Task 4
        System.out.print("Please enter your first name: ");
        String name = input.next();

        char base_code = Character.toUpperCase(name.charAt(0));
        char shifted_letter = (char)('A' + (base_code - 'A' + 2) % 26);

        String lastTwo = short_ID.substring(short_ID.length() - 2);
        String displayCode = shifted_letter + lastTwo + "-" + metric;
        System.out.println("Display Code: " + displayCode);
//        Task 5
        String service_Name=" ";
        switch (service_code){
            case 'P':
                service_Name = "PHARMACY";
                System.out.println("Summary: " + service_Name + " | ID=" + short_ID + " | Code=" + displayCode);
                break;
            case 'L':
                service_Name = "LAB";
                System.out.println("Summary: " + service_Name + " | ID=" + short_ID + " | Code=" + displayCode);
                break;
            case 'T':
                service_Name = "TRIAGE";
                System.out.println("Summary: " + service_Name + " | ID=" + short_ID + " | BMI=" + bmi + " | Code=" + displayCode);
                break;
            case 'C':
                service_Name = "COUNSELING";
                System.out.println("Summary: " + service_Name + " | ID=" + short_ID + " | Code=" + displayCode);
                break;
            default:
                System.out.println("Invalid input");
        }

        input.close();
    }
}
