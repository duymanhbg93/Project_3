
/**
 * class định nghĩa cho bộ phận
 *
 */
public class Department {
	private String departmentID, departmentName;
	private int numberEmployees;
	
	public Department(String departmentID, String departmentName, int numberEmployees) {
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.numberEmployees = numberEmployees;
	}
	
	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(int numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	@Override
	public String toString() {
		String output = String.format("%-10s | %-20s | %-25s", this.getDepartmentID(), this.getDepartmentName(), this.getNumberEmployees());
		return output;
	}

}
