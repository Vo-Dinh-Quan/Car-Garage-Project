-- T?o b?ng TAIKHOAN
CREATE TABLE TAIKHOAN (
    ChucVu VARCHAR2(50),
    TenDangNhap VARCHAR2(50),
    MatKhau VARCHAR2(50)
);

-- T?o b?ng TIENCONG
CREATE TABLE TIENCONG (
    MaTC VARCHAR2(50) PRIMARY KEY,
    TenTC VARCHAR2(50),
    ChiPhiTC NUMBER(10, 2)
);

CREATE TABLE SUDUNG_TIENCONG (
    MAPHIEUSUACHUA VARCHAR(50)REFERENCES PHIEUSUACHUA (MAPHIEUSUACHUA), 
    MaTC VARCHAR(50) REFERENCES TIENCONG(MaTC),
    TenTC VARCHAR(50),
    ChiPhiTC NUMBER(10, 2),
    PRIMARY KEY (MaPhieuSuaChua, MaTC)
)


-- T?o b?ng KHACHHANG
CREATE TABLE KHACHHANG (
    MaKH VARCHAR2(50) PRIMARY KEY,
    HoTenKH VARCHAR2(50),
    DienThoai NUMBER(10),
    EMail VARCHAR2(50)
);


-- T?o b?ng XE
CREATE TABLE XE (
    BienSo VARCHAR2(50) PRIMARY KEY,
    MaKH VARCHAR2(50) REFERENCES KHACHHANG(MaKH),
    tenHX VARCHAR(20),
    TienNo NUMBER(10, 2),
    NgayTiepNhan DATE
);

-- T?o b?ng PHIEUTHUTIEN
CREATE TABLE PHIEUTHUTIEN (
    MaPhieuThuTien VARCHAR2(50) PRIMARY KEY,
    BienSo VARCHAR2(50) REFERENCES XE(BienSo),
    SoTienThu NUMBER(10, 2),
    NgayThuTien DATE
);

COMMIT;
-- T?o b?ng PHIEUSUACHUA
CREATE TABLE PHIEUSUACHUA (
    MaPhieuSuaChua VARCHAR2(50) PRIMARY KEY,
    BienSo VARCHAR2(50) REFERENCES XE(BienSo),
    NgaySuaChua DATE,
    ThanhTienPSC NUMBER(10, 2)
);

-- T?o b?ng VATTUPHUTUNG
CREATE TABLE VATTUPHUTUNG (
    MaVTPT VARCHAR2(50) PRIMARY KEY,
    TenVTPT VARCHAR2(50),
    DonGiaNhap NUMBER(10, 2),
    DonGiaBan NUMBER(10, 2),
    SoLuongTon NUMBER(10)
);


-- T?o b?ng CT_SUDUNGVTPT
CREATE TABLE CT_SUDUNGVTPT (
    MaPhieuSuaChua VARCHAR2(50),
    MaVTPT VARCHAR2(50),
    TenVTPT VARCHAR(50),
    DonGiaBan NUMBER(10, 2),
    SoLuongSuDung NUMBER(10),
    ThanhTien NUMBER(10, 2),
    PRIMARY KEY (MaPhieuSuaChua, MaVTPT),
    FOREIGN KEY (MaPhieuSuaChua) REFERENCES PHIEUSUACHUA(MaPhieuSuaChua),
    FOREIGN KEY (MaVTPT) REFERENCES VATTUPHUTUNG(MaVTPT)
);

-- T?o b?ng PHIEUNHAPVTPT
CREATE TABLE PHIEUNHAPVTPT (
    MaPNVTPT VARCHAR2(50) PRIMARY KEY,
    ThanhTienNhap NUMBER(10, 2),
    NgayNhap DATE
);


-- T?o b?ng CT_PHIEUNHAPVTPT
CREATE TABLE CT_PHIEUNHAPVTPT (
    MaPNVTPT VARCHAR2(50),
    MaVTPT VARCHAR2(50),
    SoLuongNhap NUMBER(10),
    TienNhapVTPT NUMBER(10, 2),
    PRIMARY KEY (MaPNVTPT, MaVTPT),
    FOREIGN KEY (MaPNVTPT) REFERENCES PHIEUNHAPVTPT(MaPNVTPT),
    FOREIGN KEY (MaVTPT) REFERENCES VATTUPHUTUNG(MaVTPT)
);

-- T?o b?ng BAOCAODOANHSO
CREATE TABLE BAOCAODOANHSO (
    MaBCDS VARCHAR2(50) PRIMARY KEY,
    Thang NUMBER(2),
    Nam NUMBER(4),
    TongDoanhThu NUMBER(10, 2)
);


