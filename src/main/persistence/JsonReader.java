package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads state of the whole game from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }


    // EFFECTS: reads Manager from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Manager readManager() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        Manager manager = parseManager(jsonObject);
        return manager;

    }

    // EFFECTS: reads Manager from file and returns it;
    // throws IOException if an error occurs reading data from file
    public League readLeague(Team team) throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        League league = parseLeague(jsonObject, team);
        return league;

    }

    // EFFECTS: reads Team from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Team readTeam(Manager manager) throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        Team team = parseTeam(jsonObject, manager);
        return team;

    }

    // EFFECTS: reads Fixture from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Fixture readFixture(Team team) throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        Fixture fixture = parseFixture(jsonObject, team);
        return fixture;

    }



    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Team from JSON object and returns it
    private Team parseTeam(JSONObject jsonObject, Manager manager) {
        JSONObject jsonTeam = jsonObject.getJSONObject("team");
        Integer point = jsonTeam.getInt("point");
        Team team = new Team(manager);
        team.updatePoints(point);
        addPlayers(team, jsonTeam);
        return team;

    }

    //Modifies: Team
    // EFFECTS: add Players to the team
    private void addPlayers(Team team, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("players");
        for (Object json : jsonArray) {
            JSONObject nextPlayer = (JSONObject) json;
            addPlayer(team, nextPlayer);
        }
    }

    //Modifies: Team
    // EFFECTS: add a Player to the team
    private void addPlayer(Team team, JSONObject jsonObject) {
        Integer star = jsonObject.getInt("star");
        String name = jsonObject.getString("name");
        Player player = new Player(team.getManager(),star);
        player.setName(name);
        team.addPlayer(player);

    }

    // EFFECTS: parses Fixture from JSON object and returns it
    private Fixture parseFixture(JSONObject jsonObject, Team team) {
        JSONObject jsonFixture = jsonObject.getJSONObject("fixture");
        Integer week = jsonFixture.getInt("week");
        Fixture fixture = new Fixture(team);
        fixture.setWeek(week);
        JSONArray jsonArray = jsonFixture.getJSONArray("predTeams");
        for (Object json : jsonArray) {
            JSONObject nextPreTeam = (JSONObject) json;
            addPreTeam(fixture, nextPreTeam);


        }
        fixture.setGames();
        return fixture;
    }

    // EFFECTS: add PreTeam from JSON object and add it to the fixture
    private void addPreTeam(Fixture fixture, JSONObject preteam) {
        Integer overall = preteam.getInt("overall");
        Integer point = preteam.getInt("point");
        String name = preteam.getString("name");
        String imgSrc = preteam.getString("img");
        Predefinedteams predteam = new Predefinedteams(name, imgSrc);
        predteam.setOverall(overall);
        predteam.updatePoints(point);
        fixture.addPreDTeams(predteam);

    }

    // EFFECTS: parses Manager from JSON object and returns it
    private Manager parseManager(JSONObject jsonObject) {
        JSONObject jsonManager = jsonObject.getJSONObject("manager");
        String name = jsonManager.getString("manager name");
        Integer coin = jsonManager.getInt("coin");
        Manager manager = new Manager();
        manager.setName(name);
        manager.setCoin(coin);
        return manager;
    }

    // EFFECTS: parses League from JSON object and returns it
    private League parseLeague(JSONObject jsonObject, Team team) {
        JSONObject jsonLeague = jsonObject.getJSONObject("league");
        JSONArray jsonArray = jsonLeague.getJSONArray("teams");
        League league = new League();
        league.addTeam(team);
        for (Object json : jsonArray) {
            JSONObject nextPreTeam = (JSONObject) json;
            addPreTeamToLeague(league, nextPreTeam);

        }
        return league;
    }

    // EFFECTS: add PreTeam from JSON object and add it to the league
    private void addPreTeamToLeague(League league, JSONObject jsonObject) {
        if (!jsonObject.getString("name").equals("Dream Team")) {
            Integer point = jsonObject.getInt("point");
            String name = jsonObject.getString("name");
            String imgSrc = jsonObject.getString("img");
            Predefinedteams predteam = new Predefinedteams(name, imgSrc);
            predteam.updatePoints(point);
            league.addTeam(predteam);
        }
    }


}
