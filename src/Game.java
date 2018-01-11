import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Game {
    public static void main(String [] args) {

            JFrame myWindow = new JFrame("Snake menu");
            myWindow.setLayout(null);
            myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myWindow.setSize(270, 240);
            myWindow.setVisible(true);

            final JButton GO = new JButton("Start game");
            GO.setLocation(30, 30);
            GO.setSize(200, 40);
            myWindow.add(GO);
            GO.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent event) {//Start the game
                    MainWindow MW1 = new MainWindow("ssnake!!!");
                    MW1.setVisible(true);
                }
            });


            final JButton exit = new JButton("Exit");
            exit.setLocation(30, 100);
            exit.setSize(200, 40);
            myWindow.add(exit);

            exit.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent event) {
                    JOptionPane.showMessageDialog(exit, "Goodbye!", "", JOptionPane.WARNING_MESSAGE);
                    System.exit(0);
                }
            });
        }


    }

