package View.panel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class PanelTiepNhanXe extends JPanel {
    private JTextField textField_tenkhachhangmoi;
    private JTextField textField_sodienthoai;
    private JTextField textField_diachi;
    private JTextField textField_bienso;
    private JTextField textField_thoigiantiepnhan;
    private JTable table;

    public PanelTiepNhanXe() {
        setBackground(new Color(255, 255, 255));
        setLayout(null);

        JLabel label_themthongtinkhachhangvaxe = new JLabel("THÊM THÔNG TIN KHÁCH HÀNG VÀ XE");
        label_themthongtinkhachhangvaxe.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        label_themthongtinkhachhangvaxe.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label_themthongtinkhachhangvaxe.setBounds(10, 11, 395, 35);
        add(label_themthongtinkhachhangvaxe);

        JLabel label_danhsachxedatiepnhan = new JLabel("DANH SÁCH XE ĐÃ TIẾP NHẬN");
        label_danhsachxedatiepnhan.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        label_danhsachxedatiepnhan.setHorizontalAlignment(SwingConstants.CENTER);
        label_danhsachxedatiepnhan.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label_danhsachxedatiepnhan.setBounds(438, 11, 416, 35);
        add(label_danhsachxedatiepnhan);

        JScrollPane scrollPane_table_danhsachxedatiepnhan = new JScrollPane();
        scrollPane_table_danhsachxedatiepnhan.setBounds(438, 57, 416, 391);
        add(scrollPane_table_danhsachxedatiepnhan);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[]{
                        "Biển số", "Hiệu xe", "Khách hàng", "Điện thoại", "Địa chỉ"
                }
        ));

// Điều chỉnh kích thước của cột "Khách hàng"
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(2).setPreferredWidth(150); // Điều chỉnh kích thước chiều ngang của cột "Khách hàng" (index 2)

        scrollPane_table_danhsachxedatiepnhan.setViewportView(table);

        JLabel label_tenkhachhang = new JLabel("Tên khách hàng:");
        label_tenkhachhang.setBounds(10, 57, 130, 30);
        add(label_tenkhachhang);

        textField_tenkhachhangmoi = new JTextField();
        textField_tenkhachhangmoi.setBounds(141, 98, 264, 30);
        add(textField_tenkhachhangmoi);
        textField_tenkhachhangmoi.setColumns(10);

        JLabel label_tenkhachhangmoi = new JLabel("Tên khách hàng mới:");
        label_tenkhachhangmoi.setBounds(10, 98, 130, 30);
        add(label_tenkhachhangmoi);

        JComboBox comboBox_tenkhachhang = new JComboBox();
        comboBox_tenkhachhang.setBounds(141, 57, 265, 30);
        add(comboBox_tenkhachhang);

        JLabel label_sodienthoai = new JLabel("Số điện thoại:");
        label_sodienthoai.setBounds(10, 139, 130, 30);
        add(label_sodienthoai);

        textField_sodienthoai = new JTextField();
        textField_sodienthoai.setColumns(10);
        textField_sodienthoai.setBounds(141, 139, 264, 30);
        add(textField_sodienthoai);

        JLabel label_diachi = new JLabel("Địa chỉ:");
        label_diachi.setBounds(10, 180, 130, 30);
        add(label_diachi);

        textField_diachi = new JTextField();
        textField_diachi.setColumns(10);
        textField_diachi.setBounds(141, 180, 264, 30);
        add(textField_diachi);

        JLabel label_bienso = new JLabel("Biển số:");
        label_bienso.setBounds(10, 221, 130, 30);
        add(label_bienso);

        textField_bienso = new JTextField();
        textField_bienso.setColumns(10);
        textField_bienso.setBounds(141, 221, 264, 30);
        add(textField_bienso);

        JLabel label_hieuxe = new JLabel("Hiệu xe:");
        label_hieuxe.setBounds(10, 262, 130, 30);
        add(label_hieuxe);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(140, 262, 265, 30);
        add(comboBox_1);

        JLabel label_thoigiantiepnhan = new JLabel("thời gian tiếp nhận:");
        label_thoigiantiepnhan.setBounds(10, 303, 130, 30);
        add(label_thoigiantiepnhan);

        textField_thoigiantiepnhan = new JTextField();
        textField_thoigiantiepnhan.setColumns(10);
        textField_thoigiantiepnhan.setBounds(141, 303, 264, 30);
        add(textField_thoigiantiepnhan);

        JButton button_lammoibang = new JButton("Làm mới bảng");
        button_lammoibang.setBounds(739, 459, 115, 35);
        add(button_lammoibang);

        JButton button_luu = new JButton("Lưu");
//        button_luu.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
        button_luu.setBounds(10, 413, 89, 35);
        add(button_luu);

        JButton button_luumoi = new JButton("Lưu mới");
//        button_luumoi.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
        button_luumoi.setBounds(109, 413, 89, 35);
        add(button_luumoi);

        JButton button_sua = new JButton("Sửa");
        button_sua.setBounds(217, 413, 89, 35);
        add(button_sua);

        JButton button_xoa = new JButton("Xóa");
        button_xoa.setBounds(316, 413, 89, 35);
        add(button_xoa);

        JButton button_lammoi = new JButton("Làm mới");
        button_lammoi.setBounds(316, 344, 89, 35);
        add(button_lammoi);
    }
}
