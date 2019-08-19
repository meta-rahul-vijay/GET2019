package com.Rahul;

import java.util.Comparator;


// TODO: Auto-generated Javadoc
/**author : Rahul Vijay
 * created : 09/08/2019
 * The Class EmployeeSorter implements Comparator override compare method for sort by name
 */
public class EmployeeSorter implements Comparator<Employee>{

	/**
	 * Compare two employees name
	 *
	 * @param emp1 the emp 1
	 * @param emp2 the emp 2
	 * @return the int
	 */
	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getName().compareTo(emp2.getName());
	}
	
}
