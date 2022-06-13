package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game extends JFrame implements ActionListener {

    public Game() {
        super("Flappy Bird");

        setSize(1080, 1000);

        setLayout(new FlowLayout(FlowLayout.CENTER, -1080,0));
        myMouseListener mml = new myMouseListener();
        addMouseListener(mml);
        addKeyListener(mml);

        add(new ScoreUI());

        add(new Pipe(2000));
        add(new Pipe(3000));
        add(new Pipe(4000));

        add(new Bird());

        add(new Background());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void OverallStart(boolean On){
        Bird.Start(On);
        Pipe.Start(On);
    }

}
