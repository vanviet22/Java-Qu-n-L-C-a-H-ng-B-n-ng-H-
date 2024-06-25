/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;
import BUS.HoaDon_BUS;
import DTO.HoaDon_DTO;
import DTO.KMtheoSP_DTO;
import BUS.CTHoaDon_BUS;
import BUS.CTKM_BUS;
import DTO.CTKM_DTO;
import DTO.ChiTietHoaDon_DTO;
import BUS.SanPham_BUS;
import DTO.SanPham_DTO;
import BUS.KMTheoSP_BUS;
import DTO.loaiSP_DTO;
import BUS.LoaiSP_BUS;
import DTO.KMtheoTTien_DTO;
import BUS.KMTheoTT_BUS;

public class GUI_CTHoaDon extends javax.swing.JFrame {
    private ThongTinDN dn=new ThongTinDN();
    private ArrayList<String> luuTruTF = new ArrayList<String>();
    DefaultTableModel model = new DefaultTableModel();
    private HoaDon_BUS hoaDon_BUS = new HoaDon_BUS();
    private CTKM_BUS ctkm_BUS = new CTKM_BUS();
    private CTHoaDon_BUS cthd_BUS = new CTHoaDon_BUS();
    private SanPham_BUS sanPham_BUS = new SanPham_BUS();
    private KMTheoSP_BUS kmTheoSP_BUS = new KMTheoSP_BUS();
    private KMTheoTT_BUS kmTheoTT_BUS = new KMTheoTT_BUS();
    private LoaiSP_BUS loaiSP_BUS = new LoaiSP_BUS();
    private ArrayList<HoaDon_DTO> listHoaDon = hoaDon_BUS.getListHD();
    private ArrayList<SanPham_DTO> listSanPham = sanPham_BUS.getList();
    private ArrayList<KMtheoSP_DTO> listKmtheoSP = kmTheoSP_BUS.getList();
    private ArrayList<CTKM_DTO> listCTKM = ctkm_BUS.getList();
    private ArrayList<loaiSP_DTO> listLoaiSP = loaiSP_BUS.getListLoai();
    private ArrayList<KMtheoTTien_DTO> listKMTheoTT = kmTheoTT_BUS.getList();
    private ArrayList<ChiTietHoaDon_DTO> listCTHD = cthd_BUS.getListCTHD();

    // Hàm khởi tạo
    public GUI_CTHoaDon() {
        // Hàm gọi form
        addControls();
        // Hàm gọi sự kiện
        addEvents();
    }

    // Thuộc Tính Trang Chủ
    Panel paTieuDe = new Panel();
    Panel paMenu = new Panel();
    Panel paChiTiet = new Panel();
    JLabel lbTieuDeTrai = new JLabel("        Chào mừng đến với hệ thống quản lí");
    JLabel lbTieuDePhai = new JLabel(dn.getHoTen());
    JButton btnSanPham = new JButton("Sản Phẩm");
    JButton btnKhachHang = new JButton("Khách hàng");
    JButton btnNhanVien = new JButton("Nhân viên");
    JButton btnBanHang = new JButton("Bán hàng");
    JButton btnKhuyenMai = new JButton("Khuyến mãi");
    JButton btnDuyet = new JButton("Duyệt yêu cầu");
    JButton btnUser = new JButton("User");
    JButton btnNCC = new JButton("Nhà cung cấp");
    JButton btnKhoHang = new JButton("Kho hàng");
    JButton btnThongKe = new JButton("Thống kê");
    JButton btnDangXuat = new JButton("Đăng xuất");
    ImageIcon icon = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\iConTrangChu.png");
    JLabel lbImgTrangChu = new JLabel();
    // Thuộc tính của CHI TIẾT HÓA ĐƠN
    // private javax.swing.JComboBox<String> JComboBoxMAHD;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnResetCTHD;
    private javax.swing.JButton btnSuaCTHD;
    private javax.swing.JButton btnThemCTHD;
    private javax.swing.JButton btnTimKiemCTHD;
    private javax.swing.JButton btnXoaCTHD;
    // private javax.swing.JComboBox<String> jComboBoxMACT;
    // private javax.swing.JComboBox<String> jComboBoxMASP;
    private javax.swing.JComboBox<String> jComboBoxTKCTHD;
    private javax.swing.JScrollPane jScrollPaneCTDH;
    private javax.swing.JSpinner jSpinnerSoLuong;
    private javax.swing.JTable jTableCTHD;
    private javax.swing.JLabel lbGia;
    private javax.swing.JLabel lbImgBill;
    private javax.swing.JLabel lbMaChuongTrinh;
    private javax.swing.JLabel lbMaHDCTHD;
    private javax.swing.JLabel lbMaSPCTHD;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbThanhTien;
    private javax.swing.JLabel lbTienGiamCTHD;
    private javax.swing.JLabel lbTieuDeCTHD;
    private javax.swing.JTextField tfGia;
    private javax.swing.JTextField tfMaCT;
    private javax.swing.JTextField tfMaHDCTHD;
    private javax.swing.JTextField tfMaSPCTDH;
    private javax.swing.JTextField tfThanhTien;
    private javax.swing.JTextField tfTienGiam;
    private javax.swing.JTextField tfTuKhoaTKCTHD;
    private javax.swing.JTable jTableMAHD;
    private javax.swing.JScrollPane jScrollPaneMAHD;
    private javax.swing.JTable jTableMASP;
    private javax.swing.JScrollPane jScrollPaneMASP;

