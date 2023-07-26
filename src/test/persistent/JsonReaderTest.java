package persistent;

import model.League;
import model.Manager;
import model.Team;
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
        assertEquals(jsonReader.readManager().getCoin(),300);


    }

    @Test
    public void TestReadFixture() throws IOException {
        Manager manager = jsonReader.readManager();
        Team team = jsonReader.readTeam(manager);
        assertEquals(jsonReader.readFixture(team).getWeek(),5);

    }

    @Test
    public void TestReadLeague() throws IOException {
        Manager manager = jsonReader.readManager();
        Team team = jsonReader.readTeam(manager);
        League league = jsonReader.readLeague(team);
        league.sortTeams();
        assertEquals(league.getTeams().get(0).getName(), "Dream Team");

    }
}
