package Models.dao;

import Models.entity.TaiKhoan;
import Utils.Database_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO {

    public TaiKhoan getTaiKhoanByUsername(String tenDangNhap) {
        Connection connection = Database_Connection.getConnection();
        TaiKhoan taiKhoan = null;

        String query = "SELECT * FROM TAIKHOAN WHERE TENDANGNHAP = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tenDangNhap);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String chucVu = resultSet.getString("CHUCVU");
                String username = resultSet.getString("TENDANGNHAP");
                String password = resultSet.getString("MATKHAU");
                taiKhoan = new TaiKhoan(chucVu, username, password);
                System.out.println("User found: " + taiKhoan);
            } else {
                System.out.println("No user found with username: " + tenDangNhap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database_Connection.closeConnection(connection);
        }
        return taiKhoan;
    }

    // Thêm phương thức để lấy tất cả các tài khoản
    public List<TaiKhoan> getAllTaiKhoan() {
        Connection connection = Database_Connection.getConnection();
        List<TaiKhoan> taiKhoanList = new ArrayList<>();

        String query = "SELECT * FROM TAIKHOAN";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String chucVu = resultSet.getString("CHUCVU");
                String username = resultSet.getString("TENDANGNHAP");
                String password = resultSet.getString("MATKHAU");
                TaiKhoan taiKhoan = new TaiKhoan(chucVu, username, password);
                taiKhoanList.add(taiKhoan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database_Connection.closeConnection(connection);
        }

        return taiKhoanList;
    }

    // Thêm phương thức để thêm tài khoản
    public boolean addTaiKhoan(TaiKhoan taiKhoan) {
        Connection connection = Database_Connection.getConnection();
        String query = "INSERT INTO TAIKHOAN (CHUCVU, TENDANGNHAP, MATKHAU) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, taiKhoan.getChucVu());
            preparedStatement.setString(2, taiKhoan.getTenDangNhap());
            preparedStatement.setString(3, taiKhoan.getMatKhau());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database_Connection.closeConnection(connection);
        }

        return false;
    }

    // Thêm phương thức để sửa tài khoản
    public boolean updateTaiKhoan(TaiKhoan taiKhoan) {
        Connection connection = Database_Connection.getConnection();
        String query = "UPDATE TAIKHOAN SET CHUCVU = ?, MATKHAU = ? WHERE TENDANGNHAP = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, taiKhoan.getChucVu());
            preparedStatement.setString(2, taiKhoan.getMatKhau());
            preparedStatement.setString(3, taiKhoan.getTenDangNhap());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database_Connection.closeConnection(connection);
        }

        return false;
    }

    // Thêm phương thức để xóa tài khoản
    public boolean deleteTaiKhoan(String tenDangNhap) {
        Connection connection = Database_Connection.getConnection();
        String query = "DELETE FROM TAIKHOAN WHERE TENDANGNHAP = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tenDangNhap);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database_Connection.closeConnection(connection);
        }

        return false;
    }
    // Phương thức thay đổi mật khẩu
    public boolean changePassword(String username, String currentPassword, String newPassword) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "UPDATE TAIKHOAN SET MATKHAU = ? WHERE TENDANGNHAP = ? AND MATKHAU = ?";
        try {
            conn = Database_Connection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, newPassword);
            stmt.setString(2, username);
            stmt.setString(3, currentPassword);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Database_Connection.closeConnection(conn);
        }
    }


//    public static void main(String[] args) {
//        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
//
//        // Kiểm tra phương thức lấy tất cả tài khoản
//        List<TaiKhoan> allTaiKhoan = taiKhoanDAO.getAllTaiKhoan();
//        for (TaiKhoan taiKhoan : allTaiKhoan) {
//            System.out.println(taiKhoan);
//        }
//
//        // Kiểm tra phương thức thêm tài khoản
//        TaiKhoan newTaiKhoan = new TaiKhoan("Quan Ly", "quan", "quan");
//        boolean isAdded = taiKhoanDAO.addTaiKhoan(newTaiKhoan);
//        if (isAdded) {
//            System.out.println("New account added successfully.");
//        } else {
//            System.out.println("Failed to add new account.");
//        }

//        // Kiểm tra phương thức sửa tài khoản
//        TaiKhoan updatedTaiKhoan = new TaiKhoan("Quan Ly", "newUser", "newPassword123");
//        boolean isUpdated = taiKhoanDAO.updateTaiKhoan(updatedTaiKhoan);
//        if (isUpdated) {
//            System.out.println("Account updated successfully.");
//        } else {
//            System.out.println("Failed to update account.");
//        }
//
//        // Kiểm tra phương thức xóa tài khoản
//        boolean isDeleted = taiKhoanDAO.deleteTaiKhoan("admin");
//        if (isDeleted) {
//            System.out.println("Account deleted successfully.");
//        } else {
//            System.out.println("Failed to delete account.");
//        }
//    }
}
