package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// citation: https://docs.oracle.com/javase/tutorial/uiswing/

// EFFECTS:Constructs MainMenu based on FirstMenu Class
public class MainMenu extends FirstMenu {

    private JFrame frame;

    //MODIFIES: this
    // EFFECTS: constructs new frame in JFrame
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

    //MODIFIES: this
    //EFFECTS: Add buttons to the frame
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void addButtons() {
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));

        ImageIcon img = imageProccesor("data/Soccer-Ball.jpeg");
        JButton button1 = new JButton("start game");
        button1.setIcon(img);
        button1.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent me) {
                button1.setIcon(null);
                button1.setText("Start game");
            }

            public void mouseExited(MouseEvent me) {
                button1.setIcon(img);
            }
        });
        button1.addActionListener(this::actionPerformed);
        button1.setActionCommand("Start");
        buttonPanel.add(button1);

        ImageIcon img1 = imageProccesor("data/Squad-image.png");
        JButton button2 = new JButton("Squad");
        button2.setIcon(img1);
        button2.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent me) {
                button2.setIcon(null);
                button2.setText("Squad"); // change the color to green when mouse over a button
            }

            public void mouseExited(MouseEvent me) {
                button2.setIcon(img1);
            }
        });
        button2.addActionListener(this::actionPerformed);
        button2.setActionCommand("Squad");
        buttonPanel.add(button2);
        ImageIcon img2 = imageProccesor("data/Cup-image.jpeg");
        JButton button3 = new JButton("Standing");
        button3.setIcon(img2);
        button3.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent me) {
                button3.setIcon(null);
                button3.setText("Standing"); // change the color to green when mouse over a button
            }

            public void mouseExited(MouseEvent me) {
                button3.setIcon(img2);
            }
        });
        button3.addActionListener(this::actionPerformed);
        button3.setActionCommand("Standing");
        buttonPanel.add(button3);
        ImageIcon img3 = imageProccesor("data/Save.png");
        JButton button4 = new JButton("Save");
        button4.setIcon(img3);
        button4.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent me) {
                button4.setIcon(null);
                button4.setText("Save"); // change the color to green when mouse over a button
            }

            public void mouseExited(MouseEvent me) {
                button4.setIcon(img3);
            }
        });
        button4.addActionListener(this::actionPerformed);
        button4.setActionCommand("Save");
        buttonPanel.add(button4);
        ImageIcon img4 = imageProccesor("data/load-image.jpeg");
        JButton button5 = new JButton("Load");
        button5.setIcon(img4);
        button5.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent me) {
                button5.setIcon(null);
                button5.setText("Load"); // change the color to green when mouse over a button
            }

            public void mouseExited(MouseEvent me) {
                button5.setIcon(img4);
            }
        });
        button5.addActionListener(this::actionPerformed);
        button5.setActionCommand("Load");
        buttonPanel.add(button5);
        ImageIcon img5 = imageProccesor("data/exit.jpeg");
        JButton button6 = new JButton("Quit");
        button6.setIcon(img5);
        button6.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent me) {
                button6.setIcon(null);
                button6.setText("Quit"); // change the color to green when mouse over a button
            }

            public void mouseExited(MouseEvent me) {
                button6.setIcon(img5);
            }
        });
        button6.addActionListener(this::actionPerformed);
        button6.setActionCommand("Quit");
        buttonPanel.add(button6);
        frame.getContentPane().add(buttonPanel);
    }


    //EFFECTS: NAVIGATE THE BUTTONS TO DIFFERENT FRAMES
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

    //EFFECTS: PREPROCESS IMAGE TO BE ADDED AS THE ICON OF Buttons
    private ImageIcon imageProccesor(String source) {
        ImageIcon img2 = new ImageIcon(source);
        Image image2 = img2.getImage();
        Image newImg2 = image2.getScaledInstance(220, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        img2 = new ImageIcon(newImg2);
        return img2;

    }
}

