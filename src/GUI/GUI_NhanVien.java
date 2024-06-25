package GUI;
import ConnectDB.XuLyDatabase;
import DTO.NhanVien_DTO;
import BUS.NhanVien_BUS;
import GUI.ThongTinDN;
import com.toedter.calendar.JCalendar;
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
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Vector;
public class GUI_NhanVien extends JFrame {
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
    private javax.swing.JButton bt_Clear;
    private javax.swing.JButton bt_Sua;
    private javax.swing.JButton bt_Them;
    private javax.swing.JButton bt_Lich;
    private javax.swing.JButton bt_TimKiem;
    private javax.swing.JButton bt_Xoa;
    private javax.swing.JButton bt_Xong;
    private javax.swing.JComboBox<String> cb_GioiTinh;
    private javax.swing.JComboBox<String> cb_LuaChon_TK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableNV;
    private javax.swing.JLabel lb_ChucVu;
    private javax.swing.JLabel lb_DiaChi;
    private javax.swing.JLabel lb_GioiTinh;
    private javax.swing.JLabel lb_Họ;
    private javax.swing.JLabel lb_ID;
    private javax.swing.JLabel lb_Luong;
    private javax.swing.JLabel lb_NgaySinh;
    private javax.swing.JLabel lb_SDT;
    private javax.swing.JLabel lb_Ten;
    private javax.swing.JLabel lb_anhNV;
    private javax.swing.JLabel lb_lc;
    private java.awt.List list1;
    private javax.swing.JComboBox<String> cb_ChucVu;
    private javax.swing.JTextField tx_DiaChi;
    private javax.swing.JTextField tx_Ho;
    private javax.swing.JTextField tx_ID;
    private javax.swing.JTextField tx_Luong;
    private javax.swing.JTextField tx_NgaySinh;
    private javax.swing.JTextField tx_Nhap_TK;
    private javax.swing.JTextField tx_SDT;
    private javax.swing.JTextField tx_Ten;
    private javax.swing.JButton bt_ExportExcel;
    private javax.swing.JButton bt_ImportExcel;
     
