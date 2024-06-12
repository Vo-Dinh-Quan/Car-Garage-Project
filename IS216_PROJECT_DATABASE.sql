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
CREATE SEQUENCE KHACHHANG_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE SEQ_MAVTPT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_MAPNVTPT START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_VTPT START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_PNVTPT START WITH 1 INCREMENT BY 1;

INSERT INTO TAIKHOAN (CHUCVU, TENDANGNHAP, MATKHAU) VALUES ('Quan ly', 'vodinhminhquan','22521193');
commit;

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


CREATE SEQUENCE MaPhieuSuaChua_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;


CREATE SEQUENCE MaPhieuThuTien_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

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
    -- Khóa bảng CT_SUDUNGVTPT để ngăn chặn ghi đè dữ liệu
    --EXECUTE IMMEDIATE 'LOCK TABLE CT_SUDUNGVTPT IN EXCLUSIVE MODE';
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

    TYPE vtpt_rec_type IS RECORD (
        maphieusuachua CT_SUDUNGVTPT.MaPhieuSuaChua%TYPE,
        mavtpt CT_SUDUNGVTPT.MaVTPT%TYPE,
        soluongsu CT_SUDUNGVTPT.SoLuongSuDung%TYPE,
        old_soluongsu CT_SUDUNGVTPT.SoLuongSuDung%TYPE
    );

    TYPE vtpt_table_type IS TABLE OF vtpt_rec_type;
    vtpt_table vtpt_table_type := vtpt_table_type();

    BEFORE STATEMENT IS
    BEGIN
        vtpt_table.DELETE;
    END BEFORE STATEMENT;

    AFTER EACH ROW IS
    BEGIN
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
                v_tongtien NUMBER;
            BEGIN
                -- Tính tổng tiền từ bảng CT_SUDUNGVTPT
                SELECT NVL(SUM(CT.ThanhTien), 0)
                INTO v_tongtien
                FROM CT_SUDUNGVTPT CT
                WHERE CT.MaPhieuSuaChua = vtpt_table(i).maphieusuachua;

                -- Cập nhật lại giá trị ThanhTienPSC trên PHIEUSUACHUA
                UPDATE PHIEUSUACHUA
                SET ThanhTienPSC = v_tongtien
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
    add_content_to_ct_sudungvtpt('PSC8', 'VTPT004', 'Bugi', 120000, 1, 10); -- p_maphieusuachua = '2', p_mavtpt = '4', p_tenvtpt = 'Tên VTPT 4', p_dongiaban = 100000, p_soluongsu = 5, p_sleep_time = 10
    COMMIT;
END;
/

-- Session 2: 
BEGIN
    -- Gọi hàm add_content_to_ct_sudungvtpt với thời gian tạm dừng 0 giây
    add_content_to_ct_sudungvtpt('PSC8', 'VTPT002', 'Phanh đĩa', 960000, 1, 0); -- p_maphieusuachua = '2', p_mavtpt = '3', p_tenvtpt = 'Tên VTPT 3', p_dongiaban = 50000, p_soluongsu = 2, p_sleep_time = 0
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

-- Session 1: Đọc và xác minh số lượng tồn kho với mức độ cô lập cao
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
-- Session 1: Nhân viên 1 đọc số lượng tồn kho và kiểm tra
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
    sleep(5);

    -- Đọc lại số lượng tồn kho
    SELECT SoLuongTon
    INTO v_soluong
    FROM VATTUPHUTUNG
    WHERE MaVTPT = 'VTPT001';

    -- Ghi log hoặc xử lý sau lần đọc lại
    DBMS_OUTPUT.PUT_LINE('Lần đọc lại: ' || v_soluong);
END;
/
-- Commit giao dịch
COMMIT;


-- Session 2: Nhân viên 2 cập nhật số lượng tồn kho
BEGIN
    -- Cập nhật số lượng tồn kho
    UPDATE VATTUPHUTUNG
    SET SoLuongTon = SoLuongTon + 10
    WHERE MaVTPT = 'VTPT001';
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
