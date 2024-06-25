package GUI;
import ConnectDB.XuLyDatabase;
import BUS.CTKM_BUS;
import BUS.KMTheoSP_BUS;
import BUS.KMTheoTT_BUS;
import BUS.SanPham_BUS;
import GUI.ThongTinDN;
import DTO.CTKM_DTO;
import DTO.KMtheoSP_DTO;
import DTO.KMtheoTTien_DTO;
import DTO.SanPham_DTO;
import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.awt.*;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Vector;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class GUI_CTKM extends JFrame {
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
    ImageIcon icon = new ImageIcon("D:\\vietcpp\\.vscode/doan_java/Image/276-2764901_www-agisac-gov-in-admin-png.png"); 
    JLabel jlb_anh = new JLabel();
    private javax.swing.JButton bt_Clear_CTKM;
    private javax.swing.JButton bt_Clear_KMSP;
    private javax.swing.JButton bt_Clear_KMTT;
    private javax.swing.JButton bt_Sua_CTKM;
    private javax.swing.JButton bt_Sua_KMSP;
    private javax.swing.JButton bt_Sua_KMTT;
     private javax.swing.JButton bt_LichBD;
    private javax.swing.JButton bt_LichKT;
    private javax.swing.JButton bt_Them_CTKM;
    private javax.swing.JButton bt_Them_KMSP;
    private javax.swing.JButton bt_Them_KMTT;
    private javax.swing.JButton bt_TimKiem_CTKM;
    private javax.swing.JButton bt_TimKiem_KMSP;
    private javax.swing.JButton bt_TimKiem_TT;
    private javax.swing.JButton bt_Xoa_CTKM;
    private javax.swing.JButton bt_Xoa_KMSP;
    private javax.swing.JButton bt_Xoa_KMTT;
    private javax.swing.JButton bt_Xong_CTKM;
    private javax.swing.JButton bt_Xong_KMSP;
    private javax.swing.JButton bt_Xong_KMTT;
    private javax.swing.JComboBox<String> cb_TKiemCTKM;
    private javax.swing.JComboBox<String> cb_TKiemKMSP;
    private javax.swing.JComboBox<String> cb_TKiemKMTT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_CTKM;
    private javax.swing.JLabel lb_KMTheoTT;
    private javax.swing.JLabel lb_KMtheoSP;
    private javax.swing.JLabel lb_maCT;
    private javax.swing.JLabel lb_maCT_KMSP;
    private javax.swing.JLabel lb_maCT_KMTT;
    private javax.swing.JLabel lb_maKM_KMTT;
    private javax.swing.JLabel lb_maSP_KMSP;
    private javax.swing.JLabel lb_ngayBD;
    private javax.swing.JLabel lb_ngayKT;
    private javax.swing.JLabel lb_phanTram_KMSP;
    private javax.swing.JLabel lb_phanTram_KMTT;
    private javax.swing.JLabel lb_tenCT;
    private javax.swing.JLabel lb_tienMin;
    private javax.swing.JTable table_CTKM;
    private javax.swing.JTable table_KMTT;
    private javax.swing.JTable table_KMTheoSP;
    private javax.swing.JTextField tx_NhapTKiemCTKM;
    private javax.swing.JTextField tx_NhapTKiemKMSP;
    private javax.swing.JTextField tx_NhapTKiemKMTT;
    private javax.swing.JTextField tx_maCT;
    private javax.swing.JTextField tx_maCT_KMSP;
    private javax.swing.JTextField tx_maCT_KMTT;
    private javax.swing.JTextField tx_maKM_KMTT;
    private javax.swing.JTextField tx_maSP_KMSP;
    private javax.swing.JTextField tx_ngayBD;
    private javax.swing.JTextField tx_ngayKT;
    private javax.swing.JTextField tx_phanTram_KMSP;
    private javax.swing.JTextField tx_phanTram_KMTT;
    private javax.swing.JTextField tx_tenCT;
    private javax.swing.JTextField tx_tienMin_KMTT;
    private DefaultTableModel modelCT=new DefaultTableModel();
    private ArrayList<CTKM_DTO> dsCT=new ArrayList<CTKM_DTO>();
    private DefaultTableModel modelKMSP=new DefaultTableModel();
    private ArrayList<KMtheoSP_DTO> dsKMSP=new ArrayList<KMtheoSP_DTO>();
    private DefaultTableModel modelKMTT=new DefaultTableModel();
    private ArrayList<KMtheoTTien_DTO> dsKMTT=new ArrayList<KMtheoTTien_DTO>();
    private ArrayList<SanPham_DTO> dsSP=new ArrayList<SanPham_DTO>();
    private CTKM_BUS ct_BUS=new CTKM_BUS();
    private KMTheoTT_BUS kmtt_BUS=new KMTheoTT_BUS();
    private KMTheoSP_BUS kmsp_BUS=new KMTheoSP_BUS();
    private SanPham_BUS sp_BUS=new SanPham_BUS();
    private JTable Tb_MaCTKMSP;
    private JScrollPane scrollMaCTKMSP;
    private JTable Tb_MaSP;
    private JScrollPane scrollMaSP;
    private JTable Tb_MaCTKMTT;
    private JScrollPane scrollMaCTKMTT;
    private Vector headerCT(Vector he)
    {
        he.add("Mã CT");
        he.add("Tên CT");
        he.add("Ngày BD");
        he.add("Ngày KT");
        return he;
    }
    private Vector headerKMSP(Vector he)
    {
        he.add("Mã CT");
        he.add("Mã SP");
        he.add("Phần %");
        return he;
    }
    private Vector headerKMTT(Vector he)
    {
        he.add("Mã KM");
        he.add("Mã CT");
        he.add("Tiền Min");
        he.add("Phần %");
        return he;
    }
    private Vector rowCT(Vector row,CTKM_DTO i)
    {
        row.add(i.getMaCT());
        row.add(i.getTenCT());
        row.add(String.valueOf(i.getNgayBD().toLocalDate()));
        row.add(i.getNgayKT());
        return row;
    }
    private Vector rowKMSP(Vector rowSP,KMtheoSP_DTO i)
    {
        rowSP.add(i.getMaCT());
        rowSP.add(i.getMaSP());
        rowSP.add(i.getPhanTram_KM());
        return rowSP;
    }
    private Vector rowKMTT(Vector rowTT,KMtheoTTien_DTO i)
    {
        rowTT.add(i.getMaKM());
        rowTT.add(i.getMaCT());
                
        rowTT.add(i.getTienMin());
        rowTT.add(i.getPhanTram_KM());
        return rowTT;
    }
    private void hienThi()
    {
        if(dsCT.isEmpty()) dsCT=ct_BUS.getList();
        if(dsKMSP.isEmpty()) dsKMSP=kmsp_BUS.getList();
        if(dsKMTT.isEmpty()) dsKMTT=kmtt_BUS.getList();
        dsSP=sp_BUS.getList();
        if(!dsCT.isEmpty())
        {
            Vector header=new Vector();
            header=headerCT(header);
            modelCT=new DefaultTableModel(header, 0);
            for(CTKM_DTO i:dsCT)
            {
                Vector row=new Vector();
                row=rowCT(row,i);
                modelCT.addRow(row);
            }
            table_CTKM.setModel(modelCT);
        }
        if(!dsKMSP.isEmpty())
        {
            Vector headerSP=new Vector();
            headerSP=headerKMSP(headerSP);
            modelKMSP=new DefaultTableModel(headerSP, 0);
            for(KMtheoSP_DTO i:dsKMSP)
            {
                Vector rowSP=new Vector();
                rowSP=rowKMSP(rowSP,i);
                modelKMSP.addRow(rowSP);
            }
            table_KMTheoSP.setModel(modelKMSP);
        }
        if(!dsKMTT.isEmpty())
        {
            Vector headerTT=new Vector();
            headerTT=headerKMTT(headerTT);
            modelKMTT=new DefaultTableModel(headerTT, 0);
            for(KMtheoTTien_DTO i:dsKMTT)
            {
                Vector rowTT=new Vector();
                rowTT=rowKMTT(rowTT,i);
                modelKMTT.addRow(rowTT);
            }
            table_KMTT.setModel(modelKMTT);
        }
        
    }
    private void bt_ClearCTActionPerformed(java.awt.event.ActionEvent evt) {
        tx_maCT.setEnabled(true);
        tx_maCT.setDisabledTextColor(Color.BLACK);
        tx_maCT.setText("");
        tx_tenCT.setText("");
        tx_ngayBD.setText("");
        tx_ngayKT.setText("");
    }
    private void bt_ClearKMSPActionPerformed(java.awt.event.ActionEvent evt) {
        tx_maCT_KMSP.setEnabled(true);
        tx_maCT_KMSP.setDisabledTextColor(Color.BLACK);
        tx_maSP_KMSP.setEnabled(true);
        tx_maSP_KMSP.setDisabledTextColor(Color.BLACK);
        tx_maCT_KMSP.setText("");
        tx_maSP_KMSP.setText("");
        tx_phanTram_KMSP.setText("");
    }
    private void bt_ClearKMTTActionPerformed(java.awt.event.ActionEvent evt) {
        tx_maKM_KMTT.setEnabled(true);
        tx_maKM_KMTT.setDisabledTextColor(Color.BLACK);
        tx_maCT_KMTT.setEnabled(true);
        tx_maCT_KMTT.setDisabledTextColor(Color.BLACK);
        tx_maCT_KMTT.setText("");
        tx_maKM_KMTT.setText("");
        tx_tienMin_KMTT.setText("");
        tx_phanTram_KMTT.setText("");
        
    }
    private void table_CTKMMouseClicked(java.awt.event.MouseEvent evt)
    {
        int i=table_CTKM.getSelectedRow();
        if(i>=0 && i<dsCT.size())
        {
            tx_maCT.setEnabled(false);
            tx_maCT.setDisabledTextColor(Color.GRAY);
            CTKM_DTO ct=new CTKM_DTO();
            ct=dsCT.get(i);
            tx_maCT.setText(ct.getMaCT());
            tx_tenCT.setText(ct.getTenCT());
            tx_ngayBD.setText(String.valueOf(ct.getNgayBD().toLocalDate()));
            tx_ngayKT.setText(String.valueOf(ct.getNgayKT().toLocalDate()));
            DefaultTableModel modelTamKMSP=new DefaultTableModel();
            modelTamKMSP=ct_BUS.TKKMSP_CTKM(dsKMSP, ct.getMaCT(), modelTamKMSP);
            DefaultTableModel modelTamKMTT=new DefaultTableModel();
            modelTamKMTT=ct_BUS.TKKMTT_CTKM(dsKMTT, ct.getMaCT(), modelTamKMTT);
            table_KMTheoSP.setModel(modelTamKMSP);
            table_KMTT.setModel(modelTamKMTT);
            tx_tenCT.requestFocus();
        }
    }
    private void table_KMSPMouseClicked(java.awt.event.MouseEvent evt)
    {
        int i=table_KMTheoSP.getSelectedRow();
        if(i>=0 && i<dsKMSP.size())
        {
            tx_maCT_KMSP.setEnabled(false);
            tx_maCT_KMSP.setDisabledTextColor(Color.GRAY);
            tx_maSP_KMSP.setEnabled(false);
            tx_maSP_KMSP.setDisabledTextColor(Color.GRAY);
            KMtheoSP_DTO ct=new KMtheoSP_DTO();
            ct=dsKMSP.get(i);
            tx_maCT_KMSP.setText(ct.getMaCT());
            tx_maSP_KMSP.setText(ct.getMaSP());
            tx_phanTram_KMSP.setText(String.valueOf(ct.getPhanTram_KM()));
            tx_maSP_KMSP.requestFocus();
        }
    }
    private void table_KMTTMouseClicked(java.awt.event.MouseEvent evt)
    {
        int i= table_KMTT.getSelectedRow();
        if(i>=0 && i<dsKMTT.size())
        {
            tx_maKM_KMTT.setEnabled(false);
            tx_maKM_KMTT.setDisabledTextColor(Color.GRAY);
            tx_maCT_KMTT.setEnabled(false);
            tx_maCT_KMTT.setDisabledTextColor(Color.GRAY);
            KMtheoTTien_DTO ct=new KMtheoTTien_DTO();
            ct=dsKMTT.get(i);
            tx_maKM_KMTT.setText(ct.getMaKM());
            tx_maCT_KMTT.setText(ct.getMaCT());
            tx_tienMin_KMTT.setText(String.valueOf(ct.getTienMin()));
            tx_phanTram_KMTT.setText(String.valueOf(ct.getPhanTram_KM()));
            tx_tienMin_KMTT.requestFocus();
        }
    }
    private void bt_XongCTActionPerformed(java.awt.event.ActionEvent evt) {
        table_CTKM.setModel(modelCT);
        table_KMTheoSP.setModel(modelKMSP);
        table_KMTT.setModel(modelKMTT);
   }
   private void bt_XongKMSPActionPerformed(java.awt.event.ActionEvent evt) {
        table_KMTheoSP.setModel(modelKMSP);
    }
    private void bt_XongKMTTActionPerformed(java.awt.event.ActionEvent evt) {
        table_KMTT.setModel(modelKMTT);
    }
    private boolean checkMaCT(ArrayList<CTKM_DTO> ds,String ma)
    {
        for(CTKM_DTO i:ds)
        {
            if(i.getMaCT().equals(ma))
                return false;
        }
        return true;
    }
    private boolean checkMaSP(ArrayList<SanPham_DTO> ds,String ma)
    {
        for(SanPham_DTO i:ds)
        {
            if(i.getMaSp().equals(ma))
                return false;
        }
        return true;
    }
    private boolean checkMaKM(ArrayList<KMtheoTTien_DTO> ds,String ma)
    {
        for(KMtheoTTien_DTO i:ds)
        {
            if(i.getMaKM().equals(ma))
            {
                return false;
            }
        }
        return true;
    }
    private void checkNhapCT()
    {
        if(tx_maCT.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã CTKM!");
            tx_maCT.requestFocus();
        }
        else if(tx_tenCT.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên CTKM!");
            tx_tenCT.requestFocus();
        }
        else if(tx_ngayBD.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày bắt đầu chương trình!");
            tx_ngayBD.requestFocus();
        }
        else if(tx_ngayKT.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày kết thúc chương trình!");
            tx_ngayKT.requestFocus();
        }
    }
    private void checkNhapKMSP(){
        if(tx_maCT_KMSP.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã CTKM cho KM theo SP!");
            tx_maCT_KMSP.requestFocus();
        }
        else if(tx_maSP_KMSP.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm được khuyến mãi!");
            tx_maSP_KMSP.requestFocus();
        }
        else if(tx_phanTram_KMSP.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập phần trắm được khuyến mãi của sản phẩm!");
            tx_phanTram_KMSP.requestFocus();
        }
    }
    private void checkNhapKMTT()
    {
        if(tx_maKM_KMTT.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khuyễn mãi của KMTT!");
            tx_maKM_KMTT.requestFocus();
        }

        else if(tx_maCT_KMTT.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã CTKM cho KM theo TT!");
            tx_maCT_KMTT.requestFocus();
        }
        else if(tx_tienMin_KMTT.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền nhỏ nhất để được KM!");
            tx_tienMin_KMTT.requestFocus();
        }
        else if(tx_phanTram_KMTT.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập phần trăm được khuyến mãi theo tổng tiền!");
            tx_phanTram_KMTT.requestFocus();
        }
    }
    private boolean checkMaCTVaMaSP(String maCT,String maSP)
    {
        for(KMtheoSP_DTO i:dsKMSP)
        {
            if(i.getMaCT().equals(maCT) && i.getMaSP().equals(maSP))
                return false;
        }
        return true;
    }
    private CTKM_DTO getCTKM(String ma)
    {
        for(CTKM_DTO i:dsCT)
            if(i.getMaCT().equals(ma))
                return i;
        return null;
    }
    private boolean checkCTKMSP(String mact,String masp)
    {
        for(KMtheoSP_DTO i:dsKMSP)
            if(i.getMaSP().equals(masp))
            {
                if(getCTKM(i.getMaCT()).getNgayKT().isAfter( getCTKM(mact).getNgayBD()) && getCTKM(i.getMaCT()).getNgayKT().isAfter(getCTKM(mact).getNgayKT()))
                    return false;
            }
        return true;
    }
    private boolean checkCTKMTT(String mact,float tienmin)
    {
        for(KMtheoTTien_DTO i:dsKMTT)
        {
            if(i.getTienMin()==tienmin)
            {
                if(getCTKM(i.getMaCT()).getNgayKT().isAfter( getCTKM(mact).getNgayBD()) && getCTKM(i.getMaCT()).getNgayKT().isAfter(getCTKM(mact).getNgayKT()))
                    return false;
            }
        }
        return true;
    }
    private LocalDate dinhDangNgay(LocalDate local,String text)
    {
        try {
            // Định dạng của chuỗi ngày tháng
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // Chuyển đổi chuỗi thành LocalDate
            local = LocalDate.parse(text, formatter);
            return local;
            } catch (DateTimeParseException e) {
                return null;
                
            }
    }
    private void bt_ThemCTKMActionPerformed(java.awt.event.ActionEvent evt) {
        LocalDate ngayBD=null;
        LocalDate ngayKT=null;
        ngayBD=dinhDangNgay(ngayBD, tx_ngayBD.getText());
            ngayKT=dinhDangNgay(ngayKT,tx_ngayKT.getText());
        if(tx_maCT.getText().isEmpty() || tx_tenCT.getText().isEmpty() ||tx_ngayBD.getText().isEmpty() || tx_ngayKT.getText().isEmpty() )
        {
            checkNhapCT();
        }
        else if (ngayBD == null) {
            JOptionPane.showMessageDialog(this,"Bạn nhập Ngày Bắt Đầu sai hãy nhập theo form yyyy-MM-dd");
            tx_ngayBD.setText("");
            tx_ngayBD.requestFocus();
        }
        else if(ngayKT == null) {
                JOptionPane.showMessageDialog(this,"Bạn nhập Ngày Kết Thúc sai hãy nhập theo form yyyy-MM-dd");
                tx_ngayKT.setText("");
                tx_ngayKT.requestFocus();    
        }
        else if(ngayBD.isAfter(ngayKT)) {
                System.out.print("ĐÚNg");
                JOptionPane.showMessageDialog(this,"Ngày bắt đầu sau ngày kết thúc vui lòng kiểm tra lại");
                tx_ngayKT.setText("");
                tx_ngayKT.requestFocus();    
        }
        else if(tx_maCT.getText().length()>10)
        {
            JOptionPane.showMessageDialog(this,"Mã CT không được có độ dài lớn hơn 10 mời nhập lại");
            tx_maCT.setText("");
            tx_maCT.requestFocus();
        }
        else
        {
            ngayBD=dinhDangNgay(ngayBD, tx_ngayBD.getText());
            ngayKT=dinhDangNgay(ngayKT,tx_ngayKT.getText());
            if(!checkMaCT(dsCT, tx_maCT.getText()))
            {
                JOptionPane.showMessageDialog(this, "Mã CT bạn nhập đã có trong cửa hàng vui lòng nhập lại!");
                tx_maCT.setText("");
                tx_maCT.requestFocus();
            }
            else
            {
                CTKM_DTO ct = new CTKM_DTO();
                ct.setMaCT(tx_maCT.getText());
                ct.setTenCT(tx_tenCT.getText());
                ct.setNgayBD(ngayBD.atStartOfDay());
                ct.setNgayKT(ngayKT.atStartOfDay());
                dsCT=ct_BUS.themCTKM(ct);
                Vector header=new Vector();
                header=headerCT(header);
                if(modelCT.getRowCount()==0)
                {
                    modelCT=new DefaultTableModel(header, 0); 
                }
                Vector row=new Vector();
                row=rowCT(row,dsCT.get(dsCT.size()-1));
                modelCT.addRow(row);
                table_CTKM.setModel(modelCT);
                JOptionPane.showMessageDialog(this, "Thêm CTKM có mã " +tx_maCT.getText()+" thành công");
                bt_ClearCTActionPerformed(evt);
            }
        }
    }
    private void bt_ThemKMSPActionPerformed(java.awt.event.ActionEvent evt) {
        if(tx_maCT_KMSP.getText().isEmpty() || tx_maSP_KMSP.getText().isEmpty() || tx_phanTram_KMSP.getText().isEmpty())
        {
            checkNhapKMSP();
        }
        else if(checkMaCT(dsCT,tx_maCT_KMSP.getText()))
        {
            JOptionPane.showMessageDialog(this, "Mã CTKM bạn nhập không có trong cửa hàng vui lòng nhập lại!");
            tx_maCT_KMSP.setText("");
            tx_maCT_KMSP.requestFocus();
        }
        else if(checkMaSP(dsSP,tx_maSP_KMSP.getText()))
        {
            JOptionPane.showMessageDialog(this, "Mã Sản phẩm bạn nhập không có trong cửa hàng vui lòng nhập lại!");
            tx_maSP_KMSP.setText("");
            tx_maSP_KMSP.requestFocus();
        }
        else if(!checkMaCTVaMaSP(tx_maCT_KMSP.getText(),tx_maSP_KMSP.getText()))
        {
            JOptionPane.showMessageDialog(this, "Mã CT và Mã SP bạn nhập đã tồn tại trong dsKMSP");
            tx_maCT_KMSP.requestFocus();
        }
        else if(!checkCTKMSP(tx_maCT_KMSP.getText(),tx_maSP_KMSP.getText()))
        {
            JOptionPane.showMessageDialog(this, "Mã "+tx_maSP_KMSP.getText()+" đang có chương trình khuyến mãi và vẫn còn thời gian khuyến mãi vui lòng kiểm tra lại");
            tx_maSP_KMSP.requestFocus();
        }
        else
        {
            KMtheoSP_DTO kmSP = new KMtheoSP_DTO();
            kmSP.setMaCT(tx_maCT_KMSP.getText());
            kmSP.setMaSP(tx_maSP_KMSP.getText());
            kmSP.setPhanTram_KM(Float.parseFloat(tx_phanTram_KMSP.getText()));
            dsKMSP=kmsp_BUS.ThemKMSP(kmSP);
            Vector header=new Vector();
            header=headerKMSP(header);
            if(modelKMSP.getRowCount()==0)
            {
                modelKMSP=new DefaultTableModel(header, 0);
            }
            Vector row=new Vector();
            row=rowKMSP(row,dsKMSP.get(dsKMSP.size()-1));
            modelKMSP.addRow(row);
            table_KMTheoSP.setModel(modelKMSP);
            bt_ClearKMSPActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Thêm chương trình khuyễn mãi theo sản phẩm có mãCTKM " +tx_maCT_KMSP.getText()+" thành công");
        }
    }
    private void bt_ThemKMTTActionPerformed(java.awt.event.ActionEvent evt) {
        if(tx_maKM_KMTT.getText().isEmpty() || tx_maCT_KMTT.getText().isEmpty() ||tx_tienMin_KMTT.getText().isEmpty() ||tx_phanTram_KMTT.getText().isEmpty())
        {
            checkNhapKMTT();
        }
        else if(!checkMaKM(dsKMTT,tx_maKM_KMTT.getText()))
        {
            JOptionPane.showMessageDialog(this, "Mã Khuyễn mãi theo TT đã có trong cửa hàng vui lòng nhập lại");
            tx_maKM_KMTT.setText("");
            tx_maKM_KMTT.requestFocus();
        }
        else if(checkMaCT(dsCT,tx_maCT_KMTT.getText()))
        {
            JOptionPane.showMessageDialog(this, "Mã CTKM không có trong cửa hàng vui lòng nhập lại");
            tx_maCT_KMTT.setText("");
            tx_maCT_KMTT.requestFocus();
        }
        else if(tx_maKM_KMTT.getText().length()>10)
        {
            JOptionPane.showMessageDialog(this,"Mã khuyến mãi theo tổng tiền không được có độ lớn >10");
            tx_maKM_KMTT.setText("");
            tx_maKM_KMTT.requestFocus();
        }
        else if(!checkCTKMTT(tx_maCT_KMTT.getText(),Float.parseFloat(tx_tienMin_KMTT.getText())))
        {
            JOptionPane.showMessageDialog(this,"Tiền min "+tx_tienMin_KMTT.getText()+" hiện đang có chương trình khuyến mãi và vẫn còn thời gian khuyến mãi vui lòng kiểm tra lại");
            tx_tienMin_KMTT.setText("");
            tx_tienMin_KMTT.requestFocus();
        }
        else 
        {
            KMtheoTTien_DTO km = new KMtheoTTien_DTO();
            km.setMaKM(tx_maKM_KMTT.getText());
            km.setMaCT(tx_maCT_KMTT.getText());
            km.setTienMin(Float.parseFloat(tx_tienMin_KMTT.getText()));
            km.setPhanTram_KM(Float.parseFloat(tx_phanTram_KMTT.getText()));
            dsKMTT=kmtt_BUS.ThemKMTT( km);
            Vector header=new Vector();
            header=headerKMTT(header);
            if(modelKMTT.getRowCount()==0)
            {
                 modelKMTT=new DefaultTableModel(header, 0);
            }
            Vector row=new Vector();
            row=rowKMTT(row,dsKMTT.get(dsKMTT.size()-1));
            modelKMTT.addRow(row);
            table_KMTT.setModel(modelKMTT);
            bt_ClearKMTTActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Thêm chương trình khuyến mãi theo tổng tiền có mã " +tx_maKM_KMTT.getText()+" thành công");
        }
    }
    private void bt_XoaCTKMActionPerformed(java.awt.event.ActionEvent evt)
    {
        int i=table_CTKM.getSelectedRow();
        if(i>=0 && i<dsCT.size())
        {
            String ma=tx_maCT.getText();
            dsCT=ct_BUS.xoaCTKM(i, ma);
            modelCT.removeRow(i);
            table_CTKM.setModel(modelCT);
            for(int j=0;j<dsKMSP.size();j++)
            {
                if(dsKMSP.get(j).getMaCT().equals(ma))
                {
                    dsKMSP=kmsp_BUS.xoaTheoMaCT(j, ma);
                    modelKMSP.removeRow(j);
                    j--;
                    
                }
            }
            table_KMTheoSP.setModel(modelKMSP);
            for(int h=0;h<dsKMTT.size();h++)
            {
                if(dsKMTT.get(h).getMaCT().equals(ma))
                {
                    dsKMTT=kmtt_BUS.xoaTheoMaCT(h, ma);
                    modelKMTT.removeRow(h);
                    h--;
                    
                }
            }
            table_KMTT.setModel(modelKMTT);
            JOptionPane.showMessageDialog(this, "Xóa CTKM có mã " +tx_maCT.getText()+" thành công");
            bt_ClearCTActionPerformed(evt);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Đã vượt quá độ lớn của danh sách CTKM");
        }
    }
    private void bt_XoaKMSPActionPerformed(java.awt.event.ActionEvent evt)
    {
        int i=table_KMTheoSP.getSelectedRow();
        if(i>=0 && i<dsKMSP.size())
        {
            dsKMSP=kmsp_BUS.xoaKMSP(i, tx_maCT_KMSP.getText(), tx_maSP_KMSP.getText());
            modelKMSP.removeRow(i);
            table_KMTheoSP.setModel(modelKMSP);
            bt_ClearKMSPActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Xóa CTKM theo sản phẩm có mã CTKM " +tx_maCT_KMSP.getText()+" thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Đã vượt quá độ lớn của danh sách KMSP");
        }
    }
    private void bt_XoaKMTTActionPerformed(java.awt.event.ActionEvent evt)
    {
        int i=table_KMTT.getSelectedRow();
        if(i>=0 && i<dsKMTT.size())
        {
            dsKMTT=kmtt_BUS.xoaKMTT(i, tx_maCT_KMTT.getText(),tx_maKM_KMTT.getText());
            modelKMTT.removeRow(i);
            table_KMTT.setModel(modelKMTT);
            bt_ClearKMTTActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Xóa CTKM theo tổng tiền có mã " +tx_maKM_KMTT.getText()+" thành công");
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Đã vượt quá độ lớn của danh sách KMSP");
        }
    }
    private void bt_SuaCTKMActionPerformed(java.awt.event.ActionEvent evt) {  
        int i=table_CTKM.getSelectedRow();
        if(i>=0 && i<dsCT.size())
        {
            LocalDate ngayBD=null;
            LocalDate ngayKT=null;
            ngayBD=dinhDangNgay(ngayBD, tx_ngayBD.getText());
            ngayKT=dinhDangNgay(ngayKT,tx_ngayKT.getText());
            if( tx_tenCT.getText().isEmpty() ||tx_ngayBD.getText().isEmpty() || tx_ngayKT.getText().isEmpty() ) {
                checkNhapCT();
            }
            else if (ngayBD == null) {
                JOptionPane.showMessageDialog(this,"Bạn nhập Ngày Bắt Đầu sai hãy nhập theo form yyyy-MM-dd");
                tx_ngayBD.setText("");
                tx_ngayBD.requestFocus();
            }
            else if(ngayKT == null) {
                JOptionPane.showMessageDialog(this,"Bạn nhập Ngày Kết Thúc sai hãy nhập theo form yyyy-MM-dd");
                tx_ngayKT.setText("");
                tx_ngayKT.requestFocus();    
            }
            else if(ngayBD.isAfter(ngayKT)) {
                JOptionPane.showMessageDialog(this,"Ngày bắt đầu sau ngày kết thúc vui lòng kiểm tra lại");
                tx_ngayKT.setText("");
                tx_ngayKT.requestFocus();    
            }
            else
            {
                CTKM_DTO ct = new CTKM_DTO();
                ct.setMaCT(tx_maCT.getText());
                ct.setTenCT(tx_tenCT.getText());
                ct.setNgayBD(ngayBD.atStartOfDay());
                ct.setNgayKT(ngayKT.atStartOfDay());
                dsCT=ct_BUS.suaCTKM(i,ct);
                modelCT.setValueAt(ct.getTenCT(), i,1);
                modelCT.setValueAt(String.valueOf(ct.getNgayBD()), i, 2);
                modelCT.setValueAt(String.valueOf(ct.getNgayKT()), i, 3);
                table_CTKM.setModel(modelCT);
                bt_ClearCTActionPerformed(evt);
                JOptionPane.showMessageDialog(this, "Sửa CTKM có mã " +tx_maCT.getText()+" thành công");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Đã vượt quá độ lớn của danh sách");
        }
        
    }
    private void bt_SuaKMSPActionPerformed(java.awt.event.ActionEvent evt)
    {
        int i=table_KMTheoSP.getSelectedRow();
        if(i>=0 && i<dsKMSP.size())
        {
            if(tx_phanTram_KMSP.getText().isEmpty())
            {
                checkNhapKMSP();
            }
            else
            {
                KMtheoSP_DTO kmSP = new KMtheoSP_DTO();
                kmSP.setMaCT(tx_maCT_KMSP.getText());
                kmSP.setMaSP(tx_maSP_KMSP.getText());
                kmSP.setPhanTram_KM(Float.parseFloat(tx_phanTram_KMSP.getText()));
                dsKMSP=kmsp_BUS.suaKMSP(i, kmSP);
                modelKMSP.setValueAt(kmSP.getPhanTram_KM(), i, 2);
                table_KMTheoSP.setModel(modelKMSP);
                bt_ClearKMSPActionPerformed(evt);
                JOptionPane.showMessageDialog(this, "Sửa CTKM theo sản phẩm có mã CTKM " +tx_maCT_KMSP.getText()+" thành công");
            }
            
        }else
            {
                JOptionPane.showMessageDialog(this,"Đã vượt quá độ lớn của danh sách KMSP");
            }
        
    }
     private void bt_SuaKMTTActionPerformed(java.awt.event.ActionEvent evt)
     {
         int i=table_KMTT.getSelectedRow();
         if(i>=0 && i<dsKMTT.size())
         {
            if(tx_tienMin_KMTT.getText().isEmpty() ||tx_phanTram_KMTT.getText().isEmpty())
            {
                checkNhapKMTT();
            }
            else
            {
                KMtheoTTien_DTO km = new KMtheoTTien_DTO();
                km.setMaKM(tx_maKM_KMTT.getText());
                km.setMaCT(tx_maCT_KMTT.getText());
                km.setTienMin(Float.parseFloat(tx_tienMin_KMTT.getText()));
                km.setPhanTram_KM(Float.parseFloat(tx_phanTram_KMTT.getText()));
                dsKMTT=kmtt_BUS.suaKMTT(i,km);
                modelKMTT.setValueAt(km.getTienMin(), i, 2);
                modelKMTT.setValueAt(km.getPhanTram_KM(), i, 3);
                table_KMTT.setModel(modelKMTT);
                bt_ClearKMTTActionPerformed(evt);
                JOptionPane.showMessageDialog(this, "Sửa CTKM theo tổng tiền có mã " +tx_maKM_KMTT.getText()+" thành công");
            }
         }
         else
        {
            JOptionPane.showMessageDialog(this,"Đã vượt quá độ lớn của danh sách KMTT");
        }
     }
    
    private void bt_TimKiemCTActionPerformed(java.awt.event.ActionEvent evt)
    {
        
        if(tx_NhapTKiemCTKM.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Vui lòng nhập nội dung cần tìm của CTKM");
            tx_NhapTKiemCTKM.requestFocus();
        }
        else
        {
            DefaultTableModel[] results =ct_BUS.TK(dsKMSP, dsKMTT,(String) cb_TKiemCTKM.getSelectedItem(),tx_NhapTKiemCTKM.getText());
            
            if(results!=null)
            {
                table_CTKM.setModel(results[0]);
                table_KMTheoSP.setModel(results[1]);
                table_KMTT.setModel(results[2]);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Cửa hàng không có yêu cầu  bạn tìm");
            }
            tx_NhapTKiemCTKM.setText("");
        }
    }
    private void bt_TimKiemKMSPActionPerformed(java.awt.event.ActionEvent evt)
    {
        if(tx_NhapTKiemKMSP.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Vui lòng nhập nội dung cần tìm ở KMSP");
            tx_NhapTKiemKMSP.requestFocus();
        }
        else
        {
            DefaultTableModel model_tam = new DefaultTableModel();
            model_tam=kmsp_BUS.TimKiem((String)cb_TKiemKMSP.getSelectedItem(), tx_NhapTKiemKMSP.getText());
            if(model_tam.getRowCount()>0)
            {
                table_KMTheoSP.setModel(model_tam);
                tx_NhapTKiemKMSP.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Cửa hàng không có yêu cầu bạn tìm");
            }
            tx_NhapTKiemKMSP.setText("");
        }
    }
    private void bt_TimKiemKMTTActionPerformed(java.awt.event.ActionEvent evt)
    {
        if(tx_NhapTKiemKMTT.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Vui lòng nhập nội dung cần tìm ở KMSP");
            tx_NhapTKiemKMTT.requestFocus();
        }
        else
        {
            DefaultTableModel model_tam = new DefaultTableModel();
            model_tam=kmtt_BUS.TimKiem((String) cb_TKiemKMTT.getSelectedItem(), tx_NhapTKiemKMTT.getText());
            if(model_tam.getRowCount()>0)
            {
                table_KMTT.setModel(model_tam);

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Cửa hàng không có yêu cầu bạn tìm");
            }
            tx_NhapTKiemKMTT.setText("");
        }
    }
    private void bt_LichBDActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JDialog dialog = new JDialog(this, "Chọn ngày", true);
        dialog.setSize(200, 200);
        dialog.setLocationRelativeTo(this);
        int x = this.getX() -10+ (this.getWidth() - dialog.getWidth()) / 2;
        int y = this.getY() + (this.getHeight() - dialog.getHeight()) / 2 ;

        // Đặt vị trí mới cho cuốn lịch
        dialog.setLocation(x, y);
        JCalendar calendar = new JCalendar();
        dialog.add(calendar);
        
        JButton selectButton = new JButton("Chọn");
        selectButton.addActionListener(e -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String selectedDate = dateFormat.format(calendar.getDate());
            tx_ngayBD.setText(selectedDate);
            dialog.dispose();
        });
        
        dialog.add(selectButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    private void bt_LichKTActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JDialog dialog = new JDialog(this, "Chọn ngày", true);
        dialog.setSize(200, 200);
        dialog.setLocationRelativeTo(this);
        int x = this.getX()-5+ (this.getWidth() - dialog.getWidth()) / 2;
        int y = this.getY()+20 + (this.getHeight() - dialog.getHeight()) / 2 ;

        // Đặt vị trí mới cho cuốn lịch
        dialog.setLocation(x, y);
        JCalendar calendar = new JCalendar();
        dialog.add(calendar);
        
        JButton selectButton = new JButton("Chọn");
        selectButton.addActionListener(e -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String selectedDate = dateFormat.format(calendar.getDate());
            tx_ngayKT.setText(selectedDate);
            dialog.dispose();
        });
        
        dialog.add(selectButton, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    private void ViTriCuaTableMa()
    {
        //Mã CT của KMSP
        Tb_MaCTKMSP=new JTable();
        DefaultTableModel modelMaCTKMSP=new DefaultTableModel(new Object[]{""},0);
        Tb_MaCTKMSP.setModel(modelMaCTKMSP);
        scrollMaCTKMSP=new JScrollPane(Tb_MaCTKMSP);
        chitiet.add(scrollMaCTKMSP);
        scrollMaCTKMSP.setBounds(542,260,100, 50);
        scrollMaCTKMSP.setVisible(false);
        //Mã SP của KmSP
        Tb_MaSP=new JTable();
        DefaultTableModel modelMaSP=new DefaultTableModel(new Object[]{""},0);
        Tb_MaSP.setModel(modelMaSP);
        scrollMaSP=new JScrollPane(Tb_MaSP);
        chitiet.add(scrollMaSP);
        scrollMaSP.setBounds(542,293,100, 50);
        scrollMaSP.setVisible(false);
        //Mã CT của KMTT
        Tb_MaCTKMTT=new JTable();
        DefaultTableModel modelMaCTKMTT=new DefaultTableModel(new Object[]{""},0);
        Tb_MaCTKMTT.setModel(modelMaCTKMTT);
        scrollMaCTKMTT=new JScrollPane(Tb_MaCTKMTT);
        chitiet.add(scrollMaCTKMTT);
        scrollMaCTKMTT.setBounds(74,465,100, 50);
        scrollMaCTKMTT.setVisible(false);
    }
    private void searchMaCT(JTable tb,String ma)
    {
        DefaultTableModel modelMaCT = (DefaultTableModel) tb.getModel();
        modelMaCT.setRowCount(0);
        for(CTKM_DTO i:dsCT)
            if(i.getMaCT().toLowerCase().contains(ma.toLowerCase()))
                modelMaCT.addRow(new Object[]{i.getMaCT()});
    }
    private void searchMaSP(String ma)
    {
        DefaultTableModel modelMaSP = (DefaultTableModel) Tb_MaSP.getModel();
        modelMaSP.setRowCount(0);
        for(SanPham_DTO i:dsSP)
            if(i.getMaSp().toLowerCase().contains(ma.toLowerCase()))
                modelMaSP.addRow(new Object[]{i.getMaSp()});
    }
    private void txMaMouseListener()
    {
        tx_maCT_KMSP.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e)
            {
                scrollMaCTKMSP.setVisible(true);
                tx_maSP_KMSP.setVisible(false);
                searchMaCT(Tb_MaCTKMSP,tx_maCT_KMSP.getText());
                
            }
        });
        tx_maSP_KMSP.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e)
            {
                scrollMaSP.setVisible(true);
                tx_phanTram_KMSP.setVisible(false);
                searchMaSP(tx_maSP_KMSP.getText());
            }
        });
        tx_maCT_KMTT.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e)
            {
                scrollMaCTKMTT.setVisible(true);
                tx_tienMin_KMTT.setVisible(false);
                searchMaCT(Tb_MaCTKMTT,tx_maCT_KMTT.getText());
            }
        });
        
    }
    private void tableMaCTKMSP_Click(java.awt.event.MouseEvent evt)
    {
        int i=Tb_MaCTKMSP.getSelectedRow();
        if(i>-1)
        {
            tx_maCT_KMSP.setText(Tb_MaCTKMSP.getValueAt(i,0).toString());
            scrollMaCTKMSP.setVisible(false);
            tx_maSP_KMSP.setVisible(true);
        }
        
        
    }
    private void tableMaSP_Click(java.awt.event.MouseEvent evt)
    {
        int i=Tb_MaSP.getSelectedRow();
        if(i>-1)
        {
            tx_maSP_KMSP.setText(Tb_MaSP.getValueAt(i,0).toString());
            scrollMaSP.setVisible(false);
            tx_phanTram_KMSP.setVisible(true);
        }
    }
    private void tableMaCTKMTT_Click(java.awt.event.MouseEvent evt)
    {
        int i=Tb_MaCTKMTT.getSelectedRow();
        if(i>-1)
        {
            tx_maCT_KMTT.setText(Tb_MaCTKMTT.getValueAt(i,0).toString());
            scrollMaCTKMTT.setVisible(false);
            tx_tienMin_KMTT.setVisible(true);
        }
    }
    
    public GUI_CTKM() {
        
        setTitle("Quản lí chương trình khuyến mãi");
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
        
        bt_km.setBackground(new java.awt.Color(153,255,153));
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
        //Chương trình khuyến mãi
        lb_CTKM = new javax.swing.JLabel();
        lb_maCT = new javax.swing.JLabel();
        tx_maCT = new javax.swing.JTextField();
        lb_tenCT = new javax.swing.JLabel();
        tx_tenCT = new javax.swing.JTextField();
        lb_ngayBD = new javax.swing.JLabel();
        tx_ngayBD = new javax.swing.JTextField();
        lb_ngayKT = new javax.swing.JLabel();
        tx_ngayKT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_KMTT = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_CTKM = new javax.swing.JTable();
        lb_KMtheoSP = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_KMTheoSP = new javax.swing.JTable();
        bt_Them_CTKM = new javax.swing.JButton();
        bt_Sua_CTKM = new javax.swing.JButton();
        bt_Clear_CTKM = new javax.swing.JButton();
        bt_Xoa_CTKM = new javax.swing.JButton();
        cb_TKiemCTKM = new javax.swing.JComboBox<>();
        tx_NhapTKiemCTKM = new javax.swing.JTextField();
        bt_TimKiem_CTKM = new javax.swing.JButton();
        lb_maCT_KMSP = new javax.swing.JLabel();
        lb_maSP_KMSP = new javax.swing.JLabel();
        lb_phanTram_KMSP = new javax.swing.JLabel();
        tx_maCT_KMSP = new javax.swing.JTextField();
        tx_maSP_KMSP = new javax.swing.JTextField();
        tx_phanTram_KMSP = new javax.swing.JTextField();
        bt_Them_KMSP = new javax.swing.JButton();
        bt_Sua_KMSP = new javax.swing.JButton();
        bt_Clear_KMSP = new javax.swing.JButton();
        cb_TKiemKMSP = new javax.swing.JComboBox<>();
        tx_NhapTKiemKMSP = new javax.swing.JTextField();
        bt_TimKiem_KMSP = new javax.swing.JButton();
        bt_Xoa_KMSP = new javax.swing.JButton();
        bt_Xong_CTKM = new javax.swing.JButton();
        bt_Xong_KMSP = new javax.swing.JButton();
        lb_KMTheoTT = new javax.swing.JLabel();
        lb_maKM_KMTT = new javax.swing.JLabel();
        lb_maCT_KMTT = new javax.swing.JLabel();
        lb_tienMin = new javax.swing.JLabel();
        lb_phanTram_KMTT = new javax.swing.JLabel();
        tx_maKM_KMTT = new javax.swing.JTextField();
        tx_maCT_KMTT = new javax.swing.JTextField();
        tx_tienMin_KMTT = new javax.swing.JTextField();
        tx_phanTram_KMTT = new javax.swing.JTextField();
        bt_Them_KMTT = new javax.swing.JButton();
        bt_Sua_KMTT = new javax.swing.JButton();
        bt_Clear_KMTT = new javax.swing.JButton();
        bt_Xoa_KMTT = new javax.swing.JButton();
        bt_Xong_KMTT = new javax.swing.JButton();
        cb_TKiemKMTT = new javax.swing.JComboBox<>();
        tx_NhapTKiemKMTT = new javax.swing.JTextField();
        bt_TimKiem_TT = new javax.swing.JButton();
        bt_LichBD = new javax.swing.JButton();
        bt_LichKT = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chitiet.setBackground(new java.awt.Color(204, 204, 204));
        chitiet.setPreferredSize(new java.awt.Dimension(750, 535));

        lb_CTKM.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_CTKM.setText("Quản lí chương trình khuyến mãi");

        lb_maCT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_maCT.setText("Mã CT");
        lb_maCT.setPreferredSize(new java.awt.Dimension(50, 16));

        lb_tenCT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_tenCT.setText("Tên CT");

        lb_ngayBD.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_ngayBD.setText("Ngày BĐ");

        lb_ngayKT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_ngayKT.setText("Ngày KT");

        table_KMTT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã KM", "Mã CT", "Tiền Min", "Phần %"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        // table_KMTT.addMouseListener(new java.awt.event.MouseAdapter() {
        //     public void mouseClicked(java.awt.event.MouseEvent evt) {
        //         table_KMTTMouseClicked(evt);
        //     }
        // });
        jScrollPane1.setViewportView(table_KMTT);

        table_CTKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã CT", "Tên CT", "Ngày BĐ", "Ngày KT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        // table_CTKM.addMouseListener(new java.awt.event.MouseAdapter() {
        //     public void mouseClicked(java.awt.event.MouseEvent evt) {
        //         table_CTKMMouseClicked(evt);
        //     }
        // });
        jScrollPane2.setViewportView(table_CTKM);

        lb_KMtheoSP.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_KMtheoSP.setText("Quản lí KM theo sản phẩm");

        table_KMTheoSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã CT", "Mã SP", "Phần % KM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        // table_KMTheoSP.addMouseListener(new java.awt.event.MouseAdapter() {
        //     public void mouseClicked(java.awt.event.MouseEvent evt) {
        //         table_KMTheoSPMouseClicked(evt);
        //     }
        // });
        jScrollPane3.setViewportView(table_KMTheoSP);

        bt_Them_CTKM.setBackground(new java.awt.Color(255, 153, 153));
        ImageIcon anhThem_CTKM= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-add-27.png");
        ImageIcon anhThemCTKM_resized = new ImageIcon(anhThem_CTKM.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Them_CTKM.setIcon(anhThemCTKM_resized); 
        bt_Them_CTKM.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhSuaCTKM= new ImageIcon("D:\\vietcpp\\.vscode\\\\doan_java/Image/icons8-update-left-rotation-27.png");
        ImageIcon anhSuaCTKM_resized = new ImageIcon(anhSuaCTKM.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Sua_CTKM.setIcon(anhSuaCTKM_resized); // NOI18N
        bt_Sua_CTKM.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhClearCTKM= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\clean-icon2.png");
        ImageIcon anhClearCTKM_resized = new ImageIcon(anhClearCTKM.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Clear_CTKM.setIcon(anhClearCTKM_resized);
        bt_Clear_CTKM.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhXoaCTKM= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\Button-Delete-icon.png");
        ImageIcon anhXoaCTKM_resized = new ImageIcon(anhXoaCTKM.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Xoa_CTKM.setIcon(anhXoaCTKM_resized);
        bt_Xoa_CTKM.setPreferredSize(new java.awt.Dimension(24, 24));

        cb_TKiemCTKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã CT", "Tên CT", "Ngày BĐ", "Ngày KT" }));

        bt_TimKiem_CTKM.setIcon(new javax.swing.ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-google-web-search-27.png")); // NOI18N
        bt_TimKiem_CTKM.setPreferredSize(new java.awt.Dimension(24, 24));

        lb_maCT_KMSP.setText("Mã CT");

        lb_maSP_KMSP.setText("Mã SP");

        lb_phanTram_KMSP.setText("Phần % KM");

        bt_Them_KMSP.setBackground(new java.awt.Color(255, 204, 204));
        ImageIcon anhThem_KMSP= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-add-27.png");
        ImageIcon anhThemKMSP_resized = new ImageIcon(anhThem_KMSP.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Them_KMSP.setIcon(anhThemKMSP_resized); 
        bt_Them_KMSP.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhSuaKMSP= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java/Image/icons8-update-left-rotation-27.png");
        ImageIcon anhSuaKMSP_resized = new ImageIcon(anhSuaKMSP.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Sua_KMSP.setIcon(anhSuaKMSP_resized);
        bt_Sua_KMSP.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhClearKMSP= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\clean-icon2.png");
        ImageIcon anhClearKMSP_resized = new ImageIcon(anhClearKMSP.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Clear_KMSP.setIcon(anhClearKMSP_resized);
        bt_Clear_KMSP.setPreferredSize(new java.awt.Dimension(24, 24));

        cb_TKiemKMSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã CT", "Mã SP", "Phần %" }));

        bt_TimKiem_KMSP.setBackground(new java.awt.Color(255, 204, 204));
        bt_TimKiem_KMSP.setIcon(new javax.swing.ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-google-web-search-27.png")); // NOI18N
        bt_TimKiem_KMSP.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhXoaKMSP= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\Button-Delete-icon.png");
        ImageIcon anhXoaKMSP_resized = new ImageIcon(anhXoaKMSP.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Xoa_KMSP.setIcon(anhXoaKMSP_resized);
        bt_Xoa_KMSP.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhXongCTKM= new ImageIcon("D:\\vietcpp\\.vscode\\\\doan_java\\Image\\sign-check-icon.png");
        ImageIcon anhXongCTKM_resized = new ImageIcon(anhXongCTKM.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Xong_CTKM.setIcon(anhXongCTKM_resized); // NOI18N
        bt_Xong_CTKM.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhXongKMSP= new ImageIcon("D:\\vietcpp\\.vscode\\\\doan_java\\Image\\sign-check-icon.png");
        ImageIcon anhXongKMSP_resized = new ImageIcon(anhXongKMSP.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Xong_KMSP.setIcon(anhXongKMSP_resized); // NOI18N
        bt_Xong_KMSP.setPreferredSize(new java.awt.Dimension(24, 24));

        lb_KMTheoTT.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_KMTheoTT.setText("Quản lí KM theo tổng tiền");

        lb_maKM_KMTT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_maKM_KMTT.setText("Mã KM");
        lb_maKM_KMTT.setPreferredSize(new java.awt.Dimension(50, 16));

        lb_maCT_KMTT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_maCT_KMTT.setText("Mã CT");
        lb_maCT_KMTT.setPreferredSize(new java.awt.Dimension(50, 16));

        lb_tienMin.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_tienMin.setText("Tiền Min");
        lb_tienMin.setPreferredSize(new java.awt.Dimension(50, 16));

        lb_phanTram_KMTT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_phanTram_KMTT.setText("Phần %");
        lb_phanTram_KMTT.setPreferredSize(new java.awt.Dimension(50, 16));

        bt_Them_KMTT.setBackground(new java.awt.Color(255, 204, 204));
        ImageIcon anhThem_KMTT= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-add-27.png");
        ImageIcon anhThemKMTT_resized = new ImageIcon(anhThem_KMTT.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Them_KMTT.setIcon(anhThemCTKM_resized); 
        bt_Them_KMTT.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhSuaKMTT= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java/Image/icons8-update-left-rotation-27.png");
        ImageIcon anhSuaKMTT_resized = new ImageIcon(anhSuaKMTT.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Sua_KMTT.setIcon(anhSuaKMTT_resized);
        bt_Sua_KMTT.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhClearKMTT= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\clean-icon2.png");
        ImageIcon anhClearKMTT_resized = new ImageIcon(anhClearKMTT.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Clear_KMTT.setIcon(anhClearKMTT_resized);
        bt_Clear_KMTT.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhXoaKMTT= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\Button-Delete-icon.png");
        ImageIcon anhXoaKMTT_resized = new ImageIcon(anhXoaKMTT.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Xoa_KMTT.setIcon(anhXoaKMTT_resized);
        bt_Xoa_KMTT.setPreferredSize(new java.awt.Dimension(24, 24));

        ImageIcon anhXongKMTT= new ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\sign-check-icon.png");
        ImageIcon anhXongKMTT_resized = new ImageIcon(anhXongKMTT.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        bt_Xong_KMTT.setIcon(anhXongKMTT_resized); // NOI18N
        bt_Xong_KMTT.setPreferredSize(new java.awt.Dimension(24, 24));

        cb_TKiemKMTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã KM","Mã CT", "Tiền Min", "Phần %" }));

        bt_TimKiem_TT.setBackground(new java.awt.Color(255, 204, 204));
        bt_TimKiem_TT.setIcon(new javax.swing.ImageIcon("D:\\vietcpp\\.vscode\\doan_java\\Image\\icons8-google-web-search-27.png")); // NOI18N
        bt_TimKiem_TT.setPreferredSize(new java.awt.Dimension(24, 24));
       

        bt_LichBD.setBackground(new java.awt.Color(255, 204, 204));
        ImageIcon anhLich=new ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\doan_java\\src\\Image\\lich.jpg"); // NOI18N
        ImageIcon anhLich_resized = new ImageIcon(anhLich.getImage().getScaledInstance(28, 28, java.awt.Image.SCALE_SMOOTH));
        bt_LichBD.setIcon(anhLich_resized);
        bt_LichBD.setPreferredSize(new java.awt.Dimension(24, 24));

        bt_LichKT.setIcon(anhLich_resized);
        bt_LichKT.setPreferredSize(new java.awt.Dimension(24, 24));

        
        
        hienThi();
        //các bảng hiện thị mã khi nhập
        ViTriCuaTableMa();
        txMaMouseListener();
        Tb_MaCTKMSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMaCTKMSP_Click(evt);
            }
        });
        Tb_MaSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMaSP_Click(evt);
            }
        });
        Tb_MaCTKMTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMaCTKMTT_Click(evt);
            }
        });
        chitiet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                scrollMaCTKMSP.setVisible(false);
                tx_maSP_KMSP.setVisible(true);
                tx_phanTram_KMSP.setVisible(true);
                scrollMaSP.setVisible(false);
                tx_tienMin_KMTT.setVisible(true);
                scrollMaCTKMTT.setVisible(false);
            }
        });
        bt_Clear_CTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_ClearCTActionPerformed(evt);
            }
        });
        bt_Clear_KMSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_ClearKMSPActionPerformed(evt);
            }
        });
        bt_Clear_KMTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_ClearKMTTActionPerformed(evt);
            }
        });
        table_CTKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_CTKMMouseClicked(evt);
            }
        });
        table_KMTheoSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_KMSPMouseClicked(evt);
            }
        });
        table_KMTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_KMTTMouseClicked(evt);
            }
        });
        bt_LichBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            // Thêm nhân viên vào danh sách và cập nhật bảng
            bt_LichBDActionPerformed(evt);
            }
        });
        bt_LichKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            // Thêm nhân viên vào danh sách và cập nhật bảng
            bt_LichKTActionPerformed(evt);
            }
        });
        bt_Xong_CTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_XongCTActionPerformed(evt);
            }
        });
        bt_Xong_KMSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_XongKMSPActionPerformed(evt);
            }
        });
        bt_Xong_KMTT.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_XongKMTTActionPerformed(evt);
            }
        });

        bt_Them_CTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            // Thêm nhân viên vào danh sách và cập nhật bảng
            bt_ThemCTKMActionPerformed(evt);
            }
        });
        bt_Them_KMSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            // Thêm nhân viên vào danh sách và cập nhật bảng
            bt_ThemKMSPActionPerformed(evt);
            }
        });
        bt_Them_KMTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            // Thêm nhân viên vào danh sách và cập nhật bảng
            bt_ThemKMTTActionPerformed(evt);
            }
        });
        bt_Xoa_CTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_XoaCTKMActionPerformed(evt);
            }
        });
        bt_Xoa_KMSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_XoaKMSPActionPerformed(evt);
            }
        });
        bt_Xoa_KMTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_XoaKMTTActionPerformed(evt);
            }
        });
        bt_Sua_CTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_SuaCTKMActionPerformed(evt);
            }
        });
        bt_Sua_KMSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_SuaKMSPActionPerformed(evt);
            }
        });
        bt_Sua_KMTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_SuaKMTTActionPerformed(evt);
            }
        });
        bt_TimKiem_CTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_TimKiemCTActionPerformed(evt);
            }
        });
        bt_TimKiem_KMSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_TimKiemKMSPActionPerformed(evt);
            }
        });
        bt_TimKiem_TT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                bt_TimKiemKMTTActionPerformed(evt);
            }
        });
        

        javax.swing.GroupLayout chitietLayout = new javax.swing.GroupLayout(chitiet);
        chitiet.setLayout(chitietLayout);
        chitietLayout.setHorizontalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_CTKM)
                .addGap(99, 99, 99)
                .addComponent(bt_Xong_CTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(chitietLayout.createSequentialGroup()
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cb_TKiemKMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lb_maSP_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lb_phanTram_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lb_maCT_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addComponent(tx_maCT_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bt_Them_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addComponent(tx_maSP_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bt_Sua_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addComponent(tx_NhapTKiemKMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bt_TimKiem_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_Xoa_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addComponent(tx_phanTram_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bt_Clear_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addComponent(cb_TKiemKMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(tx_NhapTKiemKMTT, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(chitietLayout.createSequentialGroup()
                                            .addComponent(lb_maKM_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tx_maKM_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(chitietLayout.createSequentialGroup()
                                            .addComponent(lb_maCT_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tx_maCT_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(chitietLayout.createSequentialGroup()
                                            .addComponent(lb_tienMin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tx_tienMin_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(chitietLayout.createSequentialGroup()
                                            .addComponent(lb_phanTram_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tx_phanTram_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt_TimKiem_TT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_Them_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_Sua_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_Clear_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_Xoa_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                                        .addComponent(lb_KMTheoTT, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(73, 73, 73)
                                        .addComponent(bt_Xong_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10))))))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(lb_maCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tx_maCT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(lb_tenCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tx_tenCT))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(lb_ngayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tx_ngayBD))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(lb_ngayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tx_ngayKT))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addComponent(cb_TKiemCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tx_NhapTKiemCTKM)))
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(bt_TimKiem_CTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(chitietLayout.createSequentialGroup()
                                        .addComponent(bt_LichKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bt_Clear_CTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                                        .addComponent(bt_LichBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bt_Xoa_CTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bt_Sua_CTKM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_Them_CTKM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(lb_KMtheoSP, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(bt_Xong_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        chitietLayout.setVerticalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_CTKM)
                    .addComponent(bt_Xong_CTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_maCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tx_maCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, chitietLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(bt_Them_CTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_tenCT)
                                .addComponent(tx_tenCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_Sua_CTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_ngayBD)
                                .addComponent(tx_ngayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_LichBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Xoa_CTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bt_LichKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_ngayKT)
                                .addComponent(tx_ngayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_Clear_CTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb_TKiemCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tx_NhapTKiemCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chitietLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(bt_TimKiem_CTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bt_Xong_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_KMtheoSP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_maCT_KMSP)
                                .addComponent(tx_maCT_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_Them_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lb_maSP_KMSP)
                                        .addComponent(tx_maSP_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bt_Sua_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lb_phanTram_KMSP)
                                        .addComponent(tx_phanTram_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bt_Clear_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_TimKiem_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(chitietLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cb_TKiemKMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tx_NhapTKiemKMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bt_Xoa_KMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cb_TKiemKMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tx_NhapTKiemKMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_TimKiem_TT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tx_maKM_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_maKM_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_Them_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tx_maCT_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_maCT_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_Sua_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tx_tienMin_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_tienMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_Clear_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_phanTram_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_phanTram_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Xoa_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(chitietLayout.createSequentialGroup()
                        .addGroup(chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_KMTheoTT)
                            .addComponent(bt_Xong_KMTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        //sự kiện Enter
        suKienEnter();
//      chuyển form
        chuyenForm();
        // Thêm các panel vào JFrame
        add(tieude);
        add(menu);
        add(chitiet);

        setVisible(true);
    }
    public void suKienEnter()
    {
        tx_maCT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_tenCT.requestFocus();
            }
        });
        tx_tenCT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_ngayBD.requestFocus();
            }
        });
        tx_ngayBD.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_ngayKT.requestFocus();
            }
        });
        tx_maCT_KMSP.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_maSP_KMSP.requestFocus();
            }
        });
        tx_maSP_KMSP.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_phanTram_KMSP.requestFocus();
            }
        });
        tx_maKM_KMTT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_maCT_KMTT.requestFocus();
            }
        });
        tx_maCT_KMTT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_tienMin_KMTT.requestFocus();
            }
        });
        tx_tienMin_KMTT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    tx_phanTram_KMTT.requestFocus();
            }
        });
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
    public static void main(String[] args) {
        new GUI_CTKM();
    }
}

