package View.panel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelLapPhieuSuaChua extends JPanel {
    private JTable table_vattuphutung;
    private JTable table_phieusuachuahienco;
    private JTable table_tiencong;
    private JTextField textField_soluong;
    private JTextField textField_ngaysuachua;
    private JTextField textField_tentiencong;
    private JTextField textField_tongtien;

    public PanelLapPhieuSuaChua() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        JLabel label_lapphieusuachua = new JLabel("LẬP PHIẾU SỬA CHỮA");
        label_lapphieusuachua.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        label_lapphieusuachua.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label_lapphieusuachua.setHorizontalAlignment(SwingConstants.CENTER);
        label_lapphieusuachua.setBounds(198, 0, 395, 35);
        add(label_lapphieusuachua);

        JScrollPane scrollPane_table_vattuphutung = new JScrollPane();
        scrollPane_table_vattuphutung.setBounds(10, 175, 465, 98);
        add(scrollPane_table_vattuphutung);

        table_vattuphutung = new JTable();
        table_vattuphutung.setFont(new Font("Segoe UI", Font.BOLD, 11));
        table_vattuphutung.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[]{
                        "STT", "Mã phụ tùng", "Vật tư phụ tùng", "Số lượng", "Đơn giá", "Thành tiền"
                }
        ));
        scrollPane_table_vattuphutung.setViewportView(table_vattuphutung);

        JScrollPane scrollPane_phieusuachuahienco = new JScrollPane();
        scrollPane_phieusuachuahienco.setBounds(10, 363, 821, 141);
        add(scrollPane_phieusuachuahienco);

        table_phieusuachuahienco = new JTable();
        table_phieusuachuahienco.setFont(new Font("Segoe UI", Font.BOLD, 11));
        table_phieusuachuahienco.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Mã phiếu sửa chữa", "Biển số xe", "Ngày nhận sửa", "Thành tiền"
                }
        ));
        scrollPane_phieusuachuahienco.setViewportView(table_phieusuachuahienco);

        JLabel label_phieusuachuahienco = new JLabel("PHIẾU SỬA CHỮA HIỆN CÓ");
        label_phieusuachuahienco.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        label_phieusuachuahienco.setHorizontalAlignment(SwingConstants.CENTER);
        label_phieusuachuahienco.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label_phieusuachuahienco.setBounds(198, 325, 395, 35);
        add(label_phieusuachuahienco);

        JLabel label_biensoxe = new JLabel("Biển số xe:");
        label_biensoxe.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_biensoxe.setBounds(10, 53, 75, 29);
        add(label_biensoxe);

        JScrollPane scrollPane_table_tiencong = new JScrollPane();
        scrollPane_table_tiencong.setBounds(485, 175, 346, 98);
        add(scrollPane_table_tiencong);

        table_tiencong = new JTable();
        table_tiencong.setFont(new Font("Segoe UI", Font.BOLD, 11));
        table_tiencong.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                },
                new String[]{
                        "STT", "Mã tiền công", "Nội dung", "Chi phí"
                }
        ));
        scrollPane_table_tiencong.setViewportView(table_tiencong);

        JComboBox comboBox_biensoxe = new JComboBox();
        comboBox_biensoxe.setBounds(90, 52, 265, 30);
        add(comboBox_biensoxe);

        JLabel label_VTPT = new JLabel("VTPT:");
        label_VTPT.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_VTPT.setBounds(10, 93, 75, 29);
        add(label_VTPT);

        JComboBox comboBox_VTPT = new JComboBox();
        comboBox_VTPT.setBounds(90, 93, 265, 30);
        add(comboBox_VTPT);

        JLabel label_soluong = new JLabel("Số lượng:");
        label_soluong.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_soluong.setBounds(10, 135, 75, 29);
        add(label_soluong);

        textField_soluong = new JTextField();
        textField_soluong.setColumns(10);
        textField_soluong.setBounds(91, 134, 264, 30);
        add(textField_soluong);

        JButton button_nhapvtpt = new JButton("Nhập VTPT");
        button_nhapvtpt.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_nhapvtpt.setBounds(369, 50, 106, 35);
        add(button_nhapvtpt);

        JLabel label_ngaysuachua = new JLabel("Ngày sửa chữa:");
        label_ngaysuachua.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_ngaysuachua.setBounds(485, 53, 86, 29);
        add(label_ngaysuachua);

        textField_ngaysuachua = new JTextField();
        textField_ngaysuachua.setColumns(10);
        textField_ngaysuachua.setBounds(581, 52, 250, 30);
        add(textField_ngaysuachua);

        JLabel label_tentiencong = new JLabel("Tên tiền công:");
        label_tentiencong.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_tentiencong.setBounds(485, 93, 86, 29);
        add(label_tentiencong);

        textField_tentiencong = new JTextField();
        textField_tentiencong.setColumns(10);
        textField_tentiencong.setBounds(581, 92, 250, 30);
        add(textField_tentiencong);

        JButton button_nhaptiencong = new JButton("Nhập tiền công");
        button_nhaptiencong.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_nhaptiencong.setBounds(698, 129, 133, 35);
        add(button_nhaptiencong);

        JButton button_hoantat = new JButton("Hoàn tất");
        button_hoantat.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_hoantat.setBounds(10, 284, 106, 35);
        add(button_hoantat);

        JLabel label_tongtien = new JLabel("Tổng tiền:");
        label_tongtien.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_tongtien.setBounds(125, 284, 58, 35);
        add(label_tongtien);

        textField_tongtien = new JTextField();
        textField_tongtien.setColumns(10);
        textField_tongtien.setBounds(186, 284, 289, 35);
        add(textField_tongtien);

        JButton button_luu = new JButton("Lưu");
        button_luu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_luu.setBounds(725, 284, 106, 35);
        add(button_luu);

        JButton button_nhapphieumoi = new JButton("Nhập phiếu mới");
        button_nhapphieumoi.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_nhapphieumoi.setBounds(548, 284, 133, 35);
        add(button_nhapphieumoi);
    }
}