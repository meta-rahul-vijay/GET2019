package com.Rahul;


import java.util.ArrayList;
import java.util.Collections;

// TODO: Auto-generated Javadoc
/**author : Rahul Vijay
 * created : 09/08/2019
 * The Class EmployeeCollection.
 * contains employeeList
 */
public class EmployeeCollection {
	
	/** The employee list. */
	ArrayList<Employee> employeeList = new ArrayList<>();
	
	/**
	 * Adds the employee which are not already present
	 * 
	 * @param emp the emp
	 */
	public void addEmployee(Employee emp){
		for(int i = 0 ; i < employeeList.size() ; i++){
			if(emp.getEmpId() == employeeList.get(i).getEmpId()) {
				throw new RuntimeException("Employee Id Already Present");
			}
		}
		employeeList.add(emp);
	}
	
	/**
	 * Prints the.
	 */
	public void print() {
		System.out.println("Unsorted List");
		System.out.println(employeeList);
	}
	
	/**
	 * Sort on natural order
	 */
	public void sort() {
		Collections.sort(employeeList);
		System.out.println("Natural Sorted List");
		System.out.println(employeeList);
	}
	
	/**
	 * Sort by name.
	 */
	public void sortByName() {
		Collections.sort(employeeList, new EmployeeSorter());
		System.out.println("Sorted By Name List");
		System.out.println(employeeList);
	}
}
