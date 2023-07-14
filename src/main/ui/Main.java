package ui;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class startGame {

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
    private League league;
    private Fixture fixture;
    private Scanner input;
    private Game game;

    public Main() {
        runMain();
    }

    private void runMain() {
        boolean keepGoing = true;
        String command = null;

        init();

        init();
        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();
            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("Goodbye!");
    }

    private void displayMenu() {
        System.out.println("\nselect from:");
        System.out.println("start game");
        System.out.println("squad");
        System.out.println("standing");


    }

    private void processCommand(String command) {
        if (command.equals("start game")) {
            startGame();
        } else if (command.equals("squad")) {
            showSquad();
        } else if (command.equals("standing")) {
            showStanding();
        } else {
            System.out.println("Not a valid selection...");
        }
    }

    private void init() {
        System.out.println("Enter your username");
        String name = input.next();
        manager = new Manager();
        manager.setName(name);
        makePlayers(manager);
        makePredefinedTeams();
        makeLeague();
        makeFixture();

    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void makePlayers(Manager m) {
        p1 = new Player(m,1);
        p1.setName("Buffon");
        team.addPlayer(p1);
        p2 = new Player(m,1);
        p2.setName("Sergio Ramos");
        team.addPlayer(p2);
        p3 = new Player(m,1);
        p3.setName("Pepe");
        team.addPlayer(p3);
        p4 = new Player(m,1);
        p4.setName("Marcelo");
        team.addPlayer(p4);
        p5 = new Player(m,1);
        p5.setName("Philip Lahm");
        team.addPlayer(p5);
        p6 = new Player(m,1);
        p6.setName("Toni Kroos");
        team.addPlayer(p6);
        p7 = new Player(m,1);
        p7.setName("Xavi");
        team.addPlayer(p7);
        p8 = new Player(m,1);
        p8.setName("Modric");
        team.addPlayer(p8);
        p9 = new Player(m, 1);
        p9.setName("Messi");
        team.addPlayer(p9);
        p10 = new Player(m,2);
        p10.setName("Ronaldo");
        team.addPlayer(p10);
        p11 = new Player(m,1);
        p11.setName("Pele");
        team.addPlayer(p11);
    }

    private void makePredefinedTeams() {
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
    }

    private void makeLeague() {
        league = new League();
        ArrayList<Predefinedteams> list = new ArrayList<Predefinedteams>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(team);
        league.setTeams(list);
    }

    private void makeFixture() {
        fixture = new Fixture(team);
        fixture.addPreDTeams(t1);
        fixture.addPreDTeams(t2);
        fixture.addPreDTeams(t3);
        fixture.addPreDTeams(t4);
        fixture.addPreDTeams(t5);
        fixture.setGames();
    }

    private void showStanding() {
        league.sortTeams();
        for (int i = 0; i < league.getTeams().size(); i++) {
            Predefinedteams team = league.getTeams().get(i);
            System.out.println(team.getName() + " points:" + team.getPoint());
        }

    }

    private void showSquad() {
        for (int i = 0; i < team.getPlayers().size(); i++) {
            Player player = team.getPlayers().get(i);
            System.out.println(player.getName() + " Stars:" + player.getStar());
        }

    }

    private void startGame() {

    }


}


