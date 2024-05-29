package View.panel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelQuanLyVTPT extends JPanel {
    private JTable table_danhsachphieunhap;
    private JTable table_danhsachvtpt;

    public PanelQuanLyVTPT() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        JLabel label_danhsachphieunhap = new JLabel("DANH SÁCH PHIẾU NHẬP");
        label_danhsachphieunhap.setHorizontalAlignment(SwingConstants.CENTER);
        label_danhsachphieunhap.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label_danhsachphieunhap.setBounds(10, 174, 350, 27);
        add(label_danhsachphieunhap);

        JLabel label_danhsachvtpt = new JLabel("DANH SÁCH VẬT TƯ PHỤ TÙNG");
        label_danhsachvtpt.setHorizontalAlignment(SwingConstants.CENTER);
        label_danhsachvtpt.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label_danhsachvtpt.setBounds(387, 174, 444, 27);
        add(label_danhsachvtpt);

        JButton button_lapphieuvtpt = new JButton("Lập phiếu nhập VTPT");
        button_lapphieuvtpt.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lapphieuvtpt.setBounds(21, 23, 188, 46);
        add(button_lapphieuvtpt);

        JScrollPane scrollPane_danhsachphieunhap = new JScrollPane();
        scrollPane_danhsachphieunhap.setBounds(10, 259, 350, 236);
        add(scrollPane_danhsachphieunhap);

        table_danhsachphieunhap = new JTable();
        table_danhsachphieunhap.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                },
                new String[]{
                        "Mã phiếu", "Thành tiền", "Thời điểm"
                }
        ));
        scrollPane_danhsachphieunhap.setViewportView(table_danhsachphieunhap);

        JScrollPane scrollPane_danhsachvtpt = new JScrollPane();
        scrollPane_danhsachvtpt.setBounds(387, 259, 444, 236);
        add(scrollPane_danhsachvtpt);

        table_danhsachvtpt = new JTable();
        table_danhsachvtpt.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                },
                new String[]{
                        "Tên VTPT", "Đơn giá nhập", "Đơn giá bán", "Số lượng"
                }
        ));
        scrollPane_danhsachvtpt.setViewportView(table_danhsachvtpt);

        JButton button_xoavtpt = new JButton("Xóa VTPT");
        button_xoavtpt.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_xoavtpt.setBounds(708, 212, 123, 36);
        add(button_xoavtpt);

        JButton button_lammoi_danhsachvtpt = new JButton("Làm mới");
        button_lammoi_danhsachvtpt.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoi_danhsachvtpt.setBounds(387, 212, 113, 36);
        add(button_lammoi_danhsachvtpt);

        JButton button_lammoi_danhsachphieunhap = new JButton("Làm mới");
        button_lammoi_danhsachphieunhap.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoi_danhsachphieunhap.setBounds(10, 212, 113, 36);
        add(button_lammoi_danhsachphieunhap);
    }
}
