package Models.dao;

import Models.entity.PhieuThuTien;
import Utils.Database_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhieuThuTienDAO {

    public void savePhieuThuTien(PhieuThuTien phieuThuTien) {
        String sql = "INSERT INTO PHIEUTHUTIEN (MaPhieuThuTien, BienSo, NgayThuTien, SoTienThu) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, phieuThuTien.getMaPhieuThuTien());
            ps.setString(2, phieuThuTien.getBienSo());
            ps.setDate(3, new java.sql.Date(phieuThuTien.getNgayThuTien().getTime()));
            ps.setDouble(4, phieuThuTien.getSoTienThu());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String generateMaPhieuThuTien() {
        String sql = "SELECT MaPhieuThuTien_SEQ.NEXTVAL FROM dual";
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

    public List<PhieuThuTien> getAllPhieuThuTien() {
        List<PhieuThuTien> phieuThuTienList = new ArrayList<>();
        String query = "SELECT * FROM PHIEUTHUTIEN";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                PhieuThuTien phieuThuTien = new PhieuThuTien(
                        rs.getString("MaPhieuThuTien"),
                        rs.getString("BienSo"),
                        rs.getDouble("SoTienThu"),
                        rs.getDate("NgayThuTien")
                );
                phieuThuTienList.add(phieuThuTien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieuThuTienList;
    }
}
