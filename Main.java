package srcs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CustomerService service = new CustomerService();

        while (true) {
            System.out.println("\n--- Shopping Mall Customer Service ---");
            System.out.println("1. Create Ticket");
            System.out.println("2. View Tickets");
            System.out.println("3. Assign Staff");
            System.out.println("4. Close Ticket");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Issue Type: ");
                    String issue = sc.nextLine();

                    System.out.print("Description: ");
                    String desc = sc.nextLine();

                    service.createTicket(name, issue, desc);
                    break;

                case 2:
                    service.viewTickets();
                    break;

                case 3:
                    System.out.print("Enter Ticket ID: ");
                    int tid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Assign Staff Name: ");
                    String staff = sc.nextLine();

                    service.assignStaff(tid, staff);
                    break;

                case 4:
                    System.out.print("Enter Ticket ID: ");
                    int closeId = sc.nextInt();
                    service.closeTicket(closeId);
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
