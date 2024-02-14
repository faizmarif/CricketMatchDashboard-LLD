package services;

import models.Player;
import models.Team;

public interface Calculations {
    void runScored(int run, Player player);
    Player wicketDown(Player player);
    void thrownWide(Team battingTeam);
}
