package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FixtureTest {
    Team t1;
    Predefinedteams t2;
    Predefinedteams t3;
    Predefinedteams t4;
    Predefinedteams t5;
    Manager m1;
    Fixture f1;

    @BeforeEach
    public void setup() {
        m1 = new Manager();
        t1 = new Team(m1);
        t2 = new Predefinedteams("AFC");
        t2.setOverall(1);
        t3 = new Predefinedteams("EU");
        t4 = new Predefinedteams("Milan");
        t5 = new Predefinedteams("aston Villa");
        f1 = new Fixture(t1);
    }

    @Test
    public void TestAddPreDTeams() {
        f1.addPreDTeams(t2);
        f1.addPreDTeams(t3);
        assertTrue(f1.getPreTeams().contains(t2));
        assertTrue(f1.getPreTeams().contains(t3));
        f1.addPreDTeams(t4);
        assertTrue(f1.getPreTeams().contains(t4));
        f1.addPreDTeams(t5);
        assertTrue(f1.getPreTeams().contains(t5));
    }

    @Test
    public void TestSetGame() {
        f1.addPreDTeams(t2);
        f1.addPreDTeams(t3);
        f1.addPreDTeams(t4);
        f1.addPreDTeams(t5);
        f1.setGames();
        assertEquals(f1.getGames().size(), 4);
        assertEquals(f1.getGames().get(3).getT1(),t5);
        assertEquals(f1.getGames().get(2).getT1(),t4);
        assertEquals(f1.getGames().get(1).getT1(),t3);
        assertEquals(f1.getGames().get(0).getT1(),t2);
    }
}
