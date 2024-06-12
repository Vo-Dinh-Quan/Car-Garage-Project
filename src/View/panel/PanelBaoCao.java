package View.panel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import Controller.BaoCaoController;
import Models.entity.BaoCaoDoanhSo;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PanelBaoCao extends JPanel {
    private JTable table_baocaodoanhso;
    private JTextField textField_nam;
    private JComboBox comboBox_thang;
    private List<BaoCaoDoanhSo> datas;
    private BaoCaoController baoCaoController;
    private String[][] datasTable;
    private JComboBox comboBox_thang_1;
    private DefaultTableModel tableModel;
    private DefaultComboBoxModel<String> comboboxModel;
    public PanelBaoCao() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane_1.setBounds(0, 0, 841, 495);
        add(tabbedPane_1);

        JPanel panel_baocaodoanhthu = new JPanel();
        tabbedPane_1.addTab("Báo cáo doanh thu", null, panel_baocaodoanhthu, null);
        panel_baocaodoanhthu.setLayout(null);

        JLabel label_baocaodoanhso = new JLabel("BÁO CÁO DOANH SỐ");
        label_baocaodoanhso.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        label_baocaodoanhso.setBounds(188, 11, 388, 27);
        label_baocaodoanhso.setHorizontalAlignment(SwingConstants.CENTER);
        label_baocaodoanhso.setFont(new Font("Segoe UI", Font.BOLD, 20));
        panel_baocaodoanhthu.add(label_baocaodoanhso);

        JScrollPane scrollPane_baocaodoanhso = new JScrollPane();
        scrollPane_baocaodoanhso.setBounds(10, 182, 816, 285);
        panel_baocaodoanhthu.add(scrollPane_baocaodoanhso);

        table_baocaodoanhso = new JTable();
        scrollPane_baocaodoanhso.setViewportView(table_baocaodoanhso);

        JLabel label_thang = new JLabel("Tháng:");
        label_thang.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_thang.setBounds(10, 57, 64, 35);
        panel_baocaodoanhthu.add(label_thang);

        JLabel label_nam = new JLabel("Năm: ");
        label_nam.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_nam.setBounds(10, 103, 64, 35);
        panel_baocaodoanhthu.add(label_nam);

        LocalDate today = LocalDate.now();

        textField_nam = new JTextField();
        textField_nam.setFont(new Font("Segoe UI", Font.BOLD, 11));
        textField_nam.setColumns(10);
        textField_nam.setBounds(84, 103, 145, 35);
        panel_baocaodoanhthu.add(textField_nam);
        textField_nam.setText(String.valueOf(today.getYear()));

        comboBox_thang = new JComboBox();
        comboBox_thang.setFont(new Font("Segoe UI", Font.BOLD, 11));
        comboBox_thang.setBounds(84, 58, 145, 35);
        panel_baocaodoanhthu.add(comboBox_thang);

        String[] months = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(months);
        comboBox_thang.setModel(model);
        comboBox_thang.setSelectedIndex(today.getMonthValue() - 1);

        JButton button_lapbaocao = new JButton("Lập báo cáo");
        button_lapbaocao.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lapbaocao.setBounds(250, 58, 132, 35);
        panel_baocaodoanhthu.add(button_lapbaocao);

        JButton button_xoabaocao = new JButton("Xóa báo cáo");
        button_xoabaocao.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_xoabaocao.setBounds(250, 103, 132, 35);
        panel_baocaodoanhthu.add(button_xoabaocao);

        comboBox_thang_1 = new JComboBox();
        comboBox_thang_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
        comboBox_thang_1.setBounds(681, 57, 145, 35);
        panel_baocaodoanhthu.add(comboBox_thang_1);

        JLabel label_mabaocao = new JLabel("Mã báo cáo:");
        label_mabaocao.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_mabaocao.setBounds(604, 57, 76, 35);
        panel_baocaodoanhthu.add(label_mabaocao);

        JButton button_timkiem = new JButton("Tìm kiếm ");
        button_timkiem.setFont(new Font("Tahoma", Font.BOLD, 11));
        button_timkiem.setBounds(707, 103, 119, 35);
        panel_baocaodoanhthu.add(button_timkiem);

        button_lapbaocao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                lapBaoCao();
            }
        });

        button_timkiem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                search();
            }
        });
        button_xoabaocao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                xoa();
            }
        });
        baoCaoController = new BaoCaoController();
        getDatas();
    }
    private void search() {
        if (comboBox_thang_1.getSelectedIndex() == 0)
        {
            setTable(datas);
            return;
        }
        String ma = comboBox_thang_1.getSelectedItem().toString();
        List<BaoCaoDoanhSo> list = new ArrayList();
        for (int i = 0; i < datas.size(); i++)
            if (datas.get(i).getMaBCDS().equals(ma))
            {
                list.add(datas.get(i));
                setTable(list);
                return;
            }
    }
    private void setTable(List<BaoCaoDoanhSo> datas) {
        String[] columns = new String[]{
                "Mã báo cáo", "Tháng", "Năm", "Tổng doanh thu"
        };
        datasTable = new String[datas.size()][columns.length];
        for (int i = 0; i < datas.size(); i++)
        {
            datasTable[i][0] = datas.get(i).getMaBCDS();
            datasTable[i][1] = String.valueOf(datas.get(i).getThang());
            datasTable[i][2] = String.valueOf(datas.get(i).getNam());
            datasTable[i][3] = String.valueOf(datas.get(i).getTongDoanhThu());
        }
        tableModel = new DefaultTableModel(
                datasTable, columns
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }
        };
        table_baocaodoanhso.setModel(tableModel);
    }
    private void getDatas() {
        datas = baoCaoController.getAll();
        if (datas == null) return;
        setTable(datas);
        initCombobox();
    }
    private void initCombobox() {
        String[] comboboxId = new String[datas.size() + 1];
        comboboxId[0] = "Chọn mã";
        for (int i = 0; i < datas.size(); i++)
            comboboxId[i + 1] = datas.get(i).getMaBCDS();
        comboboxModel = new DefaultComboBoxModel<>(comboboxId);
        comboBox_thang_1.setModel(comboboxModel);
    }
    private void lapBaoCao() {
        int month = comboBox_thang.getSelectedIndex() + 1;
        int year;
        try {
            year = Integer.valueOf(textField_nam.getText());
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(this, "Năm không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (datas.size() > 0) { // kiểm tra các báo cáo đã lập
            for (int i = 0; i < datas.size(); i++) {
                BaoCaoDoanhSo bc = datas.get(i);
                if (bc.getThang() == month &&
                        bc.getNam() == year)
                {
                    JOptionPane.showMessageDialog(this, "Tháng " + month + " năm " + year +
                                    " đã được lập báo cáo trước đó"
                            , "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        BaoCaoDoanhSo baoCaoDoanhSo = baoCaoController.add(month, year);
        if (baoCaoDoanhSo == null) {
            JOptionPane.showMessageDialog(this, "Lập báo cáo thất bại"
                    , "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            if (datas == null) {
                datas = new ArrayList();
            }
            if (datas.size() == 0) {
                datas.add(baoCaoDoanhSo);
                setTable(datas);
            }
            else {
                if (datas.get(0).getNam() > year ||
                        (datas.get(0).getNam() == year && datas.get(0).getThang() > month)) {
                    datas.add(0, baoCaoDoanhSo);
                    setTable(datas);
                    initCombobox();
                    return;
                }
                for (int i = 0; i < datas.size(); i++) {
                    BaoCaoDoanhSo bc = datas.get(i);
                    if ((year == bc.getNam() && month > bc.getThang()) ||
                            year > bc.getNam())
                    {
                        datas.add(i, baoCaoDoanhSo);
                        setTable(datas);
                        initCombobox();
                        return;
                    }
                }
                datas.add(baoCaoDoanhSo);
                if (comboBox_thang_1.getSelectedIndex() == 0) {
                    Object[] newRow = new Object[4];
                    newRow[0] = baoCaoDoanhSo.getMaBCDS();
                    newRow[1] = baoCaoDoanhSo.getThang();
                    newRow[2] = baoCaoDoanhSo.getNam();
                    newRow[3] = baoCaoDoanhSo.getTongDoanhThu();
                    tableModel.addRow(newRow);
                    comboboxModel.addElement(baoCaoDoanhSo.getMaBCDS());
                } else {
                    setTable(datas);
                    initCombobox();
                }
            }
        }
    }
    private void xoa() {
        if (table_baocaodoanhso.getSelectedRowCount() == 0)
        {
            JOptionPane.showMessageDialog(this, "Phải chọn 1 hàng dữ liệu trên bảng"
                    , "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn xóa báo cáo doanh số này?",
                "Xác nhận", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION)
            return;
        int index = table_baocaodoanhso.getSelectedRow();
        if (!baoCaoController.remove(datas.get(index).getMaBCDS())) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại"
                    , "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        tableModel.removeRow(index);
        comboboxModel.removeElementAt(index);
    }
}