-- T?o sequence cho b?ng KHACHHANG
CREATE SEQUENCE KHACHHANG_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_MAVTPT START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_MAPNVTPT START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_VTPT START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_PNVTPT START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE MaPhieuSuaChua_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;

CREATE SEQUENCE MaPhieuThuTien_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;


SELECT * FROM BAOCAODOANHSO;

INSERT INTO TAIKHOAN (CHUCVU, TENDANGNHAP, MATKHAU) VALUES ('Quan ly', 'quancute','22521193');
INSERT INTO TAIKHOAN (CHUCVU, TENDANGNHAP, MATKHAU) VALUES ('Quan ly', 'quandethuong','22521193');
INSERT INTO TAIKHOAN (CHUCVU, TENDANGNHAP, MATKHAU) VALUES ('Quan ly', 'nhanvien1','22521193');
INSERT INTO TAIKHOAN (CHUCVU, TENDANGNHAP, MATKHAU) VALUES ('Quan ly', 'nhanvien2','22521193');

commit;

-- Xóa dữ liệu trong bảng SUDUNG_TIENCONG
DELETE FROM SUDUNG_TIENCONG;

-- Xóa dữ liệu trong bảng CT_SUDUNGVTPT
DELETE FROM CT_SUDUNGVTPT;

-- Xóa dữ liệu trong bảng CT_PHIEUNHAPVTPT
DELETE FROM CT_PHIEUNHAPVTPT;

-- Xóa dữ liệu trong bảng PHIEUNHAPVTPT
DELETE FROM PHIEUNHAPVTPT;

-- Xóa dữ liệu trong bảng PHIEUSUACHUA
DELETE FROM PHIEUSUACHUA;

-- Xóa dữ liệu trong bảng PHIEUTHUTIEN
DELETE FROM PHIEUTHUTIEN;

-- Xóa dữ liệu trong bảng XE
DELETE FROM XE;

-- Xóa dữ liệu trong bảng VATTUPHUTUNG
DELETE FROM VATTUPHUTUNG;

-- Xóa dữ liệu trong bảng TIENCONG
DELETE FROM TIENCONG;

-- Xóa dữ liệu trong bảng KHACHHANG
DELETE FROM KHACHHANG;

-- Xóa dữ liệu trong bảng TAIKHOAN
DELETE FROM TAIKHOAN;

-- Xóa dữ liệu trong bảng BAOCAODOANHSO
DELETE FROM BAOCAODOANHSO;

INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT001', 'Lốp xe', 1500000, 1800000, 20);
INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT002', 'Phanh đĩa', 800000, 960000, 25);
INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT003', 'Bộ lọc dầu', 300000, 360000, 30);
INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT004', 'Bugi', 100000, 120000, 40);
INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT005', 'Gương chiếu hậu', 250000, 300000, 22);
INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT006', 'Cần trước', 1200000, 1440000, 28);
INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT007', 'Cần sau', 1300000, 1560000, 27);
INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT008', 'Đèn pha', 750000, 900000, 35);
INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT009', 'Đèn hậu', 700000, 840000, 32);
INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT010', 'Hộp số', 1800000, 2160000, 24);
INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT011', 'Xi nhan', 150000, 180000, 45);
INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT012', 'Ắc quy', 900000, 1080000, 20);
INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT013', 'Má phanh', 450000, 540000, 26);
INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT014', 'Dây curoa', 200000, 240000, 50);
INSERT INTO VATTUPHUTUNG (MaVTPT, TenVTPT, DonGiaNhap, DonGiaBan, SoLuongTon) VALUES ('VTPT015', 'Cần gạt nước', 80000, 96000, 48);


-- Xóa dữ liệu trong bảng VATTUPHUTUNG
DELETE FROM VATTUPHUTUNG;

-- Xóa dữ liệu trong bảng TIENCONG
DELETE FROM TIENCONG;

DELETE FROM PHIEUSUACHUA;
DELETE FROM PHIEUTHUTIEN;

COMMIT;

INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC01', 'Thay dầu động cơ', 500000);
INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC02', 'Bảo dưỡng phanh', 700000);
INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC03', 'Thay bugi', 300000);
INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC04', 'Sửa chữa hộp số', 1500000);
INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC05', 'Thay lọc gió', 200000);
INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC06', 'Kiểm tra ắc quy', 100000);
INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC07', 'Bảo dưỡng hệ thống điện', 800000);
INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC08', 'Sửa chữa điều hòa', 1200000);
INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC09', 'Thay nước làm mát', 400000);
INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC10', 'Bảo dưỡng khung gầm', 900000);
INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC11', 'Sửa chữa hệ thống lái', 1100000);
INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC12', 'Thay lọc dầu', 450000);
INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC13', 'Bảo dưỡng hệ thống treo', 1000000);
INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC14', 'Thay lốp xe', 550000);
INSERT INTO TIENCONG (MaTC, TenTC, ChiPhiTC) VALUES ('TC15', 'Sửa chữa động cơ', 2000000);

