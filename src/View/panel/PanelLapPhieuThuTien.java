package View.panel;

import Controller.PhieuThuTienController;
import Models.entity.PhieuThuTien;
import Models.entity.KhachHang;
import Models.entity.Xe;
import Models.entity.CTSuDungVTPT;
import Models.entity.SuDungTienCong;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    private PhieuThuTien selectedPhieuThuTien;

    public PanelLapPhieuThuTien() {
        controller = new PhieuThuTienController();

        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        JLabel label_lapphieuthutien = new JLabel("LẬP PHIẾU THU TIỀN");
        label_lapphieuthutien.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        label_lapphieuthutien.setBounds(284, 11, 210, 27);
        label_lapphieuthutien.setHorizontalAlignment(SwingConstants.CENTER);
        label_lapphieuthutien.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        add(label_lapphieuthutien);

        JLabel label_biensoxe_phieuthutien = new JLabel("Biển số xe:");
        label_biensoxe_phieuthutien.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 11));
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
        label_hotenchuxe.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 11));
        label_hotenchuxe.setBounds(452, 83, 109, 29);
        add(label_hotenchuxe);

        JLabel label_sotienthu = new JLabel("Số tiền thu:");
        label_sotienthu.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 11));
        label_sotienthu.setBounds(20, 130, 109, 29);
        add(label_sotienthu);

        JLabel label_sodienthoai_phieuthutien = new JLabel("Số điện thoại:");
        label_sodienthoai_phieuthutien.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 11));
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
        label_ngaythutien_phieuthutien.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 11));
        label_ngaythutien_phieuthutien.setBounds(452, 200, 109, 29);
        add(label_ngaythutien_phieuthutien);

        textField_ngaythutien_phieuthutien = new JTextField();
        textField_ngaythutien_phieuthutien.setColumns(10);
        textField_ngaythutien_phieuthutien.setBounds(571, 199, 264, 30);
        add(textField_ngaythutien_phieuthutien);

        JLabel label_email_phieuthutien = new JLabel("Email:");
        label_email_phieuthutien.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 11));
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
        label_sotienno_phieuthutien.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 11));
        label_sotienno_phieuthutien.setBounds(452, 315, 109, 29);
        add(label_sotienno_phieuthutien);

        JButton button_luu_phieuthutien = new JButton("Lưu");
        button_luu_phieuthutien.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 11));
        button_luu_phieuthutien.setBounds(312, 170, 109, 39);
        button_luu_phieuthutien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                luuPhieuThuTien();
            }
        });
        add(button_luu_phieuthutien);

        JButton button_lammoi_phieuthutien = new JButton("Làm mới");
        button_lammoi_phieuthutien.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 11));
        button_lammoi_phieuthutien.setBounds(193, 170, 109, 39);
        button_lammoi_phieuthutien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        add(button_lammoi_phieuthutien);

        JButton button_inphieuthu = new JButton("In phiếu thu");
        button_inphieuthu.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 11));
        button_inphieuthu.setBounds(193, 220, 228, 39);
        button_inphieuthu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedPhieuThuTien != null) {
                    inPhieuThuTien(selectedPhieuThuTien);
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu thu từ danh sách trước khi in.");
                }
            }
        });
        add(button_inphieuthu);

        Box verticalBox = Box.createVerticalBox();
        verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        verticalBox.setBounds(430, 49, 411, 457);
        add(verticalBox);

        JScrollPane scrollPane_danhsachphieuthu = new JScrollPane();
        scrollPane_danhsachphieuthu.setBounds(10, 289, 411, 217);
        add(scrollPane_danhsachphieuthu);

        JButton button_lammoi_danhsachphieuthu = new JButton("Làm mới");
        button_lammoi_danhsachphieuthu.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 11));
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
        table_danhsachphieuthu.getSelectionModel().addListSelectionListener(event -> {
            int selectedRow = table_danhsachphieuthu.getSelectedRow();
            if (selectedRow != -1) {
                selectedPhieuThuTien = new PhieuThuTien(
                        (String) table_danhsachphieuthu.getValueAt(selectedRow, 0),
                        (String) table_danhsachphieuthu.getValueAt(selectedRow, 1),
                        (Double) table_danhsachphieuthu.getValueAt(selectedRow, 2),
                        (Date) table_danhsachphieuthu.getValueAt(selectedRow, 3)
                );
            }
        });
        scrollPane_danhsachphieuthu.setViewportView(table_danhsachphieuthu);

        loadDataToComboBox();
    }

    private void refresh_table_danhsachphieuthu() {
        DefaultTableModel model = (DefaultTableModel) table_danhsachphieuthu.getModel();
        model.setRowCount(0);

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
        clearFields();
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

    private void inPhieuThuTien(PhieuThuTien phieuThuTien) {
        KhachHang khachHang = controller.getKhachHangByBienSo(phieuThuTien.getBienSo());
        List<CTSuDungVTPT> ctSuDungVTPTList = controller.getCTSuDungVTPTByBienSo(phieuThuTien.getBienSo());
        List<SuDungTienCong> suDungTienCongList = controller.getSuDungTienCongByBienSo(phieuThuTien.getBienSo());

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("PhieuThuTien.pdf"));
            document.open();

            BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font titleFont = new Font(baseFont, 18, Font.BOLD);
            Font contentFont = new Font(baseFont, 12, Font.NORMAL);
            Font headerFont = new Font(baseFont, 12, Font.BOLD);

            // logo
            String logoPath = "E:\\Code With Me\\IS216_Java\\Gaga_Oto_Project\\src\\image\\login_im.jpg";
            Image logo = Image.getInstance(logoPath);
            logo.scaleToFit(50, 50);
            logo.setAlignment(Element.ALIGN_LEFT);
            document.add(logo);


            // title
            Paragraph title = new Paragraph("Phiếu Thu Tiền", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("Mã khách hàng: " + khachHang.getMaKH(), contentFont));
            document.add(new Paragraph("Tên khách hàng: " + khachHang.getHoTenKH(), contentFont));
            document.add(new Paragraph("Số điện thoại: " + khachHang.getDienThoai(), contentFont));
            document.add(new Paragraph("Email: " + khachHang.getEmail(), contentFont));

            document.add(new Paragraph(" "));

            PdfPTable tableVTPT = new PdfPTable(5);
            tableVTPT.setWidthPercentage(100);
            tableVTPT.setSpacingBefore(10f);
            tableVTPT.setSpacingAfter(10f);

            PdfPCell cell = new PdfPCell(new Paragraph("Vật tư phụ tùng sử dụng", headerFont));
            cell.setColspan(5);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableVTPT.addCell(cell);

            tableVTPT.addCell(new PdfPCell(new Paragraph("Mã VTPT", headerFont)));
            tableVTPT.addCell(new PdfPCell(new Paragraph("Tên VTPT", headerFont)));
            tableVTPT.addCell(new PdfPCell(new Paragraph("Đơn giá", headerFont)));
            tableVTPT.addCell(new PdfPCell(new Paragraph("Số lượng", headerFont)));
            tableVTPT.addCell(new PdfPCell(new Paragraph("Thành tiền", headerFont)));

            for (CTSuDungVTPT vtpt : ctSuDungVTPTList) {
                tableVTPT.addCell(new PdfPCell(new Paragraph(vtpt.getMaVTPT(), contentFont)));
                tableVTPT.addCell(new PdfPCell(new Paragraph(vtpt.getTenVTPT(), contentFont)));
                tableVTPT.addCell(new PdfPCell(new Paragraph(String.valueOf(vtpt.getDonGiaBan()), contentFont)));
                tableVTPT.addCell(new PdfPCell(new Paragraph(String.valueOf(vtpt.getSoLuongSuDung()), contentFont)));
                tableVTPT.addCell(new PdfPCell(new Paragraph(String.valueOf(vtpt.getThanhTien()), contentFont)));
            }

            document.add(tableVTPT);

            PdfPTable tableTienCong = new PdfPTable(2);
            tableTienCong.setWidthPercentage(100);
            tableTienCong.setSpacingBefore(10f);
            tableTienCong.setSpacingAfter(10f);

            cell = new PdfPCell(new Paragraph("Tiền công sử dụng", headerFont));
            cell.setColspan(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableTienCong.addCell(cell);

            tableTienCong.addCell(new PdfPCell(new Paragraph("Tên TC", headerFont)));
            tableTienCong.addCell(new PdfPCell(new Paragraph("Chi phí TC", headerFont)));

            for (SuDungTienCong tc : suDungTienCongList) {
                tableTienCong.addCell(new PdfPCell(new Paragraph(tc.getTenTC(), contentFont)));
                tableTienCong.addCell(new PdfPCell(new Paragraph(String.valueOf(tc.getChiPhiTC()), contentFont)));
            }

            document.add(tableTienCong);

            document.add(new Paragraph("Ngày thu tiền: " + new SimpleDateFormat("dd/MM/yyyy").format(phieuThuTien.getNgayThuTien()), contentFont));

            document.close();
            JOptionPane.showMessageDialog(this, "In phiếu thu thành công.");
        } catch (DocumentException | java.io.IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi in phiếu thu: " + e.getMessage());
        }
    }

}
