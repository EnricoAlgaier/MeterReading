package com.algaier.MeterReading.Layout;

import com.algaier.MeterReading.Layout.Components.MenuBar;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private MenuBar menuBar;
    private static final String WINDOWNAME = "Meter Reading";
    private static final String BACKGROUNDCOLOR_CODE = "#2b2d30";
    private static final Color BACKGROUNDCOLOR = Color.decode(BACKGROUNDCOLOR_CODE);
    private ImageIcon iconPath = new ImageIcon("src/main/resources/img/counter.png");

    public Window(int posX, int posY){
        super(WINDOWNAME);
        menuBar = new MenuBar();
        menuBar.createMenuBar(this);

        setSize(posX, posY);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(BACKGROUNDCOLOR);
        setIconImage(iconPath.getImage());
    }
}
