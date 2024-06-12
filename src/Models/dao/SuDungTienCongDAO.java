package Models.dao;

import Models.entity.SuDungTienCong;
import Utils.Database_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuDungTienCongDAO {

    public List<SuDungTienCong> getSuDungTienCongByPhieuSuaChua(String maPhieuSuaChua) {
        List<SuDungTienCong> list = new ArrayList<>();
        String query = "SELECT * FROM SUDUNG_TIENCONG WHERE MAPHIEUSUACHUA = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, maPhieuSuaChua);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    SuDungTienCong sdtc = new SuDungTienCong();
                    sdtc.setMaPhieuSuaChua(rs.getString("MAPHIEUSUACHUA"));
                    sdtc.setMaTC(rs.getString("MaTC"));
                    sdtc.setTenTC(rs.getString("TenTC"));
                    sdtc.setChiPhiTC(rs.getDouble("ChiPhiTC"));
                    list.add(sdtc);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveSuDungTienCong(SuDungTienCong sdtc) {
        String query = "INSERT INTO SUDUNG_TIENCONG (MAPHIEUSUACHUA, MaTC, TenTC, ChiPhiTC) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, sdtc.getMaPhieuSuaChua());
            ps.setString(2, sdtc.getMaTC());
            ps.setString(3, sdtc.getTenTC());
            ps.setDouble(4, sdtc.getChiPhiTC());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSuDungTienCong(String maPhieuSuaChua, String maTC) {
        String query = "DELETE FROM SUDUNG_TIENCONG WHERE MAPHIEUSUACHUA = ? AND MaTC = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, maPhieuSuaChua);
            ps.setString(2, maTC);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveSuDungTienCongList(List<SuDungTienCong> suDungTienCongList) {
        String query = "INSERT INTO SUDUNG_TIENCONG (MAPHIEUSUACHUA, MaTC, TenTC, ChiPhiTC) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            for (SuDungTienCong sdtc : suDungTienCongList) {
                ps.setString(1, sdtc.getMaPhieuSuaChua());
                ps.setString(2, sdtc.getMaTC());
                ps.setString(3, sdtc.getTenTC());
                ps.setDouble(4, sdtc.getChiPhiTC());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
