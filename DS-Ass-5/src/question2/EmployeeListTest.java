package question2;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * This class tests the methods of EmployeeList class.
 * @author Rahul Vijay 
 * Dated 08/07/2019
 */
public class EmployeeListTest {

	@Test
	public void test1() {
		EmployeeList employeeList = new EmployeeList();

		employeeList.addEmployee("Rahul", 22, 30000);
		employeeList.addEmployee("Ajay", 22, 45000);
		employeeList.addEmployee("Aman", 23, 15000);
		employeeList.addEmployee("anmol", 22, 25000);

		employeeList.sortEmployeeList();

		assertEquals("Ajay", employeeList.sortedLinkedListHead.getEmployeeName());
	}
}