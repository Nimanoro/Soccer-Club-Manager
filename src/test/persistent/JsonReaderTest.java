package persistent;

import model.League;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonReaderTest {
    JsonReader jsonReader;

    @BeforeEach
    public void setup() {
        jsonReader = new JsonReader("./data/Team.json");
    }
    @Test
    public void TestReadManager() throws IOException {
        assertEquals(jsonReader.readManager().getCoin(),75);


    }

    @Test
    public void TestReadFixture() throws IOException {
        assertEquals(jsonReader.readFixture().getWeek(),2);
    }

    @Test
    public void TestReadLeague() throws IOException {
        League league = jsonReader.readLeague();
        league.sortTeams();
        assertEquals(league.getTeams().get(0).getName(), "Barcelona");

    }
}
