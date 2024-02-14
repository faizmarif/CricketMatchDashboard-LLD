package services;

import models.Team;

public interface Dashboard {
    void printScorecard(Team team, int over);

    void printResult(Team teamA, Team teamB);

}