    // HÀM FORM
    private void addControls() {
        setTitle("Quản lí sản phẩm");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Tắt LayoutManager để sử dụng setBounds()
        setResizable(false);
        lbImgTrangChu.setIcon(icon);
        lbImgTrangChu.setHorizontalAlignment(JLabel.CENTER);
        lbImgTrangChu.setVerticalAlignment(JLabel.CENTER);
        paTieuDe.setBounds(150, 0, 750, 30);
        paTieuDe.setBackground(new java.awt.Color(102, 102, 102));

        paMenu.setBounds(0, 0, 150, 565); // Đặt vị trí và kích thước cho panel paMenu
        // paMenu.setLayout(new GridLayout(12, 1));
        paMenu.setBackground(new java.awt.Color(51, 153, 255));

        // Panel chi tiết
        paChiTiet.setBounds(143, 30, 750, 535); // Đặt vị trí và kích thước cho panel chi tiết
        paChiTiet.setBackground(new java.awt.Color(204, 204, 204));

        // Đặt kích thước cho các nút trong paMenu
        lbImgTrangChu.setPreferredSize(new Dimension(150, 180));
        btnSanPham.setPreferredSize(new Dimension(150, 30)); // Điều chỉnh kích thước nút
        btnKhachHang.setPreferredSize(new Dimension(150, 30));
        btnNhanVien.setPreferredSize(new Dimension(150, 30));
        btnBanHang.setPreferredSize(new Dimension(150, 30));
        btnKhuyenMai.setPreferredSize(new Dimension(150, 30));
        btnDuyet.setPreferredSize(new Dimension(150, 30));
        btnUser.setPreferredSize(new Dimension(150, 30));
        btnNCC.setPreferredSize(new Dimension(150, 30));
        btnKhoHang.setPreferredSize(new Dimension(150, 30));
        btnThongKe.setPreferredSize(new Dimension(150, 30));
        btnDangXuat.setPreferredSize(new Dimension(100, 22));
        btnDangXuat.setBackground(Color.PINK);
        lbTieuDeTrai.setForeground(Color.WHITE);
        lbTieuDePhai.setForeground(Color.WHITE);
        lbTieuDeTrai.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lbTieuDePhai.setFont(new Font("Times New Roman", Font.BOLD, 14));
        Box hbox = Box.createHorizontalBox();
        hbox.add(lbTieuDeTrai);
        hbox.add(Box.createHorizontalStrut(200));
        hbox.add(lbTieuDePhai);
        paTieuDe.setLayout(new BorderLayout());
        paTieuDe.add(hbox, BorderLayout.WEST);

        // Panel paMenu

        btnBanHang.setBackground(new java.awt.Color(153, 255, 153));
        paMenu.add(lbImgTrangChu);
        paMenu.add(btnSanPham);
        paMenu.add(btnKhachHang);
        paMenu.add(btnNhanVien);
        paMenu.add(btnBanHang);
        paMenu.add(btnKhuyenMai);
        paMenu.add(btnDuyet);
        paMenu.add(btnUser);
        paMenu.add(btnNCC);
        paMenu.add(btnKhoHang);
        paMenu.add(btnThongKe);
        paMenu.add(btnDangXuat);
        // FORM CỦA CHI TIẾT HÓA ĐƠN
        jScrollPaneCTDH = new javax.swing.JScrollPane();
        jTableCTHD = new javax.swing.JTable();
        jScrollPaneMAHD = new javax.swing.JScrollPane();
        jTableMAHD = new javax.swing.JTable();
        jScrollPaneMASP = new javax.swing.JScrollPane();
        jTableMASP = new javax.swing.JTable();
        btnThemCTHD = new javax.swing.JButton();
        btnSuaCTHD = new javax.swing.JButton();
        btnResetCTHD = new javax.swing.JButton();
        btnXoaCTHD = new javax.swing.JButton();
        lbMaHDCTHD = new javax.swing.JLabel();
        lbMaSPCTHD = new javax.swing.JLabel();
        lbMaChuongTrinh = new javax.swing.JLabel();
        lbGia = new javax.swing.JLabel();
        lbTienGiamCTHD = new javax.swing.JLabel();
        lbThanhTien = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        tfMaHDCTHD = new javax.swing.JTextField();
        tfMaSPCTDH = new javax.swing.JTextField();
        tfMaCT = new javax.swing.JTextField();
        tfTienGiam = new javax.swing.JTextField();
        tfThanhTien = new javax.swing.JTextField();
        tfGia = new javax.swing.JTextField();
        jComboBoxTKCTHD = new javax.swing.JComboBox<>();
        tfTuKhoaTKCTHD = new javax.swing.JTextField();
        jSpinnerSoLuong = new javax.swing.JSpinner();
        btnTimKiemCTHD = new javax.swing.JButton();
        lbTieuDeCTHD = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lbImgBill = new javax.swing.JLabel();
        // jComboBoxMACT = new javax.swing.JComboBox<>();
        // JComboBoxMAHD = new javax.swing.JComboBox<>();
        // jComboBoxMASP = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paChiTiet.setBackground(new java.awt.Color(153, 153, 153));

        jTableCTHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        jTableCTHD.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null }
                },
                new String[] {
                        "Mã HD", "Mã SP", "Mã CT", "Số lượng", "Giá", "Tiền giảm", "Thành tiền"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
                    java.lang.Float.class, java.lang.Float.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPaneCTDH.setViewportView(jTableCTHD);

        ImageIcon imageThemCTHD = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\icons8-add-27.png");
        ImageIcon imageThemCTHD_resized = new ImageIcon(
                imageThemCTHD.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        btnThemCTHD.setIcon(imageThemCTHD_resized); // NOI18N
        btnThemCTHD.setMaximumSize(new java.awt.Dimension(72, 72));
        btnThemCTHD.setPreferredSize(new java.awt.Dimension(27, 27));

        ImageIcon imageSuaCTHD = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\update.png");
        ImageIcon imageSuaCTHD_resized = new ImageIcon(
                imageSuaCTHD.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        btnSuaCTHD.setIcon(imageSuaCTHD_resized); // NOI18N
        btnSuaCTHD.setPreferredSize(new java.awt.Dimension(27, 27));

        ImageIcon imageResetCTHD = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\clear.png");
        ImageIcon imageResetCTHD_resized = new ImageIcon(
                imageResetCTHD.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        btnResetCTHD.setIcon(imageResetCTHD_resized); // NOI18N
        btnResetCTHD.setPreferredSize(new java.awt.Dimension(27, 27));

        ImageIcon imageXoaCTHD = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\Button-Delete-icon.png");
        ImageIcon imageXoaCTHD_resized = new ImageIcon(
                imageXoaCTHD.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        btnXoaCTHD.setIcon(imageXoaCTHD_resized); // NOI18
        btnXoaCTHD.setPreferredSize(new java.awt.Dimension(27, 27));

        lbMaHDCTHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMaHDCTHD.setForeground(new java.awt.Color(51, 51, 51));
        lbMaHDCTHD.setText("Mã hóa đơn");

        lbMaSPCTHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMaSPCTHD.setForeground(new java.awt.Color(51, 51, 51));
        lbMaSPCTHD.setText("Mã sản phẩm");

        lbMaChuongTrinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMaChuongTrinh.setForeground(new java.awt.Color(51, 51, 51));
        lbMaChuongTrinh.setText("Mã chương trình");

        lbGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGia.setForeground(new java.awt.Color(51, 51, 51));
        lbGia.setText("Giá");

        lbTienGiamCTHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTienGiamCTHD.setForeground(new java.awt.Color(51, 51, 51));
        lbTienGiamCTHD.setText("Tiền giảm");

        lbThanhTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbThanhTien.setForeground(new java.awt.Color(51, 51, 51));
        lbThanhTien.setText("Thành tiền");

        lbSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSoLuong.setForeground(new java.awt.Color(51, 51, 51));
        lbSoLuong.setText("Số lượng");

        tfMaHDCTHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfMaHDCTHD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfMaHDCTHD.setPreferredSize(new java.awt.Dimension(80, 25));
        tfMaSPCTDH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfMaSPCTDH.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfMaSPCTDH.setPreferredSize(new java.awt.Dimension(80, 25));

        tfMaCT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfMaCT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfMaCT.setPreferredSize(new java.awt.Dimension(80, 25));

        tfTienGiam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfTienGiam.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfTienGiam.setPreferredSize(new java.awt.Dimension(80, 25));

        tfThanhTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfThanhTien.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfThanhTien.setPreferredSize(new java.awt.Dimension(80, 25));

        tfGia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfGia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfGia.setPreferredSize(new java.awt.Dimension(80, 25));

        jComboBoxTKCTHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBoxTKCTHD.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Mã hóa đơn", "Mã sản phẩm", "Mã chương trình" }));
        tfTuKhoaTKCTHD.setText("Tìm kiếm");

        jSpinnerSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinnerSoLuong.setModel(new javax.swing.SpinnerNumberModel(0, 0, 200, 1));
//        jSpinnerSoLuong.addChangeListener(e -> {
//            updateTotalAmount();
//        });
        // JFormattedTextField tf = ((JSpinner.DefaultEditor) jSpinnerSoLuong.getEditor()).getTextField();
        // tf.setEditable(false);

        jSpinnerSoLuong.setPreferredSize(new java.awt.Dimension(67, 25));

        ImageIcon imageTimKiemCTHD = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\icons8-search-27.png");
        ImageIcon imageTimKiemCTHD_resized = new ImageIcon(
                imageTimKiemCTHD.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        btnTimKiemCTHD.setIcon(imageTimKiemCTHD_resized); // NOI18
        btnTimKiemCTHD.setPreferredSize(new java.awt.Dimension(27, 27));

        lbTieuDeCTHD.setBackground(new java.awt.Color(255, 250, 205));
        lbTieuDeCTHD.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbTieuDeCTHD.setText("Quản lý chi tiết hóa đơn");

        ImageIcon imageBack = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\quaylai.png");
        ImageIcon imageBack_resized = new ImageIcon(
                imageBack.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
        btnBack.setIcon(imageBack_resized); // NOI18N
        btnBack.setPreferredSize(new java.awt.Dimension(45, 45));

        ImageIcon imgBill = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\icons8-bill-64.png");
        lbImgBill.setIcon(imgBill); // NOI18N

        // jComboBoxMACT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
        // "..." }));
        // jComboBoxMACT.setPreferredSize(new java.awt.Dimension(60, 23));

        // JComboBoxMAHD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
        // "..." }));
        // JComboBoxMAHD.setPreferredSize(new java.awt.Dimension(60, 23));

        // jComboBoxMASP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
        // "..." }));
        // jComboBoxMASP.setPreferredSize(new java.awt.Dimension(60, 23));

        javax.swing.GroupLayout paChiTietLayout = new javax.swing.GroupLayout(paChiTiet);
        paChiTiet.setLayout(paChiTietLayout);
        paChiTietLayout.setHorizontalGroup(
                paChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paChiTietLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(paChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(paChiTietLayout.createSequentialGroup()
                                                .addComponent(jScrollPaneCTDH, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        719, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(paChiTietLayout.createSequentialGroup()
                                                .addGroup(paChiTietLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(paChiTietLayout.createSequentialGroup()
                                                                .addComponent(btnBack,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(29, 29, 29)
                                                                .addComponent(lbTieuDeCTHD))
                                                        .addGroup(paChiTietLayout.createSequentialGroup()
                                                                .addGroup(paChiTietLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                paChiTietLayout.createSequentialGroup()
                                                                                        .addComponent(lbMaHDCTHD)
                                                                                        .addGap(50, 50, 50))
                                                                        .addGroup(
                                                                                paChiTietLayout.createSequentialGroup()
                                                                                        .addComponent(lbMaSPCTHD)
                                                                                        .addGap(41, 41, 41))
                                                                        .addGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                paChiTietLayout.createSequentialGroup()
                                                                                        .addComponent(lbMaChuongTrinh)
                                                                                        .addGap(18, 18, 18)))
                                                                .addGroup(paChiTietLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(tfMaCT,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                130, Short.MAX_VALUE)
                                                                        .addComponent(tfMaSPCTDH,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(tfMaHDCTHD,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(paChiTietLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbSoLuong)
                                                                        .addComponent(lbGia,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(paChiTietLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(lbThanhTien,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        72,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                        paChiTietLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        lbTienGiamCTHD)
                                                                                                .addGap(6, 6, 6))))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(paChiTietLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(paChiTietLayout.createSequentialGroup()
                                                                .addGap(27, 27, 27)
                                                                .addComponent(tfTuKhoaTKCTHD,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 140,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jComboBoxTKCTHD,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 112,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(btnTimKiemCTHD,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(59, 59, 59))
                                                        .addGroup(paChiTietLayout.createSequentialGroup()
                                                                .addGroup(paChiTietLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(tfGia,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                130,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jSpinnerSoLuong,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tfThanhTien,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                130,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tfTienGiam,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                130,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(27, 27, 27)
                                                                .addComponent(btnThemCTHD,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(paChiTietLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(paChiTietLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(btnSuaCTHD,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        36,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(btnXoaCTHD,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        36,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(btnResetCTHD,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        36,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(lbImgBill))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)))))));
        paChiTietLayout.setVerticalGroup(
                paChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paChiTietLayout.createSequentialGroup()
                                .addGroup(paChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(paChiTietLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnTimKiemCTHD, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(paChiTietLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tfTuKhoaTKCTHD,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbTieuDeCTHD,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBoxTKCTHD,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(paChiTietLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(paChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(paChiTietLayout.createSequentialGroup()
                                                .addGroup(paChiTietLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(paChiTietLayout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(lbMaHDCTHD,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lbSoLuong,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jSpinnerSoLuong,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(tfMaHDCTHD,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(paChiTietLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(paChiTietLayout.createSequentialGroup()
                                                                .addGroup(paChiTietLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(lbGia,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tfGia,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(paChiTietLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(lbTienGiamCTHD,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tfTienGiam,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(paChiTietLayout.createSequentialGroup()
                                                                .addGroup(paChiTietLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(lbMaSPCTHD,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tfMaSPCTDH,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(paChiTietLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(tfMaCT,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbMaChuongTrinh,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 1, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                paChiTietLayout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(lbImgBill, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(paChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnThemCTHD, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSuaCTHD, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnXoaCTHD, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(paChiTietLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lbThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tfThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnResetCTHD, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPaneCTDH, javax.swing.GroupLayout.PREFERRED_SIZE, 341,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        tfTuKhoaTKCTHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tfTuKhoaTKCTHD.getText().equals("Tìm kiếm")) {
                    tfTuKhoaTKCTHD.setText("");
                }
            }
        });
        jScrollPaneMAHD.setBounds(140, 78, 130, 0);
        jScrollPaneMASP.setBounds(140, 110, 130, 0);
        DefaultTableModel modelTB = new DefaultTableModel(new Object[] { "" }, 0);
        jTableMAHD.setModel(modelTB);
        jTableMASP.setModel(modelTB);
        jScrollPaneMAHD.setViewportView(jTableMAHD);
        jScrollPaneMASP.setViewportView(jTableMASP);
        paChiTiet.add(jScrollPaneMAHD);
        paChiTiet.add(jScrollPaneMASP);
        jScrollPaneMAHD.setVisible(false);
        jScrollPaneMASP.setVisible(false);
        tfMaHDCTHD.setPreferredSize(new java.awt.Dimension(130, 25));
        tfMaCT.setText("Chưa được áp dụng");
        tfGia.setText("0");
        tfTienGiam.setText("0");
        tfThanhTien.setText("0");
        tfMaCT.setEnabled(false);
        tfGia.setEnabled(false);
        tfTienGiam.setEnabled(false);
        tfThanhTien.setEnabled(false);
        // loadDataLenTableChiTietHoaDon();
        suKienEnter();
        chuyenForm();
        // KẾT THÚC
        add(paTieuDe);
        add(paMenu);
        add(paChiTiet);

        setVisible(true);
    }

    // HÀM CÁC SỰ KIỆN
    public void chuyenForm(){
         if(dn.getQuyen().equals("ADMIN"))
        {
            btnUser.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_USER().setVisible(true);
                }
            });
            btnDangXuat.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            btnKhachHang.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            btnNhanVien.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            btnKhuyenMai.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            btnSanPham.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            btnKhoHang.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            btnNCC.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            btnBanHang.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
//            bt_duyet.addActionListener(new ActionListener() {
//                @Override 
//                public void actionPerformed(ActionEvent e){
//                 
//                }
//            });
            btnThongKe.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
        }
        else if(dn.getQuyen().equals("Quản lí"))
        {
            btnUser.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên quản lí bạn không có quyền quản lí thực thể này!!");
                }
            });
            btnDangXuat.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            btnKhachHang.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_Khachhang().setVisible(true);
                }
            });
            btnNhanVien.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NhanVien().setVisible(true);
                }
            });
            btnKhuyenMai.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_CTKM().setVisible(true);
                }
            });
            btnSanPham.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_Sanpham().setVisible(true);
                }
            });
            btnKhoHang.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NhapHang().setVisible(true);
                }
            });
            btnNCC.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NCC().setVisible(true);
                }
            });
            btnBanHang.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_HoaDon().setVisible(true);
                }
            });
//            bt_duyet.addActionListener(new ActionListener() {
//                @Override 
//                public void actionPerformed(ActionEvent e){
//                 
//                }
//            });
            btnThongKe.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên quản lí bạn không có quyền quản lí thực thể này!!");
                }
            });
            
        }
        else if(dn.getQuyen().equals("Nhân viên bán hàng"))
        {
            btnUser.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
            btnDangXuat.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            btnKhachHang.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_Khachhang().setVisible(true);
                }
            });
            btnNhanVien.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
            btnKhuyenMai.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_CTKM().setVisible(true);
                }
            });
            btnSanPham.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_Sanpham().setVisible(true);
                }
            });
            btnKhoHang.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
            btnNCC.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
            btnBanHang.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_HoaDon().setVisible(true);
                }
            });
