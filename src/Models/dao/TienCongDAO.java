package Models.dao;

import Models.entity.TienCong;
import Utils.Database_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TienCongDAO {
    public List<TienCong> getAllTienCong() {
        List<TienCong> tienCongList = new ArrayList<>();
        try (Connection connection = Database_Connection.getConnection()) {
            String query = "SELECT * FROM TIENCONG";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                TienCong tienCong = new TienCong();
                tienCong.setMaTC(rs.getString("MaTC"));
                tienCong.setTenTC(rs.getString("TenTC"));
                tienCong.setChiPhiTC(rs.getDouble("ChiPhiTC"));
                tienCongList.add(tienCong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tienCongList;
    }

    public TienCong getTienCongByTen(String tenTC) {
        TienCong tienCong = null;
        try (Connection connection = Database_Connection.getConnection()) {
            String query = "SELECT * FROM TIENCONG WHERE TenTC = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tenTC);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                tienCong = new TienCong();
                tienCong.setMaTC(rs.getString("MaTC"));
                tienCong.setTenTC(rs.getString("TenTC"));
                tienCong.setChiPhiTC(rs.getDouble("ChiPhiTC"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tienCong;
    }
}
