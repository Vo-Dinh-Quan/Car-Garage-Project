package View.panel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class PanelLapPhieuThuTien extends JPanel {
    private JTextField textField_hotenchuxe;
    private JTextField textField_sodienthoai_phieuthutien;
    private JTextField textField_sotienthu;
    private JTextField textField_ngaythutien_phieuthutien;
    private JTextField textField_diachi_phieuthutien;
    private JTextField textField_sotienno_phieuthutien;

    public PanelLapPhieuThuTien() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        JLabel label_lapphieuthutien = new JLabel("LẬP PHIẾU THU TIỀN");
        label_lapphieuthutien.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        label_lapphieuthutien.setBounds(284, 11, 210, 27);
        label_lapphieuthutien.setHorizontalAlignment(SwingConstants.CENTER);
        label_lapphieuthutien.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(label_lapphieuthutien);

        JLabel label_biensoxe_phieuthutien = new JLabel("Biển số xe:");
        label_biensoxe_phieuthutien.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_biensoxe_phieuthutien.setBounds(20, 83, 109, 29);
        add(label_biensoxe_phieuthutien);

        JComboBox comboBox_biensoxe_phieuthutien = new JComboBox();
        comboBox_biensoxe_phieuthutien.setBounds(139, 82, 282, 30);
        add(comboBox_biensoxe_phieuthutien);

        textField_hotenchuxe = new JTextField();
        textField_hotenchuxe.setColumns(10);
        textField_hotenchuxe.setBounds(571, 82, 264, 30);
        add(textField_hotenchuxe);

        JLabel label_hotenchuxe = new JLabel("Họ tên chủ xe:");
        label_hotenchuxe.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_hotenchuxe.setBounds(452, 83, 109, 29);
        add(label_hotenchuxe);

        JLabel label_sotienthu = new JLabel("Số tiền thu:");
        label_sotienthu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_sotienthu.setBounds(20, 130, 109, 29);
        add(label_sotienthu);

        JLabel label_sodienthoai_phieuthutien = new JLabel("Số điện thoại:");
        label_sodienthoai_phieuthutien.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_sodienthoai_phieuthutien.setBounds(452, 143, 109, 29);
        add(label_sodienthoai_phieuthutien);

        textField_sodienthoai_phieuthutien = new JTextField();
        textField_sodienthoai_phieuthutien.setColumns(10);
        textField_sodienthoai_phieuthutien.setBounds(571, 142, 264, 30);
        add(textField_sodienthoai_phieuthutien);

        textField_sotienthu = new JTextField();
        textField_sotienthu.setColumns(10);
        textField_sotienthu.setBounds(139, 129, 282, 30);
        add(textField_sotienthu);

        JLabel label_ngaythutien_phieuthutien = new JLabel("Ngày thu tiền:");
        label_ngaythutien_phieuthutien.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_ngaythutien_phieuthutien.setBounds(452, 200, 109, 29);
        add(label_ngaythutien_phieuthutien);

        textField_ngaythutien_phieuthutien = new JTextField();
        textField_ngaythutien_phieuthutien.setColumns(10);
        textField_ngaythutien_phieuthutien.setBounds(571, 199, 264, 30);
        add(textField_ngaythutien_phieuthutien);

        JLabel label_diachi_phieuthutien = new JLabel("Địa chỉ:");
        label_diachi_phieuthutien.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_diachi_phieuthutien.setBounds(452, 254, 109, 29);
        add(label_diachi_phieuthutien);

        textField_diachi_phieuthutien = new JTextField();
        textField_diachi_phieuthutien.setColumns(10);
        textField_diachi_phieuthutien.setBounds(571, 254, 264, 30);
        add(textField_diachi_phieuthutien);

        textField_sotienno_phieuthutien = new JTextField();
        textField_sotienno_phieuthutien.setColumns(10);
        textField_sotienno_phieuthutien.setBounds(571, 315, 264, 30);
        add(textField_sotienno_phieuthutien);

        JLabel label_sotienno_phieuthutien = new JLabel("Số tiền nợ:");
        label_sotienno_phieuthutien.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_sotienno_phieuthutien.setBounds(452, 315, 109, 29);
        add(label_sotienno_phieuthutien);

        JButton button_luu_phieuthutien = new JButton("Lưu");
        button_luu_phieuthutien.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_luu_phieuthutien.setBounds(312, 170, 109, 39);
        add(button_luu_phieuthutien);

        JButton button_lammoi_phieuthutien = new JButton("Làm mới");
        button_lammoi_phieuthutien.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoi_phieuthutien.setBounds(193, 170, 109, 39);
        add(button_lammoi_phieuthutien);

        JButton button_inphieuthu = new JButton("In phiếu thu");
        button_inphieuthu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_inphieuthu.setBounds(193, 220, 228, 39);
        add(button_inphieuthu);

        Box verticalBox = Box.createVerticalBox();
        verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        verticalBox.setBounds(430, 49, 411, 457);
        add(verticalBox);
    }
}