COMMIT;


-- DROP TABLE BAOCAODOANHSO CASCADE CONSTRAINTS;
-- DROP TABLE CT_PHIEUNHAPVTPT CASCADE CONSTRAINTS;
-- DROP TABLE CT_PHIEUSUACHUA CASCADE CONSTRAINTS;
-- DROP TABLE CT_SUDUNGVTPT CASCADE CONSTRAINTS;
-- DROP TABLE KHACHHANG CASCADE CONSTRAINTS;
-- DROP TABLE PHIEUNHAPVTPT CASCADE CONSTRAINTS;
-- DROP TABLE PHIEUSUACHUA CASCADE CONSTRAINTS;
-- DROP TABLE PHIEUTHUTIEN CASCADE CONSTRAINTS;
-- DROP TABLE TAIKHOAN CASCADE CONSTRAINTS;
-- DROP TABLE TIENCONG CASCADE CONSTRAINTS;
-- DROP TABLE SUDUNG_TIENCONG CASCADE CONSTRAINTS;
-- DROP TABLE VATTUPHUTUNG CASCADE CONSTRAINTS;
-- DROP TABLE XE CASCADE CONSTRAINTS;
-- commit;



CREATE OR REPLACE PROCEDURE sleep (p_time IN NUMBER) AS
    v_now DATE;
BEGIN
    -- Thời gian ngủ tính bằng giây
    v_now := SYSDATE + p_time / 86400;
    LOOP
        EXIT WHEN SYSDATE >= v_now;
    END LOOP;
END;
/

---------------------------------------------LOST UPDATES---------------------------------------------
CREATE OR REPLACE PROCEDURE add_content_to_ct_sudungvtpt (
    p_maphieusuachua IN CT_SUDUNGVTPT.MaPhieuSuaChua%TYPE,
    p_mavtpt IN CT_SUDUNGVTPT.MaVTPT%TYPE,
    p_tenvtpt IN CT_SUDUNGVTPT.TenVTPT%TYPE,
    p_dongiaban IN CT_SUDUNGVTPT.DonGiaBan%TYPE,
    p_soluongsu IN CT_SUDUNGVTPT.SoLuongSuDung%TYPE,
    p_sleep_time IN NUMBER
) AS
    v_count NUMBER;
BEGIN
    EXECUTE IMMEDIATE 'LOCK TABLE CT_SUDUNGVTPT IN EXCLUSIVE MODE';
    -- Kiểm tra nếu hàng đã tồn tại
    SELECT COUNT(*)
    INTO v_count
    FROM CT_SUDUNGVTPT
    WHERE MaPhieuSuaChua = p_maphieusuachua AND MaVTPT = p_mavtpt;

    IF v_count = 0 THEN
        -- Thêm dữ liệu vào bảng CT_SUDUNGVTPT nếu không tồn tại
        INSERT INTO CT_SUDUNGVTPT (MaPhieuSuaChua, MaVTPT, TenVTPT, DonGiaBan, SoLuongSuDung, ThanhTien)
        VALUES (p_maphieusuachua, p_mavtpt, p_tenvtpt, p_dongiaban, p_soluongsu, p_dongiaban * p_soluongsu);
    ELSE
        -- Cập nhật nếu đã tồn tại
        UPDATE CT_SUDUNGVTPT
        SET TenVTPT = p_tenvtpt, DonGiaBan = p_dongiaban, SoLuongSuDung = SoLuongSuDung + p_soluongsu, ThanhTien = ThanhTien + (p_dongiaban * p_soluongsu)
        WHERE MaPhieuSuaChua = p_maphieusuachua AND MaVTPT = p_mavtpt;
    END IF;

    -- Gọi procedure sleep nếu có thời gian ngủ
    IF p_sleep_time > 0 THEN
        sleep(p_sleep_time);
    END IF;
END;
/



