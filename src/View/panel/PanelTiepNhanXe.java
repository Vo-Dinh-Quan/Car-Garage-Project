package View.panel;

import Controller.TiepNhanXeController;
import Models.entity.KhachHang;
import Models.entity.Xe;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class PanelTiepNhanXe extends JPanel {
    private final JTextField textField_email;
    private final JComboBox<String> comboBox_hieuxe;
    private final JComboBox<String> comboBox_tenkhachhang;
    private JTable table;
    private JTextField textField_tenkhachhangmoi;
    private JTextField textField_sodienthoai;
    private JTextField textField_bienso;
    private JTextField textField_thoigiantiepnhan;
    private TiepNhanXeController controller;
    private String currentBienSo; // Biến để lưu biển số xe hiện tại khi sửa
    private String currentMaKH; // Biến để lưu mã khách hàng hiện tại khi sửa
    private double currentTienNo; // Biến để lưu tiền nợ hiện tại của xe khi sửa

    public PanelTiepNhanXe() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        controller = new TiepNhanXeController();

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
                new Object[][]{},
                new String[]{
                        "Biển số", "Hiệu xe", "Tên khách hàng", "Mã KH", "Điện thoại"
                }
        ));
        // chỉnh kích cột thước các bảng
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(170);
        columnModel.getColumn(3).setPreferredWidth(70);
        columnModel.getColumn(4).setPreferredWidth(100);

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

        comboBox_tenkhachhang = new JComboBox<>();
        comboBox_tenkhachhang.setBounds(141, 57, 265, 30);
        add(comboBox_tenkhachhang);
        comboBox_tenkhachhang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // cái listener này để đề xuất dựa trên thông tin khách hàng đã có sẵn vào các texField
                String selectedName = (String) comboBox_tenkhachhang.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    KhachHang khachHang = controller.getKhachHangByName(selectedName);
                    if (khachHang != null) {
                        textField_tenkhachhangmoi.setText("");
                        textField_sodienthoai.setText(khachHang.getDienThoai());
                        textField_email.setText(khachHang.getEmail());
                    }
                }
            }
        });

        JLabel label_sodienthoai = new JLabel("Số điện thoại:");
        label_sodienthoai.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_sodienthoai.setBounds(10, 139, 130, 30);
        add(label_sodienthoai);

        textField_sodienthoai = new JTextField();
        textField_sodienthoai.setColumns(10);
        textField_sodienthoai.setBounds(141, 139, 264, 30);
        add(textField_sodienthoai);

        JLabel label_Email = new JLabel("Email:");
        label_Email.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_Email.setBounds(10, 180, 130, 30);
        add(label_Email);

        textField_email = new JTextField();
        textField_email.setColumns(10);
        textField_email.setBounds(141, 180, 264, 30);
        add(textField_email);

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

        comboBox_hieuxe = new JComboBox<>();
        comboBox_hieuxe.setBounds(140, 262, 265, 30);
        add(comboBox_hieuxe);

        // Thêm các hiệu xe vào comboBox_hieuxe
        String[] hieuXe = {"Toyota", "Honda", "Ford", "BMW", "Mercedes", "Audi", "Hyundai", "Kia", "Mazda", "Nissan"};
        for (String hieu : hieuXe) {
            comboBox_hieuxe.addItem(hieu);
        }

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

        button_lammoibang_tiepnhanxe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable(); // hàm làm mới bảng
            }
        });

        JButton button_luu_tiepnhanxe = new JButton("Lưu");
        button_luu_tiepnhanxe.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_luu_tiepnhanxe.setBounds(10, 413, 89, 35);
        add(button_luu_tiepnhanxe);

        button_luu_tiepnhanxe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentBienSo != null) {
                    // Cập nhật thông tin khách hàng trước
                    String hoTenKH = textField_tenkhachhangmoi.getText();
                    String dienThoai = textField_sodienthoai.getText();
                    String email = textField_email.getText();
                    KhachHang khachHang = controller.getKhachHangById(currentMaKH); // lấy thông tin của khách hàng hiện tại đnag sửa
                    if (khachHang != null) { // nếu khách hàng tồn tại thì tiến hành cập nhật bằng hàm updateKhachhang
                        khachHang.setHoTenKH(hoTenKH);
                        khachHang.setDienThoai(dienThoai);
                        khachHang.setEmail(email);
                        boolean khUpdated = controller.updateKhachHang(khachHang);

                        if (khUpdated) {
                            // Cập nhật thông tin xe sau khi cập nhật khách hàng thành công
                            String bienSo = textField_bienso.getText();
                            String hieuXe = (String) comboBox_hieuxe.getSelectedItem();
                            String ngayTiepNhanStr = textField_thoigiantiepnhan.getText();

                            Date ngayTiepNhan = null; // định dạng lại ngày
                            try {
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                java.util.Date date = sdf.parse(ngayTiepNhanStr);
                                ngayTiepNhan = new Date(date.getTime());
                            } catch (ParseException ex) {
                                JOptionPane.showMessageDialog(null, "Ngày tiếp nhận không đúng định dạng. Vui lòng nhập ngày theo định dạng DD/MM/YYYY.");
                                return;
                            }

                            Xe xe = new Xe(bienSo, khachHang.getMaKH(), hieuXe, currentTienNo, ngayTiepNhan);
                            boolean xeUpdated = controller.updateXe(currentBienSo, xe);

                            if (xeUpdated) {
                                JOptionPane.showMessageDialog(null, "Cập nhật thông tin xe và khách hàng thành công!");
                                refreshTable();
                                resetFields();
                                currentBienSo = null; // Reset currentBienSo
                                currentMaKH = null; // Reset currentMaKH
                                currentTienNo = 0.0; // Reset currentTienNo
                            } else {
                                JOptionPane.showMessageDialog(null, "Cập nhật thông tin xe thất bại. Vui lòng kiểm tra lại!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Cập nhật thông tin khách hàng thất bại. Vui lòng kiểm tra lại!");
                        }
                    }
                }
            }
        });

        JButton button_luumoi_tiepnhanxe = new JButton("Lưu mới");
        button_luumoi_tiepnhanxe.setFont(new Font("Tahoma", Font.BOLD, 11));
        button_luumoi_tiepnhanxe.setBounds(109, 413, 89, 35);
        add(button_luumoi_tiepnhanxe);

        button_luumoi_tiepnhanxe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // hành động lưu mới xảy ra 1 trong 2 trường hợp sau.
                if (textField_tenkhachhangmoi.getText().isEmpty()) {
                    // Sử dụng tên trong comboBox_tenkhachhang
                    String hoTenKH = (String) comboBox_tenkhachhang.getSelectedItem();
                    String dienThoai = textField_sodienthoai.getText();
                    String email = textField_email.getText();

                    // kiểm tra khách hàng đã tồn tại trong cơ sở dữ liệu chưa
                    KhachHang existingKhachHang = controller.getKhachHangByDetails(hoTenKH, dienThoai, email);

                    if (existingKhachHang != null) { // có thì chỉ lưu thêm thông tin xe thôi
                        boolean xeSaved = luuMoiThongTinXe(existingKhachHang.getMaKH());
                        if (xeSaved) {
                            JOptionPane.showMessageDialog(null, "Thông tin xe đã được lưu thành công!");
                            refreshTable(); // Cập nhật bảng sau khi lưu mới
                        } else {
                            JOptionPane.showMessageDialog(null, "Lưu thông tin xe thất bại. Vui lòng kiểm tra lại!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng. Vui lòng kiểm tra lại thông tin!");
                    }
                } else {
                    // Sử dụng thông tin từ textField_tenkhachhangmoi
                    String maKH = luuMoiThongTinKhachHang();
                    if (maKH != null) {
                        boolean xeSaved = luuMoiThongTinXe(maKH);
                        if (xeSaved) {
                            // load lại comboBox
                            loadKhachHangToComboBox();
                            comboBox_tenkhachhang.setSelectedItem(textField_tenkhachhangmoi.getText());
                            JOptionPane.showMessageDialog(null, "Thông tin khách hàng và xe đã được lưu thành công!");
                            refreshTable(); // Cập nhật bảng sau khi lưu mới
                        } else {
                            JOptionPane.showMessageDialog(null, "Lưu thông tin xe thất bại. Vui lòng kiểm tra lại!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lưu thông tin khách hàng thất bại. Vui lòng kiểm tra lại!");
                    }
                }
            }
        });

        JButton button_sua_tiepnhanxe = new JButton("Sửa");
        button_sua_tiepnhanxe.setFont(new Font("Tahoma", Font.BOLD, 11));
        button_sua_tiepnhanxe.setBounds(217, 413, 89, 35);
        add(button_sua_tiepnhanxe);

        button_sua_tiepnhanxe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    currentBienSo = (String) table.getValueAt(selectedRow, 0); // lấy biển số xe

                    // lấy ra khách hàng và xe tương ứng
                    Xe xe = controller.getXeByBienSo(currentBienSo);
                    KhachHang kh = controller.getKhachHangById(xe.getMaKH());

                    currentMaKH = kh.getMaKH(); // lưu lại mã khách hànghienejn tại để có thể kiểm tra thông tin khi sửa khách hàng
                    currentTienNo = xe.getTienNo(); // Lưu lại tiền nợ hiện tại của xe
                    textField_tenkhachhangmoi.setText(kh.getHoTenKH());
                    textField_sodienthoai.setText(kh.getDienThoai());
                    textField_email.setText(kh.getEmail());
                    textField_bienso.setText(xe.getBienSo());
                    comboBox_hieuxe.setSelectedItem(xe.getTenHX());
                    textField_thoigiantiepnhan.setText(new SimpleDateFormat("dd/MM/yyyy").format(xe.getNgayTiepNhan()));
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn xe cần sửa.");
                }
            }
        });

        JButton button_xoa_tiepnhanxe = new JButton("Xóa");
        button_xoa_tiepnhanxe.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_xoa_tiepnhanxe.setBounds(316, 413, 89, 35);
        add(button_xoa_tiepnhanxe);

        button_xoa_tiepnhanxe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String bienSo = (String) table.getValueAt(selectedRow, 0);
                    String maKH = (String) table.getValueAt(selectedRow, 3);
                    int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa xe này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        // Kiểm tra xem xe này có phải là xe cuối cùng của khách hàng hay không
                        boolean isLastCar = controller.isLastCarOfCustomer(maKH);
                        boolean xeDeleted = controller.deleteXe(bienSo);
                        if (xeDeleted) { // sau khi xe đã xóa
                            if (isLastCar) { // nếu đây là chiếc xe cuối cùng của khach thì xóa luôn thông tin khách
                                controller.deleteKhachHang(maKH);
                            }
                            JOptionPane.showMessageDialog(null, "Xóa thông tin xe thành công!");
                            refreshTable(); // Cập nhật bảng sau khi xóa
                        } else {
                            JOptionPane.showMessageDialog(null, "Xóa thông tin xe thất bại. Vui lòng kiểm tra lại!");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn xe cần xóa.");
                }
            }
        });

        JButton button_lammoi = new JButton("Làm mới");
        button_lammoi.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoi.setBounds(316, 344, 89, 35);
        add(button_lammoi);

        button_lammoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });

        loadKhachHangToComboBox();
        refreshTable();
    }

    private void resetFields() {
        textField_tenkhachhangmoi.setText("");
        textField_sodienthoai.setText("");
        textField_email.setText("");
        textField_bienso.setText("");
        comboBox_hieuxe.setSelectedIndex(0);
        textField_thoigiantiepnhan.setText("");
        comboBox_tenkhachhang.setSelectedIndex(-1);
        currentBienSo = null; // Reset currentBienSo
        currentMaKH = null; // Reset currentMaKH
        currentTienNo = 0.0; // Reset currentTienNo
    }

    private String luuMoiThongTinKhachHang() {
        String maKH = generateMaKH();
        String hoTenKH = textField_tenkhachhangmoi.getText();
        String dienThoai = textField_sodienthoai.getText();
        String email = textField_email.getText();

        KhachHang khachHang = new KhachHang(maKH, hoTenKH, dienThoai, email);
        return controller.saveKhachHang(khachHang);
    }

    private boolean luuMoiThongTinXe(String maKH) {
        String bienSo = textField_bienso.getText();
        String hieuXe = (String) comboBox_hieuxe.getSelectedItem();
        String ngayTiepNhanStr = textField_thoigiantiepnhan.getText();

        Date ngayTiepNhan = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = sdf.parse(ngayTiepNhanStr);
            ngayTiepNhan = new Date(date.getTime());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày tiếp nhận không đúng định dạng. Vui lòng nhập ngày theo định dạng DD/MM/YYYY.");
            return false;
        }
        Xe xe = new Xe(bienSo, maKH, hieuXe, 0.0, ngayTiepNhan);
        return controller.saveXe(xe);
    }

    private void loadKhachHangToComboBox() {
        comboBox_tenkhachhang.removeAllItems();
        List<KhachHang> khachHangList = controller.getAllKhachHang();
        for (KhachHang kh : khachHangList) {
            comboBox_tenkhachhang.addItem(kh.getHoTenKH());
        }
    }

    private String generateMaKH() {
        List<KhachHang> khachHangList = controller.getAllKhachHang();
        int max = 0;
        for (KhachHang kh : khachHangList) {
            String maKH = kh.getMaKH();
            int number = Integer.parseInt(maKH.substring(2));
            if (number > max) {
                max = number;
            }
        }
        return "KH" + String.format("%04d", max + 1);
    }

    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // lấy lại các xe trong list xe và hiển thị ra lại bảng
        List<Xe> xeList = controller.getAllXe();
        for (Xe xe : xeList) {
            KhachHang kh = controller.getKhachHangById(xe.getMaKH());
            model.addRow(new Object[]{
                    xe.getBienSo(),
                    xe.getTenHX(),
                    kh != null ? kh.getHoTenKH() : "",
                    xe.getMaKH(),
                    kh != null ? kh.getDienThoai() : ""
            });
        }
    }
}
