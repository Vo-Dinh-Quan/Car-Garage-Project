package View.panel;

import View.frame.LapPhieuNhapVTPTFrame;
import Models.dao.PhieuNhapVTPTDAO;
import Models.dao.VatTuPhuTungDAO;
import Models.entity.PhieuNhapVTPT;
import Models.entity.VatTuPhuTung;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelQuanLyVTPT extends JPanel {
    private final JTextField textField_nhaptenvtpt;
    private final JButton button_timkiem;
    private JTable table_danhsachphieunhap;
    private JTable table_danhsachvtpt;
    private PhieuNhapVTPTDAO phieuNhapVTPTDAO;
    private VatTuPhuTungDAO vatTuPhuTungDAO;

    public PanelQuanLyVTPT() {
        phieuNhapVTPTDAO = new PhieuNhapVTPTDAO();
        vatTuPhuTungDAO = new VatTuPhuTungDAO();

        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        JLabel label_danhsachphieunhap = new JLabel("DANH SÁCH PHIẾU NHẬP");
        label_danhsachphieunhap.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        label_danhsachphieunhap.setHorizontalAlignment(SwingConstants.CENTER);
        label_danhsachphieunhap.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label_danhsachphieunhap.setBounds(10, 174, 350, 27);
        add(label_danhsachphieunhap);

        JLabel label_danhsachvtpt = new JLabel("DANH SÁCH VẬT TƯ PHỤ TÙNG");
        label_danhsachvtpt.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        label_danhsachvtpt.setHorizontalAlignment(SwingConstants.CENTER);
        label_danhsachvtpt.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label_danhsachvtpt.setBounds(387, 174, 444, 27);
        add(label_danhsachvtpt);

        JButton button_lapphieuvtpt = new JButton("Lập phiếu nhập VTPT");
        button_lapphieuvtpt.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lapphieuvtpt.setBounds(21, 23, 188, 46);
        add(button_lapphieuvtpt);

        button_lapphieuvtpt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LapPhieuNhapVTPTFrame frame = new LapPhieuNhapVTPTFrame();
                frame.setVisible(true);
            }
        });

        JScrollPane scrollPane_danhsachphieunhap = new JScrollPane();
        scrollPane_danhsachphieunhap.setBounds(10, 259, 350, 236);
        add(scrollPane_danhsachphieunhap);

        table_danhsachphieunhap = new JTable();
        table_danhsachphieunhap.setModel(new DefaultTableModel(
                new Object[][]{},
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
                new Object[][]{},
                new String[]{
                        "Tên VTPT", "Đơn giá nhập", "Đơn giá bán", "Số lượng"
                }
        ));
        scrollPane_danhsachvtpt.setViewportView(table_danhsachvtpt);

        JButton button_lammoi_danhsachvtpt = new JButton("Làm mới");
        button_lammoi_danhsachvtpt.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoi_danhsachvtpt.setBounds(387, 212, 92, 36);
        add(button_lammoi_danhsachvtpt);

        JButton button_lammoi_danhsachphieunhap = new JButton("Làm mới");
        button_lammoi_danhsachphieunhap.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoi_danhsachphieunhap.setBounds(10, 212, 113, 36);
        add(button_lammoi_danhsachphieunhap);

        textField_nhaptenvtpt = new JTextField();
        textField_nhaptenvtpt.setBounds(602, 212, 127, 36);
        add(textField_nhaptenvtpt);
        textField_nhaptenvtpt.setColumns(10);

        JLabel label_nhaptenvtpt = new JLabel("Nhập tên VTPT:");
        label_nhaptenvtpt.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_nhaptenvtpt.setBounds(508, 212, 84, 36);
        add(label_nhaptenvtpt);

        button_timkiem = new JButton("Tìm kiếm");
        button_timkiem.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_timkiem.setBounds(739, 212, 92, 36);
        add(button_timkiem);

        button_timkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchVatTuPhuTung();
            }
        });

        loadDanhSachPhieuNhap();
        loadDanhSachVTPT();

        button_lammoi_danhsachphieunhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDanhSachPhieuNhap();
            }
        });

        button_lammoi_danhsachvtpt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDanhSachVTPT();
            }
        });

    }

    private void loadDanhSachPhieuNhap() {
        List<PhieuNhapVTPT> phieuNhapList = phieuNhapVTPTDAO.getAllPhieuNhapVTPT();
        DefaultTableModel model = (DefaultTableModel) table_danhsachphieunhap.getModel();
        model.setRowCount(0); // Clear existing data

        for (PhieuNhapVTPT pn : phieuNhapList) {
            model.addRow(new Object[]{pn.getMaPNVTPT(), pn.getThanhTienNhap(), pn.getNgayNhap()});
        }
    }

    private void loadDanhSachVTPT() {
        List<VatTuPhuTung> vtptList = vatTuPhuTungDAO.getAllVatTuPhuTung();
        DefaultTableModel model = (DefaultTableModel) table_danhsachvtpt.getModel();
        model.setRowCount(0); // Clear existing data

        for (VatTuPhuTung vtpt : vtptList) {
            model.addRow(new Object[]{vtpt.getTenVTPT(), vtpt.getDonGiaNhap(), vtpt.getDonGiaBan(), vtpt.getSoLuongTon()});
        }
    }

    private void searchVatTuPhuTung() {
        String tenVTPT = textField_nhaptenvtpt.getText().trim();
        if (tenVTPT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên vật tư phụ tùng để tìm kiếm.");
            return;
        }

        List<VatTuPhuTung> vtptList = vatTuPhuTungDAO.searchVatTuPhuTungByName(tenVTPT);
        DefaultTableModel model = (DefaultTableModel) table_danhsachvtpt.getModel();
        model.setRowCount(0); // Clear existing data

        for (VatTuPhuTung vtpt : vtptList) {
            model.addRow(new Object[]{vtpt.getTenVTPT(), vtpt.getDonGiaNhap(), vtpt.getDonGiaBan(), vtpt.getSoLuongTon()});
        }
    }
}
