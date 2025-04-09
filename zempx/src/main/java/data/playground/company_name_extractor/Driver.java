package data.playground.company_name_extractor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Driver {

    public static final String JSON_FILE_PATH = "C:\\Users\\SHAKIR\\Desktop\\leetcode-company-tags.json";
    public static final String EXCEL_FILE_PATH = "C:\\Users\\SHAKIR\\Desktop\\Company.xlsx";

    public static void main(String[] args) {
        try {
            // Read and map json file to data object
            Data data = extractJson();

            //Create excel workbook for json data
            createXLSX(data);

            System.out.println("Extraction complete, path: " + EXCEL_FILE_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Data extractJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(JSON_FILE_PATH), Data.class);
    }

    private static void createXLSX(Data data) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Product based companies");

            Row headerRow = sheet.createRow(0);
            Cell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Company");

            //Add companies data to excel rows
            int rowIndex = 1;
            for (Company company : data.getData().getCompanyTags()) {
                Row row = sheet.createRow(rowIndex++);
                Cell cell = row.createCell(0);
                cell.setCellValue(company.getName());
            }
            sheet.autoSizeColumn(0);

            //write excel to file
            try (FileOutputStream fileOutputStream = new FileOutputStream(EXCEL_FILE_PATH)) {
                workbook.write(fileOutputStream);
            }
        }
    }

}
