package persistence;

import model.Fixture;
import model.League;
import model.Manager;
import model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class JsonReaderTest extends JsonTest{
    JsonReader jsonReader;

    @BeforeEach
    public void setup() {
        jsonReader = new JsonReader("./data/Test.json");
    }
    @Test
    public void TestReadManager() throws IOException {
        Manager manager = jsonReader.readManager();
        checkManager(manager,"nima", 300);



    }

    @Test
    public void TestReadFixture() throws IOException {
        Manager manager = jsonReader.readManager();
        Team team = jsonReader.readTeam(manager);
        Fixture fixture = jsonReader.readFixture(team);
        checkFixture(fixture,9 , 5);
    }

    @Test
    public void TestReadLeague() throws IOException {
        Manager manager = jsonReader.readManager();
        Team team = jsonReader.readTeam(manager);
        League league = jsonReader.readLeague(team);
        league.sortTeams();
        checkLeague(league, "Real Madrid",10);
    }

    @Test
    public void TestReadTeam() throws IOException {
        Manager manager = jsonReader.readManager();
        Team team = jsonReader.readTeam(manager);
        checkTeam(team,"Dream Team", 7, 11);
    }


}
