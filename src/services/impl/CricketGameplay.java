package services.impl;

import enums.PlayerStatus;
import models.Player;
import models.Team;
import services.Gameplay;

import java.util.Scanner;

public class CricketGameplay implements Gameplay {
    private static final Scanner scanner = new Scanner(System.in);
    private Team teamA;
    private Team teamB;
    private Team battingTeam;
    private Team fieldingTeam;
    private int numPlayers;
    private int numOvers;
    private Player striker;
    private Player nonStriker;
    private CricketCalc cricketCalc;
    private CricketDashboard dashboard;
    private int inningNum;

    public CricketGameplay() {
        this.cricketCalc = new CricketCalc();
        this.dashboard = new CricketDashboard();
    }

    @Override
    public void playMatch(int numPlayers, int numOvers) {
        this.numPlayers = numPlayers;
        this.numOvers = numOvers;
        teamA = new Team("Team-A", numPlayers);
        teamA.setBattedFirst();
        teamB = new Team("Team-B", numPlayers);
        battingTeam = teamA;
        fieldingTeam = teamB;
        inningNum = 1;
        playInning();
        battingTeam = teamB;
        fieldingTeam = teamA;
        inningNum = 2;
        playInning();
        dashboard.printResult(teamA, teamB);

    }

    private void playInning() {
        System.out.println("Batting Order for " + battingTeam.getTeamName());

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name of player: ");
            String playerName = scanner.next();
            Player player = new Player(playerName);
            player.setPlayerTeam(battingTeam);
            player.setStatus(PlayerStatus.STILL_TO_PLAY);
            battingTeam.addPlayer(player);
        }
        striker = battingTeam.getNextPlayer();
        striker.setStatus(PlayerStatus.PLAYING);
        nonStriker = battingTeam.getNextPlayer();
        nonStriker.setStatus(PlayerStatus.PLAYING);

        for (int over = 1; over <= numOvers; over++) {
            System.out.println("Over " + over);
            if(!playOver()) {
                dashboard.printScorecard(battingTeam, over);
                return;
            }
            dashboard.printScorecard(battingTeam, over);
            swapStriker();
        }
    }

    private boolean playOver() {
        for (int ball = 1; ball <= 6; ball++) {
            if(scanner.hasNextInt()) {
                int run = scanner.nextInt();
                cricketCalc.runScored(run, striker);
                if(inningNum == 2 && run > fieldingTeam.getTotalRuns()) {
                    return false;
                }
                if(run%2 != 0)
                    swapStriker();
            } else if(scanner.hasNext()) {
                String thisBall = scanner.next();
                if(thisBall.equalsIgnoreCase("W")) {
                    striker = cricketCalc.wicketDown(striker);
                    if(striker == null)
                        return false;
                }
                if(thisBall.equalsIgnoreCase("Wd")) {
                    cricketCalc.thrownWide(battingTeam);
                    ball--;
                }
            }
        }
        return true;
    }

    private void swapStriker() {
        Player temp = striker;
        striker = nonStriker;
        nonStriker = temp;
    }
}

