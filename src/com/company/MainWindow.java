package com.company;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final DrawPanel panel;

    public MainWindow(int width, int height) throws HeadlessException {
        this.setSize(width, height);
        panel = new DrawPanel(width, height, 100);
        panel.setBackground(new Color(14, 18, 232));
        this.add(panel);
    }
}
