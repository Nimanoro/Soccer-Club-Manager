package ui;

import model.Game;
import model.Predefinedteams;

import javax.swing.*;
import java.awt.*;

//Constructs the game menu
public class GameMenu extends FirstMenu {

    JFrame gameFrame;

    //MODIFIES: THIS
    //EFFECTS: Construct the GameFrame
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public GameMenu() {
        gameFrame = new JFrame();
        gameFrame.setPreferredSize(new Dimension(500,500));
        Game game1 = fixture.getGames().get(fixture.getWeek());
        JPanel gamePanel = new JPanel(new GridLayout(3,1,10,10));
        JLabel weekLabel = new JLabel("Week " + Integer.toString(fixture.getWeek() + 1) + "\n");
        weekLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel gameLabel = new JLabel("This is " + game1.getT1().getName() + " VS " + game1.getT2().getName()
                            + "\n");
        gameLabel.setHorizontalAlignment(JLabel.CENTER);
        game1.generateResult();
        game1.updatePoints();
        game1.updateCoins();
        Predefinedteams t1 = game1.getT1();
        JLabel result = new JLabel("Result: " + t1.getName() + " " + game1.getGoal1() + "-"
                + game1.getGoal2() + " " + team.getName());
        result.setHorizontalAlignment(JLabel.CENTER);
        gamePanel.add(weekLabel);
        gamePanel.add(gameLabel);

        gameFrame.setLocationRelativeTo(null);
        gameFrame.pack();
        gameFrame.setVisible(true);

        gamePanel.add(result);
        gameFrame.add(gamePanel,BorderLayout.NORTH);
        JPanel parent = new JPanel(new GridLayout(2,1,10,10));
        JPanel results = new JPanel(new GridLayout(2,1,1,1));
        if (game1.getGoal1() > game1.getGoal2()) {
            JLabel pictureLabel = new JLabel();
            ImageIcon img = new ImageIcon("data/360_F_131419939_Uh5AUdnNOjGiVEpFgweSWogZMXBDuGwE.jpeg");
            Image image = img.getImage(); // transform it
            Image newImg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            img = new ImageIcon(newImg);  // transform it back
            pictureLabel.setIcon(img);
            pictureLabel.setHorizontalAlignment(JLabel.CENTER);
            pictureLabel.setBounds(100,100,200,200);
            parent.add(pictureLabel,CENTER_ALIGNMENT);
        } else if (game1.getGoal1() == game1.getGoal2()) {
            JLabel pictureLabel = new JLabel();
            ImageIcon img = new ImageIcon("data/keep-calm-it-s-a-tie-game.png");
            Image image = img.getImage(); // transform it
            Image newImg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            img = new ImageIcon(newImg);  // transform it back
            pictureLabel.setIcon(img);
            pictureLabel.setHorizontalAlignment(JLabel.CENTER);
            parent.add(pictureLabel,CENTER_ALIGNMENT);
        } else {
            JLabel pictureLabel = new JLabel();
            ImageIcon img = new ImageIcon("data/Win.jpeg");
            Image image = img.getImage(); // transform it
            Image newImg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            img = new ImageIcon(newImg);  // transform it back
            pictureLabel.setIcon(img);
            pictureLabel.setHorizontalAlignment(JLabel.CENTER);
            parent.add(pictureLabel);

        }
        JLabel coinLabel = new JLabel("Your coin after this game:" + manager.getCoin());
        JLabel pointLabel = new JLabel("your points after this game:" + team.getPoint());
        coinLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pointLabel.setHorizontalAlignment(SwingConstants.CENTER);
        results.add(coinLabel);
        results.add(pointLabel);
        parent.add(results);
        gameFrame.add(parent);
        fixture.addAWeek();


    }
}
