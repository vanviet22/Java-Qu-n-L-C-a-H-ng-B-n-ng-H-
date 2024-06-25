package GUI;
import BUS.ThongKe_BUS;
import DTO.HoaDon_DTO;
import DTO.ChiTietHoaDon_DTO;
import BUS.CTHoaDon_BUS;
import BUS.HoaDon_BUS;
import BUS.SanPham_BUS;
import BUS.KhachHang_BUS;
import DTO.SanPham_DTO;
import DTO.KhachHang_DTO;
import GUI.TransparentPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.plot.PlotOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.FormattableFlags;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GUI_ThongKe extends javax.swing.JFrame {
    private ThongTinDN dn=new ThongTinDN();
    private ChartPanel chartPanel;
    DefaultTableModel modelSanPham = new DefaultTableModel();
    DefaultTableModel modelKhachHang = new DefaultTableModel();
    private HoaDon_BUS hoaDon_BUS = new HoaDon_BUS();
    private ThongKe_BUS thongKe_BUS = new ThongKe_BUS();
    private KhachHang_BUS khachHang_BUS = new KhachHang_BUS();
    private CTHoaDon_BUS cthoaDon_BUS = new CTHoaDon_BUS();
    private SanPham_BUS sanPham_BUS = new SanPham_BUS();
    private ArrayList<HoaDon_DTO> listHD = hoaDon_BUS.getListHD();
    private ArrayList<ChiTietHoaDon_DTO> listCTHD = cthoaDon_BUS.getListCTHD();
    private ArrayList<SanPham_DTO> listSP = sanPham_BUS.getList();
    private ArrayList<KhachHang_DTO> listKH = khachHang_BUS.getListKH();

    // peivate ct
    // Hàm khởi tạo
    public GUI_ThongKe() {
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
    ImageIcon icon = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image/iConTrangChu.png");
    JLabel lbImgTrangChu = new JLabel();
    // Thuộc tính của Thống kê
     private javax.swing.JSpinner jSpinnerNamTKKH;
    private javax.swing.JSpinner jSpinnerNamTKSP;
    private javax.swing.JLabel lbNamTKKH;
    private javax.swing.JLabel lbNamTKSP;
    private javax.swing.JScrollPane jScrollPaneSP;
    private javax.swing.JScrollPane jScrollPaneTKKH;
    private javax.swing.JSpinner jSpinnerNam;
    private javax.swing.JTabbedPane jTabbedPaneTK;
    private javax.swing.JLabel lbBanChay;
    private javax.swing.JLabel lbDoanhThu;
    private javax.swing.JLabel lbDoanhThuQuy;
    private javax.swing.JLabel lbDoanhThuQuy1;
    private javax.swing.JLabel lbDoanhThuQuy2;
    private javax.swing.JLabel lbDoanhThuQuy3;
    private javax.swing.JLabel lbDoanhThuQuy4;
    private javax.swing.JLabel lbImgCTTKKH;
    private javax.swing.JLabel lbImgDT;
    private javax.swing.JLabel lbImgKH;
    private javax.swing.JLabel lbImgSP;
    private javax.swing.JLabel lbImgTieuDe2;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbLogoCTKH;
    private javax.swing.JLabel lbLogoTKSP;
    private javax.swing.JLabel lbLogoTopBanChay;
    private javax.swing.JLabel lbQuy;
    private javax.swing.JLabel lbQuy1;
    private javax.swing.JLabel lbQuy2;
    private javax.swing.JLabel lbQuy3;
    private javax.swing.JLabel lbQuy4;
    private javax.swing.JLabel lbSLDT;
    private javax.swing.JLabel lbSLKH;
    private javax.swing.JLabel lbSLSP;
    private javax.swing.JLabel lbSLSPTop1;
    private javax.swing.JLabel lbSLSPTop2;
    private javax.swing.JLabel lbSLSPTop3;
    private javax.swing.JLabel lbSanPham;
    private javax.swing.JLabel lbSoLuongCuaTop;
    private javax.swing.JLabel lbTenSPTop1;
    private javax.swing.JLabel lbTenSPTop2;
    private javax.swing.JLabel lbTenSPTop3;
    private javax.swing.JLabel lbTenSamPhamTopSP;
    private javax.swing.JLabel lbTieuDe;
    private javax.swing.JLabel lbTieuDeCTTKKH;
    private javax.swing.JLabel lbTongCongDTQuy;
    private javax.swing.JLabel lbTongSoDoanhThu1234;
    private javax.swing.JLabel lbTop1;
    private javax.swing.JLabel lbTop2;
    private javax.swing.JLabel lbTop3;
    private javax.swing.JLabel lbTopTopSanPham;
    private javax.swing.JPanel paChiTietCacQuy;
    private javax.swing.JPanel paChiTietTKDT;
    private javax.swing.JPanel paChiTietTKKH;
    private javax.swing.JPanel paChiTietTKSP;
    private javax.swing.JPanel paChiTietTKTQ;
    private javax.swing.JPanel paDoanhThu;
    private javax.swing.JPanel paKhachHang;
    private javax.swing.JPanel pnChart;
    private javax.swing.JPanel paSanPham;
    private javax.swing.JPanel paTopSPBanChay;
    private javax.swing.JTable tbCTTKKH;
    private javax.swing.JTable tbTKSP;

    // HÀM FORM
    private void addControls() {
        // FORM TRANG CHỦ
        setTitle("Quản lí thống kê");
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

        btnThongKe.setBackground(new java.awt.Color(153, 255, 153));
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

        // FORM CỦA PHẦN THỐNG Kê
        jSpinnerNamTKKH = new javax.swing.JSpinner();
        lbNamTKKH = new javax.swing.JLabel();
        jSpinnerNamTKSP = new javax.swing.JSpinner();
        lbNamTKSP = new javax.swing.JLabel();
        lbTieuDe = new javax.swing.JLabel();
        lbImgTieuDe2 = new javax.swing.JLabel();
        jTabbedPaneTK = new javax.swing.JTabbedPane();
        paChiTietTKSP = new javax.swing.JPanel();
        jScrollPaneSP = new javax.swing.JScrollPane();
        tbTKSP = new javax.swing.JTable();
        paTopSPBanChay = new javax.swing.JPanel();
        lbLogoTopBanChay = new javax.swing.JLabel();
        lbBanChay = new javax.swing.JLabel();
        lbTopTopSanPham = new javax.swing.JLabel();
        lbTop1 = new javax.swing.JLabel();
        lbTop2 = new javax.swing.JLabel();
        lbTop3 = new javax.swing.JLabel();
        lbTenSPTop3 = new javax.swing.JLabel();
        lbTenSamPhamTopSP = new javax.swing.JLabel();
        lbTenSPTop1 = new javax.swing.JLabel();
        lbTenSPTop2 = new javax.swing.JLabel();
        lbSLSPTop3 = new javax.swing.JLabel();
        lbSoLuongCuaTop = new javax.swing.JLabel();
        lbSLSPTop1 = new javax.swing.JLabel();
        lbSLSPTop2 = new javax.swing.JLabel();
        lbLogoTKSP = new javax.swing.JLabel();
        paChiTietTKKH = new javax.swing.JPanel();
        lbTieuDeCTTKKH = new javax.swing.JLabel();
        lbImgCTTKKH = new javax.swing.JLabel();
        lbLogoCTKH = new javax.swing.JLabel();
        jScrollPaneTKKH = new javax.swing.JScrollPane();
        tbCTTKKH = new javax.swing.JTable();
        paChiTietTKDT = new javax.swing.JPanel();
        paChiTietTKTQ = new javax.swing.JPanel();
        paKhachHang = new javax.swing.JPanel();
        lbImgKH = new javax.swing.JLabel();
        lbKhachHang = new javax.swing.JLabel();
        lbSLKH = new javax.swing.JLabel();
        paSanPham = new javax.swing.JPanel();
        lbImgSP = new javax.swing.JLabel();
        lbSanPham = new javax.swing.JLabel();
        lbSLSP = new javax.swing.JLabel();
        paDoanhThu = new javax.swing.JPanel();
        lbImgDT = new javax.swing.JLabel();
        lbDoanhThu = new javax.swing.JLabel();
        lbSLDT = new javax.swing.JLabel();
        paChiTietCacQuy = new javax.swing.JPanel();
        pnChart = new javax.swing.JPanel();
        lbQuy = new javax.swing.JLabel();
        lbQuy1 = new javax.swing.JLabel();
        lbQuy4 = new javax.swing.JLabel();
        lbQuy3 = new javax.swing.JLabel();
        lbQuy2 = new javax.swing.JLabel();
        lbDoanhThuQuy = new javax.swing.JLabel();
        lbTongCongDTQuy = new javax.swing.JLabel();
        lbDoanhThuQuy1 = new javax.swing.JLabel();
        lbDoanhThuQuy2 = new javax.swing.JLabel();
        lbDoanhThuQuy3 = new javax.swing.JLabel();
        lbDoanhThuQuy4 = new javax.swing.JLabel();
        lbTongSoDoanhThu1234 = new javax.swing.JLabel();
        jSpinnerNam = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 1000));

//         paMainGUI_ThongKe.setBackground(new java.awt.Color(102, 102, 102));
//         paMainGUI_ThongKe.setBorder(new javax.swing.border.LineBorder(new
//         java.awt.Color(0, 0, 0), 3, true));

        lbTieuDe.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lbTieuDe.setForeground(new java.awt.Color(255, 153, 0));
        lbTieuDe.setText("THỐNG KÊ");

        ImageIcon imageTieuDe2 = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image/icon-TieuDe.png");
        lbImgTieuDe2.setIcon(imageTieuDe2); // NOI18N

        jTabbedPaneTK.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPaneTK.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 4, true));
        jTabbedPaneTK.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        paChiTietTKSP.setBackground(new java.awt.Color(153, 153, 153));

        tbTKSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        tbTKSP.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số Lượng"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPaneSP.setViewportView(tbTKSP);
        jSpinnerNamTKSP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinnerNamTKSP.setModel(new javax.swing.SpinnerListModel(new String[] {"2021", "2022", "2023", "2024", "2025"}));
        // jSpinnerNamTKSP.addChangeListener(e -> {
        //     updateTotalAmountTKSP();
        // });
        jSpinnerNamTKSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbNamTKSP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNamTKSP.setText("THEO NĂM :");
        paTopSPBanChay.setBackground(new java.awt.Color(153, 153, 153));
        paTopSPBanChay.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        ImageIcon imageLogoTopBanChay = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image/icons8-best-seller-48.png");
        lbLogoTopBanChay.setIcon(imageLogoTopBanChay); // NOI18N

        lbBanChay.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbBanChay.setForeground(new java.awt.Color(255, 195, 0));
        lbBanChay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBanChay.setText("Bán Chạy");

        lbTopTopSanPham.setBackground(new java.awt.Color(255, 195, 0));
        lbTopTopSanPham.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbTopTopSanPham.setForeground(new java.awt.Color(255, 195, 0));
        lbTopTopSanPham.setText("Top Sản Phẩm ");

        lbTop1.setBackground(new java.awt.Color(102, 102, 102));
        lbTop1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTop1.setForeground(new java.awt.Color(255, 255, 255));
        lbTop1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTop1.setText("Top 1");
        lbTop1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbTop2.setBackground(new java.awt.Color(102, 102, 102));
        lbTop2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTop2.setForeground(new java.awt.Color(255, 255, 255));
        lbTop2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTop2.setText("Top 2");
        lbTop2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbTop3.setBackground(new java.awt.Color(102, 102, 102));
        lbTop3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTop3.setForeground(new java.awt.Color(255, 255, 255));
        lbTop3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTop3.setText("Top 3");
        lbTop3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbTenSPTop3.setBackground(new java.awt.Color(102, 102, 102));
        lbTenSPTop3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTenSPTop3.setForeground(new java.awt.Color(255, 255, 255));
        lbTenSPTop3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTenSPTop3.setText("Top 1");
        lbTenSPTop3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbTenSamPhamTopSP.setBackground(new java.awt.Color(102, 102, 102));
        lbTenSamPhamTopSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTenSamPhamTopSP.setForeground(new java.awt.Color(255, 255, 255));
        lbTenSamPhamTopSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTenSamPhamTopSP.setText("Mã Sản Phẩm");
        lbTenSamPhamTopSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbTenSPTop1.setBackground(new java.awt.Color(102, 102, 102));
        lbTenSPTop1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTenSPTop1.setForeground(new java.awt.Color(255, 255, 255));
        lbTenSPTop1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTenSPTop1.setText("Top 1");
        lbTenSPTop1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbTenSPTop2.setBackground(new java.awt.Color(102, 102, 102));
        lbTenSPTop2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTenSPTop2.setForeground(new java.awt.Color(255, 255, 255));
        lbTenSPTop2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTenSPTop2.setText("Top 1");
        lbTenSPTop2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbSLSPTop3.setBackground(new java.awt.Color(102, 102, 102));
        lbSLSPTop3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSLSPTop3.setForeground(new java.awt.Color(255, 255, 255));
        lbSLSPTop3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSLSPTop3.setText("Số Lượng");
        lbSLSPTop3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbSoLuongCuaTop.setBackground(new java.awt.Color(102, 102, 102));
        lbSoLuongCuaTop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSoLuongCuaTop.setForeground(new java.awt.Color(255, 255, 255));
        lbSoLuongCuaTop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSoLuongCuaTop.setText("Số Lượng");
        lbSoLuongCuaTop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbSLSPTop1.setBackground(new java.awt.Color(102, 102, 102));
        lbSLSPTop1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSLSPTop1.setForeground(new java.awt.Color(255, 255, 255));
        lbSLSPTop1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSLSPTop1.setText("Số Lượng");
        lbSLSPTop1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbSLSPTop2.setBackground(new java.awt.Color(102, 102, 102));
        lbSLSPTop2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSLSPTop2.setForeground(new java.awt.Color(255, 255, 255));
        lbSLSPTop2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSLSPTop2.setText("Số Lượng");
        lbSLSPTop2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        ImageIcon imageLogoTKSP = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image/boss luxyry logo.png");
        lbLogoTKSP.setIcon(imageLogoTKSP); // NOI18
        
        javax.swing.GroupLayout paTopSPBanChayLayout = new javax.swing.GroupLayout(paTopSPBanChay);
        paTopSPBanChay.setLayout(paTopSPBanChayLayout);
        paTopSPBanChayLayout.setHorizontalGroup(
            paTopSPBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paTopSPBanChayLayout.createSequentialGroup()
                .addGroup(paTopSPBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paTopSPBanChayLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lbLogoTopBanChay))
                    .addGroup(paTopSPBanChayLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lbBanChay))
                    .addGroup(paTopSPBanChayLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbTopTopSanPham)))
                .addGap(54, 54, 54)
                .addGroup(paTopSPBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTop2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTop3, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(lbTop1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paTopSPBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTenSPTop3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTenSPTop1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTenSamPhamTopSP, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(lbTenSPTop2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paTopSPBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paTopSPBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbSLSPTop2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbSLSPTop1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbSoLuongCuaTop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbSLSPTop3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(lbLogoTKSP)
                .addContainerGap())
        );
        paTopSPBanChayLayout.setVerticalGroup(
            paTopSPBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paTopSPBanChayLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbLogoTKSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(paTopSPBanChayLayout.createSequentialGroup()
                .addGroup(paTopSPBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paTopSPBanChayLayout.createSequentialGroup()
                        .addGroup(paTopSPBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paTopSPBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbTenSamPhamTopSP)
                                .addComponent(lbSoLuongCuaTop))
                            .addGroup(paTopSPBanChayLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbTopTopSanPham)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLogoTopBanChay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbBanChay))
                    .addGroup(paTopSPBanChayLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lbSLSPTop1))
                    .addGroup(paTopSPBanChayLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(paTopSPBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTenSPTop1)
                            .addComponent(lbTop1))
                        .addGap(4, 4, 4)
                        .addGroup(paTopSPBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTenSPTop2)
                            .addComponent(lbTop2)
                            .addComponent(lbSLSPTop2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paTopSPBanChayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTenSPTop3)
                            .addComponent(lbTop3)
                            .addComponent(lbSLSPTop3))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paChiTietTKSPLayout = new javax.swing.GroupLayout(paChiTietTKSP);
        paChiTietTKSP.setLayout(paChiTietTKSPLayout);
        paChiTietTKSPLayout.setHorizontalGroup(
            paChiTietTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paChiTietTKSPLayout.createSequentialGroup()
                .addGroup(paChiTietTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paChiTietTKSPLayout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(lbNamTKSP, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerNamTKSP, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paChiTietTKSPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(paTopSPBanChay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(paChiTietTKSPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPaneSP)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        paChiTietTKSPLayout.setVerticalGroup(
            paChiTietTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paChiTietTKSPLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(paTopSPBanChay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paChiTietTKSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNamTKSP)
                    .addComponent(jSpinnerNamTKSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneSP, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
        );

        jTabbedPaneTK.addTab("Thống Kê Sản Phẩm", paChiTietTKSP);

        paChiTietTKKH.setBackground(new java.awt.Color(153, 153, 153));

        lbTieuDeCTTKKH.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lbTieuDeCTTKKH.setForeground(new java.awt.Color(247, 143, 131));
        lbTieuDeCTTKKH.setText("Chi Tiết Thống Kê Khách Hàng");

        ImageIcon imageCTTKKH = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image/iconKhachHang.png");
        lbImgCTTKKH.setIcon(imageCTTKKH); // NOI18N

        ImageIcon imageLogoCTKH = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image/boss luxyry logo.png");
        lbLogoCTKH.setIcon(imageLogoCTKH); // NOI18N

        tbCTTKKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        tbCTTKKH.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null }
                },
                new String[] {
                        "Mã khách hàng", "Họ Tên", "Số điện thoại", "Giới tính", "Tổng tiền"
                }));
        jScrollPaneTKKH.setViewportView(tbCTTKKH);
        
        jSpinnerNamTKKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jSpinnerNamTKKH.setModel(new javax.swing.SpinnerListModel(new String[] {"2021", "2022", "2023", "2024", "2025"}));
        jSpinnerNamTKKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        // jSpinnerNamTKKH.addChangeListener(e -> {
        //     updateTotalAmountTKKH();
        // });
        lbNamTKKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNamTKKH.setText("THEO NĂM :");
        
        javax.swing.GroupLayout paChiTietTKKHLayout = new javax.swing.GroupLayout(paChiTietTKKH);
        paChiTietTKKH.setLayout(paChiTietTKKHLayout);
        paChiTietTKKHLayout.setHorizontalGroup(
            paChiTietTKKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paChiTietTKKHLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbNamTKKH, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinnerNamTKKH, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paChiTietTKKHLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lbImgCTTKKH, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lbTieuDeCTTKKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(lbLogoCTKH)
                .addContainerGap())
            .addGroup(paChiTietTKKHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTKKH)
                .addContainerGap())
        );
        paChiTietTKKHLayout.setVerticalGroup(
            paChiTietTKKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paChiTietTKKHLayout.createSequentialGroup()
                .addGroup(paChiTietTKKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paChiTietTKKHLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lbImgCTTKKH, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paChiTietTKKHLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(paChiTietTKKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTieuDeCTTKKH, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLogoCTKH))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paChiTietTKKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerNamTKKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNamTKKH))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneTKKH, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jTabbedPaneTK.addTab("Thống Kê Khách Hàng", paChiTietTKKH);

        paChiTietTKDT.setBackground(new java.awt.Color(153, 153, 153));

        jTabbedPaneTK.addTab("Thống Kê Doanh Thu", paChiTietTKDT);

        paChiTietTKTQ.setBackground(new java.awt.Color(153, 153, 153));

        paKhachHang.setBackground(new java.awt.Color(161, 201, 241));
        paKhachHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paKhachHang.setPreferredSize(new java.awt.Dimension(161, 162));

        ImageIcon imageImgKH = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image/iconKhachHang.png");
        lbImgKH.setIcon(imageImgKH); // NOI18N

        lbKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbKhachHang.setText("Khách Hàng");

        lbSLKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSLKH.setText("Số Lượng");

        javax.swing.GroupLayout paKhachHangLayout = new javax.swing.GroupLayout(paKhachHang);
        paKhachHang.setLayout(paKhachHangLayout);
        paKhachHangLayout.setHorizontalGroup(
                paKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paKhachHangLayout.createSequentialGroup()
                                .addGroup(paKhachHangLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbImgKH, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(paKhachHangLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(paKhachHangLayout.createSequentialGroup()
                                                        .addGap(29, 29, 29)
                                                        .addComponent(lbKhachHang))
                                                .addGroup(paKhachHangLayout.createSequentialGroup()
                                                        .addGap(70, 70, 70)
                                                        .addComponent(lbSLKH))))
                                .addContainerGap(39, Short.MAX_VALUE)));
        paKhachHangLayout.setVerticalGroup(
                paKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paKhachHangLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbImgKH, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbKhachHang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbSLKH)
                                .addContainerGap(34, Short.MAX_VALUE)));

        paSanPham.setBackground(new java.awt.Color(255, 206, 84));
        paSanPham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paSanPham.setPreferredSize(new java.awt.Dimension(161, 162));

        ImageIcon imageImgSP = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image/iconDT.png");
        lbImgSP.setIcon(imageImgSP); // NOI18N

        lbSanPham.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbSanPham.setText("Sản Phẩm");

        lbSLSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSLSP.setText("Số Lượng");

        javax.swing.GroupLayout paSanPhamLayout = new javax.swing.GroupLayout(paSanPham);
        paSanPham.setLayout(paSanPhamLayout);
        paSanPhamLayout.setHorizontalGroup(
                paSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paSanPhamLayout.createSequentialGroup()
                                .addContainerGap(45, Short.MAX_VALUE)
                                .addComponent(lbImgSP, javax.swing.GroupLayout.PREFERRED_SIZE, 69,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                        .addGroup(paSanPhamLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(paSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(paSanPhamLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(lbSLSP))
                                        .addComponent(lbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        paSanPhamLayout.setVerticalGroup(
                paSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paSanPhamLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbImgSP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbSanPham)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbSLSP)
                                .addContainerGap(33, Short.MAX_VALUE)));

        paDoanhThu.setBackground(new java.awt.Color(66, 181, 166));
        paDoanhThu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paDoanhThu.setPreferredSize(new java.awt.Dimension(161, 162));

        ImageIcon imageImgDT = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image/iconDoanhThu.png");
        lbImgDT.setIcon(imageImgDT); // NOI18N

        lbDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        lbDoanhThu.setText("Doanh Thu");

        lbSLDT.setBackground(new java.awt.Color(255, 255, 255));
        lbSLDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSLDT.setForeground(new java.awt.Color(255, 255, 255));
        lbSLDT.setText("Số Lượng");

        javax.swing.GroupLayout paDoanhThuLayout = new javax.swing.GroupLayout(paDoanhThu);
        paDoanhThu.setLayout(paDoanhThuLayout);
        paDoanhThuLayout.setHorizontalGroup(
                paDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paDoanhThuLayout.createSequentialGroup()
                                .addContainerGap(33, Short.MAX_VALUE)
                                .addGroup(paDoanhThuLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(paDoanhThuLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(lbSLDT, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(paDoanhThuLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbDoanhThu, javax.swing.GroupLayout.Alignment.TRAILING,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 98,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paDoanhThuLayout
                                                        .createSequentialGroup()
                                                        .addComponent(lbImgDT, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(9, 9, 9))))
                                .addGap(25, 25, 25)));
        paDoanhThuLayout.setVerticalGroup(
                paDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paDoanhThuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbImgDT, javax.swing.GroupLayout.PREFERRED_SIZE, 69,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbDoanhThu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbSLDT)
                                .addContainerGap(34, Short.MAX_VALUE)));

        paChiTietCacQuy.setBackground(new java.awt.Color(153, 153, 153));
        paChiTietCacQuy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbQuy.setBackground(new java.awt.Color(102, 102, 102));
        lbQuy.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbQuy.setForeground(new java.awt.Color(255, 255, 255));
        lbQuy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuy.setText("Quý");
        lbQuy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbQuy1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbQuy1.setForeground(new java.awt.Color(255, 255, 255));
        lbQuy1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuy1.setText("Quý 1");
        lbQuy1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lbQuy1.setPreferredSize(new java.awt.Dimension(70, 40));

        lbQuy4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbQuy4.setForeground(new java.awt.Color(255, 255, 255));
        lbQuy4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuy4.setText("Quý 4");
        lbQuy4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lbQuy4.setPreferredSize(new java.awt.Dimension(70, 40));

        lbQuy3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbQuy3.setForeground(new java.awt.Color(255, 255, 255));
        lbQuy3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuy3.setText("Quý 3");
        lbQuy3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lbQuy3.setPreferredSize(new java.awt.Dimension(70, 40));

        lbQuy2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbQuy2.setForeground(new java.awt.Color(255, 255, 255));
        lbQuy2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuy2.setText("Quý 2");
        lbQuy2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lbQuy2.setPreferredSize(new java.awt.Dimension(70, 40));

        lbDoanhThuQuy.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbDoanhThuQuy.setForeground(new java.awt.Color(255, 255, 255));
        lbDoanhThuQuy.setText("Doanh Thu");
        lbDoanhThuQuy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbTongCongDTQuy.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTongCongDTQuy.setForeground(new java.awt.Color(255, 255, 255));
        lbTongCongDTQuy.setText("Tổng cộng");
        lbTongCongDTQuy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbDoanhThuQuy1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDoanhThuQuy1.setForeground(new java.awt.Color(255, 255, 255));
        lbDoanhThuQuy1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoanhThuQuy1.setText("1,000,000,000");
        lbDoanhThuQuy1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lbDoanhThuQuy1.setPreferredSize(new java.awt.Dimension(70, 40));

        lbDoanhThuQuy2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDoanhThuQuy2.setForeground(new java.awt.Color(255, 255, 255));
        lbDoanhThuQuy2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoanhThuQuy2.setText("1,000,000,000");
        lbDoanhThuQuy2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lbDoanhThuQuy2.setPreferredSize(new java.awt.Dimension(70, 40));

        lbDoanhThuQuy3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDoanhThuQuy3.setForeground(new java.awt.Color(255, 255, 255));
        lbDoanhThuQuy3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoanhThuQuy3.setText("1,000,000,000");
        lbDoanhThuQuy3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lbDoanhThuQuy3.setPreferredSize(new java.awt.Dimension(70, 40));

        lbDoanhThuQuy4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDoanhThuQuy4.setForeground(new java.awt.Color(255, 255, 255));
        lbDoanhThuQuy4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoanhThuQuy4.setText("100,000,000");
        lbDoanhThuQuy4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lbDoanhThuQuy4.setPreferredSize(new java.awt.Dimension(70, 40));

        lbTongSoDoanhThu1234.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTongSoDoanhThu1234.setForeground(new java.awt.Color(255, 255, 255));
        lbTongSoDoanhThu1234.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTongSoDoanhThu1234.setText("1,000,000,000");
        lbTongSoDoanhThu1234.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        lbTongSoDoanhThu1234.setPreferredSize(new java.awt.Dimension(70, 40));

        javax.swing.GroupLayout paChiTietCacQuyLayout = new javax.swing.GroupLayout(paChiTietCacQuy);
        paChiTietCacQuy.setLayout(paChiTietCacQuyLayout);
        paChiTietCacQuyLayout.setHorizontalGroup(
            paChiTietCacQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paChiTietCacQuyLayout.createSequentialGroup()
                .addGroup(paChiTietCacQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbDoanhThuQuy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbQuy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTongCongDTQuy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(paChiTietCacQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paChiTietCacQuyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paChiTietCacQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbDoanhThuQuy1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(lbQuy1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paChiTietCacQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDoanhThuQuy2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(lbQuy2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(paChiTietCacQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbQuy3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(lbDoanhThuQuy3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paChiTietCacQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbQuy4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDoanhThuQuy4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paChiTietCacQuyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTongSoDoanhThu1234, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)))
                .addGap(6, 6, 6))
        );
        paChiTietCacQuyLayout.setVerticalGroup(
            paChiTietCacQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paChiTietCacQuyLayout.createSequentialGroup()
                .addGroup(paChiTietCacQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQuy)
                    .addComponent(lbQuy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQuy4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQuy3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQuy2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paChiTietCacQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDoanhThuQuy)
                    .addComponent(lbDoanhThuQuy1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDoanhThuQuy2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDoanhThuQuy3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDoanhThuQuy4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paChiTietCacQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTongCongDTQuy)
                    .addComponent(lbTongSoDoanhThu1234, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSpinnerNam.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jSpinnerNam.setModel(new javax.swing.SpinnerListModel(new String[] { "2021", "2022","2023", "2024", "2025" }));
        jSpinnerNam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        // jSpinnerNam.addChangeListener(e -> {
        //     updateTotalAmount();
        // });
        javax.swing.GroupLayout paChiTietTKTQLayout = new javax.swing.GroupLayout(paChiTietTKTQ);
        paChiTietTKTQ.setLayout(paChiTietTKTQLayout);
        paChiTietTKTQLayout.setHorizontalGroup(
            paChiTietTKTQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paChiTietTKTQLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paChiTietCacQuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paChiTietTKTQLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(paSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(paKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(paDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paChiTietTKTQLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSpinnerNam, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
        );
        paChiTietTKTQLayout.setVerticalGroup(
            paChiTietTKTQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paChiTietTKTQLayout.createSequentialGroup()
                .addGroup(paChiTietTKTQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paChiTietTKTQLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(paSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paChiTietTKTQLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(paChiTietTKTQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinnerNam, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(paChiTietCacQuy, javax.swing.GroupLayout.PREFERRED_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneTK.addTab("Thống Kê Tổng Quát", paChiTietTKTQ);

        javax.swing.GroupLayout paMainGUI_ThongKeLayout = new javax.swing.GroupLayout(paChiTiet);
        paChiTiet.setLayout(paMainGUI_ThongKeLayout);
        paMainGUI_ThongKeLayout.setHorizontalGroup(
                paMainGUI_ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paMainGUI_ThongKeLayout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addComponent(lbImgTieuDe2, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 223,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(200, Short.MAX_VALUE))
                        .addComponent(jTabbedPaneTK, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));
        paMainGUI_ThongKeLayout.setVerticalGroup(
                paMainGUI_ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paMainGUI_ThongKeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(paMainGUI_ThongKeLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbImgTieuDe2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPaneTK, javax.swing.GroupLayout.PREFERRED_SIZE, 441,
                                        Short.MAX_VALUE)
                                .addContainerGap()));
        // Biểu đồ
        
        pnChart = new TransparentPanel();
        pnChart.setBounds(3, 3, 730, 385);
        // Tạo dataset cho biểu đồ cột
        // CategoryDataset dataset = createDataset();
        chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new Dimension(730, 385));
        // Tạo một panel chứa biểu đồ
        pnChart.add(chartPanel);
        paChiTietTKDT.add(pnChart);
        // KẾT THÚC FORM THỐNG KÊ
        chuyenForm();
        setjSPiner();
        add(paTieuDe);
        add(paMenu);
        add(paChiTiet);

        setVisible(true);
    }

    // hàm các sự kiện
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
       
       thongKeSanPham();
       thongKeKhachHang();
       thongKeTongQuat();
       veLaiChart();
       jSpinnerNam.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                updateTotalAmount();
            }
        });
        jSpinnerNamTKSP.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                updateTotalAmountTKSP();
            }
        });
        jSpinnerNamTKKH.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                updateTotalAmountTKKH();
            }
        });
       JFormattedTextField tfJSpinnerTKTQ = ((JSpinner.DefaultEditor) jSpinnerNam.getEditor()).getTextField();
        tfJSpinnerTKTQ.addPropertyChangeListener("value", evt -> {
            thongKeTongQuat();
            veLaiChart();
            });
        JFormattedTextField tfJSpinnerTKSP = ((JSpinner.DefaultEditor) jSpinnerNamTKSP.getEditor()).getTextField();
        tfJSpinnerTKSP.addPropertyChangeListener("value", evt -> {
                thongKeSanPham();
            });

        JFormattedTextField tfJSpinnerTKKH = ((JSpinner.DefaultEditor) jSpinnerNamTKKH.getEditor()).getTextField();
        tfJSpinnerTKKH.addPropertyChangeListener("value", evt -> {
                thongKeKhachHang();
            });
   }
   private void setjSPiner() {
    LocalDate currentDate = LocalDate.now();
    String dateStr = currentDate.toString();
    int namHienTai = Integer.parseInt(dateStr.substring(0, 4));
    String namHoaDonMinStr = listHD.get(0).getNgayLap().toString().substring(0, 4);
    int namHoaDonMin = Integer.parseInt(namHoaDonMinStr);
    for (HoaDon_DTO hd : listHD) {
        LocalDateTime ngayLap = hd.getNgayLap();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str = ngayLap.format(formatter);
        if(namHoaDonMin > Integer.parseInt(hd.getNgayLap().toString().substring(0, 4))) {
            namHoaDonMin = Integer.parseInt(hd.getNgayLap().toString().substring(0, 4));
        }
    }
    
    ArrayList<String> listNam = new ArrayList<String>();
    for(int i = namHoaDonMin ; i <= namHienTai ; i++) {
        listNam.add(String.valueOf(i));
    }
    SpinnerListModel modelNam = new SpinnerListModel(listNam);
    jSpinnerNam.setModel(modelNam);
    SpinnerListModel modelNamTKSP = new SpinnerListModel(listNam);
    jSpinnerNamTKSP.setModel(modelNamTKSP);
    SpinnerListModel modelNamTKKH = new SpinnerListModel(listNam);
    jSpinnerNamTKKH.setModel(modelNamTKKH);

    
   }
    // Kiểm tra năm
    private boolean kiemTraNam(String ngayHoaDon) {
        // Kiểm tra độ dài chuỗi ngayHoaDon trước khi cắt chuỗi
        if (ngayHoaDon.length() < 4) {
            return false; // Chuỗi ngày không đủ dài để lấy năm
        }

        // Lấy năm từ chuỗi ngày hóa đơn
        String namHoaDon = ngayHoaDon.substring(0, 4);

        try {
            // Ép kiểu giá trị từ jSpinnerNam.getValue() sang int
            int soLuong = Integer.parseInt(jSpinnerNam.getValue().toString());
            int namInt = Integer.parseInt(namHoaDon);
            // So sánh năm từ chuỗi ngày và giá trị từ jSpinnerNam
            return soLuong == namInt;
        } catch (NumberFormatException e) {
            // Xử lý nếu giá trị từ jSpinnerNam không phải là một số hợp lệ
            e.printStackTrace(); // Hoặc thực hiện xử lý khác tùy vào ngữ cảnh
            return false;
        }
    }
    // Hàm thống kê sản phẩm
    private void thongKeSanPham() {
        int valueNam = Integer.parseInt(jSpinnerNamTKSP.getValue().toString());
        Map<String, Integer> listSanPham = thongKe_BUS.thongKeSanPham(valueNam);
        if(listSanPham.size() > 0) {
                thongKeSanPham(listSanPham);
        }
        else {
                modelSanPham.setRowCount(0);
                Vector tieuDe = new Vector();
                tieuDe.add("Mã sản phẩm");
                tieuDe.add("Tên sản phẩm");
                tieuDe.add("Đơn giá");
                tieuDe.add("Số lượng");
                if (modelSanPham.getRowCount() == 0) {
                    modelSanPham = new DefaultTableModel(tieuDe, 0);
                }
                lbTenSPTop1.setText("NULL");
                lbSLSPTop1.setText("NULL");
                lbTenSPTop2.setText("NULL");
                lbSLSPTop2.setText("NULL");
                lbTenSPTop3.setText("NULL");
                lbSLSPTop3.setText("NULL");
                return;
        }

    }

    private SanPham_DTO doiTuongSP(String maSP) {
        for (SanPham_DTO sp : listSP) {
            if (sp.getMaSp().equals(maSP)) {
                return sp;
            }
        }
        return null;
    }

    private String FormatTienFloatSangString(float valueFloat) {
        return String.format("%.0f", valueFloat);
    }

    private void thongKeSanPham( Map<String, Integer> listSanPham ) {
        modelSanPham.setRowCount(0);
        for (Map.Entry<String, Integer> entry : listSanPham.entrySet()) {
            SanPham_DTO sp = doiTuongSP(entry.getKey());
            if(sp != null) {

                Vector tieuDe = new Vector();
                tieuDe.add("Mã sản phẩm");
                tieuDe.add("Tên sản phẩm");
                tieuDe.add("Đơn giá");
                tieuDe.add("Số lượng");
                if (modelSanPham.getRowCount() == 0) {
                    modelSanPham = new DefaultTableModel(tieuDe, 0);
                }
                Vector row = new Vector();
                row.add(entry.getKey());
                row.add(sp.getTenSP());
                String donGiaStr = FormatTienFloatSangString(sp.getDongia());
                row.add(donGiaStr);
                row.add(entry.getValue());
                modelSanPham.addRow(row);
            }
        }
        tbTKSP.setModel(modelSanPham);
        // sắp xếp để tìm ra sản phẩm bán chạy
        List<Map.Entry<String, Integer>> list = new ArrayList<>(listSanPham.entrySet());

        // Sắp xếp List theo giá trị giảm dần của value
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        if (list.size() >= 3) {
            lbTenSPTop1.setText(list.get(0).getKey());
            lbSLSPTop1.setText(String.valueOf(list.get(0).getValue()));
            lbTenSPTop2.setText(list.get(1).getKey());
            lbSLSPTop2.setText(String.valueOf(list.get(1).getValue()));
            lbTenSPTop3.setText(list.get(2).getKey());
            lbSLSPTop3.setText(String.valueOf(list.get(2).getValue()));
        }
        else if(list.size() == 2) {
            lbTenSPTop1.setText(list.get(0).getKey());
            lbSLSPTop1.setText(String.valueOf(list.get(0).getValue()));
            lbTenSPTop2.setText(list.get(1).getKey());
            lbSLSPTop2.setText(String.valueOf(list.get(1).getValue()));
            lbTenSPTop3.setText("NULL");
            lbSLSPTop3.setText("NULL");
        } else if(list.size() == 1) {
            lbTenSPTop1.setText(list.get(0).getKey());
            lbSLSPTop1.setText(String.valueOf(list.get(0).getValue()));
            lbTenSPTop2.setText("NULL");
            lbSLSPTop2.setText("NULL");
            lbTenSPTop3.setText("NULL");
            lbSLSPTop3.setText("NULL");
        }

    }
    // Hàm của phần Biểu Đồ
    // HÀM THỐNG KÊ KHÁCH HÀNG
    private void thongKeKhachHang() {
        int valueNam = Integer.parseInt(jSpinnerNamTKKH.getValue().toString());
        Map<String, Double> listKhachHang = thongKe_BUS.thongKeKhachHang(valueNam);
        if(listKhachHang.size() > 0) {
                thongKeKhachHang(listKhachHang);
        }
        else {
                modelKhachHang.setRowCount(0);
                Vector tieuDe = new Vector();
                tieuDe.add("Mã sản phẩm");
                tieuDe.add("Tên sản phẩm");
                tieuDe.add("Đơn giá");
                tieuDe.add("Số lượng");
                if (modelKhachHang.getRowCount() == 0) {
                    modelKhachHang = new DefaultTableModel(tieuDe, 0);
                }
        }

    }

    private KhachHang_DTO doiTuongKhachHang(String maKH) {
        for (KhachHang_DTO kh : listKH) {
            if (kh.getMaKH().equals(maKH)) {
                return kh;
            }
        }
        return null;
    }

    private String FormatTienDoubleSangString(double valueDouble) {
        return String.format("%.0f", valueDouble);
    }

    private void thongKeKhachHang(Map<String, Double> listKhachHang) {
        modelKhachHang.setRowCount(0);
        for (Map.Entry<String, Double> entry : listKhachHang.entrySet()) {
            KhachHang_DTO kh = doiTuongKhachHang(entry.getKey());
            Vector tieuDe = new Vector();
            tieuDe.add("Mã khách hàng");
            tieuDe.add("Họ tên");
            tieuDe.add("Số điện thoại");
            tieuDe.add("Giới tính");
            tieuDe.add("Tổng tiền đã mua");
            if (modelKhachHang.getRowCount() == 0) {
                modelKhachHang = new DefaultTableModel(tieuDe, 0);
            }
            Vector row = new Vector();
            String maKH = "  " + entry.getKey();
            row.add(maKH);
            String HoTen = kh.getHo() + " " + kh.getTen();
            row.add(HoTen);
            row.add(kh.getSdt());
            row.add(kh.getGt());
            String tongTienStr = FormatTienDoubleSangString(entry.getValue());
            row.add(tongTienStr);
            modelKhachHang.addRow(row);
            tbCTTKKH.setModel(modelKhachHang);
        }
    }
    private void thongKeTongQuat() {
        ArrayList<String> listMaKH = new ArrayList<>();
        ArrayList<Double> listTongTien = new ArrayList<>();
        ArrayList<String> listSP = new ArrayList<>();
        ArrayList<Integer> listSoLuong = new ArrayList<>();
        ArrayList<String> listThang = new ArrayList<>();
        for (HoaDon_DTO hd : listHD) {
            LocalDateTime ngayLap = hd.getNgayLap();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String str = ngayLap.format(formatter);
            if (kiemTraNam(str)) {
                listMaKH.add(hd.getMaKH());
                listTongTien.add(hd.getTongTien());
                for (ChiTietHoaDon_DTO cthd : listCTHD) {
                    if (cthd.getMaHD().equals(hd.getMaHD())) {
                        listSP.add(cthd.getMaSP());
                        listSoLuong.add(cthd.getSoLuong());
                    }
                }
                listThang.add(str.substring(5, 7));
            }
        }
        if(listMaKH.size() > 0 && listTongTien.size() > 0) {
                thongKeTongQuat(listSP, listSoLuong, listMaKH, listTongTien, listThang);
        }
        else {
                lbSLDT.setText("0");
                lbSLDT.setHorizontalAlignment(SwingConstants.CENTER);
                lbSLSP.setText("0");
                lbSLKH.setText("0");
                lbDoanhThuQuy1.setText("0");
                lbDoanhThuQuy2.setText("0");
                lbDoanhThuQuy3.setText("0");
                lbDoanhThuQuy4.setText("0");
                lbTongSoDoanhThu1234.setText("0");
        }

    }

    private void thongKeTongQuat(ArrayList<String> listSP, ArrayList<Integer> listSoLuong, ArrayList<String> listMaKH,
            ArrayList<Double> listTongTien, ArrayList<String> listThang) {
        Map<String, Integer> listSanPham = new HashMap<>();
        for (int i = 0; i < listSP.size(); i++) {
            String maSP = listSP.get(i);
            int soLuongSP = listSoLuong.get(i);

            // Nếu sản phẩm đã có trong map, cộng số lượng mới vào số lượng đã có
            if (listSanPham.containsKey(maSP)) {
                int tongSoLuong = listSanPham.get(maSP);
                listSanPham.put(maSP, tongSoLuong + soLuongSP);
            } else {
                // Nếu sản phẩm chưa có trong map, thêm sản phẩm vào map với số lượng tương ứng
                listSanPham.put(maSP, soLuongSP);
            }
        }
        int tongSoLuong = 0;
        for (Map.Entry<String, Integer> entry : listSanPham.entrySet()) {
            tongSoLuong += entry.getValue();
        }
        lbSLSP.setText(String.valueOf(tongSoLuong));
        lbSLSP.setHorizontalAlignment(SwingConstants.CENTER);
        Map<String, Double> listKhachHang = new HashMap<>();
        for (int i = 0; i < listMaKH.size(); i++) {
            String maKH = listMaKH.get(i);
            Double tongTien = listTongTien.get(i);

            // Nếu sản phẩm đã có trong map, cộng số lượng mới vào số lượng đã có
            if (listKhachHang.containsKey(maKH)) {
                Double Tong = listKhachHang.get(maKH);
                listKhachHang.put(maKH, Tong + tongTien);
            } else {
                // Nếu sản phẩm chưa có trong map, thêm sản phẩm vào map với số lượng tương ứng
                listKhachHang.put(maKH, tongTien);
            }
        }
        int tongSoKH = 0;
        Double tongDoanhThu = 0.0;
        for (Map.Entry<String, Double> entry : listKhachHang.entrySet()) {
            tongSoKH++;
            tongDoanhThu += entry.getValue();
        }
        lbSLKH.setText(String.valueOf(tongSoKH));
        lbSLKH.setHorizontalAlignment(SwingConstants.CENTER);
        lbSLDT.setText(FormatTienDoubleSangString(tongDoanhThu));
        Double tongTienQuy1 = 0.0, tongTienQuy2 = 0.0, tongTienQuy3 = 0.0, tongTienQuy4 = 0.0, tong = 0.0;
        for (int i = 0; i < listThang.size(); i++) {
            int thang = Integer.parseInt(listThang.get(i));
            if (thang > 0 && thang <= 3) {
                tongTienQuy1 += listTongTien.get(i);
            } else if (thang >= 4 && thang <= 6) {
                tongTienQuy2 += listTongTien.get(i);
            } else if (thang >= 7 && thang <= 9) {
                tongTienQuy3 += listTongTien.get(i);
            } else if (thang >= 10 && thang <= 12) {
                tongTienQuy4 += listTongTien.get(i);
            }
            tong = tongTienQuy1 + tongTienQuy2 + tongTienQuy3 + tongTienQuy4;
            String tongTienQuy1Str = FormatTienDoubleSangString(tongTienQuy1);
            String tongTienQuy2Str = FormatTienDoubleSangString(tongTienQuy2);
            String tongTienQuy3Str = FormatTienDoubleSangString(tongTienQuy3);
            String tongTienQuy4Str = FormatTienDoubleSangString(tongTienQuy4);
            String tongStr = FormatTienDoubleSangString(tong);
            lbDoanhThuQuy1.setText(tongTienQuy1Str);
            lbDoanhThuQuy2.setText(tongTienQuy2Str);
            lbDoanhThuQuy3.setText(tongTienQuy3Str);
            lbDoanhThuQuy4.setText(tongTienQuy4Str);
            lbTongSoDoanhThu1234.setText(tongStr);

        }
    }

    // Biểu đồ
    private void veLaiChart() {
        pnChart.removeAll();

        chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new Dimension(730, 385));

        pnChart.add(chartPanel);
    }

    private JFreeChart createChart() {
        System.out.println("đã chạy");
        String tieuDe = "Doanh thu năm " + jSpinnerNam.getValue().toString();
        // Tạo biểu đồ cột từ dataset
        JFreeChart chart = ChartFactory.createBarChart(
                tieuDe, // Tiêu đề biểu đồ
                "Tháng", // Nhãn trục x
                "Doanh thu (triệu đồng)", // Nhãn trục y
                createDataset(), // Dataset chứa dữ liệu
                PlotOrientation.VERTICAL, // Hướng của biểu đồ (dọc hoặc ngang)
                true, // Có hiển thị legend không
                true, // Có tooltips không
                false // Có URL không
        );
        return chart;
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<Double> listTongTien = new ArrayList<>();
        ArrayList<String> listThang = new ArrayList<>();
        Map<Integer, Double> listBieuDo = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            listBieuDo.put(i, 0.0);
        }
        for (HoaDon_DTO hd : listHD) {
            LocalDateTime ngayLap = hd.getNgayLap();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String str = ngayLap.format(formatter);
            if (kiemTraNam(str)) {
                listThang.add(str.substring(5, 7));
                listTongTien.add(hd.getTongTien());
            }
        }

        for (int i = 0; i < listThang.size(); i++) {
            int thang = Integer.parseInt(listThang.get(i));
            Double tongTien = listTongTien.get(i);

            // Nếu sản phẩm đã có trong map, cộng số lượng mới vào số lượng đã có
            if (listBieuDo.containsKey(thang)) {
                Double tongTien1 = listBieuDo.get(thang);
                listBieuDo.put(thang, tongTien1 + tongTien);
            }
        }
        for (Map.Entry<Integer, Double> entry : listBieuDo.entrySet()) {
            String doubleStr = FormatTienDoubleSangString(entry.getValue());
            Double value = Double.valueOf(doubleStr);
            dataset.addValue(value, "Doanh thu", entry.getKey());
        }
        return dataset;
    }

    // HÀM MAIN
    private void updateTotalAmountTKSP() {
        thongKeSanPham();
    }
    private void updateTotalAmountTKKH() {
        thongKeKhachHang();
    }
    private void updateTotalAmount() {
        thongKeTongQuat();
        veLaiChart();
    }

    public static void main(String[] args) {
        new GUI_ThongKe();
    }
}
