package Models.dao;

import Models.entity.Xe;
import Utils.Database_Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class XeDAO {

    public boolean addXe(Xe xe) {
        if (isBienSoExist(xe.getBienSo())) {
            return false; // Biển số đã tồn tại
        }
        String query = "INSERT INTO XE (BienSo, MaKH, tenHX, TienNo, NgayTiepNhan) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, xe.getBienSo());
            pstmt.setString(2, xe.getMaKH());
            pstmt.setString(3, xe.getTenHX());
            pstmt.setDouble(4, 0.0); // Tiền nợ ban đầu là 0
            pstmt.setDate(5, xe.getNgayTiepNhan());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isBienSoExist(String bienSo) {
        String query = "SELECT COUNT(*) FROM XE WHERE BienSo = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, bienSo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Xe> getAllXe() {
        List<Xe> xeList = new ArrayList<>();
        String query = "SELECT * FROM XE";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Xe xe = new Xe();
                xe.setBienSo(rs.getString("BienSo"));
                xe.setMaKH(rs.getString("MaKH"));
                xe.setTenHX(rs.getString("tenHX"));
                xe.setTienNo(rs.getDouble("TienNo"));
                xe.setNgayTiepNhan(rs.getDate("NgayTiepNhan"));
                xeList.add(xe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xeList;
    }
    public List<Xe> getAllXeByMaKH(String maKH) {
        List<Xe> xeList = new ArrayList<>();
        String query = "SELECT * FROM XE WHERE MaKH = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maKH);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Xe xe = new Xe();
                    xe.setBienSo(rs.getString("BienSo"));
                    xe.setMaKH(rs.getString("MaKH"));
                    xe.setTenHX(rs.getString("tenHX"));
                    xe.setTienNo(rs.getDouble("TienNo"));
                    xe.setNgayTiepNhan(rs.getDate("NgayTiepNhan"));
                    xeList.add(xe);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xeList;
    }

    public boolean deleteXe(String bienSo) {
        String query = "DELETE FROM XE WHERE BienSo = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, bienSo);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Xe getXeByBienSo(String bienSo) {
        String query = "SELECT * FROM XE WHERE BienSo = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, bienSo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Xe xe = new Xe();
                    xe.setBienSo(rs.getString("BienSo"));
                    xe.setMaKH(rs.getString("MaKH"));
                    xe.setTenHX(rs.getString("tenHX"));
                    xe.setTienNo(rs.getDouble("TienNo"));
                    xe.setNgayTiepNhan(rs.getDate("NgayTiepNhan"));
                    return xe;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean updateXe(String oldBienSo, Xe newXe) {
        String query = "UPDATE XE SET BienSo = ?, MaKH = ?, tenHX = ?, TienNo = ?, NgayTiepNhan = ? WHERE BienSo = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newXe.getBienSo());
            pstmt.setString(2, newXe.getMaKH());
            pstmt.setString(3, newXe.getTenHX());
            pstmt.setDouble(4, newXe.getTienNo());
            pstmt.setDate(5, newXe.getNgayTiepNhan());
            pstmt.setString(6, oldBienSo);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateTienNo(String bienSo, double soTienNoMoi) {
        String query = "UPDATE XE SET TienNo = TienNo + ? WHERE BienSo = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDouble(1, soTienNoMoi);
            pstmt.setString(2, bienSo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
