/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import ConnectDB.XuLyDatabase;
import DTO.NCC_DTO;
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
public class NCC_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private java.sql.Statement st;
    private ResultSet rs = null;
    public ArrayList<NCC_DTO> getAllNCC()
    {
        ArrayList<NCC_DTO> dsNCC = new ArrayList<NCC_DTO>();
        try
        {
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            String qry = "Select * from ncc ";
            ps = conn.prepareStatement(qry);
            rs = ps.executeQuery(qry);
            while(rs.next())
            {
                NCC_DTO ncc = new NCC_DTO();
                ncc.setMaNCC(rs.getString(1));
                ncc.setTenNCC(rs.getString(2));
                ncc.setDcNCC(rs.getString(3));
                ncc.setSdtNCC(rs.getString(4));
                ncc.setGmail(rs.getString(6));
                int status = rs.getInt(5);
                if(status==1)
                    ncc.setTrangThai("Không chặn");
                else ncc.setTrangThai("Chặn"); 
                dsNCC.add(ncc);
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
    return dsNCC;
    }
    
    public void ThemNCC(NCC_DTO ncc) {
        try {
            xuLyDB = new XuLyDatabase();
            conn = xuLyDB.openConnection();
            String qry = "Insert into ncc Values (";
            qry = qry + "'" + ncc.getMaNCC() + "', '" + ncc.getTenNCC() + "', '" + ncc.getDcNCC() + "', '"
                    + ncc.getSdtNCC() + "', ";
            if (ncc.getTrangThai().equals("Không chặn"))
                qry = qry + 1 + ", '";
            else
                qry = qry + 0 + ", '";
            qry = qry + ncc.getGmail() + "')";
            st = conn.createStatement();
            st.executeUpdate(qry);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
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
    public void XoaNCC(String ma)
    {
        try
            {
                xuLyDB = new XuLyDatabase();
                conn = xuLyDB.openConnection();
                st = conn.createStatement();
                String qry="Delete from ncc where MANCC='"+ma+"'";
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
    public void SuaNCC(NCC_DTO ncc)
    {
        try{
            xuLyDB = new XuLyDatabase();
            conn =  xuLyDB.openConnection();
            st = conn.createStatement();
            String qry = "Update ncc Set ";
            qry = qry +"TENNCC='"+ ncc.getTenNCC() + "'"+",DCNCC='" + ncc.getDcNCC() + "',SDTNCC='" + ncc.getSdtNCC() + "',GMAIL='" + ncc.getGmail() + "'";
            if(ncc.getTrangThai().equals("Không chặn"))
                qry=qry+",TRANGTHAI="+1+" WHERE MANCC='"+ncc.getMaNCC()+"'";
            else qry=qry+",TRANGTHAI="+0+" where MANCC='"+ncc.getMaNCC()+"'";
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