CREATE OR REPLACE TRIGGER trg_update_tongtien
FOR INSERT OR UPDATE ON CT_SUDUNGVTPT
COMPOUND TRIGGER

    -- định nghĩa 1 cái bản ghi để chứa tt của CT_SUDUNGVTPT
    TYPE vtpt_rec_type IS RECORD (
        maphieusuachua CT_SUDUNGVTPT.MaPhieuSuaChua%TYPE,
        mavtpt CT_SUDUNGVTPT.MaVTPT%TYPE,
        soluongsu CT_SUDUNGVTPT.SoLuongSuDung%TYPE,
        old_soluongsu CT_SUDUNGVTPT.SoLuongSuDung%TYPE
    );

    -- Định nghĩa kiểu dữ liệu bảng tạm thời lưu trữ các bản ghi của CT_SUDUNGVTPT
    TYPE vtpt_table_type IS TABLE OF vtpt_rec_type;
    vtpt_table vtpt_table_type := vtpt_table_type();

    BEFORE STATEMENT IS
    BEGIN
        -- đảm bảo bảng trống truwsowsc khi lưu mới bản ghi nào
        vtpt_table.DELETE;
    END BEFORE STATEMENT;

    AFTER EACH ROW IS
    BEGIN
        -- mở rộng bảng tạm và lưu thông tin của các bản ghi mới vào
        vtpt_table.EXTEND;
        vtpt_table(vtpt_table.COUNT).maphieusuachua := :NEW.MaPhieuSuaChua;
        vtpt_table(vtpt_table.COUNT).mavtpt := :NEW.MaVTPT;
        vtpt_table(vtpt_table.COUNT).soluongsu := :NEW.SoLuongSuDung;

        IF UPDATING THEN
            vtpt_table(vtpt_table.COUNT).old_soluongsu := NVL(:OLD.SoLuongSuDung, 0);
        ELSE
            vtpt_table(vtpt_table.COUNT).old_soluongsu := 0;
        END IF;
    END AFTER EACH ROW;

    AFTER STATEMENT IS
    BEGIN
        FOR i IN 1..vtpt_table.COUNT LOOP
            DECLARE
                v_tongtien_vtpt NUMBER;
                v_tongtien_tiencong NUMBER;
                v_tongtien_total NUMBER;
            BEGIN
                -- Tính tổng tiền từ bảng CT_SUDUNGVTPT
                SELECT NVL(SUM(CT.ThanhTien), 0)
                INTO v_tongtien_vtpt
                FROM CT_SUDUNGVTPT CT
                WHERE CT.MaPhieuSuaChua = vtpt_table(i).maphieusuachua;

                -- Tính tổng chi phí từ bảng SUDUNG_TIENCONG
                SELECT NVL(SUM(TC.ChiPhiTC), 0)
                INTO v_tongtien_tiencong
                FROM SUDUNG_TIENCONG TC
                WHERE TC.MaPhieuSuaChua = vtpt_table(i).maphieusuachua;

                -- Tổng tiền = tổng tiền vật tư phụ tùng + tổng tiền công
                v_tongtien_total := v_tongtien_vtpt + v_tongtien_tiencong;

                -- Cập nhật lại giá trị ThanhTienPSC trên PHIEUSUACHUA
                UPDATE PHIEUSUACHUA
                SET ThanhTienPSC = v_tongtien_total
                WHERE MaPhieuSuaChua = vtpt_table(i).maphieusuachua;

                -- Điều chỉnh số lượng tồn kho trong VATTUPHUTUNG
                UPDATE VATTUPHUTUNG
                SET SoLuongTon = SoLuongTon - (vtpt_table(i).soluongsu - vtpt_table(i).old_soluongsu)
                WHERE MaVTPT = vtpt_table(i).mavtpt;
            END;
        END LOOP;
    END AFTER STATEMENT;

END trg_update_tongtien;
/




-- Session 1:
BEGIN
    -- Gọi hàm add_content_to_ct_sudungvtpt với thời gian tạm dừng 10 giây
    add_content_to_ct_sudungvtpt('PSC8', 'VTPT004', 'Bugi', 120000, 1, 10); -- p_maphieusuachua = ' ', p_mavtpt = ' ', p_tenvtpt = ' ', p_dongiaban = , p_soluongsu = , p_sleep_time = 10
    COMMIT;
END;
/

-- Session 2: 
BEGIN
    -- Gọi hàm add_content_to_ct_sudungvtpt với thời gian tạm dừng 0 giây
    add_content_to_ct_sudungvtpt('PSC8', 'VTPT002', 'Phanh đĩa', 960000, 1, 0); -- p_maphieusuachua = ' ', p_mavtpt = ' ', p_tenvtpt = ' ', p_dongiaban = , p_soluongsu = , p_sleep_time = 0
END;
/
-- Commit giao dịch
COMMIT;

-- Kiểm tra tổng tiền của phiếu sửa chữa
SELECT * FROM PHIEUSUACHUA;

-- Kiểm tra chi tiết phiếu sửa chữa
SELECT * FROM CT_SUDUNGVTPT;

SELECT * FROM SUDUNG_TIENCONG;

SELECT * FROM TIENCONG;

SELECT * FROM VATTUPHUTUNG;

