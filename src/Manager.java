import java.text.DecimalFormat;

/**
 * class quản lý 
 *
 */
public class Manager extends Staff implements ICalculator {
	private String position;
	
	public Manager(String staffId, String staffName, int staffAge, double coefficientsSalary, String workingDay,
			String department, int numberDaysOfLeave, String position) {
		super(staffId, staffName, staffAge, coefficientsSalary, workingDay, department, numberDaysOfLeave);
		this.position = position;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

//	Quản lý: Hệ số lương * 5,000,000 + Lương trách nhiệm
	@Override
	public double calculateSalary() {
		double salary = 0;
		if(this.position.equals("Business Leader")) {
			salary += super.getCoefficientsSalary() * 5000000 + 8000000;
		} else if(this.position.equals("Project Leader")) {
			salary += super.getCoefficientsSalary() * 5000000 + 5000000;
		} else if(this.position.equals("Technical Leader")) {
			salary += (super.getCoefficientsSalary() * 5000000 + 6000000);
		}
		return salary;
	}
	
	@Override
	public void displayInformation() {
		DecimalFormat dcf = new DecimalFormat("#.##");
		System.out.printf("%-15s | %-20s | %-5s | %-10s | %-13s | %-23s | %-20s | %-25s | %-15s\n",
				super.getStaffId(),super.getStaffName(),super.getstaffAge(),super.getCoefficientsSalary(),super.getWorkingDay(),
				super.getDepartment(),super.getNumberDaysOfLeave(),this.position,dcf.format(this.calculateSalary())+",00");
	}
	
}
