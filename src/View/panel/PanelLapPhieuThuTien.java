package View.panel;

import Controller.PhieuThuTienController;
import Models.entity.PhieuThuTien;
import Models.entity.KhachHang;
import Models.entity.Xe;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PanelLapPhieuThuTien extends JPanel {
    private JTextField textField_hotenchuxe;
    private JTextField textField_sodienthoai_phieuthutien;
    private JTextField textField_sotienthu;
    private JTextField textField_ngaythutien_phieuthutien;
    private JTextField textField_email_phieuthutien;
    private JTextField textField_sotienno_phieuthutien;
    private JComboBox<String> comboBox_biensoxe_phieuthutien;
    private JTable table_danhsachphieuthu;
    private PhieuThuTienController controller;

    public PanelLapPhieuThuTien() {
        controller = new PhieuThuTienController();

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

        comboBox_biensoxe_phieuthutien = new JComboBox<>();
        comboBox_biensoxe_phieuthutien.setBounds(139, 82, 282, 30);
        comboBox_biensoxe_phieuthutien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadXeInfo();
            }
        });
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

        JLabel label_email_phieuthutien = new JLabel("Email:");
        label_email_phieuthutien.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_email_phieuthutien.setBounds(452, 254, 109, 29);
        add(label_email_phieuthutien);

        textField_email_phieuthutien = new JTextField();
        textField_email_phieuthutien.setColumns(10);
        textField_email_phieuthutien.setBounds(571, 254, 264, 30);
        add(textField_email_phieuthutien);

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
        button_luu_phieuthutien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                luuPhieuThuTien();
            }
        });
        add(button_luu_phieuthutien);

        JButton button_lammoi_phieuthutien = new JButton("Làm mới");
        button_lammoi_phieuthutien.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoi_phieuthutien.setBounds(193, 170, 109, 39);
        button_lammoi_phieuthutien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        add(button_lammoi_phieuthutien);

        JButton button_inphieuthu = new JButton("In phiếu thu");
        button_inphieuthu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_inphieuthu.setBounds(193, 220, 228, 39);
        add(button_inphieuthu);

        Box verticalBox = Box.createVerticalBox();
        verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        verticalBox.setBounds(430, 49, 411, 457);
        add(verticalBox);

        JScrollPane scrollPane_danhsachphieuthu = new JScrollPane();
        scrollPane_danhsachphieuthu.setBounds(10, 289, 411, 217);
        add(scrollPane_danhsachphieuthu);

        JButton button_lammoi_danhsachphieuthu = new JButton("Làm mới");
        button_lammoi_danhsachphieuthu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoi_danhsachphieuthu.setBounds(10, 258, 89, 23);
        add(button_lammoi_danhsachphieuthu);
        button_lammoi_danhsachphieuthu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh_table_danhsachphieuthu();
            }
        });

        table_danhsachphieuthu = new JTable();
        table_danhsachphieuthu.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Mã phiếu thu", "Biển số", "Số tiền thu (VND)", "Ngày thu"
                }
        ));
        scrollPane_danhsachphieuthu.setViewportView(table_danhsachphieuthu);

        loadDataToComboBox();
    }
    private void refresh_table_danhsachphieuthu() {
        DefaultTableModel model = (DefaultTableModel) table_danhsachphieuthu.getModel();
        model.setRowCount(0);

        // lấy ra tất cả list phiếu thu và hiển thị ra lại bảng
        List<PhieuThuTien> phieuThuTienList = controller.getAllPhieuThuTien();
        for (PhieuThuTien phieuThuTien : phieuThuTienList) {
            model.addRow(new Object[]{
                phieuThuTien.getMaPhieuThuTien(),
                phieuThuTien.getBienSo(),
                phieuThuTien.getSoTienThu(),
                phieuThuTien.getNgayThuTien()
            });
        }
    }

    private void loadDataToComboBox() {
        comboBox_biensoxe_phieuthutien.removeAllItems();
        List<Xe> xeList = controller.getAllXe();
        for (Xe xe : xeList) {
            comboBox_biensoxe_phieuthutien.addItem(xe.getBienSo());
        }
    }

    private void loadXeInfo() {
        String bienSo = (String) comboBox_biensoxe_phieuthutien.getSelectedItem();
        if (bienSo != null) {
            Xe xe = controller.getXeByBienSo(bienSo);
            if (xe != null) {
                KhachHang khachHang = controller.getKhachHangByMaKH(xe.getMaKH());
                if (khachHang != null) {
                    textField_hotenchuxe.setText(khachHang.getHoTenKH());
                    textField_sodienthoai_phieuthutien.setText(khachHang.getDienThoai());
                    textField_email_phieuthutien.setText(khachHang.getEmail());
                }
                textField_sotienno_phieuthutien.setText(String.valueOf(xe.getTienNo()));
            }
        }
    }

    private void luuPhieuThuTien() {
        String bienSo = (String) comboBox_biensoxe_phieuthutien.getSelectedItem();
        String ngayThuTienStr = textField_ngaythutien_phieuthutien.getText();
        double soTienThu = Double.parseDouble(textField_sotienthu.getText());

        Date ngayThuTien;
        try {
            ngayThuTien = new SimpleDateFormat("dd/MM/yyyy").parse(ngayThuTienStr);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày thu tiền không đúng định dạng. Vui lòng nhập ngày theo định dạng dd/MM/yyyy.");
            return;
        }

        String maPhieuThuTien = controller.generateMaPhieuThuTien();
        PhieuThuTien phieuThuTien = new PhieuThuTien(maPhieuThuTien, bienSo, soTienThu, ngayThuTien);
        controller.savePhieuThuTien(phieuThuTien);

        JOptionPane.showMessageDialog(this, "Lưu phiếu thu tiền thành công.");
        clearFields(); //
    }

    private void clearFields() {
        loadDataToComboBox();
        comboBox_biensoxe_phieuthutien.setSelectedIndex(-1);
        textField_hotenchuxe.setText("");
        textField_sodienthoai_phieuthutien.setText("");
        textField_email_phieuthutien.setText("");
        textField_sotienthu.setText("");
        textField_ngaythutien_phieuthutien.setText("");
        textField_sotienno_phieuthutien.setText("");
    }
}
