package View.panel;

import Models.dao.*;
import Models.entity.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PanelLapPhieuSuaChua extends JPanel {
    private final JComboBox<String> comboBox_tentiencong;
    private final JComboBox<String> comboBox_biensoxe;
    private final JComboBox<String> comboBox_VTPT;
    private final JButton button_lammoibangtiencong;
    private final JButton button_lammoibangvtpt;
    private final JButton button_lammoi_phieusuachua;
    private JTable table_vattuphutung;
    private JTable table_phieusuachuahienco;
    private JTable table_tiencong;
    private JTextField textField_soluong;
    private JTextField textField_ngaysuachua;
    private JTextField textField_tongtien;
    private TienCongDAO tienCongDAO;
    private VatTuPhuTungDAO vatTuPhuTungDAO;
    private XeDAO xeDAO;
    private PhieuSuaChuaDAO phieuSuaChuaDAO;
    private SuDungTienCongDAO suDungTienCongDAO;

    public PanelLapPhieuSuaChua() {
        tienCongDAO = new TienCongDAO();
        vatTuPhuTungDAO = new VatTuPhuTungDAO();
        xeDAO = new XeDAO();
        phieuSuaChuaDAO = new PhieuSuaChuaDAO();
        suDungTienCongDAO = new SuDungTienCongDAO();
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
                new Object[][]{},
                new String[]{
                        "Mã phụ tùng", "Vật tư phụ tùng", "Số lượng", "Đơn giá", "Thành tiền (VND)"
                }
        ));
        scrollPane_table_vattuphutung.setViewportView(table_vattuphutung);
        TableColumnModel columnModel = table_vattuphutung.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(30);
        columnModel.getColumn(3).setPreferredWidth(30);

        JScrollPane scrollPane_phieusuachuahienco = new JScrollPane();
        scrollPane_phieusuachuahienco.setBounds(10, 363, 821, 141);
        add(scrollPane_phieusuachuahienco);

        table_phieusuachuahienco = new JTable();
        table_phieusuachuahienco.setFont(new Font("Segoe UI", Font.BOLD, 11));
        table_phieusuachuahienco.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Mã phiếu sửa chữa", "Biển số xe", "Ngày nhận sửa", "Thành tiền (VND)"
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
                new Object[][]{},
                new String[]{
                        "Mã tiền công", "Nội dung", "Chi phí"
                }
        ));
        scrollPane_table_tiencong.setViewportView(table_tiencong);
        TableColumnModel columnModel1 = table_tiencong.getColumnModel();
        columnModel1.getColumn(0).setPreferredWidth(70);
        columnModel1.getColumn(1).setPreferredWidth(130);



        comboBox_biensoxe = new JComboBox<>();
        comboBox_biensoxe.setBounds(90, 52, 265, 30);
        add(comboBox_biensoxe);

        JLabel label_VTPT = new JLabel("VTPT:");
        label_VTPT.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_VTPT.setBounds(10, 93, 75, 29);
        add(label_VTPT);

        comboBox_VTPT = new JComboBox<>();
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

        comboBox_tentiencong = new JComboBox<>();
        comboBox_tentiencong.setBounds(581, 93, 250, 30);
        add(comboBox_tentiencong);

        // Load danh sách tiền công lên comboBox_tentiencong
        loadTienCongToComboBox();

        JButton button_nhaptiencong = new JButton("Nhập tiền công");
        button_nhaptiencong.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_nhaptiencong.setBounds(698, 129, 133, 35);
        add(button_nhaptiencong);
        button_nhaptiencong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nhapTienCong();
            }
        });

        JButton button_hoantat = new JButton("Hoàn tất");
        button_hoantat.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_hoantat.setBounds(10, 284, 106, 35);
        add(button_hoantat);
        button_hoantat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hoanTatPhieuSuaChua();
            }
        });

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
        button_luu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                luuPhieuSuaChua();
            }
        });

        JButton button_nhapphieumoi = new JButton("Nhập phiếu mới");
        button_nhapphieumoi.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_nhapphieumoi.setBounds(548, 284, 133, 35);
        add(button_nhapphieumoi);
        button_nhapphieumoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nhapPhieuMoi();
            }
        });

        button_lammoibangtiencong = new JButton("Làm mới");
        button_lammoibangtiencong.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoibangtiencong.setBounds(485, 129, 96, 35);
        add(button_lammoibangtiencong);
        button_lammoibangtiencong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lamMoiBangTienCong();
            }
        });

        button_lammoibangvtpt = new JButton("Làm mới");
        button_lammoibangvtpt.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoibangvtpt.setBounds(379, 129, 96, 35);
        add(button_lammoibangvtpt);
        button_lammoibangvtpt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lamMoiBangVTPT();
            }
        });

        button_lammoi_phieusuachua = new JButton("Làm mới");
        button_lammoi_phieusuachua.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoi_phieusuachua.setBounds(742, 329, 89, 23);
        add(button_lammoi_phieusuachua);
        button_lammoi_phieusuachua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lamMoiBangPhieuSuaChua();
            }
        });

        // Load danh sách xe và VTPT lên comboBox
        loadXeToComboBox();
        loadVTPTToComboBox();

        button_nhapvtpt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nhapVTPT();
            }
        });

        loadPhieuSuaChuaHienCo();
    }

    private void loadTienCongToComboBox() {
        List<TienCong> tienCongList = tienCongDAO.getAllTienCong();
        comboBox_tentiencong.removeAllItems();
        for (TienCong tc : tienCongList) {
            comboBox_tentiencong.addItem(tc.getTenTC());
        }
    }

    private void loadXeToComboBox() {
        List<Xe> xeList = xeDAO.getAllXe();
        comboBox_biensoxe.removeAllItems();
        for (Xe xe : xeList) {
            comboBox_biensoxe.addItem(xe.getBienSo());
        }
    }

    private void loadVTPTToComboBox() {
        List<VatTuPhuTung> vtptList = vatTuPhuTungDAO.getAllVatTuPhuTung();
        comboBox_VTPT.removeAllItems();
        for (VatTuPhuTung vtpt : vtptList) {
            comboBox_VTPT.addItem(vtpt.getTenVTPT());
        }
    }


    // hàm hiển thị các loại tiền công lên comboBox
    private void nhapTienCong() {
        String tenTC = (String) comboBox_tentiencong.getSelectedItem();
        if (tenTC != null && !tenTC.isEmpty()) {
            TienCong tienCong = tienCongDAO.getTienCongByTen(tenTC); // lấy ra tiền công trong comboBox
            if (tienCong != null) {
                DefaultTableModel model = (DefaultTableModel) table_tiencong.getModel();
                model.addRow(new Object[]{tienCong.getMaTC(), tienCong.getTenTC(), tienCong.getChiPhiTC()});
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy tiền công tương ứng.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tiền công.");
        }
    }

    private void nhapVTPT() {
        String tenVTPT = (String) comboBox_VTPT.getSelectedItem(); // lấy tên vtpt trong comboBox
        int soLuong; // biến này

        try {
            soLuong = Integer.parseInt(textField_soluong.getText()); // lấy số lượng
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số.");
            return;
        }
        int slton = vatTuPhuTungDAO.getSoLuongTonByTen(tenVTPT);
        if (soLuong > slton) {
            JOptionPane.showMessageDialog(this, "Số lượng vật tư phụ tùng không đủ.");
            return;
        }
        VatTuPhuTung vtpt = vatTuPhuTungDAO.getVatTuPhuTungByTen(tenVTPT);
        if (vtpt != null) {
            double donGiaBan = vtpt.getDonGiaBan();
            double thanhTien = donGiaBan * soLuong;

            DefaultTableModel model = (DefaultTableModel) table_vattuphutung.getModel();
            model.addRow(new Object[]{vtpt.getMaVTPT(), vtpt.getTenVTPT(), soLuong, donGiaBan, thanhTien});

            textField_soluong.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy vật tư phụ tùng tương ứng.");
        }
    }

    private void nhapPhieuMoi() {
        DefaultTableModel vtptModel = (DefaultTableModel) table_vattuphutung.getModel();
        vtptModel.setRowCount(0); // Clear existing data

        DefaultTableModel tienCongModel = (DefaultTableModel) table_tiencong.getModel();
        tienCongModel.setRowCount(0); // Clear existing data

        textField_tongtien.setText("");
        textField_ngaysuachua.setText("");
        textField_soluong.setText("");
        comboBox_biensoxe.setSelectedIndex(-1);
        comboBox_tentiencong.setSelectedIndex(-1);
        comboBox_VTPT.setSelectedIndex(-1);
        loadVTPTToComboBox();
        loadXeToComboBox();
    }

    // Hàm tính tổng tiền phiếu sửa chữa
    private void hoanTatPhieuSuaChua() {
        double tongTien = 0.0;

        // Tính tổng thành tiền từ table_vattuphutung
        DefaultTableModel vtptModel = (DefaultTableModel) table_vattuphutung.getModel();
        int rowCount = vtptModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            double thanhTien = (double) vtptModel.getValueAt(i, 4);
            tongTien += thanhTien;
        }

        // Tính tổng chi phí tiền công từ table_tiencong
        DefaultTableModel tienCongModel = (DefaultTableModel) table_tiencong.getModel();
        rowCount = tienCongModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            double chiPhi = (double) tienCongModel.getValueAt(i, 2);
            tongTien += chiPhi;
        }

        textField_tongtien.setText(String.valueOf(tongTien));
    }

    // Hàm lưu phiếu sửa chữa
    private void luuPhieuSuaChua() {
        String bienSo = (String) comboBox_biensoxe.getSelectedItem();
        String ngaySuaChuaStr = textField_ngaysuachua.getText();
        double thanhTienPSC = Double.parseDouble(textField_tongtien.getText());

        Date ngaySuaChua;
        try { // format lại cái ngaySuaChuaStr
            ngaySuaChua = new SimpleDateFormat("dd/MM/yyyy").parse(ngaySuaChuaStr);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày sửa chữa không đúng định dạng. Vui lòng nhập ngày theo định dạng dd/MM/yyyy.");
            return;
        }

        // Tạo phiếu sửa chữa
        String maPhieuSuaChua = phieuSuaChuaDAO.generateMaPhieuSuaChua();
        PhieuSuaChua phieuSuaChua = new PhieuSuaChua(maPhieuSuaChua, bienSo, ngaySuaChua, thanhTienPSC);
        phieuSuaChuaDAO.savePhieuSuaChua(phieuSuaChua);

        // Tạo chi tiết sử dụng vật tư phụ tùng
        DefaultTableModel vtptModel = (DefaultTableModel) table_vattuphutung.getModel();
        List<CTSuDungVTPT> ctSudungVTPTList = new ArrayList<>();
        for (int i = 0; i < vtptModel.getRowCount(); i++) {
            String maVTPT = (String) vtptModel.getValueAt(i, 0);
            String vattuphutung = (String) vtptModel.getValueAt(i, 1);
            int soLuongSuDung = (int) vtptModel.getValueAt(i, 2);
            double donGia = (double) vtptModel.getValueAt(i, 3);
            double thanhTien = (double) vtptModel.getValueAt(i, 4);


            CTSuDungVTPT ctSudungVTPT = new CTSuDungVTPT(maPhieuSuaChua, maVTPT,vattuphutung, donGia, soLuongSuDung, thanhTien);
            ctSudungVTPTList.add(ctSudungVTPT);

            // Trừ số lượng tồn
            vatTuPhuTungDAO.updateSoLuongTon(maVTPT, -soLuongSuDung);
        }
        // tạo chi tiết sử dụng tiền công
        DefaultTableModel tiencongModel = (DefaultTableModel) table_tiencong.getModel();
        List<SuDungTienCong> tiencongList = new ArrayList<>();
        for (int i = 0; i < tiencongModel.getRowCount(); i++) {
            String maTienCong = (String) tiencongModel.getValueAt(i, 0);
            String tenTienCong = (String) tiencongModel.getValueAt(i, 1);
            double chiPhi = (double) tiencongModel.getValueAt(i, 2);

            SuDungTienCong suDungTienCong = new SuDungTienCong(maPhieuSuaChua, maTienCong,tenTienCong, chiPhi);
            tiencongList.add(suDungTienCong);
        }
        // trong cái SuDungTienCongDAO viết hàm lưu danh sách sử dụng tiền công
        suDungTienCongDAO.saveSuDungTienCongList(tiencongList);

        // trong cái phiếu sửa chữa DAO làm 1 lúc cả lưu VATTUPHUTUNG và lưu CTSuDungVTPT
        phieuSuaChuaDAO.saveCTSudungVTPT(ctSudungVTPTList);

        // Cập nhật tiền nợ của xe
        xeDAO.updateTienNo(bienSo, thanhTienPSC);

        JOptionPane.showMessageDialog(this, "Lưu phiếu sửa chữa thành công.");
        nhapPhieuMoi(); // làm mới lại
    }

    private void lamMoiBangTienCong() {
        DefaultTableModel model = (DefaultTableModel) table_tiencong.getModel();
        model.setRowCount(0);
    }

    private void lamMoiBangVTPT() {
        DefaultTableModel model = (DefaultTableModel) table_vattuphutung.getModel();
        model.setRowCount(0);
    }

    private void lamMoiBangPhieuSuaChua() {
        DefaultTableModel model = (DefaultTableModel) table_phieusuachuahienco.getModel();
        model.setRowCount(0);
        loadPhieuSuaChuaHienCo();
    }

    private void loadPhieuSuaChuaHienCo() {
        List<PhieuSuaChua> phieuSuaChuaList = phieuSuaChuaDAO.getAllPhieuSuaChua();
        DefaultTableModel model = (DefaultTableModel) table_phieusuachuahienco.getModel();
        for (PhieuSuaChua psc : phieuSuaChuaList) {
            model.addRow(new Object[]{psc.getMaPhieuSuaChua(), psc.getBienSo(), psc.getNgaySuaChua(), psc.getThanhTienPSC()});
        }
    }
}
