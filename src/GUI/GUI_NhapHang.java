package GUI;

import ConnectDB.XuLyDatabase;
import DTO.NCC_DTO;
import BUS.NCC_BUS;
import DTO.PhieuNhap_DTO;
import BUS.PN_BUS;
import DTO.NhanVien_DTO;
import BUS.NhanVien_BUS;
import DTO.NhanVien_DTO;
import BUS.SanPham_BUS;
import DTO.SanPham_DTO;
import DTO.CTPN_DTO;
import BUS.CTPN_BUS;
import DTO.loaiSP_DTO;
import BUS.LoaiSP_BUS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import GUI.ThongTinDN;
import com.toedter.calendar.JCalendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class GUI_NhapHang extends JFrame {
    ThongTinDN dn=new ThongTinDN();
    Panel tieude = new Panel();
    Panel menu = new Panel();
    Panel chitiet = new Panel();
    JLabel lb_bentrai = new JLabel("        Chào mừng đến với hệ thống quản lí");
    JLabel lb_benphai = new JLabel(dn.getHoTen());
    JButton bt_sp = new JButton("Sản Phẩm");
    JButton bt_kh = new JButton("Khách hàng");
    JButton bt_nv = new JButton("Nhân viên");
    JButton bt_bh = new JButton("Bán hàng");
    JButton bt_km = new JButton("Khuyến mãi");
    JButton bt_duyet = new JButton("Duyệt yêu cầu");
    JButton bt_user = new JButton("User");
    JButton bt_ncc = new JButton("Nhà cung cấp");
    JButton bt_kho = new JButton("Kho hàng");
    JButton bt_tk = new JButton("Thống kê");
    JButton bt_dx = new JButton("Đăng xuất");
    ImageIcon icon = new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\276-2764901_www-agisac-gov-in-admin-png.png");
    JLabel jlb_anh = new JLabel();

    
    JLabel lb_HeadLoai = new javax.swing.JLabel();
    JLabel lb_MaLoai = new javax.swing.JLabel();
    JLabel lb_TenLoai = new javax.swing.JLabel();
    JLabel lb_SlLoai = new javax.swing.JLabel();
    JTextField tx_MaLoai = new javax.swing.JTextField();
    JTextField tx_TenLoai = new javax.swing.JTextField();
    JTextField tx_SlLoai = new javax.swing.JTextField();
    JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    JTable tb_Loai = new javax.swing.JTable();
    JButton bt_ThemLoai = new javax.swing.JButton();
    JButton bt_SuaLoai = new javax.swing.JButton();
    JButton bt_XoaLoai = new javax.swing.JButton();
    JLabel lb_HeadPN = new javax.swing.JLabel();
    JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
    JTable tb_PN = new javax.swing.JTable();
    JButton bt_ThemPN = new javax.swing.JButton();
    JButton bt_SuaPN = new javax.swing.JButton();
    JButton bt_XoaPN = new javax.swing.JButton();
    JButton bt_lich=new javax.swing.JButton();
    JLabel lb_MaPN = new javax.swing.JLabel();
    JLabel lb_MaNCC = new javax.swing.JLabel();
    JLabel lb_MaNV = new javax.swing.JLabel();
    JLabel lb_NgLap = new javax.swing.JLabel();
    JLabel lb_TongSL = new javax.swing.JLabel();
    JLabel lb_TongTien = new javax.swing.JLabel();
    JTextField tx_MaPN = new javax.swing.JTextField();
    JTextField tx_MaNCC = new javax.swing.JTextField();
    JTextField tx_MaNV = new javax.swing.JTextField();
    JTextField tx_NgLap = new javax.swing.JTextField();
    JTextField tx_TongSL = new javax.swing.JTextField();
    JTextField tx_TongTien = new javax.swing.JTextField();
    JLabel lb_HeadCTPN = new javax.swing.JLabel();
    JLabel lb_MaPN_CTPN = new javax.swing.JLabel();
    JLabel lb_MaSP = new javax.swing.JLabel();
    JLabel lb_SLSP = new javax.swing.JLabel();
    JLabel lb_GiaNhap = new javax.swing.JLabel();
    JLabel lb_ThanhTien = new javax.swing.JLabel();
    JTextField tx_MaPN_CTPN = new javax.swing.JTextField();
    JTextField tx_MaSP = new javax.swing.JTextField();
    JTextField tx_SLSP = new javax.swing.JTextField();
    JTextField tx_GiaNhap = new javax.swing.JTextField();
    JTextField tx_ThanhTien = new javax.swing.JTextField();
    JScrollPane jScrollPane3 = new javax.swing.JScrollPane();
    JTable tb_CTPN = new javax.swing.JTable();
    JButton bt_ThemCTPN = new javax.swing.JButton();
    JButton bt_SuaCTPN = new javax.swing.JButton();
    JButton bt_XoaCTPN = new javax.swing.JButton();
    JTextField tx_TKLoai = new javax.swing.JTextField();
    JTextField tx_TKPN = new javax.swing.JTextField();
    JTextField tx_TKCTPN = new javax.swing.JTextField();
    JButton bt_TKLoai = new javax.swing.JButton();
    JButton bt_TKPN = new javax.swing.JButton();
    JButton bt_TKCTPN = new javax.swing.JButton();
    JButton bt_InPN=new javax.swing.JButton();
    JComboBox cb_TKLoai = new javax.swing.JComboBox<>();
    JComboBox cb_TKPN = new javax.swing.JComboBox<>();
    JComboBox cb_TKCTPN = new javax.swing.JComboBox<>();
    JButton bt_clearLoai = new javax.swing.JButton();
    JButton bt_clearPN = new javax.swing.JButton();
    JButton bt_clearCTPN = new javax.swing.JButton();
    JButton bt_dong = new javax.swing.JButton();
    ArrayList<loaiSP_DTO> dsLoai = new ArrayList<loaiSP_DTO>();
    ArrayList<PhieuNhap_DTO> dsPN = new ArrayList<PhieuNhap_DTO>();
    ArrayList<CTPN_DTO> dsCTPN = new ArrayList<CTPN_DTO>();
    ArrayList<NhanVien_DTO> dsNV=new ArrayList<NhanVien_DTO>();
    ArrayList<SanPham_DTO> dsSP = new ArrayList<SanPham_DTO>();
    ArrayList<NCC_DTO> dsNCC = new ArrayList<NCC_DTO>();
    DefaultTableModel modelLoai = new DefaultTableModel();
    DefaultTableModel modelPN = new DefaultTableModel();
    DefaultTableModel modelCTPN = new DefaultTableModel();
    XuLyDatabase xuLyDB = null;
    JButton bt_LoaiChecked = new javax.swing.JButton();
    JButton bt_PNChecked = new javax.swing.JButton();
    JButton bt_CTPNChecked = new javax.swing.JButton();
    LoaiSP_BUS loai_BUS = new LoaiSP_BUS();
    NhanVien_BUS nv_BUS=new NhanVien_BUS();
    PN_BUS pn_BUS = new PN_BUS();
    CTPN_BUS ctpn_BUS = new CTPN_BUS();
    SanPham_BUS sp_BUS = new SanPham_BUS();
    NCC_BUS ncc_BUS = new NCC_BUS();
    private JTable TbMaNCC;
    private JTable TbMaNV;
    private JTable TbMaSP;
    private JScrollPane scrollMaNCC;
    private JScrollPane scrollMaNV;
    private JScrollPane scrollMaSP;

    public GUI_NhapHang() {

        setTitle("Quản lí kho hàng");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Tắt LayoutManager để sử dụng setBounds()
        setResizable(false);
        jlb_anh.setIcon(icon);
        jlb_anh.setHorizontalAlignment(JLabel.CENTER);
        jlb_anh.setVerticalAlignment(JLabel.CENTER);
        tieude.setBounds(150, 0, 750, 30);
        tieude.setBackground(new java.awt.Color(102, 102, 102));

        menu.setBounds(0, 0, 150, 565); // Đặt vị trí và kích thước cho panel menu
        // menu.setLayout(new GridLayout(12, 1));
        menu.setBackground(new java.awt.Color(51, 153, 255));

        // Panel chi tiết
        chitiet.setBounds(150, 30, 750, 535); // Đặt vị trí và kích thước cho panel chi tiết
        chitiet.setBackground(new java.awt.Color(204, 204, 204));

        // Đặt kích thước cho các nút trong menu
        jlb_anh.setPreferredSize(new Dimension(150, 180));
        bt_sp.setPreferredSize(new Dimension(150, 30)); // Điều chỉnh kích thước nút
        bt_kh.setPreferredSize(new Dimension(150, 30));
        bt_nv.setPreferredSize(new Dimension(150, 30));
        bt_bh.setPreferredSize(new Dimension(150, 30));
        bt_km.setPreferredSize(new Dimension(150, 30));
        bt_duyet.setPreferredSize(new Dimension(150, 30));
        bt_user.setPreferredSize(new Dimension(150, 30));
        bt_ncc.setPreferredSize(new Dimension(150, 30));
        bt_kho.setPreferredSize(new Dimension(150, 30));
        bt_tk.setPreferredSize(new Dimension(150, 30));
        bt_dx.setPreferredSize(new Dimension(100, 22));
        bt_dx.setBackground(Color.PINK);
        lb_bentrai.setForeground(Color.WHITE);
        lb_benphai.setForeground(Color.WHITE);
        lb_bentrai.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lb_benphai.setFont(new Font("Times New Roman", Font.BOLD, 14));
        Box hbox = Box.createHorizontalBox();
        hbox.add(lb_bentrai);
        hbox.add(Box.createHorizontalStrut(200));
        hbox.add(lb_benphai);
        tieude.setLayout(new BorderLayout());
        tieude.add(hbox, BorderLayout.WEST);

        // Panel menu

        bt_kho.setBackground(new java.awt.Color(153, 255, 153));
        menu.add(jlb_anh);
        menu.add(bt_sp);
        menu.add(bt_kh);
        menu.add(bt_nv);
        menu.add(bt_bh);
        menu.add(bt_km);
        menu.add(bt_duyet);
        menu.add(bt_user);
        menu.add(bt_ncc);
        menu.add(bt_kho);
        menu.add(bt_tk);
        menu.add(bt_dx);
        tx_SlLoai.setEnabled(false);
        tx_SlLoai.setDisabledTextColor(Color.GRAY);
        tx_TongSL.setEnabled(false);
        tx_TongSL.setDisabledTextColor(Color.GRAY);
        tx_TongTien.setEnabled(false);
        tx_TongTien.setDisabledTextColor(Color.GRAY);
        tx_ThanhTien.setEnabled(false);
        tx_ThanhTien.setDisabledTextColor(Color.GRAY);

        lb_HeadLoai.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_HeadLoai.setForeground(new java.awt.Color(255, 102, 0));
        lb_HeadLoai.setText("Quản lý loại");

        lb_MaLoai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_MaLoai.setForeground(new java.awt.Color(255, 102, 0));
        lb_MaLoai.setText("Mã loại: ");

        lb_TenLoai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_TenLoai.setForeground(new java.awt.Color(255, 102, 0));
        lb_TenLoai.setText("Tên loại:");

        lb_SlLoai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_SlLoai.setForeground(new java.awt.Color(255, 102, 0));
        lb_SlLoai.setText("Số lượng:");

        tb_Loai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã loại", "Tên loại", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_Loai);
        hienThiLoai();
        tb_Loai.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tb_LoaiMouseClicked(evt);
                }
        });

        bt_ThemLoai.setIcon(new javax.swing.ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-add-27.png")); // NOI18N
        bt_ThemLoai.setMaximumSize(new java.awt.Dimension(24, 24));
        bt_ThemLoai.setMinimumSize(new java.awt.Dimension(24, 24));
        bt_ThemLoai.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_ThemLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ThemLoaiActionPerformed(evt);
            }
        });

        bt_SuaLoai.setIcon(new javax.swing.ImageIcon("D:\\vietcpp\\.vscode/doan_java/Image/icons8-update-left-rotation-27.png")); // NOI18N
        bt_SuaLoai.setMaximumSize(new java.awt.Dimension(24, 24));
        bt_SuaLoai.setMinimumSize(new java.awt.Dimension(24, 24));
        bt_SuaLoai.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_SuaLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SuaLoaiActionPerformed(evt);
            }
        });

        ImageIcon anhXoa= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\Button-Delete-icon.png");
        ImageIcon anhXoa_resized = new ImageIcon(anhXoa.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_XoaLoai.setIcon(anhXoa_resized); // NOI18N
        bt_XoaLoai.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_XoaLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_XoaLoaiActionPerformed(evt);
            }
        });

        lb_HeadPN.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_HeadPN.setForeground(new java.awt.Color(255, 102, 0));
        lb_HeadPN.setText("Quản lý phiếu nhập");

        tb_PN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã PN", "Mã NV", "Mã NCC", "Ngày lập", "SL", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tb_PN);
        hienThiPN();
        //hiện thị các bảng tìm kiếm
        ViTriCuaTableMa();
        txMaMouseListener();
        TbMaNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMaNCCClick(evt);
            }
        });
        TbMaNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMaNVClick(evt);
            }
        });
        TbMaSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMaSPClick(evt);
            }
        });
        // hủy tìm kiếm
        chitiet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                scrollMaNCC.setVisible(false);
                scrollMaNV.setVisible(false);
                scrollMaSP.setVisible(false);
                tx_MaNV.setVisible(true);
                tx_NgLap.setVisible(true);
                
                tx_TongSL.setVisible(true);
                tx_SLSP.setVisible(true);
                tx_GiaNhap.setVisible(true);
            }
        });
        
        tb_PN.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tb_PNMouseClicked(evt);
                }
        });
        
        bt_ThemPN.setBackground(new java.awt.Color(255, 153, 153));
        ImageIcon anhThem= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-add-27.png");
        ImageIcon anhThem_resized = new ImageIcon(anhThem.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        bt_ThemPN.setIcon(anhThem_resized);
        bt_ThemPN.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_ThemPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ThemPNActionPerformed(evt);
            }
        });

        ImageIcon anhSua= new ImageIcon("D:\\vietcpp\\.vscode/doan_java/Image/icons8-update-left-rotation-27.png");
        ImageIcon anhSua_resized = new ImageIcon(anhSua.getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH));
        bt_SuaPN.setIcon(anhSua_resized); // NOI18N
        bt_SuaPN.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_SuaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SuaPNActionPerformed(evt);
            }
        });

        
        bt_XoaPN.setIcon(anhXoa_resized); // NOI18N
        bt_XoaPN.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_XoaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_XoaPNActionPerformed(evt);
            }
        });
        bt_lich.setBackground(new java.awt.Color(255, 204, 204));
        ImageIcon anhLich=new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\lich.jpg"); // NOI18N
        ImageIcon anhLich_resized = new ImageIcon(anhLich.getImage().getScaledInstance(28, 28, java.awt.Image.SCALE_SMOOTH));
        bt_lich.setIcon(anhLich_resized);
        bt_lich.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_lich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_lichActionPerformed(evt);
            }
        });

        lb_MaPN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_MaPN.setForeground(new java.awt.Color(255, 102, 0));
        lb_MaPN.setText("Mã PN:");

        lb_MaNCC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_MaNCC.setForeground(new java.awt.Color(255, 102, 0));
        lb_MaNCC.setText("Mã NCC:");

        lb_MaNV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_MaNV.setForeground(new java.awt.Color(255, 102, 0));
        lb_MaNV.setText("Mã NV:");

        lb_NgLap.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_NgLap.setForeground(new java.awt.Color(255, 102, 0));
        lb_NgLap.setText("Ngày lập:");
        
        lb_TongSL.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_TongSL.setForeground(new java.awt.Color(255, 102, 0));
        lb_TongSL.setText("Số lượng");


        lb_TongTien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_TongTien.setForeground(new java.awt.Color(255, 102, 0));
        lb_TongTien.setText("Tổng tiền:");

        lb_HeadCTPN.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_HeadCTPN.setForeground(new java.awt.Color(255, 102, 0));
        lb_HeadCTPN.setText("Quản lý CTPN");

        lb_MaPN_CTPN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_MaPN_CTPN.setForeground(new java.awt.Color(255, 102, 0));
        lb_MaPN_CTPN.setText("Mã PN:");

        lb_MaSP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_MaSP.setForeground(new java.awt.Color(255, 102, 0));
        lb_MaSP.setText("Mã SP:");

        lb_SLSP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_SLSP.setForeground(new java.awt.Color(255, 102, 0));
        lb_SLSP.setText("Số lượng:");

        lb_GiaNhap.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_GiaNhap.setForeground(new java.awt.Color(255, 102, 0));
        lb_GiaNhap.setText("Giá nhập:");

        lb_ThanhTien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_ThanhTien.setForeground(new java.awt.Color(255, 102, 0));
        lb_ThanhTien.setText("Thành tiền:");

        tb_CTPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã PN", "Mã SP", "Số lượng", "Giá nhập", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tb_CTPN);
        hienThiCTPN();
        tb_CTPN.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tb_CTPNMouseClicked(evt);
                }
        });

       bt_ThemCTPN.setBackground(new java.awt.Color(255, 153, 153));
        bt_ThemCTPN.setIcon(anhThem_resized);
        bt_ThemCTPN.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_ThemCTPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ThemCTPNActionPerformed(evt);
            }
        });

        bt_SuaCTPN.setIcon(anhSua_resized); // NOI18N
        bt_SuaCTPN.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_SuaCTPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SuaCTPNActionPerformed(evt);
            }
        });

        bt_XoaCTPN.setIcon(anhXoa_resized); // NOI18N
        bt_XoaCTPN.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_XoaCTPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_XoaCTPNActionPerformed(evt);
            }
        });

        bt_TKLoai.setIcon(new javax.swing.ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-google-web-search-27.png")); // NOI18N
        bt_TKLoai.setMaximumSize(new java.awt.Dimension(24, 24));
        bt_TKLoai.setMinimumSize(new java.awt.Dimension(24, 24));
        bt_TKLoai.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_TKLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_TKLoaiActionPerformed(evt);
            }
        });

        bt_TKPN.setIcon(new javax.swing.ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-google-web-search-27.png")); // NOI18N
        bt_TKPN.setMaximumSize(new java.awt.Dimension(24, 24));
        bt_TKPN.setMinimumSize(new java.awt.Dimension(24, 24));
        bt_TKPN.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_TKPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_TKPNActionPerformed(evt);
            }
        });

        bt_TKCTPN.setIcon(new javax.swing.ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-google-web-search-27.png")); // NOI18N
        bt_TKCTPN.setMaximumSize(new java.awt.Dimension(24, 24));
        bt_TKCTPN.setMinimumSize(new java.awt.Dimension(24, 24));
        bt_TKCTPN.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_TKCTPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_TKCTPNActionPerformed(evt);
            }
        });

        bt_InPN.setIcon(new javax.swing.ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-database-import-24.png")); // NOI18N
        bt_InPN.setMaximumSize(new java.awt.Dimension(24, 24));
        bt_InPN.setMinimumSize(new java.awt.Dimension(24, 24));
        bt_InPN.setPreferredSize(new java.awt.Dimension(24, 24));
         bt_InPN.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 bt_InPNActionPerformed(evt);
             }
         });
        
        cb_TKLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Tên" }));

        cb_TKPN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã PN", "Mã NV", "Mã NCC", "Ngày lập" }));
       
        cb_TKCTPN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã PN", "Mã SP" }));
        
        bt_clearLoai.setText("Clear");
        bt_clearLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_clearLoaiActionPerformed(evt);
            }
        });

        bt_clearPN.setText("Clear");
        bt_clearPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_clearPNActionPerformed(evt);
            }
        });

        bt_clearCTPN.setText("Clear");
        bt_clearCTPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_clearCTPNActionPerformed(evt);
            }
        });

        bt_dong.setText("Đóng");
        bt_dong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_dongActionPerformed(evt);
            }
        });
        
        ImageIcon anhXong= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\sign-check-icon.png");
        ImageIcon anhXong_resized = new ImageIcon(anhXong.getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH));
        bt_LoaiChecked.setIcon(anhXong_resized); // NOI18N
        bt_LoaiChecked.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_LoaiChecked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_LoaiCheckedActionPerformed(evt);
            }
        });
        tx_NgLap.setText(String.valueOf(LocalDate.now()));
        bt_PNChecked.setIcon(anhXong_resized); // NOI18N
        bt_PNChecked.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_PNChecked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_PNCheckedActionPerformed(evt);
            }
        });

        bt_CTPNChecked.setIcon(anhXong_resized); // NOI18N
        bt_CTPNChecked.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_CTPNChecked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CTPNCheckedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chitietLayout = new javax.swing.GroupLayout(chitiet);
        chitiet.setLayout(chitietLayout);
        chitietLayout.setHorizontalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chitietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lb_MaPN_CTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lb_SLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lb_MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(chitietLayout.createSequentialGroup()
                                                .addComponent(tx_MaPN_CTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(bt_ThemCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(chitietLayout.createSequentialGroup()
                                                .addComponent(tx_MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(bt_SuaCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(chitietLayout.createSequentialGroup()
                                                .addComponent(tx_SLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(bt_XoaCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addComponent(lb_GiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tx_GiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                                .addComponent(lb_ThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tx_ThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_clearCTPN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(bt_dong)
                                .addGap(12, 12, 12))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addComponent(cb_TKPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tx_TKPN, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
.addComponent(bt_TKPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bt_PNChecked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(cb_TKCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tx_TKCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_TKCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt_CTPNChecked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_SlLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_TenLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_MaLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_HeadLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tx_TenLoai, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tx_SlLoai, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_HeadPN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tx_MaLoai, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(38, 38, 38)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bt_SuaLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_ThemLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_XoaLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(bt_clearLoai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(lb_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tx_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_clearPN))
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, chitietLayout.createSequentialGroup()
.addComponent(cb_TKLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tx_TKLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_TKLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(bt_LoaiChecked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, chitietLayout.createSequentialGroup()
                                    .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(chitietLayout.createSequentialGroup()
                                            .addComponent(lb_MaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tx_MaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(chitietLayout.createSequentialGroup()
                                            .addComponent(lb_MaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tx_MaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(chitietLayout.createSequentialGroup()
                                            .addComponent(lb_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tx_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(chitietLayout.createSequentialGroup()
.addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lb_NgLap, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                                .addComponent(lb_TongSL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tx_TongSL, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(chitietLayout.createSequentialGroup()
                                                    .addComponent(tx_NgLap, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(bt_lich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(9, 9, 9)
                                    .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bt_InPN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt_XoaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt_SuaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt_ThemPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(23, 23, 23))
            .addGroup(chitietLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(lb_HeadCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        chitietLayout.setVerticalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chitietLayout.createSequentialGroup()
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addComponent(lb_HeadLoai)
                        .addGap(12, 12, 12)
.addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_ThemLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_MaLoai)
                                .addComponent(tx_MaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_SuaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_TenLoai)
                                .addComponent(tx_TenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_SlLoai)
                                .addComponent(tx_SlLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_XoaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_clearLoai)
                        .addGap(15, 15, 15)
                        .addComponent(lb_HeadPN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bt_TKPN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tx_TKPN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(cb_TKPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_PNChecked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_TKLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_TKLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tx_TKLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_LoaiChecked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(bt_ThemPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_SuaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_XoaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(bt_InPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lb_MaPN)
                                            .addComponent(tx_MaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lb_MaNCC)
                                            .addComponent(tx_MaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lb_MaNV)
                                            .addComponent(tx_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lb_NgLap)
                                            .addComponent(tx_NgLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bt_lich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lb_TongSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tx_TongSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
.addGap(0, 39, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_TongTien)
                                    .addComponent(tx_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_clearPN))
                                .addGap(12, 12, 12)))))
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addComponent(lb_HeadCTPN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_MaPN_CTPN)
                                    .addComponent(tx_MaPN_CTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_MaSP)
                                    .addComponent(tx_MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(bt_ThemCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_SuaCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
.addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_SLSP)
                                    .addComponent(tx_SLSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_GiaNhap)
                                    .addComponent(tx_GiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_ThanhTien)
                                    .addComponent(tx_ThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_clearCTPN)
                                    .addComponent(bt_dong)))
                            .addComponent(bt_XoaCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tx_TKCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_TKCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_TKCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_CTPNChecked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        // sự kiện bàn phím
        sukienEnterLoai();
        sukienEnterPN();
        sukienEnterCTPN();
        chuyenForm();
        // Thêm các panel vào JFrame
        add(tieude);
        add(menu);
        add(chitiet);

        setVisible(true);
    }
    public void chuyenForm(){
         if(dn.getQuyen().equals("ADMIN"))
        {
            bt_user.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_USER().setVisible(true);
                }
            });
            bt_dx.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            bt_kh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            bt_nv.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            bt_km.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            bt_sp.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            bt_kho.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            bt_ncc.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
            bt_bh.addActionListener(new ActionListener() {
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
            bt_tk.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                     JOptionPane.showMessageDialog(null, "Bạn là ADMIN bạn không có quyền quản lí thực thể này,bạn chỉ quản lí user!!");
                }
            });
        }
        else if(dn.getQuyen().equals("Quản lí"))
        {
            bt_user.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên quản lí bạn không có quyền quản lí thực thể này!!");
                }
            });
            bt_dx.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            bt_kh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_Khachhang().setVisible(true);
                }
            });
            bt_nv.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NhanVien().setVisible(true);
                }
            });
            bt_km.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_CTKM().setVisible(true);
                }
            });
            bt_sp.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_Sanpham().setVisible(true);
                }
            });
            bt_kho.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NhapHang().setVisible(true);
                }
            });
            bt_ncc.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NCC().setVisible(true);
                }
            });
            bt_bh.addActionListener(new ActionListener() {
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
            bt_tk.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên quản lí bạn không có quyền quản lí thực thể này!!");
                }
            });
            
        }
        else if(dn.getQuyen().equals("Nhân viên bán hàng"))
        {
            bt_user.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
            bt_dx.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            bt_kh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_Khachhang().setVisible(true);
                }
            });
            bt_nv.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
            bt_km.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_CTKM().setVisible(true);
                }
            });
            bt_sp.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_Sanpham().setVisible(true);
                }
            });
            bt_kho.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
            bt_ncc.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
            bt_bh.addActionListener(new ActionListener() {
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
            bt_tk.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "Bạn là nhân viên bán hàng bạn không có quyền quản lí thực thể này!!");
                }
            });
        }
        else
        {
            bt_user.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_USER().setVisible(true);
                }
            });
            bt_dx.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            bt_kh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new GUI_Khachhang().setVisible(true);
                }
            });
            bt_nv.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NhanVien().setVisible(true);
                }
            });
            bt_km.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_CTKM().setVisible(true);
                }
            });
            bt_sp.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_Sanpham().setVisible(true);
                }
            });
            bt_kho.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NhapHang().setVisible(true);
                }
            });
            bt_ncc.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_NCC().setVisible(true);
                }
            });
            bt_bh.addActionListener(new ActionListener() {
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
            bt_tk.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    dispose();
                    new GUI_ThongKe().setVisible(true);
                }
            });
        }
    }
    // Gọi các sự kiện
    private void bt_lichActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JDialog dialog = new JDialog(this, "Chọn ngày", true);
        dialog.setSize(200, 200);
        dialog.setLocationRelativeTo(this);
        int x = this.getX()+300 + (this.getWidth() - dialog.getWidth()) / 2;
        int y = this.getY()+150 + (this.getHeight() - dialog.getHeight()) / 2 ;

        // Đặt vị trí mới cho cuốn lịch
        dialog.setLocation(x, y);
        JCalendar calendar = new JCalendar();
        dialog.add(calendar);
        
        JButton selectButton = new JButton("Chọn");
        selectButton.addActionListener(e -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String selectedDate = dateFormat.format(calendar.getDate());
            tx_NgLap.setText(selectedDate);
            dialog.dispose();
        });
        
        dialog.add(selectButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    private void ViTriCuaTableMa()
    {
        TbMaNCC=new JTable();
        DefaultTableModel modelMaNCC = new DefaultTableModel(new Object[]{""}, 0);
        TbMaNCC.setModel(modelMaNCC);
        scrollMaNCC=new JScrollPane(TbMaNCC);
        chitiet.add(scrollMaNCC);
        scrollMaNCC.setBounds(481,232,129,60);
        scrollMaNCC.setVisible(false);
        //Mã NV
        TbMaNV=new JTable();
        DefaultTableModel modelMaNV = new DefaultTableModel(new Object[]{""}, 0);
        TbMaNV.setModel(modelMaNV);
        scrollMaNV=new JScrollPane(TbMaNV);
        chitiet.add(scrollMaNV);
        scrollMaNV.setBounds(481,258,129,60);
        scrollMaNV.setVisible(false);
        //Mã SP
        TbMaSP=new JTable();
        DefaultTableModel modelMaSP = new DefaultTableModel(new Object[]{""}, 0);
        TbMaSP.setModel(modelMaSP);
        scrollMaSP=new JScrollPane(TbMaSP);
        chitiet.add(scrollMaSP);
        scrollMaSP.setBounds(96,426,122,50);
        scrollMaSP.setVisible(false);
    }
    private void searchMaNCC(String ma)
    {
        DefaultTableModel modelMaNCC = (DefaultTableModel) TbMaNCC.getModel();
        modelMaNCC.setRowCount(0);
        for(NCC_DTO i:dsNCC)
            if(i.getMaNCC().toLowerCase().contains(ma.toLowerCase()))
                modelMaNCC.addRow(new Object[]{i.getMaNCC()});
    }
    private void searchMaNV(String ma)
    {
        DefaultTableModel modelMaNV = (DefaultTableModel) TbMaNV.getModel();
        modelMaNV.setRowCount(0);
        for(NhanVien_DTO i:dsNV)
            if(i.getMaNV().toLowerCase().contains(ma.toLowerCase()))
                modelMaNV.addRow(new Object[]{i.getMaNV()});
    }
    private void searchMaSP(String ma)
    {
        DefaultTableModel modelMaSP = (DefaultTableModel) TbMaSP.getModel();
        modelMaSP.setRowCount(0);
        for(SanPham_DTO i:dsSP)
            if(i.getMaSp().toLowerCase().contains(ma.toLowerCase()))
                modelMaSP.addRow(new Object[]{i.getMaSp()});
    }
    private void txMaMouseListener()
    {
        tx_MaNCC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Khi người dùng nhập, thực hiện tìm kiếm và hiển thị kết quả
                scrollMaNCC.setVisible(true);
                tx_MaNV.setVisible(false);
                tx_NgLap.setVisible(false);
                String searchText = tx_MaNCC.getText();
                searchMaNCC(searchText);
            }
        });
        tx_MaNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Khi người dùng nhập, thực hiện tìm kiếm và hiển thị kết quả
                scrollMaNV.setVisible(true);
                tx_NgLap.setVisible(false);
                tx_TongSL.setVisible(false);
                String searchText = tx_MaNV.getText();
                searchMaNV(searchText);
            }
        });
        tx_MaSP.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Khi người dùng nhập, thực hiện tìm kiếm và hiển thị kết quả
                scrollMaSP.setVisible(true);
                tx_SLSP.setVisible(false);
                tx_GiaNhap.setVisible(false);
                String searchText = tx_MaSP.getText();
                searchMaSP(searchText);
            }
        });
    }
    private void tableMaNCCClick(java.awt.event.MouseEvent evt)
    {
        int i=TbMaNCC.getSelectedRow();
        if(i>-1)
        {
            tx_MaNCC.setText(TbMaNCC.getValueAt(i,0).toString());
            scrollMaNCC.setVisible(false);
            tx_MaNV.setVisible(true);
            tx_NgLap.setVisible(true);
        }
    }
    private void tableMaNVClick(java.awt.event.MouseEvent evt)
    {
        int i=TbMaNV.getSelectedRow();
        if(i>-1)
        {
            tx_MaNV.setText(TbMaNV.getValueAt(i,0).toString());
            scrollMaNV.setVisible(false);
            tx_NgLap.setVisible(true);
             tx_TongSL.setVisible(true);
        }
    }
    private void tableMaSPClick(java.awt.event.MouseEvent evt)
    {
        int i=TbMaSP.getSelectedRow();
        if(i>-1)
        {
            tx_MaSP.setText(TbMaSP.getValueAt(i,0).toString());
            scrollMaSP.setVisible(false);
            tx_SLSP.setVisible(true);
            tx_GiaNhap.setVisible(true);
        }
    }
    // Hàm header
    private Vector headerLoai(Vector header){
        header.add("Mã loại");
        header.add("Tên loại");
        header.add("Số lượng");
        return header;
    }
    
    private Vector headerPN(Vector header){
        header.add("Mã PN");
        header.add("Mã NV");
        header.add("Mã NCC");
        header.add("Ngày lập");
        header.add("SL");
        header.add("Tổng tiền");
        return header;
    }
    
    private Vector headerCTPN(Vector header){
        header.add("Mã PN");
        header.add("Mã SP");
        header.add("Số lượng");
        header.add("Giá nhập");
        header.add("Thành tiền");
        return header;
    }
    
    // Hàm row
    private Vector rowLoai(Vector row, loaiSP_DTO loai){
        row.add(loai.getMaLoai());
        row.add(loai.getTenLoai());
        row.add(loai.getSoluong());
        return row;
    }
    
    private Vector rowPN(Vector row, PhieuNhap_DTO pn){
        row.add(pn.getMaPN());
        row.add(pn.getMaNV());
        row.add(pn.getMaNCC());
        //row.add(pn.getNgayLap());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String ngayLapFormatted = pn.getNgayLap().format(formatter); // Định dạng thành chuỗi theo định dạng "yyyy-MM-dd"
        row.add(ngayLapFormatted); // Thêm vào vector row
        row.add(pn.getSoLuong());
        row.add(pn.getTongTien());
        return row;
    }
    
    private Vector rowCTPN(Vector row, CTPN_DTO ctpn){
        row.add(ctpn.getMaPN());
        row.add(ctpn.getMaSP());
        row.add(ctpn.getSoLuong());
        row.add(ctpn.getGiaNhap());
        row.add(ctpn.getThanhTien());
        return row;
    }
    
    // Hàm hiển thị
    private void hienThiLoai() {
        // TODO add your handling code here:
        if(dsLoai.isEmpty()) dsLoai = loai_BUS.getListLoai();
        if(dsSP.isEmpty()) dsSP=sp_BUS.getList();
        if(!dsLoai.isEmpty()){
            Vector header=new Vector();
            header = headerLoai(header);   
            modelLoai = new DefaultTableModel(header, 0);

            for(loaiSP_DTO loai:dsLoai)
            {
               Vector row = new Vector();
               row = rowLoai(row,loai);
               modelLoai.addRow(row); 
            }
            tb_Loai.setModel(modelLoai);
       }
    }
    
    private void hienThiPN() {
        // TODO add your handling code here:
        if(dsPN.isEmpty()) dsPN = pn_BUS.getListPN();
        if(dsNV.isEmpty()) 
        {
            for(NhanVien_DTO nv:nv_BUS.getList())
                if(nv.getChucvu().equals("Quản lí")|| nv.getChucvu().equals("Quản lí doanh nghiệp"))
                    dsNV.add(nv);
        }
        if(dsNCC.isEmpty()) dsNCC=ncc_BUS.getListNCC();
        if(!dsPN.isEmpty()){
            Vector header = new Vector();
            header = headerPN(header);
            modelPN = new DefaultTableModel(header,0);
            
            for(PhieuNhap_DTO pn:dsPN){
                Vector row = new Vector();
                row = rowPN(row,pn);
                modelPN.addRow(row);
            }
            tb_PN.setModel(modelPN);
        }
    }
    
    private void hienThiCTPN() {
        // TODO add your handling code here:
        if(dsCTPN.isEmpty()) dsCTPN = ctpn_BUS.getListCTPN();
        if(!dsCTPN.isEmpty()){
            Vector header = new Vector();
            header = headerCTPN(header);
            modelCTPN = new DefaultTableModel(header,0);
            
            for(CTPN_DTO ctpn:dsCTPN){
                Vector row = new Vector();
                row = rowCTPN(row,ctpn);
                modelCTPN.addRow(row);
            }
            tb_CTPN.setModel(modelCTPN);
        }
    }
    
    // Hàm click bảng
    private void tb_LoaiMouseClicked(java.awt.event.MouseEvent evt){
        // TODO add your handling code here:
        tx_MaLoai.setEnabled(false);
        tx_MaLoai.setBackground(Color.GRAY);
        int i = tb_Loai.getSelectedRow();
        tx_MaLoai.setText(tb_Loai.getModel().getValueAt(i, 0).toString());
        tx_TenLoai.setText(tb_Loai.getModel().getValueAt(i, 1).toString());
        tx_SlLoai.setText(tb_Loai.getModel().getValueAt(i, 2).toString());
    }
    
    private void tb_PNMouseClicked(java.awt.event.MouseEvent evt){
        int i = tb_PN.getSelectedRow();
        if(i>=0 && i<dsPN.size()){
            PhieuNhap_DTO pn = new PhieuNhap_DTO();
            pn = dsPN.get(i);
            CTPN_DTO ctpn = new CTPN_DTO();
            tx_MaPN.setEnabled(false);
            tx_MaPN.setBackground(Color.GRAY);
            tx_MaPN.setText(tb_PN.getModel().getValueAt(i, 0).toString());
            tx_MaNCC.setText(tb_PN.getModel().getValueAt(i, 1).toString());
            tx_MaNV.setText(tb_PN.getModel().getValueAt(i, 2).toString());
            tx_NgLap.setText(tb_PN.getModel().getValueAt(i, 3).toString());
            tx_TongSL.setText(tb_PN.getModel().getValueAt(i, 4).toString());
            tx_TongTien.setText(tb_PN.getModel().getValueAt(i, 5).toString());
//            DefaultTableModel modelPNTam = new DefaultTableModel();
//            modelPNTam =pn_BUS.TKPN(dsPN, pn.getMaPN(), modelPNTam);
            DefaultTableModel modelCTPNTam = new DefaultTableModel();
            modelCTPNTam = ctpn_BUS.TKCTPN(dsCTPN, pn.getMaPN(), modelCTPNTam);
//            tb_PN.setModel(modelPNTam);
            tb_CTPN.setModel(modelCTPNTam);
        }
    }
    
    private void tb_CTPNMouseClicked(java.awt.event.MouseEvent evt){
        // TODO add your handling code here:
        tx_MaPN_CTPN.setEnabled(false);
        tx_MaPN_CTPN.setBackground(Color.GRAY);
        tx_MaSP.setEnabled(false);
        tx_MaSP.setBackground(Color.GRAY);
        tx_ThanhTien.setEnabled(false);
//        tx_ThanhTien.setBackground(Color.GRAY);
        int i = tb_CTPN.getSelectedRow();
        tx_MaPN_CTPN.setText(tb_CTPN.getModel().getValueAt(i, 0).toString());
        tx_MaSP.setText(tb_CTPN.getModel().getValueAt(i, 1).toString());
        tx_SLSP.setText(tb_CTPN.getModel().getValueAt(i, 2).toString());
        tx_GiaNhap.setText(tb_CTPN.getModel().getValueAt(i, 3).toString());
        tx_ThanhTien.setText(tb_CTPN.getModel().getValueAt(i, 4).toString());
    }
    
    private NhanVien_DTO getNhanVien(String ma){
        dsNV = nv_BUS.getList();
        for(NhanVien_DTO i:dsNV)
            if(i.getMaNV().equals(ma))
                return i;
        return null;
    }
    // Hàm thêm
    private boolean checkChucVu(String ma){
        NhanVien_DTO nv=new NhanVien_DTO();
        nv=getNhanVien(ma);
        if(nv.getChucvu().equals("Quản lí") || nv.getChucvu().equals("Quản lí doanh nghiệp"))
            return true;
        return false;
    }
    
    private boolean checkMaSP(String ma){
        for(SanPham_DTO i:dsSP)
            if(i.getMaSp().equals(ma))
                return true;
        return false;
    }
    
    private SanPham_DTO getSanPham(String ma){
        for(SanPham_DTO i:dsSP)
            if(i.getMaSp().equals(ma))
                return i;
        return null;
    }
    
    private boolean checkMaNCC(String ma){
        dsNCC = ncc_BUS.getListNCC();
        for(NCC_DTO i:dsNCC)
            if(i.getMaNCC().equals(ma))
                return true;
            return false;
    }
    
    private void bt_ThemLoaiActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (tx_MaLoai.getText().isEmpty() || tx_TenLoai.getText().isEmpty() || tx_SlLoai.getText().isEmpty())
            checkNhapLoai();
        else {
            if (checkMaLoai(dsLoai, tx_MaLoai.getText()) != true) {
                JOptionPane.showMessageDialog(this, "Mã bạn nhập đã có trong cửa hàng vui lòng nhập lại!");
                tx_MaLoai.setText("");
                tx_MaLoai.requestFocus();
            } else if (tx_MaLoai.getText().length() > 10) {
                JOptionPane.showMessageDialog(this,"Mã bạn nhập lớn hơn giới hạn cho phép vui lòng nhập mã có độ lớn<10!");
                tx_MaLoai.setText("");
                tx_MaLoai.requestFocus();
            } else {
                try {
                    loaiSP_DTO loai = new loaiSP_DTO();
                    loai.setMaLoai(tx_MaLoai.getText());
                    loai.setTenLoai(tx_TenLoai.getText());
                    loai.setSoluong(Integer.parseInt(tx_SlLoai.getText()));
                    dsLoai = loai_BUS.Them(loai);
                    Vector header = new Vector();
                    header = headerLoai(header);
                    if (modelLoai.getRowCount() == 0) {
                        modelLoai = new DefaultTableModel(header, 0);
                    }

                    Vector row = new Vector();
                    row = rowLoai(row, dsLoai.get(dsLoai.size() - 1));
                    modelLoai.addRow(row);
                    tb_Loai.setModel(modelLoai);
                    JOptionPane.showMessageDialog(this, "Thêm Loại có mã " + tx_MaLoai.getText() + " thành công");
                    bt_clearLoaiActionPerformed(evt);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
                }
            }
        }
    }

    private void bt_InPNActionPerformed(java.awt.event.ActionEvent evt) {
        int i = tb_PN.getSelectedRow();
        if (i >= 0 && i < dsPN.size()) {
            PhieuNhap_DTO pn = new PhieuNhap_DTO();
            pn = dsPN.get(i);
            pn_BUS.In("PhieuNhap.txt", pn, dsCTPN, dsSP, dsNV, dsNCC);

        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn đối tượng in!!!");
        }

    }

    private void bt_ThemPNActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (tx_MaPN.getText().isEmpty() || tx_MaNCC.getText().isEmpty() || tx_MaNV.getText().isEmpty()
                || tx_NgLap.getText().isEmpty())
            checkNhapPN();
        else {
            if (checkMaPN(dsPN, tx_MaPN.getText()) != true) {
                JOptionPane.showMessageDialog(this, "Mã bạn nhập đã có trong cửa hàng vui lòng nhập lại!");
                tx_MaPN.setText("");
                tx_MaPN.requestFocus();
            } else if (tx_MaPN.getText().length() > 10) {
                JOptionPane.showMessageDialog(this,"Mã bạn nhập lớn hơn giới hạn cho phép vui lòng nhập mã có độ lớn<10!");
                tx_MaPN.setText("");
                tx_MaPN.requestFocus();
            } else if (checkMaNCC(tx_MaNCC.getText()) != true) {
                JOptionPane.showMessageDialog(this, "Mã NCC bạn nhập chưa có trong cửa hàng!! Hãy nhập mã khác");
                tx_MaNCC.setText("");
                tx_MaNCC.requestFocus();
            } else if (checkChucVu(tx_MaNV.getText()) != true) {
                JOptionPane.showMessageDialog(this, "Mã NV nhập hàng phải là quản lý hoặc là quản lý doanh nghiệp!!!");
                tx_MaNV.setText("");
                tx_MaNV.requestFocus();
            } else {
                try {
                    LocalDate localDate = null;
                    try {
                        // Định dạng của chuỗi ngày tháng
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        // Chuyển đổi chuỗi thành LocalDate
                        localDate = LocalDate.parse(tx_NgLap.getText(), formatter);
                    } catch (DateTimeParseException e) {
                        JOptionPane.showMessageDialog(this, "Bạn nhập ngày lập sai hãy nhập theo form yyyy-MM-dd");
                        tx_NgLap.setText("");
                        tx_NgLap.requestFocus();
                        return;
                    }

                    PhieuNhap_DTO pn = new PhieuNhap_DTO();
                    pn.setMaPN(tx_MaPN.getText());
                    pn.setMaNV(tx_MaNV.getText());
                    pn.setMaNCC(tx_MaNCC.getText());
                    pn.setNgayLap(localDate.atStartOfDay());
                    pn.setSoLuong(0);
                    pn.setTongTien(0);
                    dsPN = pn_BUS.Them(pn);
                    Vector header = new Vector();
                    header = headerPN(header);
                    if (modelPN.getRowCount() == 0) {
                        modelPN = new DefaultTableModel(header, 0);
                    }
                    Vector row = new Vector();
                    row = rowPN(row, dsPN.get(dsPN.size() - 1));
                    modelPN.addRow(row);
                    tb_PN.setModel(modelPN);
                    // JOptionPane.showMessageDialog(this, "Cập nhật dữ liệu thành công! " + "Số
                    // lượng và Tổng tiền set về 0");

                    JOptionPane.showMessageDialog(this, "Thêm PN có mã " + tx_MaPN.getText() + " thành công");
                    bt_clearPNActionPerformed(evt);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
                }
            }
        }
    }

    private void bt_ThemCTPNActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (tx_MaPN_CTPN.getText().isEmpty() || tx_MaSP.getText().isEmpty() || tx_SLSP.getText().isEmpty()
                || tx_GiaNhap.getText().isEmpty())
            checkNhapCTPN();
        else {
            if (checkCTPN(dsCTPN, tx_MaPN_CTPN.getText(), tx_MaSP.getText()) != true) {
                JOptionPane.showMessageDialog(this, "Mã bạn nhập đã có trong cửa hàng vui lòng nhập lại!");
                tx_MaPN_CTPN.setText("");
                tx_MaPN_CTPN.requestFocus();
                tx_MaSP.setText("");
                tx_MaSP.requestFocus();
            } else if (checkMaSP(tx_MaSP.getText()) != true) {
                JOptionPane.showMessageDialog(this, "Mã SP bạn nhập chưa có trong của hàng");
                tx_MaSP.setText("");
                tx_MaSP.requestFocus();
            } else if (checkMaPN(dsPN, tx_MaPN_CTPN.getText()) == true) {
                JOptionPane.showMessageDialog(this, "Mã PN bạn nhập chưa có trong của hàng");
                tx_MaPN_CTPN.setText("");
                tx_MaPN_CTPN.requestFocus();
            } else {
                try {
                    CTPN_DTO ctpn = new CTPN_DTO();
                    ctpn.setMaPN(tx_MaPN_CTPN.getText());
                    ctpn.setMaSP(tx_MaSP.getText());
                    ctpn.setSoLuong(Integer.parseInt(tx_SLSP.getText()));
                    ctpn.setGiaNhap(Float.parseFloat(tx_GiaNhap.getText()));
                    ctpn.setThanhTien(Double.parseDouble(String.valueOf(Integer.parseInt(tx_SLSP.getText()) * Float.parseFloat(tx_GiaNhap.getText()))));
                    Vector header = new Vector();
                    header = headerCTPN(header);
                    if (modelCTPN.getRowCount() == 0) {
                        modelCTPN = new DefaultTableModel(header, 0);
                    }
                    Vector row = new Vector();
                    row = rowCTPN(row, dsCTPN.get(dsCTPN.size() - 1));
                    modelCTPN.addRow(row);
                    tb_CTPN.setModel(modelCTPN);
                    updateVeSPKhiThem(tx_MaPN_CTPN.getText(), tx_MaSP.getText(), Integer.parseInt(tx_SLSP.getText()),Float.parseFloat(tx_GiaNhap.getText()));

                    JOptionPane.showMessageDialog(this,"Thêm CTPN với mã PN " + tx_MaPN_CTPN.getText() + " thành công");
                    bt_clearCTPNActionPerformed(evt);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
                }
            }
        }
    }
    
    private loaiSP_DTO getLoai(String ma){
        for(loaiSP_DTO i:dsLoai)
            if(i.getMaLoai().equals(ma))
                return i;
        return null;
    }
    
    private PhieuNhap_DTO getPN(String ma){
        for(PhieuNhap_DTO i:dsPN)
            if(i.getMaPN().equals(ma))
                return i;
        return null;
    }
    
    private void updateVeSPKhiThem(String maPN,String maSP,int sl, float dongia){
        SanPham_DTO sp=new SanPham_DTO();
        
        sp=getSanPham(maSP);
        int i=dsSP.indexOf(sp);
        //update sản phẩm
        sp.setSoluong(sp.getSoluong()+sl);
        dsSP=sp_BUS.SuaSP(i,sp);
        //update loại
        loaiSP_DTO loai=new loaiSP_DTO();
        loai=getLoai(sp.getMaLoai());
        int j=dsLoai.indexOf(loai);
        loai.setSoluong(sl+loai.getSoluong());
        dsLoai=loai_BUS.Sua(j,loai);
        modelLoai.setValueAt(loai.getSoluong()+sl, j, 2);
        tb_Loai.setModel(modelLoai);
        //update phiếu nhập
        PhieuNhap_DTO pn=new PhieuNhap_DTO();
        pn=getPN(maPN);
        int k=dsPN.indexOf(pn);
        Double tt=Double.parseDouble(String.valueOf(dongia*sl));
        pn.setSoLuong(pn.getSoLuong()+sl);
        pn.setTongTien(pn.getTongTien()+tt);
        dsPN=pn_BUS.Sua(k,pn);
        modelPN.setValueAt(pn.getSoLuong()+sl, k, 4);
        modelPN.setValueAt(pn.getTongTien()+tt, k, 5);
        tb_PN.setModel(modelPN);
    }
    
    // Hàm sửa 
    private boolean checkMaLoai(ArrayList<loaiSP_DTO> ds,String ma){
        for(loaiSP_DTO i:ds){
            if(i.getMaLoai().equals(ma))
                return false;
        }
        return true;
    }

    private void checkNhapLoai() {
        if (tx_MaLoai.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã loại!");
            tx_MaLoai.requestFocus();
        } else if (tx_TenLoai.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên loại!");
            tx_TenLoai.requestFocus();
        } else if (tx_SlLoai.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng loại!");
            tx_SlLoai.requestFocus();
        }
    }
    
    private void bt_SuaLoaiActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = tb_Loai.getSelectedRow();
        if (i >= 0 && i < dsLoai.size()) {
            // ArrayList<loaiSP_DTO> dsLoaiTam = new ArrayList<>(dsLoai);
            // dsLoaiTam.remove(i);
            if (tx_MaLoai.getText().isEmpty() || tx_TenLoai.getText().isEmpty() || tx_SlLoai.getText().isEmpty())
                checkNhapLoai();
            else {
                if (checkMaLoai(dsLoai, tx_MaLoai.getText()) != true) {
                    JOptionPane.showMessageDialog(this, "Mã bạn nhập đã có trong cửa hàng vui lòng nhập lại!");
                    tx_MaLoai.setText("");
                    tx_MaLoai.requestFocus();
                } else if (tx_MaLoai.getText().length() > 10) {
                    JOptionPane.showMessageDialog(this,"Mã bạn nhập lớn hơn giới hạn cho phép vui lòng nhập mã có độ lớn<10!");
                    tx_MaLoai.setText("");
                    tx_MaLoai.requestFocus();
                } else {
                    loaiSP_DTO loai = new loaiSP_DTO();
                    loai.setMaLoai(tx_MaLoai.getText());
                    loai.setTenLoai(tx_TenLoai.getText());
                    loai.setSoluong(Integer.parseInt(tx_SlLoai.getText()));
                    dsLoai = loai_BUS.Sua(i, loai);
                    modelLoai.setValueAt(tx_MaLoai.getText(), i, 0);
                    modelLoai.setValueAt(tx_TenLoai.getText(), i, 1);
                    modelLoai.setValueAt(Integer.parseInt(tx_SlLoai.getText()), i, 2);
                    tb_Loai.setModel(modelLoai);

                    JOptionPane.showMessageDialog(this, "Sửa loại có mã " + tx_MaLoai.getText() + " thành công");
                    bt_clearLoaiActionPerformed(evt);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Đã vượt quá độ lớn của danh sách");
        }
    }
    
    private boolean checkMaPN(ArrayList<PhieuNhap_DTO> ds,String ma){
        for(PhieuNhap_DTO i:ds){
            if(i.getMaPN().equals(ma))
                return false;
        }
        return true;
    }

    private void checkNhapPN() {
        if (tx_MaPN.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã phiếu nhập!");
            tx_MaPN.requestFocus();
        } else if (tx_MaNCC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhà cung cấp!");
            tx_MaNCC.requestFocus();
        } else if (tx_MaNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên!");
            tx_MaNV.requestFocus();
        } else if (tx_NgLap.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày lập!");
            tx_NgLap.requestFocus();
        } else if (tx_TongSL.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng phiếu nhập!");
            tx_TongSL.requestFocus();
        } else if (tx_TongTien.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tông tiền!");
            tx_TongTien.requestFocus();
        }
        
    }
    
    private void bt_SuaPNActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = tb_PN.getSelectedRow();
        if (i >= 0 && i < dsPN.size()) {
            LocalDate localDate = null;
            if (tx_MaPN.getText().isEmpty() || tx_MaNCC.getText().isEmpty() || tx_MaNV.getText().isEmpty()
                    || tx_TongSL.getText().isEmpty() || tx_NgLap.getText().isEmpty()
                    || tx_TongTien.getText().isEmpty()) {
                checkNhapPN();
            } else {
                try {
                    // Định dạng của chuỗi ngày tháng
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    // Chuyển đổi chuỗi thành LocalDate
                    localDate = LocalDate.parse(tx_NgLap.getText(), formatter);
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(this, "Bạn nhập ngày lập sai hãy nhập theo form yyyy-MM-dd");
                    tx_NgLap.setText("");
                    tx_NgLap.requestFocus();
                    return;
                }

                PhieuNhap_DTO pn = new PhieuNhap_DTO();
                pn.setMaPN(tx_MaPN.getText());
                pn.setMaNV(tx_MaNV.getText());
                pn.setMaNCC(tx_MaNCC.getText());
                pn.setNgayLap(localDate.atStartOfDay());
                pn.setSoLuong(Integer.parseInt(tx_TongSL.getText()));
                pn.setTongTien(Double.parseDouble(tx_TongTien.getText()));
                dsPN = pn_BUS.Sua(i, pn);
                // PhieuNhap_DTO pn = dsPN.get(i);
                modelPN.setValueAt(pn.getMaPN(), i, 0);
                modelPN.setValueAt(pn.getMaNV(), i, 1);
                modelPN.setValueAt(pn.getMaNCC(), i, 2);
                modelPN.setValueAt(pn.getNgayLap(), i, 3);
                modelPN.setValueAt(pn.getSoLuong(), i, 4);
                modelPN.setValueAt(pn.getTongTien(), i, 5);
                tb_PN.setModel(modelPN);

                JOptionPane.showMessageDialog(this, "Sửa PN có mã " + tx_MaPN.getText() + " thành công");
                bt_clearPNActionPerformed(evt);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Đã vượt quá độ lớn của danh sách");
        }
    }
    
    private boolean checkCTPN(ArrayList<CTPN_DTO> ds,String ma1, String ma2){
        for(CTPN_DTO i:ds){
            if(i.getMaPN().equals(ma1) && i.getMaSP().equals(ma2))
                return false;
        }
        return true;
    }
    

    private void checkNhapCTPN() {
        if (tx_MaPN_CTPN.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã phiếu nhập!");
            tx_MaPN_CTPN.requestFocus();
        } else if (tx_MaSP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm!");
            tx_MaSP.requestFocus();
        } else if (tx_SLSP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng sản phẩm!");
            tx_SLSP.requestFocus();
        } else if (tx_GiaNhap.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá nhập!");
            tx_GiaNhap.requestFocus();
        } else if (tx_ThanhTien.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thanh tiền!");
            tx_ThanhTien.requestFocus();
        }
    }
    
    private void bt_SuaCTPNActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        int i = tb_CTPN.getSelectedRow();
        if (i >= 0 && i < dsCTPN.size()) {
            ArrayList<CTPN_DTO> dsCTPNTam = new ArrayList<>(dsCTPN);
            dsCTPNTam.remove(i);
            if (tx_MaPN_CTPN.getText().isEmpty() || tx_MaSP.getText().isEmpty() || tx_SLSP.getText().isEmpty()
                    || tx_GiaNhap.getText().isEmpty() || tx_ThanhTien.getText().isEmpty())
                checkNhapCTPN();
            else {
                if (checkCTPN(dsCTPNTam, tx_MaPN_CTPN.getText(), tx_MaSP.getText()) != true) {
                    JOptionPane.showMessageDialog(this, "Mã bạn nhập đã có trong cửa hàng vui lòng nhập lại!");
                    tx_MaPN_CTPN.setText("");
                    tx_MaSP.setText("");
                    tx_MaPN_CTPN.requestFocus();
                    tx_MaSP.requestFocus();
                } else if (tx_MaPN_CTPN.getText().length() > 10 && tx_MaSP.getText().length() > 10) {
                    JOptionPane.showMessageDialog(this,"Mã bạn nhập lớn hơn giới hạn cho phép vui lòng nhập mã có độ lớn<10!");
                    tx_MaPN_CTPN.setText("");
                    tx_MaSP.setText("");
                    tx_MaPN_CTPN.requestFocus();
                    tx_MaSP.requestFocus();
                } else {
                    if (!dsCTPN.isEmpty()) {
                        CTPN_DTO ctpn = new CTPN_DTO();
                        ctpn.setMaPN(tx_MaPN_CTPN.getText());
                        ctpn.setMaSP(tx_MaSP.getText());
                        ctpn.setSoLuong(Integer.parseInt(tx_SLSP.getText()));
                        ctpn.setGiaNhap(Float.parseFloat(tx_GiaNhap.getText()));
                        ctpn.setThanhTien(ctpn.getSoLuong() * ctpn.getGiaNhap());

                        CTPN_DTO ctcu = dsCTPN.get(i);
                        int slcu = ctcu.getSoLuong();
                        float dgcu = ctcu.getGiaNhap();
                        String ma = tx_MaPN_CTPN.getText();
                        dsCTPN = ctpn_BUS.Sua(i, ctpn);
                        // CTPN_DTO ctpn = dsCTPN.get(i);
                        modelCTPN.setValueAt(ctpn.getMaPN(), i, 0);
                        modelCTPN.setValueAt(ctpn.getMaSP(), i, 1);
                        modelCTPN.setValueAt(ctpn.getSoLuong(), i, 2);
                        modelCTPN.setValueAt(tx_GiaNhap.getText(), i, 3);
                        modelCTPN.setValueAt(ctpn.getThanhTien(), i, 4);
                        tb_CTPN.setModel(modelCTPN);
                        updateVeSPKhiSua(tx_MaPN_CTPN.getText(), tx_MaSP.getText(), Integer.parseInt(tx_SLSP.getText()),
                                Float.parseFloat(tx_GiaNhap.getText()), slcu, dgcu);

                        double ttMoi = dsCTPN.get(i).getSoLuong() * dsCTPN.get(i).getGiaNhap();
                        System.out.print(dsCTPN.get(i).getThanhTien());

                        JOptionPane.showMessageDialog(this,"Sửa CTPN có mã PN là " + tx_MaPN_CTPN.getText() + " thành công");
                        bt_clearCTPNActionPerformed(evt);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Đã vượt quá độ lớn của danh sách");
        }
    }
    private void updateVeSPKhiSua(String maPN,String maSP,int sl, float dongia,int slcu,float dgiacu){
        SanPham_DTO sp=new SanPham_DTO();
        
        sp=getSanPham(maSP);
        int i=dsSP.indexOf(sp);
        //update sản phẩm
        sp.setSoluong(sp.getSoluong()-slcu+sl);
        dsSP=sp_BUS.SuaSP(i,sp);
        //update loại
        loaiSP_DTO loai=new loaiSP_DTO();
        loai=getLoai(sp.getMaLoai());
        int j=dsLoai.indexOf(loai);
        loai.setSoluong(loai.getSoluong()+sl-slcu);
        dsLoai=loai_BUS.Sua(j, loai );
        modelLoai.setValueAt(loai.getSoluong()+sl-slcu, j, 2);
        tb_Loai.setModel(modelLoai);
        //update phiếu nhập
        PhieuNhap_DTO pn=new PhieuNhap_DTO();
        pn=getPN(maPN);
        int k=dsPN.indexOf(pn);
        Double tt=Double.parseDouble(String.valueOf(dongia*sl));
        pn.setSoLuong(pn.getSoLuong()+sl-slcu);
        pn.setTongTien(pn.getTongTien()+tt-(slcu*dgiacu));
        dsPN=pn_BUS.Sua(k, pn);
        modelPN.setValueAt(pn.getSoLuong()+sl-slcu, k, 4);
        modelPN.setValueAt(pn.getTongTien()+tt-(slcu*dgiacu), k, 5);
        tb_PN.setModel(modelPN);
    }
    // Hàm xóa
    private void bt_XoaLoaiActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        int i = tb_Loai.getSelectedRow();
        if(i>=0 &&i< dsLoai.size())
        {
            String ma = tx_MaLoai.getText();
            try
            {
                dsLoai = loai_BUS.Xoa(i, ma);
                modelLoai.removeRow(i);
                tb_Loai.setModel(modelLoai);
                
                JOptionPane.showMessageDialog(this, "Bạn đã xoá Loại có mã "+tx_MaLoai.getText());
                bt_clearLoaiActionPerformed(evt);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
            }  
            
        }
    }
    
    private void bt_XoaPNActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        int i = tb_PN.getSelectedRow();
        if(i>=0 &&i< dsPN.size())
        {
            String ma = tx_MaPN.getText();
            try
            {
                dsPN = pn_BUS.Xoa(i, ma);
                modelPN.removeRow(i);
                tb_PN.setModel(modelPN);
                for(int j=0;j<dsCTPN.size();j++)
                {
                    if(dsCTPN.get(j).getMaPN().equals(ma))
                    {
                        dsCTPN=ctpn_BUS.Xoa(j, ma, dsCTPN.get(j).getMaSP());
                        modelCTPN.removeRow(j);
                        j--;
                    }
                }
                tb_CTPN.setModel(modelCTPN);
               
                JOptionPane.showMessageDialog(this, "Bạn đã xóa PN có mã "+tx_MaPN.getText());
                 bt_clearPNActionPerformed(evt);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
            }  
            
        }
    }
    
    private void bt_XoaCTPNActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        int i = tb_CTPN.getSelectedRow();
        if(i>=0 &&i< dsCTPN.size())
        {
            String maPN = tx_MaPN_CTPN.getText();
            String maSP = tx_MaSP.getText();
            try
            {
                dsCTPN = ctpn_BUS.Xoa(i, maPN, maSP);
                modelCTPN.removeRow(i);
                tb_CTPN.setModel(modelCTPN);
                updateVeSPKhiXoa(tx_MaPN_CTPN.getText(),tx_MaSP.getText(),Integer.parseInt(tx_SLSP.getText()),Float.parseFloat(tx_GiaNhap.getText()));
                
                JOptionPane.showMessageDialog(this, "Bạn đã xóa CTPN có mã PN là "+tx_MaPN_CTPN.getText());
                bt_clearCTPNActionPerformed(evt);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
            }  
            
        }
    }
    private void updateVeSPKhiXoa(String maPN,String maSP,int sl, float dongia){
        SanPham_DTO sp=new SanPham_DTO();
        
        sp=getSanPham(maSP);
        int i=dsSP.indexOf(sp);
        sp.setSoluong(sp.getSoluong()-sl);
        //update sản phẩm
        String path="";
        dsSP=sp_BUS.SuaSP(i,sp);
        //update loại
        loaiSP_DTO loai=new loaiSP_DTO();
        loai=getLoai(sp.getMaLoai());
        int j=dsLoai.indexOf(loai);
        loai.setSoluong(loai.getSoluong()-sl);
        dsLoai=loai_BUS.Sua(j,loai);
        modelLoai.setValueAt(loai.getSoluong()-sl, j, 2);
        tb_Loai.setModel(modelLoai);
        //update phiếu nhập
        PhieuNhap_DTO pn=new PhieuNhap_DTO();
        pn=getPN(maPN);
        int k=dsPN.indexOf(pn);
        Double tt=Double.parseDouble(String.valueOf(dongia*sl));
        pn.setSoLuong(pn.getSoLuong()-sl);
        pn.setTongTien(pn.getTongTien()-tt);
        dsPN=pn_BUS.Sua(k, pn);
        modelPN.setValueAt(pn.getSoLuong()-sl, k, 4);
        modelPN.setValueAt(pn.getTongTien()-tt, k, 5);
        tb_PN.setModel(modelPN);
    }
    // Hàm clear
    private void bt_clearLoaiActionPerformed(java.awt.event.ActionEvent evt) {  
        tx_MaLoai.setEnabled(true);
        tx_MaLoai.setBackground(Color.WHITE);
        tx_MaLoai.setText("");
        tx_TenLoai.setText("");
        tx_SlLoai.setText("");
        tx_TKLoai.setText("");
    }
    
    private void bt_clearPNActionPerformed(java.awt.event.ActionEvent evt) {
        tx_MaPN.setEnabled(true);
        tx_MaPN.setBackground(Color.WHITE);
        tx_MaPN.setText("");
        tx_MaNCC.setText("");
        tx_MaNV.setText("");
        tx_NgLap.setText(String.valueOf(LocalDate.now()));
        tx_TongSL.setText("");
        tx_TongTien.setText("");
        tx_TKPN.setText("");
    }
    
    private void bt_clearCTPNActionPerformed(java.awt.event.ActionEvent evt) {
        tx_MaPN_CTPN.setEnabled(true);
        tx_MaPN_CTPN.setBackground(Color.WHITE);
        tx_MaSP.setEnabled(true);
        tx_MaSP.setBackground(Color.WHITE);
        tx_MaPN_CTPN.setText("");
        tx_MaSP.setText("");
        tx_SLSP.setText("");
        tx_GiaNhap.setText("");
        tx_ThanhTien.setText("");
        tx_TKCTPN.setText("");
        tx_MaPN_CTPN.requestFocus();
    }
    
    // Hàm đóng
    private void bt_dongActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        System.exit(0);
    }
    
    // Hàm tim kiếm
    private void bt_TKLoaiActionPerformed(java.awt.event.ActionEvent evt){
        if (tx_TKLoai.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy nhập nội dung cần tìm!!!");
            tx_TKLoai.requestFocus();
        } else {
            DefaultTableModel modelLoaiTam = new DefaultTableModel();

            modelLoaiTam = loai_BUS.TimKiem(String.valueOf(cb_TKLoai.getSelectedItem()), tx_TKLoai.getText());
            if (modelLoaiTam.getRowCount() > 0) {
                tb_Loai.setModel(modelLoaiTam);
                bt_clearLoaiActionPerformed(evt);
            } else {
                JOptionPane.showMessageDialog(this, "Cửa hàng không có thứ bạn tìm");
            }
            tx_TKLoai.setText("");
        }
    }
    
    private void bt_TKPNActionPerformed(java.awt.event.ActionEvent evt){
        if (tx_TKPN.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn hãy nhập thứ bạn muốn tìm kiếm!");
            tx_TKPN.requestFocus();
        } else {
            DefaultTableModel modelPNTam = new DefaultTableModel();

            modelPNTam = pn_BUS.TimKiem(String.valueOf(cb_TKPN.getSelectedItem()), tx_TKPN.getText());
            if (modelPNTam.getRowCount() > 0) {
                tb_PN.setModel(modelPNTam);
                bt_clearPNActionPerformed(evt);
            } else {
                JOptionPane.showMessageDialog(this, "Cửa hàng không có mục bạn tìm kiếm!");
            }
            tx_TKPN.setText("");
        }
    }
    
    private void bt_TKCTPNActionPerformed(java.awt.event.ActionEvent evt){
        if (tx_TKCTPN.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy nhập thông tin bạn muốn tìm kiếm!");
        } else {
            DefaultTableModel modelCTPNTam = new DefaultTableModel();

            modelCTPNTam = ctpn_BUS.TimKiem(String.valueOf(cb_TKCTPN.getSelectedItem()), tx_TKCTPN.getText());
            if (modelCTPNTam.getRowCount() > 0) {
                tb_CTPN.setModel(modelCTPNTam);
                bt_clearCTPNActionPerformed(evt);
            } else {
                JOptionPane.showMessageDialog(this, "Mục bạn tìm kiếm không tồn tại trong của hàng!!!");
            }
            tx_TKCTPN.setText("");
        }
    }
    
    // Hàm Checked khi tìm kiếm xog
    private void bt_LoaiCheckedActionPerformed(java.awt.event.ActionEvent evt){
        tb_Loai.setModel(modelLoai);
    }
    
    private void bt_PNCheckedActionPerformed(java.awt.event.ActionEvent evt){
        tb_PN.setModel(modelPN);
    }
    
    private void bt_CTPNCheckedActionPerformed(java.awt.event.ActionEvent evt){
        tb_CTPN.setModel(modelCTPN);
    }
    
    // Hàm enter
    public void sukienEnterLoai(){
        tx_MaLoai.requestFocus();
        tx_MaLoai.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_TenLoai.requestFocus();
            }
        });
        tx_TenLoai.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_SlLoai.requestFocus();
            }
        });
        tx_SlLoai.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_MaPN.requestFocus();
            }
        });
        tx_TKLoai.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_TKLoai.doClick();
            }
        });
    }
    
    public void sukienEnterPN(){
        //tx_MaPN.requestFocus();
        tx_MaPN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_MaNCC.requestFocus();
            }
        });
        tx_MaNCC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_MaNV.requestFocus();
            }
        });
        tx_MaNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_NgLap.requestFocus();
            }
        });
        tx_NgLap.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_TongSL.requestFocus();
            }
        });
        tx_TongSL.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_TongTien.requestFocus();
            }
        });
        tx_TongTien.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_MaPN_CTPN.requestFocus();
            }
        });
        tx_TKPN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_TKPN.doClick();
            }
        });
    }
    
    public void sukienEnterCTPN(){
        //tx_MaPN_CTPN.requestFocus();
        tx_MaPN_CTPN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_MaSP.requestFocus();
            }
        });
        tx_MaSP.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_SLSP.requestFocus();
            }
        });
        tx_SLSP.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_GiaNhap.requestFocus();
            }
        });
        tx_GiaNhap.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_ThanhTien.requestFocus();
            }
        });
        tx_TKCTPN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_TKCTPN.doClick();
            }
        });
    }
    

//    public static void main(String[] args) {
//        new GUI_NhapHang();
//    }
}
