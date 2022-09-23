package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class DrawPanel extends JPanel implements ActionListener {

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final int TIMER_DELAY;
    private Timer timer;
    private int ticksFromStart = 0;

    private Planet planet1, planet2;
    private Star star;
    private ArrayList<Star> stars;
    private Rocket rocket;
    private UFO ufo;
    private Random random = new Random();

    public DrawPanel(final int width, final int height, final int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TIMER_DELAY = timerDelay;
        timer = new Timer(TIMER_DELAY, this);
        timer.start();

        this.planet1 = new Planet(100, 350, 200, 200, new Color(43, 127, 224));
        this.stars = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            this.star = new Star(random.nextInt(PANEL_WIDTH), random.nextInt(PANEL_HEIGHT),
                    5, 10, 8);
            stars.add(star);
        }
        int y = planet1.getY();
        int x = (int) (planet1.getX() + 0.5 * planet1.getWidth());
        this.rocket = new Rocket(x, y, 25, 50, false);
        this.planet2 = new Planet(PANEL_WIDTH, 0, 100, 100, new Color(138, 18, 18));
        this.ufo = new UFO(PANEL_WIDTH, y + rocket.getHeight() / 2, 100, 100, new Color(45, 169, 26));
    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        for (Star star1 : stars) {
            star1.draw(gr);
        }
        planet1.setY(350 + ticksFromStart);
        if (ticksFromStart > 100) {
            int xPlanet = planet1.getX() - 2;
            planet1.setX(xPlanet);
            int xRocket = rocket.getX();
            rocket.setX(++xRocket);
            rocket.setPosition(true);
            planet2.setX(PANEL_WIDTH + 2 * 100 - 2 * ticksFromStart);
            planet2.draw(gr);
        }
        planet1.draw(gr);
        rocket.draw(gr);
        if (ticksFromStart > 300) {
            ufo.setX(PANEL_WIDTH + 300 - ticksFromStart);
            ufo.draw(gr);
            if (ticksFromStart > 400 && ticksFromStart < 470) {
                ufo.drawHello(gr);
            }
        }
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ++ticksFromStart;
        }
    }
}
