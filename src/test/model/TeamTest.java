package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeamTest {
    Team t1;

    @BeforeEach
    public void setT1(){
        t1 = new Team();

    }

    @Test
    public void TestAddPlayer() {
        Player p1 = new Player();
        p1.setStar(1);
        Player p2 = new Player();
        p2.setStar(2);
        t1.addPlayer(p1);
        assertTrue(t1.getPlayers().contains(p1));
        t1.addPlayer(p2);
        assertTrue(t1.getPlayers().contains(p2));



    }

    @Test
    public void TestGetPlayers() {
        Player p1 = new Player();
        p1.setStar(1);
        Player p2 = new Player();
        p2.setStar(2);
        t1.addPlayer(p1);
        assertTrue(t1.getPlayers().contains(p1));
        t1.addPlayer(p2);
        assertTrue(t1.getPlayers().contains(p2));

    }

    @Test
    public void TestOverall() {
        Player p1 = new Player();
        p1.setStar(1);
        Player p2 = new Player();
        p2.setStar(2);
        Player p3 = new Player();
        p3.setStar(3);
        t1.addPlayer(p1);
        t1.addPlayer(p2);
        assertEquals(t1.overall(),1.5);
        t1.addPlayer(p3);
        assertEquals(t1.overall(),2);
    }



}
