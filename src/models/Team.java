package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Team {
    private String teamName;
    private final String teamId;
    private int totalPlayers;
    private List<Player> playerList;
    private int totalRuns;
    private int wicketsDown;
    private boolean battedFirst;
    private int nextPlayerNum;

    public Team(String teamName, int totalPlayers) {
        this.teamName = teamName;
        this.totalPlayers = totalPlayers;
        this.teamId = UUID.randomUUID().toString();
        this.playerList = new ArrayList<>(totalPlayers);
        this.totalRuns = 0;
        this.wicketsDown = 0;
        this.battedFirst = false;
        this.nextPlayerNum = 0;
    }

    public Team() {
        this.teamId = UUID.randomUUID().toString();
        this.totalRuns = 0;
        this.wicketsDown = 0;
        this.nextPlayerNum = 0;

    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamId() {
        return teamId;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getWicketsDown() {
        return wicketsDown;
    }

    public Player getPlayer(int playerBattingNumber) {
        return playerList.get(playerBattingNumber);
    }

    public Player getNextPlayer() {
        return playerList.get(nextPlayerNum++);
    }

    public boolean isBattedFirst() {
        return battedFirst;
    }

    public Team setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public Team setTotalPlayers(int totalPlayers) {
        this.totalPlayers = totalPlayers;
        this.playerList = new ArrayList<>(totalPlayers);
        return this;
    }

    public Team addPlayer(Player player) {
        this.playerList.add(player);
        return this;
    }

    public Team setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
        return this;
    }

    public Team addRun(int run) {
        this.totalRuns += run;
        return this;
    }

    public Team setWicketsDown(int wicketsDown) {
        this.wicketsDown = wicketsDown;
        return this;
    }

    public Team addWicket() {
        this.wicketsDown += 1;
        return this;
    }

    public Team setBattedFirst() {
        this.battedFirst = true;
        return this;
    }
}
