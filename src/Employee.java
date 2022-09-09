import java.text.DecimalFormat;

/**
 * class nhân viên
 *
 */
public class Employee extends Staff implements ICalculator {
	private double overtimeHours;
	
	public Employee(String staffId, String staffName, int staffAge, double coefficientsSalary, String workingDay,
			String department, int numberDaysOfLeave, double overtimeHours) {
		super(staffId, staffName, staffAge, coefficientsSalary, workingDay, department, numberDaysOfLeave);
		this.overtimeHours = overtimeHours;
	}
	
	public double getOvertimeHours() {
		return overtimeHours;
	}

	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}

//	Nhân viên bình thường: Hệ số lương * 3,000,000 + Số giờ làm thêm * 200,000
	@Override
	public double calculateSalary() {
		return super.getCoefficientsSalary() * 3000000 + this.overtimeHours * 200000;
	}
	

	@Override
	public void displayInformation() {
		DecimalFormat dcf = new DecimalFormat("#.##");
		System.out.printf("%-15s | %-20s | %-5s | %-10s | %-13s | %-23s | %-20s | %-25s | %-15s\n",
				super.getStaffId(),super.getStaffName(),super.getstaffAge(),super.getCoefficientsSalary(),super.getWorkingDay(),
				super.getDepartment(),super.getNumberDaysOfLeave(),this.overtimeHours,dcf.format(this.calculateSalary())+",00");
	}
		
}
