package Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.text.NumberFormat;

public class CurrencyRenderer extends DefaultTableCellRenderer {
    private final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    @Override
    protected void setValue(Object value) {
        if (value != null) {
            double doubleValue = (double) value;
            setText(currencyFormat.format(doubleValue));
        } else {
            setText("");
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (isSelected) {
            c.setBackground(table.getSelectionBackground());
            c.setForeground(table.getSelectionForeground());
        } else {
            c.setBackground(table.getBackground());
            c.setForeground(table.getForeground());
        }
        setHorizontalAlignment(RIGHT);
        return c;
    }
    private double parseCurrency(String currencyStr) {
        try {
            // Loại bỏ các ký tự không phải số và dấu chấm
            String cleanStr = currencyStr.replaceAll("[^\\d,]", "").replace(",", ".");
            return Double.parseDouble(cleanStr);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
