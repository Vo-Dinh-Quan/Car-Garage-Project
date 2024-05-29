package View.panel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelTraCuu extends JPanel {
    private JTable table_danhsachxe;
    private JTextField textField_bienso_tracuu;

    public PanelTraCuu() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        JLabel label_tracuu = new JLabel("TRA CỨU XE");
        label_tracuu.setBounds(10, 38, 216, 27);
        label_tracuu.setHorizontalAlignment(SwingConstants.CENTER);
        label_tracuu.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(label_tracuu);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(231, 76, 587, 419);
        add(scrollPane);

        table_danhsachxe = new JTable();
        table_danhsachxe.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[]{
                        "Biển số xe", "Hiệu xe", "Mã khách hàng", "Tên khách hàng", "Ngày tiếp nhận", "Tiền nợ"
                }
        ));
        scrollPane.setViewportView(table_danhsachxe);

        JLabel label_hieuxe_tracuu = new JLabel("Hiệu xe:");
        label_hieuxe_tracuu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_hieuxe_tracuu.setBounds(10, 76, 216, 34);
        add(label_hieuxe_tracuu);

        JComboBox comboBox_hieuxe_tracuu = new JComboBox();
        comboBox_hieuxe_tracuu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        comboBox_hieuxe_tracuu.setBounds(10, 107, 216, 30);
        add(comboBox_hieuxe_tracuu);

        JLabel label_bienso_tracuu = new JLabel("Biển số: ");
        label_bienso_tracuu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_bienso_tracuu.setBounds(10, 148, 216, 34);
        add(label_bienso_tracuu);

        textField_bienso_tracuu = new JTextField();
        textField_bienso_tracuu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        textField_bienso_tracuu.setColumns(10);
        textField_bienso_tracuu.setBounds(10, 177, 216, 30);
        add(textField_bienso_tracuu);

        JButton button_timkiem_tracuu = new JButton("Tìm kiếm");
        button_timkiem_tracuu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_timkiem_tracuu.setBounds(10, 237, 216, 34);
        add(button_timkiem_tracuu);

        JButton button_lammoi_tracuu = new JButton("Làm mới");
        button_lammoi_tracuu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoi_tracuu.setBounds(10, 274, 216, 34);
        add(button_lammoi_tracuu);
    }
}
