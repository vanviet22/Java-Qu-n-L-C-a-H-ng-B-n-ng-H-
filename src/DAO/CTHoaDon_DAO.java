package DAO;

import DTO.HoaDon_DTO;
import DTO.loaiSP_DTO;
import DTO.SanPham_DTO;
import DTO.ChiTietHoaDon_DTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.security.Timestamp;
import java.sql.Connection;
import ConnectDB.XuLyDatabase;
import java.time.LocalDateTime;

public class CTHoaDon_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<ChiTietHoaDon_DTO> getListCTHD() {
        ArrayList<ChiTietHoaDon_DTO> listCTHD = new ArrayList<ChiTietHoaDon_DTO>();
        try {
            String sql = "SELECT * FROM cthd";
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon_DTO cthd = new ChiTietHoaDon_DTO();
                cthd.setMaHD(rs.getString(1));
                cthd.setMaSP(rs.getString(2));
                cthd.setMaCT(rs.getString(3));
                cthd.setSoLuong(Integer.parseInt(rs.getString(4)));
                cthd.setGia(rs.getFloat(5));
                cthd.setTienGiam(rs.getFloat(6));
                cthd.setThanhTien(rs.getDouble(7));

                listCTHD.add(cthd);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        } finally {
            try {
                if (connection != null) {
                    xuLyDB.closeConnection(connection);
                }
                if (ps != null) {
                    ps.close();
                }
                rs.close();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return listCTHD;
    }

    public boolean addCTHD(ChiTietHoaDon_DTO cthd) {
        boolean result = false;
        try {
            String sql = "INSERT INTO cthd VALUES (?,?,?,?,?,?,?)";
            XuLyDatabase xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, cthd.getMaHD());
            ps.setString(2, cthd.getMaSP());
            ps.setString(3, cthd.getMaCT());
            ps.setInt(4, cthd.getSoLuong());
            ps.setFloat(5, cthd.getGia());
            ps.setFloat(6, cthd.getTienGiam());
            ps.setDouble(7, cthd.getThanhTien());
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    public boolean updateSLSP(SanPham_DTO sp) {
        boolean result = false;
        try {
            String sql = "UPDATE sanpham SET SOLUONG =? WHERE MASP =?";
            XuLyDatabase xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, sp.getSoluong());
            ps.setString(2, sp.getMaSp());
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            // TODO: handle exception\e.printStackTrace();
            e.printStackTrace();
            return false;
        } finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateSLLoai(loaiSP_DTO loai) {
        boolean result = false;
        try {
            String sql = "UPDATE loai SET SOLUONG =? WHERE MALOAI =?";
            XuLyDatabase xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, loai.getSoluong());
            ps.setString(2, loai.getMaLoai());
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        } finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateChiTietHoaDonSuaNgay(ChiTietHoaDon_DTO cthd) {
        boolean result = false;
        try {
            String sql = "UPDATE cthd SET MACT = ?, TIENGIAM = ?, THANHTIEN = ?" + "WHERE MAHD = ? AND MASP = ?";
            XuLyDatabase xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, cthd.getMaCT());
            ps.setFloat(2, cthd.getTienGiam());
            ps.setDouble(3, cthd.getThanhTien());
            ps.setString(4, cthd.getMaHD());
            ps.setString(5, cthd.getMaSP());
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        } finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateCTHD(ChiTietHoaDon_DTO cthd) {
        boolean result = false;
        try {
            String sql = "UPDATE cthd set MACT = ?, SOLUONG = ?, GIA = ?, TIENGIAM = ?, THANHTIEN = ?"
                    + " WHERE MAHD = ? AND MASP = ?";
            XuLyDatabase xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, cthd.getMaCT());
            ps.setInt(2, cthd.getSoLuong());
            ps.setFloat(3, cthd.getGia());
            ps.setFloat(4, cthd.getTienGiam());
            ps.setDouble(5, cthd.getThanhTien());
            ps.setString(6, cthd.getMaHD());
            ps.setString(7, cthd.getMaSP());
            result = ps.executeUpdate() > 0;

        }

        catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    public boolean deleteChiTietKhiXoaHoaDon(String maHD, String maSP) {
        boolean result = false;
        try {
            String sql = "DELETE FROM cthd WHERE MAHD =? AND MASP =?";
            XuLyDatabase xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, maHD);
            ps.setString(2, maSP);
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        } finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return result;
    }

    public ArrayList<ChiTietHoaDon_DTO> searchCTHD(String thuMuc, String tuKhoaTimKiem) {
        ArrayList<ChiTietHoaDon_DTO> listCTHD = new ArrayList<ChiTietHoaDon_DTO>();

        try {
            String sql = "SELECT * FROM cthd WHERE " + thuMuc + " LIKE '%" + tuKhoaTimKiem + "%'";
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ChiTietHoaDon_DTO cthd = new ChiTietHoaDon_DTO();
                cthd.setMaHD(rs.getString(1));
                cthd.setMaSP(rs.getString(2));
                cthd.setMaCT(rs.getString(3));
                cthd.setSoLuong((rs.getInt(4)));
                cthd.setGia(rs.getFloat(5));
                cthd.setTienGiam(rs.getFloat(6));
                cthd.setThanhTien(rs.getDouble(7));

                listCTHD.add(cthd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Dong ket noi
        finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listCTHD;
    }
}
