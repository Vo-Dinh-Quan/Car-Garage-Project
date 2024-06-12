package Controller;

import java.time.LocalDateTime;
import java.util.List;

import Models.dao.BaoCaoDAO;
import Models.dao.PhieuThuTienDAO;
import Models.entity.BaoCaoDoanhSo;
import Models.entity.PhieuThuTien;

public class BaoCaoController {
    private BaoCaoDAO baoCaoDAO;
    private PhieuThuTienDAO phieuThuTienDAO;
    public BaoCaoController() {
        baoCaoDAO = new BaoCaoDAO();
        phieuThuTienDAO = new PhieuThuTienDAO();
    }

    public List<BaoCaoDoanhSo> getAll() {
        return baoCaoDAO.getAll();
    }

    public BaoCaoDoanhSo search(String ma) {
        return baoCaoDAO.search(ma);
    }

    public boolean remove(String ma) {
        return baoCaoDAO.delete(ma);
    }

    public BaoCaoDoanhSo add(int thang, int nam) {
        BaoCaoDoanhSo baoCaoDoanhSo = new BaoCaoDoanhSo();
        baoCaoDoanhSo.setThang(thang);
        baoCaoDoanhSo.setNam(nam);

        // ta mã báo cáo
        LocalDateTime now = LocalDateTime.now();
        baoCaoDoanhSo.setMaBCDS("" + now.getYear() + "" +
                now.getMonthValue() + "" + now.getDayOfMonth() + "" + now.getHour() + "" +
                now.getMinute() + "" + now.getSecond());
        List<PhieuThuTien> phieuThuTiens = phieuThuTienDAO.getAllByThangNam(nam, thang);
        if (phieuThuTiens == null)
            return null;
        double tong = 0;
        for (int i = 0; i < phieuThuTiens.size(); i++)
            tong += phieuThuTiens.get(i).getSoTienThu();
        baoCaoDoanhSo.setTongDoanhThu(tong);
        if (baoCaoDAO.add(baoCaoDoanhSo))
            return baoCaoDoanhSo;
        return null;
    }
}
