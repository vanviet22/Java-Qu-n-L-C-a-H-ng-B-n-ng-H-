package GUI;

import DTO.NCC_DTO;
import DAO.NCC_DAO;
import BUS.NCC_BUS;
import ConnectDB.XuLyDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import GUI.ThongTinDN;
public class GUI_NCC extends JFrame {
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
    ImageIcon icon = new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\276-2764901_www-agisac-gov-in-admin-png.png");
    JLabel jlb_anh = new JLabel();

    JLabel lb_headNCC = new javax.swing.JLabel();
    JLabel lb_MaNCC = new javax.swing.JLabel();
    JLabel lb_TenNCC = new javax.swing.JLabel();
    JLabel lb_DCNCC = new javax.swing.JLabel();
    JLabel lb_SDTNCC = new javax.swing.JLabel();
    JLabel lb_GmailNCC = new javax.swing.JLabel();
    JTextField tx_MaNCC = new javax.swing.JTextField();
    JTextField tx_TenNCC = new javax.swing.JTextField();
    JTextField tx_DCNCC = new javax.swing.JTextField();
    JTextField tx_SDTNCC = new javax.swing.JTextField();
    JTextField tx_GmailNCC = new javax.swing.JTextField();
    JButton bt_them = new javax.swing.JButton();
    JButton bt_sua = new javax.swing.JButton();
    JButton bt_xoa = new javax.swing.JButton();
    JButton bt_clear = new javax.swing.JButton();
    JLabel lb_TrangThai = new javax.swing.JLabel();
    JComboBox cb_trangthai = new javax.swing.JComboBox<>();
    JTextField tx_TimKiem = new javax.swing.JTextField();
    JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    JTable tb_NCC = new javax.swing.JTable();
    JButton bt_TimKiem = new javax.swing.JButton();
    JButton bt_Dong = new javax.swing.JButton();
    JComboBox cb_timkiem=new javax.swing.JComboBox<>();
    JLabel lb_AnhNCC=new javax.swing.JLabel();
    
    ArrayList<NCC_DTO> dsNCC = new ArrayList<NCC_DTO>();
    NCC_BUS ncc_BUS = new NCC_BUS();
    DefaultTableModel model = new DefaultTableModel();
    NCC_DAO ncc_DAO = new NCC_DAO();
    JButton bt_doc = new javax.swing.JButton();
    JButton bt_checked = new javax.swing.JButton();


