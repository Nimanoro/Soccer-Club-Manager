package ui;

import model.Predefinedteams;

import javax.swing.*;
import java.awt.*;

// Constructs LeagueFrame based on JFrame
public class LeaguePanel extends MainMenu {
    JFrame leagueFrame;

    //MODIFIES: this
    //EFFECTS: constructs the leagueFrame
    public LeaguePanel() {
        leagueFrame = new JFrame();
        leagueFrame.setPreferredSize(new Dimension(600,600));
        JPanel leaguePanel = new JPanel(new GridLayout(11,1, 10, 10));
        Color color = new Color(4, 137, 48);
        leaguePanel.setBackground(color);
        league.sortTeams();
        for (int i = 0; i < league.getTeams().size(); i++) {
            Predefinedteams team = league.getTeams().get(i);
            JLabel teamLabel = new JLabel(Integer.toString(i + 1)
                    + " " + team.getName() + " points: " + team.getPoint());
            ImageIcon i1 =  imageProccesor(league.getTeams().get(i).getImage());
            teamLabel.setIcon(i1);
            teamLabel.setBackground(Color.BLUE);
            leaguePanel.add(teamLabel);
        }

        leagueFrame.add(leaguePanel);
        leagueFrame.pack();
        leagueFrame.setLocationRelativeTo(null);
        leagueFrame.setVisible(true);
    }

    private ImageIcon imageProccesor(String source) {
        ImageIcon img2 = new ImageIcon(source);
        Image image2 = img2.getImage();
        Image newImg2 = image2.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        img2 = new ImageIcon(newImg2);
        return img2;

    }


}



