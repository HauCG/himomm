-- Thêm dữ liệu cho bảng provinces
INSERT INTO province (province_id, province_name)
SELECT 1, 'Hà Nội' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 1);

INSERT INTO province (province_id, province_name)
SELECT 2, 'TP. Hồ Chí Minh' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 2);

INSERT INTO province (province_id, province_name)
SELECT 3, 'Hải Phòng' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 3);

INSERT INTO province (province_id, province_name)
SELECT 4, 'Đà Nẵng' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 4);

INSERT INTO province (province_id, province_name)
SELECT 5, 'Hà Giang' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 5);

INSERT INTO province (province_id, province_name)
SELECT 6, 'Cao Bằng' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 6);

INSERT INTO province (province_id, province_name)
SELECT 7, 'Lai Châu' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 7);

INSERT INTO province (province_id, province_name)
SELECT 8, 'Lào Cai' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 8);

INSERT INTO province (province_id, province_name)
SELECT 9, 'Tuyên Quang' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 9);

INSERT INTO province (province_id, province_name)
SELECT 10, 'Lạng Sơn' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 10);

INSERT INTO province (province_id, province_name)
SELECT 11, 'Bắc Kạn' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 11);

INSERT INTO province (province_id, province_name)
SELECT 12, 'Thái Nguyên' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 12);

INSERT INTO province (province_id, province_name)
SELECT 13, 'Yên Bái' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 13);

INSERT INTO province (province_id, province_name)
SELECT 14, 'Sơn La' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 14);

INSERT INTO province (province_id, province_name)
SELECT 15, 'Phú Thọ' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 15);

INSERT INTO province (province_id, province_name)
SELECT 16, 'Vĩnh Phúc' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 16);

INSERT INTO province (province_id, province_name)
SELECT 17, 'Quảng Ninh' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 17);

INSERT INTO province (province_id, province_name)
SELECT 18, 'Bắc Giang' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 18);

INSERT INTO province (province_id, province_name)
SELECT 19, 'Bắc Ninh' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 19);

INSERT INTO province (province_id, province_name)
SELECT 20, 'Hải Dương' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 20);

INSERT INTO province (province_id, province_name)
SELECT 21, 'Hưng Yên' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 21);

INSERT INTO province (province_id, province_name)
SELECT 22, 'Hoà Bình' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 22);

INSERT INTO province (province_id, province_name)
SELECT 23, 'Hà Nam' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 23);

INSERT INTO province (province_id, province_name)
SELECT 24, 'Nam Định' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 24);

INSERT INTO province (province_id, province_name)
SELECT 25, 'Thái Bình' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 25);

INSERT INTO province (province_id, province_name)
SELECT 26, 'Ninh Bình' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 26);

INSERT INTO province (province_id, province_name)
SELECT 27, 'Thanh Hoá' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 27);

INSERT INTO province (province_id, province_name)
SELECT 28, 'Nghệ An' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 28);

INSERT INTO province (province_id, province_name)
SELECT 29, 'Hà Tĩnh' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 29);

INSERT INTO province (province_id, province_name)
SELECT 30, 'Quảng Bình' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 30);

INSERT INTO province (province_id, province_name)
SELECT 31, 'Quảng Trị' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 31);

INSERT INTO province (province_id, province_name)
SELECT 32, 'Thừa Thiên Huế' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 32);

INSERT INTO province (province_id, province_name)
SELECT 33, 'Quảng Nam' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 33);

INSERT INTO province (province_id, province_name)
SELECT 34, 'Quảng Ngãi' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 34);

INSERT INTO province (province_id, province_name)
SELECT 35, 'Kon Tum' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 35);

INSERT INTO province (province_id, province_name)
SELECT 36, 'Bình Định' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 36);

INSERT INTO province (province_id, province_name)
SELECT 37, 'Gia Lai' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 37);

INSERT INTO province (province_id, province_name)
SELECT 38, 'Phú Yên' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 38);

INSERT INTO province (province_id, province_name)
SELECT 39, 'Đắk Lắk' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 39);

INSERT INTO province (province_id, province_name)
SELECT 40, 'Khánh Hoà' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 40);

INSERT INTO province (province_id, province_name)
SELECT 41, 'Lâm Đồng' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 41);

INSERT INTO province (province_id, province_name)
SELECT 42, 'Bình Phước' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 42);

INSERT INTO province (province_id, province_name)
SELECT 43, 'Bình Dương' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 43);

INSERT INTO province (province_id, province_name)
SELECT 44, 'Ninh Thuận' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 44);

INSERT INTO province (province_id, province_name)
SELECT 45, 'Tây Ninh' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 45);

INSERT INTO province (province_id, province_name)
SELECT 46, 'Bình Thuận' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 46);

INSERT INTO province (province_id, province_name)
SELECT 47, 'Đồng Nai' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 47);

INSERT INTO province (province_id, province_name)
SELECT 48, 'Long An' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 48);

INSERT INTO province (province_id, province_name)
SELECT 49, 'Đồng Tháp' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 49);

INSERT INTO province (province_id, province_name)
SELECT 50, 'An Giang' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 50);

INSERT INTO province (province_id, province_name)
SELECT 51, 'Bà Rịa - Vũng Tàu' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 51);

INSERT INTO province (province_id, province_name)
SELECT 52, 'Tiền Giang' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 52);

INSERT INTO province (province_id, province_name)
SELECT 53, 'Kiên Giang' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 53);

INSERT INTO province (province_id, province_name)
SELECT 54, 'Cần Thơ' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 54);

INSERT INTO province (province_id, province_name)
SELECT 55, 'Bến Tre' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 55);

INSERT INTO province (province_id, province_name)
SELECT 56, 'Vĩnh Long' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 56);

INSERT INTO province (province_id, province_name)
SELECT 57, 'Trà Vinh' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 57);

INSERT INTO province (province_id, province_name)
SELECT 58, 'Sóc Trăng' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 58);

INSERT INTO province (province_id, province_name)
SELECT 59, 'Bạc Liêu' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 59);

INSERT INTO province (province_id, province_name)
SELECT 60, 'Cà Mau' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 60);

INSERT INTO province (province_id, province_name)
SELECT 61, 'Điện Biên' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 61);

INSERT INTO province (province_id, province_name)
SELECT 62, 'Đắk Nông' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 62);

INSERT INTO province (province_id, province_name)
SELECT 63, 'Hậu Giang' WHERE NOT EXISTS (SELECT 1 FROM province WHERE province_id = 63);

INSERT IGNORE INTO province (province_id, name) VALUES
(1, 'An Giang'),
(2, 'Bà Rịa - Vũng Tàu'),
(3, 'Bắc Giang'),
(4, 'Bắc Kạn');

INSERT IGNORE INTO customers (id, name, email, address, province_id) VALUES
(1, 'John Doe', 'john@example.com', '123 Main St', 1),
(2, 'Jane Smith', 'jane@example.com', '456 Oak Ave', 2),
(3, 'Bob Johnson', 'bob@example.com', '789 Pine Rd', 1);
