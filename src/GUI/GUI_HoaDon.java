package GUI;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;
import BUS.HoaDon_BUS;
import DTO.HoaDon_DTO;
import DTO.KhachHang_DTO;
import DTO.loaiSP_DTO;
import DTO.NhanVien_DTO;
import DTO.SanPham_DTO;
import DTO.KMtheoTTien_DTO;
import BUS.KhachHang_BUS;
import BUS.LoaiSP_BUS;
import BUS.NhanVien_BUS;
import BUS.SanPham_BUS;
import DAO.KMTheoTT_DAO;
import BUS.KMTheoTT_BUS;
import BUS.CTKM_BUS;
import DTO.CTKM_DTO;
import DAO.CTHoaDon_DAO;
import DTO.ChiTietHoaDon_DTO;
import BUS.CTHoaDon_BUS;
import DTO.KMtheoSP_DTO;
import BUS.KMTheoSP_BUS;
import com.toedter.calendar.JCalendar;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GUI_HoaDon extends javax.swing.JFrame {
    private ThongTinDN dn=new ThongTinDN();
    DefaultTableModel model = new DefaultTableModel();
    private HoaDon_BUS hoaDon_BUS = new HoaDon_BUS();
    private KhachHang_BUS khachHang_BUS = new KhachHang_BUS();
    private NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();
    private KMTheoTT_BUS kmTheoTT_BUS = new KMTheoTT_BUS();
    private CTKM_BUS ctkm_BUS = new CTKM_BUS();
    private CTHoaDon_BUS cthd_BUS = new CTHoaDon_BUS();
    private KMTheoSP_BUS kmTheoSP_BUS = new KMTheoSP_BUS();
    private SanPham_BUS sanPham_BUS = new SanPham_BUS();
    private LoaiSP_BUS loaiSP_BUS = new LoaiSP_BUS();
    private ArrayList<HoaDon_DTO> listHoaDon = hoaDon_BUS.getListHD();
    private ArrayList<KhachHang_DTO> listKhachHang = khachHang_BUS.getListKH();
    private ArrayList<NhanVien_DTO> listNhanVien = nhanVien_BUS.getList();
    private ArrayList<KMtheoTTien_DTO> listKMTheoTT = kmTheoTT_BUS.getList();
    private ArrayList<CTKM_DTO> listCTKM = ctkm_BUS.getList();
    private ArrayList<ChiTietHoaDon_DTO> listCTHD = cthd_BUS.getListCTHD();
    private ArrayList<KMtheoSP_DTO> listKMTheoSP = kmTheoSP_BUS.getList();
    private ArrayList<SanPham_DTO> listSanPham = sanPham_BUS.getList();
    private ArrayList<loaiSP_DTO> listLoaiSP = loaiSP_BUS.getListLoai();
    private static boolean closedByOk = false;

    // Hàm khởi tạo
    public GUI_HoaDon() {
        // Hàm gọi form
        addControls();
        // Hàm gọi sự kiện
        addEvents();
    }

    // Thuộc tính của Trang Chủ
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
    // Thuộc Tính của Hóa Đơn
    // private javax.swing.JComboBox<String> JComboBoxMAHD1;
    // private javax.swing.JComboBox<String> JComboBoxMAKH;
    // private javax.swing.JComboBox<String> JComboBoxMANV;
    private javax.swing.JButton btnLichBD;
    private javax.swing.JButton btnLichKT;
    private javax.swing.JButton btnLichNgayLap;
    private javax.swing.JButton btnPrintHD;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXemCTHD;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> jComboBoxTimKiem;
    private javax.swing.JScrollPane jScrollPaneHoaDon;
    private javax.swing.JTable jTableHoaDon;
    private javax.swing.JScrollPane jScrollPaneMAHD;
    private javax.swing.JTable jTableMAHD;
    private javax.swing.JScrollPane jScrollPaneMAKH;
    private javax.swing.JTable jTableMAKH;
    private javax.swing.JScrollPane jScrollPaneMANV;
    private javax.swing.JTable jTableMANV;

    private javax.swing.JLabel lbDen;
    private javax.swing.JLabel lbInHoaDon;
    // private javax.swing.JLabel lbLocTheoNgay;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbMaHD;
    private javax.swing.JLabel lbMaKH;
    private javax.swing.JLabel lbMaKM;
    private javax.swing.JLabel lbMaNV;
    private javax.swing.JLabel lbNgayLapHoaDon;
    private javax.swing.JLabel lbTienGiam;
    private javax.swing.JLabel lbTieuDe;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JLabel lbTu;
    private javax.swing.JTextField tfMaHD;
    private javax.swing.JTextField tfMaKH;
    private javax.swing.JTextField tfMaKM;
    private javax.swing.JTextField tfMaNV;
    private javax.swing.JTextField tfNgayBD;
    private javax.swing.JTextField tfNgayKT;
    private javax.swing.JTextField tfNgayLap;
    private javax.swing.JTextField tfTienGiam;
    private javax.swing.JTextField tfTongTien;
    private javax.swing.JTextField tfTuKhoaTimKiem;
    private javax.swing.JEditorPane txtHoaDon;

    // Hàm thực hiện form
    private void addControls() {
        setTitle("Quản lí hóa đơn");
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
        paChiTiet.setBounds(145, 28, 750, 535); // Đặt vị trí và kích thước cho panel chi tiết
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
        // Form Hóa Đơn
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        lbMaHD = new javax.swing.JLabel();
        lbMaKH = new javax.swing.JLabel();
        lbMaNV = new javax.swing.JLabel();
        lbNgayLapHoaDon = new javax.swing.JLabel();
        lbTienGiam = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        lbMaKM = new javax.swing.JLabel();
        tfTongTien = new javax.swing.JTextField();
        jComboBoxTimKiem = new javax.swing.JComboBox<>();
        tfTuKhoaTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        lbTieuDe = new javax.swing.JLabel();
        jScrollPaneHoaDon = new javax.swing.JScrollPane();
        jTableHoaDon = new javax.swing.JTable();
        jScrollPaneMAHD = new javax.swing.JScrollPane();
        jTableMAHD = new javax.swing.JTable();
        jScrollPaneMAKH = new javax.swing.JScrollPane();
        jTableMAKH = new javax.swing.JTable();
        jScrollPaneMANV = new javax.swing.JScrollPane();
        jTableMANV = new javax.swing.JTable();
        btnPrintHD = new javax.swing.JButton();
        btnXemCTHD = new javax.swing.JButton();
        lbInHoaDon = new javax.swing.JLabel();
        lbLogo = new javax.swing.JLabel();
        tfMaHD = new javax.swing.JTextField();
        tfMaKH = new javax.swing.JTextField();
        tfMaNV = new javax.swing.JTextField();
        tfMaKM = new javax.swing.JTextField();
        tfNgayLap = new javax.swing.JTextField();
        tfTienGiam = new javax.swing.JTextField();
        // JComboBoxMANV = new javax.swing.JComboBox<>();
        // JComboBoxMAHD1 = new javax.swing.JComboBox<>();
        // JComboBoxMAKH = new javax.swing.JComboBox<>();
        btnLichNgayLap = new javax.swing.JButton();
        // lbLocTheoNgay = new javax.swing.JLabel();
        lbTu = new javax.swing.JLabel();
        tfNgayKT = new javax.swing.JTextField();
        tfNgayBD = new javax.swing.JTextField();
        lbDen = new javax.swing.JLabel();
        btnLichBD = new javax.swing.JButton();
        btnLichKT = new javax.swing.JButton();
        txtHoaDon = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paChiTiet.setBackground(new java.awt.Color(153, 153, 153));

        ImageIcon imageThem = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\icons8-add-27.png");
        ImageIcon imageThem_resized = new ImageIcon(
                imageThem.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        btnThem.setIcon(imageThem_resized); // NOI18N
        btnThem.setMaximumSize(new java.awt.Dimension(72, 72));
        btnThem.setPreferredSize(new java.awt.Dimension(27, 27));
        // btnThem.addActionListener(new java.awt.event.ActionListener() {
        // public void actionPerformed(java.awt.event.ActionEvent evt) {
        // btnThemActionPerformed(evt);
        // }
        // });

        ImageIcon imageSua = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\update.png");
        ImageIcon imageSua_resized = new ImageIcon(
                imageSua.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        btnSua.setIcon(imageSua_resized); // NOI18N
        btnSua.setPreferredSize(new java.awt.Dimension(27, 27));

        ImageIcon imageReset = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\clear.png");
        ImageIcon imageReset_resized = new ImageIcon(
                imageReset.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        btnReset.setIcon(imageReset_resized); // NOI18N
        btnReset.setPreferredSize(new java.awt.Dimension(27, 27));

        ImageIcon imageXoa = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\Button-Delete-icon.png");
        ImageIcon imageXoa_resized = new ImageIcon(
                imageXoa.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        btnXoa.setIcon(imageXoa_resized); // NOI18N
        btnXoa.setPreferredSize(new java.awt.Dimension(27, 27));
        // btnXoa.addActionListener(new java.awt.event.ActionListener() {
        // public void actionPerformed(java.awt.event.ActionEvent evt) {
        // btnXoaActionPerformed(evt);
        // }
        // });

        lbMaHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMaHD.setForeground(new java.awt.Color(51, 51, 51));
        lbMaHD.setText("Mã hóa đơn");

        lbMaKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMaKH.setForeground(new java.awt.Color(51, 51, 51));
        lbMaKH.setText("Mã khách hàng");

        lbMaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMaNV.setForeground(new java.awt.Color(51, 51, 51));
        lbMaNV.setText("Mã nhân viên");

        lbNgayLapHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNgayLapHoaDon.setForeground(new java.awt.Color(51, 51, 51));
        lbNgayLapHoaDon.setText("Ngày lập");

        lbTienGiam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTienGiam.setForeground(new java.awt.Color(51, 51, 51));
        lbTienGiam.setText("Tiền giảm");

        lbTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTongTien.setForeground(new java.awt.Color(51, 51, 51));
        lbTongTien.setText("Tổng tiền");

        lbMaKM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMaKM.setForeground(new java.awt.Color(51, 51, 51));
        lbMaKM.setText("Mã khuyến mãi");

        tfTongTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfTongTien.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfTongTien.setPreferredSize(new java.awt.Dimension(80, 25));

        jComboBoxTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBoxTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Mã khuyến mãi" }));
        // jComboBoxTimKiem.addActionListener(new java.awt.event.ActionListener() {
        // public void actionPerformed(java.awt.event.ActionEvent evt) {
        // jComboBoxTimKiemActionPerformed(evt);
        // }
        // });

        tfTuKhoaTimKiem.setText("Tìm kiếm");

        ImageIcon imageTimKiem = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\icons8-search-27.png");
        ImageIcon imageTimKiem_resized = new ImageIcon(
                imageTimKiem.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        btnTimKiem.setIcon(imageTimKiem_resized); // NOI18N
        btnTimKiem.setPreferredSize(new java.awt.Dimension(27, 27));

        lbTieuDe.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbTieuDe.setText("Quản lý hóa đơn");

        jTableHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        jTableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
                        "Mã HD", "Mã KH", "Mã NV", "Mã KH", "Ngày", "Tiền giảm", "Tổng Tiền"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.Float.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPaneHoaDon.setViewportView(jTableHoaDon);

        ImageIcon imagePrintHD = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\icons8-print-27.png");
        ImageIcon imagePrintHD_resized = new ImageIcon(
                imagePrintHD.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        btnPrintHD.setIcon(imagePrintHD_resized); // NOI18N
        btnPrintHD.setMaximumSize(new java.awt.Dimension(72, 72));
        btnPrintHD.setPreferredSize(new java.awt.Dimension(27, 27));

        ImageIcon imageXemCTHD = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\xem.png");
        ImageIcon imageXemCTHD_resized = new ImageIcon(
                imageXemCTHD.getImage().getScaledInstance(42, 42, java.awt.Image.SCALE_SMOOTH));
        btnXemCTHD.setIcon(imageXemCTHD_resized); // NOI18N
        btnXemCTHD.setPreferredSize(new java.awt.Dimension(45, 45));

        lbInHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbInHoaDon.setText("In hóa đơn");

        ImageIcon imageLogoHD = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\boss luxyry logo.png");
        lbLogo.setIcon(imageLogoHD); // NOI18N
        // lbLogo.setText("jLabe");

        tfMaHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfMaHD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfMaHD.setPreferredSize(new java.awt.Dimension(80, 25));

        tfMaKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfMaKH.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfMaKH.setPreferredSize(new java.awt.Dimension(80, 25));

        tfMaNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfMaNV.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfMaNV.setPreferredSize(new java.awt.Dimension(80, 25));

        tfMaKM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfMaKM.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfMaKM.setPreferredSize(new java.awt.Dimension(80, 25));

        tfNgayLap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfNgayLap.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfNgayLap.setPreferredSize(new java.awt.Dimension(80, 25));

        tfTienGiam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfTienGiam.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfTienGiam.setPreferredSize(new java.awt.Dimension(80, 25));

        // JComboBoxMANV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
        // "..." }));
        // JComboBoxMANV.setPreferredSize(new java.awt.Dimension(60, 23));

        // JComboBoxMAHD1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
        // "..." }));
        // JComboBoxMAHD1.setPreferredSize(new java.awt.Dimension(60, 23));

        // JComboBoxMAKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
        // "..." }));
        // JComboBoxMAKH.setPreferredSize(new java.awt.Dimension(60, 23));

        ImageIcon imageLichNL = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\lich.jpg");
        ImageIcon imageLichNL_resized = new ImageIcon(
                imageLichNL.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        btnLichNgayLap.setIcon(imageLichNL_resized); // NOI18N
        btnLichNgayLap.setMaximumSize(new java.awt.Dimension(72, 72));
        btnLichNgayLap.setPreferredSize(new java.awt.Dimension(27, 27));
        lbTu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTu.setText("Từ");

        lbDen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDen.setText("Đến ");

        ImageIcon imageLichBD = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\lich.jpg");
        ImageIcon imageLichBD_resized = new ImageIcon(
                imageLichBD.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        btnLichBD.setIcon(imageLichBD_resized); // NOI18N
        btnLichBD.setMaximumSize(new java.awt.Dimension(72, 72));
        btnLichBD.setPreferredSize(new java.awt.Dimension(27, 27));
        // btnLichBD.addActionListener(new java.awt.event.ActionListener() {
        // public void actionPerformed(java.awt.event.ActionEvent evt) {
        // btnLichBDActionPerformed(evt);
        // }
        // });

        ImageIcon imageLichKT = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\lich.jpg");
        ImageIcon imageLichKT_resized = new ImageIcon(
                imageLichKT.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        btnLichKT.setIcon(imageLichKT_resized); // NOI18N
        btnLichKT.setMaximumSize(new java.awt.Dimension(72, 72));
        btnLichKT.setPreferredSize(new java.awt.Dimension(27, 27));
        // btnLichKT.addActionListener(new java.awt.event.ActionListener() {
        // public void actionPerformed(java.awt.event.ActionEvent evt) {
        // btnLichKTActionPerformed(evt);
        // }
        // });

        javax.swing.GroupLayout paMainQLHDLayout = new javax.swing.GroupLayout(paChiTiet);
        paChiTiet.setLayout(paMainQLHDLayout);
        paMainQLHDLayout.setHorizontalGroup(
                paMainQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPaneHoaDon)
                                .addContainerGap())
                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                .addGroup(paMainQLHDLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnXemCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                                .addGroup(paMainQLHDLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                paMainQLHDLayout.createSequentialGroup()
                                                                        .addContainerGap(
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(paMainQLHDLayout
                                                                                        .createSequentialGroup()
                                                                                        .addComponent(jComboBoxTimKiem,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                117,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                        .addComponent(tfTuKhoaTimKiem,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                158,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(btnTimKiem,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                36,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(18, 18, 18))
                                                                                .addGroup(paMainQLHDLayout
                                                                                        .createSequentialGroup()
                                                                                        .addComponent(lbLogo,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                103,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(39, 39, 39)
                                                                                        .addGroup(paMainQLHDLayout
                                                                                                .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                        paMainQLHDLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(
                                                                                                                        paMainQLHDLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(
                                                                                                                                        btnThem,
                                                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                        36,
                                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(
                                                                                                                                        btnXoa,
                                                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                        36,
                                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGap(55,
                                                                                                                        55,
                                                                                                                        55)
                                                                                                                .addGroup(
                                                                                                                        paMainQLHDLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(
                                                                                                                                        btnSua,
                                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                        36,
                                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(
                                                                                                                                        btnReset,
                                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                        36,
                                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGap(56,
                                                                                                                        56,
                                                                                                                        56))
                                                                                                .addGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                        paMainQLHDLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(
                                                                                                                        lbTieuDe)
                                                                                                                .addGap(18,
                                                                                                                        18,
                                                                                                                        18))))))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                paMainQLHDLayout.createSequentialGroup()
                                                                        .addGap(13, 13, 13)
                                                                        .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(paMainQLHDLayout
                                                                                        .createSequentialGroup()
                                                                                        .addComponent(lbTu,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                23,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(tfNgayBD,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                103,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(btnLichBD,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        36,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(paMainQLHDLayout
                                                                                        .createSequentialGroup()
                                                                                        .addComponent(lbDen)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(tfNgayKT,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                113,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(btnLichKT,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        36,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)))
                                                .addGroup(paMainQLHDLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                                                .addComponent(lbMaHD)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        36, Short.MAX_VALUE)
                                                                .addComponent(tfMaHD,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbMaKH)
                                                                        .addComponent(lbMaNV))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(tfMaKH,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                120, Short.MAX_VALUE)
                                                                        .addComponent(tfMaNV,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)))
                                                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbMaKM)
                                                                        .addComponent(lbTongTien)
                                                                        .addComponent(lbTienGiam,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                77,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbNgayLapHoaDon))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(tfTienGiam,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                120, Short.MAX_VALUE)
                                                                        .addComponent(tfNgayLap,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(tfMaKM,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(tfTongTien,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(paMainQLHDLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                                                .addComponent(lbInHoaDon)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnPrintHD,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(btnLichNgayLap,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(18, Short.MAX_VALUE)));
        paMainQLHDLayout.setVerticalGroup(
                paMainQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                .addGroup(paMainQLHDLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                                .addGroup(paMainQLHDLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(lbMaHD,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                29,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tfMaHD,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                26,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbTieuDe))
                                                                .addGap(4, 4, 4)
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnThem,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnSua,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnXoa,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnReset,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(51, 51, 51))
                                                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(lbLogo,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 106,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        26, Short.MAX_VALUE)
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnTimKiem,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jComboBoxTimKiem,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        27,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(tfTuKhoaTimKiem,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        27,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(paMainQLHDLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(tfNgayBD,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                27,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbTu,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                20,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbDen,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                20,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(tfNgayKT,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                27,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnLichBD,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(btnLichKT,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                                .addGroup(paMainQLHDLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                paMainQLHDLayout.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addComponent(btnXemCTHD,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(btnPrintHD,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                39,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(paMainQLHDLayout.createSequentialGroup()
                                                                .addGap(43, 43, 43)
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(tfMaKH,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                26,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbMaKH,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(tfMaNV,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                26,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbMaNV,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(tfMaKM,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                26,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbMaKM,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(7, 7, 7)
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(tfNgayLap,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        26,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lbNgayLapHoaDon,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        25,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(btnLichNgayLap,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(tfTienGiam,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                26,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbTienGiam,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(paMainQLHDLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(tfTongTien,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbTongTien,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbInHoaDon,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 6, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPaneHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 272,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(8, Short.MAX_VALUE)));

        tfTuKhoaTimKiem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tfTuKhoaTimKiem.getText().equals("Tìm kiếm")) {
                    tfTuKhoaTimKiem.setText("");
                }
            }
        });
        jScrollPaneMAHD.setBounds(478, 35, 121, 0);
        jScrollPaneMAKH.setBounds(478, 68, 121, 0);
        jScrollPaneMANV.setBounds(478, 100, 121, 0);
        DefaultTableModel modelTB = new DefaultTableModel(new Object[] { "" }, 0);
        jTableMAHD.setModel(modelTB);
        jTableMAKH.setModel(modelTB);
        jTableMANV.setModel(modelTB);
        jScrollPaneMAHD.setViewportView(jTableMAHD);
        jScrollPaneMAKH.setViewportView(jTableMAKH);
        jScrollPaneMANV.setViewportView(jTableMANV);
        paChiTiet.add(jScrollPaneMAHD);
        paChiTiet.add(jScrollPaneMAKH);
        paChiTiet.add(jScrollPaneMANV);
        jScrollPaneMAHD.setVisible(false);
        jScrollPaneMAKH.setVisible(false);
        jScrollPaneMANV.setVisible(false);
        LocalDate currentDate = LocalDate.now();
        tfNgayLap.setText(currentDate.toString());
        tfMaKM.setText("Chưa được áp dụng");
        tfTienGiam.setText("0");
        tfTongTien.setText("0");
        tfMaHD.setEnabled(false);
        tfMaKM.setEnabled(false);
        tfTienGiam.setEnabled(false);
        tfTongTien.setEnabled(false);

        // Thêm các panel vào JFrame
        add(paTieuDe);
        add(paMenu);
        add(paChiTiet);
        suKienEnter();
        chuyenForm();
        // loadDataLenTableHoaDon();
        xuLyReset();
        // setTFMaHoaDon();
        setVisible(true);

    }

    // Hàm
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
        btnXemCTHD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listHoaDon = hoaDon_BUS.getListHD();
                boolean flag = true;
                if (tfMaHD.getText().isEmpty()) {
                    flag = false;
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn", "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);
                } else if (!kiemTraDauVaoHoaDonKhiXemChiTiet(tfMaHD.getText())) {
                    flag = false;
                    JOptionPane.showMessageDialog(null, "Không có hóa đơn này", "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);
                } else if (kiemTraDauVaoHoaDonKhiXemChiTiet(tfMaHD.getText())) {
                    for (HoaDon_DTO hd : listHoaDon) {
                        if (hd.getMaHD().equals(tfMaHD.getText())) {
                            LocalDateTime ngayLap = hd.getNgayLap();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            String ngayLapStr = ngayLap.format(formatter);
                            if (!hd.getMaKH().equals(tfMaKH.getText()) && kiemTraDauVaoKhachHang(tfMaKH.getText()) ||
                                    !hd.getMaNV().equals(tfMaNV.getText()) && kiemTraDauVaoNhanVien(tfMaNV.getText()) ||
                                    !ngayLapStr.equals(tfNgayLap.getText())
                                            && kiemTraDinhDangNgay(tfNgayLap.getText())) {
                                flag = false;
                                JOptionPane.showMessageDialog(null, "Bạn vừa thay đổi hóa đơn vui lòng lưu lại",
                                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                tfMaKH.setText(hd.getMaKH());
                                tfMaNV.setText(hd.getMaNV());
                                tfMaKM.setText(hd.getMaKM());
                                tfNgayLap.setText(ngayLapStr);
                                String tienGiam = FormatTienFloatSangString(hd.getTienGiam());
                                tfTienGiam.setText(tienGiam);
                                String tongTien = FormatTienDoubleSangString(hd.getTongTien());
                                tfTongTien.setText(tongTien);
                                flag = true;

                            }
                        }
                    }
                }
                if (flag) {
                    GUI_CTHoaDon ctHoaDon = new GUI_CTHoaDon();
                    ctHoaDon.getTextField(tfMaHD.getText(), tfMaKH.getText(), tfMaNV.getText(), tfMaKM.getText(),
                            tfNgayLap.getText(), tfTienGiam.getText(), tfTongTien.getText());
                    dispose();
                    ctHoaDon.setVisible(true);
                }
            }

        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThemHoaDon();
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLySuaHoaDon();
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyXoaHoaDon();
            }
        });
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfNgayBD.getText().length() < 10 && tfNgayKT.getText().length() < 10) {
                    xuLyTimKiemHoaDon();
                    if(jTableHoaDon.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn",
                                "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else {
                    locHoaDonTheoNgay();
                    if(jTableHoaDon.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn",
                                "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyReset();
            }
        });
        jTableHoaDon.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xuLyResetTableGoiY();
                tbDSHDMouseClicked();
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
        btnPrintHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuLyHienThiHoaDon();
                btnInHoaDonActionPerformed(evt);
            }
        });
        btnLichNgayLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichNgayLapActionPerformed(evt);
            }
        });
        btnLichBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichBatDauActionPerformed();
            }
        });
        tfNgayBD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnLichBatDauActionPerformed();
            }
        });
        btnLichKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichKetThucActionPerformed();
            }
        });
        tfNgayKT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnLichKetThucActionPerformed();
            }
        });
        // tfTuKhoaTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
        //     public void keyReleased(java.awt.event.KeyEvent evt) {
        //         tfTuKhoaTimKiemKeyReleased(evt);
        //     }
        // });
        tfTuKhoaTimKiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(tfNgayBD.getText().length() < 10 && tfNgayKT.getText().length() < 10) {
                        xuLyTimKiemHoaDon();
                        if(jTableHoaDon.getRowCount() == 0) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn",
                                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else {
                        locHoaDonTheoNgay();
                        if(jTableHoaDon.getRowCount() == 0) {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn",
                                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        });
        tfMaHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfMaHoaDonKeyReleased();
            }
        });
        tfMaHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tfMaHoaDonKeyReleased();
            }
        });
        tfMaKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfMaKhachHangKeyReleased();
            }
        });
        tfMaKH.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tfMaKhachHangKeyReleased();
            }
        });
        tfMaNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {

                tfMaNhanVienKeyReleased();
            }
        });
        tfMaNV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tfMaNhanVienKeyReleased();
            }
        });

        // jComboBoxTimKiem.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         cbbTimKiemActionPerformed(evt);
        //     }

        // });
        
        jTableMAHD.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickTableMAHD(evt);
            }
        });
        jTableMAKH.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickTableMAKH(evt);
            }
        });
        jTableMANV.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickTableMANV(evt);
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
    }
    private void setTFMaHoaDon() {
        listHoaDon = hoaDon_BUS.getListHD();
        int soHoaDonMax = Integer.parseInt(listHoaDon.get(0).getMaHD().substring(2));
        for( HoaDon_DTO hd : listHoaDon) {
            if(soHoaDonMax < Integer.parseInt(hd.getMaHD().substring(2))) {
                soHoaDonMax = Integer.parseInt(hd.getMaHD().substring(2));
            }
        }
        String soHoaDonMaxStr = String.valueOf(soHoaDonMax + 1);
        if(soHoaDonMax + 1 >=0 && soHoaDonMax + 1 <=9) {
            tfMaHD.setText("HD0" + soHoaDonMaxStr);
        }
        else if(soHoaDonMax + 1 >=10) {
            tfMaHD.setText("HD" + soHoaDonMaxStr);
        }
    }
    private void loadDataLenTableHoaDon() {
        listHoaDon = hoaDon_BUS.getListHD();
        loadDataLenTableHoaDon(listHoaDon);

    }

    private String FormatTienFloatSangString(float valueFloat) {
        return String.format("%.0f", valueFloat);
    }

    private String FormatTienDoubleSangString(double valueDouble) {
        return String.format("%.0f", valueDouble);
    }

    private void loadDataLenTableHoaDon(ArrayList<HoaDon_DTO> listHoaDon) {
        model.setRowCount(0);
        Vector tieuDe = new Vector();
        tieuDe.add("Mã HD");
        tieuDe.add("Mã KH");
        tieuDe.add("Mã NV");
        tieuDe.add("Mã KM");
        tieuDe.add("Ngày lập");
        tieuDe.add("Tiền giảm");
        tieuDe.add("Tổng tiền");
        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(tieuDe, 0);
        }
        for (HoaDon_DTO hd : listHoaDon) {
            Vector row = new Vector();
            row.add(hd.getMaHD());
            row.add(hd.getMaKH());
            row.add(hd.getMaNV());
            row.add(hd.getMaKM());
            row.add(hd.getNgayLap());
            String tienGiamHDStr = FormatTienFloatSangString(hd.getTienGiam());
            row.add(tienGiamHDStr);
            String tongTienHDStr = FormatTienDoubleSangString(hd.getTongTien());
            row.add(tongTienHDStr);
            model.addRow(row);
            jTableHoaDon.setModel(model);
        }
    }

    // loadTextfield
    public void loadTextfield(ArrayList<String> listTextField) {
        tfMaHD.setText(listTextField.get(0));
        tfMaKH.setText(listTextField.get(1));
        tfMaNV.setText(listTextField.get(2));
        tfMaKM.setText(listTextField.get(3));
        tfNgayLap.setText(listTextField.get(4));
        float tienGiam = Float.parseFloat(listTextField.get(5));
        Double tongTien = Double.parseDouble(listTextField.get(6));
        String tienGiamStr = FormatTienFloatSangString(tienGiam);
        String tongTienStr = FormatTienDoubleSangString(tongTien);
        tfTienGiam.setText(tienGiamStr);
        tfTongTien.setText(tongTienStr);
    }

    // Hàm reset
    private void xuLyReset() {
        if(tfMaHD.getText().isEmpty() || kiemTraDauVaoHoaDon(tfMaHD.getText())) {
            setTFMaHoaDon();
        }
        tfMaKH.setText("");
        tfMaNV.setText("");
        tfMaKM.setText("Chưa được áp dụng");
        LocalDate currentDate = LocalDate.now();
        tfNgayLap.setText(currentDate.toString());
        tfTienGiam.setText("0");
        tfTongTien.setText("0");
        tfTuKhoaTimKiem.setText("Tìm kiếm");
        loadDataLenTableHoaDon();
    }

    private void xuLyResetTableGoiY() {
        DefaultTableModel modelMANV = (DefaultTableModel) jTableMANV.getModel();
        modelMANV.setRowCount(0);
        jTableMANV.setModel(modelMANV);
        DefaultTableModel modelMAKH = (DefaultTableModel) jTableMAKH.getModel();
        modelMAKH.setRowCount(0);
        jTableMAKH.setModel(modelMAKH);
        DefaultTableModel modelMAHD = (DefaultTableModel) jTableMAHD.getModel();
        modelMAHD.setRowCount(0);
        jTableMAHD.setModel(modelMAHD);
        jScrollPaneMAHD.setVisible(false);
        jScrollPaneMAKH.setVisible(false);
        jScrollPaneMANV.setVisible(false);
        tfMaKH.setVisible(true);
        tfMaNV.setVisible(true);
        tfMaKM.setVisible(true);
        tfNgayLap.setVisible(true);
    }

    // Các hàm kiểm tra hóa đơn
    private boolean kiemTraDauVaoHoaDon(String maHD) {
        for (HoaDon_DTO hd : listHoaDon) {
            if (hd.getMaHD().equals(maHD)) {
                return false;
            }
        }
        return true;
    }

    // private void phuDinhkiemTraDauVaoHoaDon() {
    //     tfMaHD.setText("Hóa đơn đã tồn tại");
    //     tfMaHD.addMouseListener(new MouseAdapter() {
    //         @Override
    //         public void mouseClicked(MouseEvent e) {
    //             if (tfMaHD.getText().equals("Hóa đơn đã tồn tại")) {
    //                 tfMaHD.setText("");
    //             }
    //         }
    //     });
    // }

    // hàm tìm hóa đơn và trả về đối tượng
    private HoaDon_DTO kiemTraDauVaoHoaDonDoiTuong(String maHD) {
        listHoaDon = hoaDon_BUS.getListHD();
        for (HoaDon_DTO hd : listHoaDon) {
            if (hd.getMaHD().equals(maHD)) {
                return hd;
            }
        }
        return null;
    }

    // Kiểm tra hóa đơn xem đã tồn tại chưa để được xem chi tiết
    private boolean kiemTraDauVaoHoaDonKhiXemChiTiet(String maHD) {
        for (HoaDon_DTO hd : listHoaDon) {
            if (hd.getMaHD().equals(maHD)) {
                return true;
            }
        }
        return false;
    }

    // Kiểm tra khách hàng
    private boolean kiemTraDauVaoKhachHang(String maKH) {
        for (KhachHang_DTO kh : listKhachHang) {
            if (kh.getMaKH().equals(maKH)) {
                return true;
            }
        }
        return false;
    }

    // kiểm tra khách hàng và trả về đối tưowngj khách hàng
    private KhachHang_DTO doiTuongKhachHang(String maKH) {
        for (KhachHang_DTO kh : listKhachHang) {
            if (kh.getMaKH().equals(maKH)) {
                return kh;
            }
        }
        return null;
    }

    private void phuDinhkiemTraDauVaoKhachHang() {
        tfMaKH.setText("KH Không tồn tại");
        tfMaKH.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tfMaKH.getText().equals("KH Không tồn tại")) {
                    tfMaKH.setText("");
                }
            }
        });
    }

    // KIỂM TRA NHÂN VIÊN
    private boolean kiemTraDauVaoNhanVien(String maNV) {
        int dem = 0;
        for (NhanVien_DTO nv : listNhanVien) {
            if (nv.getMaNV().equals(maNV)) {
                String chucVu = nv.getChucvu().toUpperCase();
                dem++;
                if (chucVu.equals("BÁN HÀNG")) {
                    return true;
                } else {
                    tfMaNV.setText("Không phải NV bán hàng");
                    return false;
                }
            }
        }
        if (dem == 0) {
            tfMaNV.setText("NV không tồn tại");
        }
        return false;
    }

    private void phuDinhkiemTraDauVaoNhanVien() {
        tfMaNV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tfMaNV.getText().equals("NV không tồn tại") ||
                        tfMaNV.getText().equals("Không phải NV bán hàng")) {
                    tfMaNV.setText("");
                }
            }
        });
    }

    // kiểm tra nhân viên và trả về đối tượng
    private NhanVien_DTO doiTuongNhanVien(String maNV) {
        for (NhanVien_DTO nv : listNhanVien) {
            if (nv.getMaNV().equals(maNV)) {
                return nv;
            }
        }
        return null;
    }

    // hàm kiểm tra và trả về đối tượng sản phẩm
    private SanPham_DTO doiTuongSP(String maSP) {
        for (SanPham_DTO sp : listSanPham) {
            if (sp.getMaSp().equals(maSP)) {
                return sp;
            }
        }
        return null;
    }

    // hàm kiểm tra và trả về đối tương loại sản phẩm
    private loaiSP_DTO doiTuongLoai(String maLoai) {
        for (loaiSP_DTO loai : listLoaiSP) {
            if (loai.getMaLoai().equals(maLoai)) {
                return loai;
            }
        }
        return null;
    }

    // Kiểm tra định dạng ngày
    private boolean kiemTraDinhDangNgay(String ngayLap) {
        if (ngayLap.matches("\\d{4}-\\d{2}-\\d{2}")) {
            // Kiểm tra các phần của ngày (năm, tháng, ngày)
            String[] parts = ngayLap.split("-");
            try {
                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int day = Integer.parseInt(parts[2]);
                if (year >= 1000 && year <= 9999 && month >= 1 && month <= 12 && day >= 1 && day <= 31) {
                    return true;
                }
            } catch (Exception e) {
                // TODO: handle exception
                return false;
            }
        }
        return false;
    }
    // Định dạng ngày
    private LocalDate dinhDangNgay(String ngay) {
        try {
            DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(ngay, dinhDang);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private boolean kiemTraNgay(KMtheoTTien_DTO KMtheoTTien) {
        String maCT = KMtheoTTien.getMaCT();
        LocalDate ngayLap = dinhDangNgay(tfNgayLap.getText());

        if (ngayLap != null) {
            for (CTKM_DTO ctkm : listCTKM) {
                if (maCT.equals(ctkm.getMaCT())) {
                    LocalDateTime ngayBD = ctkm.getNgayBD();
                    LocalDateTime ngayKT = ctkm.getNgayKT();

                    // Chuyển đổi LocalDate thành LocalDateTime
                    LocalDateTime ngayLapLocalDateTime = ngayLap.atStartOfDay();

                    // Kiểm tra nếu ngày lập nằm trong khoảng thời gian của khuyến mãi
                    if (ngayLapLocalDateTime.isBefore(ngayKT) && ngayLapLocalDateTime.isAfter(ngayBD)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Kiểm tra để được khuyến mãi
    private KMtheoTTien_DTO kiemTra(Double tongTien, HoaDon_DTO hd) {
        Double tienNhoNhat = 0.0;
        int dem = 0;
        KMtheoTTien_DTO kmtheoTT = null;
        for (KMtheoTTien_DTO km : listKMTheoTT) {
            if ((tongTien >= km.getTienMin()) && (kiemTraNgay(km))) {
                dem++;
                tienNhoNhat = tongTien * km.getPhanTram_KM();
                kmtheoTT = km;
                break;
            }
        }
        if (dem != 0) {
            for (KMtheoTTien_DTO km : listKMTheoTT) {
                if ((tongTien >= km.getTienMin()) && (kiemTraNgay(km))) {
                    if ((tongTien * km.getPhanTram_KM()) < tienNhoNhat) {
                        kmtheoTT = km;
                    }
                }
            }
        }
        return kmtheoTT;
    }

    /// Hàm kiểm tra đầu vào khi nhập
    private boolean kiemTraDauVaoKhiNhap() {
        int dem = 0;
        if (listKhachHang.size() == 0 || listNhanVien.size() == 0) {
            JOptionPane.showMessageDialog(null, "Không có dữ liệu để thêm", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        // Kiểm tra hóa đơn
        
        // kiểm tra khách hàng
        if (!kiemTraDauVaoKhachHang(tfMaKH.getText())) {
            phuDinhkiemTraDauVaoKhachHang();
            dem++;
        }
        // kiểm tra nhân viên
        if (!kiemTraDauVaoNhanVien(tfMaNV.getText())) {
            phuDinhkiemTraDauVaoNhanVien();
            dem++;
        }

        if (dem == 0) {
            return true;
        }
        return false;
    }
    // kiểm tra kí tự đặc biệt

    private boolean containsSpecialCharacter(String str) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");// phủ định lại các kí tự bên trong
        Matcher matcher = pattern.matcher(str);
        return matcher.find();// nếu tìm thấy sẽ trả về true (nghĩa là có kí tự đặc biệt)
    }

    // Hàm xử lý thêm hóa đơn
    private void xuLyThemHoaDon() {
        if (tfMaHD.getText().isEmpty() || tfMaKH.getText().isEmpty() || tfMaNV.getText().isEmpty()
                || tfNgayLap.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng không để trống thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            if (containsSpecialCharacter(tfMaHD.getText()) || containsSpecialCharacter(tfMaKH.getText())
                    || containsSpecialCharacter(tfMaNV.getText())) {
                JOptionPane.showMessageDialog(null, "Vui lòng không nhập kí tự đặc biệt và khoảng trắng", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if(!kiemTraDinhDangNgay(tfNgayLap.getText())) {
            JOptionPane.showMessageDialog(null, "Ngày không hợp lệ", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                        tfNgayLap.requestFocus();
                        return;
        }
        if(!kiemTraNgayHD()) {
            // JDialog dialog = new JDialog();
            int option = JOptionPane.showConfirmDialog(null, "Ngày không hợp lệ bạn có muốn chọn ngày hiện tại không", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            LocalDate ngayHienTaiLCD = LocalDate.now();
            tfNgayLap.setText(ngayHienTaiLCD.toString());
        }
        else {
            return;
        }
        
        }
        if (!kiemTraDauVaoHoaDon(tfMaHD.getText())) {
            int optionMAHD = JOptionPane.showConfirmDialog(null, "Hóa đơn này đã tồn tại, bạn có muốn thay đổi mã hóa đơn và thêm không?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
            if (optionMAHD == JOptionPane.OK_OPTION) {
                setTFMaHoaDon();
            }
            else {
                return;
            }
        }
        if (kiemTraDauVaoKhiNhap()) {
            LocalDate ngayLap = null;
            float tienGiam = 0;
            double tongTien = 0;
            tfMaKM.setText("Chưa đủ điều kiện");
            ngayLap = dinhDangNgay(tfNgayLap.getText());
            tienGiam = Float.parseFloat(tfTienGiam.getText());
            tongTien = Double.parseDouble(tfTongTien.getText());
            HoaDon_DTO hoaDon = new HoaDon_DTO();
            hoaDon.setMaHD(tfMaHD.getText());
            hoaDon.setMaKH(tfMaKH.getText());
            hoaDon.setMaNV(tfMaNV.getText());
            hoaDon.setMaKM("NULL");
            hoaDon.setNgayLap(ngayLap.atStartOfDay());
            hoaDon.setTienGiam(tienGiam);
            hoaDon.setTongTien(tongTien);
            hoaDon_BUS.themHoaDon(hoaDon);
            xuLyReset();
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Hàm tỉnh tổng tiền
    private double tinhTongTien(String maHD) {
        ArrayList<ChiTietHoaDon_DTO> listCTHoaDon = cthd_BUS.getListCTHD();
        double tongTien = 0;
        for (ChiTietHoaDon_DTO cthd : listCTHoaDon) {
            if (cthd.getMaHD().equals(maHD)) {
                tongTien += cthd.getThanhTien();
            }
        }
        return tongTien;
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

    // kiểm tra khuyến mãi
    private boolean kiemTraKhuyenMaiCTHD(String maSP, ChiTietHoaDon_DTO cthd) {
        for (KMtheoSP_DTO km : listKMTheoSP) {
            if (km.getMaSP().equals(maSP)) {
                return kiemTraNgayCTHD(km.getMaCT(), cthd);

            }
        }
        return false;
    }

    // kiểm tra ngày
    private boolean kiemTraNgayCTHD(String maCT, ChiTietHoaDon_DTO cthd) {
        LocalDate ngayLap = null;
        ngayLap = dinhDangNgay(tfNgayLap.getText());
        for (CTKM_DTO ctkm : listCTKM) {
            if (maCT.equals(ctkm.getMaCT())) {
                LocalDateTime ngayBD = ctkm.getNgayBD();
                LocalDateTime ngayKT = ctkm.getNgayKT();
                LocalDateTime ngayLapLocalDateTime = ngayLap.atStartOfDay();
                if ((ngayLapLocalDateTime.isAfter(ngayBD) || ngayLapLocalDateTime.isEqual(ngayBD)) && (ngayLapLocalDateTime.isBefore(ngayKT) || ngayLapLocalDateTime.isEqual(ngayKT))) {
                    if (!maCT.equals(cthd.getMaCT())) {
                        cthd.setMaCT(maCT);
                        return true;
                        // UPDATE
                    } else {
                        return false;
                    }
                } else {
                    if (!cthd.getMaCT().equals("NULL")) {
                        cthd.setMaCT("NULL");
                        return true;
                        // UPDATE
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
    private boolean kiemTraNgayHD() {
        LocalDate ngayLap = null;
        ngayLap = dinhDangNgay(tfNgayLap.getText());
        
        LocalDateTime ngayHienTaiLCDT = LocalDateTime.now();
        LocalDateTime ngayLapLocalDateTime = ngayLap.atStartOfDay();
        if (ngayLapLocalDateTime.isAfter(ngayHienTaiLCDT)) {
            
            return false;
        }
        return true;
    }

    // Tính tiền giảm
    private float tinhTienGiamCTHD(ChiTietHoaDon_DTO cthd) {
        for (KMtheoSP_DTO kmsp : listKMTheoSP) {
            if (kmsp.getMaCT().equals(cthd.getMaCT())) {
                if (kmsp.getPhanTram_KM() > 1) {
                    float tienGiam = ((kmsp.getPhanTram_KM() * cthd.getSoLuong() * cthd.getGia()) / 100);
                    return tienGiam;
                } else {
                    float tienGiam = (kmsp.getPhanTram_KM() * cthd.getSoLuong() * cthd.getGia());
                    return tienGiam;
                }
            }
        }
        return 0;
    }

    // Tính tiền khi có khuyến mãi
    private double tinhThanhTien(ChiTietHoaDon_DTO cthd, float tienGiam) {
        double thanhTien = (cthd.getGia() * cthd.getSoLuong()) - tienGiam;
        return thanhTien;
    }

    // Hàm xử lý sửa hóa đơn
    private boolean kiemTraDauVaoKhiSuaHoaDon() {
        int dem = 0;

        if (!kiemTraDauVaoKhachHang(tfMaKH.getText())) {
            phuDinhkiemTraDauVaoKhachHang();
            dem++;
        }
        if (!kiemTraDauVaoNhanVien(tfMaNV.getText())) {
            phuDinhkiemTraDauVaoNhanVien();
            dem++;
        }
        if (dem == 0) {
            return true;
        }
        return false;

    }

    private void xuLySuaHoaDon() {
        if (tfMaKH.getText().isEmpty() || tfMaNV.getText().isEmpty() || tfNgayLap.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng không để trống thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            if (containsSpecialCharacter(tfMaHD.getText()) || containsSpecialCharacter(tfMaKH.getText())
                    || containsSpecialCharacter(tfMaNV.getText())) {
                JOptionPane.showMessageDialog(null, "Vui lòng không nhập kí tự đặc biệt và khoảng trắng", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if(!kiemTraDinhDangNgay(tfNgayLap.getText())) {
            JOptionPane.showMessageDialog(null, "Ngày không hợp lệ", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                        tfNgayLap.requestFocus();
                        return;
        }
        if(!kiemTraNgayHD()) {
            // JDialog dialog = new JDialog();
            int option = JOptionPane.showConfirmDialog(null, "Ngày không hợp lệ bạn có muốn chọn ngày hiện tại không", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            LocalDate ngayHienTaiLCD = LocalDate.now();
            tfNgayLap.setText(ngayHienTaiLCD.toString());
        }
        else {
            return;
        }
       
        }
        if (kiemTraDauVaoHoaDonDoiTuong(tfMaHD.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Hóa đơn không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (kiemTraDauVaoKhiSuaHoaDon()) {
            float tienGiam = 0;
            double thanhTien = 0;

            for (ChiTietHoaDon_DTO cthd : listCTHD) {
                if (cthd.getMaHD().equals(tfMaHD.getText())) {
                    String maSP = cthd.getMaSP();
                    if (kiemTraKhuyenMaiCTHD(maSP, cthd)) {
                        if (cthd.getMaCT().equals("NULL")) {
                            thanhTien = cthd.getThanhTien() + cthd.getTienGiam();
                            cthd.setTienGiam(0);
                            cthd.setThanhTien(thanhTien);
                        } else {
                            tienGiam = tinhTienGiamCTHD(cthd);
                            thanhTien = tinhThanhTien(cthd, tienGiam);
                            cthd.setTienGiam(tienGiam);
                            cthd.setThanhTien(thanhTien);
                        }
                        cthd_BUS.capNhapChiTietHoaDon(cthd);
                    }
                }
            }
            xuLyUpdateHoaDon();
            xuLyReset();

        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void xuLyUpdateHoaDon() {
        HoaDon_DTO hd = kiemTraDauVaoHoaDonDoiTuong(tfMaHD.getText());
        LocalDate ngayLap = null;
        ngayLap = dinhDangNgay(tfNgayLap.getText());
        String maKM = "NULL";
        float tienGiamHD = 0;
        double tongTien = tinhTongTien(tfMaHD.getText());
        KMtheoTTien_DTO kMtheoTTien = kiemTra(hd.getTongTien(), hd);
        if (kMtheoTTien != null) {
            ArrayList<String> listTien = tinhTienKhiCoKhuyenMai(kMtheoTTien.getMaKM(), hd.getTongTien());
            maKM = kMtheoTTien.getMaKM();
            tienGiamHD = Float.parseFloat(listTien.get(0));
            tongTien = Double.parseDouble(listTien.get(1));
        }
        hd.setMaKM(maKM);
        hd.setNgayLap(ngayLap.atStartOfDay());
        hd.setTienGiam(tienGiamHD);
        hd.setTongTien(tongTien);
        hoaDon_BUS.capNhatHoaDon(hd);
    }

    private boolean kiemTraDauVaoXoa() {
            if (kiemTraDauVaoHoaDonDoiTuong(tfMaHD.getText()) == null) {
                JOptionPane.showMessageDialog(null, "Không thể xóa hóa đơn không tồn tại", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

        
        return true;
    }

    // hàm đưa ra sản phẩm cần update
    private void xuLyXoaHoaDon() {
        if (kiemTraDauVaoXoa()) {
            if (hoaDon_BUS.xoaHoaDon(tfMaHD.getText())) {
                for (ChiTietHoaDon_DTO cthd : listCTHD) {
                    if (cthd.getMaHD().equals(tfMaHD.getText())) {
                        if (cthd_BUS.deleteChiTietKhiXoaHoaDon(cthd.getMaHD(), cthd.getMaSP())) {
                            SanPham_DTO sp = doiTuongSP(cthd.getMaSP());
                            loaiSP_DTO loai = doiTuongLoai(sp.getMaLoai());
                            sp.setSoluong(sp.getSoluong() + cthd.getSoLuong());
                            loai.setSoluong(loai.getSoluong() + cthd.getSoLuong());
                            cthd_BUS.suaSoLuongSP(sp);
                            cthd_BUS.suaSoLuongLoai(loai);
                        }
                    }
                }

            }
            xuLyReset();
        }
    }

    private void tbDSHDMouseClicked() {
        int i = jTableHoaDon.getSelectedRow();
        tfMaHD.setText(jTableHoaDon.getModel().getValueAt(i, 0).toString());
        tfMaKH.setText(jTableHoaDon.getModel().getValueAt(i, 1).toString());
        tfMaNV.setText(jTableHoaDon.getModel().getValueAt(i, 2).toString());
        tfMaKM.setText(jTableHoaDon.getModel().getValueAt(i, 3).toString());
        String ngayLap = (jTableHoaDon.getModel().getValueAt(i, 4).toString());
        ngayLap = ngayLap.substring(0, 10);
        tfNgayLap.setText(ngayLap);
        tfTienGiam.setText(jTableHoaDon.getModel().getValueAt(i, 5).toString());
        tfTongTien.setText(jTableHoaDon.getModel().getValueAt(i, 6).toString());

    }

    private void suKienEnter() {
        // tfMaHD.requestFocus();
        // tfMaHD.addKeyListener(new KeyAdapter() {
        //     @Override
        //     public void keyPressed(KeyEvent e) {
        //         if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        //             if (jTableMAHD.getRowCount() > 0) {
        //                 tfMaHD.setText(jTableMAHD.getValueAt(0, 0).toString());
        //             }
        //             xuLyResetTableGoiY();
        //             tfMaKH.requestFocus();
        //         }
        //     }
        // });
        tfMaKH.requestFocus();
        tfMaKH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (jTableMAKH.getRowCount() > 0) {
                        tfMaKH.setText(jTableMAKH.getValueAt(0, 0).toString());
                    }
                    xuLyResetTableGoiY();
                    tfMaNV.requestFocus();
                }
            }
        });
        tfMaNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (jTableMANV.getRowCount() > 0) {
                        tfMaNV.setText(jTableMANV.getValueAt(0, 0).toString());
                    }
                    xuLyResetTableGoiY();
                    tfNgayLap.requestFocus();
                }
            }
        });
    }

    // xử lý in hóa đơn
    private void xuLyHienThiHoaDon() {
        if (tfMaHD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (kiemTraDauVaoHoaDonDoiTuong(tfMaHD.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Mã hóa đơn không hợp lệ", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        txtHoaDon.setContentType("text/html");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String hd = "<style> "
                + "table {"
                + "border: 1px solid;"
                + "border-bottom: none"
                + "}"
                + "tr {"
                + "border-bottom: 1px solid;"
                + "}"
                + "td {"
                + "padding: 2px;"
                + "border-left: 1px solid;"
                + "border-right: 1px solid;"
                + "} "
                + "th {"
                + "font-size:10px;"
                + "}"
                + "</style>";
        String hoTenNV = "", hoTenKH = "", SDTKH = "", ngayLap = "";
        float tienGiam = 0;
        Double tongTien = 0.0;
        for (HoaDon_DTO hoaDon : listHoaDon) {
            if (hoaDon.getMaHD().equals(tfMaHD.getText())) {
                tienGiam = hoaDon.getTienGiam();
                tongTien = hoaDon.getTongTien();
                NhanVien_DTO nv = doiTuongNhanVien(hoaDon.getMaNV());
                hoTenNV = nv.getHo() + " " + nv.getTen();
                hoTenNV = hoTenNV.toUpperCase();
                KhachHang_DTO kh = doiTuongKhachHang(hoaDon.getMaKH());
                hoTenKH = kh.getHo() + " " + kh.getTen();
                hoTenKH = hoTenKH.toUpperCase();
                SDTKH = kh.getSdt();
                ngayLap = hoaDon.getNgayLap().format(dtf);

            }
        }
        hd += "<h1 style='text-align:center;'>HOÁ ĐƠN THANH TOÁN</h1>";
        hd += "NHÂN VIÊN: " + hoTenNV + "<br/>";
        hd += "NGÀY LẬP: " + ngayLap + "<br/>";
        hd += "KHÁCH HÀNG: " + hoTenKH + "<br/>";
        hd += "SỐ ĐIỆN THOẠI: " + SDTKH + "<br/>";
        hd += "<div style='text-align:center;'>SẢN PHẨM ĐÃ MUA</div><br/>";
        hd += "<div style='text-align:center'>";
        hd += "<table style='max-width:100%'>";
        hd += "<tr>"
                + "<th style='border: 1px solid;'>Mã</th>"
                + "<th style='border: 1px solid;'>Tên</th>"
                + "<th style='border: 1px solid;'>Số lượng</th>"
                + "<th style='border: 1px solid;'>Đơn giá</th>"
                + "<th style='border: 1px solid;'>Tiền giảm</th>"
                + "<th style='border: 1px solid;'>Thành tiền</th>"
                + "</tr>";
        String tenSP = "", maSP = "", donGiaStr = "", thanhTienStr = "", tienGiamCTHDStr = "";
        int soLuong = 0;
        float donGia = 0, tienGiamCTHD = 0;
        Double tongCong = 0.0, thanhTien = 0.0;
        for (ChiTietHoaDon_DTO cthd : listCTHD) {
            if (cthd.getMaHD().equals(tfMaHD.getText())) {
                tongCong += cthd.getThanhTien();
                SanPham_DTO sp = doiTuongSP(cthd.getMaSP());
                tenSP = sp.getTenSP();
                maSP = sp.getMaSp();
                soLuong = cthd.getSoLuong();
                donGia = sp.getDongia();
                tienGiamCTHD = cthd.getTienGiam();
                thanhTien = cthd.getThanhTien();
                donGiaStr = FormatTienFloatSangString(donGia) + " VND";
                tienGiamCTHDStr = FormatTienFloatSangString(tienGiamCTHD) + " VND";
                thanhTienStr = FormatTienDoubleSangString(thanhTien) + " VND";
                hd += "<tr>";
                hd += "<td style='text-align:center;font-size:10px;'>" + maSP + "</td>";
                hd += "<td style='text-align:center;font-size:10px;'>" + tenSP + "</td>";
                hd += "<td style='text-align:center;font-size:10px;'>" + soLuong + "</td>";
                hd += "<td style='text-align:center;font-size:10px;'>" + donGiaStr + "</td>";
                hd += "<td style='text-align:center;font-size:10px;'>" + tienGiamCTHDStr + "</td>";
                hd += "<td style='text-align:center;font-size:10px;'>" + thanhTienStr + "</td>";
                hd += "</tr>";

            }
        }
        String tongCongStr = FormatTienDoubleSangString(tongCong) + " VND";
        hd += "<tr>";
        hd += "<td style='text-align:center;font-size:10px;'>" + "</td>";
        hd += "<td style='text-align:center;font-size:10px;'>" + "</td>";
        hd += "<td style='text-align:center;font-size:10px;'>" + "</td>";
        hd += "<td style='text-align:center;font-size:10px;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold;font-size:10px;'>Tổng cộng:</td>";
        hd += "<td style='text-align:center;font-size:10px;'>" + tongCongStr + "</td>";
        hd += "</tr>";
        String tienGiamStr = FormatTienFloatSangString(tienGiam) + " VND";
        hd += "<tr>";
        hd += "<td style='text-align:center;font-size:10px;'>" + "</td>";
        hd += "<td style='text-align:center;font-size:10px;'>" + "</td>";
        hd += "<td style='text-align:center;font-size:10px;'>" + "</td>";
        hd += "<td style='text-align:center;font-size:10px;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold;font-size:10px;'>Tiền giảm:</td>";
        hd += "<td style='text-align:center;font-size:10px;'>" + tienGiamStr + "</td>";
        hd += "</tr>";
        String tongTienStr = FormatTienDoubleSangString(tongTien) + " VND";
        hd += "<tr>";
        hd += "<td style='text-align:center;font-size:10px;'>" + "</td>";
        hd += "<td style='text-align:center;font-size:10px;'>" + "</td>";
        hd += "<td style='text-align:center;font-size:10px;'>" + "</td>";
        hd += "<td style='text-align:center;font-size:10px;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold;font-size:10px;'>Tổng tiền:</td>";
        hd += "<td style='text-align:center;font-size:10px;'>" + tongTienStr + "</td>";
        hd += "</tr>";
        hd += "</tr>";
        hd += "</table>";
        hd += "</div>";
        hd += "<div style='text-align:center;'>XIN CẢM ƠN QUÝ KHÁCH!HẸN GẶP LẠI!</div><br/>";
        txtHoaDon.setText(hd);
    }

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (!txtHoaDon.getText().equals("")) {
                txtHoaDon.print();
                this.dispose();
            }
        } catch (PrinterException ex) {
        }
    }

    // Làm phần hiện lịch
    private void btnLichNgayLapActionPerformed(java.awt.event.ActionEvent evt) {
        JDialog dialog = new JDialog(this, "Chọn ngày", true);
        dialog.setSize(200, 200);
        dialog.setLocationRelativeTo(this);
        int x = this.getX() + 350 + (this.getWidth() - dialog.getWidth()) / 2;
        int y = this.getY() + 40 + (this.getHeight() - dialog.getHeight()) / 2;

        // Đặt vị trí mới cho cuốn lịch
        dialog.setLocation(x, y);
        JCalendar calendar = new JCalendar();
        dialog.add(calendar);

        JButton selectButton = new JButton("Chọn");
        selectButton.addActionListener(e -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String selectedDate = dateFormat.format(calendar.getDate());
            tfNgayLap.setText(selectedDate);
            dialog.dispose();
        });

        dialog.add(selectButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private void btnLichBatDauActionPerformed() {
        JDialog dialog = new JDialog(this, "Chọn ngày", true);
        dialog.setSize(200, 200);
        dialog.setLocationRelativeTo(this);
        int x = this.getX() - 50 + (this.getWidth() - dialog.getWidth()) / 2;
        int y = this.getY() + 40 + (this.getHeight() - dialog.getHeight()) / 2;

        // Đặt vị trí mới cho cuốn lịch
        dialog.setLocation(x, y);
        JCalendar calendar = new JCalendar();
        dialog.add(calendar);

        JButton selectButton = new JButton("Chọn");
        selectButton.addActionListener(e -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String selectedDate = dateFormat.format(calendar.getDate());
            tfNgayBD.setText(selectedDate);
            dialog.dispose();
            locHoaDonTheoNgay();
        });

        dialog.add(selectButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private void btnLichKetThucActionPerformed() {
        JDialog dialog = new JDialog(this, "Chọn ngày", true);
        dialog.setSize(200, 200);
        dialog.setLocationRelativeTo(this);
        int x = this.getX() + 120 + (this.getWidth() - dialog.getWidth()) / 2;
        int y = this.getY() + 40 + (this.getHeight() - dialog.getHeight()) / 2;

        // Đặt vị trí mới cho cuốn lịch
        dialog.setLocation(x, y);
        JCalendar calendar = new JCalendar();
        dialog.add(calendar);

        JButton selectButton = new JButton("Chọn");
        selectButton.addActionListener(e -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String selectedDate = dateFormat.format(calendar.getDate());
            tfNgayKT.setText(selectedDate);
            dialog.dispose();
            locHoaDonTheoNgay();
        });

        dialog.add(selectButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    // xử lý tìm kiếm hóa đơn
    // private void tfTuKhoaTimKiemKeyReleased(java.awt.event.KeyEvent evt) {
    //     if (tfNgayBD.getText().isEmpty() && tfNgayKT.getText().isEmpty()) {
    //         xuLyTimKiemHoaDon();
    //     } else {
    //         locHoaDonTheoNgay();
    //     }
    // }

    // private void cbbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbbTimKiemActionPerformed
    //     if (tfNgayBD.getText().isEmpty() && tfNgayKT.getText().isEmpty()) {
    //         xuLyTimKiemHoaDon();
    //     } else {
    //         locHoaDonTheoNgay();
    //     }

    // }// GEN-LAST:event_cbbTimKiemActionPerformed

    private void xuLyTimKiemHoaDon() {
        ArrayList<HoaDon_DTO> dshd = new ArrayList<HoaDon_DTO>();
        String thuMucTimKiem = jComboBoxTimKiem.getSelectedItem().toString();
        String tuKhoaTimKiem = tfTuKhoaTimKiem.getText();
        if (!tfTuKhoaTimKiem.getText().isEmpty() && !tfTuKhoaTimKiem.getText().equals("Tìm kiếm")) {

            switch (thuMucTimKiem) {
                case "Mã hóa đơn": {
                    String sqlTimKiem = "MAHD";
                    dshd = hoaDon_BUS.TimKiemKhongNgay(sqlTimKiem, tuKhoaTimKiem);
                    break;
                }
                case "Mã khách hàng": {
                    String sqlTimKiem = "MAKH";
                    dshd = hoaDon_BUS.TimKiemKhongNgay(sqlTimKiem, tuKhoaTimKiem);
                    break;
                }
                case "Mã nhân viên": {
                    String sqlTimKiem = "ID";
                    dshd = hoaDon_BUS.TimKiemKhongNgay(sqlTimKiem, tuKhoaTimKiem);
                    break;
                }
                case "Mã khuyễn mãi": {
                    String sqlTimKiem = "MAKM";
                    dshd = hoaDon_BUS.TimKiemKhongNgay(sqlTimKiem, tuKhoaTimKiem);
                    break;
                }
            }
        }
        loadDataLenTableHoaDon(dshd);
    }

    private void locHoaDonTheoNgay() {
        ArrayList<HoaDon_DTO> dshd = new ArrayList<HoaDon_DTO>();
        String thuMucTimKiem = jComboBoxTimKiem.getSelectedItem().toString();
        String ngayBD = "";
        String ngayKT = "";

        if (!tfNgayBD.getText().isEmpty()) {
            if (kiemTraDinhDangNgay(tfNgayBD.getText())) {
                ngayBD = (tfNgayBD.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng ngày","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;

            }
        }
        if (!tfNgayKT.getText().isEmpty()) {
            if (kiemTraDinhDangNgay(tfNgayKT.getText())) {
                ngayKT = (tfNgayKT.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng ngày","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        if (!tfTuKhoaTimKiem.getText().isEmpty() && !tfTuKhoaTimKiem.getText().equals("Tìm kiếm")) {
            if (!tfNgayBD.getText().isEmpty() && !tfNgayKT.getText().isEmpty()) {
                switch (thuMucTimKiem) {
                    case "Mã hóa đơn": {
                        String sqlTimKiem = "MAHD";
                        dshd = hoaDon_BUS.timKiemHDTheoNgay(ngayBD, ngayKT, sqlTimKiem, tfTuKhoaTimKiem.getText());
                        break;
                    }
                    case "Mã khách hàng": {
                        String sqlTimKiem = "MAKH";
                        dshd = hoaDon_BUS.timKiemHDTheoNgay(ngayBD, ngayKT, sqlTimKiem, tfTuKhoaTimKiem.getText());
                        break;
                    }
                    case "Mã nhân viên": {
                        String sqlTimKiem = "ID";
                        dshd = hoaDon_BUS.timKiemHDTheoNgay(ngayBD, ngayKT, sqlTimKiem, tfTuKhoaTimKiem.getText());
                        break;

                    }
                    case "Mã khuyễn mãi": {
                        String sqlTimKiem = "MAKM";
                        dshd = hoaDon_BUS.timKiemHDTheoNgay(ngayBD, ngayKT, sqlTimKiem, tfTuKhoaTimKiem.getText());
                        break;

                    }
                }
            }
            if (!tfNgayBD.getText().isEmpty() && tfNgayKT.getText().isEmpty()) {
                switch (thuMucTimKiem) {
                    case "Mã hóa đơn": {
                        String sqlTimKiem = "MAHD";
                        dshd = hoaDon_BUS.timKiemHDTheoNgayNhoHonHoacBang(ngayBD, sqlTimKiem,
                                tfTuKhoaTimKiem.getText());
                        break;
                    }
                    case "Mã khách hàng": {
                        String sqlTimKiem = "MAKH";
                        dshd = hoaDon_BUS.timKiemHDTheoNgayNhoHonHoacBang(ngayBD, sqlTimKiem,
                                tfTuKhoaTimKiem.getText());
                        break;
                    }
                    case "Mã nhân viên": {
                        String sqlTimKiem = "ID";
                        dshd = hoaDon_BUS.timKiemHDTheoNgayNhoHonHoacBang(ngayBD, sqlTimKiem,
                                tfTuKhoaTimKiem.getText());
                        break;
                    }
                    case "Mã khuyễn mãi": {
                        String sqlTimKiem = "MAKM";
                        dshd = hoaDon_BUS.timKiemHDTheoNgayNhoHonHoacBang(ngayBD, sqlTimKiem,
                                tfTuKhoaTimKiem.getText());
                        break;
                    }
                }
            }
            if (tfNgayBD.getText().isEmpty() && !tfNgayKT.getText().isEmpty()) {
                switch (thuMucTimKiem) {
                    case "Mã hóa đơn": {
                        String sqlTimKiem = "MAHD";
                        dshd = hoaDon_BUS.timKiemHDTheoNgayLonHonHoacBang(ngayKT, sqlTimKiem,
                                tfTuKhoaTimKiem.getText());
                        break;
                    }
                    case "Mã khách hàng": {
                        String sqlTimKiem = "MAKH";
                        dshd = hoaDon_BUS.timKiemHDTheoNgayLonHonHoacBang(ngayKT, sqlTimKiem,
                                tfTuKhoaTimKiem.getText());
                        break;
                    }
                    case "Mã nhân viên": {
                        String sqlTimKiem = "ID";
                        dshd = hoaDon_BUS.timKiemHDTheoNgayLonHonHoacBang(ngayKT, sqlTimKiem,
                                tfTuKhoaTimKiem.getText());
                        break;
                    }
                    case "Mã khuyễn mãi": {
                        String sqlTimKiem = "MAKM";
                        dshd = hoaDon_BUS.timKiemHDTheoNgayLonHonHoacBang(ngayKT, sqlTimKiem,
                                tfTuKhoaTimKiem.getText());
                        break;
                    }
                }
            }
        } else {
            if (!tfNgayBD.getText().isEmpty() && !tfNgayKT.getText().isEmpty()) {
                dshd = hoaDon_BUS.timKiemHDTheoNgay(ngayBD, ngayKT);
            }
            if (!tfNgayBD.getText().isEmpty() && tfNgayKT.getText().isEmpty()) {
                dshd = hoaDon_BUS.timKiemHDTheoNgayNhoHonHoacBang(ngayBD);
            }
            if (tfNgayBD.getText().isEmpty() && !tfNgayKT.getText().isEmpty()) {
                dshd = hoaDon_BUS.timKiemHDTheoNgayLonHonHoacBang(ngayKT);
            }
        }
        loadDataLenTableHoaDon(dshd);
    }

    // xỬ KÝ KHI NHẬP SẼ HIỆN GỢI Ý
    private void tfMaHoaDonKeyReleased() {
        int height = 0;
        DefaultTableModel modelMAHD = (DefaultTableModel) jTableMAHD.getModel();
        modelMAHD.setRowCount(0);
        if (tfMaHD.getText().isEmpty()) {
            jTableMAHD.setModel(modelMAHD);
            jScrollPaneMAHD.setVisible(false);
            tfMaNV.setVisible(true);
            tfMaKH.setVisible(true);
            return;
        }
        if (containsSpecialCharacter(tfMaHD.getText()) && !tfMaHD.getText().equals("Hóa đơn đã tồn tại")) {
            JOptionPane.showMessageDialog(null, "Vui lòng không nhập kí tự đặc biệt và khoảng trắng", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        listHoaDon = hoaDon_BUS.getListHD();
        for (HoaDon_DTO hd : listHoaDon) {
            if (hd.getMaHD().contains(tfMaHD.getText())) {
                modelMAHD.addRow(new Object[] { hd.getMaHD() });
                if (height < 70) {
                    height += 25;
                }
            }
        }
        if (modelMAHD.getRowCount() == 0) {
            jScrollPaneMAHD.setVisible(false);
            tfMaNV.setVisible(true);
            tfMaKH.setVisible(true);
            return;
        } else if (modelMAHD.getRowCount() >= 1 && modelMAHD.getRowCount() < 3) {
            tfMaKH.setVisible(false);
            tfMaNV.setVisible(true);

        } else if (modelMAHD.getRowCount() >= 3) {
            tfMaKH.setVisible(false);
            tfMaNV.setVisible(false);

        }
        if (height > 70) {
            height = 70;
        }
        jScrollPaneMAHD.setBounds(478, 35, 121, height);
        jScrollPaneMAHD.setVisible(true);

    }

    private void clickTableMAHD(java.awt.event.MouseEvent evt) {
        int row = jTableMAHD.getSelectedRow();
        if (row > -1) {
            tfMaHD.setText(jTableMAHD.getValueAt(row, 0).toString());
            jScrollPaneMAHD.setVisible(false);
            tfMaKH.setVisible(true);
            tfMaNV.setVisible(true);
        }
    }

    private void tfMaKhachHangKeyReleased() {
        int height = 0;
        DefaultTableModel modelMAKH = (DefaultTableModel) jTableMAKH.getModel();
        modelMAKH.setRowCount(0);
        if (tfMaKH.getText().isEmpty()) {
            jTableMAKH.setModel(modelMAKH);
            jScrollPaneMAKH.setVisible(false);
            tfMaNV.setVisible(true);
            tfMaKM.setVisible(true);
            return;
        }
        if (containsSpecialCharacter(tfMaKH.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng không nhập kí tự đặc biệt và khoảng trắng", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (KhachHang_DTO kh : listKhachHang) {
            if (kh.getMaKH().contains(tfMaKH.getText())) {
                modelMAKH.addRow(new Object[] { kh.getMaKH() });
                if (height < 70) {
                    height += 25;
                }
            }
        }
        if (modelMAKH.getRowCount() == 0) {
            jScrollPaneMAKH.setVisible(false);
            tfMaNV.setVisible(true);
            tfMaKM.setVisible(true);
            return;
        } else if (modelMAKH.getRowCount() >= 1 && modelMAKH.getRowCount() < 3) {
            tfMaNV.setVisible(false);
            tfMaKM.setVisible(true);

        } else if (modelMAKH.getRowCount() >= 3) {
            tfMaNV.setVisible(false);
            tfMaKM.setVisible(false);

        }
        if (height > 70) {
            height = 70;
        }
        jScrollPaneMAKH.setBounds(478, 68, 121, height);
        jScrollPaneMAKH.setVisible(true);

    }

    private void clickTableMAKH(java.awt.event.MouseEvent evt) {
        int row = jTableMAKH.getSelectedRow();
        if (row > -1) {
            tfMaKH.setText(jTableMAKH.getValueAt(row, 0).toString());
            jScrollPaneMAKH.setVisible(false);
            tfMaKM.setVisible(true);
            tfMaNV.setVisible(true);
        }
    }

    private void tfMaNhanVienKeyReleased() {
        int height = 0;
        DefaultTableModel modelMANV = (DefaultTableModel) jTableMANV.getModel();
        modelMANV.setRowCount(0);
        if (tfMaNV.getText().isEmpty()) {
            jTableMANV.setModel(modelMANV);
            jScrollPaneMANV.setVisible(false);
            tfMaKM.setVisible(true);
            tfNgayLap.setVisible(true);
            return;
        }
        if (containsSpecialCharacter(tfMaNV.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng không nhập kí tự đặc biệt và khoảng trắng", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (NhanVien_DTO nv : listNhanVien) {
            if (nv.getMaNV().contains(tfMaNV.getText())) {
                modelMANV.addRow(new Object[] { nv.getMaNV() });
                if (height < 70) {
                    height += 25;
                }
            }
        }
        if (modelMANV.getRowCount() == 0) {
            jScrollPaneMANV.setVisible(false);
            tfMaKM.setVisible(true);
            tfNgayLap.setVisible(true);
            return;
        } else if (modelMANV.getRowCount() >= 1 && modelMANV.getRowCount() < 3) {
            tfMaKM.setVisible(false);
            tfNgayLap.setVisible(true);

        } else if (modelMANV.getRowCount() >= 3) {
            tfMaKM.setVisible(false);
            tfNgayLap.setVisible(false);

        }
        if (height > 70) {
            height = 70;
        }
        jScrollPaneMANV.setBounds(478, 100, 121, height);
        jScrollPaneMANV.setVisible(true);

    }

    private void clickTableMANV(java.awt.event.MouseEvent evt) {
        int row = jTableMANV.getSelectedRow();
        if (row > -1) {
            tfMaNV.setText(jTableMANV.getValueAt(row, 0).toString());
            jScrollPaneMANV.setVisible(false);
            tfMaKM.setVisible(true);
            tfNgayLap.setVisible(true);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_HoaDon().setVisible(true);
            }
        });
    }

}
