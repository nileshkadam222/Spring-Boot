package com.mppfilereader.mppfilereader.web;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import net.sf.mpxj.Column;
import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.TableContainer;
import net.sf.mpxj.mpp.MPPReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class fileReaderController {

    @GetMapping("/read")
    public static void readMppFile() throws MPXJException {
        MPPReader reader = new MPPReader();
        reader.setPreserveNoteFormatting(true);
        ProjectFile project = reader.read("E:\\Spring boot\\mpp-file-reader\\src\\main\\resources\\files\\b4ubuild_sample_07.mpp");

        System.out.println("hi this is "+project);
        System.out.println("hi this is "+ project.getTables());
        System.out.println("hi this is "+ project.getResources());
        writeExcelFile(project);

    }

    private static void writeExcelFile(ProjectFile project){
        System.out.println("hi this is "+ project.getTables());
        TableContainer tables = project.getTables();
        //Create Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        FileOutputStream out = null;
        try {


            //Create row object


            XSSFRow row;
            for(int i=0;i<tables.size();i++){

                XSSFSheet spreadsheet = workbook.createSheet(tables.get(i).getName());
                List<Column> columns = tables.get(i).getColumns();
                row = spreadsheet.createRow(0);
                int cellid=0;
                for (Column col : columns) {
                    Cell cell = row.createCell(cellid++);
                    cell.setCellValue(col.getTitle());
                }


            }
            out = new FileOutputStream(new File("E:\\Spring boot\\mpp-file-reader\\src\\main\\resources\\files\\createworkbook.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("createworkbook.xlsx written successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
