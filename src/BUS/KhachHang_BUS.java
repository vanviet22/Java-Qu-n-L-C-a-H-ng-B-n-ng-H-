package BUS;
import DTO.KhachHang_DTO;
import DAO.KhachHang_DAO;
import DTO.NhanVien_DTO;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class KhachHang_BUS {
    private ArrayList<KhachHang_DTO> dsKH = null;
    private KhachHang_DAO KHDAO = new KhachHang_DAO();
    public ArrayList<KhachHang_DTO> getListKH()
    {
        dsKH=KHDAO.getAllKH();
        return dsKH;
    }
    public ArrayList<KhachHang_DTO> Them(KhachHang_DTO kh) {  
        dsKH.add(kh);
        KHDAO.ThemKhachHang(kh);      
        return dsKH;
    }
    public ArrayList<KhachHang_DTO> Xoa(int i,String ma) {  
            KHDAO.XoaKhachHang(ma);
            dsKH.remove(i);
        return dsKH;
    }
    public ArrayList<KhachHang_DTO> Sua(int i,KhachHang_DTO kh) {  
            KHDAO.SuaKhachHang(kh);
            KhachHang_DTO old=dsKH.set(i, kh);
            return dsKH;
    }
    private Vector headerKH()
    {
        Vector header=new Vector();
        header.add("ID");
        header.add("Họ");
        header.add("Tên");
        header.add("Địa chỉ");
        header.add("SĐT");
        header.add("Giới tính");
        header.add("Trạng thái");
        return header;
    }
    private Vector rowKH(KhachHang_DTO kh)
    {
        Vector row=new Vector();
        row.add(kh.getMaKH());
        row.add(kh.getHo());
        row.add(kh.getTen());
        row.add(kh.getDc());
        row.add(kh.getSdt());
        row.add(kh.getGt());
        row.add(kh.getTrang_thai());
        return row;
    }
    public DefaultTableModel TimKiem(String yctim,String values )
    {
        DefaultTableModel model_tam = new DefaultTableModel();
        Vector header = headerKH();
        if(model_tam.getRowCount()==0)
        {
            model_tam=new DefaultTableModel(header, 0);
        }
         for (KhachHang_DTO kh : dsKH) {
                if (yctim.equals("ID") && kh.getMaKH().equals(values)
                        || yctim.equals("Họ") && kh.getHo().equals(values)
                        || yctim.equals("Tên") && kh.getTen().equals(values)
                        || yctim.equals("Địa chỉ") && kh.getDc().equals(values)
                        || yctim.equals("SĐT") && kh.getSdt().equals(values)
                        || yctim.equals("Giới tính") && kh.getGt().equals(values)
                        || yctim.equals("Trạng thái") && kh.getTrang_thai().equals(values)) {
        
                    Vector row = rowKH(kh);
                    model_tam.addRow(row);
                }
        }
         return model_tam;
    }
    private boolean checkMa(ArrayList<KhachHang_DTO> ds,String ma)
    {
        for(KhachHang_DTO i:ds)
        {
            if(i.getMaKH().equals(ma))
                return false;
        }
        return true;
    }
    public void importExcel() {
        ArrayList<KhachHang_DTO> listTam = new ArrayList<KhachHang_DTO>();
        JFileChooser fileImport = new JFileChooser(); // Khởi tạo JFileChooser
        fileImport.setCurrentDirectory(new File(System.getProperty("user.dir")));

        int result = fileImport.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream file = new FileInputStream(fileImport.getSelectedFile());
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                XSSFSheet sheet = workbook.getSheetAt(0);

                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    if (row.getRowNum() < 1) continue; // Bỏ qua hàng tiêu đề

                    KhachHang_DTO khachHang = new KhachHang_DTO();

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
                                khachHang.setMaKH(cell.getStringCellValue());
                                break;
                            case 2:
                                khachHang.setHo(cell.getStringCellValue());
                                break;
                            case 3:
                                khachHang.setTen(cell.getStringCellValue());
                                break;
                            case 4:
                                khachHang.setDc(cell.getStringCellValue());
                                break;
                            case 5:
                                khachHang.setSdt(cell.getStringCellValue());
                                break;
                            case 6:
                                khachHang.setGt(cell.getStringCellValue());
                                break;
                            case 7:
                                khachHang.setTrang_thai(cell.getStringCellValue());
                                break;
                            default:
                                break;
                        }
                        cellIndex++;
                    }
                    listTam.add(khachHang);
                }

                for (KhachHang_DTO i : listTam) {
                    if (checkMa(dsKH, i.getMaKH())) {
                        dsKH.add(i);
                        KHDAO.ThemKhachHang(i);
                    }
                    else
                         JOptionPane.showMessageDialog(null, "Mã khách hàng "+i.getMaKH()+" đã có trong cửa hàng không thể thêm");
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
             XSSFSheet excelSheet = excelWorkbook.createSheet("Danh sách khách hàng");
             
             XSSFRow row = null;
             Cell cell = null;
             
             // Merge các cột thành một
            excelSheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 7));
            row = excelSheet.createRow(2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SÁCH KHÁCH HÀNG");
            CellStyle centerStyle = excelWorkbook.createCellStyle();
            centerStyle.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellStyle(centerStyle);
 
             row = excelSheet.createRow(3);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã khách hàng");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Họ khách hàng");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Tên khách hàng");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Địa chỉ");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Số điện thoại");
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Giới tính");
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Trạng thái");
             
            for (int i = 0; i < dsKH.size(); i++) {
                row = excelSheet.createRow(4 + i);
                row.setHeight((short) 400);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(dsKH.get(i).getMaKH());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(dsKH.get(i).getHo());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(dsKH.get(i).getTen());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(dsKH.get(i).getDc());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(dsKH.get(i).getSdt());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(dsKH.get(i).getGt());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(dsKH.get(i).getTrang_thai());
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
