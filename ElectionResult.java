import java.util.Scanner;

public class ElectionResult {
    public static void main(String[] args) {
        String[] candidates = getCandidates();
        int[] votes = getVotes(candidates);
        printResults(candidates, votes);
    }

    public static String[] getCandidates() {
        Scanner input = new Scanner(System.in);
        String[] candidates = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter candidate #" + (i+1) + "'s last name: ");
            candidates[i] = input.nextLine();
        }

        return candidates;
    }

    public static int[] getVotes(String[] candidates) {
        Scanner input = new Scanner(System.in);
        int[] votes = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter " + candidates[i] + "'s number of votes: ");
            votes[i] = input.nextInt();
            input.nextLine();
        }

        return votes;
    }

    public static void printResults(String[] candidates, int[] votes) {
        int totalVotes = 0 , winner = 0, loser = 0;

        for (int i = 0; i < 5; i++) {
            totalVotes += votes[i];
            if (votes[i] > votes[winner]) {
                winner = i;
            }
            if (votes[i] < votes[loser]) {
                loser = i;
            }
        }

        System.out.println("\nCandidate\tVotes\t% of Total Votes");
        for (int i = 0; i < 5; i++) {
            double percentage = ( votes[i] / totalVotes) * 100;
            System.out.printf("%-10s\t%-6d\t%7.2f%%\n", candidates[i], votes[i], percentage);
        }
        System.out.println("Total Votes: " + totalVotes);
        System.out.println("The winner is " + candidates[winner] + ".");
        System.out.println("The loser is " + candidates[loser] + ".");
    }
}