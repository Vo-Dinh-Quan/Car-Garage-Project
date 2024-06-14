package Controller;

import Models.dao.KhachHangDAO;
import Models.dao.PhieuThuTienDAO;
import Models.dao.XeDAO;
import Models.entity.*;
import Utils.Database_Connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PhieuThuTienController {
    private XeDAO xeDAO;
    private KhachHangDAO khachHangDAO;
    private PhieuThuTienDAO phieuThuTienDAO;

    public PhieuThuTienController() {
        xeDAO = new XeDAO();
        khachHangDAO = new KhachHangDAO();
        phieuThuTienDAO = new PhieuThuTienDAO();
    }

    public List<Xe> getAllXe() {
        return xeDAO.getAllXe();
    }

    public Xe getXeByBienSo(String bienSo) {
        return xeDAO.getXeByBienSo(bienSo);
    }

    public KhachHang getKhachHangByMaKH(String maKH) {
        return khachHangDAO.getKhachHangById(maKH);
    }

    public void savePhieuThuTien(PhieuThuTien phieuThuTien) {
        phieuThuTienDAO.savePhieuThuTien(phieuThuTien);
    }

    public String generateMaPhieuThuTien() {
        return phieuThuTienDAO.generateMaPhieuThuTien();
    }

    public List<PhieuThuTien> getAllPhieuThuTien() {
        return phieuThuTienDAO.getAllPhieuThuTien();
    }
    public KhachHang getKhachHangByBienSo(String bienSo) {
        return KhachHangDAO.getKhachHangByBienSo(bienSo);
    }
    public List<CTSuDungVTPT> getCTSuDungVTPTByBienSo(String bienSo) {
        return phieuThuTienDAO.getCTSuDungVTPTByBienSo(bienSo);
    }
    public List<SuDungTienCong> getSuDungTienCongByBienSo(String bienSo) {
        return phieuThuTienDAO.getSuDungTienCongByBienSo(bienSo);
    }
    public boolean updateTienNoXe(Xe xe) {
        return xeDAO.updateTienNo(xe.getBienSo(), xe.getTienNo());
    }
    public boolean luuPhieuThuTien(String bienSo, double soTienThu, java.sql.Date ngayThuTien) {
        try (Connection conn = Database_Connection.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL LuuPhieuThuTien(?, ?, ?)}");
            stmt.setString(1, bienSo);
            stmt.setDouble(2, soTienThu);
            stmt.setDate(3, ngayThuTien);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