------------------------------------------NONREPEATABLE READ---------------------------------------------------------
CREATE OR REPLACE PROCEDURE update_inventory (
    p_mavtpt IN VATTUPHUTUNG.MaVTPT%TYPE,
    p_soluong IN NUMBER,
    p_sleep_time IN NUMBER
) AS
BEGIN
    -- Cập nhật số lượng tồn kho
    UPDATE VATTUPHUTUNG
    SET SoLuongTon = SoLuongTon + p_soluong
    WHERE MaVTPT = p_mavtpt;

    -- Gọi procedure sleep nếu có thời gian ngủ
    IF p_sleep_time > 0 THEN
        sleep(p_sleep_time);
    END IF;
END;
/

-- Session 1: Nhân viên 1 đọc số lượng tồn kho và kiểm tra
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
DECLARE
    v_soluong NUMBER;
BEGIN

    -- Đọc số lượng tồn kho lần đầu
    SELECT SoLuongTon
    INTO v_soluong
    FROM VATTUPHUTUNG
    WHERE MaVTPT = 'VTPT001';

    -- Ghi log hoặc xử lý sau lần đọc đầu
    DBMS_OUTPUT.PUT_LINE('Lần đọc đầu: ' || v_soluong);

    -- Mô phỏng thời gian trễ
    sleep(10);

    -- Đọc lại số lượng tồn kho
    SELECT SoLuongTon
    INTO v_soluong
    FROM VATTUPHUTUNG
    WHERE MaVTPT = 'VTPT001';

    -- Ghi log hoặc xử lý sau lần đọc lại
    DBMS_OUTPUT.PUT_LINE('Lần đọc lại: ' || v_soluong);
    COMMIT;
END;
/
COMMIT;


-- Session 2: Nhân viên 2 cập nhật số lượng tồn kho
BEGIN
    UPDATE VATTUPHUTUNG
    SET SoLuongTon = SoLuongTon + 2
    WHERE MaVTPT = 'VTPT001';
    COMMIT;
END;
/
COMMIT;

SELECT * FROM VATTUPHUTUNG WHERE MaVTPT = 'VTPT001';


-- Kiểm tra tổng tiền của phiếu sửa chữa
SELECT * FROM PHIEUSUACHUA;

SELECT * FROM XE;

commit;
-- Kiểm tra chi tiết phiếu sửa chữa
SELECT * FROM CT_SUDUNGVTPT;

SELECT * FROM SUDUNG_TIENCONG;

SELECT * FROM TIENCONG;

SELECT * FROM VATTUPHUTUNG WHERE MaVTPT = 'VTPT001';

SELECT * FROM TAIKHOAN;

CREATE OR REPLACE PROCEDURE LuuPhieuThuTien(
    p_bienSo IN XE.BIENSO%TYPE,
    p_soTienThu IN NUMBER,
    p_ngayThuTien IN DATE
) IS
    v_tienNoMoi NUMBER;
    v_maPhieuThuTien VARCHAR2(20);
BEGIN
    -- Tạo mã phiếu thu tiền từ sequence
    SELECT 'PTT' || TO_CHAR(MaPhieuThuTien_SEQ.NEXTVAL, 'FM00000') INTO v_maPhieuThuTien FROM DUAL;

    -- Thêm bản ghi vào PHIEU_THU_TIEN
    INSERT INTO PHIEU_THU_TIEN (MAPHIEUTHUTIEN, BIENSO, SOTIENTHU, NGAYTHUTIEN)
    VALUES (v_maPhieuThuTien, p_bienSo, p_soTienThu, p_ngayThuTien);

    -- Cập nhật tiền nợ của xe
    UPDATE XE
    SET TIENNO = TIENNO - p_soTienThu
    WHERE BIENSO = p_bienSo
    RETURNING TIENNO INTO v_tienNoMoi;

    -- Kiểm tra và báo lỗi nếu tiền nợ mới nhỏ hơn 0
    IF v_tienNoMoi < 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Số tiền thu lớn hơn số tiền nợ hiện tại.');
    END IF;

    COMMIT;
END;
/




























--trigger
CREATE OR REPLACE TRIGGER TRIGGER_TienNo
AFTER INSERT ON PHIEUTHUTIEN
FOR EACH ROW
BEGIN
  UPDATE XE
  SET TienNo = TienNo - :NEW.SoTienThu
  WHERE BienSo = :NEW.BienSo;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_ThanhTienVTPT
BEFORE INSERT ON CT_SUDUNGVTPT
FOR EACH ROW
BEGIN
  :NEW.ThanhTien := 0;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_ThanhTienPSC
