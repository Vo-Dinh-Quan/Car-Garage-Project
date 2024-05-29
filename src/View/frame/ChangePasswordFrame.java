package View.frame;

import Controller.TaiKhoanController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private final JPasswordField PasswordField_matkhaumoi;
    private final JPasswordField PasswordField_matkhauhientai;
    private final JPasswordField PasswordField_xacnhanmatkhaumoi;
    private JPanel contentPane;
    private TaiKhoanController taiKhoanController;
    private String currentUsername;

    public ChangePasswordFrame(String currentUsername) {
        this.currentUsername = currentUsername;
        this.taiKhoanController = new TaiKhoanController();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icon = new ImageIcon("E:\\Code With Me\\IS216_Java\\Gaga_Oto_Project\\src\\image\\login_im.jpg");
        setIconImage(icon.getImage());

        JLabel label_matkhauhientai = new JLabel("Mật khẩu hiện tại:");
        label_matkhauhientai.setBounds(30, 30, 110, 25);
        contentPane.add(label_matkhauhientai);
        PasswordField_matkhauhientai = new JPasswordField();
        PasswordField_matkhauhientai.setBounds(180, 30, 230, 25);
        contentPane.add(PasswordField_matkhauhientai);

        JLabel label_matkhaumoi = new JLabel("Mật khẩu mới:");
        label_matkhaumoi.setBounds(30, 66, 110, 25);
        contentPane.add(label_matkhaumoi);

        PasswordField_matkhaumoi = new JPasswordField();
        PasswordField_matkhaumoi.setBounds(180, 66, 230, 25);
        contentPane.add(PasswordField_matkhaumoi);

        JLabel label_xacnhanmatkhaumoi = new JLabel("Xác nhận mật khẩu mới:");
        label_xacnhanmatkhaumoi.setBounds(30, 102, 150, 25);
        contentPane.add(label_xacnhanmatkhaumoi);

        PasswordField_xacnhanmatkhaumoi = new JPasswordField();
        PasswordField_xacnhanmatkhaumoi.setBounds(180, 102, 230, 25);
        contentPane.add(PasswordField_xacnhanmatkhaumoi);

        JButton button_doimatkhau = new JButton("Đổi mật khẩu");
        button_doimatkhau.setBounds(133, 155, 150, 30);
        contentPane.add(button_doimatkhau);
        setLocationRelativeTo(null);

        button_doimatkhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matKhauHienTai = new String(PasswordField_matkhauhientai.getPassword());
                String matKhauMoi = new String(PasswordField_matkhaumoi.getPassword());
                String xacNhanMatKhauMoi = new String(PasswordField_xacnhanmatkhaumoi.getPassword());

                if (!matKhauMoi.equals(xacNhanMatKhauMoi)) {
                    JOptionPane.showMessageDialog(null, "Mật khẩu mới và xác nhận mật khẩu không khớp!");
                    return;
                }

                boolean success = taiKhoanController.changePassword(currentUsername, matKhauHienTai, matKhauMoi);

                if (success) {
                    JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Đổi mật khẩu thất bại!");
                }
            }
        });
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            try {
//                String currentUsername = "user"; // Thay thế bằng cách lấy username thực tế từ phiên đăng nhập
//                ChangePasswordFrame frame = new ChangePasswordFrame(currentUsername);
//                frame.setVisible(true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }
}
