import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * class HumanResources chứa luồng chính của chương trình method main điều khiển
 * luồng chính của chương trình bắt đầu chương trình sẽ gọi method department để
 * thêm danh sách bộ phân và method staff để thêm nhân viên ban đầu cho công ty
 * method menu hiển thị các chức năng để người dùng chọn
 *
 */
public class HumanResources {
	public static ArrayList<Staff> staffLisst = new ArrayList<Staff>(); // Array list lưu thông tin nhân viên
	public static ArrayList<Department> DepartmentList = new ArrayList<Department>(); // Array list lưu các bộ phận
//	các biến dùng để nhập dữ liệu khi thêm nhân viên mới vào công ty
	public static String id, fullName, workingDay, department;
	public static int age, dayOfleave;
	public static double coefficientsSalary;
	public static Scanner sc = new Scanner(System.in);

/**
 * 	method điều khiển luồng chính của chương trình
 * @param args
 */
	public static void main(String[] args) {
		department();
		staff();
		while (true) {
			menu();
		}
	}

/**
 *  method hiển thị các chức năng chính của chương trình
 */
	public static void menu() {
//      Menu của chương trình
		System.out.println("CHUONG TRINH QUAN LY NHAN VIEN");
		System.out.println("1.Hien thi danh sach nhan vien");
		System.out.println("2.Hien thi cac bo phan");
		System.out.println("3.Hien thi nhan vien theo bo phan");
		System.out.println("4.Them nhan vien");
		System.out.println("5.Tim kiem nhan vien theo ten hoac theo ma nhan vien");
		System.out.println("6.Hien thi bang luong toan cong ty");
		System.out.println("7.Hien thi bang luong nhan vien theo thu tu tang dan");
		System.out.println("0.Thoat khoi Ung dung");
		System.out.print("Lua chon cua ban: ");
//      Giá trị của người dùng nhập vào
		int value = sc.nextInt();
		switch (value) {
		// Chức năng 1 Hiển thị danh sách nhân viên
		case 1:
			System.out.println("Danh sach nhan vien cong ty:");
			System.out.printf("%-15s | %-20s | %-5s | %-10s | %-13s | %-23s | %-20s | %-25s | %-15s\n", "Ma nhan vien",
					"Ho va ten", "Tuoi", "HS Luong", "Ngay vao lam", "Bo phan lam viec", "So ngay nghi phep",
					"So gio lam them/Chuc vu", "Luong");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			displayStaffList();
			System.out.println();
			break;
		// Chức năng 2 Hiển thị các bộ phận trong công ty
		case 2:
			System.out.println("Cac bo phan cua cong ty:");
			System.out.printf("%-10s | %-20s | %-25s\n", "Ma bo phan", "Ten bo phan", "So luong nhan vien hien tai");
			System.out.println("-------------------------------------------------------------------");
			displayDepartmentList();
			System.out.println();
			break;
		// Chức năng 3 Hiển thị nhân viên theo bộ phận
		case 3:
			displayStaffDepartment();
			System.out.println();
			break;
		// Chức năng 4 Thêm nhân viên
		case 4:
			addStaff();
			System.out.println();
			break;
		// Chức năng 5 Tìm kiếm nhân viên theo mã hoặc họ và tên
		case 5:
			searchStaff();
			System.out.println();
			break;
		// Chức năng 6 Hiển thị bảng lượng toàn công ty giảm dần
		case 6:
			descendingSalaryArrangement();
			System.out.println();
			break;
		// Chức năng 7 Hiển thị bảng lương nhân viên theo thứ tự tăng dần
		case 7:
			SalaryArrangement();
			System.out.println();
			break;
		// Chức năng thoát khỏi chương trình
		case 0:
			System.out.println("Hen gap lai ban!");
			System.exit(0);
		default:
			System.err.println("Chuc nang ban chon khong ton tai!");
			System.out.println();
		}
	}

/**
 * 	khởi tạo danh sách nhân viên ban đầu cho công ty
 * 	add nhân viên vào danh sach staffList để lưu trữ và quản lý
 * 	gọi hàm numberEmployeesDepartment() để tổng hợp số nhân theo từng bộ phận
 */
	public static void staff() {
//	    Danh sách nhân viên
		Employee employee1 = new Employee("E001", "Phong Tuyet Hoa", 24, 3.2, "1/1/2021", "Hanh chinh nhan su", 1, 4);
		Employee employee2 = new Employee("E002", "Ngo Van Que", 26, 2.1, "1/1/2019", "Cong nghe thong tin", 1, 5);
		Employee employee3 = new Employee("E003", "Tran Thi Ben", 30, 2.2, "1/1/2015", "Cong nghe thong tin", 1, 3);

//	    Danh sách quản lý
		Manager manager1 = new Manager("M001", "Nguyen Thuy Linh", 35, 4.5, "1/1/2010", "Cong nghe thong tin", 2,
				"Business Leader");
		Manager manager2 = new Manager("M002", "Ta Van Luc", 37, 4.5, "1/1/2010", "Hanh chinh nhan su", 2,
				"Technical Leader");
		Manager manager3 = new Manager("M003", "Nguyen Van An", 34, 2.5, "1/1/2010", "Marketing", 2, "Business Leader");

//	    Thêm nhân viên và quản lý vào danh sách mảng
		staffLisst.add(employee1);
		staffLisst.add(employee2);
		staffLisst.add(employee3);
		staffLisst.add(manager1);
		staffLisst.add(manager2);
		staffLisst.add(manager3);
		numberEmployeesDepartment(); // tổng hợp số lượng nhân viên từng bộ phận
	}

/**
 * 	method khởi tạo các bộ phận của công ty
 * 	add vào DepartmentList để lưu trữ và quản lý các bộ phận
 */
	public static void department() {
//		   Tạo ra các bộ phận cho công ty
		Department department1 = new Department("HC", "Hanh chinh nhan su", 0);
		Department department2 = new Department("IT", "Cong nghe thong tin", 0);
		Department department3 = new Department("MKT", "Marketing", 0);
//	        ADD các bộ phận vào danh sách mảng
		DepartmentList.add(department1);
		DepartmentList.add(department2);
		DepartmentList.add(department3);
	}

/**
 * 	method tổng hợp số lượng nhân viên trong từng bộ phận
 */
	public static void numberEmployeesDepartment() {
		for (Department department : DepartmentList) {
			int count = 0;
			for (Staff staff : staffLisst) {
				if (staff.getDepartment().equals(department.getDepartmentName())) {
					count++;
					department.setNumberEmployees(count);
				}
			}
		}
	}

/**
 * 	 1.   method hiển thị danh sách nhân viên của công ty
 */
	public static void displayStaffList() {
		for (Staff staff : staffLisst) {
			staff.displayInformation();
		}
	}

/**
 * 	2. method hiển thị danh sách bộ phận của công ty
 */
	public static void displayDepartmentList() {
		for (Department department : DepartmentList) {
			System.out.println(department);
		}
	}

/**
 * 	 3. method hiển thị nhân viên theo từng bộ phân
 */
	public static void displayStaffDepartment() {
		for (Department department : DepartmentList) {
			System.out.println(department.getDepartmentName());
			System.out.println("------------------------------------------------------------------------------");
			System.out.printf("%-15s | %-20s | %-5s | %-10s | %-13s | %-23s | %-20s | %-25s | %-15s\n", "Ma nhan vien",
					"Ho va ten", "Tuoi", "HS Luong", "Ngay vao lam", "Bo phan lam viec", "So ngay nghi phep",
					"So gio lam them/Chuc vu", "Luong");
			for (Staff staff : staffLisst) {
				if (staff.getDepartment().equals(department.getDepartmentName())) {
					staff.displayInformation();
				}
			}
			System.out.println();
		}
	}

/**
 * 	Nhập thông tin nhân viên mới để thêm vào công ty
 * 	Nhập các thông tin của nhần viên mới(mã nhân viên, tên, tuổi, hệ số lương, 
 * 		ngày vào làm, số ngày nghỉ phép, bộ phận)
 */
	public static void dataEntry() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap ma nhan vien: ");
		id = sc.next();
		for (Staff staff : staffLisst) {
			if (staff.getStaffId().equals(id)) {
				System.out.println("Ma nhan vien da ton tai, vui long nhap lai !");
				id = sc.next();
			}
		}
		System.out.print("Nhap ten nhan vien: ");
		fullName = scan.nextLine();
		System.out.print("Nhap tuoi nhan vien: ");
		try {
			age = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			age = 18;
		}
		System.out.print("Nhap he so luong cua nhan vien: ");
		coefficientsSalary = sc.nextDouble();
		System.out.print("Nhap ngay vao lam cua nhan vien: ");
		workingDay = sc.next();

//		kiểm tra ngày tháng nhập vào có đúng hay ko                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		String[] arr = workingDay.split("/");
		int dd = Integer.parseInt(arr[0]);
		int mm = Integer.parseInt(arr[1]);
		int yy = Integer.parseInt(arr[2]);
		if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {
			if (dd < 0 || dd > 30) {
				System.out.println("Thang " + mm + " khong co ngay 31 vui long nhap lai");
				workingDay = sc.next();
			}
		} else if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) {
			if (dd < 0 || dd > 31) {
				System.out.println("Nhap lai ngay vao lam");
				workingDay = sc.next();
			}
		} else if (mm == 2) {
			if (dd < 0 || dd > 28) {
				System.out.println("Thang " + mm + " khong co ngay 29 vui long nhap lai");
				workingDay = sc.next();
			}
		}
		if (yy < 1990 || yy > 2023) {
			System.out.println("Nhap lai ngay vao lam");
			workingDay = sc.next();
		}

		System.out.print("Nhap so ngay nghi phep cua nhan vien: ");
		dayOfleave = Integer.parseInt(scan.nextLine());

		System.out.println("1. HC - Hanh chinh nhan su");
		System.out.println("2. IT - Cong nghe thong tin");
		System.out.println("3. MKT - Marketing");
		while(true) {
			System.out.print("Ban chon bo phan: ");
			int valueDepartment = sc.nextInt();
			if (valueDepartment == 1) {
				department = "Hanh chinh nhan su";
				break;
			} else if (valueDepartment == 2) {
				department = "Cong nghe thong tin";
				break;
			} else if (valueDepartment == 3) {
				department = "Marketing";
				break;
			} 
		}
	}

