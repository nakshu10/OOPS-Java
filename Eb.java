import java.util.Scanner;

public class Eb {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the Consumer Number: ");
        int consumerNo = input.nextInt();
        input.nextLine(); 

        System.out.print("Enter the Consumer Name: ");
        String consumerName = input.nextLine();                      

        System.out.print("Enter the Previous Reading: ");
        int prevReading = input.nextInt();

        System.out.print("Enter the Current Reading: ");
        int currReading = input.nextInt();
        input.nextLine(); 

        System.out.print("Enter the type of EB connection (domestic or commercial): ");
        String connection = input.nextLine();

        int units = currReading - prevReading;
        double amount = 0;

       if (connection.equals("domestic")) {
            if (units <= 100) {
                amount = units * 1;
            } else if (units <= 200) {
                amount = 100 * 1 + (units - 100) * 2.5;
            } else if (units <= 500) {
                amount = 100 * 1 + 100 * 2.5 + (units - 200) * 4;
            } else {
                amount = 100 * 1 + 100 * 2.5 + 300 * 4 + (units - 500) * 6;
            }
        } else if (connection.equals("commercial")) {
            if (units <= 100) {
                amount = units * 2;
            } else if (units <= 200) {
                amount = 100 * 2 + (units - 100) * 4.5;
            } else if (units <= 500) {
                amount = 100 * 2 + 100 * 4.5 + (units - 200) * 6;
            } else {
                amount = 100 * 2 + 100 * 4.5 + 300 * 6 + (units - 500) * 7;
            }
        } else {
            System.out.println("Invalid connection type! Please give either 'domestic' or 'commercial'.");
            
            
        }
        System.out.println("\n--- Electricity Bill ---");
        System.out.println("Consumer No     : " + consumerNo);
        System.out.println("Consumer Name   : " + consumerName);
        System.out.println("Units Consumed  : " + units);
        System.out.println("Connection Type : " + connection);
        System.out.println("Total Bill (Rs.): " + amount);

        input.close();
    }
} 

