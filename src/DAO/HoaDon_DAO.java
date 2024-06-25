package DAO;

import DTO.ChiTietHoaDon_DTO;
import DTO.HoaDon_DTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.security.Timestamp;
import java.sql.Connection;
import ConnectDB.XuLyDatabase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HoaDon_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<HoaDon_DTO> getListHoaDon() {
        ArrayList<HoaDon_DTO> listHD = new ArrayList<HoaDon_DTO>();
        try {
            String sql = "SELECT * FROM hoadon";
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon_DTO hd = new HoaDon_DTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaKH(rs.getString(2));
                hd.setMaNV(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayLap(rs.getTimestamp(5).toLocalDateTime());
                hd.setTienGiam(rs.getFloat(6));
                hd.setTongTien(rs.getDouble(7));
                listHD.add(hd);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return null;
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
        return listHD;
    }

    public boolean addHoaDon(HoaDon_DTO hd) {
        boolean result = false;
        try {
            String sql = "INSERT INTO hoadon VALUES (?,?,?,?,?,?,?)";
            XuLyDatabase xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, hd.getMaHD());
            ps.setString(2, hd.getMaKH());
            ps.setString(3, hd.getMaNV());
            ps.setString(4, hd.getMaKM());
            ps.setString(5, hd.getNgayLap().toString());
            ps.setFloat(6, hd.getTienGiam());
            ps.setDouble(7, hd.getTongTien());

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

    public boolean updateHoaDon(HoaDon_DTO hd) {
        boolean result = false;
        try {
            String sql = "UPDATE hoadon SET  MAKH= ?, ID= ?, MAKM= ?, NGAYLAP= ?, TIENGIAM= ?, TONGTIEN= ? WHERE MAHD= ?";
            XuLyDatabase xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, hd.getMaKH());
            ps.setString(2, hd.getMaNV());
            ps.setString(3, hd.getMaKM());
            ps.setString(4, hd.getNgayLap().toString());
            ps.setFloat(5, hd.getTienGiam());
            ps.setDouble(6, hd.getTongTien());
            ps.setString(7, hd.getMaHD());

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

    public boolean updateHoaDon(String maKM, float tienGiam, double tongTien, String maHD) {
        boolean result = false;
        try {
            String sql = "UPDATE hoadon SET MAKM = ?, TIENGIAM = ?, TONGTIEN = ?" + " WHERE MAHD = ?";
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, maKM);
            ps.setFloat(2, tienGiam);
            ps.setDouble(3, tongTien);
            ps.setString(4, maHD);
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

    public boolean deleteHoaDon(String maHD) {
        boolean result = false;
        try {
            String sql = "DELETE FROM hoadon WHERE MAHD =?";
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, maHD);
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

    public ArrayList<HoaDon_DTO> searchHDKhongNgay(String thuMuc, String tuKhoaTimKiem) {
        ArrayList<HoaDon_DTO> listHD = new ArrayList<HoaDon_DTO>();
        String sql = "SELECT * FROM hoadon WHERE " + thuMuc + " LIKE '%" + tuKhoaTimKiem + "%'";
        if (thuMuc.equals("NGAYLAP")) {
            sql = "SELECT * FROM hoadon WHERE NGAYLAP = '" + tuKhoaTimKiem + "'" + " AND " + thuMuc;
        }
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                HoaDon_DTO hd = new HoaDon_DTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaKH(rs.getString(2));
                hd.setMaNV(rs.getString(3));
                hd.setMaKM((rs.getString(4)));
                hd.setNgayLap(rs.getTimestamp(5).toLocalDateTime());
                hd.setTienGiam(rs.getFloat(6));
                hd.setTongTien(rs.getDouble(7));
                listHD.add(hd);
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

        return listHD;
    }

    public ArrayList<HoaDon_DTO> searchHDTheoNgayNhoHonHoacBang(String ngayBD, String thuMuc, String tuKhoa) {
        ArrayList<HoaDon_DTO> listHD = new ArrayList<HoaDon_DTO>();
        try {
            String sql = "SELECT * FROM hoadon WHERE NGAYLAP >= '" + ngayBD + "'" + " AND " + thuMuc + " LIKE '%"
                    + tuKhoa + "%'";
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon_DTO hd = new HoaDon_DTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaKH(rs.getString(2));
                hd.setMaNV(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayLap(rs.getTimestamp(5).toLocalDateTime());
                hd.setTienGiam(rs.getFloat(6));
                hd.setTongTien(rs.getDouble(7));
                listHD.add(hd);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listHD;
    }

    public ArrayList<HoaDon_DTO> searchHDTheoNgayLonHonHoacBang(String ngayKT, String thuMuc, String tuKhoa) {
        ArrayList<HoaDon_DTO> listHD = new ArrayList<HoaDon_DTO>();
        try {
            String sql = "SELECT * FROM hoadon WHERE NGAYLAP <= '" + ngayKT + "'" + " AND " + thuMuc + " LIKE '%"
                    + tuKhoa + "%'";
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon_DTO hd = new HoaDon_DTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaKH(rs.getString(2));
                hd.setMaNV(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayLap(rs.getTimestamp(5).toLocalDateTime());
                hd.setTienGiam(rs.getFloat(6));
                hd.setTongTien(rs.getDouble(7));
                listHD.add(hd);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listHD;
    }

    public ArrayList<HoaDon_DTO> searchHDTheoNgay(String ngayBD, String ngayKT, String thuMuc, String tuKhoa) {
        ArrayList<HoaDon_DTO> listHD = new ArrayList<HoaDon_DTO>();
        try {
            String sql = "SELECT * FROM hoadon WHERE NGAYLAP BETWEEN '" + ngayBD + "' AND '" + ngayKT + "'" +
                    " AND " + thuMuc + " LIKE '%" + tuKhoa + "%'";
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon_DTO hd = new HoaDon_DTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaKH(rs.getString(2));
                hd.setMaNV(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayLap(rs.getTimestamp(5).toLocalDateTime());
                hd.setTienGiam(rs.getFloat(6));
                hd.setTongTien(rs.getDouble(7));
                listHD.add(hd);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listHD;
    }

    public ArrayList<HoaDon_DTO> searchHDTheoNgay(String ngayBD, String ngayKT) {
        ArrayList<HoaDon_DTO> listHD = new ArrayList<HoaDon_DTO>();
        try {
            String sql = "SELECT * FROM hoadon WHERE NGAYLAP BETWEEN '" + ngayBD + "' AND '" + ngayKT + "'";
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon_DTO hd = new HoaDon_DTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaKH(rs.getString(2));
                hd.setMaNV(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayLap(rs.getTimestamp(5).toLocalDateTime());
                hd.setTienGiam(rs.getFloat(6));
                hd.setTongTien(rs.getDouble(7));
                listHD.add(hd);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listHD;
    }

    public ArrayList<HoaDon_DTO> searchHDTheoNgayNhoHonHoacBang(String ngayBD) {
        ArrayList<HoaDon_DTO> listHD = new ArrayList<HoaDon_DTO>();
        try {
            String sql = "SELECT * FROM hoadon WHERE NGAYLAP >= '" + ngayBD + "'";
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon_DTO hd = new HoaDon_DTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaKH(rs.getString(2));
                hd.setMaNV(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayLap(rs.getTimestamp(5).toLocalDateTime());
                hd.setTienGiam(rs.getFloat(6));
                hd.setTongTien(rs.getDouble(7));
                listHD.add(hd);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listHD;
    }

    public ArrayList<HoaDon_DTO> searchHDTheoNgayLonHonHoacBang(String ngayKT) {
        ArrayList<HoaDon_DTO> listHD = new ArrayList<HoaDon_DTO>();
        try {
            String sql = "SELECT * FROM hoadon WHERE NGAYLAP <= '" + ngayKT + "'";
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon_DTO hd = new HoaDon_DTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaKH(rs.getString(2));
                hd.setMaNV(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayLap(rs.getTimestamp(5).toLocalDateTime());
                hd.setTienGiam(rs.getFloat(6));
                hd.setTongTien(rs.getDouble(7));
                listHD.add(hd);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listHD;
    }
}