/**
 * 	4. add nhân viên mới vào công ty
 * 		Chọn 1: thêm nhân viên thông thường
 * 		chọn 2: thêm nhân viên là cấp quản lý
 * 		Nhập xong hết thông tin thỳ add nhân viên mới vào staffList để lưu trữ và quản lý
 */
	public static void addStaff() {
		while (true) {
			System.out.println("1. Them nhan vien thong thuong");
			System.out.println("2. Them nhan vien la cap quan ly (co them chuc vu)");
			System.out.print("Ban chon: ");
			int value = sc.nextInt();

//			Nhập nhân viên thông thường
			if (value == 1) {
				Employee addList = new Employee(null, null, 0, 0, null, null, 0, 0);

				dataEntry();
				addList.setStaffId(id);
				addList.setStaffName(fullName);
				addList.setStaffAge(age);
				addList.setCoefficientsSalary(coefficientsSalary);
				addList.setWorkingDay(workingDay);
				addList.setNumberDaysOfLeave(dayOfleave);
				addList.setDepartment(department);
				System.out.print("Nhap so gio lam them: ");
				addList.setOvertimeHours(sc.nextDouble());

				staffLisst.add(addList);
			}

//			Nhập nhân viên là cấp quản lý 
			if (value == 2) {
				Manager addList = new Manager(null, null, value, value, null, null, value, null);

				dataEntry();
				addList.setStaffId(id);
				addList.setStaffName(fullName);
				addList.setStaffAge(age);
				addList.setCoefficientsSalary(coefficientsSalary);
				addList.setWorkingDay(workingDay);
				addList.setNumberDaysOfLeave(dayOfleave);
				addList.setDepartment(department);

				System.out.println("Chuc danh: ");
				System.out.println("1. Business Leader");
				System.out.println("2. Project Leader");
				System.out.println("3. Technical Leader");
				while(true) {
					System.out.print("Nhap chuc danh: ");
					int valuePosition = sc.nextInt();
					if (valuePosition == 1) {
						addList.setPosition("Business Leader");
						break;
					} else if (valuePosition == 2) {
						addList.setPosition("Project Leader");
						break;
					} else if (valuePosition == 3) {
						addList.setPosition("Technical Leader");
						break;
					} 
				}
				staffLisst.add(addList);
			}
			numberEmployeesDepartment();
			System.out.println("Ban co muon tiep tuc them nhan vien: chon Y/N");
			if (sc.next().equalsIgnoreCase("n")) {
				break;
			}
		}
	}

