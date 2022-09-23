package com.company;

import java.awt.*;

public class Rocket {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isHorizontal;

    public Rocket(int x, int y, int width, int height, boolean isHorizontal) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isHorizontal = isHorizontal;
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

    public void setPosition(boolean isHorizontal) {
        this.isHorizontal = isHorizontal;
    }

    public boolean getPosition() {
        return this.isHorizontal;
    }

    void draw(final Graphics gr) {
        if (!getPosition()) {
            drawVertically(gr);
        } else {
            drawHorizontally(gr);
        }
    }

    void drawVertically(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        //tail
        int[] xPoints = {this.x, this.x + this.width / 2, this.x + this.width};
        int[] yPoints = {this.y, this.y - this.height / 2, this.y};
        Polygon poly = new Polygon(xPoints, yPoints, 3);
        g.setColor(Color.orange);
        g.drawPolygon(poly);
        g.fillPolygon(poly);

        //rocket
        g.setColor(Color.GRAY);
        g.fillOval(this.x, this.y - this.height, this.width, this.height);

        //window
        g.setColor(Color.CYAN);
        g.fillOval(this.x + this.width / 4, this.y - 4 * this.height / 5, this.width / 2, this.width / 2);

        //fire
        g.setColor(Color.RED);
        int[] xPointsF = {this.x + 2 * this.width / 7, this.x + this.width / 5, this.x + 2 * this.width / 5,
                this.x + 4 * this.width / 7, this.x + 2 * this.width / 3, this.x + 3 * this.width / 4,
                this.x + 5 * this.width / 7};
        int[] yPointsF = {this.y, this.y + 7, this.y + 3, this.y + 10, this.y + 4, this.y + 6, this.y};
        Polygon poly2 = new Polygon(xPointsF, yPointsF, 7);
        g.drawPolygon(poly2);
        g.fillPolygon(poly2);
    }

    void drawHorizontally(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        //tail
        int[] xPoints = {this.x, this.x + this.height / 2, this.x};
        int[] yPoints = {this.y, this.y - this.width / 2, this.y - this.width};
        Polygon poly = new Polygon(xPoints, yPoints, 3);
        g.setColor(Color.orange);
        g.drawPolygon(poly);
        g.fillPolygon(poly);

        //rocket
        g.setColor(Color.GRAY);
        g.fillOval(this.x, this.y - this.width, this.height, this.width);

        //window
        g.setColor(Color.CYAN);
        g.fillOval(this.x + 3 * this.height / 5, this.y - 3 * this.width / 4,
                this.width / 2, this.width / 2);

        //fire
        g.setColor(Color.RED);
        int[] xPointsF = {this.x, this.x - 6, this.x - 4, this.x - 10, this.x - 3, this.x - 7, this.x};
        int[] yPointsF = {this.y - 2 * this.width / 7, this.y - this.width / 5, this.y - 2 * this.width / 5,
                this.y - 4 * this.width / 7, this.y - 2 * this.width / 3, this.y - 3 * this.width / 4,
                this.y - 5 * this.width / 7};
        Polygon poly2 = new Polygon(xPointsF, yPointsF, 7);
        g.drawPolygon(poly2);
        g.fillPolygon(poly2);
    }
}
