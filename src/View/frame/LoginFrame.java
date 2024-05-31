package View.frame;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import Models.service.TaiKhoanService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField textField_tentaikhoan;
    private JPasswordField textField_matkhau;
    private JPanel contentPane;
    private TaiKhoanService taiKhoanService;

    public LoginFrame() {
        taiKhoanService = new TaiKhoanService();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_image = new JPanel();
        panel_image.setBackground(new Color(255, 255, 255));
        panel_image.setBounds(0, 11, 237, 300);
        contentPane.add(panel_image);
        panel_image.setLayout(null);

        JLabel label_image = new JLabel("New label");
        ImageIcon originalIcon = new ImageIcon("E:\\Code With Me\\IS216_Java\\Gaga_Oto_Project\\src\\image\\login_im.jpg");
        Image originalImage = originalIcon.getImage();
        Image scaledImage_login_im = originalImage.getScaledInstance(217, 213, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage_login_im);
        label_image.setIcon(scaledIcon);
        label_image.setBounds(10, 30, 217, 213);
        panel_image.add(label_image);

        JPanel panel_login = new JPanel();
        panel_login.setBackground(new Color(255, 255, 255));
        panel_login.setBounds(237, 11, 347, 300);
        contentPane.add(panel_login);
        panel_login.setLayout(null);

        JLabel label_dangnhap = new JLabel("ĐĂNG NHẬP");
        label_dangnhap.setHorizontalAlignment(SwingConstants.CENTER);
        label_dangnhap.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
        label_dangnhap.setBounds(0, 11, 347, 57);
        panel_login.add(label_dangnhap);

        JLabel lblTnTaiKhoan = new JLabel("Tên Tài Khoản:");
        lblTnTaiKhoan.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblTnTaiKhoan.setBounds(0, 101, 347, 20);
        panel_login.add(lblTnTaiKhoan);

        textField_tentaikhoan = new JTextField();
        textField_tentaikhoan.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textField_tentaikhoan.setBounds(0, 119, 310, 35);
        panel_login.add(textField_tentaikhoan);
        textField_tentaikhoan.setColumns(10);

        JLabel label_matkhau = new JLabel("Mật Khẩu:");
        label_matkhau.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        label_matkhau.setBounds(0, 156, 347, 20);
        panel_login.add(label_matkhau);

        textField_matkhau = new JPasswordField();
        textField_matkhau.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textField_matkhau.setColumns(10);
        textField_matkhau.setBounds(0, 175, 311, 35);
        panel_login.add(textField_matkhau);

        // Resize và đặt icon cho label tài khoản
        JLabel label_icon_tentaikhoan = new JLabel("New label");
        ImageIcon originalIconUsername = new ImageIcon("E:\\Code With Me\\IS216_Java\\Gaga_Oto_Project\\src\\image\\username-icon.png");
        Image originalImageUsername = originalIconUsername.getImage();
        Image scaledImageUsername = originalImageUsername.getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        ImageIcon scaledIconUsername = new ImageIcon(scaledImageUsername);
        label_icon_tentaikhoan.setIcon(scaledIconUsername);
        label_icon_tentaikhoan.setBounds(312, 119, 26, 26);
        panel_login.add(label_icon_tentaikhoan);

        // Resize và đặt icon cho label mật khẩu
        JLabel label_icon_matkhau = new JLabel("New label");
        ImageIcon originalIconPassword = new ImageIcon("E:\\Code With Me\\IS216_Java\\Gaga_Oto_Project\\src\\image\\password-icon.png");
        Image originalImagePassword = originalIconPassword.getImage();
        Image scaledImagePassword = originalImagePassword.getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        ImageIcon scaledIconPassword = new ImageIcon(scaledImagePassword);
        label_icon_matkhau.setIcon(scaledIconPassword);
        label_icon_matkhau.setBounds(312, 175, 26, 26);
        panel_login.add(label_icon_matkhau);

        JLabel label_chaomung = new JLabel("Chào mừng quay trở lại !");
        label_chaomung.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        label_chaomung.setHorizontalAlignment(SwingConstants.CENTER);
        label_chaomung.setBounds(0, 65, 347, 14);
        panel_login.add(label_chaomung);

        JButton button_dangnhap = new JButton("Đăng Nhập");
        button_dangnhap.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button_dangnhap.setBounds(89, 212, 136, 33);
        panel_login.add(button_dangnhap);

        // Thêm sự kiện cho nút đăng nhập
        button_dangnhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
        setLocationRelativeTo(null);
    }

    private void handleLogin() {
        String username = textField_tentaikhoan.getText();
        String password = new String(textField_matkhau.getPassword());
        if (taiKhoanService.login(username, password)) {
            // Đăng nhập thành công
            this.dispose(); // Đóng màn hình đăng nhập
            openHomeFrame(username); // Mở màn hình trang chủ và truyền username
        } else {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openHomeFrame(String username) {
        HomeFrame homeFrame = new HomeFrame(username);
        homeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            SwingUtilities.invokeLater(() -> {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
