package com.algaier.MeterReading.Layout.Design;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class PasswordFieldCustom extends JPasswordField{
    private static List<PasswordFieldCustom> allPasswordFields = new ArrayList<>();

    private boolean mouseOver = false;
    private boolean mouseClicked = false;
    private boolean checkClick = false;

    private Color lineColor = new Color(211,211,211);
    private Color lineColorClicked = new Color(3, 155, 216);

    public PasswordFieldCustom() {
        setBorder(new EmptyBorder(0, 0, 2, 0));
        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                mouseOver = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent me) {
                mouseOver = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent me) {

                for (PasswordFieldCustom textField : allPasswordFields) {
                    textField.setMouseClicked(false);
                    textField.repaint();
                }

                setMouseClicked(true);
                setMouseOver(false);
                checkClick = true;
                repaint();

            }
        });
        allPasswordFields.add(this);
    }

    private void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    private void setMouseClicked(boolean mouseClicked) {
        this.mouseClicked = mouseClicked;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR);

        int width = getWidth();
        int height = getHeight();

        if (mouseOver) {
            g2.setColor(Color.GRAY);
        } else if (mouseClicked) {
            g2.setColor(lineColorClicked);
        } else {
            g2.setColor(lineColor);
        }

        g2.fillRect(0, height - 2, width, 2);
        g2.dispose();
    }


}