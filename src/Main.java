
import services.impl.CricketGameplay;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("No. of players for each team: ");
        int numPlayers = scanner.nextInt();
        System.out.println(numPlayers);
        System.out.print("No. of overs: ");
        int numOvers = scanner.nextInt();
        System.out.println(numOvers);
        CricketGameplay gameplay = new CricketGameplay();
        gameplay.playMatch(numPlayers, numOvers);
        }
    }

