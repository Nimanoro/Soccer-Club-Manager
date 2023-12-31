package ui;

import model.*;
import org.json.JSONObject;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


// This class is made to make the CLI ui of the game.
public class MainGame {

    private Manager manager;
    private Team team;
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;
    private Player p5;
    private Player p6;
    private Player p7;
    private Player p8;
    private Player p9;
    private Player p10;
    private Player p11;
    private Predefinedteams t1;
    private Predefinedteams t2;
    private Predefinedteams t3;
    private Predefinedteams t4;
    private Predefinedteams t5;
    private Predefinedteams t6;
    private Predefinedteams t7;
    private Predefinedteams t8;
    private Predefinedteams t9;
    private League league;
    private Fixture fixture;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/Team.json";


    public MainGame() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runMain();
    }

    //EFFECTS: Start the game
    private void runMain() {
        boolean keepGoing = true;
        String command = null;
        init();
        while (keepGoing) {
            displayMainMenu();
            input = new Scanner(System.in);
            command = input.next();
            command = command.toLowerCase();
            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommandMain(command);
            }
        }

        System.out.println("Thanks for playing! Bye bye!");
    }

    //EFFECTS: It is the main menu of the game that keep getting commands
    // from the user.
    private void mainMenu() {
        boolean keepGoing = true;
        String command = null;

        while (keepGoing) {
            displayMainMenu();
            input = new Scanner(System.in);
            command = input.next();
            command = command.toLowerCase();
            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommandMain(command);
            }
        }
        System.out.println("Thanks for playing! Bye bye!");
    }

    //EFFECTS: Printing out the options of the main menu.
    private void displayMainMenu() {
        System.out.println("\nselect from:");
        System.out.println("start for start game");
        System.out.println("squad");
        System.out.println("standing");
        System.out.println("save");
        System.out.println("load");
        System.out.println("Quit");


    }

    //EFFECTS: Produce the related response to the command entered by the user.
    private void processCommandMain(String command) {
        if (command.equals("start")) {
            startGame();
        } else if (command.equals("squad")) {
            showSquad();
        } else if (command.equals("standing")) {
            showStanding();
        } else if (command.equals("save")) {
            saveWorkRoom();
        } else if (command.equals("load")) {
            loadWorkRoom();
        } else {
            System.out.println("Not a valid selection...");
        }
    }

    //MODIFIES: Manager, Player, Team, PredefinedTeam, League, Fixture
    //EFFECTS: Set up the starting environment of th game.
    private void init() {
        System.out.println("Enter your username");
        String name = null;
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        manager = new Manager();
        manager.setName(name);
        makePlayers(manager);
        makePredefinedTeams();
        makeLeague();
        makeFixture();
    }

    //EFFECTS: Set up the starting schedule of the team.
    // Modifies: Player, Team
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void makePlayers(Manager m) {
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
    private void makePredefinedTeams() {
        t1 = new Predefinedteams("Arsenal", "data/Teams/Arsenal.png");
        t1.setOverall(2);
        t2 = new Predefinedteams("Barcelona", "data/Teams/Arsenal.png");
        t2.setOverall(1);
        t3 = new Predefinedteams("Real Madrid", "data/Teams/Arsenal.png");
        t3.setOverall(5);
        t4 = new Predefinedteams("Bayern", "data/Teams/Arsenal.png");
        t4.setOverall(4);
        t5 = new Predefinedteams("Tottenham", "data/Teams/Arsenal.png");
        t5.setOverall(3);
        t6 = new Predefinedteams("Atlanta", "data/Teams/Arsenal.png");
        t6.setOverall(2);
        t7 = new Predefinedteams("Malavan FC", "data/Teams/Arsenal.png");
        t7.setOverall(1);
        t8 = new Predefinedteams("PSG", "data/Teams/Arsenal.png");
        t8.setOverall(4);
        t9 = new Predefinedteams("BVB", "data/Teams/Arsenal.png");
        t9.setOverall(2);

    }

    //EFFECTS: Set up the starting status of the league.
    //MODIFIES: League
    private void makeLeague() {
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
    private void makeFixture() {
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

    //MODIFIES: League
    //EFFECTS: Sort the teams based on their point and print their standing.
    private void showStanding() {
        league.sortTeams();
        for (int i = 0; i < league.getTeams().size(); i++) {
            Predefinedteams team = league.getTeams().get(i);
            System.out.println(team.getName() + " points:" + team.getPoint());
        }
    }

    //EFFECTS: Print out the players in the squad and run the squad menu
    private void showSquad() {
        boolean keepGoing = true;
        String command = null;
        for (Integer i = 0; i < team.getPlayers().size(); i++) {
            Player player = team.getPlayers().get(i);
            System.out.println(Integer.toString(i) + " " + player.getName() + " Stars:" + player.getStar());
        }
        displaySquadMenu();
        input = new Scanner(System.in);


        while (keepGoing) {
            input = new Scanner(System.in);
            command = input.next();
            command = command.toLowerCase();
            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommandSquad(command);
            }
        }

        mainMenu();

    }

    //EFFECTS: Process the command in the squad menu.
    public void processCommandSquad(String command) {
        if (command.equals("update")) {
            updatePlayer();
        } else if (command.equals("new")) {
            newPlayer();
        }
    }

    public void newPlayer() {
        String command = null;
        System.out.println("Enter the name of the new player: Cost 100");
        input = new Scanner(System.in);
        command = input.next();
        if (team.makePlayer(command,manager)) {
            System.out.println("New player was made. You can view him in your squad!");
        } else {
            System.out.println("You do not have enough coin to make a new player. Try again later!");
        }
        wait(1000);
        showSquad();
    }

    //EFFECTS: Add a start to player and deduct 10 coin from the manager coin inventory if the manager
    //coin inventory is enough to take this action.
    //MODIFIES: player, Manager
    public void updatePlayer() {
        input = new Scanner(System.in);
        System.out.println("Enter the number of the player you want to update (cost: 10 coin)");
        System.out.println("Your coin:" + Integer.toString(manager.getCoin()));
        Integer number = input.nextInt();
        Player player = team.getPlayers().get(number);
        System.out.println(player.getName());
        System.out.println("Do you want to update this player? y/n");
        String response = input.next();
        processCommandUpdate(response, player);

    }

    // Process the command in the update menu
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void processCommandUpdate(String response, Player player) {
        if (response.equals("y")) {
            if (manager.getCoin() >= 10) {
                if (player.improvePlayer()) {
                    System.out.println(player.getName() + " was updated");
                    System.out.println("Current Stars " + player.getName() + ":" + player.getStar());
                    showSquad();
                } else if (!player.improvePlayer()) {
                    System.out.println("This player is maxed out");
                } else {
                    Integer missing;
                    missing = (10 - manager.getCoin());
                    System.out.println("You don't have enough coin to update this player.");
                    System.out.println("You need " + Integer.toString(missing) + " coins");
                    wait(2000);
                    showSquad();
                }
            } else if (response.equals("n")) {
                updatePlayer();
            } else if (response.equals("q")) {
                updatePlayer();
            } else {
                System.out.println("Invalid Statement... Back to Squad menu!");
                showSquad();
            }
        }
    }

// EFFECTS: print out the options of the squad menu
    public void displaySquadMenu() {
        System.out.println("update for updating your players");
        System.out.println("new for adding a customized player to your squad");
        System.out.println("Q for going back to the main menu");
    }

    //EFFECTS: Generate the result of a game. add the points based on the result to both sides, add
    // the coins to the user account based on the result and
    // change the state of the game to a week later.
    //MODIFIES:
    private void startGame() {
        Game game1 = fixture.getGames().get(fixture.getWeek());
        System.out.println("Week " + Integer.toString(fixture.getWeek() + 1));
        System.out.println("This is " + game1.getT1().getName() + " VS " + game1.getT2().getName());
        wait(5000);
        game1.generateResult();
        game1.updatePoints();
        game1.updateCoins();
        Predefinedteams t1 = game1.getT1();
        System.out.println("Result: " + t1.getName() + " " + game1.getGoal1() + "-"
                + game1.getGoal2() + " " + team.getName());
        if (game1.getGoal1() > game1.getGoal2()) {
            System.out.println("you lost! Keep trying " + manager.getName());
        } else if (game1.getGoal1() == game1.getGoal2()) {
            System.out.println("It was a tie. Good job " + manager.getName() + " !");
        } else {
            System.out.println("You did Great " + manager.getName() + "! You won the match.");
        }
        System.out.println("Your coin after this game:" + manager.getCoin());
        System.out.println("your points after this game:" + team.getPoint());
        fixture.addAWeek();
        wait(5000);
    }

    private void saveWorkRoom() {
        try {
            jsonWriter.open();
            JSONObject json = jsonWriter.write();
            jsonWriter.writeTeam(team,json);
            jsonWriter.writeFixture(fixture,json);
            jsonWriter.writeLeague(league,json);
            jsonWriter.writeManager(manager,json);
            jsonWriter.close();
            System.out.println("Saved " + team.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    private void loadWorkRoom() {
        try {
            Manager manager = jsonReader.readManager();
            this.manager = manager;
            Team team = jsonReader.readTeam(this.manager);
            this.team = team;
            Fixture fixture = jsonReader.readFixture(team);
            League league = jsonReader.readLeague(team);
            this.league = league;
            this.fixture = fixture;

            System.out.println("Loaded " + manager.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }



    //EFFECTS:constructor of the wait method.
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
