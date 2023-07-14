package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeagueTest {

    Predefinedteams t1;
    Predefinedteams t2;
    Predefinedteams t3;
    Predefinedteams t4;
    Predefinedteams t5;
    ArrayList<Predefinedteams> list1;
    League l1;

    @BeforeEach
    public void setup() {
        t1 = new Predefinedteams("AFC");
        t2 = new Predefinedteams("Milan");
        t3 = new Predefinedteams("BArcelona");
        t4 = new Predefinedteams("Real Madrid");
        t5 = new Predefinedteams("BVB");
        t1.updatePoints(5);
        t2.updatePoints(6);
        t3.updatePoints(7);
        t4.updatePoints(8);
        t5.updatePoints(1);
        list1 = new ArrayList<Predefinedteams>();
        list1.add(t1);
        list1.add(t2);
        list1.add(t3);
        list1.add(t4);
        list1.add(t5);
        League l1;
        l1 = new League();


    }

    @Test
    public void TestGetTeams() {
        l1 = new League();
        l1.setTeams(list1);
        assertEquals(l1.getTeams(), list1);

    }

    @Test
    public void TestSortTeams() {
        l1 = new League();
        l1.setTeams(list1);
        assertEquals(l1.getTeams(), list1);
        l1.sortTeams();
        ArrayList<Predefinedteams> list2;
        list2 = new ArrayList<Predefinedteams>();
        list2.add(t4);
        list2.add(t3);
        list2.add(t2);
        list2.add(t1);
        list2.add(t5);

        assertEquals(l1.getTeams(), list2);



    }
}
