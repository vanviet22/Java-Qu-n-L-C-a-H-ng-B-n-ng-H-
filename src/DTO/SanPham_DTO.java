package DTO;
import java.util.ArrayList;
import java.util.Scanner;
public class SanPham_DTO {
    static Scanner sc=new Scanner(System.in);
    private String maSp;
    private String maNcc;
    private String maLoai;
    private String tenSP;
    private String mieuta;
    private float dongia;
    private int soluong;
    private String anh;
    public SanPham_DTO(){};
    public String getMaSp() {
        return maSp;
    }
    public String getMaNcc() {
        return maNcc;
    }
    public String getMaLoai() {
        return maLoai;
    }
    public String getTenSP() {
        return tenSP;
    }
    public String getMieuta() {
        return mieuta;
    }
    public float getDongia() {
        return dongia;
    }
    public int getSoluong() {
        return soluong;
    }
    public String getAnh() {
        return anh;
    }
    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }
    public void setMaNcc(String maNcc) {
        this.maNcc = maNcc;
    }
    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    public void setMieuta(String mieuta) {
        this.mieuta = mieuta;
    }
    public void setDongia(float dongia) {
        this.dongia = dongia;
    }
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    public void setAnh(String anh) {
        this.anh = anh;
    };
    
}