    public GUI_NCC() {

        setTitle("Quản lí nhà cung cấp");
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

        bt_ncc.setBackground(new java.awt.Color(153, 255, 153));
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

        // chuyển trang
        // bt_kh.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         dispose();
        //         new GUI_Khachhang().setVisible(true);
        //     }
        // });
        // bt_dx.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         dispose();
        //         new GUI_dangnhap().setVisible(true);
        //     }
        // });

        //NCC
        lb_headNCC.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_headNCC.setForeground(new java.awt.Color(255, 102, 0));
        lb_headNCC.setText("Quản lý nhà cung cấp");

        lb_MaNCC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_MaNCC.setForeground(new java.awt.Color(255, 102, 0));
        lb_MaNCC.setText("Mã NCC");

        lb_TenNCC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_TenNCC.setForeground(new java.awt.Color(255, 102, 0));
        lb_TenNCC.setText("Tên NCC");

        lb_DCNCC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_DCNCC.setForeground(new java.awt.Color(255, 102, 0));
        lb_DCNCC.setText("Địa chỉ NCC");

        lb_SDTNCC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_SDTNCC.setForeground(new java.awt.Color(255, 102, 0));
        lb_SDTNCC.setText("SĐT NCC");

        lb_GmailNCC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_GmailNCC.setForeground(new java.awt.Color(255, 102, 0));
        lb_GmailNCC.setText("Gmail");
        
        bt_them.setBackground(new java.awt.Color(255, 153, 153));
        ImageIcon anhThem= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-add-27.png");
        ImageIcon anhThem_resized = new ImageIcon(anhThem.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        bt_them.setIcon(anhThem_resized);
        bt_them.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_themActionPerformed(evt);
            }
        });

        ImageIcon anhSua= new ImageIcon("D:\\vietcpp\\.vscode/doan_java/Image/icons8-update-left-rotation-27.png");
        ImageIcon anhSua_resized = new ImageIcon(anhSua.getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH));
        bt_sua.setIcon(anhSua_resized); // NOI18N
        bt_sua.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_suaActionPerformed(evt);
            }
        });

        ImageIcon anhXoa= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\Button-Delete-icon.png");
        ImageIcon anhXoa_resized = new ImageIcon(anhXoa.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_xoa.setIcon(anhXoa_resized); // NOI18N
        bt_xoa.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_xoaActionPerformed(evt);
            }
        });

        tb_NCC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tb_NCC.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã NCC", "Tên NCC", "Địa chỉ", "SĐT", "Gmail", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tb_NCC.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tb_NCC);
        tb_NCC.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tb_NCC.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tb_NCCMouseClicked(evt);
                }
        });
        //hienThi();

        bt_TimKiem.setIcon(new javax.swing.ImageIcon("D:\\vietcpp\\.vscode\\\\doan_java/Image/icons8-search-27.png")); // NOI18N
        bt_TimKiem.setMaximumSize(new java.awt.Dimension(24, 24));
        bt_TimKiem.setMinimumSize(new java.awt.Dimension(24, 24));
        bt_TimKiem.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_TimKiemActionPerformed(evt);
            }
        });

        bt_Dong.setText("Đóng");
        bt_Dong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DongActionPerformed(evt);
            }
        });

        cb_timkiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NCC", "Tên NCC", "Địa chỉ", "SĐT", "Gmail" }));

        lb_AnhNCC.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\icons8-home-26.png")); // NOI18N
        lb_AnhNCC.setMaximumSize(new java.awt.Dimension(150, 150));
        lb_AnhNCC.setMinimumSize(new java.awt.Dimension(150, 150));
        lb_AnhNCC.setPreferredSize(new java.awt.Dimension(150, 150));

        ImageIcon anhNCC= new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\icons8-home-26.png");
        ImageIcon anhNCC_resized = new ImageIcon(anhNCC.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
        lb_AnhNCC.setIcon(anhNCC_resized);
        lb_AnhNCC.setPreferredSize(new java.awt.Dimension(150, 150));
        
        bt_clear.setText("Clear");
        bt_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_clearActionPerformed(evt);
            }
        });

        lb_TrangThai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_TrangThai.setForeground(new java.awt.Color(255, 102, 0));
        lb_TrangThai.setText("Trạng thái");

        cb_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không chặn", "Chặn" }));
        
        bt_doc.setText("Đọc");
        bt_doc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_docMouseClicked(evt);
            }
        });
        ImageIcon anhXong= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\sign-check-icon.png");
        ImageIcon anhXong_resized = new ImageIcon(anhXong.getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH));
        bt_checked.setIcon(anhXong_resized); // NOI18N
        bt_checked.setPreferredSize(new java.awt.Dimension(24, 24));
        
        bt_checked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_checkedActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout chitietLayout = new javax.swing.GroupLayout(chitiet);
        chitiet.setLayout(chitietLayout);
        chitietLayout.setHorizontalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chitietLayout.createSequentialGroup()
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(cb_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tx_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(lb_headNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(chitietLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lb_SDTNCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_DCNCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(lb_TenNCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_MaNCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_GmailNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_TrangThai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addComponent(cb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(bt_clear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_doc))
                            .addComponent(tx_DCNCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(tx_TenNCC, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tx_MaNCC, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tx_GmailNCC)
                            .addComponent(tx_SDTNCC, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(77, 77, 77)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(bt_Dong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_checked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lb_AnhNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98))))
        );
        chitietLayout.setVerticalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chitietLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_headNCC)
                .addGap(18, 18, 18)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_MaNCC)
                            .addComponent(tx_MaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_TenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_TenNCC)
                            .addComponent(bt_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_DCNCC)
                            .addComponent(tx_DCNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_SDTNCC)
                            .addComponent(tx_SDTNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_GmailNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_GmailNCC)))
                    .addComponent(lb_AnhNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_TrangThai)
                    .addComponent(cb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_clear)
                            .addComponent(bt_doc))
                        .addGap(16, 16, 16)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_Dong, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tx_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cb_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(bt_checked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        
        // su kien enter
        sukienEnter();
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
    // gọi sự kiện 
    
    private Vector headerNCC(Vector header){
        header.add("Mã NCC");
        header.add("Tên NCC");
        header.add("Địa chỉ");
        header.add("SĐT");
        header.add("Gmail");
        header.add("Trạng thái");
        return header;
    }
    
    private Vector rowNCC(Vector row, NCC_DTO ncc){
        row.add(ncc.getMaNCC());
        row.add(ncc.getTenNCC());
        row.add(ncc.getDcNCC());
        row.add(ncc.getSdtNCC());
        row.add(ncc.getGmail());
        row.add(ncc.getTrangThai());
        return row;
    }
    
    private void bt_docMouseClicked(java.awt.event.MouseEvent evt) {
         // TODO add your handling code here:
        dsNCC=ncc_BUS.getListNCC();
           if(!dsNCC.isEmpty())
           {
               Vector header=new Vector();
               header = headerNCC(header);   
                   model=new DefaultTableModel(header, 0);

                   for(NCC_DTO ncc:dsNCC)
                   {
                      Vector row=new Vector();
                      row=rowNCC(row,ncc);
                       model.addRow(row); 
                   }
                   tb_NCC.setModel(model);
           }
    }
    
    private void tb_NCCMouseClicked(java.awt.event.MouseEvent evt){
        // TODO add your handling code here:
        int i = tb_NCC.getSelectedRow();
        tx_MaNCC.setText(tb_NCC.getModel().getValueAt(i, 0).toString());
        tx_TenNCC.setText(tb_NCC.getModel().getValueAt(i, 1).toString());
        tx_DCNCC.setText(tb_NCC.getModel().getValueAt(i, 2).toString());
        tx_SDTNCC.setText(tb_NCC.getModel().getValueAt(i, 3).toString());
        tx_GmailNCC.setText(tb_NCC.getModel().getValueAt(i, 4).toString());
        cb_trangthai.setSelectedItem(tb_NCC.getModel().getValueAt(i,5).toString());
    }
    
    
    private boolean checkMa(ArrayList<NCC_DTO> ds,String ma){
        for(NCC_DTO i:ds){
            if(i.getMaNCC().equals(ma))
                return false;
        }
        return true;
    }

    private void checkNhap() {
        if (tx_MaNCC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhà cung cấp!");
            tx_MaNCC.requestFocus();
        } else if (tx_TenNCC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhà cung cấp!");
            tx_TenNCC.requestFocus();
        } else if (tx_DCNCC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhà cung cấp!");
            tx_DCNCC.requestFocus();
        } else if (tx_SDTNCC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại nahf cung cấp!");
            tx_SDTNCC.requestFocus();
        } else if (tx_GmailNCC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Gmail nhà cung cấp!");
            tx_GmailNCC.requestFocus();
        }
    }
    
    private void bt_themActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (tx_MaNCC.getText().isEmpty() || tx_TenNCC.getText().isEmpty() || tx_DCNCC.getText().isEmpty()
                || tx_SDTNCC.getText().isEmpty() || tx_GmailNCC.getText().isEmpty())
            checkNhap();
        else {
            if (checkMa(dsNCC, tx_MaNCC.getText()) != true) {
                JOptionPane.showMessageDialog(this, "Mã bạn nhập đã có trong cửa hàng vui lòng nhập lại!");
                tx_MaNCC.setText("");
                tx_MaNCC.requestFocus();
            } else if (tx_MaNCC.getText().length() > 10) {
                JOptionPane.showMessageDialog(this,"Mã bạn nhập lớn hơn giới hạn cho phép vui lòng nhập mã có độ lớn<10!");
                tx_MaNCC.setText("");
                tx_MaNCC.requestFocus();
            } else {
                try {
                    NCC_DTO ncc = new NCC_DTO();
                    ncc.setMaNCC(tx_MaNCC.getText());
                    ncc.setTenNCC(tx_TenNCC.getText());
                    ncc.setDcNCC(tx_DCNCC.getText());
                    ncc.setSdtNCC(tx_SDTNCC.getText());
                    ncc.setGmail(tx_GmailNCC.getText());
                    ncc.setTrangThai((String) cb_trangthai.getSelectedItem());

                    dsNCC = ncc_BUS.Them(ncc);
                    Vector header = new Vector();
                    header = headerNCC(header);
                    if (model.getRowCount() == 0) {
                        model = new DefaultTableModel(header, 0);
                    }
                    Vector row = new Vector();
                    row = rowNCC(row, dsNCC.get(dsNCC.size() - 1));
                    model.addRow(row);
                    tb_NCC.setModel(model);

                    JOptionPane.showMessageDialog(this, "Thêm NCC có mã " + tx_MaNCC.getText() + " thành công");
                    bt_clearActionPerformed(evt);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
                }
            }
        }
    }

    private void bt_suaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = tb_NCC.getSelectedRow();
        if (i >= 0 && i < dsNCC.size()) {
            if (tx_MaNCC.getText().isEmpty() || tx_TenNCC.getText().isEmpty() || tx_DCNCC.getText().isEmpty()
                    || tx_SDTNCC.getText().isEmpty() || tx_GmailNCC.getText().isEmpty())
                checkNhap();
            else {
                try {
                    Long.parseLong(tx_SDTNCC.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại bạn nhập không phải số vui lòng nhập lại!");
                    tx_SDTNCC.requestFocus();
                    return;
                }
                NCC_DTO ncc = new NCC_DTO();
                ncc.setMaNCC(tx_MaNCC.getText());
                ncc.setTenNCC(tx_TenNCC.getText());
                ncc.setDcNCC(tx_DCNCC.getText());
                ncc.setSdtNCC(tx_SDTNCC.getText());
                ncc.setGmail(tx_GmailNCC.getText());
                ncc.setTrangThai((String) cb_trangthai.getSelectedItem());

                dsNCC = ncc_BUS.Sua(i, ncc);
                model.setValueAt(tx_MaNCC.getText(), i, 0);
                model.setValueAt(tx_TenNCC.getText(), i, 1);
                model.setValueAt(tx_DCNCC.getText(), i, 2);
                model.setValueAt(tx_SDTNCC.getText(), i, 3);
                model.setValueAt(tx_GmailNCC.getText(), i, 4);
                model.setValueAt((String) cb_trangthai.getSelectedItem(), i, 5);
                tb_NCC.setModel(model);

                JOptionPane.showMessageDialog(this, "Sửa NCC có mã " + tx_MaNCC.getText() + " thành công");
                bt_clearActionPerformed(evt);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Đã vượt quá độ lớn của danh sách");
        }
    }                                      

    private void bt_xoaActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        int i = tb_NCC.getSelectedRow();
        if(i>=0 &&i< dsNCC.size())
        {
            String ma = tx_MaNCC.getText();
            dsNCC = ncc_BUS.Xoa(i, ma);
            model.removeRow(i);
            tb_NCC.setModel(model);
            
            JOptionPane.showMessageDialog(this, "Bạn đã xóa NCC có mã "+tx_MaNCC.getText());
            bt_clearActionPerformed(evt);
        }
    }               
    
    private void bt_clearActionPerformed(java.awt.event.ActionEvent evt) {  
        tx_MaNCC.setText("");
        tx_TenNCC.setText("");
        tx_DCNCC.setText("");
        tx_SDTNCC.setText("");
        tx_GmailNCC.setText("");
        cb_trangthai.setSelectedIndex(0);
        tx_TimKiem.setText("");
    }

    private void bt_DongActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        System.exit(0);
    }                                       

    private void bt_checkedActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        tb_NCC.setModel(model);
    }    
    
    public void sukienEnter(){
        tx_MaNCC.requestFocus();
        tx_MaNCC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_TenNCC.requestFocus();
            }
        });
        tx_TenNCC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_DCNCC.requestFocus();
            }
        });
        tx_DCNCC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_SDTNCC.requestFocus();
            }
        });
        tx_SDTNCC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_GmailNCC.requestFocus();
            }
        });
        tx_GmailNCC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    cb_trangthai.requestFocus();
            }
        });
        tx_TimKiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_TimKiem.doClick();
            }
        });
    }
    
    private void bt_TimKiemActionPerformed(java.awt.event.ActionEvent evt){
        if(tx_TimKiem.getText().isEmpty()){
            JOptionPane.showConfirmDialog(this,"Hãy nhập nội dung cần tìm!!!");
            tx_TimKiem.requestFocus();
        } else {
            DefaultTableModel modelNCCTam = new DefaultTableModel();
            Vector header = new Vector();
            header = headerNCC(header);
            if(modelNCCTam.getRowCount()==0){
                modelNCCTam = new DefaultTableModel(header,0);
            }
            modelNCCTam = ncc_BUS.TimKiem((String) cb_timkiem.getSelectedItem(), tx_TimKiem.getText());

            if(modelNCCTam.getRowCount() > 0){
                tb_NCC.setModel(modelNCCTam);
                bt_clearActionPerformed(evt);
            }else{
                JOptionPane.showMessageDialog(this,"Cửa hàng không có thứ bạn tìm");
            }
        }
    }

//    public static void main(String[] args) {
//        new GUI_NCC();
//    }
}
