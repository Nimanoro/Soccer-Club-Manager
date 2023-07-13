package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    Player p1;

    @BeforeEach
    public void setup() {
        Manager m1;
        m1 = new Manager();
        m1.addCoin(500);
        p1 = new Player(m1,2);
    }

    @Test
    public void TestSetStar() {
        p1.setStar(1);
        assertEquals(p1.getStar(),1);
    }

    @Test
    public void TestGetStar() {
        p1.setStar(3);
        assertEquals(p1.getStar(),3);
    }

    @Test
    public void TestImprovePlayer() {
        p1.improvePlayer();
        assertEquals(p1.getStar(),3);
        assertEquals(p1.getM1().getCoin(), 400);
        p1.improvePlayer();
        assertEquals(p1.getStar(),4);
        assertEquals(p1.getM1().getCoin(), 300);
    }
}
