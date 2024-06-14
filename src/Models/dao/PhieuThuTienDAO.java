package Models.dao;

import Models.entity.CTSuDungVTPT;
import Models.entity.KhachHang;
import Models.entity.PhieuThuTien;
import Models.entity.SuDungTienCong;
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

    // 2 cái hàm này phục vụ cho việc in phiếu thu tiền
    public List<CTSuDungVTPT> getCTSuDungVTPTByBienSo(String bienSo) {
        List<CTSuDungVTPT> list = new ArrayList<>();
        // Lấy danh sách các chi tiết sử dụng vật tư phụ tùng có mã phiếu sửa chữa trong bảng mã sửa chữa có biển số xe tương ứng
        String sql = "SELECT * FROM CT_SUDUNGVTPT WHERE MaPhieuSuaChua IN (SELECT MaPhieuSuaChua FROM PHIEUSUACHUA WHERE BienSo = ?)";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, bienSo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    CTSuDungVTPT ct = new CTSuDungVTPT(
                            rs.getString("MaPhieuSuaChua"),
                            rs.getString("MaVTPT"),
                            rs.getString("TenVTPT"),
                            rs.getDouble("DonGiaBan"),
                            rs.getInt("SoLuongSuDung"),
                            rs.getDouble("ThanhTien")
                    );
                    list.add(ct);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SuDungTienCong> getSuDungTienCongByBienSo(String bienSo) {
        List<SuDungTienCong> list = new ArrayList<>();
        // lấy ra danh sách các sử dụng tiền công mà m phiếu sửa chữa của sử dụng tiền công này sửa biển số xe tương ứng
        String sql = "SELECT * FROM SUDUNG_TIENCONG WHERE MaPhieuSuaChua IN (SELECT MaPhieuSuaChua FROM PHIEUSUACHUA WHERE BienSo = ?)";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, bienSo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    SuDungTienCong tc = new SuDungTienCong(
                            rs.getString("MaPhieuSuaChua"),
                            rs.getString("MaTC"),
                            rs.getString("TenTC"),
                            rs.getDouble("ChiPhiTC")
                    );
                    list.add(tc);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public KhachHang getKhachHangByBienSo(String bienSo) {
        KhachHang khachHang = null;
        String sql = "SELECT KH.* FROM KHACHHANG KH JOIN XE X ON KH.MaKH = X.MaKH WHERE X.BienSo = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, bienSo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    khachHang = new KhachHang(
                            rs.getString("MaKH"),
                            rs.getString("HoTenKH"),
                            rs.getString("DienThoai"),
                            rs.getString("Email")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachHang;
    }
//    public List<PhieuThuTien> getAllByThangNam(int nam, int thang) {
//        List<PhieuThuTien> phieuThuTienList = new ArrayList<>();
//        String query = "SELECT * FROM PHIEUTHUTIEN WHERE YEAR(NgayThuTien) = ? AND MONTH(NgayThuTien) = ?";
//
//        try (Connection conn = Database_Connection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query)) {
//            pstmt.setInt(1, nam);
//            pstmt.setInt(2, thang);
//            ResultSet rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                PhieuThuTien phieuThuTien = new PhieuThuTien();
//                phieuThuTien.setMaPhieuThuTien(rs.getString("MaPhieuThuTien"));
//                phieuThuTien.setBienSo(rs.getString("BienSo"));
//                phieuThuTien.setSoTienThu(rs.getBigDecimal("SoTienThu").doubleValue());
//                phieuThuTien.setNgayThuTien(rs.getDate("NgayThuTien"));
//                phieuThuTienList.add(phieuThuTien);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return phieuThuTienList;
//    }
    public List<PhieuThuTien> getAllByThangNam(int nam, int thang) {
        List<PhieuThuTien> phieuThuTienList = new ArrayList<>();
        String query = "SELECT * FROM PHIEUTHUTIEN WHERE EXTRACT(YEAR FROM NgayThuTien) = ? AND EXTRACT(MONTH FROM NgayThuTien) = ?";

        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, nam);
            pstmt.setInt(2, thang);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                PhieuThuTien phieuThuTien = new PhieuThuTien();
                phieuThuTien.setMaPhieuThuTien(rs.getString("MaPhieuThuTien"));
                phieuThuTien.setBienSo(rs.getString("BienSo"));
                phieuThuTien.setSoTienThu(rs.getBigDecimal("SoTienThu").doubleValue());
                phieuThuTien.setNgayThuTien(rs.getDate("NgayThuTien"));
                phieuThuTienList.add(phieuThuTien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return phieuThuTienList;
    }

    public boolean updateTienNo(String bienSo, double tienNoMoi) {
        String sql = "UPDATE XE SET TienNo = ? WHERE BienSo = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, tienNoMoi);
            ps.setString(2, bienSo);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
