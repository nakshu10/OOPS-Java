import java.util.Scanner;

// Base Class
class Employee {
    String empName, empId, address, mailId, mobileNo;
    double basicPay, da, hra, pf, staffClub, grossPay, netPay;

    Employee(Scanner sc) {
        System.out.print("Enter Employee Name: ");
        empName = sc.nextLine();
        System.out.print("Enter Employee ID: ");
        empId = sc.nextLine();
        System.out.print("Enter Address: ");
        address = sc.nextLine();
        System.out.print("Enter Mail ID: ");
        mailId = sc.nextLine();
        System.out.print("Enter Mobile Number: ");
        mobileNo = sc.nextLine();
        System.out.print("Enter Basic Pay: ");
        basicPay = sc.nextDouble();
    }

    void calculateSalary(double daPercent, double hraPercent, double pfPercent, double staffClubPercent) {
        da = (daPercent / 100) * basicPay;
        hra = (hraPercent / 100) * basicPay;
        pf = (pfPercent / 100) * basicPay;
        staffClub = (staffClubPercent / 100) * basicPay;

        grossPay = basicPay + da + hra;
        netPay = grossPay - pf - staffClub;
    }

    void displayPayslip() {
        System.out.println("\n--- Pay Slip ---");
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee ID: " + empId);
        System.out.println("Address: " + address);
        System.out.println("Mail ID: " + mailId);
        System.out.println("Mobile Number: " + mobileNo);
        System.out.println("Basic Pay: " + basicPay);
        System.out.println("DA: " + da);
        System.out.println("HRA: " + hra);
        System.out.println("PF: " + pf);
        System.out.println("Staff Club Fund: " + staffClub);
        System.out.println("Gross Pay: " + grossPay);
        System.out.println("Net Pay: " + netPay);
    }
}

// Derived classes
class Programmer extends Employee {
    Programmer(Scanner sc) {
        super(sc);
        calculateSalary(97, 10, 12, 1);
    }
}

class AssistantProfessor extends Employee {
    AssistantProfessor(Scanner sc) {
        super(sc);
        calculateSalary(110, 20, 12, 1);
    }
}

class AssociateProfessor extends Employee {
    AssociateProfessor(Scanner sc) {
        super(sc);
        calculateSalary(130, 30, 12, 10);
    }
}

class Professor extends Employee {
    Professor(Scanner sc) {
        super(sc);
        calculateSalary(140, 40, 12, 15);
    }
}

// Main class
public class EmployeeSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Designation:");
        System.out.println("1. Programmer");
        System.out.println("2. Assistant Professor");
        System.out.println("3. Associate Professor");
        System.out.println("4. Professor");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        Employee emp = null;
        switch (choice) {
            case 1:
                emp = new Programmer(sc);
                break;
            case 2:
                emp = new AssistantProfessor(sc);
                break;
            case 3:
                emp = new AssociateProfessor(sc);
                break;
            case 4:
                emp = new Professor(sc);
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }

        emp.displayPayslip();
        sc.close();
    }
}

