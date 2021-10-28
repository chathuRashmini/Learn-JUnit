import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ManageEmployees {

    List<Employee> employeeList = new ArrayList<Employee>();

    public void addEmployee(String firstName, String lastName, String contactNumber) {
        Employee emp = new Employee(firstName, lastName, contactNumber);
        checkEmployeeExistence(emp);
        validateEmployee(emp);
        employeeList.add(emp);
    }

    public Collection<Employee> getEmployees() {
        return employeeList;
    }

    public void checkEmployeeExistence(Employee employee) {
        if (employeeList.contains(employee)) {
            throw new RuntimeException("This Employee Exists Already");
        }
    }

    public void validateEmployee(Employee employee) {
        employee.validateFirstName();
        employee.validateLastName();
        employee.validateContactNumber();
    }
}
