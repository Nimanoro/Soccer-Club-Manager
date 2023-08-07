package ui;

import model.*;
import org.json.JSONObject;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class FirstMenu extends JFrame {
    protected static Manager manager;
    protected static Team team;
    protected static Player p1;
    protected static Player p2;
    protected static Player p3;
    protected static Player p4;
    protected static Player p5;
    private  static Player p6;
    private  static Player p7;
    private  static Player p8;
    private  static Player p9;
    private  static Player p10;
    private  static Player p11;
    protected static Predefinedteams t1;
    protected  static Predefinedteams t2;
    protected  static Predefinedteams t3;
    protected  static Predefinedteams t4;
    protected static Predefinedteams t5;
    protected  static Predefinedteams t6;
    protected  static Predefinedteams t7;
    protected  static Predefinedteams t8;
    protected  static Predefinedteams t9;
    protected  static League league;
    protected  static Fixture fixture;
    protected  static JsonWriter jsonWriter;
    protected  static JsonReader jsonReader;
    protected static final String JSON_STORE = "./data/Team.json";
    protected static JFrame parent;

    public static void main(final String[] args) {
        parent = new JFrame();
        JButton button = new JButton();

        button.setText("Click me to Start the game!");
        parent.setLocationRelativeTo(null);
        parent.add(button);
        parent.pack();
        parent.setVisible(true);

        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = JOptionPane.showInputDialog(parent,
                        "What is your name?", null);
                if ((name != null) && (name.length() > 0)) {
                    gameInit(name);
                    new MainMenu();
                }

            }
        });


    }

    private static void gameInit(String name) {
        manager = new Manager();
        manager.setName(name);
        makePlayers(manager);
        makePredefinedTeams();
        makeLeague();
        makeFixture();
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private static void makePlayers(Manager m) {
        p1 = new Player(m, 1);
        p1.setName("Buffon");
        team = new Team(m);
        team.addPlayer(p1);
        p2 = new Player(m, 1);
        p2.setName("Sergio Ramos");
        team.addPlayer(p2);
        p3 = new Player(m, 1);
        p3.setName("Pepe");
        team.addPlayer(p3);
        p4 = new Player(m, 1);
        p4.setName("Marcelo");
        team.addPlayer(p4);
        p5 = new Player(m, 1);
        p5.setName("Philip Lahm");
        team.addPlayer(p5);
        p6 = new Player(m, 1);
        p6.setName("Toni Kroos");
        team.addPlayer(p6);
        p7 = new Player(m, 1);
        p7.setName("Xavi");
        team.addPlayer(p7);
        p8 = new Player(m, 1);
        p8.setName("Modric");
        team.addPlayer(p8);
        p9 = new Player(m, 1);
        p9.setName("Messi");
        team.addPlayer(p9);
        p10 = new Player(m, 2);
        p10.setName("Ronaldo");
        team.addPlayer(p10);
        p11 = new Player(m, 1);
        p11.setName("Pele");
        team.addPlayer(p11);
    }

    //EFFECTS: Set up the default predefined teams
    //MODIFIES: Predefinedteams
    private static void makePredefinedTeams() {
        t1 = new Predefinedteams("Arsenal");
        t1.setOverall(2);
        t2 = new Predefinedteams("Barcelona");
        t2.setOverall(1);
        t3 = new Predefinedteams("Real Madrid");
        t3.setOverall(5);
        t4 = new Predefinedteams("Bayern");
        t4.setOverall(4);
        t5 = new Predefinedteams("Tottenham");
        t5.setOverall(3);
        t6 = new Predefinedteams("Atlanta");
        t6.setOverall(2);
        t7 = new Predefinedteams("Malavan FC");
        t7.setOverall(1);
        t8 = new Predefinedteams("PSG");
        t8.setOverall(4);
        t9 = new Predefinedteams("BVB");
        t9.setOverall(2);

    }

    //EFFECTS: Set up the starting status of the league.
    //MODIFIES: League
    private static void makeLeague() {
        league = new League();
        ArrayList<Predefinedteams> list = new ArrayList<Predefinedteams>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        list.add(t7);
        list.add(t8);
        list.add(t9);
        list.add(team);
        league.setTeams(list);
    }

    // EFFECTS: Make the schedule of the game for the team.
    //MODIFIES: Fixture
    private static void makeFixture() {
        fixture = new Fixture(team);
        fixture.addPreDTeams(t1);
        fixture.addPreDTeams(t2);
        fixture.addPreDTeams(t3);
        fixture.addPreDTeams(t4);
        fixture.addPreDTeams(t5);
        fixture.addPreDTeams(t6);
        fixture.addPreDTeams(t7);
        fixture.addPreDTeams(t8);
        fixture.addPreDTeams(t9);
        fixture.setGames();
    }

    public void saveGame() {
        try {
            jsonWriter = new JsonWriter(JSON_STORE);
            jsonWriter.open();
            JSONObject json = jsonWriter.write();
            jsonWriter.writeTeam(team,json);
            jsonWriter.writeFixture(fixture,json);
            jsonWriter.writeLeague(league,json);
            jsonWriter.writeManager(manager,json);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            JFrame error = new JFrame("Error");
            error.setVisible(true);
        }
    }

    public void loadGame() {
        jsonReader = new JsonReader(JSON_STORE);
        try {
            Manager manager = jsonReader.readManager();
            this.manager = manager;
            Team team = jsonReader.readTeam(this.manager);
            this.team = team;
            Fixture fixture = jsonReader.readFixture(team);
            League league = jsonReader.readLeague(team);
            this.league = league;
            this.fixture = fixture;
        } catch (IOException e) {
            JFrame error = new JFrame("Error");
            error.setVisible(true);

        }
    }


    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}


