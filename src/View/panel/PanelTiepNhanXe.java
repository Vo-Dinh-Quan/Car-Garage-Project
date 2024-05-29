package View.panel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelTiepNhanXe extends JPanel {
    private JTable table;
    private JTextField textField_tenkhachhangmoi;
    private JTextField textField_sodienthoai;
    private JTextField textField_diachi;
    private JTextField textField_bienso;
    private JTextField textField_thoigiantiepnhan;

    public PanelTiepNhanXe() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        JLabel label_themthongtinkhachhangvaxe = new JLabel("THÊM THÔNG TIN KHÁCH HÀNG VÀ XE");
        label_themthongtinkhachhangvaxe.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        label_themthongtinkhachhangvaxe.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label_themthongtinkhachhangvaxe.setBounds(10, 11, 395, 35);
        add(label_themthongtinkhachhangvaxe);

        JLabel label_danhsachxedatiepnhan = new JLabel("DANH SÁCH XE ĐÃ TIẾP NHẬN");
        label_danhsachxedatiepnhan.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        label_danhsachxedatiepnhan.setHorizontalAlignment(SwingConstants.CENTER);
        label_danhsachxedatiepnhan.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label_danhsachxedatiepnhan.setBounds(438, 11, 393, 35);
        add(label_danhsachxedatiepnhan);

        JScrollPane scrollPane_danhsachxedatipenhan = new JScrollPane();
        scrollPane_danhsachxedatipenhan.setBounds(438, 57, 393, 391);
        add(scrollPane_danhsachxedatipenhan);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[]{
                        "Biển số", "Tên hiệu xe", "Tên khách hàng", "Điện thoại", "Địa chỉ"
                }
        ));
        scrollPane_danhsachxedatipenhan.setViewportView(table);

        JLabel label_tenkhachhang = new JLabel("Tên khách hàng:");
        label_tenkhachhang.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_tenkhachhang.setBounds(10, 57, 130, 30);
        add(label_tenkhachhang);

        textField_tenkhachhangmoi = new JTextField();
        textField_tenkhachhangmoi.setBounds(141, 98, 264, 30);
        add(textField_tenkhachhangmoi);
        textField_tenkhachhangmoi.setColumns(10);

        JLabel label_tenkhachhangmoi = new JLabel("Tên khách hàng mới:");
        label_tenkhachhangmoi.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_tenkhachhangmoi.setBounds(10, 98, 130, 30);
        add(label_tenkhachhangmoi);

        JComboBox comboBox_tenkhachhang = new JComboBox();
        comboBox_tenkhachhang.setBounds(141, 57, 265, 30);
        add(comboBox_tenkhachhang);

        JLabel label_sodienthoai = new JLabel("Số điện thoại:");
        label_sodienthoai.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_sodienthoai.setBounds(10, 139, 130, 30);
        add(label_sodienthoai);

        textField_sodienthoai = new JTextField();
        textField_sodienthoai.setColumns(10);
        textField_sodienthoai.setBounds(141, 139, 264, 30);
        add(textField_sodienthoai);

        JLabel label_diachi = new JLabel("Địa chỉ:");
        label_diachi.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_diachi.setBounds(10, 180, 130, 30);
        add(label_diachi);

        textField_diachi = new JTextField();
        textField_diachi.setColumns(10);
        textField_diachi.setBounds(141, 180, 264, 30);
        add(textField_diachi);

        JLabel label_bienso = new JLabel("Biển số:");
        label_bienso.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_bienso.setBounds(10, 221, 130, 30);
        add(label_bienso);

        textField_bienso = new JTextField();
        textField_bienso.setColumns(10);
        textField_bienso.setBounds(141, 221, 264, 30);
        add(textField_bienso);

        JLabel label_hieuxe = new JLabel("Hiệu xe:");
        label_hieuxe.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_hieuxe.setBounds(10, 262, 130, 30);
        add(label_hieuxe);

        JComboBox comboBox_hieuxe = new JComboBox();
        comboBox_hieuxe.setBounds(140, 262, 265, 30);
        add(comboBox_hieuxe);

        JLabel label_thoigiantiepnhan = new JLabel("Thời gian tiếp nhận:");
        label_thoigiantiepnhan.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_thoigiantiepnhan.setBounds(10, 303, 130, 30);
        add(label_thoigiantiepnhan);

        textField_thoigiantiepnhan = new JTextField();
        textField_thoigiantiepnhan.setColumns(10);
        textField_thoigiantiepnhan.setBounds(141, 303, 264, 30);
        add(textField_thoigiantiepnhan);

        JButton button_lammoibang_tiepnhanxe = new JButton("Làm mới bảng");
        button_lammoibang_tiepnhanxe.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoibang_tiepnhanxe.setBounds(438, 460, 130, 35);
        add(button_lammoibang_tiepnhanxe);

        JButton button_luu_tiepnhanxe = new JButton("Lưu");
        button_luu_tiepnhanxe.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_luu_tiepnhanxe.setBounds(10, 413, 89, 35);
        add(button_luu_tiepnhanxe);

        JButton button_luumoi_tiepnhanxe = new JButton("Lưu mới");
        button_luumoi_tiepnhanxe.setFont(new Font("Tahoma", Font.BOLD, 11));
        button_luumoi_tiepnhanxe.setBounds(109, 413, 89, 35);
        add(button_luumoi_tiepnhanxe);

        JButton button_sua_tiepnhanxe = new JButton("Sửa");
        button_sua_tiepnhanxe.setFont(new Font("Tahoma", Font.BOLD, 11));
        button_sua_tiepnhanxe.setBounds(217, 413, 89, 35);
        add(button_sua_tiepnhanxe);

        JButton button_xoa_tiepnhanxe = new JButton("Xóa");
        button_xoa_tiepnhanxe.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_xoa_tiepnhanxe.setBounds(316, 413, 89, 35);
        add(button_xoa_tiepnhanxe);

        JButton button_lammoi = new JButton("Làm mới");
        button_lammoi.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoi.setBounds(316, 344, 89, 35);
        add(button_lammoi);
    }
}