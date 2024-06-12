package Models.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.entity.BaoCaoDoanhSo;
import Utils.Database_Connection;

public class BaoCaoDAO {
    public BaoCaoDoanhSo search(String ma) {
        String query = "SELECT * FROM BAOCAODOANHSO WHERE MaBCDS = ? ORDER BY Nam, Thang";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, ma);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                BaoCaoDoanhSo baoCaoDoanhSo = new BaoCaoDoanhSo();
                baoCaoDoanhSo.setMaBCDS(rs.getString("MaBCDS"));
                baoCaoDoanhSo.setThang(rs.getInt("Thang"));
                baoCaoDoanhSo.setNam(rs.getInt("Nam"));
                baoCaoDoanhSo.setTongDoanhThu(rs.getBigDecimal("TongDoanhThu").doubleValue());
                return baoCaoDoanhSo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean existsByMonthYear(int month, int year) {
        String query = "SELECT COUNT(*) FROM BAOCAODOANHSO WHERE Thang = ? AND Nam = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, month);
            pstmt.setInt(2, year);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<BaoCaoDoanhSo> getAll() {
        List<BaoCaoDoanhSo> baoCaoDoanhSoList = new ArrayList<>();
        String query = "SELECT * FROM BAOCAODOANHSO";

        try (Connection conn = Database_Connection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                BaoCaoDoanhSo baoCaoDoanhSo = new BaoCaoDoanhSo();
                baoCaoDoanhSo.setMaBCDS(rs.getString("MaBCDS"));
                baoCaoDoanhSo.setThang(rs.getInt("Thang"));
                baoCaoDoanhSo.setNam(rs.getInt("Nam"));
                baoCaoDoanhSo.setTongDoanhThu(rs.getBigDecimal("TongDoanhThu").doubleValue());
                baoCaoDoanhSoList.add(baoCaoDoanhSo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return baoCaoDoanhSoList;
    }
    public boolean add(BaoCaoDoanhSo baoCaoDoanhSo) {
        String query = "INSERT INTO BAOCAODOANHSO (MaBCDS, Thang, Nam, TongDoanhThu) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, baoCaoDoanhSo.getMaBCDS());
            pstmt.setInt(2, baoCaoDoanhSo.getThang());
            pstmt.setInt(3, baoCaoDoanhSo.getNam());
            pstmt.setBigDecimal(4, BigDecimal.valueOf(baoCaoDoanhSo.getTongDoanhThu()));
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(String ma) {
        String query = "DELETE FROM BAOCAODOANHSO WHERE MaBCDS = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, ma);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String generateMaBaoCao() {
        String sql = "SELECT MaBaoCao_SEQ.NEXTVAL FROM dual";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return "PTT" + rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
