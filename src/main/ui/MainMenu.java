package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenu extends FirstMenu {

    private JFrame frame;



    public MainMenu() {
        frame = new JFrame();
        frame.setTitle("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));

        // Create and add buttons to the content pane
        addButtons();

        // Pack the frame and make it visible
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private void addButtons() {
        // Create the container to hold the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 6, 10, 10));
        // The GridLayout will create a 1x12 grid with 10-pixel horizontal and vertical gaps

        // Add buttons to the panel
        JButton button1 = new JButton("StartGame");
        button1.setPreferredSize(new Dimension(40, 40));
        button1.addActionListener(this::actionPerformed);
        button1.setActionCommand("Start");
        buttonPanel.add(button1);
        JButton button2 = new JButton("Squad");
        button2.setPreferredSize(new Dimension(40, 40));
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
        button5.addActionListener(this::actionPerformed);
        button5.setActionCommand("Quit");
        buttonPanel.add(button6);



        // Add the panel to the frame's content pane
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

