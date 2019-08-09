package com.Rahul;

import java.io.IOException;
import java.util.ArrayList;

import jxl.write.WriteException;

public class MainCounselling {
	public static void main(String args[]) throws IOException, WriteException{
		ReadJExcel test = new ReadJExcel();
	    test.readProgramData("C:/Users/Admin/Downloads/ProgramList.xls");
	    test.readStudentData("C:/Users/Admin/Downloads/StudentList.xls");
		ArrayList<Allocate> listOfAllocate = new ArrayList<Allocate>();
	    test.assignCourseToStudent(listOfAllocate);
	    WriteJExcel write = new WriteJExcel();
	    write.writeInSheet(listOfAllocate);
	}
}
