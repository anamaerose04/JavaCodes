import java.util.*;

public class AirplaneSeats {
    private static char[][] seats = new char[13][6];

   static {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 6; j++) {
                seats[i][j] = '*';
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\nWELCOME TO MEOW AIRLINES!");
            System.out.println("\t(1) Reserve a seat");
            System.out.println("\t(2) Print seating plan");
            System.out.println("\t(3) Exit");
            int choice = input.nextInt();
            if (choice == 1) {
                reserveSeat(input);
            } else if (choice == 2) {
                printSeatingPlan();
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void reserveSeat(Scanner input) {
        System.out.println("Please enter your ticket type:\n\t(1) for first class\n\t(2) for business class\n\t(3) for economy class");
        int ticketType = input.nextInt();
        int startRow = 0;
        int endRow = 0;
        if (ticketType == 1) {
            endRow = 1;
        } else if (ticketType == 2) {
            startRow = 2;
            endRow = 6;
        } else if (ticketType == 3) {
            startRow = 7;
            endRow = 12;
        } else {
            System.out.println("Invalid ticket type. Please try again.");
            return;
        }
        System.out.println("Please enter your desired seat (in the format of row number followed by seat letter, e.g. 3A):");
        int row = input.nextInt() - 1;
        char seat = input.next().charAt(0);
        if (row < startRow || row > endRow || seat < 'A' || seat > 'F') {
            System.out.println("Invalid seat selection. Please try again.");
            return;
        } else if (seats[row][seat - 'A'] == 'X') {
            System.out.println("That seat is already taken. Please select another seat.");
            return;
        }
        seats[row][seat - 'A'] = 'X';
        System.out.println("Seat reserved successfully.");
    }

    private static void printSeatingPlan() {
        System.out.println("  A B C  D E F");
        for (int i = 0; i < 13; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 6; j++) {
                if (seats[i][j] == 'X') {
                    System.out.print(seats[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}