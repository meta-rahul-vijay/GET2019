package question2;
/**
 * this class implements employees methods
 * @author Rahul Vijay
 * Dated 08/07/2019
 *
 */
public class EmployeeList {
	Employee linkedListHead;
	Employee sortedLinkedListHead;
	
	/**
	 * Constructor to initialize list
	 */
	public EmployeeList()
	{
		linkedListHead = null;
		sortedLinkedListHead = null;
	}

	/**
	 * This method is used to add a Employee in the linked list.
	 * @param employeeName name of employee
	 * @param employeeAge age of employee
	 * @param employeeSalary salary of employee
	 */
	public void addEmployee(String employeeName,int employeeAge,double employeeSalary) {       
        Employee newEmployee = new Employee(employeeName,employeeAge,employeeSalary);    
        
        if(linkedListHead == null) {    
        	linkedListHead = newEmployee;  
        	return;
        }    
        Employee temp=linkedListHead;
        while(temp.next!=null){
        	temp=temp.next;
        }
        temp.next=newEmployee;

    }
	
	/**
	 * This method sorts the given employee list with insertion sort method.
	 */
	void sortEmployeeList()
	{
		Employee currentEmployee = linkedListHead;
		while(currentEmployee != null)
		{
			Employee nextEmployee = currentEmployee.next;
			if((sortedLinkedListHead == null) || 
					(sortedLinkedListHead.getEmployeeSalaray() <= currentEmployee.getEmployeeSalaray()))
			{
				if(sortedLinkedListHead == null)
				{
					currentEmployee.next = sortedLinkedListHead;
					sortedLinkedListHead = currentEmployee;
				}
				else if(sortedLinkedListHead.getEmployeeSalaray() < currentEmployee.getEmployeeSalaray())
				{
					currentEmployee.next = sortedLinkedListHead;
					sortedLinkedListHead = currentEmployee;
				}
				else if((sortedLinkedListHead.getEmployeeSalaray() == currentEmployee.getEmployeeSalaray()) && 
						(sortedLinkedListHead.getEmployeeAge() > currentEmployee.getEmployeeAge()))
				{
					currentEmployee.next = sortedLinkedListHead;
					sortedLinkedListHead = currentEmployee;
				}
				else
				{
					Employee temp = sortedLinkedListHead;
					while((temp.next != null) && (temp.next.getEmployeeSalaray() == currentEmployee.getEmployeeSalaray()) && 
							(temp.next.getEmployeeAge() < currentEmployee.getEmployeeAge()))
					{
						temp = temp.next;
					}
					currentEmployee.next = temp.next;
					temp.next = currentEmployee;
				}
			}
			else
			{
				Employee temp = sortedLinkedListHead;
				while((temp.next != null) && 
						(temp.next.getEmployeeSalaray() >= currentEmployee.getEmployeeSalaray()))
				{
					if((temp.next.getEmployeeSalaray() == currentEmployee.getEmployeeSalaray()) &&
							temp.next.getEmployeeAge() < currentEmployee.getEmployeeAge())
					{
						temp = temp.next;
					}
					else if(temp.next.getEmployeeSalaray() > currentEmployee.getEmployeeSalaray())
					{
						temp = temp.next;
					}
				}
				
				temp.next = currentEmployee;
				temp.next.next = null;
			}
			currentEmployee = nextEmployee;
		}
		
	}
}
