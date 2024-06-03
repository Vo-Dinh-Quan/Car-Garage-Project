package Models.dao;

import Models.entity.VatTuPhuTung;
import Utils.Database_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VatTuPhuTungDAO {

    // hàm lấy ra vật tư phụ tùng dựa theo tên
    public VatTuPhuTung getVatTuPhuTungByTen(String tenVTPT) {
        VatTuPhuTung vtpt = null;
        try (Connection connection = Database_Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM VATTUPHUTUNG WHERE TENVTPT = ?")) {
            statement.setString(1, tenVTPT);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                vtpt = new VatTuPhuTung(
                        resultSet.getString("MAVTPT"),
                        resultSet.getString("TENVTPT"),
                        resultSet.getDouble("DONGIANHAP"),
                        resultSet.getDouble("DONGIABAN"),
                        resultSet.getInt("SOLUONGTON")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vtpt;
    }

    public String getNextMaVTPT() {
        String nextMaVTPT = null;
        try (Connection connection = Database_Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT 'VTPT' || LPAD(SEQ_VTPT.NEXTVAL, 5, '0') AS NEXT_MA FROM DUAL")) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                nextMaVTPT = resultSet.getString("NEXT_MA");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextMaVTPT;
    }

    public void addVatTuPhuTung(VatTuPhuTung vtpt) { // hàm ny thêm vật tư phụ tùng mới vào database
        try (Connection connection = Database_Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO VATTUPHUTUNG (MAVTPT, TENVTPT, DONGIANHAP, DONGIABAN, SOLUONGTON) VALUES (?, ?, ?, ?, ?)")) {
            statement.setString(1, vtpt.getMaVTPT());
            statement.setString(2, vtpt.getTenVTPT());
            statement.setDouble(3, vtpt.getDonGiaNhap());
            statement.setDouble(4, vtpt.getDonGiaBan());
            statement.setInt(5, vtpt.getSoLuongTon());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSoLuongTon(String maVTPT, int soLuong) { // cái hàm này cập nhật lại số lượng vật tư khi lập phiếu nhập
        try (Connection connection = Database_Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE VATTUPHUTUNG SET SOLUONGTON = SOLUONGTON + ? WHERE MAVTPT = ?")) {
            statement.setInt(1, soLuong);
            statement.setString(2, maVTPT);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<VatTuPhuTung> getAllVatTuPhuTung() {
        List<VatTuPhuTung> vtptList = new ArrayList<>();
        try (Connection connection = Database_Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM VATTUPHUTUNG")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                VatTuPhuTung vtpt = new VatTuPhuTung(
                        resultSet.getString("MAVTPT"),
                        resultSet.getString("TENVTPT"),
                        resultSet.getDouble("DONGIANHAP"),
                        resultSet.getDouble("DONGIABAN"),
                        resultSet.getInt("SOLUONGTON")
                );
                vtptList.add(vtpt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vtptList;
    }
    public List<VatTuPhuTung> searchVatTuPhuTungByName(String tenVTPT) {
        List<VatTuPhuTung> vtptList = new ArrayList<>();
        String query = "SELECT * FROM VATTUPHUTUNG WHERE TENVTPT LIKE ?";
        try (Connection connection = Database_Connection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + tenVTPT + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                VatTuPhuTung vtpt = new VatTuPhuTung();
                vtpt.setMaVTPT(resultSet.getString("MAVTPT"));
                vtpt.setTenVTPT(resultSet.getString("TENVTPT"));
                vtpt.setDonGiaNhap(resultSet.getDouble("DONGIANHAP"));
                vtpt.setDonGiaBan(resultSet.getDouble("DONGIABAN"));
                vtpt.setSoLuongTon(resultSet.getInt("SOLUONGTON"));
                vtptList.add(vtpt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vtptList;
    }
    public int getSoLuongTonByTen(String tenVTPT) {
        String query = "SELECT SoLuongTon FROM VatTuPhuTung WHERE TenVTPT = ?";
        try (Connection conn = Database_Connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, tenVTPT);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("SoLuongTon");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 or any other value to indicate that the item was not found
    }
}