BEFORE INSERT ON PHIEUSUACHUA
FOR EACH ROW
BEGIN
  :NEW.ThanhTienPSC := 0;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_SoLuongTon
BEFORE INSERT ON VATTUPHUTUNG
FOR EACH ROW
BEGIN
  :NEW.SoLuongTon := 0;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_NgayTiepNhan
BEFORE INSERT ON XE
FOR EACH ROW
BEGIN
  :NEW.NgayTiepNhan := SYSDATE;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_NgayThuTien
BEFORE INSERT ON PHIEUTHUTIEN
FOR EACH ROW
BEGIN
  :NEW.NgayThuTien := SYSDATE;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_KIEMTRATRUNGKHITHEMSUAKHACHHANG
BEFORE INSERT OR UPDATE ON KHACHHANG
FOR EACH ROW
BEGIN
  IF (INSERTING OR UPDATING) THEN
    IF EXISTS (
      SELECT 1
      FROM KHACHHANG
      WHERE MaKH <> :NEW.MaKH
        AND (HoTenKH = :NEW.HoTenKH OR DienThoai = :NEW.DienThoai)
    ) THEN
      RAISE_APPLICATION_ERROR(-20001, 'Khách hàng đã tồn tại hoặc thông tin trùng lặp.');
    END IF;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_KiemTraTrungKhiThemSuaTienCong
BEFORE INSERT OR UPDATE ON TIENCONG
FOR EACH ROW
BEGIN
  IF (INSERTING OR UPDATING) THEN
    IF EXISTS (
      SELECT 1
      FROM TIENCONG
      WHERE MaTC <> :NEW.MaTC AND TenTC = :NEW.TenTC
    ) THEN
      RAISE_APPLICATION_ERROR(-20002, 'Tiền công đã tồn tại hoặc thông tin trùng lặp.');
    END IF;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_KiemTraTrungKhiThemSuaVTPT
BEFORE INSERT OR UPDATE ON VATTUPHUTUNG
FOR EACH ROW
BEGIN
  IF (INSERTING OR UPDATING) THEN
    IF EXISTS (
      SELECT 1
      FROM VATTUPHUTUNG
      WHERE MaVTPT <> :NEW.MaVTPT AND TenVTPT = :NEW.TenVTPT
    ) THEN
      RAISE_APPLICATION_ERROR(-20003, 'Vật tư phụ tùng đã tồn tại hoặc thông tin trùng lặp.');
    END IF;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_SoXeToiDa
BEFORE INSERT ON XE
FOR EACH ROW
DECLARE
  SoXeToiDa NUMBER := 50; -- Số xe tối đa tiếp nhận trong ngày
  SoXeTrongNgay NUMBER;
BEGIN
  SELECT COUNT(*)
  INTO SoXeTrongNgay
  FROM XE
  WHERE TRUNC(NgayTiepNhan) = TRUNC(SYSDATE);

  IF SoXeTrongNgay >= SoXeToiDa THEN
    RAISE_APPLICATION_ERROR(-20004, 'Đã đạt số xe tối đa tiếp nhận trong ngày.');
  END IF;
END;
/
-- TRIGGER BÁO CÁO DOANH soso
CREATE OR REPLACE PROCEDURE GenerateBaoCaoDoanhSo(
    p_thang IN NUMBER,
    p_nam IN NUMBER,
    p_maBaoCao OUT VARCHAR2
) IS
    v_tongDoanhThu NUMBER;
BEGIN
    -- Tính tổng doanh thu cho tháng và năm được cung cấp
    SELECT SUM(SoTienThu) INTO v_tongDoanhThu
    FROM PHIEUTHUTIEN
    WHERE EXTRACT(MONTH FROM NgayThu) = p_thang
      AND EXTRACT(YEAR FROM NgayThu) = p_nam;

    -- Tạo mã báo cáo doanh số
    SELECT 'BC' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS')
    INTO p_maBaoCao
    FROM dual;

    -- Chèn báo cáo doanh số mới vào bảng
    INSERT INTO BAOCAODOANHSO (MaBCDS, Thang, Nam, TongDoanhThu)
    VALUES (p_maBaoCao, p_thang, p_nam, NVL(v_tongDoanhThu, 0));

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        p_maBaoCao := NULL;
    WHEN OTHERS THEN
        p_maBaoCao := NULL;
        RAISE;
END;
/

--------------------
CREATE OR REPLACE TRIGGER TRIGGER_SoTienThu
BEFORE INSERT ON PHIEUTHUTIEN
FOR EACH ROW
BEGIN
  DECLARE
    TienNoXe XE.TienNo%TYPE;
  BEGIN
    SELECT TienNo INTO TienNoXe FROM XE WHERE BienSo = :NEW.BienSo;
    IF :NEW.SoTienThu > TienNoXe THEN
      RAISE_APPLICATION_ERROR(-20005, 'Số tiền thu không được vượt quá số tiền nợ.');
    END IF;
  END;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_SoLuongSuDung
