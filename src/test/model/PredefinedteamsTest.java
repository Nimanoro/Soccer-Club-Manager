package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredefinedteamsTest {
    Predefinedteams t1;

    @BeforeEach
    public void setup() {
        t1 = new Predefinedteams("Arsenal");
    }

    @Test
    public void TestGetOverall() {
        t1.setOverall(2);
        assertEquals(t1.getOverall(),2);

    }

    @Test
    public void TestGetName() {
        assertEquals(t1.getName(),"Arsenal");
    }
}
