package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(p1.getM1().getCoin(), 490);
        p1.improvePlayer();
        assertEquals(p1.getStar(),4);
        assertEquals(p1.getM1().getCoin(), 480);
        assertTrue(p1.improvePlayer());
        assertEquals(p1.getStar(),5);
        assertEquals(p1.getM1().getCoin(), 470);
        assertFalse(p1.improvePlayer());
        assertEquals(p1.getStar(),5);
        assertEquals(p1.getM1().getCoin(), 470);



    }

    @Test
    public void GetName() {
        p1.setName("Nima");
        assertEquals(p1.getName(), "Nima");

    }

    @Test
    public void SetName() {
        p1.setName("amin");
        assertEquals(p1.getName(), "amin");
    }
}
