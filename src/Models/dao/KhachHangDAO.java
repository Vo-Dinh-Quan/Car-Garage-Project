package Models.dao;

import Models.entity.KhachHang;
import Utils.Database_Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {

    public String addKhachHang(KhachHang khachHang) {
        String query = "INSERT INTO KHACHHANG (MaKH, HoTenKH, DienThoai, Email) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, khachHang.getMaKH());
            pstmt.setString(2, khachHang.getHoTenKH());
            pstmt.setString(3, khachHang.getDienThoai());
            pstmt.setString(4, khachHang.getEmail());
            pstmt.executeUpdate();
            return khachHang.getMaKH();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> khachHangList = new ArrayList<>();
        String query = "SELECT * FROM KHACHHANG";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setHoTenKH(rs.getString("HoTenKH"));
                kh.setDienThoai(rs.getString("DienThoai"));
                kh.setEmail(rs.getString("Email"));
                khachHangList.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachHangList;
    }

    public KhachHang getKhachHangById(String maKH) {
        String query = "SELECT * FROM KHACHHANG WHERE MaKH = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maKH);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    KhachHang kh = new KhachHang();
                    kh.setMaKH(rs.getString("MaKH"));
                    kh.setHoTenKH(rs.getString("HoTenKH"));
                    kh.setDienThoai(rs.getString("DienThoai"));
                    kh.setEmail(rs.getString("Email"));
                    return kh;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public KhachHang getKhachHangByDetails(String hoTenKH, String dienThoai, String email) {
        String query = "SELECT * FROM KHACHHANG WHERE HoTenKH = ? AND DienThoai = ? AND Email = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, hoTenKH);
            pstmt.setString(2, dienThoai);
            pstmt.setString(3, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    KhachHang kh = new KhachHang();
                    kh.setMaKH(rs.getString("MaKH"));
                    kh.setHoTenKH(rs.getString("HoTenKH"));
                    kh.setDienThoai(rs.getString("DienThoai"));
                    kh.setEmail(rs.getString("Email"));
                    return kh;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteKhachHang(String maKH) {
        String query = "DELETE FROM KHACHHANG WHERE MaKH = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maKH);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateKhachHang(KhachHang khachHang) {
        String query = "UPDATE KHACHHANG SET HoTenKH = ?, DienThoai = ?, Email = ? WHERE MaKH = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, khachHang.getHoTenKH());
            pstmt.setString(2, khachHang.getDienThoai());
            pstmt.setString(3, khachHang.getEmail());
            pstmt.setString(4, khachHang.getMaKH());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



}
