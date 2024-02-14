package models;

import enums.PlayerStatus;

import java.util.UUID;

public class Player {
    private String name;
    private final String playerId;
    private int runScored;
    private PlayerStatus status;
    private int fours;
    private int sixes;
    private int ballsPlayed;
    private Team playerTeam;

    public Player(String name) {
        this.name = name;
        this.playerId = UUID.randomUUID().toString();
        this.runScored = 0;
        this.fours = 0;
        this.sixes = 0;
        this.ballsPlayed = 0;
        this.status = PlayerStatus.STILL_TO_PLAY;
    }

    public String getName() {
        return name;
    }

    public String getPlayerId() {
        return playerId;
    }

    public int getRunScored() {
        return runScored;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public int getFours() {
        return fours;
    }

    public int getSixes() {
        return sixes;
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public Team getPlayerTeam() {
        return playerTeam;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public Player addRuns(int runScored) {
        this.runScored += runScored;
        return this;
    }

    public Player setStatus(PlayerStatus status) {
        this.status = status;
        return this;
    }

    public Player addFours() {
        this.fours++;
        return this;
    }

    public Player addSixes() {
        this.sixes++;
        return this;
    }

    public Player addBallPlayed() {
        this.ballsPlayed++;
        return this;
    }

    public Player setPlayerTeam(Team playerTeam) {
        this.playerTeam = playerTeam;
        return this;
    }
}
