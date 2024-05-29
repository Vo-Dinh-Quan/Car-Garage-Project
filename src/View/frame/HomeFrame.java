package View.frame;

import View.panel.*;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    private String currentUsername; // Biến để lưu tên người dùng hiện tại

    public HomeFrame(String username) {
        this.currentUsername = username; // Lưu tên người dùng hiện tại
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
        tabbedPane.setBounds(0, 39, 984, 511);
        tabbedPane.setBackground(Color.WHITE);
        contentPane.add(tabbedPane);

        tabbedPane.addTab("Tiếp nhận xe", new ImageIcon("E:\\Code With Me\\IS216_Java\\Gaga_Oto_Project\\src\\image\\tiepnhanxe-icon.24.png"), new PanelTiepNhanXe(), null);
        tabbedPane.addTab("Lập phiếu sửa chữa", new ImageIcon("E:\\Code With Me\\IS216_Java\\Gaga_Oto_Project\\src\\image\\lapphieusuachua-icon.png"), new PanelLapPhieuSuaChua(), null);
        tabbedPane.addTab("Lập phiếu thu tiền", new ImageIcon("E:\\Code With Me\\IS216_Java\\Gaga_Oto_Project\\src\\image\\phieuthutien-icon.24.png"), new PanelLapPhieuThuTien(), null);
        tabbedPane.addTab("Quản lý VTPT", new ImageIcon("E:\\Code With Me\\IS216_Java\\Gaga_Oto_Project\\src\\image\\quanlyVTPT-icon.24.png"), new PanelQuanLyVTPT(), null);
        tabbedPane.addTab("Tra cứu", new ImageIcon("E:\\Code With Me\\IS216_Java\\Gaga_Oto_Project\\src\\image\\tracuu-icon.png"), new PanelTraCuu(), null);
        tabbedPane.addTab("Báo cáo", new ImageIcon("E:\\Code With Me\\IS216_Java\\Gaga_Oto_Project\\src\\image\\baocao-icon.png"), new PanelBaoCao(), null);

        JLabel label_xinchao = new JLabel(username);
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
        label_xinchao.setOpaque(true);
        label_xinchao.setBackground(Color.WHITE);
        contentPane.add(label_xinchao);

        ImageIcon loginIcon = new ImageIcon("E:\\Code With Me\\IS216_Java\\Gaga_Oto_Project\\src\\image\\login_im.jpg");
        Image loginImg = loginIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        loginIcon = new ImageIcon(loginImg);

        JLabel label_quanlygaraoto = new JLabel("QUẢN LÝ GARA O-TO");
        label_quanlygaraoto.setIcon(loginIcon);
        label_quanlygaraoto.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        label_quanlygaraoto.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        label_quanlygaraoto.setHorizontalAlignment(SwingConstants.CENTER);
        label_quanlygaraoto.setBounds(0, 0, 585, 40);
        label_quanlygaraoto.setOpaque(true);
        label_quanlygaraoto.setBackground(Color.WHITE);
        contentPane.add(label_quanlygaraoto);

        JButton button_doimatkhau = new JButton("Đổi mật khẩu");
        button_doimatkhau.setFont(new Font("Segoe UI", Font.BOLD, 13));
        button_doimatkhau.setBounds(590, 0, 145, 40);
        button_doimatkhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePasswordFrame changePasswordFrame = new ChangePasswordFrame(currentUsername);
                changePasswordFrame.setVisible(true);
            }
        });
        contentPane.add(button_doimatkhau);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            SwingUtilities.invokeLater(() -> {
                HomeFrame homeFrame = new HomeFrame("user"); // Thay thế bằng username thực tế
                homeFrame.setVisible(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
