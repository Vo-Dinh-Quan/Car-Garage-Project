package View.frame;

import View.panel.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HomeFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JLabel label_xinchao;
    private JLabel label_quanlygaraoto;
    private JLabel label_icon;

    public HomeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.WHITE);  // Thiết lập màu nền trắng cho contentPane
        setContentPane(contentPane);
        contentPane.setLayout(null);

        tabbedPane.setTabPlacement(JTabbedPane.LEFT); // Thiết lập tab theo chiều ngang bên trái
        tabbedPane.setBounds(0, 41, 984, 520); // Đặt kích thước cho JTabbedPane
        tabbedPane.setBackground(Color.WHITE);  // Thiết lập màu nền trắng cho tabbedPane
        contentPane.add(tabbedPane);

        // Thêm các Panel đã tách ra thành các lớp riêng biệt vào JTabbedPane
        tabbedPane.addTab("Tiếp nhận xe", null, new PanelTiepNhanXe(), null);
        tabbedPane.addTab("Lập phiếu sửa chữa", null, new PanelLapPhieuSuaChua(), null);
        tabbedPane.addTab("Lập phiếu thu tiền", null, new PanelLapPhieuThuTien(), null);
        tabbedPane.addTab("Quản lý VTPT", null, new PanelQuanLyVTPT(), null);
        tabbedPane.addTab("Tra cứu", null, new PanelTraCuu(), null);
        tabbedPane.addTab("Báo cáo", null, new PanelBaoCao(), null);

        label_xinchao = new JLabel("Xin chào ADMIN");
        ImageIcon originalIconXinchao = new ImageIcon("E:\\Code With Me\\IS216_Java\\Gaga_Oto_Project\\src\\image\\username-icon.png");
        Image originalImageXinchao = originalIconXinchao.getImage();
        Image scaledImageXinchao = originalImageXinchao.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledIconXinchao = new ImageIcon(scaledImageXinchao);
        label_xinchao.setIcon(scaledIconXinchao);
        label_xinchao.setHorizontalAlignment(SwingConstants.LEFT);
        label_xinchao.setFont(new Font("Segoe UI", Font.BOLD, 16));
        label_xinchao.setForeground(new Color(0, 0, 0));
        label_xinchao.setBackground(new Color(0, 0, 0));
        label_xinchao.setBounds(757, 0, 217, 40);
        label_xinchao.setOpaque(true); // Thiết lập để hiển thị màu nền
        label_xinchao.setBackground(Color.WHITE); // Thiết lập màu nền là màu trắng
        contentPane.add(label_xinchao);


        // Load và thay đổi kích thước của login_im.jpg
        ImageIcon loginIcon = new ImageIcon("E:\\Code With Me\\IS216_Java\\Gaga_Oto_Project\\src\\image\\login_im.jpg");
        Image loginImg = loginIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        loginIcon = new ImageIcon(loginImg);

        label_quanlygaraoto = new JLabel("QUẢN LÝ GARA O-TO");
        label_quanlygaraoto.setIcon(loginIcon);
        label_quanlygaraoto.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        label_quanlygaraoto.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        label_quanlygaraoto.setHorizontalAlignment(SwingConstants.CENTER);
        label_quanlygaraoto.setBounds(0, 0, 585, 40);
        label_quanlygaraoto.setOpaque(true);  // Thiết lập để hiển thị màu nền
        label_quanlygaraoto.setBackground(Color.WHITE);  // Thiết lập màu nền là màu trắng
        contentPane.add(label_quanlygaraoto);

        JButton button_doimatkhau = new JButton("Đổi mật khẩu");
        button_doimatkhau.setFont(new Font("Segoe UI", Font.BOLD, 13));
        button_doimatkhau.setBounds(590, 0, 145, 40);
        contentPane.add(button_doimatkhau);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeFrame homeFrame = new HomeFrame();
            homeFrame.setVisible(true);
        });
    }
}
