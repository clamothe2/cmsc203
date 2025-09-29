package assignment2;

import java.util.Scanner;

public class PatientDriverApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Patient's First Name: ");
        String firstName = input.nextLine();
        System.out.print("Enter Patient's Middle Name: ");
        String middleName = input.nextLine();
        System.out.print("Enter Patient's Last Name: ");
        String lastName = input.nextLine();
        System.out.print("Enter Patient's Address: ");
        String address = input.nextLine();
        System.out.print("Enter City: ");
        String city = input.nextLine();
        System.out.print("Enter State: ");
        String state = input.nextLine();
        System.out.print("Enter ZIP Code: ");
        String zip = input.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = input.nextLine();
        System.out.print("Enter Emergency Contact Name: ");
        String emergencyName = input.nextLine();
        System.out.print("Enter Emergency Contact Phone: ");
        String emergencyPhone = input.nextLine();

        Patient patient = new Patient(firstName, middleName, lastName, address, city, state, zip, phone, emergencyName, emergencyPhone);

        System.out.println("\nEnter Procedure 1 Details:");
        Procedure proc1 = getProcedure(input, true);

        System.out.println("\nEnter Procedure 2 Details:");
        Procedure proc2 = getProcedure(input, false);

        System.out.println("\nEnter Procedure 3 Details:");
        Procedure proc3 = new Procedure();
        System.out.print("Name: ");
        proc3.setName(input.nextLine());
        System.out.print("Date: ");
        proc3.setDate(input.nextLine());
        System.out.print("Practitioner: ");
        proc3.setPractitioner(input.nextLine());
        System.out.print("Charge: ");
        proc3.setCharge(Double.parseDouble(input.nextLine()));

        System.out.println("\n" + patient);
        System.out.println("\n" + proc1);
        System.out.println("\n" + proc2);
        System.out.println("\n" + proc3);

        double total = calculateTotalCharges(proc1, proc2, proc3);
        System.out.printf("\nTotal Charges: $%,.2f\n", total);

        System.out.println("\nThe program was developed by a Student: Carlos Lamothe 07/27/24");
    }

    public static Procedure getProcedure(Scanner input, boolean fullConstructor) {
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Date: ");
        String date = input.nextLine();

        if (fullConstructor) {
            System.out.print("Practitioner: ");
            String practitioner = input.nextLine();
            System.out.print("Charge: ");
            double charge = Double.parseDouble(input.nextLine());
            return new Procedure(name, date, practitioner, charge);
        } else {
            Procedure proc = new Procedure(name, date);
            System.out.print("Practitioner: ");
            proc.setPractitioner(input.nextLine());
            System.out.print("Charge: ");
            proc.setCharge(Double.parseDouble(input.nextLine()));
            return proc;
        }
    }

    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getCharge() + p2.getCharge() + p3.getCharge();
    }
}