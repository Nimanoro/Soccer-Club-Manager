package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends FirstMenu {

    private JFrame frame;



    public MainMenu() {
        frame = new JFrame();
        frame.setTitle("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));

        addButtons();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private void addButtons() {
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));

        ImageIcon img = new ImageIcon("data/Soccer-Ball.jpeg");
        Image image = img.getImage(); // transform it
        Image newImg = image.getScaledInstance(220, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        img = new ImageIcon(newImg);
        JButton button1 = new JButton("start game");
        button1.setIcon(img);
        ImageIcon finalImg = img;
        button1.addMouseListener(new MouseAdapter() {
            Color color = button1.getForeground();
            public void mouseEntered(MouseEvent me) {
                color = button1.getForeground();
                button1.setIcon(null);
                button1.setText("Start game"); // change the color to green when mouse over a button
            }

            public void mouseExited(MouseEvent me) {
                button1.setIcon(finalImg);
            }
        });
        button1.addActionListener(this::actionPerformed);
        button1.setActionCommand("Start");
        buttonPanel.add(button1);
        JButton button2 = new JButton("Squad");
        button2.addActionListener(this::actionPerformed);
        button2.setActionCommand("Squad");
        buttonPanel.add(button2);
        JButton button3 = new JButton("Standing");
        button3.addActionListener(this::actionPerformed);
        button3.setActionCommand("Standing");
        buttonPanel.add(button3);
        JButton button4 = new JButton("Save");
        button4.addActionListener(this::actionPerformed);
        button4.setActionCommand("Save");
        buttonPanel.add(button4);
        JButton button5 = new JButton("Load");
        button5.addActionListener(this::actionPerformed);
        button5.setActionCommand("Load");
        buttonPanel.add(button5);
        JButton button6 = new JButton("Quit");
        button6.addActionListener(this::actionPerformed);
        button6.setActionCommand("Quit");
        buttonPanel.add(button6);
        frame.getContentPane().add(buttonPanel);
    }

    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Start")) {
            new GameMenu();
        } else if (action.equals("Squad")) {
            new TeamPanel();
        } else if (action.equals("Standing")) {
            new LeaguePanel();
        } else if (action.equals("Save")) {
            super.saveGame();
        } else if (action.equals("Load")) {
            super.loadGame();
        } else if (action.equals("Quit")) {
            System.exit(0);
        }
    }
}

