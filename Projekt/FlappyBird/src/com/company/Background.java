package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background extends JPanel {

    public BufferedImage image;

    public Background() {
        super();

        File imageFile = new File("src/tekstury/background.png");

        try {
            image = ImageIO.read(imageFile);

        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }

        Dimension dimension = new Dimension(1080, 1000);
        setPreferredSize(dimension);

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        setOpaque(false);

        g2d.drawImage(image, 0, 0, this);
    }



}