package persistent;

import model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkTeam(Team team, String name, Integer points, Integer numPlayer) {
        assertEquals(name, team.getName());
        assertEquals(points, team.getPoint());
        assertEquals(numPlayer, team.getPlayers().size());
    }

    protected void checkManager(Manager manager, String name, Integer coins) {
        assertEquals(name, manager.getName());
        assertEquals(coins, manager.getCoin());
    }

    protected void checkPlayer(Player player, String name, Integer stars, Integer managerCoin) {
        assertEquals(name, player.getName());
        assertEquals(stars, player.getStar());
        assertEquals(managerCoin, player.getM1().getCoin());
    }

    protected void checkFixture(Fixture fixture, Integer numTeams, Integer week) {
        assertEquals(numTeams, fixture.getPreTeams().size());
        assertEquals(week, fixture.getWeek());
    }

    protected void checkLeague(League league, String team1name, Integer numTeams) {
        league.sortTeams();
        assertEquals(team1name, league.getTeams().get(1).getName());
        assertEquals(numTeams, league.getTeams().size());
    }


}
