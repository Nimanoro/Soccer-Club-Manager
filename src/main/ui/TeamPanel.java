package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TeamPanel extends MainMenu {

    JFrame teamFrame;

    public TeamPanel() {
        teamFrame = new JFrame();
        teamFrame.setTitle("Team Menu");
        teamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teamFrame.setPreferredSize(new Dimension(600, 600));
        JLabel managerLabel = new JLabel(super.manager.getName() + " coins:"
                + Integer.toString(super.manager.getCoin()));
        managerLabel.setHorizontalAlignment(JLabel.CENTER);
        teamFrame.add(managerLabel, BorderLayout.NORTH);

        // Create and add buttons to the content pane
        addButtons();

        // Pack the frame and make it visible
        teamFrame.pack();
        teamFrame.setLocationRelativeTo(null);
        teamFrame.setVisible(true);
    }

    private void addButtons() {
        // Create the container to hold the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(13, 1, 10, 10));
        // The GridLayout will create a 1x12 grid with 10-pixel horizontal and vertical gaps

        // Add buttons to the panel
        for (int i = 0; i <= team.getPlayers().size() - 1; i++) {
            JButton button = new JButton(team.getPlayers().get(i).getName()
                    + " " + "Stars: " + Integer.toString(team.getPlayers().get(i).getStar()));
            button.addActionListener(this::actionPerformed);
            button.setActionCommand("player " + Integer.toString(i));
            buttonPanel.add(button);
        }
        // Add the panel to the frame's content pane
        JButton make = new JButton("Make a new player (cost: 100 coins)");
        make.addActionListener(this::actionPerformed);
        make.setActionCommand("make");
        buttonPanel.add(make);

        JButton quit = new JButton("Back to main menu");
        make.addActionListener(this::actionPerformed);
        make.setActionCommand("quit");
        buttonPanel.add(quit);

        teamFrame.getContentPane().add(buttonPanel);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.startsWith("player")) {
            Integer number = Integer.parseInt(action.substring(action.length() - 1));
            JPanel updatePanel = new JPanel();
            JFrame playerFrame = new JFrame();
            playerFrame.setPreferredSize(new Dimension(400, 400));
            JLabel updateLabel = new JLabel("Do you want to update this player? "
                    + team.getPlayers().get(number).getName());
            updateLabel.setHorizontalAlignment(JLabel.CENTER);
            JPanel buts = new JPanel();
            JButton yes = new JButton("yes");
            yes.addActionListener(this::actionPlayer);
            yes.setActionCommand("yes" + number);
            JButton no = new JButton("no");
            no.addActionListener(this::actionPlayer);
            no.setActionCommand("no");
            buts.add(yes);
            buts.add(no);
            updatePanel.add(updateLabel);
            playerFrame.add(updatePanel,BorderLayout.NORTH);
            playerFrame.add(buts);
            teamFrame.dispose();
            playerFrame.pack();
            playerFrame.setLocationRelativeTo(null);
            playerFrame.setVisible(true);
        } else if (action.equals("make")) {
            makeMenu();
        } else if (action.equals("quit")) {
            teamFrame.dispose();
        }
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void actionPlayer(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.startsWith("yes")) {
            Integer number = Integer.parseInt(action.substring(action.length() - 1));
            Player player = team.getPlayers().get(number);
            JFrame playerFrame = new JFrame("update player");
            playerFrame.setPreferredSize(new Dimension(400,200));
            teamFrame.dispose();
            if (manager.getCoin() >= 10) {
                if (player.improvePlayer()) {
                    JLabel playerLabel = new JLabel(player.getName() + " was updated");
                    JLabel playerStatus = new JLabel("Current Stars " + player.getName() + ":" + player.getStar());
                    playerFrame.add(playerLabel, CENTER_ALIGNMENT);
                    playerFrame.add(playerStatus, CENTER_ALIGNMENT);
                    playerFrame.pack();
                    playerFrame.setLocationRelativeTo(null);
                    playerFrame.setVisible(true);
                } else if (!player.improvePlayer()) {
                    JLabel playerLabel = new JLabel("This player is maxed out");
                    playerFrame.add(playerLabel, CENTER_ALIGNMENT);
                    playerFrame.pack();
                    playerFrame.setLocationRelativeTo(null);
                    playerFrame.setVisible(true);
                } else {
                    Integer missing;
                    missing = (10 - manager.getCoin());
                    JLabel playerLabel = new JLabel("You don't have enough coin to update this player.");
                    JLabel playerStatus = new JLabel("You need " + Integer.toString(missing) + " coins");
                    playerFrame.add(playerLabel, BorderLayout.CENTER);
                    playerFrame.add(playerStatus,  BorderLayout.CENTER);
                    playerFrame.pack();
                    playerFrame.setLocationRelativeTo(null);
                    playerFrame.setVisible(true);
                }
            } else {
                JLabel playerLabel = new JLabel("You don't have enough coin to update your player");
                playerFrame.add(playerLabel, BorderLayout.CENTER);
                playerFrame.pack();
                playerFrame.setLocationRelativeTo(null);
                playerFrame.setVisible(true);
            }
        } else {
            new TeamPanel();
        }
    }

    public void makeMenu() {
        JFrame make = new JFrame();
        make.setPreferredSize(new Dimension(400,400));
        JPanel makePanel = new JPanel();
        JLabel makeLabel = new JLabel("Do you want to make a new player? Cost: 100 coins");
        makePanel.add(makeLabel,CENTER_ALIGNMENT);
        make.add(makePanel);
        make.pack();
        make.setLocationRelativeTo(null);
        make.setVisible(true);
    }
}
