package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {
    Team t1;
    Manager m1;

    @BeforeEach
    public void setT1(){

        t1 = new Team(m1);
        m1 = new Manager();

    }

    @Test
    public void TestAddPlayer() {
        Manager m1;
        m1 = new Manager();
        Player p1 = new Player(m1,1);
        Player p2 = new Player(m1,2);
        t1.addPlayer(p1);
        assertTrue(t1.getPlayers().contains(p1));
        t1.addPlayer(p2);
        assertTrue(t1.getPlayers().contains(p2));



    }

    @Test
    public void TestGetPlayers() {
        Manager m1;
        m1 = new Manager();
        Player p1 = new Player(m1, 1);
        p1.setStar(1);
        Player p2 = new Player(m1, 2);
        t1.addPlayer(p1);
        assertTrue(t1.getPlayers().contains(p1));
        t1.addPlayer(p2);
        assertTrue(t1.getPlayers().contains(p2));

    }

    @Test
    public void TestOverall() {
        Manager m1;
        m1= new Manager();
        Player p1 = new Player(m1,1);
        Player p2 = new Player(m1, 2);
        Player p3 = new Player(m1, 3);
        t1.addPlayer(p1);
        t1.addPlayer(p2);
        assertEquals(t1.getOverall(),1.5);
        t1.addPlayer(p3);
        assertEquals(t1.getOverall(),2);
    }
    @Test
    public void TestUpdatePoints() {
        t1.updatePoints(5);
        assertEquals(t1.getPoint(),5);
        t1.updatePoints(3);
        assertEquals(t1.getPoint(), 8);
        t1.updatePoints(2);
        assertEquals(t1.getPoint(),10);
    }

    @Test
    public void TestMakePlayer() {
        m1.addCoin(100);
        Player p1= new Player(m1, 1);
        String name = "Nima";
        p1.setName("Nima");
        assertTrue(t1.makePlayer(name,m1));
        assertFalse(t1.makePlayer(name,m1));
    }


}
