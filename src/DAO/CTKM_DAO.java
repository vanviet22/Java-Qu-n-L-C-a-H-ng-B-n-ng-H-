/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import ConnectDB.XuLyDatabase;
import DTO.CTKM_DTO;
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
public class CTKM_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private java.sql.Statement st;
    private ResultSet rs = null;
    public ArrayList<CTKM_DTO> getAllCTKM()
    {
        ArrayList<CTKM_DTO> dsCT=new ArrayList<CTKM_DTO>();
        try
        {
            xuLyDB=new XuLyDatabase();
            conn=xuLyDB.openConnection();
            String qry="select * from ctkm";
            ps = conn.prepareStatement(qry);
            rs=ps.executeQuery(qry);
            while(rs.next())
            {
                CTKM_DTO ct=new CTKM_DTO();
                ct.setMaCT(rs.getString(1));
                ct.setTenCT(rs.getString(2));
                ct.setNgayBD(rs.getTimestamp(3).toLocalDateTime());
                ct.setNgayKT(rs.getTimestamp(4).toLocalDateTime());
                dsCT.add(ct);
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
        return dsCT;
    }
    public void ThemCTKM(CTKM_DTO ct)
    {
        try{
            xuLyDB=new XuLyDatabase();
            conn=xuLyDB.openConnection();
            String qry="Insert into ctkm Values (";
            qry=qry+"'"+ct.getMaCT()+"','"+ct.getTenCT()+"','"+ct.getNgayBD()+"','"+ct.getNgayKT()+"')";
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
    public void XoaCTKM(String ma)
    {
        try
            {
                xuLyDB= new XuLyDatabase();
                conn=xuLyDB.openConnection();
                st=conn.createStatement();
                String qry="Delete from ctkm where MACT='"+ma+"'";
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
    public void SuaCTKM(CTKM_DTO ct)
    {
        try {
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            st = conn.createStatement();
            String qry = "Update ctkm Set ";
            qry = qry + "TenCT='"+ct.getTenCT()+"',NGAYBD='"+ct.getNgayBD()+"',NGAYKT='"+ct.getNgayKT()+"' WHERE MACT='"+ct.getMaCT()+"'";
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
