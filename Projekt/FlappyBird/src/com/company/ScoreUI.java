package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScoreUI extends JPanel implements ActionListener {

    public static int Score;
    public static int Highscore;

    public static String Press = "Press left mouse to play!";
    public static String YourHighScore = " ";

    public static int Score_Position = -60;
    public static int Highscore_Position = -150;

    public static int ScoreSystem1=0;

    public ScoreUI() {
        super();
        Dimension dimension = new Dimension(1080, 1000);
        setPreferredSize(dimension);
    }

    public static void AddScore(int ScoreSystem){
        ScoreSystem1 += ScoreSystem;
        if(ScoreSystem == 0){
            ScoreSystem1 = ScoreSystem;
        }
        if(ScoreSystem1 == 3){
            Score += 1;
        }
    }

    public static void CheckIfHighScore(){
        if(Highscore < Score){
            Highscore = Score;
        }
        Score = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Font font = new Font("Comic Sans MS", Font.BOLD, 60);
        g2d.setFont( font );
        g2d.drawString("Highscore: "+Highscore, 30, Score_Position);
        g2d.drawString("Score: "+Score, 30, Highscore_Position);

        g2d.drawString(Press, 200, 500);
        g2d.drawString(YourHighScore, 200, 600);

        setOpaque(false);

    }

    public static void Pause(String Pause_T, String HighScore_T){
        Press = Pause_T;
        Score_Position = 60;

        if(HighScore_T == " "){
            YourHighScore = " ";
            Highscore_Position = 150;
        }else{
            YourHighScore = HighScore_T + Highscore;
            Score_Position = -60;
            Highscore_Position = -150;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}