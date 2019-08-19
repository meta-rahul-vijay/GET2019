package com.Rahul;

public class MainEmployee {
	
	/**author : Rahul Vijay
	 * created : 09/08/2019
	 * The main method.
	 * Initialize employees via constructor and call methods
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		EmployeeCollection employeeCollection = new EmployeeCollection();
		Employee e1 = new Employee(1, "Virat", "6237 djwhqd, jsan");
        Employee e2 = new Employee(3, "Bumrah", "32 ddhsgd, dvwv");
        Employee e3 = new Employee(2, "Pandya", "11 lkjhh, hgdbw");
        Employee e4 = new Employee(5, "Rohit", "90 wqwmc, hdumv");
        Employee e5 = new Employee(4, "Dhoni", "183 wgmfgc, kjnns");
        employeeCollection.addEmployee(e1);
        employeeCollection.addEmployee(e2);
        employeeCollection.addEmployee(e3);
        employeeCollection.addEmployee(e4);
        employeeCollection.addEmployee(e5);
        
        
        employeeCollection.print();
        employeeCollection.sort();
        employeeCollection.sortByName();
	}
}
