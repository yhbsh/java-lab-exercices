import java.util.Scanner;

public class Employee {
  double salary;
  String department;
  int years;
  Employee manager;

  public Employee(double salary, String department, Employee manager) {
    this.years = 0;
    this.salary = salary;
    this.department = department;

    if (manager != null && manager.isManager())
      this.manager = manager;
    else
      this.manager = null;
  }

  public double getSalary() {
    return salary;
  }
  public String getDepartment() {
    return department;
  }
  public Employee getManager() {
    return manager;
  }

  public boolean changeManager(Employee manager) {
    if (isManagerValid(manager)) {
      this.manager = manager;
      System.out.println("Manager has been changed correctly");
      return true;
    }

    System.out.println("Manager could not be changed");
    return false;
  }

  public boolean isManager() {
    return manager == null;
  }

  public boolean isManagerValid(Employee manager) {
    return manager != null && manager.isManager() && manager.getDepartment().equals(department);
  }

  public boolean yearlyRaise(double performance) {
    if (performance > 100 || performance < 0)
      return false;

    double raise = 0;
    if (90 <= performance && performance <= 100) {
      raise = 0.15;
    } else if (75 <= performance && performance < 90) {
      raise = 0.10;
    } else if (50 <= performance && performance < 75) {
      raise = 0.05;
    } else if (25 <= performance && performance < 50) {
      raise = 0.0;
    } else {
      raise = -0.05;
    }

    double bonus = 0;
    if (0 <= years && years <= 5) {
      bonus = 100;
    } else if (6 <= years && years <= 10) {
      bonus = 250;
    } else {
      bonus = 500;
    }

    salary = salary * (1 + raise) + bonus;
    this.years += 1;

    if (isManager()) {
      salary += 1000;
    }
    return true;
  }

  public String toString() {
    String employeeType = "";

    if (isManager()) {
      employeeType = "Manager";
    } else {
      employeeType = "Employee";
    }

    return employeeType + " of " + department + " department. Worked for " + years + " years. Salary: " + salary;
  }

  public static void main(String[] args) {
    System.out.println("Hello World");
    final Scanner scanner = new Scanner(System.in);

    System.out.print("Enter first employee salary: ");
    final double s1 = scanner.nextDouble();
    System.out.print("Enter first employee department: ");
    final String d1 = scanner.next();

    System.out.print("Enter second employee salary: ");
    final double s2 = scanner.nextDouble();
    System.out.print("Enter second employee department: ");
    final String d2 = scanner.next();

    System.out.print("Enter third employee salary: ");
    final double s3 = scanner.nextDouble();
    System.out.print("Enter third employee department: ");
    final String d3 = scanner.next();

    final Employee e1 = new Employee(s1, d1, null);
    final Employee e2 = new Employee(s2, d2, null);
    final Employee e3 = new Employee(s3, d3, null);

    System.out.print("Enter the first year performace for the first employee: ");
    final double py1e1 = scanner.nextDouble();
    System.out.print("Enter the second year performace for the first employee: ");
    final double py2e1 = scanner.nextDouble();
    System.out.print("Enter the third year performace for the first employee: ");
    final double py3e1 = scanner.nextDouble();

    e1.yearlyRaise(py1e1);
    e1.yearlyRaise(py2e1);
    e1.yearlyRaise(py3e1);

    e2.changeManager(e1);
    e3.changeManager(e1);

    System.out.print("Enter the yearly performace for the second employee: ");
    final double py1e2 = scanner.nextDouble();
    System.out.print("Enter the yearly performace for the third employee: ");
    final double py1e3 = scanner.nextDouble();

    e2.yearlyRaise(py1e2);
    e3.yearlyRaise(py1e3);

    System.out.println(e1.toString());
    System.out.println(e2.toString());
    System.out.println(e3.toString());
  }
}
