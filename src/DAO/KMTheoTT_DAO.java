/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import ConnectDB.XuLyDatabase;
import DTO.KMtheoTTien_DTO;
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
public class KMTheoTT_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private java.sql.Statement st;
    private ResultSet rs = null;
    public ArrayList<KMtheoTTien_DTO> getAllKMTT()
    {
        ArrayList<KMtheoTTien_DTO> ds=new ArrayList<KMtheoTTien_DTO>();
        try
        {
            xuLyDB=new XuLyDatabase();
            conn=xuLyDB.openConnection();
            String qry="select * from kmtheott";
            ps = conn.prepareStatement(qry);
            rs=ps.executeQuery(qry);
            while(rs.next())
            {
                KMtheoTTien_DTO km=new KMtheoTTien_DTO();
                km.setMaKM(rs.getString(1));
                km.setMaCT(rs.getString(2));
                km.setTienMin(rs.getFloat(3));
                km.setPhanTram_KM(rs.getFloat(4));
                ds.add(km);
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
        return ds;
    }
    public void ThemKMTT(KMtheoTTien_DTO km)
    {
        try
        {
            xuLyDB=new XuLyDatabase();
            conn=xuLyDB.openConnection();
            String qry="Insert into kmtheott Values (";
            qry=qry+"'"+km.getMaKM()+"','"+km.getMaCT()+"',"+km.getTienMin()+","+km.getPhanTram_KM()+")";
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
    public void XoaKMTT(String maKM,String maCT)
    {
        try
            {
                xuLyDB= new XuLyDatabase();
                conn=xuLyDB.openConnection();
                st=conn.createStatement();
                String qry="Delete from kmtheott where MAKM='"+maKM+"' and MACT='"+maCT+"'";
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
    public void XoaKMTTTheoMACT(String maCT)
    {
        try
            {
                xuLyDB= new XuLyDatabase();
                conn=xuLyDB.openConnection();
                st=conn.createStatement();
                String qry="Delete from kmtheott where MACT='"+maCT+"'";
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
    public void SuaKMtt(KMtheoTTien_DTO ct)
    {
        try {
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            st = conn.createStatement();
            String qry = "Update kmtheott Set ";
            qry = qry +"SOTIENNN="+ct.getTienMin()+ ",PHAMTRAMKM="+ct.getPhanTram_KM()+" WHERE MAKM='"+ct.getMaKM()+"' AND MACT='"+ct.getMaCT()+"'";
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
