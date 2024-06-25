/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import ConnectDB.XuLyDatabase;
import DTO.KhachHang_DTO;
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
public class KhachHang_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private java.sql.Statement st;
    private ResultSet rs = null;
    public ArrayList<KhachHang_DTO> getAllKH()
    {
        ArrayList<KhachHang_DTO> dsKH=new ArrayList<KhachHang_DTO>();
        try
        {
            xuLyDB=new XuLyDatabase();
            conn=xuLyDB.openConnection();
            String qry="Select * from khachhang";
            ps = conn.prepareStatement(qry);
            rs=ps.executeQuery(qry);
            while(rs.next())
            {
                KhachHang_DTO kh=new KhachHang_DTO();
                kh.setMaKH(rs.getString(1));
                kh.setHo(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setDc(rs.getString(4));
                kh.setSdt(rs.getString(5));
                kh.setGt(rs.getString(6));
                int status = rs.getInt(7);
                if(status==1)
                    kh.setTrang_thai("Không chặn");
                else kh.setTrang_thai("Chặn"); 
                dsKH.add(kh);
            }
    }catch (SQLException e){
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
    return dsKH;
    }
    public void ThemKhachHang(KhachHang_DTO kh)
    {
        try
        {
            xuLyDB= new XuLyDatabase();
            conn=xuLyDB.openConnection();
            String qry="Insert into khachhang Values (";
            qry = qry + "'" + kh.getMaKH()+"','"+kh.getHo()+"','"+kh.getTen()+"','"+kh.getDc() + "','" + kh.getSdt() + "','" + kh.getGt() + "'";
            if(kh.getTrang_thai().equals("Không chặn"))
                qry=qry+","+1+")";
            else qry=qry+","+0+")";
            st=conn.createStatement();
            st.executeUpdate(qry);
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
    public void XoaKhachHang(String ma)
    {
        try
            {
                xuLyDB= new XuLyDatabase();
                conn=xuLyDB.openConnection();
                st=conn.createStatement();
                String qry="Delete from khachhang where MAKH='"+ma+"'";
                st.executeUpdate(qry);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
            }finally {
                try {
                    xuLyDB.closeConnection(conn);
                    ps.close();
                    rs.close();
                } catch (SQLException e) {
                     e.printStackTrace();
                }
            }
    }
    public void SuaKhachHang(KhachHang_DTO kh)
    {
        try{
            xuLyDB= new XuLyDatabase();
            conn=xuLyDB.openConnection();
            st=conn.createStatement();
            String qry="Update khachhang Set ";
            qry = qry +"HO='"+ kh.getHo()+"'"+",TEN='"+kh.getTen()+"',DIACHI='"+kh.getDc()+"',SDT='"+kh.getSdt()+"',GIOITINH='"+kh.getGt() + "'";
            if(kh.getTrang_thai().equals("Không chặn"))
                qry=qry+",TRANGTHAI="+1+" WHERE MAKH='"+kh.getMaKH()+"'";
            else qry=qry+",TRANGTHAI="+0+" where MAKH='"+kh.getMaKH()+"'";
            st.executeUpdate(qry);
        }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật dữ liệu: " + e.getMessage());
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
}