/**
 * 	5. Tìm kiếm thông tin nhân viên trong công ty
 * 		Tìm kiểm theo tên hoặc tìm kiếm mã nhân viên
 * 		tìm thấy thỳ hiển thị thông tin nhân viên không tìm thấy thỳ thông báo nhân viên khôn tồn tại
 */
	public static void searchStaff() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1. Tim nhan vien theo ten: ");
		System.out.println("2. Tim nhan vien bang ma nhan vien: ");
		System.out.print("Ban chon: ");
		int value = scan.nextInt();
		boolean noStaff = true;
//		Tìm nhân viên theo tên
		if (value == 1) {
			System.out.println("Nhap ten nhan vien can tim: ");
			String name = scan.next();
			System.out.printf("%-15s | %-20s | %-5s | %-10s | %-13s | %-23s | %-20s | %-25s | %-15s\n",
					"Ma nhan vien", "Ho va ten", "Tuoi", "HS Luong", "Ngay vao lam", "Bo phan lam viec",
					"So ngay nghi phep", "So gio lam them/Chuc vu", "Luong");
			for (Staff staff : staffLisst) {
				if (staff.getStaffName().toLowerCase().contains(name.toLowerCase())) {
					staff.displayInformation();
					noStaff = false;
				}
			}
			System.out.println();
			if (noStaff) {
				System.out.println("Nhan vien khong ton tai!");
			}
			System.out.println();
			System.out.println(
					"------------------------------------------------------------------------------------------------------------");
		}
