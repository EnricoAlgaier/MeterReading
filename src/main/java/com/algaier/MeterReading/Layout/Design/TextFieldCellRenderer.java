package com.algaier.MeterReading.Layout.Design;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TextFieldCellRenderer extends DefaultTableCellRenderer{
    private static final long serialVersionUID = 1001L;
    protected Color color1 = new Color(55, 55, 55);
    protected Color color2 = new Color(31, 31, 31);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {

        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (row % 2 == 0) {
            component.setBackground(color1);
        } else {
            component.setBackground(color2);
        }

        component.setForeground(Color.WHITE);
        return component;
    }
}