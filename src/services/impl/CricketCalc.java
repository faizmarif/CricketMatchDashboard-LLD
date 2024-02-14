package services.impl;

import enums.PlayerStatus;
import models.Player;
import models.Team;
import services.Calculations;

public class CricketCalc implements Calculations {
    @Override
    public void runScored(int run, Player player) {
        Team team = player.getPlayerTeam();
        player.addRuns(run);
        player.addBallPlayed();
        team.addRun(run);
        if(run == 4)
            player.addFours();
        if(run == 6)
            player.addSixes();
    }

    @Override
    public Player wicketDown(Player player) {
        Team team = player.getPlayerTeam();
        team.addWicket();
        player.setStatus(PlayerStatus.OUT);
        player.addBallPlayed();
        Player nextPlayer = null;
        if(team.getWicketsDown() < team.getTotalPlayers()-1) {
            nextPlayer = team.getNextPlayer();
            nextPlayer.setStatus(PlayerStatus.PLAYING);
        }
        return nextPlayer;
    }

    @Override
    public void thrownWide(Team team) {
        team.addRun(1);
    }
}
