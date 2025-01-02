package com.algaier.MeterReading.Layout.Components;

import com.algaier.MeterReading.Layout.Window;

import javax.swing.*;

public class MenuBar {

    public void createMenuBar(Window window) {
        JMenuBar menuBar = new JMenuBar();

        JMenu dateiMenu = new JMenu("Datei");
        JMenu bearbeitenMenu = new JMenu("Bearbeiten");
        JMenu hilfeMenu = new JMenu("Hilfe");

        JMenuItem neuItem = new JMenuItem("Neu");
        JMenuItem oeffnenItem = new JMenuItem("Öffnen");
        JMenuItem speichernItem = new JMenuItem("Speichern");
        JMenuItem beendenItem = new JMenuItem("Beenden");

        dateiMenu.add(neuItem);
        dateiMenu.add(oeffnenItem);
        dateiMenu.add(speichernItem);
        dateiMenu.addSeparator();
        dateiMenu.add(beendenItem);

        bearbeitenMenu.add(new JMenuItem("Rückgängig"));
        bearbeitenMenu.add(new JMenuItem("Wiederholen"));
        bearbeitenMenu.add(new JMenuItem("Ausschneiden"));
        bearbeitenMenu.add(new JMenuItem("Kopieren"));
        bearbeitenMenu.add(new JMenuItem("Einfügen"));

        hilfeMenu.add(new JMenuItem("Über"));

        menuBar.add(dateiMenu);
        menuBar.add(bearbeitenMenu);
        menuBar.add(hilfeMenu);

        window.setJMenuBar(menuBar);
    }
}