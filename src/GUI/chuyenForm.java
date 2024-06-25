/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JButton;
import GUI.ThongTinDN;
import GUI.GUI_CTKM;
import GUI.GUI_Khachhang;
import GUI.GUI_NCC;
import GUI.GUI_NhanVien;
import GUI.GUI_NhapHang;
import GUI.GUI_Sanpham;
import GUI.GUI_dangnhap;
import GUI.GUI_USER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
/**
 *
 * @author ADMIN
 */
public class chuyenForm {
    private ThongTinDN dn=new ThongTinDN();
    private JFrame frame;
    public chuyenForm(ThongTinDN dn)
    {
        this.dn=dn;
        this.frame=dn.getFrame();
        
    }
    public void phanQuyen(JButton bt_sp,JButton bt_kh,JButton bt_nv,JButton bt_bh,JButton bt_km,JButton bt_duyet,JButton bt_user,JButton bt_ncc,JButton bt_kho,JButton bt_tk,JButton bt_dx)
    {
        if(dn.getQuyen().equals("ADMIN"))
        {
            bt_user.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new GUI_USER().setVisible(true);
                }
            });
            bt_dx.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
        }
        else if(dn.getQuyen().equals("Quản lí"))
        {
            bt_dx.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            bt_kh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new GUI_Khachhang().setVisible(true);
                }
            });
            bt_nv.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    frame.dispose();
                    new GUI_NhanVien().setVisible(true);
                }
            });
            bt_km.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    frame.dispose();
                    new GUI_CTKM().setVisible(true);
                }
            });
            bt_sp.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    frame.dispose();
                    new GUI_Sanpham().setVisible(true);
                }
            });
            bt_kho.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    frame.dispose();
                    new GUI_NhapHang().setVisible(true);
                }
            });
            bt_ncc.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    frame.dispose();
                    new GUI_NCC().setVisible(true);
                }
            });
        }
        else if(dn.getQuyen().equals("Nhân viên bán hàng"))
        {
            bt_dx.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            bt_bh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                }
            });
            bt_duyet.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                 
                }
            });
            bt_sp.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    frame.dispose();
                    new GUI_Sanpham().setVisible(true);
                }
            });
        }
        else
        {
            bt_user.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
            bt_dx.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new GUI_dangnhap().setVisible(true);
                }
            });
            bt_kh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new GUI_Khachhang().setVisible(true);
                }
            });
            bt_nv.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    frame.dispose();
                    new GUI_NhanVien().setVisible(true);
                }
            });
            bt_km.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    frame.dispose();
                    new GUI_CTKM().setVisible(true);
                }
            });
            bt_sp.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    frame.dispose();
                    new GUI_Sanpham().setVisible(true);
                }
            });
            bt_kho.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    frame.dispose();
                    new GUI_NhapHang().setVisible(true);
                }
            });
            bt_ncc.addActionListener(new ActionListener() {
                @Override 
                public void actionPerformed(ActionEvent e){
                    frame.dispose();
                    new GUI_NCC().setVisible(true);
                }
            });
            bt_bh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
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
                 
                }
            });
        }
    }
}
