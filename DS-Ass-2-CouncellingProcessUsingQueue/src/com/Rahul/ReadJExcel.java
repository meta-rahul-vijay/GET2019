package com.Rahul;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;
import jxl.write.WriteException;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ReadJExcel {
	private Map<String, Integer> mapOfProgram = new HashMap<String, Integer>();
    private Queue<Student> queueOfStudent = new LinkedList<>(); 
	public void readProgramData(String inputFile) throws IOException{
		File programWorkbook = new File(inputFile);
		Workbook w;
		try{
			w = Workbook.getWorkbook(programWorkbook);
			Sheet sheet = w.getSheet(0);
			for(int i = 0 ; i < sheet.getRows() ; i++){
				Cell cell1 = sheet.getCell(0, i);
				Cell cell2 = sheet.getCell(1, i);
				mapOfProgram.put(cell1.getContents(), Integer.parseInt(cell2.getContents()));
			}
		}catch(BiffException e){
            e.printStackTrace();
		}
	}
	public void readStudentData(String inputFile) throws IOException{
		File programWorkBook = new File(inputFile);
		Workbook w;
		try{
			w = Workbook.getWorkbook(programWorkBook);
			Sheet sheet = w.getSheet(0);
			for(int j = 0 ; j < sheet.getRows() ; j++){
				ArrayList<String> list = new ArrayList<String>();
				for(int i = 0 ; i < sheet.getColumns() ; i++){
					Cell cell = sheet.getCell(i, j);
					list.add(cell.getContents());
				}
				Student student = new Student(list);
				queueOfStudent.add(student);
			}
		}catch(BiffException e){
			e.printStackTrace();
		}
	}
	public void assignCourseToStudent(ArrayList<Allocate> listOfAllocate) throws IOException {
		
		while(queueOfStudent.size() != 0){
			Student student = queueOfStudent.remove();
			int j;
			for(j = 0 ; j < student.preferenceList.size() ; j++){
				if(mapOfProgram.containsKey(student.preferenceList.get(j)) && mapOfProgram.get(student.preferenceList.get(j)) != 0){
					Allocate allocate = new Allocate(student.name, student.preferenceList.get(j));
			        listOfAllocate.add(allocate);
			        mapOfProgram.put(student.preferenceList.get(j), mapOfProgram.get(student.preferenceList.get(j)) - 1);
			        break;
				}
			}
			if(j == student.preferenceList.size()){
				Allocate allocate = new Allocate(student.name, null);
				listOfAllocate.add(allocate);
			}
		}
	}
}
