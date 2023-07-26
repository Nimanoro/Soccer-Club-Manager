package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }


    public Manager readManager() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        Manager manager = parseManager(jsonObject);
        return manager;

    }

    public League readLeague(Team team) throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        League league = parseLeague(jsonObject, team);
        return league;

    }

    public Team readTeam(Manager manager) throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        Team team = parseTeam(jsonObject, manager);
        return team;

    }

    public Fixture readFixture(Team team) throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        Fixture fixture = parseFixture(jsonObject, team);
        return fixture;

    }




    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    private Team parseTeam(JSONObject jsonObject, Manager manager) {
        JSONObject jsonTeam = jsonObject.getJSONObject("team");
        Integer point = jsonTeam.getInt("point");
        Team team = new Team(manager);
        team.updatePoints(point);
        addPlayers(team, jsonTeam);
        return team;

    }

    private void addPlayers(Team team, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("players");
        for (Object json : jsonArray) {
            JSONObject nextPlayer = (JSONObject) json;
            addPlayer(team, nextPlayer);
        }
    }


    @SuppressWarnings({"checkstyle:MethodParamPad", "checkstyle:SuppressWarnings"})
    private void addPlayer (Team team, JSONObject jsonObject) {
        Integer star = jsonObject.getInt("star");
        String name = jsonObject.getString("name");
        Player player = new Player(team.getManager(),star);
        player.setName(name);
        team.addPlayer(player);

    }

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

    private void addPreTeam(Fixture fixture, JSONObject preteam) {
        Integer overall = preteam.getInt("overall");
        Integer point = preteam.getInt("point");
        String name = preteam.getString("name");
        Predefinedteams predteam = new Predefinedteams(name);
        predteam.setOverall(overall);
        predteam.updatePoints(point);
        fixture.addPreDTeams(predteam);

    }


    private Manager parseManager(JSONObject jsonObject) {
        JSONObject jsonManager = jsonObject.getJSONObject("manager");
        String name = jsonManager.getString("manager name");
        Integer coin = jsonManager.getInt("coin");
        Manager manager = new Manager();
        manager.setName(name);
        manager.setCoin(coin);
        return manager;
    }

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

    private void addPreTeamToLeague(League league, JSONObject jsonObject) {
        if (!jsonObject.getString("name").equals("Dream Team")) {
            Integer point = jsonObject.getInt("point");
            String name = jsonObject.getString("name");
            Predefinedteams predteam = new Predefinedteams(name);
            predteam.updatePoints(point);
            league.addTeam(predteam);
        }
    }


}
