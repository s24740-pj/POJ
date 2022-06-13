package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

import static java.lang.Thread.sleep;

public class Pipe extends JPanel implements ActionListener {

    public BufferedImage image;

    Timer t = new Timer(40, this);

    private int x = 100;
    private int y = -1200;
    private int gap = 800;

    private int i = 1;

    static private int PosX;
    static private int PosY;

    public String Start = " ";

    public static boolean GravityOn = false;

    public Pipe(int pos) {
        super();
        this.x = pos;

        Random rand = new Random();
        this.y = rand.nextInt(-150 - -1200) + -1200;

        File imageFile = new File("src/tekstury/pipe.jpg");

        try {
            image = ImageIO.read(imageFile);

        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }

        Dimension dimension = new Dimension(1080, 1000);
        setPreferredSize(dimension);

        t.start();
    }

    public static int GetXPipe(){
        return PosX;
    }

    public static int GetYPipe(){
        return PosY;
    }


    public static void Start(boolean On){
        GravityOn = On;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.scale(0.4,0.4);

        Font font = new Font("Comic Sans MS", Font.BOLD, 60);
        g2d.setFont( font );
        g2d.drawString(Start, 200, 200);

        setOpaque(false);

        int topY = this.y;
        int topX = this.y+gap+image.getHeight();

        g2d.drawImage(image, this.x, topY, this);
        g2d.drawImage(image, this.x, topX, this);
        g2d.dispose();
        Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
        setPreferredSize(dimension);

        if(this.x<-image.getWidth()){
            this.x = 3000-image.getWidth();
            Random rand = new Random();
            int next_pipe = rand.nextInt(-150 - -1200) + -1200;
            this.y = next_pipe;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(GravityOn){
            this.x-=20;
            PosX = this.x;
            PosY = this.y;
            i = 0;
            ScoreUI.Pause(" ", " ");
        }else{
            for(i = i; i<1; i++){
                ScoreUI.Pause("Press left mouse to play!", "Your highscore is: ");
                this.x = this.x + 2000 - PosX;
                Random rand = new Random();
                int next_pipe = rand.nextInt(-150 - -1200) + -1200;
                this.y = next_pipe;
            }
        }
        repaint();
    }
}