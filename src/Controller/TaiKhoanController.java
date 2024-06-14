package Controller;

import Models.service.TaiKhoanService;
import Utils.Database_Connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class TaiKhoanController {
    private TaiKhoanService taiKhoanService;

    public TaiKhoanController() {
        this.taiKhoanService = new TaiKhoanService();
    }

    public boolean changePassword(String username, String currentPassword, String newPassword) {
        Connection conn = null;
        CallableStatement stmt = null;
        String sql = "{CALL ChangePassword(?, ?, ?, ?)}";

        try {
            conn = Database_Connection.getConnection();
            stmt = conn.prepareCall(sql);
            stmt.setString(1, username);
            stmt.setString(2, currentPassword);
            stmt.setString(3, newPassword);
            stmt.registerOutParameter(4, Types.INTEGER); // Biến OUT cho kết quả thành công

            stmt.execute();

            // Lấy kết quả
            int success = stmt.getInt(4);
            return success == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Database_Connection.closeConnection(conn);
        }
    }
}
