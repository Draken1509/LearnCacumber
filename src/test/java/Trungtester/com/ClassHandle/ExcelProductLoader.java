package Trungtester.com.ClassHandle;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelProductLoader {
        public static List<Product> loadProductsFromExcel(String excelFilePath) {
            List<Product> productList = new ArrayList<>();

            try (FileInputStream excelFile = new FileInputStream(excelFilePath);
                 Workbook workbook = new XSSFWorkbook(excelFile)) {

                // Lấy sheet có tên "Product"
                Sheet sheet = workbook.getSheet("insertCatagoryInvalid");

                Iterator<Row> rowIterator = sheet.iterator();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    if (row.getRowNum() == 0) {
                        // Bỏ qua hàng tiêu đề
                        continue;
                    }
                    String name = row.getCell(0).getStringCellValue();
                    int price = (int) row.getCell(1).getNumericCellValue();
                    int quantity = (int) row.getCell(2).getNumericCellValue();
                    Product product = new Product(name, price, quantity);
                    productList.add(product);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return productList;
        }
}
