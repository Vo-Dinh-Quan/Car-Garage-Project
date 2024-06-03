package Models.dao;

import Models.entity.PhieuNhapVTPT;
import Models.entity.CTPhieuNhapVTPT;
import Utils.Database_Connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhapVTPTDAO {
    public String getNextMaPNVTPT() {// hàm này lấy mã phiếu nhập vật tư phụ tạo bằng sequnence trong database
        String nextMaPNVTPT = null;
        try (Connection connection = Database_Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT 'PNVTPT' || LPAD(SEQ_PNVTPT.NEXTVAL, 5, '0') AS NEXT_MA FROM DUAL")) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                nextMaPNVTPT = resultSet.getString("NEXT_MA");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextMaPNVTPT;
    }

    public void addPhieuNhapVTPT(PhieuNhapVTPT pnvtpt) {
        try (Connection connection = Database_Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO PHIEUNHAPVTPT (MAPNVTPT, THANHTIENNHAP, NGAYNHAP) VALUES (?, ?, ?)")) {
            statement.setString(1, pnvtpt.getMaPNVTPT());
            statement.setDouble(2, pnvtpt.getThanhTienNhap());
            statement.setDate(3, (Date) pnvtpt.getNgayNhap());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCTPhieuNhapVTPT(CTPhieuNhapVTPT ct) {
        try (Connection connection = Database_Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO CT_PHIEUNHAPVTPT (MAPNVTPT, MAVTPT, SOLUONGNHAP, TIENNHAPVTPT) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, ct.getMaPNVTPT());
            statement.setString(2, ct.getMaVTPT());
            statement.setInt(3, ct.getSoLuongNhap());
            statement.setDouble(4, ct.getTienNhapVTPT());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<PhieuNhapVTPT> getAllPhieuNhapVTPT() {
        List<PhieuNhapVTPT> phieuNhapList = new ArrayList<>();
        try (Connection connection = Database_Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM PHIEUNHAPVTPT")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PhieuNhapVTPT phieuNhap = new PhieuNhapVTPT(
                        resultSet.getString("MAPNVTPT"),
                        resultSet.getDouble("THANHTIENNHAP"),
                        resultSet.getDate("NGAYNHAP")
                );
                phieuNhapList.add(phieuNhap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieuNhapList;
    }

}
