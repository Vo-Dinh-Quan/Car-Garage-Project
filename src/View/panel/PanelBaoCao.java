package View.panel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelBaoCao extends JPanel {
    private JTable table_baocaodoanhso;
    private JTextField textField_nam;

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
        table_baocaodoanhso.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                },
                new String[]{
                        "Mã báo cáo", "Tháng", "Năm", "Tổng doanh thu"
                }
        ));
        scrollPane_baocaodoanhso.setViewportView(table_baocaodoanhso);

        JLabel label_thang = new JLabel("Tháng:");
        label_thang.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_thang.setBounds(10, 57, 64, 35);
        panel_baocaodoanhthu.add(label_thang);

        JLabel label_nam = new JLabel("Năm: ");
        label_nam.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label_nam.setBounds(10, 103, 64, 35);
        panel_baocaodoanhthu.add(label_nam);

        textField_nam = new JTextField();
        textField_nam.setFont(new Font("Segoe UI", Font.BOLD, 11));
        textField_nam.setColumns(10);
        textField_nam.setBounds(84, 103, 145, 35);
        panel_baocaodoanhthu.add(textField_nam);

        JComboBox comboBox_thang = new JComboBox();
        comboBox_thang.setFont(new Font("Segoe UI", Font.BOLD, 11));
        comboBox_thang.setBounds(84, 58, 145, 35);
        panel_baocaodoanhthu.add(comboBox_thang);

        JButton button_lapbaocao = new JButton("Lập báo cáo");
        button_lapbaocao.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_lapbaocao.setBounds(250, 58, 132, 35);
        panel_baocaodoanhthu.add(button_lapbaocao);

        JButton button_xoabaocao = new JButton("Xóa báo cáo");
        button_xoabaocao.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button_xoabaocao.setBounds(250, 103, 132, 35);
        panel_baocaodoanhthu.add(button_xoabaocao);

        JComboBox comboBox_thang_1 = new JComboBox();
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
    }
}
