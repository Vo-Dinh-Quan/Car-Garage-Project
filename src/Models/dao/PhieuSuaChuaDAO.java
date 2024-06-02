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
        String insertCTSudungVTPTSQL = "INSERT INTO CT_SUDUNGVTPT (MaPhieuSuaChua, MaVTPT, SoLuongSuDung, ThanhTien) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertCTSudungVTPTSQL)) {
            for (CTSuDungVTPT ct : ctSudungVTPTList) {
                ps.setString(1, ct.getMaPhieuSuaChua());
                ps.setString(2, ct.getMaVTPT());
                ps.setInt(3, ct.getSoLuongSuDung());
                ps.setDouble(4, ct.getThanhTien());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
        List<PhieuSuaChua> phieuSuaChuaList = new ArrayList<>();
        String getAllPhieuSuaChuaSQL = "SELECT MaPhieuSuaChua, BienSo, NgaySuaChua, ThanhTienPSC FROM PHIEUSUACHUA";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(getAllPhieuSuaChuaSQL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maPhieuSuaChua = rs.getString("MaPhieuSuaChua");
                String bienSo = rs.getString("BienSo");
                Date ngaySuaChua = rs.getDate("NgaySuaChua");
                double thanhTienPSC = rs.getDouble("ThanhTienPSC");
                PhieuSuaChua phieuSuaChua = new PhieuSuaChua(maPhieuSuaChua, bienSo, ngaySuaChua, thanhTienPSC);
                phieuSuaChuaList.add(phieuSuaChua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieuSuaChuaList;
    }
}
