package services.impl;

import enums.PlayerStatus;
import models.Player;
import models.Team;
import services.Dashboard;

public class CricketDashboard implements Dashboard {
    @Override
    public void printScorecard(Team team, int over) {
        System.out.println("Scorecard for " + team.getTeamName() + ":");
        System.out.println("PlayerName Score 4s 6s Balls");
        for (int i = 0; i < team.getTotalPlayers(); i++) {
            Player player = team.getPlayer(i);
            System.out.println(player.getName() + (player.getStatus().equals(PlayerStatus.PLAYING) ? "* " : " ") + player.getRunScored() + " " + player.getFours() + " " + player.getSixes() + " " + player.getBallsPlayed());
        }
        System.out.println("Total: " + team.getTotalRuns() + "/" + team.getWicketsDown());
        System.out.println("Overs: " + over);
    }

    @Override
    public void printResult(Team teamA, Team teamB) {
        if(teamA.isBattedFirst()) {
            calculateResult(teamA, teamB);
        }else if(teamB.isBattedFirst()) {
            calculateResult(teamB, teamA);
        }
    }

    private void calculateResult(Team teamA, Team teamB) {
        if(teamA.getTotalRuns() > teamB.getTotalRuns()) {
            System.out.println(teamA.getTeamName() + " won by " + (teamA.getTotalRuns() - teamB.getTotalRuns()));
        } else if (teamA.getTotalRuns() < teamB.getTotalRuns()) {
            System.out.println(teamB.getTeamName() + " won by " + (teamB.getTotalPlayers() - teamB.getWicketsDown()));
        } else {
            System.out.println("Match Tied");
        }
    }
}