BEFORE INSERT OR UPDATE ON CT_SUDUNGVTPT
FOR EACH ROW
DECLARE
  SoLuongTon NUMBER;
BEGIN
  SELECT SoLuongTon
  INTO SoLuongTon
  FROM VATTUPHUTUNG
  WHERE MaVTPT = :NEW.MaVTPT;

  IF (:NEW.SoLuongSuDung > SoLuongTon) THEN
    RAISE_APPLICATION_ERROR(-20006, 'Số lượng sử dụng vượt quá số lượng tồn của vật tư phụ tùng.');
  END IF;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_SoLuongNhap
BEFORE INSERT OR UPDATE ON CT_PHIEUNHAPVTPT
FOR EACH ROW
DECLARE
  SoLuongTonTemp NUMBER;
BEGIN
  SELECT SoLuongTon INTO SoLuongTonTemp
  FROM VATTUPHUTUNG
  WHERE MaVTPT = :NEW.MaVTPT;

  IF (:NEW.SoLuongNhap <= 0) THEN
    raise_application_error(-20001,'Số lượng nhập phải lớn hơn 0');
  ELSE
    SoLuongTonTemp := SoLuongTonTemp + :NEW.SoLuongNhap;
    UPDATE VATTUPHUTUNG
    SET SoLuongTon = SoLuongTonTemp
    WHERE MaVTPT = :NEW.MaVTPT;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_CT_SUDUNGVTPT
BEFORE INSERT OR UPDATE ON CT_SUDUNGVTPT
FOR EACH ROW
DECLARE
  DonGiaBanTemp NUMBER;
  TongThanhTien NUMBER;
BEGIN
  SELECT DonGiaBan INTO DonGiaBanTemp
  FROM VATTUPHUTUNG
  WHERE MaVTPT = :NEW.MaVTPT;

  :NEW.ThanhTien := :NEW.SoLuongSuDung * DonGiaBanTemp;

  SELECT SUM(ThanhTien) INTO TongThanhTien
  FROM CT_SUDUNGVTPT
  WHERE MaPhieuSuaChua = :NEW.MaPhieuSuaChua;

  UPDATE PHIEUSUACHUA
  SET ThanhTienPSC = TongThanhTien
  WHERE MaPhieuSuaChua = :NEW.MaPhieuSuaChua;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_Thang
BEFORE INSERT OR UPDATE ON BAOCAODOANHSO
FOR EACH ROW
BEGIN
  IF (:NEW.Thang < 1 OR :NEW.Thang > 12) THEN
    RAISE_APPLICATION_ERROR(-20007, 'Tháng phải từ 1 đến 12.');
  END IF;
END;
/

CREATE OR REPLACE TRIGGER TRIGGER_TongDoanhThu
BEFORE INSERT OR UPDATE ON BAOCAODOANHSO
FOR EACH ROW
BEGIN
  SELECT SUM(ThanhTien)
  INTO :NEW.TongDoanhThu
  FROM CT_BAOCAODOANHSO;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_CHECK_BAOCAOTON
BEFORE DELETE ON BAOCAOTON
FOR EACH ROW
BEGIN
  IF :OLD.TrangThai = 'APPROVED' THEN
    RAISE_APPLICATION_ERROR(-20008, 'Không được xóa báo cáo tồn đã phê duyệt.');
  END IF;
END;
/

CREATE OR REPLACE PROCEDURE ChangePassword(
    p_username IN VARCHAR2,
    p_currentPassword IN VARCHAR2,
    p_newPassword IN VARCHAR2,
    p_success OUT NUMBER
) IS
    v_existingPassword VARCHAR2(255);
BEGIN
    -- Lấy mật khẩu hiện tại từ cơ sở dữ liệu
    SELECT MATKHAU INTO v_existingPassword
    FROM TAIKHOAN
    WHERE TENDANGNHAP = p_username;

    -- Kiểm tra mật khẩu hiện tại
    IF v_existingPassword = p_currentPassword THEN
        -- Cập nhật mật khẩu mới
        UPDATE TAIKHOAN
        SET MATKHAU = p_newPassword
        WHERE TENDANGNHAP = p_username;
        p_success := 1; -- Thành công
    ELSE
        p_success := 0; -- Thất bại
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        p_success := 0; -- Thất bại khi không tìm thấy người dùng
    WHEN OTHERS THEN
        p_success := 0; -- Thất bại với lý do khác
END;
/



