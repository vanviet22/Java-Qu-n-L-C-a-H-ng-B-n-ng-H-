/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
/**
 *
 * @author HP
 */

//import GUI.GUI_Khachhang;
import ConnectDB.XuLyDatabase;
import DTO.TaiKhoan_DTO;
import DAO.user_DAO;
import DTO.NhanVien_DTO;
import BUS.NhanVien_BUS;
import GUI.chuyenForm;
import BUS.USER_BUS;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

import ConnectDB.XuLyDatabase;
import DAO.user_DAO;
import DTO.TaiKhoan_DTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class GUI_USER extends JFrame {
    private ThongTinDN dn=new ThongTinDN();
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

    JLabel lb_user = new javax.swing.JLabel();
    JLabel lb_userName = new javax.swing.JLabel();
    JLabel lb_passWord = new javax.swing.JLabel();
    JTextField tx_userName = new javax.swing.JTextField();
    JTextField tx_passWord = new javax.swing.JTextField();
    JComboBox cb_timKiem = new javax.swing.JComboBox<>();
    JTextField tx_timKiem = new javax.swing.JTextField();
    JButton bt_timKiem = new javax.swing.JButton();
    JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    JTable tb_user = new javax.swing.JTable();
    JButton bt_them = new javax.swing.JButton();
    JButton bt_sua = new javax.swing.JButton();
    JButton bt_xoa = new javax.swing.JButton();
    JPanel tacVu = new javax.swing.JPanel();
    ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
    JRadioButton rbt_admin = new javax.swing.JRadioButton();
    JRadioButton rbt_quanLy = new javax.swing.JRadioButton();
    JRadioButton rbt_banHang = new javax.swing.JRadioButton();
    JLabel lb_tacVu = new javax.swing.JLabel();
    JButton bt_clear = new javax.swing.JButton();
    JButton bt_Check = new javax.swing.JButton();
    JLabel lb_anhUser = new javax.swing.JLabel();
    ArrayList<TaiKhoan_DTO> dsTK = new ArrayList<TaiKhoan_DTO>();
    DefaultTableModel modelUser = new DefaultTableModel();
    user_DAO user_DAO = new user_DAO();
    USER_BUS user_BUS = new USER_BUS();
    private NhanVien_BUS nv_BUS=new NhanVien_BUS();
    private JTable TbIDNV;
    private JScrollPane scrollIDNV;

    public GUI_USER() {

        setTitle("Quản lí user");
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
        chitiet.setBackground(new java.awt.Color(0,255,204));

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

        bt_user.setBackground(new java.awt.Color(153, 255, 153));
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


        // USER
        lb_user.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lb_user.setForeground(new java.awt.Color(255, 102, 0));
        lb_user.setText("Quản lý USER ");
        lb_user.setMinimumSize(new java.awt.Dimension(0, 0));
        lb_user.setPreferredSize(new java.awt.Dimension(40, 25));

        lb_userName.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_userName.setForeground(new java.awt.Color(255, 102, 0));
        lb_userName.setText("UserName");
        lb_userName.setPreferredSize(new java.awt.Dimension(100, 24));

        lb_passWord.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_passWord.setForeground(new java.awt.Color(255, 102, 0));
        lb_passWord.setText("PassWord");
        lb_passWord.setPreferredSize(new java.awt.Dimension(100, 24));

        tx_userName.setPreferredSize(new java.awt.Dimension(200, 24));

        tx_passWord.setPreferredSize(new java.awt.Dimension(200, 24));

        cb_timKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UserName", "PassWord"}));
        cb_timKiem.setPreferredSize(new java.awt.Dimension(72, 24));

        tx_timKiem.setPreferredSize(new java.awt.Dimension(73, 24));

       ImageIcon anh_Tk_CoBan= new ImageIcon("D:\\vietcpp\\.vscode\\\\doan_java/Image/icons8-search-27.png");
        ImageIcon anh_Tk_CoBan_resized = new ImageIcon(anh_Tk_CoBan.getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH));
        bt_timKiem.setIcon(anh_Tk_CoBan_resized);
        bt_timKiem.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_timKiemActionPerformed(evt);
            }
        });

        tb_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "UserName", "PassWord"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_user);
        hienThi();
        //hiện thị table mã nhân viên ở user
        ViTriCuaTableID();
        txUserMouseListener();
        TbIDNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableIDClick(evt);
            }
        });
        //hủy tìm kiếm
        chitiet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                scrollIDNV.setVisible(false);
                tx_passWord.setVisible(true);
                
            }
        });
        tb_user.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tb_userMouseClicked(evt);
                }
        });

        bt_them.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bt_them.setText("Thêm ");
        bt_them.setPreferredSize(new java.awt.Dimension(80, 24));
        bt_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_themActionPerformed(evt);
            }
        });

        bt_sua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bt_sua.setText("Sửa");
        bt_sua.setPreferredSize(new java.awt.Dimension(80, 24));
        bt_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_suaActionPerformed(evt);
            }
        });

        bt_xoa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bt_xoa.setText("Xóa");
        bt_xoa.setPreferredSize(new java.awt.Dimension(80, 24));
        bt_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_xoaActionPerformed(evt);
            }
        });

        bt_clear.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bt_clear.setText("Clear");
        bt_clear.setPreferredSize(new java.awt.Dimension(80, 24));
        bt_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_clearActionPerformed(evt);
            }
        });

        ImageIcon anhXong= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\sign-check-icon.png");
        ImageIcon anhXong_resized = new ImageIcon(anhXong.getImage().getScaledInstance(22, 22, java.awt.Image.SCALE_SMOOTH));
        bt_Check.setIcon(anhXong_resized); // NOI18N
        bt_Check.setPreferredSize(new java.awt.Dimension(24, 24));
        bt_Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CheckActionPerformed(evt);
            }
        });
        
        lb_anhUser.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\gruop-user.jpg")); // NOI18N
        ImageIcon anhUser= new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\gruop-user.jpg");
        ImageIcon anhUser_resized = new ImageIcon(anhUser.getImage().getScaledInstance(180, 170, java.awt.Image.SCALE_SMOOTH));
        lb_anhUser.setIcon(anhUser_resized);
        lb_anhUser.setPreferredSize(new java.awt.Dimension(150, 150));
        
        javax.swing.GroupLayout chitietLayout = new javax.swing.GroupLayout(chitiet);
        chitiet.setLayout(chitietLayout);
        chitietLayout.setHorizontalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chitietLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(cb_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(tx_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lb_passWord, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_userName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addComponent(bt_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bt_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addComponent(bt_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bt_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tx_userName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tx_passWord, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_Check, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_anhUser, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_user, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
        );
        chitietLayout.setVerticalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chitietLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_passWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_passWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lb_anhUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tx_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Check, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        
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
    // Gọi hàm sự kiện
    private Vector headerUser(Vector header){
        header.add("UserName");
        header.add("PassWord");
        return header;
    }
    
    private Vector rowUser(Vector row,TaiKhoan_DTO tk){
        row.add(tk.getMaNV());
        row.add(tk.getMk());
        return row;
    }
    
    private void hienThi() {
        dsTK = user_BUS.getListUser();
            if(!dsTK.isEmpty()){
                Vector header = new Vector();
                header = headerUser(header);
                modelUser = new DefaultTableModel(header, 0);

                for(TaiKhoan_DTO tk:dsTK)
                {
                   Vector row = new Vector();
                   row = rowUser(row,tk);
                   modelUser.addRow(row); 
                }
                tb_user.setModel(modelUser);
           }
    }               
    
    private void tb_userMouseClicked(java.awt.event.MouseEvent evt){
        // TODO add your handling code here:
        tx_userName.setEnabled(false);
        tx_userName.setBackground(Color.GRAY);
        int i = tb_user.getSelectedRow();
        tx_userName.setText(tb_user.getModel().getValueAt(i, 0).toString());
        tx_passWord.setText(tb_user.getModel().getValueAt(i, 1).toString());
    }
    
    private boolean checkMa(ArrayList<TaiKhoan_DTO> ds,String ma){
        for(TaiKhoan_DTO i:ds){
            if(i.getMaNV().equals(ma))
                return false;
        }
        return true;
    }

    private void checkNhap() {
        if (tx_userName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhà cung cấp!");
            tx_userName.requestFocus();
        } else if (tx_passWord.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhà cung cấp!");
            tx_passWord.requestFocus();
        }
    }
    
    private void bt_themActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        if (tx_userName.getText().isEmpty() || tx_passWord.getText().isEmpty())
            checkNhap();
        else {
            if (checkMa(dsTK, tx_userName.getText()) != true) {
                JOptionPane.showMessageDialog(this, "UserName bạn nhập đã có trong cửa hàng vui lòng nhập lại!");
                tx_userName.setText("");
                tx_userName.requestFocus();
            } else if (tx_userName.getText().length() > 10) {
                JOptionPane.showMessageDialog(this,
                        "UserName bạn nhập lớn hơn giới hạn cho phép!!! Vui lòng nhập mã có độ lớn <10!");
                tx_userName.setText("");
                tx_userName.requestFocus();
            } else if (tx_passWord.getText().length() < 5 || tx_passWord.getText().length() > 20) {
                JOptionPane.showMessageDialog(this, "Mật khẩu bạn nhập phải từ 5-20 kí tự!!!");
                tx_passWord.setText("");
                tx_passWord.requestFocus();
            } else {
                try {
                    TaiKhoan_DTO tk = new TaiKhoan_DTO();
                    tk.setMaNV(tx_userName.getText());
                    tk.setMk(tx_passWord.getText());
                    dsTK = user_BUS.Them(tk);
                    Vector row = new Vector();
                    row = rowUser(row, dsTK.get(dsTK.size() - 1));
                    modelUser.addRow(row);
                    tb_user.setModel(modelUser);

                    JOptionPane.showMessageDialog(this, "Thêm User có mã " + tx_userName.getText() + " thành công");
                    bt_clearActionPerformed(evt);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
                }
            }
        }
    }

    private void bt_suaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = tb_user.getSelectedRow();
        if (i >= 0 && i < dsTK.size()) {
            if (tx_userName.getText().isEmpty() || tx_passWord.getText().isEmpty())
                checkNhap();
            else {
                if (tx_userName.getText().length() > 10) {
                    JOptionPane.showMessageDialog(this,
                            "UserName bạn nhập lớn hơn giới hạn cho phép!! Vui lòng nhập UserName có độ lớn<10!");
                    tx_userName.setText("");
                    tx_userName.requestFocus();
                } else if (tx_passWord.getText().length() < 5 || tx_passWord.getText().length() > 20) {
                    JOptionPane.showMessageDialog(this, "PassWord bạn nhập có từ 5-20 kí tự!");
                    tx_passWord.setText("");
                    tx_passWord.requestFocus();
                } else {
                    TaiKhoan_DTO tk = new TaiKhoan_DTO();
                    tk.setMaNV(tx_userName.getText());
                    tk.setMk(tx_passWord.getText());
                    dsTK = user_BUS.Sua(i, tk);
                    modelUser.setValueAt(tx_userName.getText(), i, 0);
                    modelUser.setValueAt(tx_passWord.getText(), i, 1);
                    tb_user.setModel(modelUser);

                    JOptionPane.showMessageDialog(this, "Sửa User có mã " + tx_userName.getText() + " thành công");
                    bt_clearActionPerformed(evt);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Đã vượt quá độ lớn của danh sách");
        }
    }
    
    private void bt_xoaActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        int i = tb_user.getSelectedRow();
        if(i>=0 &&i< dsTK.size())
        {
            String ma = tx_userName.getText();
            try
            {
                dsTK = user_BUS.Xoa(i, ma);
                modelUser.removeRow(i);
                tb_user.setModel(modelUser);
                
                JOptionPane.showMessageDialog(this, "Xóa User có mã " +tx_userName.getText()+" thành công");
                bt_clearActionPerformed(evt);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
            }  
            
        }
    }

    private void bt_clearActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        tx_userName.setEnabled(true);
        tx_userName.setBackground(Color.WHITE);
        tx_userName.setText("");
        tx_passWord.setText("");
    }     
    
    private void bt_timKiemActionPerformed(java.awt.event.ActionEvent evt) {
        if(tx_timKiem.getText().isEmpty()){
            JOptionPane.showConfirmDialog(this, "Hãy nhập thông tin muốn tìm kiếm!!!");
            tx_timKiem.requestFocus();
        } else {
            DefaultTableModel modelUserTam = new DefaultTableModel();
            // Vector header = new Vector();
            // header = headerUser(header);
            // if(modelUserTam.getRowCount() == 0){
            //     modelUserTam = new DefaultTableModel(header,0);
            // }
            
            modelUserTam = user_BUS.TimKiem(String.valueOf(cb_timKiem.getSelectedItem()), tx_timKiem.getText());
            if(modelUserTam.getRowCount() > 0){
                tb_user.setModel(modelUserTam);
                bt_clearActionPerformed(evt);
            } else {
                JOptionPane.showConfirmDialog(this, "Thông tin bạn tìm không tồn tại!!");
            }
        }
    }
    
    private void bt_CheckActionPerformed(java.awt.event.ActionEvent evt) {
        tb_user.setModel(modelUser);
    }
    
    // Sự kiện enter
    public void sukienEnter(){
        tx_userName.requestFocus();
        tx_userName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_passWord.requestFocus();
            }
        });
        tx_timKiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_timKiem.doClick();
            }
        });
    }
    
    // Chuyển form
    private void ViTriCuaTableID()
    {
        TbIDNV=new JTable();
        DefaultTableModel modelIDNV=new DefaultTableModel(new Object[]{""},0);
        TbIDNV.setModel(modelIDNV);
        scrollIDNV=new JScrollPane(TbIDNV);
        chitiet.add(scrollIDNV);
        scrollIDNV.setBounds(124,76 , 200, 70);
        scrollIDNV.setVisible(false);
    }
    private void searchIDNV(String ma)
    {
        DefaultTableModel modelIDNV=(DefaultTableModel) TbIDNV.getModel();
        modelIDNV.setRowCount(0);
        for(NhanVien_DTO i:nv_BUS.getList())
            if(i.getMaNV().toLowerCase().contains(ma.toLowerCase()))
                modelIDNV.addRow(new Object[]{i.getMaNV()});
    }
    private void txUserMouseListener()
    {
        tx_userName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Khi người dùng nhập, thực hiện tìm kiếm và hiển thị kết quả
                scrollIDNV.setVisible(true);
                tx_passWord.setVisible(false);
                String searchText = tx_userName.getText();
                searchIDNV(searchText);
            }
        });
        
    }
    private void tableIDClick(java.awt.event.MouseEvent evt)
    {
        int i=TbIDNV.getSelectedRow();
        if(i>-1)
        {
            tx_userName.setText(TbIDNV.getValueAt(i,0).toString());
            scrollIDNV.setVisible(false);
            tx_passWord.setVisible(true);
        }
    }
//    public static void main(String[] args) {
//        new GUI_USER();
//    }
}

