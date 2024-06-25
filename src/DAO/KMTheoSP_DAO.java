/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import ConnectDB.XuLyDatabase;
import DTO.KMtheoSP_DTO;

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
public class KMTheoSP_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private java.sql.Statement st;
    private ResultSet rs = null;
    public ArrayList<KMtheoSP_DTO> getAllKMSP()
    {
        ArrayList<KMtheoSP_DTO> ds=new ArrayList<KMtheoSP_DTO>();
        try{
            xuLyDB=new XuLyDatabase();
            conn=xuLyDB.openConnection();
            String qry="select * from kmtheosp";
            ps = conn.prepareStatement(qry);
            rs=ps.executeQuery(qry);

            while(rs.next())
            {
                KMtheoSP_DTO km=new KMtheoSP_DTO();
                km.setMaCT(rs.getString(1));
                km.setMaSP(rs.getString(2));
                km.setPhanTram_KM(rs.getFloat(3));
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
    public void ThemKMSP(KMtheoSP_DTO km)
    {
        try
        {
            xuLyDB=new XuLyDatabase();
            conn=xuLyDB.openConnection();
            String qry="Insert into kmtheosp Values (";
            qry=qry+"'"+km.getMaCT()+"','"+km.getMaSP()+"',"+km.getPhanTram_KM()+")";
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
    public void XoaKMSP(String maCT,String maSP)
    {
        try
            {
                xuLyDB= new XuLyDatabase();
                conn=xuLyDB.openConnection();
                st=conn.createStatement();
                String qry="Delete from kmtheosp where MACT='"+maCT+"' and MASP='"+maSP+"'";
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
    public void XoaKMSPTheoMACT(String maCT)
    {
        try
            {
                xuLyDB= new XuLyDatabase();
                conn=xuLyDB.openConnection();
                st=conn.createStatement();
                String qry="Delete from kmtheosp where MACT='"+maCT+"'";
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
    public void SuaKMSP(KMtheoSP_DTO ct)
    {
        try {
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            st = conn.createStatement();
            String qry = "Update kmtheosp Set ";
            qry = qry + "PHANTRAMKM="+ct.getPhanTram_KM()+" WHERE MACT='"+ct.getMaCT()+"' AND MASP='"+ct.getMaSP()+"'";
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
