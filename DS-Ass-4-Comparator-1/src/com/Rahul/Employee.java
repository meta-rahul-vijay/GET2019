package com.Rahul;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee overrides two methods compareTo for natural sorting and toString to print Employee
 */
public class Employee implements Comparable<Employee>{
	
	/** The emp id. */
	int empId;
	
	/** The name. */
	String name;
	
	/** The address. */
	String address;
	
	/**
	 * Instantiates a new employee.
	 *
	 * @param empId the emp id
	 * @param name the name
	 * @param address the address
	 */
	public Employee(int empId, String name, String address) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Compare to.
	 *
	 * @param o the o
	 * @return the int
	 */
	@Override
	public int compareTo(Employee o) {
		return this.empId - o.empId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + "]";
	}
	
}