    private DefaultTableModel model;
    private ArrayList<NhanVien_DTO> dsNV;
    private NhanVien_BUS nv_BUS=new NhanVien_BUS();
    private Vector headerNV(Vector header)
    {
        header.add("ID");
        header.add("Chức vụ");
        header.add("Họ");
        header.add("Tên");
        header.add("Địa chỉ");
        header.add("SĐT");
        header.add("Ngày sinh");
        header.add("Giới tính");
        header.add("Lương"); 
        return header;
    }
    private Vector rowNV(Vector row,NhanVien_DTO i)
    {
        row.add(i.getMaNV());
        row.add(i.getChucvu());
        row.add(i.getHo());
        row.add(i.getTen());
        row.add(i.getDc());
        row.add(i.getSdt());
        row.add(String.valueOf(i.getNgaySinh().toLocalDate()));
        row.add(i.getGt());
         row.add(i.getLuong());
         return row;
    }
    private void hienThi()
    {
        if(dsNV.isEmpty()) dsNV=nv_BUS.getList();
            if(!dsNV.isEmpty())
            {
                Vector header=new Vector();
                header=headerNV(header);
                model=new DefaultTableModel(header, 0);
                for(NhanVien_DTO i:dsNV)
                {
                    Vector row=new Vector();
                    row=rowNV(row,i);
                    model.addRow(row);
                }
                tableNV.setModel(model);
            }
    }
    private boolean checkMa(ArrayList<NhanVien_DTO> ds,String ma)
    {
        for(NhanVien_DTO i:ds)
        {
            if(String.valueOf(i.getMaNV()).equals(ma))
                return false;
        }
        return true;
    }
    private void checkNhap()
    {
        if(tx_ID.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên!");
            tx_ID.requestFocus();
        }
        else if(tx_Ho.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập họ nhân viên!");
            tx_Ho.requestFocus();
        }
        else if(tx_Ten.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhân viên!");
            tx_Ten.requestFocus();
        }
        else if(tx_DiaChi.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhân viên!");
            tx_DiaChi.requestFocus();
        }
        else if(tx_SDT.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại nhân viên!");
            tx_SDT.requestFocus();
        }
        else if(tx_NgaySinh.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày sinh của nhân viên theo dạng yyyy-MM-dd !");
            tx_NgaySinh.requestFocus();
        }
        else if(tx_Luong.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập lương nhân viên!");
            tx_Luong.requestFocus();
        }

    }
    private void bt_ThemActionPerformed(java.awt.event.ActionEvent evt) {
        LocalDate localDate = null;
        
        if(tx_ID.getText().isEmpty() || tx_Ho.getText().isEmpty() || tx_Ten.getText().isEmpty() ||tx_DiaChi.getText().isEmpty() ||tx_SDT.getText().isEmpty()|| tx_NgaySinh.getText().isEmpty()  || tx_Luong.getText().isEmpty() )
                checkNhap(); 
        else 
        {
            if(checkMa(dsNV, tx_ID.getText())!=true)
            {
                JOptionPane.showMessageDialog(this, "Mã bạn nhập đã có trong cửa hàng vui lòng nhập lại!");
                tx_ID.setText("");
                tx_ID.requestFocus();
            }
            else if(tx_ID.getText().length()>10)
            {
                JOptionPane.showMessageDialog(this, "Mã bạn nhập lớn hơn giới hạn cho phép vui lòng nhập mã có độ lớn<10!");
                tx_ID.setText("");
                tx_ID.requestFocus();
            }
            else
            {
                    try {
                        Integer.parseInt(tx_ID.getText());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Mã Nhân viên bạn nhập không phải là số nguyên");
                        tx_ID.setText("");
                        tx_ID.requestFocus();
                        return; // Thoát khỏi phương thức
                    }
                    try {
                        Integer.parseInt(tx_SDT.getText());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Số điện thoại bạn nhập không phải là số nguyên");
                        tx_SDT.setText("");
                        tx_SDT.requestFocus();
                        return; // Thoát khỏi phương thức
                    }
                    try {
                    // Định dạng của chuỗi ngày tháng
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    // Chuyển đổi chuỗi thành LocalDate
                    localDate = LocalDate.parse(tx_NgaySinh.getText(), formatter);
                    } catch (DateTimeParseException e) {
                        JOptionPane.showMessageDialog(this,"Bạn nhập Ngày sinh sai hãy nhập theo form yyyy-MM-dd");
                        tx_NgaySinh.setText("");
                        tx_NgaySinh.requestFocus();
                        return;
                    }
                   try {
                        Float.parseFloat(tx_Luong.getText());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Lương bạn nhập không phải là số");
                        tx_Luong.setText("");
                        tx_Luong.requestFocus();
                        return; // Thoát khỏi phương thức
                    }
                    NhanVien_DTO nv = new NhanVien_DTO();
                    nv.setMaNV(tx_ID.getText());
                    nv.setChucvu(String.valueOf(cb_ChucVu.getSelectedIndex()));
                    nv.setHo(tx_Ho.getText());
                    nv.setTen(tx_Ten.getText());
                    nv.setDc(tx_DiaChi.getText());
                    nv.setSdt(tx_SDT.getText());
                    nv.setNgaySinh(localDate.atStartOfDay());
                    nv.setGt(String.valueOf(cb_GioiTinh.getSelectedItem()));
                    nv.setLuong(Float.parseFloat(tx_Luong.getText()));
                    dsNV=nv_BUS.themNhanVien(nv);
                    Vector header=new Vector();
                    header=headerNV(header);
                   if(model.getRowCount()==0)
                        {
                            model=new DefaultTableModel(header, 0);
                        }
                    Vector row=new Vector();
                    row =rowNV(row,dsNV.get(dsNV.size()-1));
                    model.addRow(row);
                    tableNV.setModel(model);
                    JOptionPane.showMessageDialog(this, "Thêm nhân viên có mã "+tx_ID.getText()+" thành công");
                    bt_ClearActionPerformed(evt);
            }
        }                                     
        
    }
    private void bt_SuaActionPerformed(java.awt.event.ActionEvent evt) {
    int i = tableNV.getSelectedRow();
    if (i >= 0 && i < dsNV.size()) {
        LocalDate localDate = null;
        if ((tx_Ho.getText().isEmpty() || tx_Ten.getText().isEmpty() || tx_DiaChi.getText().isEmpty() ||
                tx_SDT.getText().isEmpty() || tx_Luong.getText().isEmpty())) {
            checkNhap();
        } else {
                try {
                        Integer.parseInt(tx_SDT.getText());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Số điện thoại bạn nhập không phải là số nguyên");
                        tx_SDT.setText("");
                        tx_SDT.requestFocus();
                        return; // Thoát khỏi phương thức
                    }
                    try {
                    // Định dạng của chuỗi ngày tháng
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    // Chuyển đổi chuỗi thành LocalDate
                    localDate = LocalDate.parse(tx_NgaySinh.getText(), formatter);
                    } catch (DateTimeParseException e) {
                        JOptionPane.showMessageDialog(this,"Bạn nhập Ngày sinh sai hãy nhập theo form yyyy-MM-dd");
                        tx_NgaySinh.setText("");
                        tx_NgaySinh.requestFocus();
                        return;
                    }
                   try {
                        Float.parseFloat(tx_Luong.getText());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Lương bạn nhập không phải là số");
                        tx_Luong.setText("");
                        tx_Luong.requestFocus();
                        return; // Thoát khỏi phương thức
                    }
                    NhanVien_DTO nv = new NhanVien_DTO();
                    nv.setMaNV(tx_ID.getText());
                    nv.setChucvu(String.valueOf(cb_ChucVu.getSelectedIndex()));
                    nv.setHo(tx_Ho.getText());
                    nv.setTen(tx_Ten.getText());
                    nv.setDc(tx_DiaChi.getText());
                    nv.setSdt(tx_SDT.getText());
                    nv.setNgaySinh(localDate.atStartOfDay());
                    nv.setGt(String.valueOf(cb_GioiTinh.getSelectedItem()));
                    nv.setLuong(Float.parseFloat(tx_Luong.getText()));
                    dsNV=nv_BUS.SuaNhanVien(i,nv);
                    // Cập nhật dữ liệu trong bảng
                    model.setValueAt(nv.getChucvu(), i, 1);
                    model.setValueAt(nv.getHo(), i, 2);
                    model.setValueAt(nv.getTen(), i, 3);
                    model.setValueAt(nv.getDc(), i, 4);
                    model.setValueAt(nv.getSdt(), i, 5);
                    model.setValueAt(nv.getNgaySinh(), i, 6);
                    model.setValueAt(nv.getGt(), i, 7);
                    model.setValueAt(nv.getLuong(), i, 8);
                    tableNV.setModel(model);
                    
                    JOptionPane.showMessageDialog(this, "Sửa nhân viên có mã "+tx_ID.getText()+" thành công");
                    bt_ClearActionPerformed(evt);
        }
    }
}

