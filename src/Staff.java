
/**
 * chứa thông tin cơ bản của nhân viên
 *
 */
public abstract class Staff {
	protected String staffId;
	protected String staffName;
	protected int staffAge;
	protected double coefficientsSalary;
	protected String workingDay;
	protected String department;
	protected int numberDaysOfLeave;
	
	public Staff(String staffId, String staffName, int staffAge, double coefficientsSalary, String workingDay,
			String department, int numberDaysOfLeave) {
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffAge = staffAge;
		this.coefficientsSalary = coefficientsSalary;
		this.workingDay = workingDay;
		this.department = department;
		this.numberDaysOfLeave = numberDaysOfLeave;
	}
	
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getstaffAge() {
		return staffAge;
	}

	public void setStaffAge(int staffAge) {
		this.staffAge = staffAge;
	}

	public double getCoefficientsSalary() {
		return coefficientsSalary;
	}

	public void setCoefficientsSalary(double coefficientsSalary) {
		this.coefficientsSalary = coefficientsSalary;
	}

	public String getWorkingDay() {
		return workingDay;
	}

	public void setWorkingDay(String workingDay) {
		this.workingDay = workingDay;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getNumberDaysOfLeave() {
		return numberDaysOfLeave;
	}

	public void setNumberDaysOfLeave(int numberDaysOfLeave) {
		this.numberDaysOfLeave = numberDaysOfLeave;
	}

	public abstract void displayInformation();

}
