package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//Builds the teamFrame
public class TeamPanel extends FirstMenu {

    private JFrame teamFrame;
    private JTextField nameField = new JTextField("");
    private JFrame makeMenu = new JFrame();
    private JFrame playerFrame;


    //MODIFIES: this
    //EFFECTS: constructs the TeamPanel
    public TeamPanel() {
        teamFrame = new JFrame();
        teamFrame.setTitle("Team Menu");
        teamFrame.setPreferredSize(new Dimension(600, 600));
        JLabel managerLabel = new JLabel(manager.getName() + " coins:"
                + Integer.toString(manager.getCoin()));
        managerLabel.setHorizontalAlignment(JLabel.CENTER);
        teamFrame.add(managerLabel, BorderLayout.NORTH);

        // Create and add buttons to the content pane
        addButtons();

        // Pack the frame and make it visible
        teamFrame.pack();
        teamFrame.setLocationRelativeTo(null);
        teamFrame.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: add player buttons
    private void addButtons() {
        // Create the container to hold the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(team.getPlayers().size() + 2, 1, 10, 10));
        // The GridLayout will create a 1x12 grid with 10-pixel horizontal and vertical gaps

        // Add buttons to the panel
        for (int i = 0; i <= team.getPlayers().size() - 1; i++) {
            JButton button = new JButton(team.getPlayers().get(i).getName()
                    + " " + "Stars: " + Integer.toString(team.getPlayers().get(i).getStar()));
            button.addActionListener(this::actionPerformed);
            button.setActionCommand(Integer.toString(i));
            buttonPanel.add(button);
        }
        // Add the panel to the frame's content pane
        JButton make = new JButton("Make a new player (cost: 100 coins)");
        make.addActionListener(this::actionPerformed);
        make.setActionCommand("make");
        buttonPanel.add(make);

        JButton quit = new JButton("Back to main menu");
        quit.addActionListener(this::actionPerformed);
        quit.setActionCommand("Quit");
        buttonPanel.add(quit);

        teamFrame.getContentPane().add(buttonPanel);
    }

    //EFFECTS: Navigate the button to menus from TeamFrame
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();

        if (action.equals("make")) {
            makeMenu();
        } else if (action.equals("Quit")) {
            teamFrame.dispose();
        } else {
            Integer number = Integer.parseInt(action);
            playerFrameMaker(number);
        }
    }

    //EFFECTS: makes the playerFrame
    private void playerFrameMaker(Integer number) {
        JPanel updatePanel = new JPanel();
        playerFrame = new JFrame();
        playerFrame.setPreferredSize(new Dimension(400, 400));
        JLabel updateLabel = new JLabel("Do you want to update this player? "
                + team.getPlayers().get(number).getName());
        updateLabel.setHorizontalAlignment(JLabel.CENTER);
        JPanel buts = new JPanel();
        JButton yes = new JButton("yes");
        yes.addActionListener(this::actionPlayer);
        yes.setActionCommand(Integer.toString(number));
        JButton no = new JButton("no");
        no.addActionListener(this::actionPlayer);
        no.setActionCommand("no");
        buts.add(yes);
        buts.add(no);
        updatePanel.add(updateLabel);
        playerFrame.add(updatePanel, BorderLayout.NORTH);
        playerFrame.add(buts);
        teamFrame.dispose();
        playerFrame.pack();
        playerFrame.setLocationRelativeTo(null);
        playerFrame.setVisible(true);
    }

    //EFFECTS: Navigate the button to menus from PlayerFrame
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void actionPlayer(ActionEvent ae) {
        String action = ae.getActionCommand();

        if (action.startsWith("no")) {
            teamFrame.dispose();
        } else {
            Integer number = Integer.parseInt(action);
            Player player = team.getPlayers().get(number);
            JFrame playerFrame = new JFrame("update player");
            playerFrame.setPreferredSize(new Dimension(400, 200));
            if (manager.getCoin() >= 10) {
                if (player.improvePlayer()) {
                    JLabel playerLabel = new JLabel(player.getName() + " was updated");
                    JLabel playerStatus = new JLabel("Current Stars " + player.getName() + ":" + player.getStar());
                    playerFrame.add(playerLabel);
                    playerFrame.add(playerStatus);
                    playerFrame.pack();
                    playerFrame.setLocationRelativeTo(null);
                    playerFrame.setVisible(true);
                } else if (!player.improvePlayer()) {
                    JLabel playerLabel = new JLabel("This player is maxed out");
                    playerFrame.add(playerLabel);
                    playerFrame.pack();
                    playerFrame.setLocationRelativeTo(null);
                    playerFrame.setVisible(true);
                }

            } else {
                Integer missing;
                missing = (10 - manager.getCoin());
                JLabel playerStatus = new JLabel("You need " + Integer.toString(missing)
                        + " more coins to update this player");
                playerStatus.setHorizontalAlignment(SwingConstants.CENTER);
                playerFrame.add(playerStatus, BorderLayout.CENTER);
                playerFrame.pack();
                playerFrame.setLocationRelativeTo(null);
                playerFrame.setVisible(true);
            }
        }
    }

    //MODIFIES: This
    //EFFECTS: BUILD THE MAKE PLAYER MENU
    public void makeMenu() {
        makeMenu.setPreferredSize(new Dimension(400, 400));
        JPanel panel = new JPanel(new GridLayout(3,1));
        JLabel enterIns = new JLabel("Enter the name of the new player: Cost 100");
        JButton submitBut = new JButton("submit");
        submitBut.addActionListener(this::actionMake);
        submitBut.setActionCommand("submit");
        panel.add(enterIns);
        panel.add(nameField);
        panel.add(submitBut);
        makeMenu.add(panel);
        makeMenu.pack();
        makeMenu.setLocationRelativeTo(null);
        makeMenu.setVisible(true);
    }

    //EFFECTS: Navigate the button to menus from makeMenuFrame
    private void actionMake(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("submit")) {
            if (team.makePlayer(nameField.getText(), manager)) {
                teamFrame.dispose();
                makeMenu.dispose();
                new TeamPanel();
            } else {
                Integer missing;
                missing = (100 - manager.getCoin());
                JPanel parent = new JPanel(new GridLayout(2,1));
                JLabel playerLabel = new JLabel("You don't have enough coin to update this player.");
                JLabel playerStatus = new JLabel("You need " + Integer.toString(missing) + " coins");
                JFrame playerFrame = new JFrame("not enough coin!");
                playerFrame.setPreferredSize(new Dimension(400, 200));
                parent.add(playerLabel, JLabel.CENTER);
                parent.add(playerStatus, JLabel.CENTER);
                playerFrame.add(parent);
                playerFrame.pack();
                playerFrame.setLocationRelativeTo(null);
                playerFrame.setVisible(true);

            }

        }
    }
}
