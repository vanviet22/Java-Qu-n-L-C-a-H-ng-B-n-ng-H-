/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import ConnectDB.XuLyDatabase;
import DTO.NhanVien_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class NhanVien_DAO {

    private XuLyDatabase xuLyDB = null;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private java.sql.Statement st;
    private ResultSet rs = null;
    public ArrayList<NhanVien_DTO> getAllNV()
    {
        ArrayList<NhanVien_DTO> dsNV=new ArrayList<NhanVien_DTO>();
        try
        {
          
            xuLyDB=new XuLyDatabase();
            conn=xuLyDB.openConnection();
            String qry="select * from nhanvien";
            ps = conn.prepareStatement(qry);
            rs=ps.executeQuery(qry);
            while(rs.next())
            {
                NhanVien_DTO nv=new NhanVien_DTO();
                nv.setMaNV(rs.getString(1));
                nv.setChucvu(rs.getString(2));
                nv.setHo(rs.getString(3));
                nv.setTen(rs.getString(4));
                nv.setDc(rs.getString(5));
                nv.setSdt(rs.getString(6));
                nv.setNgaySinh(rs.getTimestamp(7).toLocalDateTime());
                nv.setGt(rs.getString(8));
                nv.setLuong(rs.getFloat(9));
                dsNV.add(nv);
              
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(conn);
                ps.close();
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return dsNV;        
    }
    public ArrayList<NhanVien_DTO> getNVBanHang()
    {
        ArrayList<NhanVien_DTO> dsNV=new ArrayList<NhanVien_DTO>();
        try
        {
          
            xuLyDB=new XuLyDatabase();
            conn=xuLyDB.openConnection();
            String qry="select * from nhanvien";
            ps = conn.prepareStatement(qry);
            rs=ps.executeQuery(qry);
            while(rs.next())
            {
                if(rs.getString(2).equals("Bán Hàng"))
                {
                    NhanVien_DTO nv=new NhanVien_DTO();
                    nv.setMaNV(rs.getString(1));
                    nv.setChucvu(rs.getString(2));
                    nv.setHo(rs.getString(3));
                    nv.setTen(rs.getString(4));
                    nv.setDc(rs.getString(5));
                    nv.setSdt(rs.getString(6));
                    nv.setNgaySinh(rs.getTimestamp(7).toLocalDateTime());
                    nv.setGt(rs.getString(8));
                    nv.setLuong(rs.getFloat(9));
                    dsNV.add(nv);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(conn);
                ps.close();
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return dsNV;        
    }
    public void ThemNhanVien(NhanVien_DTO nv)
    {
        try
        {
            xuLyDB=new XuLyDatabase();
            conn=xuLyDB.openConnection();
            String qry="Insert into nhanvien Values (";
            qry=qry+"'"+nv.getMaNV()+"','"+nv.getChucvu()+"','"+nv.getHo()+"','"+nv.getTen()+"','"+nv.getDc()+"','"+nv.getSdt()+"','"+nv.getNgaySinh()+"','"+nv.getGt()+"',"+nv.getLuong()+")";
            st=conn.createStatement();
            st.executeUpdate(qry);        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
        }
        finally {
            try {
                xuLyDB.closeConnection(conn);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void XoaNhanVien(String ma)
    {
        try
            {
                xuLyDB= new XuLyDatabase();
                conn=xuLyDB.openConnection();
                st=conn.createStatement();
                String qry="Delete from nhanvien where ID='"+ma+"'";
                st.executeUpdate(qry);
                String qry2="Delete from user where ID='"+ma+"'";
                st.executeUpdate(qry2);
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
            }
            finally {
                try {
                    xuLyDB.closeConnection(conn);
                    ps.close();
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
    public void SuaNhanVien(NhanVien_DTO nv)
    {
        try {
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            st = conn.createStatement();
            String qry = "Update nhanvien Set ";
            qry = qry + "CHUCVU='" + nv.getChucvu() + "',HO='" + nv.getHo() + "',TEN='" + nv.getTen() + "',";
            qry = qry + "DIACHI='" + nv.getDc() + "',SDT='" + nv.getSdt() + "',NGAYSINH='" + nv.getNgaySinh() + "',GIOITINH='" + nv.getGt() + "',LUONG=" + nv.getLuong()+"  WHERE ID='"+nv.getMaNV()+"'";
            st.executeUpdate(qry);
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật dữ liệu: " + e.getMessage());
            } finally {
                try {
                    xuLyDB.closeConnection(conn);
                    ps.close();
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
}
