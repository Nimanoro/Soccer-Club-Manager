package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerTest {
    Manager m1;

    @BeforeEach
    public void setup(){
        m1 = new Manager();
    }

    @Test
    public void TestSetName(){
        m1.setName("Nima");
        assertEquals(m1.getName(), "Nima");
        m1.setName("AB");
        assertEquals(m1.getName(),"AB");
    }

    @Test
    public void TestGetName(){
        assertEquals(m1.getName(),"player1");
        m1.setName("Nima");
        assertEquals(m1.getName(), "Nima");
        m1.setName("AB");
        assertEquals(m1.getName(),"AB");
    }

    @Test
    public void TestGetCoin(){
        assertEquals(m1.getCoin(), 0);
        m1.addCoin(100);
        assertEquals(m1.getCoin(),100);
    }

    @Test
    public void TestAddCoin(){
        m1.addCoin(100);
        assertEquals(m1.getCoin(),100);
        m1.addCoin(300);
        assertEquals(m1.getCoin(),400);
    }

    @Test
    public void TestSubCoin(){
        m1.addCoin(100);
        assertEquals(m1.getCoin(),100);
        m1.subCoin(50);
        assertEquals(m1.getCoin(),50);
        m1.subCoin(20);
        assertEquals(m1.getCoin(),30);
    }


}

