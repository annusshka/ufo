package com.company;

import java.awt.*;

public class UFO {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public UFO(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void drawHello(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        g.setColor(Color.WHITE);
        g.fillOval(this.x - this.width / 2, this.y - 3 * this.height / 2, this.width, this.height / 2);

        g.setColor(Color.BLACK);
        g.drawOval(this.x - this.width / 2, this.y - 3 * this.height / 2, this.width, this.height / 2);
        g.drawLine(this.x, this.y - this.height,
                this.x + this.width / 8, this.y - 8 * this.height / 9);
        g.drawString("Hello, aliens!", this.x - this.width / 3, this.y - 6 * this.height / 5);
    }

    public void draw(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        g.setColor(this.color);
        g.fillOval(this.x, this.y - this.height, this.width, this.height);
        g.fillOval(this.x - this.width / 4, this.y - 3 * this.height / 4, 3 * this.width / 2,
                this.height / 2);

        g.setColor(Color.BLACK);
        g.drawArc(this.x - this.width / 4, this.y - 3 * this.height / 4, 3 * this.width / 2,
                this.height / 2, 130, 280);
        g.drawArc(this.x, this.y - 3 * this.height / 4, this.width,
                this.height / 4, 160, 220);
    }
}
