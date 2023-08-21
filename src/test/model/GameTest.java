package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    Game g1;
    Game g2;
    Predefinedteams t1;
    Team t2;
    Predefinedteams t3;
    Player p1;
    Player p2;
    Player p3;
    Player p4;
    Manager m1;


    @BeforeEach
    public void setup() {
        t1 = new Predefinedteams("AFC" , "data/Teams/Arsenal.png");
        t3 = new Predefinedteams("EU", "data/Teams/Arsenal.png");
        m1 = new Manager();
        t2 = new Team(m1);
        t1.setOverall(4);
        p1 = new Player(m1,1);
        p2 = new Player(m1, 1);
        p3 = new Player(m1, 1);
        p4 = new Player(m1, 1);
        t2.addPlayer(p1);
        t2.addPlayer(p2);
        t2.addPlayer(p3);
        t2.addPlayer(p4);
        t3.setOverall(1);
        g1 = new Game(t1, t2);
        g2 = new Game(t3,t2);
    }

    @Test
     public void TestGeneralResult() {
        g1.generateResult();
        assertTrue((0 < (g1.getGoal1())) && (g1.getGoal1() <= 8));
        assertTrue((-1 < (g2.getGoal1())) && (g2.getGoal1() <= 3));

    }

    @Test
    public void TestUpdatePoints() {
        g1.setGoal1(2);
        g1.setGoal2(2);
        g1.updatePoints();
        assertEquals(t1.getPoint(),1);
        assertEquals(t2.getPoint(),1);
        g1.setGoal1(3);
        g1.setGoal2(1);
        g1.updatePoints();
        assertEquals(t1.getPoint(), 4);
        assertEquals(t2.getPoint(), 1);
        g1.setGoal1(1);
        g1.setGoal2(3);
        g1.updatePoints();
        assertEquals(t1.getPoint(),4);
        assertEquals(t2.getPoint(),4);
    }

    @Test
    public void TestUpdateCoins() {
        g1.setGoal1(1);
        g1.setGoal2(2);
        g1.updateCoins();
        assertEquals(t2.getManager().getCoin(), 100);
        g1.setGoal2(1);
        g1.setGoal1(3);
        g1.updateCoins();
        assertEquals(t2.getManager().getCoin(),125);
        g1.setGoal1(2);
        g1.setGoal2(2);
        g1.updateCoins();
        assertEquals(t2.getManager().getCoin(),175);
    }

    @Test
    public void GetT2() {
        assertEquals(g1.getT2().getName(), "Dream Team" );
        assertEquals(g1.getT1().getName(), "AFC" );
    }

    @Test
    public void GetGoal1() {
        g1.setGoal1(1);
        g1.setGoal2(2);
        assertEquals(g1.getGoal1(),1);
    }

    @Test
    public void GetGoal2() {
        g1.setGoal2(2);
        assertEquals(g1.getGoal2(),2);

    }





}