    private void bt_XoaActionPerformed(java.awt.event.ActionEvent evt) {
        int i=tableNV.getSelectedRow();
        if(i>=0 &&i< dsNV.size())
        {
            String ma=tx_ID.getText();
            dsNV=nv_BUS.XoaNhanVien(i, ma);
            model.removeRow(i);
            tableNV.setModel(model);        
            bt_ClearActionPerformed(evt);
           JOptionPane.showMessageDialog(this, "Bạn đã xóa Nhân viên có mã "+ma);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Đã vượt quá độ lớn của danh sách");
        }
    }
    private void bt_ClearActionPerformed(java.awt.event.ActionEvent evt) {
        tx_ID.setEnabled(true);
        tx_ID.setDisabledTextColor(Color.BLACK);
        tx_ID.setText("");
        cb_ChucVu.setSelectedIndex(0);
        tx_Ho.setText("");
        tx_Ten.setText("");
        tx_DiaChi.setText("");
        tx_SDT.setText("");
        tx_NgaySinh.setText("");
        cb_GioiTinh.setSelectedIndex(0);
        tx_Luong.setText("");
    }
    private void bt_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {
        if(tx_Nhap_TK.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Vui lòng nhập nội dung cần tìm");
            tx_Nhap_TK.requestFocus();
        }
        else
        {
            DefaultTableModel modelTam = new DefaultTableModel();
            modelTam=nv_BUS.TimKiem( String.valueOf(cb_LuaChon_TK.getSelectedItem()), tx_Nhap_TK.getText());
            if(modelTam.getRowCount()>0)
            {
                tableNV.setModel(modelTam);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Cửa hàng không có thứ bạn tìm");
            }
            tx_Nhap_TK.setText("");
        }
    }
    private void bt_ExportExcelActionPerformed(java.awt.event.ActionEvent evt) {
        nv_BUS.exportExcel();
    }
    private void bt_ImportExcelActionPerformed(java.awt.event.ActionEvent evt) {
        nv_BUS.importExcel();
        hienThi();

    }
    private void bt_XongActionPerformed(java.awt.event.ActionEvent evt) {
         tableNV.setModel(model);
    }
    private void tableNVMouseClicked(java.awt.event.MouseEvent evt) {  
        int i=tableNV.getSelectedRow();
        if(i>=0 && i<dsNV.size())
        {
            tx_ID.setEnabled(false);
            tx_ID.setDisabledTextColor(Color.GRAY);
            NhanVien_DTO nv=new NhanVien_DTO();
            nv=dsNV.get(i);
            tx_ID.setText(String.valueOf(nv.getMaNV()));
            cb_ChucVu.setSelectedItem(nv.getChucvu());
            tx_Ho.setText(nv.getHo());
            tx_Ten.setText(nv.getTen());
            tx_DiaChi.setText(nv.getDc());
            tx_SDT.setText(nv.getSdt());
            tx_NgaySinh.setText(String.valueOf(nv.getNgaySinh().toLocalDate()));
            cb_GioiTinh.setSelectedItem(nv.getGt());
            tx_Luong.setText(String.valueOf(nv.getLuong()));
            cb_ChucVu.requestFocus();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Đã vượt quá độ lớn của danh sách");
        }
        
    }
    private void bt_LichActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JDialog dialog = new JDialog(this, "Chọn ngày", true);
        dialog.setSize(200, 200);
        dialog.setLocationRelativeTo(this);
        int x = this.getX() + (this.getWidth() - dialog.getWidth()) / 2;
        int y = this.getY()+40 + (this.getHeight() - dialog.getHeight()) / 2 ;

