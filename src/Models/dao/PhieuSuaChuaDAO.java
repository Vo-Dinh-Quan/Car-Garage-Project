package Models.dao;

import Models.entity.CTSuDungVTPT;
import Models.entity.PhieuSuaChua;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Utils.Database_Connection;

public class PhieuSuaChuaDAO {

    public String savePhieuSuaChua(PhieuSuaChua phieuSuaChua) {
        String insertPhieuSuaChuaSQL = "INSERT INTO PHIEUSUACHUA (MaPhieuSuaChua, BienSo, NgaySuaChua, ThanhTienPSC) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertPhieuSuaChuaSQL)) {
            ps.setString(1, phieuSuaChua.getMaPhieuSuaChua());
            ps.setString(2, phieuSuaChua.getBienSo());
            ps.setDate(3, new java.sql.Date(phieuSuaChua.getNgaySuaChua().getTime()));
            ps.setDouble(4, phieuSuaChua.getThanhTienPSC());
            ps.executeUpdate();
            return phieuSuaChua.getMaPhieuSuaChua();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveCTSudungVTPT(List<CTSuDungVTPT> ctSudungVTPTList) {
        String insertCTSudungVTPTSQL = "INSERT INTO CT_SUDUNGVTPT (MaPhieuSuaChua, MaVTPT, TenVTPT, DonGiaBan, SoLuongSuDung, ThanhTien) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertCTSudungVTPTSQL)) {
            for (CTSuDungVTPT ct : ctSudungVTPTList) {
                ps.setString(1, ct.getMaPhieuSuaChua());
                ps.setString(2, ct.getMaVTPT());
                ps.setString(3, ct.getTenVTPT());
                ps.setDouble(4, ct.getDonGiaBan());
                ps.setInt(5, ct.getSoLuongSuDung());
                ps.setDouble(6, ct.getThanhTien());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Hàm tạo mã phiếu sửa chửa bằng sequences
    public String generateMaPhieuSuaChua() {
        String getSequenceSQL = "SELECT MaPhieuSuaChua_SEQ.NEXTVAL FROM dual";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(getSequenceSQL)) {
            var rs = ps.executeQuery();
            if (rs.next()) {
                return "PSC" + rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<PhieuSuaChua> getAllPhieuSuaChua() {
        String query = "SELECT * FROM PHIEUSUACHUA";
        List<PhieuSuaChua> phieuSuaChuaList = new ArrayList<>();
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                PhieuSuaChua phieuSuaChua = new PhieuSuaChua();
                phieuSuaChua.setMaPhieuSuaChua(rs.getString("MaPhieuSuaChua"));
                phieuSuaChua.setBienSo(rs.getString("BienSo"));
                phieuSuaChua.setNgaySuaChua(rs.getDate("NgaySuaChua"));
                phieuSuaChua.setThanhTienPSC(rs.getDouble("ThanhTienPSC"));
                phieuSuaChuaList.add(phieuSuaChua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieuSuaChuaList;
    }
    public void addOrUpdateCTSuDungVTPT(String maPhieuSuaChua, String maVTPT, String tenVTPT, double donGiaBan, int soLuongSuDung, int delayTime) {
        String sql = "{CALL add_content_to_ct_sudungvtpt(?, ?, ?, ?, ?, ?)}";
        try (Connection conn = Database_Connection.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, maPhieuSuaChua);
            cs.setString(2, maVTPT);
            cs.setString(3, tenVTPT);
            cs.setDouble(4, donGiaBan);
            cs.setInt(5, soLuongSuDung);
            cs.setInt(6, delayTime);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
