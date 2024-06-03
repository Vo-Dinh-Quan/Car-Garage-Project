package View.panel;

import Controller.XeController;
import Models.entity.KhachHang;
import Models.entity.Xe;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelTraCuu extends JPanel {
    private JTable table_danhsachxe;
    private JTextField textField_bienso_tracuu;
    private JComboBox<String> comboBox_hieuxe_tracuu;
    private XeController xeController;

    public PanelTraCuu() {
        xeController = new XeController();
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        JLabel label_tracuu = new JLabel("TRA CỨU XE");
        label_tracuu.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        label_tracuu.setBounds(10, 38, 216, 27);
        label_tracuu.setHorizontalAlignment(SwingConstants.CENTER);
        label_tracuu.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(label_tracuu);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(231, 76, 587, 419);
        add(scrollPane);

        table_danhsachxe = new JTable();
        table_danhsachxe.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Biển số xe", "Hiệu xe", "Mã khách hàng", "Tên khách hàng", "Ngày tiếp nhận", "Tiền nợ"
                }
        ));
        scrollPane.setViewportView(table_danhsachxe);

        JLabel label_hieuxe_tracuu = new JLabel("Hiệu xe:");
        label_hieuxe_tracuu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_hieuxe_tracuu.setBounds(10, 76, 216, 34);
        add(label_hieuxe_tracuu);

        comboBox_hieuxe_tracuu = new JComboBox<>();
        comboBox_hieuxe_tracuu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        comboBox_hieuxe_tracuu.setBounds(10, 107, 216, 30);
        add(comboBox_hieuxe_tracuu);
        String[] hieuXe = {"", "Toyota", "Honda", "Ford", "BMW", "Mercedes", "Audi", "Hyundai", "Kia", "Mazda", "Nissan"};
        for (String hieu : hieuXe) {
            comboBox_hieuxe_tracuu.addItem(hieu);
        }

        JLabel label_bienso_tracuu = new JLabel("Biển số: ");
        label_bienso_tracuu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_bienso_tracuu.setBounds(10, 148, 216, 34);
        add(label_bienso_tracuu);

        textField_bienso_tracuu = new JTextField();
        textField_bienso_tracuu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        textField_bienso_tracuu.setColumns(10);
        textField_bienso_tracuu.setBounds(10, 177, 216, 30);
        add(textField_bienso_tracuu);

        JButton button_timkiem_tracuu = new JButton("Tìm kiếm");
        button_timkiem_tracuu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_timkiem_tracuu.setBounds(10, 237, 216, 34);
        add(button_timkiem_tracuu);

        JButton button_lammoi_tracuu = new JButton("Làm mới");
        button_lammoi_tracuu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lammoi_tracuu.setBounds(10, 274, 216, 34);
        add(button_lammoi_tracuu);

        loadDataToTable();

        button_timkiem_tracuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hieuXe = (String) comboBox_hieuxe_tracuu.getSelectedItem();
                String bienSo = textField_bienso_tracuu.getText();
                searchXe(hieuXe, bienSo);
            }
        });

        button_lammoi_tracuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField_bienso_tracuu.setText("");
                comboBox_hieuxe_tracuu.setSelectedIndex(0);
                loadDataToTable();
            }
        });
    }

    private void loadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) table_danhsachxe.getModel();
        model.setRowCount(0); // Clear existing data

        List<Xe> xeList = xeController.getAllXe();
        for (Xe xe : xeList) {
            KhachHang kh = xeController.getKhachHangById(xe.getMaKH());
            model.addRow(new Object[]{
                    xe.getBienSo(),
                    xe.getTenHX(),
                    xe.getMaKH(),
                    kh != null ? kh.getHoTenKH() : "",
                    xe.getNgayTiepNhan(),
                    xe.getTienNo(),
            });
        }
    }

    private void searchXe(String hieuXe, String bienSo) {
        DefaultTableModel model = (DefaultTableModel) table_danhsachxe.getModel();
        model.setRowCount(0); // Clear existing data

        List<Xe> xeList = xeController.searchXe(hieuXe, bienSo);
        for (Xe xe : xeList) {
            KhachHang kh = xeController.getKhachHangById(xe.getMaKH());
            model.addRow(new Object[]{
                    xe.getBienSo(),
                    xe.getTenHX(),
                    xe.getMaKH(),
                    kh != null ? kh.getHoTenKH() : "",
                    xe.getNgayTiepNhan(),
                    xe.getTienNo(),
            });
        }
    }
}