        // Đặt vị trí mới cho cuốn lịch
        dialog.setLocation(x, y);
        JCalendar calendar = new JCalendar();
        dialog.add(calendar);
        
        JButton selectButton = new JButton("Chọn");
        selectButton.addActionListener(e -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String selectedDate = dateFormat.format(calendar.getDate());
            tx_NgaySinh.setText(selectedDate);
            dialog.dispose();
        });
        
        dialog.add(selectButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    public GUI_NhanVien() {
        
        setTitle("Quản lí nhân viên");
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
        
        bt_nv.setBackground(new java.awt.Color(153,255,153));
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
        //Nhan Vien
        list1 = new java.awt.List();
        lb_anhNV = new javax.swing.JLabel();
        lb_lc = new javax.swing.JLabel();
        lb_ID = new javax.swing.JLabel();
        tx_ID = new javax.swing.JTextField();
        lb_ChucVu = new javax.swing.JLabel();
        cb_ChucVu = new javax.swing.JComboBox<>();
        lb_Họ = new javax.swing.JLabel();
        tx_Ho = new javax.swing.JTextField();
        lb_Ten = new javax.swing.JLabel();
        tx_Ten = new javax.swing.JTextField();
        lb_DiaChi = new javax.swing.JLabel();
        tx_DiaChi = new javax.swing.JTextField();
        lb_SDT = new javax.swing.JLabel();
        tx_SDT = new javax.swing.JTextField();
        lb_GioiTinh = new javax.swing.JLabel();
        cb_GioiTinh = new javax.swing.JComboBox<>();
        lb_NgaySinh = new javax.swing.JLabel();
        tx_NgaySinh = new javax.swing.JTextField();
        lb_Luong = new javax.swing.JLabel();
        tx_Luong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNV = new javax.swing.JTable();
        bt_Them = new javax.swing.JButton();
        bt_Sua = new javax.swing.JButton();
        bt_Clear = new javax.swing.JButton();
        cb_LuaChon_TK = new javax.swing.JComboBox<>();
        tx_Nhap_TK = new javax.swing.JTextField();
        bt_TimKiem = new javax.swing.JButton();
        bt_Xoa = new javax.swing.JButton();
        bt_Xong = new javax.swing.JButton();
        bt_ImportExcel = new javax.swing.JButton();
        bt_ExportExcel = new javax.swing.JButton();
        bt_Lich = new javax.swing.JButton();
        model=new DefaultTableModel();
        dsNV=new ArrayList<NhanVien_DTO>();
        ImageIcon anhNV= new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\icons8-account-64.png");
        ImageIcon anhNV_resized = new ImageIcon(anhNV.getImage().getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH));
        lb_anhNV.setIcon(anhNV_resized); 
        lb_anhNV.setPreferredSize(new java.awt.Dimension(24, 24));

        lb_lc.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_lc.setText("Quản lí nhân viên");

        lb_ID.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_ID.setText("ID");

        tx_ID.setPreferredSize(new java.awt.Dimension(100, 22));

        lb_ChucVu.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_ChucVu.setText("Chức vụ");

        lb_Họ.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_Họ.setText("Họ");

        lb_Ten.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_Ten.setText("Tên");

        lb_DiaChi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_DiaChi.setText("Địa chỉ");

        lb_SDT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_SDT.setText("SĐT");

        lb_GioiTinh.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_GioiTinh.setText("Giới tính");

        cb_GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        cb_GioiTinh.setPreferredSize(new java.awt.Dimension(100, 22));

        lb_NgaySinh.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_NgaySinh.setText("Ngày sinh");

        lb_Luong.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_Luong.setText("Lương");

        tableNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Chức vụ", "Họ", "Tên", "Địa chỉ", "SĐT", "Ngày sinh", "Giới tính", "Lương"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableNV);

        bt_Them.setBackground(new java.awt.Color(255, 204, 204));
        ImageIcon anhThem= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-add-27.png");
        ImageIcon anhThem_resized = new ImageIcon(anhThem.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Them.setIcon(anhThem_resized); 
        bt_Them.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhSua= new ImageIcon("D:\\vietcpp\\.vscode/doan_java/Image/icons8-update-left-rotation-27.png");
        ImageIcon anhSua_resized = new ImageIcon(anhSua.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Sua.setIcon(anhSua_resized); // NOI18N
        bt_Sua.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhClear= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\clean-icon2.png");
        ImageIcon anhClear_resized = new ImageIcon(anhClear.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Clear.setIcon(anhClear_resized);
        bt_Clear.setPreferredSize(new java.awt.Dimension(24, 24));

        cb_LuaChon_TK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Chức vụ", "Họ", "Tên", "Địa chỉ", "Giới tính", "Lương" }));

        ImageIcon anhTK= new ImageIcon("D:\\vietcpp\\.vscode\\\\doan_java\\\\Image\\\\icons8-google-web-search-27.png");
        ImageIcon anhTK_resized = new ImageIcon(anhTK.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_TimKiem.setIcon(anhTK_resized);
        bt_TimKiem.setPreferredSize(new java.awt.Dimension(24, 24));
        
        bt_Lich.setBackground(new java.awt.Color(255, 204, 204));
        ImageIcon anhLich=new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\lich.jpg"); // NOI18N
        ImageIcon anhLich_resized = new ImageIcon(anhLich.getImage().getScaledInstance(28, 28, java.awt.Image.SCALE_SMOOTH));
        bt_Lich.setIcon(anhLich_resized);
        bt_Lich.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhXoa= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\Button-Delete-icon.png");
        ImageIcon anhXoa_resized = new ImageIcon(anhXoa.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Xoa.setIcon(anhXoa_resized);
        bt_Xoa.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhXong= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\sign-check-icon.png");
        ImageIcon anhXong_resized = new ImageIcon(anhXong.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Xong.setIcon(anhXong_resized);
        bt_Xong.setPreferredSize(new java.awt.Dimension(24, 24));

        cb_ChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lí", "Bán hàng" }));
        cb_ChucVu.setPreferredSize(new java.awt.Dimension(100, 22));

        ImageIcon anhImportExcel= new ImageIcon("D:\\vietcpp\\.vscode\\\\doan_java\\\\Image\\\\icons8-microsoft-excel-27.png");
        ImageIcon anhImportExcel_resized = new ImageIcon(anhImportExcel.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_ImportExcel.setIcon(anhImportExcel_resized); // NOI18N
        bt_ImportExcel.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhExportExcel= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-export-excel-27.png");
        ImageIcon anhExportExcel_resized = new ImageIcon(anhExportExcel.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_ExportExcel.setIcon(anhExportExcel_resized); // NOI18N
        bt_ExportExcel.setPreferredSize(new java.awt.Dimension(24, 24));
        hienThi();
        bt_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            // Thêm nhân viên vào danh sách và cập nhật bảng
            bt_ThemActionPerformed(evt);
            }
        });
        bt_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_XoaActionPerformed(evt);
            }
        });
        bt_Lich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_LichActionPerformed(evt);
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

        tableNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNVMouseClicked(evt);
            }
        });
        javax.swing.GroupLayout chitietLayout = new javax.swing.GroupLayout(chitiet);
        chitiet.setLayout(chitietLayout);
        chitietLayout.setHorizontalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(chitietLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lb_Ten, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(lb_ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lb_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(tx_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(chitietLayout.createSequentialGroup()
                                            .addComponent(lb_anhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lb_lc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, chitietLayout.createSequentialGroup()
                                            .addComponent(lb_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(22, 22, 22)
                                            .addComponent(cb_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(bt_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lb_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lb_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(22, 22, 22)
                                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tx_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cb_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tx_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tx_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_Lich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addComponent(cb_LuaChon_TK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tx_Nhap_TK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_Họ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_SDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_Luong, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(tx_Ho, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt_Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(tx_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(tx_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addComponent(bt_Xong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(bt_ImportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_ExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        chitietLayout.setVerticalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chitietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_anhNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_lc))
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_ID)
                            .addComponent(tx_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_ChucVu)
                            .addComponent(lb_Họ)
                            .addComponent(tx_Ho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_Ten)
                                .addComponent(tx_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_DiaChi)
                                .addComponent(tx_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_SDT)
                                .addComponent(tx_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_NgaySinh)
                                    .addComponent(tx_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_Luong)
                                    .addComponent(tx_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_GioiTinh)
                                    .addComponent(cb_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(bt_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(bt_Lich, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cb_LuaChon_TK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tx_Nhap_TK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_Xong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_ImportExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_ExportExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 159, Short.MAX_VALUE)
                .addComponent(chitiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 65, Short.MAX_VALUE)
                .addComponent(chitiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        //chuyen form
        chuyenForm();

        // Thêm các panel vào JFrame
        add(tieude);
        add(menu);
        add(chitiet);
        //Sự kiện bàn phím
        sukienEnter();
        
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
            bt_duyet.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                 
                }
            });
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
        tx_ID.requestFocus();
        tx_ID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    cb_ChucVu.requestFocus();
            }
        });
        cb_ChucVu.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_Ho.requestFocus();
            }
        });
        tx_Ho.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_Ten.requestFocus();
            }
        });
        tx_Ten.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_DiaChi.requestFocus();
            }
        });
        tx_DiaChi.addKeyListener(new KeyAdapter() {
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
                    tx_NgaySinh.requestFocus();
            }
        });
        tx_NgaySinh.addKeyListener(new KeyAdapter() {
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
                    tx_Luong.requestFocus();
            }
        });
        tx_Luong.addKeyListener(new KeyAdapter() {
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
        cb_LuaChon_TK.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_Nhap_TK.requestFocus();
            }
        });
        tx_Nhap_TK.addKeyListener(new KeyAdapter() {
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
    public static void main(String[] args) {
        new GUI_NhanVien();
    }
}