//		Tim nhan vien theo ma nhan vien
		if (value == 2) {
			System.out.println("Nhap ma nhan vien can tim: ");
			String id = scan.next();
			System.out.printf("%-15s | %-20s | %-5s | %-10s | %-13s | %-23s | %-20s | %-25s | %-15s\n",
					"Ma nhan vien", "Ho va ten", "Tuoi", "HS Luong", "Ngay vao lam", "Bo phan lam viec",
					"So ngay nghi phep", "So gio lam them/Chuc vu", "Luong");
			for (Staff staff : staffLisst) {
				if (staff.getStaffId().contains(id)) {
					staff.displayInformation();
					noStaff = false;
				}
			}
			System.out.println();
			if (noStaff) {
				System.out.println("Nhan vien khong ton tai!");
			}
			System.out.println();
			System.out.println(
					"------------------------------------------------------------------------------------------------------------");
		}
	}

/**
 * 	6. Hiển thị bảng lương nhân viên theo thứ tự giảm dần
 */
	public static void descendingSalaryArrangement() {
		Collections.sort(staffLisst, new Comparator<Staff>() {
			
			@Override
			public int compare(Staff o1, Staff o2) {
				if (((ICalculator) o1).calculateSalary() < ((ICalculator) o2).calculateSalary()) {
					return 1;
				}
				if (((ICalculator) o1).calculateSalary() > ((ICalculator) o2).calculateSalary()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		System.out.println("Bang luong cua toan bo nhan vien theo thu tu giam dan:");
		System.out.printf("%-15s | %-20s | %-5s | %-10s | %-13s | %-23s | %-20s | %-25s | %-15s\n", "Ma nhan vien",
				"Ho va ten", "Tuoi", "HS Luong", "Ngay vao lam", "Bo phan lam viec", "So ngay nghi phep",
				"So gio lam them/Chuc vu", "Luong");
		for (Staff staff : staffLisst) {
			staff.displayInformation();
		}
	}

	/**
	 * Hiển thị bảng lương nhân viên theo thứ tự tăng dần
	 * 
	 */
	public static void SalaryArrangement() {
		Collections.sort(staffLisst, new Comparator<Staff>() {
			
			@Override
			public int compare(Staff o1, Staff o2) {
				if (((ICalculator) o1).calculateSalary() < ((ICalculator) o2).calculateSalary()) {
					return -1;
				}
				if (((ICalculator) o1).calculateSalary() > ((ICalculator) o2).calculateSalary()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		System.out.println("Bang luong cua toan bo nhan vien theo thu tu tang dan:");
		System.out.printf("%-15s | %-20s | %-5s | %-10s | %-13s | %-23s | %-20s | %-25s | %-15s\n", "Ma nhan vien",
				"Ho va ten", "Tuoi", "HS Luong", "Ngay vao lam", "Bo phan lam viec", "So ngay nghi phep",
				"So gio lam them/Chuc vu", "Luong");
		for (Staff staff : staffLisst) {
			staff.displayInformation();
		}
	}
}
