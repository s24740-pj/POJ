package com.company;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird extends JPanel implements ActionListener {

    public BufferedImage image;

    Timer t = new Timer(40, this);

    private int x = 200;
    private int y = 1000;

    private int accelerateY = 40;

    private static int posY = 1000;

    private static int rotation = 25;


    public static boolean GravityOn = false;

    public Bird() {
        super();
        File imageFile = new File("src/tekstury/bird.png");

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

    public static void SetYBird(int add){
        posY -= add;
        rotation = -25;
    }

    public static int GetYBird(){
        return posY;
    }

    public static void Start(boolean On){
        GravityOn = On;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(0.4,0.4);

        setOpaque(false);
        this.y = posY;

        g2d.rotate(Math.toRadians(rotation), this.x+image.getWidth()/2, this.y+image.getHeight()/2);

        g2d.drawImage(image, this.x, this.y, this);
        g2d.dispose();

        if(GravityOn){
            if(this.x+image.getWidth() > Pipe.GetXPipe() && this.x-image.getWidth()+100 < Pipe.GetXPipe()){
                if(this.y+image.getHeight() > Pipe.GetYPipe()+2300 || this.y < Pipe.GetYPipe()+1500){
//                  System.out.println("HIT");
                    posY = 1000;
                    ScoreUI.CheckIfHighScore();
                    Game.OverallStart(false);
                }else if(this.x > Pipe.GetXPipe()){
//                    System.out.println("POINT,after");
                    ScoreUI.AddScore(1);
                }else if(this.x > Pipe.GetXPipe()-250){
//                    System.out.println("POINT");
                    ScoreUI.AddScore(0);
                }
            }
        }
    }

    public void Gravity(boolean GravityOn){
        if(GravityOn){
            posY += this.accelerateY;
            if(rotation >= -25 && rotation <= 25){
                rotation += 10;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Gravity(GravityOn);
        repaint();
    }


}