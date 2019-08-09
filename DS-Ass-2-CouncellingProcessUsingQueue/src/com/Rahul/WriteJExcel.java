package com.Rahul;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WriteJExcel {
	public void writeInSheet(ArrayList<Allocate> listOfAllocate) throws IOException, RowsExceededException, WriteException{
		
		FileOutputStream output = new FileOutputStream("C:/Users/Admin/Downloads/StudentAllocation.xls");
        WritableWorkbook workbook = Workbook.createWorkbook(output);
        WritableSheet sheet = workbook.createSheet("Student Allocation Of Courses", 0);
        WritableFont titleFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true);
        WritableCellFormat titleformat = new WritableCellFormat(titleFont);
        sheet.addCell(new Label(0, 0, "Student Name", titleformat));
        sheet.addCell(new Label(1, 0, "Course", titleformat));
        
        for(int i = 0 ; i < listOfAllocate.size() ; i++){
            sheet.addCell(new Label(0, i + 1, listOfAllocate.get(i).getStudentName()));
            sheet.addCell(new Label(1, i + 1, listOfAllocate.get(i).getCourse()));
        }
        workbook.write(); 
        workbook.close();
	}
}
