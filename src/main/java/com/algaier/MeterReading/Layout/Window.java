package com.algaier.MeterReading.Layout;

import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Layout.Components.MenuBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends JFrame {
    private MenuBar menuBar;
    private static final String WINDOWNAME = "Meter Reading";
    private static final String BACKGROUNDCOLOR_CODE = "#2b2d30";
    private static final Color BACKGROUNDCOLOR = Color.decode(BACKGROUNDCOLOR_CODE);
    private ImageIcon iconPath = new ImageIcon("src/main/resources/img/counter.png");
    private DBConnect dbConnection;

    public Window(int posX, int posY) {
        super(WINDOWNAME);

        menuBar = new MenuBar();
        menuBar.createMenuBar(this);

        setSize(posX, posY);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(BACKGROUNDCOLOR);
        setIconImage(iconPath.getImage());
    }

    public void setDbConnection(DBConnect dbConnection){
        this.dbConnection = dbConnection;
    }

    public static void closeWindow(DBConnect dbConnection){
        dbConnection.closeDbConneciton();
        System.exit(0);
    }

    public void close() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(Window.this, "Möchten Sie das Programm wirklich beenden?", "Beenden", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    dbConnection.closeDbConneciton();
                    System.exit(0);
                }
            }
        });
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}