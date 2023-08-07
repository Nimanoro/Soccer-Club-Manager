package ui;

import model.Predefinedteams;

import javax.swing.*;
import java.awt.*;

public class LeaguePanel extends MainMenu {
    JFrame leagueFrame;

    public LeaguePanel() {
        leagueFrame = new JFrame();
        leagueFrame.setPreferredSize(new Dimension(600,600));
        leagueFrame.setBackground(Color.blue);
        JPanel leaguePanel = new JPanel(new GridLayout(11,1, 10, 10));
        leaguePanel.setBackground(Color.cyan);
        league.sortTeams();
        for (int i = 0; i < league.getTeams().size(); i++) {
            Predefinedteams team = league.getTeams().get(i);
            JLabel teamLabel= new JLabel(Integer.toString(i + 1)
                    + " " + team.getName() + " points: " + team.getPoint());
            teamLabel.setBackground(Color.BLUE);
            leaguePanel.add(teamLabel);
        }

        leagueFrame.add(leaguePanel);
        leagueFrame.pack();
        leagueFrame.setLocationRelativeTo(null);
        leagueFrame.setVisible(true);
    }


}



