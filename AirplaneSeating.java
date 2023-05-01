import java.util.Scanner;

public class AirplaneSeating {

    private static char[][] seats = new char[13][6];

    public static void main(String[] args) {
        initializeSeats();
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Please select an option:");
            System.out.println("1. Reserve a seat");
            System.out.println("2. Print seating plan");
            System.out.println("3. Exit");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    reserveSeat(input);
                    break;
                case 2:
                    printSeatingPlan();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);
    }

    private static void initializeSeats() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 6; j++) {
                seats[i][j] = '.';
            }
        }
    }

    private static void reserveSeat(Scanner input) {
        System.out.println("Please enter your ticket type (1 for first class, 2 for business class, 3 for economy class):");
        int ticketType = input.nextInt();
        int startRow, endRow;
        if (ticketType == 1) {
            startRow = 0;
            endRow = 1;
        } else if (ticketType == 2) {
            startRow = 2;
            endRow = 6;
        } else {
            startRow = 7;
            endRow = 12;
        }
        System.out.println("Please enter your desired seat (in the format of row number followed by seat letter, e.g. 3A):");
        int row = input.nextInt() - 1;
        char seat = input.next().charAt(0);
        if (row < startRow || row > endRow || seat < 'A' || seat > 'F') {
            System.out.println("Invalid seat selection. Please try again.");
        } else if (seats[row][seat - 'A'] == 'X') {
            System.out.println("That seat is already taken. Please select another seat.");
        } else {
            seats[row][seat - 'A'] = 'X';
            System.out.println("Seat reserved successfully.");
        }
    }

    private static void printSeatingPlan() {
        System.out.println("   A B C  D E F");
        for (int i = 0; i < 13; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 6; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

}