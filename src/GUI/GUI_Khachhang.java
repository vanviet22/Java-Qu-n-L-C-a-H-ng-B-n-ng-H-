package GUI;
import DTO.KhachHang_DTO;
import BUS.KhachHang_BUS;
import GUI.ThongTinDN;
import java.beans.Statement;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
public class GUI_Khachhang extends JFrame {
    private ThongTinDN dn=new ThongTinDN();
    Panel tieude = new Panel();
    Panel menu = new Panel();
    Panel chitiet = new Panel();
    JLabel lb_bentrai = new JLabel("Chào mừng đến với hệ thống quản lí");
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
    private javax.swing.JButton bt_Clear;
    private javax.swing.JButton bt_Sua;
    private javax.swing.JButton bt_Them;
    private javax.swing.JButton bt_TimKiem;
    private javax.swing.JButton bt_Xoa;
    private javax.swing.JButton bt_Xong;
    private javax.swing.JComboBox<String> cb_GioiTinh;
    private javax.swing.JComboBox<String> cb_TrangThai;
    private javax.swing.JComboBox<String> cb_LuachonTimkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlb_anh_kh;
    private javax.swing.JLabel jlb_lc_kh;
    private javax.swing.JLabel lb_GioiTinh;
    private javax.swing.JLabel lb_HoKH;
    private javax.swing.JLabel lb_IdKH;
    private javax.swing.JLabel lb_NhapID;
    private javax.swing.JLabel lb_SĐT;
    private javax.swing.JLabel lb_TenKH;
    private javax.swing.JLabel lb_TrangThai;
    private javax.swing.JTable tableKH;
    private javax.swing.JTextField tx_DCKH;
    private javax.swing.JTextField tx_HoKH;
    private javax.swing.JTextField tx_IdKH;
    private javax.swing.JTextField tx_NhapTK;
    private javax.swing.JTextField tx_SDT;
    private javax.swing.JTextField tx_TenKH;
    private javax.swing.JButton bt_ExportExcel;
    private javax.swing.JButton bt_ImportExcel;
    private DefaultTableModel model;
    private ArrayList<KhachHang_DTO> dsKH;
    private KhachHang_BUS kh_BUS=new KhachHang_BUS();
    private Vector headerKH(Vector header)
    {
        header.add("ID");
        header.add("Họ");
        header.add("Tên");
        header.add("Địa chỉ");
        header.add("SĐT");
        header.add("Giới tính");
        header.add("Trạng thái");
        return header;
    }
    private Vector rowKH(Vector row,KhachHang_DTO kh)
    {
        row.add(kh.getMaKH());
        row.add(kh.getHo());
        row.add(kh.getTen());
        row.add(kh.getDc());
        row.add(kh.getSdt());
        row.add(kh.getGt());
        row.add(kh.getTrang_thai());
        return row;
    }
    private void hienThi()
    {
        if(dsKH.isEmpty()) dsKH=kh_BUS.getListKH();
            if(!dsKH.isEmpty())
            {
                Vector header=new Vector();
                header= headerKH(header);   
                    model=new DefaultTableModel(header, 0);
                    
                    for(KhachHang_DTO kh:dsKH)
                    {
                       Vector row=new Vector();
                       row=rowKH(row,kh);
                        model.addRow(row); 
                    }
                    tableKH.setModel(model);
            }
    }
    private boolean checkMa(ArrayList<KhachHang_DTO> ds,String ma)
    {
        for(KhachHang_DTO i:ds)
        {
            if(i.getMaKH().equals(ma))
                return false;
        }
        return true;
    }
    private void checkNhap()
    {
        if(tx_IdKH.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khách hàng!");
            tx_IdKH.requestFocus();
        }
        else if(tx_HoKH.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập họ khách hàng!");
            tx_HoKH.requestFocus();
        }
        else if(tx_TenKH.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên khách hàng!");
            tx_TenKH.requestFocus();
        }
        else if(tx_DCKH.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ khách hàng!");
            tx_DCKH.requestFocus();
        }
        else if(tx_SDT.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại Khách hàng!");
            tx_SDT.requestFocus();
        }
    }
    private void bt_ThemActionPerformed(java.awt.event.ActionEvent evt) {
        if(tx_IdKH.getText().isEmpty() || tx_HoKH.getText().isEmpty() || tx_TenKH.getText().isEmpty() ||tx_DCKH.getText().isEmpty() ||tx_SDT.getText().isEmpty() )
                checkNhap(); 
        else
        {
            if(checkMa(dsKH, tx_IdKH.getText())!=true)
            {
                JOptionPane.showMessageDialog(this, "Mã bạn nhập đã có trong cửa hàng vui lòng nhập lại!");
                tx_IdKH.setText("");
                tx_IdKH.requestFocus();
            }
            else if(tx_IdKH.getText().length()>10)
            {
                JOptionPane.showMessageDialog(this, "Mã bạn nhập lớn hơn giới hạn cho phép vui lòng nhập mã có độ lớn<10!");
                tx_IdKH.setText("");
                tx_IdKH.requestFocus();
            }
            else
            {
                try {
                    Long.parseLong(tx_SDT.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại bạn nhập không phải số vui lòng nhập lại!");
                    tx_SDT.requestFocus();
                    return;
                }
                KhachHang_DTO kh=new KhachHang_DTO();
                kh.setMaKH(tx_IdKH.getText());
                kh.setHo(tx_HoKH.getText());
                kh.setTen(tx_TenKH.getText());
                kh.setDc( tx_DCKH.getText());
                kh.setSdt(tx_SDT.getText());
                kh.setGt((String)cb_GioiTinh.getSelectedItem());
                kh.setTrang_thai((String)cb_TrangThai.getSelectedItem());
                dsKH=kh_BUS.Them(kh);    
                Vector header=new Vector();
                header=headerKH(header);
                if(model.getRowCount()==0)
                {
                    model=new DefaultTableModel(header, 0);
                }
                Vector row=new Vector();
                row=rowKH(row,dsKH.get(dsKH.size()-1));
                model.addRow(row);
                tableKH.setModel(model);

                JOptionPane.showMessageDialog(this, "Thêm Khách hàng có mã " +tx_IdKH.getText()+" thành công");
                 bt_ClearActionPerformed(evt);

            }
            
        } 
                
    }
    private void bt_XoaActionPerformed(java.awt.event.ActionEvent evt) {  
        int i=tableKH.getSelectedRow();
        if(i>=0 &&i< dsKH.size())
        {
            String ma=tx_IdKH.getText();
            dsKH=kh_BUS.Xoa(i, ma);
            model.removeRow(i);
            tableKH.setModel(model);
            
            JOptionPane.showMessageDialog(this, "Xóa Khách hàng có mã " +tx_IdKH.getText()+" thành công");
            bt_ClearActionPerformed(evt);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Đã vượt qua độ lớn của danh sách khách hàng mời chọn lại!");
        }
            
    }
    private void bt_SuaActionPerformed(java.awt.event.ActionEvent evt) {  
        int i=tableKH.getSelectedRow();
        if(i>=0 && i<dsKH.size())
        {
            if( tx_HoKH.getText().isEmpty() || tx_TenKH.getText().isEmpty() ||tx_DCKH.getText().isEmpty() ||tx_SDT.getText().isEmpty() )
                checkNhap();
            else 
            {
                try {
                    Long.parseLong(tx_SDT.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại bạn nhập không phải số vui lòng nhập lại!");
                    tx_SDT.requestFocus();
                    return;
                }
                KhachHang_DTO kh=new KhachHang_DTO();
                kh.setMaKH(tx_IdKH.getText());
                kh.setHo(tx_HoKH.getText());
                kh.setTen(tx_TenKH.getText());
                kh.setDc( tx_DCKH.getText());
                kh.setSdt(tx_SDT.getText());
                kh.setGt((String)cb_GioiTinh.getSelectedItem());
                kh.setTrang_thai((String)cb_TrangThai.getSelectedItem());
                dsKH=kh_BUS.Sua(i,kh);    
                 model.setValueAt(tx_HoKH.getText(), i, 1);
                 model.setValueAt(tx_TenKH.getText(), i, 2);
                 model.setValueAt(tx_DCKH.getText(), i, 3);
                 model.setValueAt(tx_SDT.getText(), i, 4);
                 model.setValueAt((String)cb_GioiTinh.getSelectedItem(), i, 5);
                 model.setValueAt((String)cb_TrangThai.getSelectedItem(), i, 6);
                 tableKH.setModel(model);
                 JOptionPane.showMessageDialog(this, "Sửa Khách hàng có mã " +tx_IdKH.getText()+" thành công");
                 bt_ClearActionPerformed(evt);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Đã vượt quá độ lớn của danh sách");
        }
        
    }
    private void bt_ClearActionPerformed(java.awt.event.ActionEvent evt) {  
        tx_IdKH.setText("");
        tx_HoKH.setText("");
        tx_TenKH.setText("");
        tx_DCKH.setText("");
        tx_SDT.setText("");
        cb_GioiTinh.setSelectedIndex(0);
        cb_TrangThai.setSelectedIndex(0);
        tx_IdKH.requestFocus();
        tx_IdKH.setEnabled(true);
        tx_IdKH.setDisabledTextColor(Color.BLACK);
    }
    private void bt_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {
        if(tx_NhapTK.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Vui lòng nhập nội dung cần tìm");
            tx_NhapTK.requestFocus();
        }
        else
        {
            DefaultTableModel model_tam = new DefaultTableModel();
            model_tam=kh_BUS.TimKiem((String)cb_LuachonTimkiem.getSelectedItem(), tx_NhapTK.getText());
            if(model_tam.getRowCount()>0)
            {
                tableKH.setModel(model_tam);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Cửa hàng không có thứ bạn tìm");
            }
            tx_NhapTK.setText("");
        }
        
    }


    private void bt_XongActionPerformed(java.awt.event.ActionEvent evt) {
        tableKH.setModel(model);
    }
    private void tableKHMouseClicked(java.awt.event.MouseEvent evt) {  
        int i=tableKH.getSelectedRow();
        if(i>=0 && i<dsKH.size())
        {
            tx_IdKH.setEnabled(false);
            tx_IdKH.setDisabledTextColor(Color.GRAY);
            KhachHang_DTO kh=new KhachHang_DTO();
            kh=dsKH.get(i);
            tx_IdKH.setText(kh.getMaKH());
            tx_HoKH.setText(kh.getHo());
            tx_TenKH.setText(kh.getTen());
            tx_DCKH.setText(kh.getDc());
            tx_SDT.setText(kh.getSdt());
            cb_GioiTinh.setSelectedItem(kh.getGt());
            cb_TrangThai.setSelectedItem(kh.getTrang_thai());
            tx_IdKH.requestFocus();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Đã vượt quá độ lớn của danh sách");
        }
    }
    private void bt_ExportExcelActionPerformed(java.awt.event.ActionEvent evt) 
    {
        kh_BUS.exportExcel();

    }
    private void bt_ImportExcelActionPerformed(java.awt.event.ActionEvent evt) 
    {
       
       kh_BUS.importExcel();
        hienThi();

    }
    public GUI_Khachhang() {
        
        setTitle("Quản lí khách hàng");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Tắt LayoutManager để sử dụng setBounds()

        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Tắt LayoutManager để sử dụng setBounds()
        setResizable(false);
        jlb_anh.setIcon(icon);
        jlb_anh.setHorizontalAlignment(JLabel.CENTER); 
        jlb_anh.setVerticalAlignment(JLabel.CENTER); 
        tieude.setBounds(150, 0, 750, 30);
        tieude.setBackground(new java.awt.Color(102,102,102));

        menu.setBounds(0, 0, 150, 565); // Đặt vị trí và kích thước cho panel menu
        //menu.setLayout(new GridLayout(12, 1));
        menu.setBackground(new java.awt.Color(51,153,255));

        // Panel chi tiết
        chitiet.setBounds(150, 30, 750, 535); // Đặt vị trí và kích thước cho panel chi tiết
        chitiet.setBackground(new java.awt.Color(204,204,204));


        // Đặt kích thước cho các nút trong menu
        jlb_anh.setPreferredSize(new Dimension(150, 180));
        bt_sp.setPreferredSize(new Dimension(150, 30)); // Điều chỉnh kích thước nút
        bt_kh.setPreferredSize(new Dimension(150,30));
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
        
        bt_kh.setBackground(new java.awt.Color(143,255,143));
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
        //Khách hàng
        jlb_anh_kh = new javax.swing.JLabel();
        jlb_lc_kh = new javax.swing.JLabel();
        lb_IdKH = new javax.swing.JLabel();
        tx_IdKH = new javax.swing.JTextField();
        lb_HoKH = new javax.swing.JLabel();
        tx_HoKH = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKH = new javax.swing.JTable();
        lb_TenKH = new javax.swing.JLabel();
        tx_TenKH = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tx_DCKH = new javax.swing.JTextField();
        lb_SĐT = new javax.swing.JLabel();
        tx_SDT = new javax.swing.JTextField();
        lb_GioiTinh = new javax.swing.JLabel();
        cb_GioiTinh = new javax.swing.JComboBox<>();
        lb_TrangThai = new javax.swing.JLabel();
        cb_TrangThai = new javax.swing.JComboBox<>();
        bt_Them = new javax.swing.JButton();
        bt_Sua = new javax.swing.JButton();
        bt_Clear = new javax.swing.JButton();
        tx_NhapTK = new javax.swing.JTextField();
        bt_TimKiem = new javax.swing.JButton();
        bt_Xoa = new javax.swing.JButton();
        bt_Xong = new javax.swing.JButton();
        cb_LuachonTimkiem = new javax.swing.JComboBox<>();
        bt_ImportExcel = new javax.swing.JButton();
        bt_ExportExcel = new javax.swing.JButton();
        model=new DefaultTableModel();
        dsKH=new ArrayList<KhachHang_DTO>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 600));

        chitiet.setBackground(new java.awt.Color(204, 204, 204));
        chitiet.setPreferredSize(new java.awt.Dimension(750, 535));

        jlb_anh_kh.setIcon(new javax.swing.ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-change-user-30.png")); // NOI18N

        jlb_lc_kh.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jlb_lc_kh.setText("Quản lí khách hàng");

        lb_IdKH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_IdKH.setText("ID");

        lb_HoKH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_HoKH.setText("HỌ");

        tableKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ", "Tên", "Địa chỉ", "SĐT", "Giới tính", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableKH);

        lb_TenKH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_TenKH.setText("Tên");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Địa chỉ");

        lb_SĐT.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_SĐT.setText("SĐT");

        lb_GioiTinh.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        lb_GioiTinh.setText("Giới tính");

        cb_GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        lb_TrangThai.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        lb_TrangThai.setText("Trạng thái");

        cb_TrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không chặn", "Chặn" }));

        bt_Them.setBackground(new java.awt.Color(255, 153, 153));
        ImageIcon anhThem= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-add-27.png");
        ImageIcon anhThem_resized = new ImageIcon(anhThem.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Them.setIcon(anhThem_resized); 
        // bt_Them.setHorizontalTextPosition(JButton.CENTER); // Đặt văn bản ở giữa theo chiều ngang
        // bt_Them.setVerticalTextPosition(JButton.CENTER); 

        ImageIcon anhSua= new ImageIcon("D:\\vietcpp\\.vscode\\\\doan_java/Image/icons8-update-left-rotation-27.png");
        ImageIcon anhSua_resized = new ImageIcon(anhSua.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Sua.setIcon(anhSua_resized); // NOI18N

        ImageIcon anhClear= new ImageIcon("D:\\vietcpp\\.vscode\\\\doan_java\\Image\\clean-icon2.png");
        ImageIcon anhClear_resized = new ImageIcon(anhClear.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Clear.setIcon(anhClear_resized);

        bt_TimKiem.setIcon(new javax.swing.ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-google-web-search-27.png")); // NOI18N

        ImageIcon anhXoa= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\Button-Delete-icon.png");
        ImageIcon anhXoa_resized = new ImageIcon(anhXoa.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Xoa.setIcon(anhXoa_resized); // NOI18N

        ImageIcon anhXong= new ImageIcon("D:\\vietcpp\\.vscode\\\\doan_java\\Image\\sign-check-icon.png");
        ImageIcon anhXong_resized = new ImageIcon(anhXong.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Xong.setIcon(anhXong_resized); // NOI18N

        cb_LuachonTimkiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Họ", "Tên", "Địa chỉ", "SĐT", "Giới tính", "Trạng thái" }));
        hienThi();
        bt_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            // Thêm khách hàng vào danh sách và cập nhật bảng
            bt_ThemActionPerformed(evt);
            }
        });
        bt_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_XoaActionPerformed(evt);
            }
        });
        bt_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_SuaActionPerformed(evt);
            }
        });
        bt_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_ClearActionPerformed(evt);
            }
        });
        bt_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_TimKiemActionPerformed(evt);
            }
        });
        bt_ExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_ExportExcelActionPerformed(evt);
            }
        });
        bt_ImportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_ImportExcelActionPerformed(evt);
            }
        });
        bt_Xong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_XongActionPerformed(evt);
            }
        });

        tableKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKHMouseClicked(evt);
            }
        });
        ImageIcon anhImportExcel= new ImageIcon("D:\\vietcpp\\.vscode\\\\doan_java\\\\Image\\\\icons8-microsoft-excel-27.png");
        ImageIcon anhImportExcel_resized = new ImageIcon(anhImportExcel.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_ImportExcel.setIcon(anhImportExcel_resized); // NOI18N
        bt_ImportExcel.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhExportExcel= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-export-excel-27.png");
        ImageIcon anhExportExcel_resized = new ImageIcon(anhExportExcel.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_ExportExcel.setIcon(anhExportExcel_resized); // NOI18N
        bt_ExportExcel.setPreferredSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout chitietLayout = new javax.swing.GroupLayout(chitiet);
        chitiet.setLayout(chitietLayout);
        chitietLayout.setHorizontalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chitietLayout.createSequentialGroup()
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jlb_anh_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlb_lc_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(chitietLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cb_LuachonTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_HoKH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_IdKH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tx_HoKH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_IdKH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_DCKH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addComponent(lb_SĐT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cb_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tx_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                                            .addComponent(bt_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bt_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cb_TrangThai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lb_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lb_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(47, 47, 47))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_ImportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addComponent(bt_ExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tx_NhapTK, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Xong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        chitietLayout.setVerticalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chitietLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlb_lc_kh)
                    .addComponent(jlb_anh_kh))
                .addGap(21, 21, 21)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tx_IdKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lb_IdKH)
                                        .addComponent(lb_SĐT)
                                        .addComponent(tx_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bt_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_HoKH)
                                    .addComponent(tx_HoKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_GioiTinh)
                                    .addComponent(cb_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lb_TrangThai)
                                        .addComponent(cb_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tx_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lb_TenKH))
                                    .addComponent(bt_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tx_DCKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(bt_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(bt_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cb_LuachonTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tx_NhapTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt_ImportExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_ExportExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(bt_Xong, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );
        //lệnh chuyển đổi các form
        chuyenForm();
        //Sự kiện bàn phím
        sukienEnter();
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
    public void sukienEnter()
    {
        tx_IdKH.requestFocus();
        tx_IdKH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_HoKH.requestFocus();
            }
        });
        tx_HoKH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_TenKH.requestFocus();
            }
        });
        tx_TenKH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_DCKH.requestFocus();
            }
        });
        tx_DCKH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_SDT.requestFocus();
            }
        });
        tx_SDT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    cb_GioiTinh.requestFocus();
            }
        });
        cb_GioiTinh.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    cb_TrangThai.requestFocus();
            }
        });
        cb_TrangThai.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_Them.requestFocus();
            }
        });
        bt_Them.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_Clear.requestFocus();
            }
        });
        cb_LuachonTimkiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_NhapTK.requestFocus();
            }
        });
        tx_NhapTK.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_TimKiem.doClick();
            }
        });
        bt_TimKiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_Xoa.requestFocus();
            }
        });
        bt_Xoa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_Sua.requestFocus();
            }
        });
        bt_Sua.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    bt_Xong.requestFocus();
            }
        });
    }
//    public static void main(String[] args) {
//        new GUI_Khachhang();
//    }
}