CREATE OR REPLACE PROCEDURE Proc_CapNhatTienNoKhachHang(
  p_MaKH IN NUMBER,
  p_SoTienThu IN NUMBER
) IS
BEGIN
  UPDATE KHACHHANG
  SET TienNo = TienNo - p_SoTienThu
  WHERE MaKH = p_MaKH;
END;
/
CREATE OR REPLACE PROCEDURE Proc_TraCuuTienNoKhachHang(
  p_HoTenKH IN VARCHAR2,
  p_DienThoai IN VARCHAR2,
  p_TienNo OUT NUMBER
) IS
BEGIN
  SELECT TienNo
  INTO p_TienNo
  FROM KHACHHANG
  WHERE HoTenKH = p_HoTenKH AND DienThoai = p_DienThoai;
END;
/
CREATE OR REPLACE PROCEDURE Proc_BaoCaoDoanhSoThang(
  p_Thang IN NUMBER,
  p_Nam IN NUMBER
) IS
BEGIN
  -- Insert into BAOCAODOANHSO with the given month and year.
  INSERT INTO BAOCAODOANHSO (Thang, Nam, TongDoanhThu)
  VALUES (p_Thang, p_Nam, 0);

  -- Calculate and update the total revenue for the month.
  UPDATE BAOCAODOANHSO
  SET TongDoanhThu = (
    SELECT SUM(ThanhTien)
    FROM PHIEUSUACHUA
    WHERE EXTRACT(MONTH FROM NgaySuaChua) = p_Thang
      AND EXTRACT(YEAR FROM NgaySuaChua) = p_Nam
  )
  WHERE Thang = p_Thang AND Nam = p_Nam;
END;
/
CREATE OR REPLACE PROCEDURE Proc_TraCuuPhieuSuaChua(
  p_MaPhieuSuaChua IN NUMBER,
  p_ThongTin OUT SYS_REFCURSOR
) IS
BEGIN
  OPEN p_ThongTin FOR
  SELECT *
  FROM PHIEUSUACHUA
  WHERE MaPhieuSuaChua = p_MaPhieuSuaChua;
END;
/
CREATE OR REPLACE PROCEDURE Proc_TinhSoLuongTonVTPT(
  p_MaVTPT IN NUMBER,
  p_SoLuongTon OUT NUMBER
) IS
BEGIN
  SELECT SoLuongTon
  INTO p_SoLuongTon
  FROM VATTUPHUTUNG
  WHERE MaVTPT = p_MaVTPT;
END;
/
--trigger kiem tra ko am
CREATE OR REPLACE TRIGGER TRIGGER_SoDienThoai
BEFORE INSERT OR UPDATE ON KHACHHANG
FOR EACH ROW
BEGIN
  IF NOT REGEXP_LIKE(:NEW.DienThoai, '^\d+$') THEN
    RAISE_APPLICATION_ERROR(-20002, 'Số điện thoại phải là số nguyên dương.');
  END IF;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_SoTienThu
BEFORE INSERT OR UPDATE ON PHIEUTHUTIEN
FOR EACH ROW
BEGIN
  IF (:NEW.SoTienThu <= 0 OR :NEW.SoTienThu != TRUNC(:NEW.SoTienThu)) THEN
    RAISE_APPLICATION_ERROR(-20003, 'Số tiền thu phải là số nguyên dương.');
  END IF;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_SoLuongSuDung
BEFORE INSERT OR UPDATE ON CT_SUDUNGVTPT
FOR EACH ROW
BEGIN
  IF (:NEW.SoLuongSuDung <= 0 OR :NEW.SoLuongSuDung != TRUNC(:NEW.SoLuongSuDung)) THEN
    RAISE_APPLICATION_ERROR(-20004, 'Số lượng sử dụng phải là số nguyên dương.');
  END IF;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_Nam
BEFORE INSERT OR UPDATE ON BAOCAODOANHSO
FOR EACH ROW
BEGIN
  IF (:NEW.Nam <= 0 OR :NEW.Nam != TRUNC(:NEW.Nam)) THEN
    RAISE_APPLICATION_ERROR(-20005, 'Năm phải là số nguyên dương.');
  END IF;
END;
/
CREATE OR REPLACE TRIGGER TRIGGER_SoTienThu
BEFORE INSERT ON PHIEUTHUTIEN
FOR EACH ROW
BEGIN
  DECLARE
    TienNoXe XE.TienNo%TYPE;
  BEGIN
    SELECT TienNo INTO TienNoXe FROM XE WHERE BienSo = :NEW.BienSo;
    IF :NEW.SoTienThu > TienNoXe THEN
      RAISE_APPLICATION_ERROR(-20005, 'Số tiền thu không được vượt quá số tiền nợ.');
    END IF;
  END;
END;
/

