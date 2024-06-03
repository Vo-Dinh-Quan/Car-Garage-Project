package View.frame;

import Models.dao.PhieuNhapVTPTDAO;
import Models.dao.VatTuPhuTungDAO;
import Models.entity.PhieuNhapVTPT;
import Models.entity.CTPhieuNhapVTPT;
import Models.entity.VatTuPhuTung;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class LapPhieuNhapVTPTFrame extends JFrame {
    private JPanel contentPane;
    private JTextField textField_tenvtpt_phieunhap;
    private JTextField textField_dongianhap_phieunhap;
    private JTextField textField_soluong_phieunhap;
    private JTable table_phieunhap;
    private VatTuPhuTungDAO vtptDAO;
    private PhieuNhapVTPTDAO pnvtptDAO; // khai báo cái phiếu nhập vật tư DAO

    public LapPhieuNhapVTPTFrame() {
        // 2 thằng DAO này sẽ tác động đến các bảng trong database tương ứng
        vtptDAO = new VatTuPhuTungDAO();
        pnvtptDAO = new PhieuNhapVTPTDAO();

        setTitle("Lập phiếu nhập VTPT");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 430, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPhiuNhpVtpt = new JLabel("PHIẾU NHẬP VTPT");
        lblPhiuNhpVtpt.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        lblPhiuNhpVtpt.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblPhiuNhpVtpt.setBounds(137, 0, 147, 31);
        contentPane.add(lblPhiuNhpVtpt);

        JLabel lblTnVtT = new JLabel("Tên Vật Tư Phụ Tùng:");
        lblTnVtT.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblTnVtT.setBounds(10, 54, 147, 25);
        contentPane.add(lblTnVtT);

        JLabel label_dongianhap_phieunhap = new JLabel("Đơn giá nhập:");
        label_dongianhap_phieunhap.setFont(new Font("Segoe UI", Font.BOLD, 13));
        label_dongianhap_phieunhap.setBounds(10, 90, 119, 25);
        contentPane.add(label_dongianhap_phieunhap);

        JLabel label_soluong_phieunhap = new JLabel("Số lượng:");
        label_soluong_phieunhap.setFont(new Font("Segoe UI", Font.BOLD, 13));
        label_soluong_phieunhap.setBounds(10, 126, 119, 25);
        contentPane.add(label_soluong_phieunhap);

        textField_tenvtpt_phieunhap = new JTextField();
        textField_tenvtpt_phieunhap.setBounds(167, 57, 226, 22);
        contentPane.add(textField_tenvtpt_phieunhap);
        textField_tenvtpt_phieunhap.setColumns(10);

        textField_dongianhap_phieunhap = new JTextField();
        textField_dongianhap_phieunhap.setColumns(10);
        textField_dongianhap_phieunhap.setBounds(167, 93, 226, 22);
        contentPane.add(textField_dongianhap_phieunhap);

        textField_soluong_phieunhap = new JTextField();
        textField_soluong_phieunhap.setColumns(10);
        textField_soluong_phieunhap.setBounds(167, 129, 226, 22);
        contentPane.add(textField_soluong_phieunhap);

        JButton btnThm = new JButton("Thêm");
        btnThm.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnThm.setBounds(10, 163, 75, 39);
        contentPane.add(btnThm);

        JButton button_xoa_phieunhap = new JButton("Xóa");
        button_xoa_phieunhap.setFont(new Font("Segoe UI", Font.BOLD, 13));
        button_xoa_phieunhap.setBounds(95, 162, 75, 39);
        contentPane.add(button_xoa_phieunhap);

        JScrollPane scrollPane_phieunhap = new JScrollPane();
        scrollPane_phieunhap.setBounds(10, 219, 383, 281);
        contentPane.add(scrollPane_phieunhap);

        table_phieunhap = new JTable();
        table_phieunhap.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {
                        "Tên VTPT", "Đơn giá nhập (VND)", "Số lượng", "Thành tiền (VND)"
                }
        ));
        scrollPane_phieunhap.setViewportView(table_phieunhap);

        TableColumnModel columnModel = table_phieunhap.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(30);

        JButton button_hoanthanh_phieunhap = new JButton("Hoàn thành");
        button_hoanthanh_phieunhap.setFont(new Font("Segoe UI", Font.BOLD, 13));
        button_hoanthanh_phieunhap.setBounds(262, 162, 131, 39);
        contentPane.add(button_hoanthanh_phieunhap);

        setLocationRelativeTo(null);

        btnThm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themVatTuPhuTung();
            }
        });

        button_xoa_phieunhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaVatTuPhuTung();
            }
        });

        button_hoanthanh_phieunhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hoanThanhPhieuNhap();
            }
        });

        this.setVisible(true);
    }

    private void themVatTuPhuTung() {
        // gán thông tin vật tư phụ tùng vừa nhập vào
        String tenVTPT = textField_tenvtpt_phieunhap.getText();
        double donGiaNhap;
        int soLuong;

        try {
            donGiaNhap = Double.parseDouble(textField_dongianhap_phieunhap.getText());
            soLuong = Integer.parseInt(textField_soluong_phieunhap.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Đơn giá nhập và số lượng phải là số.");
            return;
        }
        // tính thành tiền
        double thanhTien = donGiaNhap * soLuong;

        DefaultTableModel model = (DefaultTableModel) table_phieunhap.getModel();
        model.addRow(new Object[]{tenVTPT, donGiaNhap, soLuong, thanhTien}); // thêm lại vào bảng

        // làm mới lại trường nhạp liệu
        textField_tenvtpt_phieunhap.setText("");
        textField_dongianhap_phieunhap.setText("");
        textField_soluong_phieunhap.setText("");
    }

    private void xoaVatTuPhuTung() {
        int selectedRow = table_phieunhap.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) table_phieunhap.getModel();
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một vật tư phụ tùng để xóa.");
        }
    }

    private void hoanThanhPhieuNhap() {
        try {
            String maPNVTPT = pnvtptDAO.getNextMaPNVTPT(); // lấy ra cái mã phiếu nhập bằng sequence
            double tongThanhTien = 0.0;
            List<CTPhieuNhapVTPT> ctPhieuNhapList = new ArrayList<>();

            DefaultTableModel model = (DefaultTableModel) table_phieunhap.getModel(); // lấy model của bảng
            int rowCount = model.getRowCount(); // lấy số lượng dòng hiện có

            for (int i = 0; i < rowCount; i++) {
                // lấy dữ liệu từng dòng
                String tenVTPT = (String) model.getValueAt(i, 0);
                double donGiaNhap = (double) model.getValueAt(i, 1);
                int soLuong = (int) model.getValueAt(i, 2);
                double thanhTien = (double) model.getValueAt(i, 3);

                VatTuPhuTung existingVTPT = vtptDAO.getVatTuPhuTungByTen(tenVTPT); // existingVTPT để kiểm tra có tồn tại vật tư phụ tùng trong hệ thống hay chưa
                String maVTPT;
                if (existingVTPT != null) { // nếu đã tồn tại rồi
                    // thì mình lấy ra tên của vật tư đó rồi cập nhật lại số lượng trong database
                    maVTPT = existingVTPT.getMaVTPT();
                    vtptDAO.updateSoLuongTon(maVTPT, soLuong);
                } else {
                    // nếu chưa tồn tại rồi thì mình thêm mới vào database
                    maVTPT = vtptDAO.getNextMaVTPT(); // hàm này củng tạo mã vật tư phụ tùng bằng sequence
                    double donGiaBan = donGiaNhap * 1.2;
                    VatTuPhuTung vtpt = new VatTuPhuTung(maVTPT, tenVTPT, donGiaNhap, donGiaBan, soLuong);
                    vtptDAO.addVatTuPhuTung(vtpt);
                }

                CTPhieuNhapVTPT ct = new CTPhieuNhapVTPT(maPNVTPT, maVTPT, soLuong, thanhTien); // add luôn vào cái chi tiest phiếu nập.
                ctPhieuNhapList.add(ct);

                tongThanhTien += thanhTien;
            }

            PhieuNhapVTPT pnvtpt = new PhieuNhapVTPT(maPNVTPT, tongThanhTien, new Date(System.currentTimeMillis())); // add vào phiếu nhập
            pnvtptDAO.addPhieuNhapVTPT(pnvtpt);

            for (CTPhieuNhapVTPT ct : ctPhieuNhapList) { // duyệt để add cái list chi tiết phiếu nhập này vào database
                pnvtptDAO.addCTPhieuNhapVTPT(ct);
            }

            JOptionPane.showMessageDialog(this, "Phiếu nhập VTPT đã được lưu thành công.");
            model.setRowCount(0); // Clear the table after successful completion
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã có lỗi xảy ra. Vui lòng thử lại.");
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            new LapPhieuNhapVTPTFrame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
