/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.NhanVien_DAO;
import DTO.NhanVien_DTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author ADMIN
 */
public class NhanVien_BUS {
     private ArrayList<NhanVien_DTO> ds= null;
    private NhanVien_DAO DAO = new NhanVien_DAO();
    public ArrayList<NhanVien_DTO> getList()
    {
        ds=DAO.getAllNV();
        return ds;
    }
    public ArrayList<NhanVien_DTO> themNhanVien(NhanVien_DTO nv) 
    {
        
        ds.add(nv);
        DAO.ThemNhanVien(nv);
        return ds;
    }
    public ArrayList<NhanVien_DTO> SuaNhanVien(int i,NhanVien_DTO nv)
    {
        DAO.SuaNhanVien(nv);
        NhanVien_DTO old=ds.set(i, nv);
        return ds;
    }
    public ArrayList<NhanVien_DTO> XoaNhanVien(int i,String ma)
    {
        DAO.XoaNhanVien(ma);
        ds.remove(i);
        return ds; 
    }
    private Vector headerNV()
    {
        Vector header=new Vector();
        header.add("ID");
        header.add("Chức vụ");
        header.add("Họ");
        header.add("Tên");
        header.add("Địa chỉ");
        header.add("SĐT");
        header.add("Ngày sinh");
        header.add("Giới tính");
        header.add("Lương"); 
        return header;
    }
    private Vector rowNV(NhanVien_DTO i)
    {
        Vector row=new Vector();
        row.add(i.getMaNV());
        row.add(i.getChucvu());
        row.add(i.getHo());
        row.add(i.getTen());
        row.add(i.getDc());
        row.add(i.getSdt());
        row.add(String.valueOf(i.getNgaySinh().toLocalDate()));
        row.add(i.getGt());
         row.add(i.getLuong());
         return row;
    }
    public DefaultTableModel TimKiem(String yctim,String values)
    {
        DefaultTableModel modelTam = new DefaultTableModel();
        Vector header=headerNV();
        if(modelTam.getRowCount()==0)
        {
            modelTam=new DefaultTableModel(header, 0);
        }
         for(NhanVien_DTO i:ds)
            {
                if (yctim.equals("ID") && i.getMaNV().equals(values)
                        || yctim.equals("Họ") && i.getHo().equals(values)
                        || yctim.equals("Tên") && i.getTen().equals(values)
                        || yctim.equals("Địa chỉ") && i.getDc().equals(values)
                        || yctim.equals("Giới tính") && i.getGt().equals(values)
                        || yctim.equals("Chức vụ") && i.getChucvu().equals(values))
                {
                    Vector row=rowNV(i);
                    modelTam.addRow(row);
                }
            }
         return modelTam;
    }
    private boolean checkMa(ArrayList<NhanVien_DTO> ds,String ma)
    {
        for(NhanVien_DTO i:ds)
        {
            if(String.valueOf(i.getMaNV()).equals(ma))
                return false;
        }
        return true;
    }
    public void importExcel() {
        ArrayList<NhanVien_DTO> listTam = new ArrayList<NhanVien_DTO>();
        JFileChooser fileImport = new JFileChooser(); // Khởi tạo JFileChooser
        fileImport.setCurrentDirectory(new File(System.getProperty("user.dir")));

        int result = fileImport.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream file = new FileInputStream(fileImport.getSelectedFile());
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                XSSFSheet sheet = workbook.getSheetAt(0);
                System.out.print("hiii");
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    if (row.getRowNum() < 1) continue; // Bỏ qua hàng tiêu đề

                    NhanVien_DTO khachHang = new NhanVien_DTO();
                    
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int cellIndex = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();

                        // Bỏ qua cột STT (cellIndex == 0)
                        if (cellIndex == 0) {
                            cellIndex++;
                            continue;
                        }
                        switch (cellIndex) {
                            case 1:
                                khachHang.setMaNV(cell.getStringCellValue());
                                break;
                            case 2:
                                khachHang.setChucvu(cell.getStringCellValue());
                                break;
                            case 3:
                                khachHang.setHo(cell.getStringCellValue());
                                break;
                            case 4:
                                khachHang.setTen(cell.getStringCellValue());
                                break;
                            case 5:
                                khachHang.setDc(cell.getStringCellValue());
                                break;
                            case 6:
                                khachHang.setSdt(cell.getStringCellValue());
                                break;
                            case 7:
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                // Lấy giá trị chuỗi từ ô Excel
                                String dateString = cell.getStringCellValue();
                                LocalDate localDate = null;
                                // Chuyển đổi chuỗi thành LocalDate
                                localDate = LocalDate.parse(dateString, formatter);
                                khachHang.setNgaySinh(localDate.atStartOfDay());
                                break;
                            case 8:
                                khachHang.setGt(cell.getStringCellValue());
                                break;
                            case 9:
                                khachHang.setLuong(Float.parseFloat(cell.getStringCellValue()));
                                break;
                            default:
                                break;
                        }
                        cellIndex++;
                    }
                    listTam.add(khachHang);
                }

                for (NhanVien_DTO i : listTam) {
                    if (checkMa(ds, i.getMaNV())) {
                        ds.add(i);
                        DAO.ThemNhanVien(i);
                    }
                    else
                         JOptionPane.showMessageDialog(null, "Mã khách hàng "+i.getMaNV()+" đã có trong cửa hàng không thể thêm");
                }

                if (!listTam.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Import Excel thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Không có dữ liệu để import hoặc tệp Excel không hợp lệ");
                }

                workbook.close();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void exportExcel(){
         JFileChooser file = new JFileChooser(); //Khởi tạo JFileChooser
         file.setCurrentDirectory(new File(System.getProperty("user.dir"))); 
         
         int result = file.showSaveDialog(null);
         if ( result == JFileChooser.APPROVE_OPTION){
             XSSFWorkbook excelWorkbook = new XSSFWorkbook();
             XSSFSheet excelSheet = excelWorkbook.createSheet("Danh sách nhân viên");
             
             XSSFRow row = null;
             Cell cell = null;
             
             // Merge các cột thành một
            excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 9));
            row = excelSheet.createRow(2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SÁCH NHÂN VIÊN");
            CellStyle centerStyle = excelWorkbook.createCellStyle();
            centerStyle.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellStyle(centerStyle);
 
             row = excelSheet.createRow(3);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã nhân viên");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Chức vụ");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Họ ");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Tên");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Địa chỉ");
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("SĐT");
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Ngày sinh");
             cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Giới tính");
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Lương");
             
            for (int i = 0; i < ds.size(); i++) {
                row = excelSheet.createRow(4 + i);
                row.setHeight((short) 400);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(ds.get(i).getMaNV());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(ds.get(i).getChucvu());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(ds.get(i).getHo());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(ds.get(i).getTen());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(ds.get(i).getDc());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(ds.get(i).getSdt());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(ds.get(i).getNgaySinh());
                
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(ds.get(i).getGt());
                
                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(ds.get(i).getLuong());
                excelSheet.autoSizeColumn(i);
            }
             
             try{
                 FileOutputStream outputStream = new FileOutputStream(file.getSelectedFile());
                 excelWorkbook.write(outputStream);
                 JOptionPane.showMessageDialog(null, "Xuất file excel thành công!");
                 excelWorkbook.close();
             }catch (IOException e){
                 e.printStackTrace();
             }
         }
     }
}
