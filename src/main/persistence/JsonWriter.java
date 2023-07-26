package persistence;

import model.Fixture;
import model.League;
import model.Manager;
import model.Team;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Represents a writer that writes JSON representation of workroom to file
public class JsonWriter {
    private static final int TAB = 4;
    private static PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    public JSONObject write() {
        JSONObject json = new JSONObject();
        return json;
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of Team to file
    public void writeTeam(Team team,JSONObject jsonObject) {
        JSONObject json = team.toJson();
        jsonObject.put("team", json);
    }

    public static void writeLeague(League league,JSONObject jsonObject) {
        JSONObject json = league.toJson();
        jsonObject.put("league", json);
    }

    public void writeFixture(Fixture fixture,JSONObject jsonObject) {
        JSONObject json = fixture.toJson();
        jsonObject.put("fixture", json);


    }

    public void writeManager(Manager manager,JSONObject jsonObject) {
        JSONObject json = manager.toJson();
        jsonObject.put("manager", json);
        saveToFile(jsonObject.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private static void saveToFile(String json) {
        writer.print(json);
    }
}