//            bt_duyet.addActionListener(new ActionListener() {
//                @Override 
//                public void actionPerformed(ActionEvent e){
//                 
//                }
//            });
            btnThongKe.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
        }
        else
        {
            btnUser.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_USER().setVisible(true);
                }
            });
            btnDangXuat.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            btnKhachHang.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_Khachhang().setVisible(true);
                }
            });
            btnNhanVien.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NhanVien().setVisible(true);
                }
            });
            btnKhuyenMai.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_CTKM().setVisible(true);
                }
            });
            btnSanPham.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_Sanpham().setVisible(true);
                }
            });
            btnKhoHang.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NhapHang().setVisible(true);
                }
            });
            btnNCC.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NCC().setVisible(true);
                }
            });
            btnBanHang.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_HoaDon().setVisible(true);
                }
            });
//            bt_duyet.addActionListener(new ActionListener() {
//                @Override 
//                public void actionPerformed(ActionEvent e){
//                 
//                }
//            });
            btnThongKe.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_ThongKe().setVisible(true);
                }
            });
        }
    }
    private void addEvents() {
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI_HoaDon HD = new GUI_HoaDon();
                dispose();
                HD.setVisible(true);
                setLaiTextfieldHoaDon();
                HD.loadTextfield(luuTruTF);
            }
        });
        btnThemCTHD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThemCTHD();
            }
        });
        btnSuaCTHD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLySuaCTHD();
            }
        });
        btnXoaCTHD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyXoaCTHD();
            }
        });
        btnTimKiemCTHD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyTimKiemCTHoaDon();

                if(jTableCTHD.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy chi tiết hóa đơn",
                                "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        btnResetCTHD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyReset();
            }
        });

        jTableCTHD.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tbDSCTHDMouseClicked();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        // tfTuKhoaTKCTHD.addKeyListener(new java.awt.event.KeyAdapter() {
        //     public void keyReleased(java.awt.event.KeyEvent evt) {
        //         tfTuKhoaTimKiemKeyReleased(evt);
        //     }
        // });
        tfTuKhoaTKCTHD.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    xuLyTimKiemCTHoaDon();
                    
                    if(jTableCTHD.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy chi tiết hóa đơn",
                                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        // jComboBoxTKCTHD.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         cbbTimKiemActionPerformed(evt);
        //     }
        // });
        tfMaHDCTHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfMaHoaDonKeyReleased();
            }
        });
        jTableMAHD.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickTableMAHD(evt);
            }
        });
        tfMaSPCTDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfMaSanPhamKeyReleased();
            }
        });
        jTableMASP.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickTableMASP(evt);
            }
        });
        tfMaHDCTHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tfMaHoaDonKeyReleased();
            }
        });
        tfMaSPCTDH.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tfMaSanPhamKeyReleased();
            }
        });
        paChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xuLyResetTableGoiY();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                xuLyResetTableGoiY();
            }
        });
        jSpinnerSoLuong.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateTotalAmount();
            }
        });
        JFormattedTextField tfJSpinnerTKSP = ((JSpinner.DefaultEditor) jSpinnerSoLuong.getEditor()).getTextField();
        tfJSpinnerTKSP.addPropertyChangeListener("value", evt -> {
            updateTotalAmount();
            });

    }

    // lưu trữ textfield
    public ArrayList<String> getTextField(String maHD, String maKH, String maNV, String maKM,
            String ngayLap, String tienGiam, String tongtien) {
        luuTruTF.clear();
        luuTruTF.add(maHD);
        luuTruTF.add(maKH);
        luuTruTF.add(maNV);
        luuTruTF.add(maKM);
        luuTruTF.add(ngayLap);
        luuTruTF.add(tienGiam);
        luuTruTF.add(tongtien);
        xuLyTimKiemLoadCTHD(luuTruTF);
        return luuTruTF;
    }

    private void setLaiTextfieldHoaDon() {
        for (HoaDon_DTO hd : listHoaDon) {
            if (hd.getMaHD().equals(luuTruTF.get(0))) {
                luuTruTF.set(3, hd.getMaKM());
                luuTruTF.set(5, String.valueOf(hd.getTienGiam()));
                luuTruTF.set(6, String.valueOf(hd.getTongTien()));
            }
        }
        // System.out.println("======="+luuTruTF.size());
    }

    // xử lý hiện các chi tiết hóa đơn trùng với hóa đơn muốn xem
    private void xuLyTimKiemLoadCTHD(ArrayList<String> luuTru) {
        ArrayList<ChiTietHoaDon_DTO> dscthd = new ArrayList<ChiTietHoaDon_DTO>();
        if (luuTru.size() > 0) { // Kiểm tra xem luuTruTF có phần tử không
            dscthd = cthd_BUS.timKiemCacCTHD(luuTruTF.get(0));
            if (dscthd != null && dscthd.size() > 0) { // Kiểm tra xem danh sách dscthd có null hay không và có phần tử
                                                       // không
                loadDataLenTableChiTietHoaDon(dscthd);
                return;
            }
        }
        model.setRowCount(0);
        Vector tieuDe = new Vector();
        tieuDe.add("Mã HD");
        tieuDe.add("Mã SP");
        tieuDe.add("Mã CT");
        tieuDe.add("Số lượng");
        tieuDe.add("Giá");
        tieuDe.add("Tiền giảm");
        tieuDe.add("Thành tiền");
        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(tieuDe, 0);
        }
        jTableCTHD.setModel(model);
    }

    // Hàm load lên database
    private void loadDataLenTableChiTietHoaDon() {
        listCTHD = cthd_BUS.getListCTHD();
        loadDataLenTableChiTietHoaDon(listCTHD);
    }

    private String FormatTienDoubleSangString(double valueDouble) {
        return String.format("%.0f", valueDouble);
    }

    private String FormatTienFloatSangString(float valueFloat) {
        return String.format("%.0f", valueFloat);
    }

    private void loadDataLenTableChiTietHoaDon(ArrayList<ChiTietHoaDon_DTO> listCTHD) {
        model.setRowCount(0);
        Vector tieuDe = new Vector();
        tieuDe.add("Mã HD");
        tieuDe.add("Mã SP");
        tieuDe.add("Mã CT");
        tieuDe.add("Số lượng");
        tieuDe.add("Giá");
        tieuDe.add("Tiền giảm");
        tieuDe.add("Thành tiền");
        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(tieuDe, 0);
        }
        for (ChiTietHoaDon_DTO cthd : listCTHD) {
            Vector row = new Vector();
            row.add(cthd.getMaHD());
            row.add(cthd.getMaSP());
            row.add(cthd.getMaCT());
            row.add(cthd.getSoLuong());
            String giaCTHDStr = FormatTienFloatSangString(cthd.getGia());
            row.add(giaCTHDStr);
            String tienGiamCTHDStr = FormatTienFloatSangString(cthd.getTienGiam());
            row.add(tienGiamCTHDStr);
            String thanhTienCTHDStr = FormatTienDoubleSangString(cthd.getThanhTien());
            row.add(thanhTienCTHDStr);
            model.addRow(row);
            jTableCTHD.setModel(model);

        }
    }

    // Kiểm tra đầu vào hóa đơn
    private boolean kiemTraDauVaoHoaDon(String maHD) {
        for (HoaDon_DTO hd : listHoaDon) {
            if (hd.getMaHD().equals(maHD)) {
                return true;
            }
        }
        return false;
    }

    // kiểm tra đầu vào hóa đơn return ra đối tượng
    private HoaDon_DTO kiemTraDauVaoHoaDonDoiTuong(String maHD) {
        for (HoaDon_DTO hd : listHoaDon) {
            if (hd.getMaHD().equals(maHD)) {
                return hd;
            }
        }
        return null;
    }

    // kiểm tra mã sản phẩm đầu vào
    private boolean kiemTraDauVaoSanPham(String maSP) {
        for (SanPham_DTO sp : listSanPham) {
            if (sp.getMaSp().equals(maSP)) {
                kiemTraKhuyenMai(maSP);
                String donGia = FormatTienFloatSangString(sp.getDongia());
                tfGia.setText(donGia);
                return true;
            }
        }
        return false;
    }

    private void phuDinhkiemTraDauVaoSanPham() {
        tfMaSPCTDH.setText("SP không tồn tại");
        tfMaSPCTDH.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tfMaSPCTDH.getText().equals("SP không tồn tại")) {
                    tfMaSPCTDH.setText("");
                }
            }
        });
    }

    // kiểm tra số lượng sản phẩm
    private boolean kiemTraSoLuong(int soLuong) {
        int soLuongBD = 0;
        ChiTietHoaDon_DTO cthd = kiemTraCTHDDoiTuong(tfMaHDCTHD.getText(), tfMaSPCTDH.getText());
        if (cthd != null) {
            soLuongBD = cthd.getSoLuong();
        }
        for (SanPham_DTO sp : listSanPham) {
            if (sp.getMaSp().equals(tfMaSPCTDH.getText())) {
                if (soLuong == 0) {
                    return false;
                }
                else if (soLuong > sp.getSoluong() + soLuongBD) {
                    return false;
                }
            }
        }
        return true;
    }

    // kiểm tra và trả về đối tượng sản phẩm
    private SanPham_DTO doiTuongSP(String maSP) {
        for (SanPham_DTO sp : listSanPham) {
            if (sp.getMaSp().equals(maSP)) {
                return sp;
            }
        }
        return null;
    }

    // kiểm tra và trả về đối tượng loại
    private loaiSP_DTO doiTuongLoai(String maLoai) {
        for (loaiSP_DTO loai : listLoaiSP) {
            if (loai.getMaLoai().equals(maLoai)) {
                return loai;
            }
        }
        return null;
    }

    // kiểm tra khuyến mãi (SẢN PHẨM)
    private boolean kiemTraKhuyenMai(String maSP) {
        for (KMtheoSP_DTO km : listKmtheoSP) {
            if (km.getMaSP().equals(maSP)) {
                return kiemTraNgayChuongTrinh(km.getMaCT());

            }
        }
        return false;
    }

    // KIỂM TRA NGÀY CỦA chương TRÌNH KHUYỄN MÃI (SẢN PHẨM)
    private boolean kiemTraNgayChuongTrinh(String maCT) {
        for (HoaDon_DTO hd : listHoaDon) {
            if (hd.getMaHD().equals(tfMaHDCTHD.getText())) {
                return (kiemTraNgay(hd.getNgayLap(), maCT));
            }
        }
        return false;
    }

    // KIỂM TRA NGÀY (SẢN PHẨM)
    private boolean kiemTraNgay(LocalDateTime ngayLapHoaDon, String maCT) {
        for (CTKM_DTO ctkm : listCTKM) {
            if (maCT.equals(ctkm.getMaCT())) {
                LocalDateTime ngayBD = ctkm.getNgayBD();
                LocalDateTime ngayKT = ctkm.getNgayKT();

                // Kiểm tra nếu ngày lập nằm trong khoảng thời gian của khuyến mãi
                if (ngayLapHoaDon.isBefore(ngayKT) && ngayLapHoaDon.isAfter(ngayBD)) {
                    tfMaCT.setText(maCT);
                    return true;
                }
            }
        }

        return false;
    }

    private boolean kiemTraCTHDDaTonTaiChua(String maHD, String maSP) {
        listCTHD = cthd_BUS.getListCTHD();
        for (ChiTietHoaDon_DTO cthd : listCTHD) {
            if (cthd.getMaSP().equals(maSP) && cthd.getMaHD().equals(maHD)) {
                return false;
            }
        }
        return true;
    }

    private ChiTietHoaDon_DTO kiemTraCTHDDoiTuong(String maHD, String maSP) {
        listCTHD = cthd_BUS.getListCTHD();
        for (ChiTietHoaDon_DTO cthd : listCTHD) {
            if (cthd.getMaSP().equals(maSP) && cthd.getMaHD().equals(maHD)) {
                return cthd;
            }
        }
        return null;
    }

    // Tính tiền giảm
    private float tinhTienGiam(int soLuong, float gia) {
        for (KMtheoSP_DTO kmsp : listKmtheoSP) {
            if (kmsp.getMaCT().equals(tfMaCT.getText())) {
                if (kmsp.getPhanTram_KM() > 1) {
                    float tienGiam = ((kmsp.getPhanTram_KM() * soLuong * gia) / 100);
                    return tienGiam;
                } else {
                    float tienGiam = (kmsp.getPhanTram_KM() * soLuong * gia);
                    return tienGiam;
                }
            }
        }
        return 0;
    }

    // Tính tiền khi có khuyến mãi
    private double tinhThanhTien(int soLuong, float gia) {
        float tienGiam = tinhTienGiam(soLuong, gia);
        String tienGiamStr = FormatTienFloatSangString(tienGiam);
        tfTienGiam.setText(tienGiamStr);
        double thanhTien = (gia * soLuong) - tienGiam;
        String thanhTienStr = FormatTienDoubleSangString(thanhTien);
        tfThanhTien.setText(thanhTienStr);
        return thanhTien;
    }

    // tính tổng tiền
    private double tinhTongTien(String maHD) {
        listCTHD = cthd_BUS.getListCTHD();
        double tongTien = 0;
        for (ChiTietHoaDon_DTO cthd : listCTHD) {
            if (cthd.getMaHD().equals(maHD)) {
                tongTien += cthd.getThanhTien();
            }
        }
        return tongTien;
    }

    // kiểm tra ngày (khuyến mãi tổng tiên)
    private boolean kiemTraNgay(KMtheoTTien_DTO KMtheoTTien, HoaDon_DTO hd) {
        for (CTKM_DTO ctkm : listCTKM) {
            if (KMtheoTTien.getMaCT().equals(ctkm.getMaCT())) {
                // Kiểm tra nếu ngày lập nằm trong khoảng thời gian của khuyến mãi
                if (hd.getNgayLap().isBefore(ctkm.getNgayKT()) && hd.getNgayLap().isAfter(ctkm.getNgayBD())) {
                    return true;
                }
            }
        }

        return false;
    }

    // Kiểm tra để được khuyến mãi(Khuyến mãi tổng tiền)
    private KMtheoTTien_DTO kiemTra(Double tongTien, HoaDon_DTO hd) {
        Double tienNhoNhat = 0.0;
        int dem = 0;
        KMtheoTTien_DTO kmtheoTT = null;
        for (KMtheoTTien_DTO km : listKMTheoTT) {
            if ((tongTien >= km.getTienMin()) && (kiemTraNgay(km, hd))) {
                dem++;
                tienNhoNhat = tongTien * km.getPhanTram_KM();
                kmtheoTT = km;
                break;
            }
        }
        if (dem != 0) {
            for (KMtheoTTien_DTO km : listKMTheoTT) {
                if ((tongTien >= km.getTienMin()) && (kiemTraNgay(km, hd))) {
                    if ((tongTien * km.getPhanTram_KM()) < tienNhoNhat) {
                        kmtheoTT = km;
                    }
                }
            }
        }
        return kmtheoTT;
    }

    // Hàm tính tổng tiền khi có khuyến mãi
    private ArrayList<String> tinhTienKhiCoKhuyenMai(String maKM, double tongTien) {
        float tienGiam = 0;
        ArrayList<String> listTongTien = new ArrayList<>();
        for (KMtheoTTien_DTO km : listKMTheoTT) {
            if (maKM.equals(km.getMaKM())) {
                if (km.getPhanTram_KM() > 1) {
                    tienGiam = (float) ((tongTien * km.getPhanTram_KM()) / 100);
                } else {
                    tienGiam = (float) ((tongTien * km.getPhanTram_KM()));
                }
                tongTien = tongTien - tienGiam;
                listTongTien.add(Float.toString(tienGiam));
                listTongTien.add(Double.toString(tongTien));
            }
        }
        return listTongTien;
    }
    // kiểm tra kí tự đặc biệt

    private boolean containsSpecialCharacter(String str) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");// phủ định lại các kí tự bên trong
        Matcher matcher = pattern.matcher(str);
        return matcher.find();// nếu tìm thấy sẽ trả về true (nghĩa là có kí tự đặc biệt)
    }

    // kiểm tra đầu vào khi thêm
    private boolean kiemTraDauVaoKhiNhap_CTHD() {
        int dem = 0;
        // Kiểm tra sản phẩm
        if (!kiemTraDauVaoSanPham(tfMaSPCTDH.getText())) {
            phuDinhkiemTraDauVaoSanPham();
            dem++;
        }
        // Kiểm tra khuyến mãi
        if (!kiemTraKhuyenMai(tfMaSPCTDH.getText())) {
            tfMaCT.setText("Không có khuyến mãi");
        }

        int soLuong = (int) jSpinnerSoLuong.getValue();
        if (!kiemTraSoLuong(soLuong)) {
            dem++;
        }
        if (dem == 0) {
            return true;
        }
        return false;

    }

    // xử lý thêm chi tiết hóa đơn
    private void xuLyThemCTHD() {
        if (tfMaHDCTHD.getText().isEmpty() || tfMaSPCTDH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (containsSpecialCharacter(tfMaHDCTHD.getText()) || containsSpecialCharacter(tfMaSPCTDH.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng không nhập kí tự đặc biệt và khoảng trắng", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (kiemTraDauVaoHoaDon(tfMaHDCTHD.getText())) {
            if (!kiemTraCTHDDaTonTaiChua(tfMaHDCTHD.getText(), tfMaSPCTDH.getText())) {
                JOptionPane.showMessageDialog(null, "Chi tiết hóa đơn đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hóa đơn không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            tfMaHDCTHD.requestFocus();
            return;
        }
        if ((int) jSpinnerSoLuong.getValue() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn số lượng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int soLuongBD = 0, soLuong = (int) jSpinnerSoLuong.getValue();
        ChiTietHoaDon_DTO cthd = kiemTraCTHDDoiTuong(tfMaHDCTHD.getText(), tfMaSPCTDH.getText());
        if( cthd != null) {
            soLuongBD = cthd.getSoLuong();
        }
        if (!kiemTraSoLuong(soLuong)) {
            for (SanPham_DTO sp : listSanPham) {
                if (sp.getMaSp().equals(tfMaSPCTDH.getText())) {
                    if (sp.getSoluong() < 1) {
                        jSpinnerSoLuong.setValue(0);
                        JOptionPane.showMessageDialog(null, "Sản phẩm này đã hết", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                                return;
                    } else if (soLuong > sp.getSoluong() + soLuongBD) {
                        jSpinnerSoLuong.setValue(sp.getSoluong());
                        JOptionPane.showMessageDialog(null, "Vượt quá số lượng sản phẩm.",
                                "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
            }
        }
        if (kiemTraDauVaoKhiNhap_CTHD()) {
            float gia = Float.parseFloat(tfGia.getText());
            tinhThanhTien(soLuong, gia);
            double thanhTien = Double.parseDouble(tfThanhTien.getText());
            String maCT = "";
            if (tfMaCT.getText().equals("Không có khuyến mãi")) {
                maCT = "NULL";
            } else {
                maCT = tfMaCT.getText();
            }
            float tienGiam = Float.parseFloat(tfTienGiam.getText());
            SanPham_DTO sp = doiTuongSP(tfMaSPCTDH.getText());
            loaiSP_DTO loai = doiTuongLoai(sp.getMaLoai());
            ChiTietHoaDon_DTO chiTietHD = new ChiTietHoaDon_DTO();
            chiTietHD.setMaHD(tfMaHDCTHD.getText());
            chiTietHD.setMaSP(tfMaSPCTDH.getText());
            chiTietHD.setMaCT(maCT);
            chiTietHD.setSoLuong(soLuong);
            chiTietHD.setGia(gia);
            chiTietHD.setTienGiam(tienGiam);
            chiTietHD.setThanhTien(thanhTien);
            if (cthd_BUS.themCTHD(chiTietHD)) {
                sp.setSoluong(sp.getSoluong() - soLuong);
                loai.setSoluong(loai.getSoluong() - soLuong);
                cthd_BUS.suaSoLuongSP(sp);
                cthd_BUS.suaSoLuongLoai(loai);
                xuLyUpdateHoaDon();
                xuLyReset();

            }

        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    // sẽ sửa lại cho tối ưu
    private void xuLySuaCTHD() {
        if (tfMaHDCTHD.getText().isEmpty() || tfMaSPCTDH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (containsSpecialCharacter(tfMaHDCTHD.getText()) || containsSpecialCharacter(tfMaSPCTDH.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng không nhập kí tự đặc biệt và khoảng trắng", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (kiemTraDauVaoHoaDon(tfMaHDCTHD.getText())) {
            if (kiemTraCTHDDaTonTaiChua(tfMaHDCTHD.getText(), tfMaSPCTDH.getText())) {
                if (!kiemTraDauVaoSanPham(tfMaSPCTDH.getText())) {
                    phuDinhkiemTraDauVaoSanPham();
                }
                JOptionPane.showMessageDialog(null, "Chi tiết hóa đơn này không tồn tại", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hóa đơn này không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            tfMaHDCTHD.requestFocus();
            return;
        }
        kiemTraDauVaoSanPham(tfMaSPCTDH.getText());
        int soLuongBD = 0, soLuong = (int) jSpinnerSoLuong.getValue();
        ChiTietHoaDon_DTO cthd = kiemTraCTHDDoiTuong(tfMaHDCTHD.getText(), tfMaSPCTDH.getText());
        if( cthd != null) {
            soLuongBD = cthd.getSoLuong();
        }
        if (!kiemTraSoLuong(soLuong)) {
            for (SanPham_DTO sp : listSanPham) {
                if (sp.getMaSp().equals(tfMaSPCTDH.getText())) {
                    if (sp.getSoluong() < 1 && soLuong != cthd.getSoLuong()) {
                        jSpinnerSoLuong.setValue(0);
                        JOptionPane.showMessageDialog(null, "Sản phẩm này đã hết", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                                return;
                    } else if (soLuong > sp.getSoluong() + soLuongBD && soLuong != cthd.getSoLuong()) {
                        jSpinnerSoLuong.setValue(sp.getSoluong());
                        JOptionPane.showMessageDialog(null, "Vượt quá số lượng sản phẩm.",
                                "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
            }
        }
        float gia = Float.parseFloat(tfGia.getText());
        tinhThanhTien(soLuong, gia);
        float tienGiam = Float.parseFloat(tfTienGiam.getText());
        double thanhTien = Double.parseDouble(tfThanhTien.getText());
        int soLuongUpdate = 0;
        String maCT = "";
        if (tfMaCT.getText().equals("Không có khuyến mãi")) {
            maCT = "NULL";
        } else {
            maCT = tfMaCT.getText();
        }
        ChiTietHoaDon_DTO chiTietHD = new ChiTietHoaDon_DTO();
        chiTietHD.setMaHD(tfMaHDCTHD.getText());
        chiTietHD.setMaSP(tfMaSPCTDH.getText());
        chiTietHD.setMaCT(maCT);
        chiTietHD.setSoLuong(soLuong);
        chiTietHD.setGia(gia);
        chiTietHD.setTienGiam(tienGiam);
        chiTietHD.setThanhTien(thanhTien);
        if (cthd_BUS.suaCTHD(chiTietHD)) {
            SanPham_DTO sp = doiTuongSP(tfMaSPCTDH.getText());
            loaiSP_DTO loai = doiTuongLoai(sp.getMaLoai());
            soLuongUpdate = soLuong - cthd.getSoLuong();
            sp.setSoluong(sp.getSoluong() - soLuongUpdate);
            loai.setSoluong(loai.getSoluong() - soLuongUpdate);
            cthd_BUS.suaSoLuongSP(sp);
            cthd_BUS.suaSoLuongLoai(loai);
            xuLyUpdateHoaDon();
            xuLyReset();
        }

    }

    // xử lý Update hóa đơn
    private void xuLyUpdateHoaDon() {
        HoaDon_DTO hd = kiemTraDauVaoHoaDonDoiTuong(tfMaHDCTHD.getText());
        double tongTien = tinhTongTien(tfMaHDCTHD.getText());
        float tienGiam = 0;
        String maKM = "NULL";
        KMtheoTTien_DTO km = kiemTra(tongTien, hd);
        if (km != null) {
            ArrayList<String> listTien = tinhTienKhiCoKhuyenMai(km.getMaKM(), tongTien);
            maKM = km.getMaKM();
            tienGiam = Float.parseFloat(listTien.get(0));
            tongTien = Double.parseDouble(listTien.get(1));
        }
        hd.setMaKM(maKM);
        hd.setTienGiam(tienGiam);
        hd.setTongTien(tongTien);
        hoaDon_BUS.capNhatHoaDonKhiSuaChiTiet(hd);

    }

    // xử lý xóa chi tiết hóa đơn
    private void xuLyXoaCTHD() {
        if (tfMaHDCTHD.getText().isEmpty() || tfMaSPCTDH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn chi tiết hóa đơn muốn xóa", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (containsSpecialCharacter(tfMaHDCTHD.getText()) || containsSpecialCharacter(tfMaSPCTDH.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng không nhập kí tự đặc biệt và khoảng trắng", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            if (kiemTraCTHDDoiTuong(tfMaHDCTHD.getText(), tfMaSPCTDH.getText()) == null) {
                JOptionPane.showMessageDialog(null, "Chi tiết hóa đơn không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        ChiTietHoaDon_DTO cthd = kiemTraCTHDDoiTuong(tfMaHDCTHD.getText(), tfMaSPCTDH.getText());
        if (cthd != null) {
            if (cthd_BUS.deleteChiTietKhiXoaHoaDon(cthd.getMaHD(), cthd.getMaSP())) {
                SanPham_DTO sp = doiTuongSP(tfMaSPCTDH.getText());
                loaiSP_DTO loai = doiTuongLoai(sp.getMaLoai());
                sp.setSoluong(sp.getSoluong() + cthd.getSoLuong());
                loai.setSoluong(loai.getSoluong() + cthd.getSoLuong());
                cthd_BUS.suaSoLuongSP(sp);
                cthd_BUS.suaSoLuongLoai(loai);
                xuLyUpdateHoaDon();
                JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                xuLyReset();
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // hàm xử lý tìm kiếm CTHD
    // private void tfTuKhoaTimKiemKeyReleased(java.awt.event.KeyEvent evt) {
    //     xuLyTimKiemCTHoaDon();
    // }

    // private void cbbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbbTimKiemActionPerformed
    //     xuLyTimKiemCTHoaDon();

    // }// GEN-LAST:event_cbbTimKiemActionPerformed

    private void xuLyTimKiemCTHoaDon() {
        ArrayList<ChiTietHoaDon_DTO> dscthd = new ArrayList<ChiTietHoaDon_DTO>();
        String thuMucTimKiem = jComboBoxTKCTHD.getSelectedItem().toString();
        String tuKhoaTimKiem = tfTuKhoaTKCTHD.getText();
        if (!tfTuKhoaTKCTHD.getText().isEmpty() && !tfTuKhoaTKCTHD.getText().equals("Tìm kiếm")) {

            switch (thuMucTimKiem) {
                case "Mã hóa đơn": {
                    String sqlTimKiem = "MAHD";
                    dscthd = cthd_BUS.timKiemCTHD(sqlTimKiem, tuKhoaTimKiem);
                    break;
                }
                case "Mã sản phẩm": {
                    String sqlTimKiem = "MASP";
                    dscthd = cthd_BUS.timKiemCTHD(sqlTimKiem, tuKhoaTimKiem);
                    break;
                }
                case "Mã chương trình": {
                    String sqlTimKiem = "MACT";
                    dscthd = cthd_BUS.timKiemCTHD(sqlTimKiem, tuKhoaTimKiem);
                    break;
                }
            }
        }
        loadDataLenTableChiTietHoaDon(dscthd);

    }

    // xử lý hiện gợi ý
    private void tfMaHoaDonKeyReleased() {
        int height = 0;
        DefaultTableModel modelMAHD = (DefaultTableModel) jTableMAHD.getModel();
        modelMAHD.setRowCount(0);
        if (tfMaHDCTHD.getText().isEmpty()) {
            jTableMAHD.setModel(modelMAHD);
            jScrollPaneMAHD.setVisible(false);
            tfMaSPCTDH.setVisible(true);
            tfMaCT.setVisible(true);
            return;
        }
        if (containsSpecialCharacter(tfMaHDCTHD.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng không nhập kí tự đặc biệt và khoảng trắng", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!kiemTraDauVaoSanPham(tfMaSPCTDH.getText())) {
            tfMaCT.setText("Chưa được áp dụng");
            tfGia.setText("0");
            tfTienGiam.setText("0");
            tfThanhTien.setText("0");
        } else if (kiemTraDauVaoSanPham(tfMaSPCTDH.getText()) && !kiemTraKhuyenMai(tfMaSPCTDH.getText())) {
            tfMaCT.setText("Chưa được áp dụng");
            tfTienGiam.setText("0");
            tfThanhTien.setText("0");
        }
        updateTotalAmount();
        for (HoaDon_DTO hd : listHoaDon) {
            if (hd.getMaHD().contains(tfMaHDCTHD.getText())) {
                modelMAHD.addRow(new Object[] { hd.getMaHD() });
                if (height < 70) {
                    height += 25;
                }
            }
        }
        if (modelMAHD.getRowCount() == 0) {
            jScrollPaneMAHD.setVisible(false);
            tfMaSPCTDH.setVisible(true);
            tfMaCT.setVisible(true);
            return;
        } else if (modelMAHD.getRowCount() >= 1 && modelMAHD.getRowCount() < 3) {
            tfMaSPCTDH.setVisible(false);
            tfMaCT.setVisible(true);

        } else if (modelMAHD.getRowCount() >= 3) {
            tfMaSPCTDH.setVisible(false);
            tfMaCT.setVisible(false);

        }
        if (height > 70) {
            height = 70;
        }
        jScrollPaneMAHD.setBounds(140, 78, 130, height);
        jScrollPaneMAHD.setVisible(true);

    }

    private void clickTableMAHD(java.awt.event.MouseEvent evt) {
        int row = jTableMAHD.getSelectedRow();
        if (row > -1) {
            tfMaHDCTHD.setText(jTableMAHD.getValueAt(row, 0).toString());
            jScrollPaneMAHD.setVisible(false);
            tfMaSPCTDH.setVisible(true);
            tfMaCT.setVisible(true);
        }
        if (!kiemTraDauVaoSanPham(tfMaSPCTDH.getText())) {
            tfMaCT.setText("Chưa được áp dụng");
            tfGia.setText("0");
            tfTienGiam.setText("0");
            tfThanhTien.setText("0");
        } else if (kiemTraDauVaoSanPham(tfMaSPCTDH.getText()) && !kiemTraKhuyenMai(tfMaSPCTDH.getText())) {
            tfMaCT.setText("Chưa được áp dụng");
            tfTienGiam.setText("0");
            tfThanhTien.setText("0");
        }
        updateTotalAmount();

    }

    private void tfMaSanPhamKeyReleased() {
        int height = 0;
        DefaultTableModel modelMASP = (DefaultTableModel) jTableMASP.getModel();
        modelMASP.setRowCount(0);
        if (tfMaSPCTDH.getText().isEmpty()) {
            jTableMASP.setModel(modelMASP);
            jScrollPaneMASP.setVisible(false);
            tfMaCT.setVisible(true);
            tfMaCT.setText("Chưa được áp dụng");
            tfGia.setText("0");
            tfTienGiam.setText("0");
            tfThanhTien.setText("0");
            return;
        }
        if (containsSpecialCharacter(tfMaSPCTDH.getText()) && !tfMaSPCTDH.getText().equals("SP không tồn tại")) {
            JOptionPane.showMessageDialog(null, "Vui lòng không nhập kí tự đặc biệt và khoảng trắng", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!kiemTraDauVaoSanPham(tfMaSPCTDH.getText())) {
            tfMaCT.setText("Chưa được áp dụng");
            tfGia.setText("0");
            tfTienGiam.setText("0");
            tfThanhTien.setText("0");
        } else if (kiemTraDauVaoSanPham(tfMaSPCTDH.getText()) && !kiemTraKhuyenMai(tfMaSPCTDH.getText())) {
            tfMaCT.setText("Chưa được áp dụng");
            tfTienGiam.setText("0");
            tfThanhTien.setText("0");
        }
        jSpinnerSoLuong.setValue(0);
        for (SanPham_DTO sp : listSanPham) {
            if (sp.getMaSp().contains(tfMaSPCTDH.getText())) {
                modelMASP.addRow(new Object[] { sp.getMaSp() });
                if (height < 70) {
                    height += 25;
                }
            }
        }
        if (modelMASP.getRowCount() == 0) {
            jScrollPaneMASP.setVisible(false);
            tfMaCT.setVisible(true);
            return;
        } else if (modelMASP.getRowCount() >= 1) {
            tfMaCT.setVisible(false);

        }
        if (height > 70) {
            height = 70;
        }
        jScrollPaneMASP.setBounds(140, 110, 130, height);
        jScrollPaneMASP.setVisible(true);

    }

    private void clickTableMASP(java.awt.event.MouseEvent evt) {
        int row = jTableMASP.getSelectedRow();
        if (row > -1) {
            tfMaSPCTDH.setText(jTableMAHD.getValueAt(row, 0).toString());
            jScrollPaneMASP.setVisible(false);
            tfMaCT.setVisible(true);
        }
        if (!kiemTraDauVaoSanPham(tfMaSPCTDH.getText())) {
            tfMaCT.setText("Chưa được áp dụng");
            tfGia.setText("0");
            tfTienGiam.setText("0");
            tfThanhTien.setText("0");
        } else if (kiemTraDauVaoSanPham(tfMaSPCTDH.getText()) && !kiemTraKhuyenMai(tfMaSPCTDH.getText())) {
            tfMaCT.setText("Chưa được áp dụng");
            tfTienGiam.setText("0");
            tfThanhTien.setText("0");
        }
        jSpinnerSoLuong.setValue(0);

    }
    // // Hàm reset

    private void xuLyReset() {
        tfMaHDCTHD.setText("");
        tfMaSPCTDH.setText("");
        tfMaCT.setText("Chưa được áp dụng");
        jSpinnerSoLuong.setValue(0);
        tfGia.setText("0");
        tfTienGiam.setText("0");
        tfThanhTien.setText("0");
        tfTuKhoaTKCTHD.setText("Tìm kiếm");
        loadDataLenTableChiTietHoaDon();
    }

    private void xuLyResetTableGoiY() {
        DefaultTableModel modelMAHD = (DefaultTableModel) jTableMAHD.getModel();
        modelMAHD.setRowCount(0);
        jTableMAHD.setModel(modelMAHD);
        DefaultTableModel modelMASP = (DefaultTableModel) jTableMASP.getModel();
        modelMASP.setRowCount(0);
        jTableMASP.setModel(modelMASP);
        jScrollPaneMAHD.setVisible(false);
        jScrollPaneMASP.setVisible(false);
        tfMaSPCTDH.setVisible(true);
        tfMaCT.setVisible(true);

    }

    private void tbDSCTHDMouseClicked() {
        int i = jTableCTHD.getSelectedRow();
        listCTHD = cthd_BUS.getListCTHD();
        if (i > -1 && i < listCTHD.size()) {

            tfMaHDCTHD.setText(jTableCTHD.getModel().getValueAt(i, 0).toString());
            tfMaSPCTDH.setText(jTableCTHD.getModel().getValueAt(i, 1).toString());
            tfMaCT.setText(jTableCTHD.getModel().getValueAt(i, 2).toString());
            int soLuong = Integer.parseInt(jTableCTHD.getModel().getValueAt(i, 3).toString());
            jSpinnerSoLuong.setValue(soLuong);
            tfGia.setText(jTableCTHD.getModel().getValueAt(i, 4).toString());
            tfTienGiam.setText(jTableCTHD.getModel().getValueAt(i, 5).toString());
            tfThanhTien.setText(jTableCTHD.getModel().getValueAt(i, 6).toString());
        }
    }

    public void suKienEnter() {
        tfMaHDCTHD.requestFocus();
        tfMaHDCTHD.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (jTableMAHD.getRowCount() > 0) {
                        tfMaHDCTHD.setText(jTableMAHD.getValueAt(0, 0).toString());
                    }
                    xuLyResetTableGoiY();
                    tfMaSPCTDH.requestFocus();
                }
            }
        });
        tfMaSPCTDH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    
                    if (jTableMASP.getRowCount() > 0) {
                        tfMaSPCTDH.setText(jTableMASP.getValueAt(0, 0).toString());
                    }
                    kiemTraDauVaoSanPham(tfMaSPCTDH.getText());
                    xuLyResetTableGoiY();
                    jSpinnerSoLuong.requestFocus();
                }
            }
        });

    }

    private void updateTotalAmount() {
        float gia = Float.parseFloat(tfGia.getText());
        double thanhTien = 0;
        int  soLuong = (int) jSpinnerSoLuong.getValue();
        if (kiemTraSoLuong(soLuong)) {
            if (tfMaCT.getText().equals("Không có khuyến mãi")) {
                thanhTien = soLuong * Float.parseFloat(tfGia.getText());
            } else {
                gia = Float.parseFloat(tfGia.getText());
                thanhTien = tinhThanhTien(soLuong, gia);
            }
            float tienGiam = Float.parseFloat(tfTienGiam.getText());
            String tienGiamStr = FormatTienFloatSangString(tienGiam);
            String thanhTienStr = FormatTienDoubleSangString(thanhTien);
            tfTienGiam.setText(tienGiamStr);
            tfThanhTien.setText(thanhTienStr);
        } 
    }

    public static void main(String[] args) {
        new GUI_CTHoaDon();
    }
}
