import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ManageEmployees {

    Map<String, Employee> employeesList = new ConcurrentHashMap<String, Employee>();

    public void addEmployee(String firstName, String lastName, String contactNumber) {
        Employee emp = new Employee(firstName, lastName, contactNumber);
        checkEmployeeExistence(emp);
        validateEmployee(emp);
        employeesList.put(generateKey(emp), emp);
    }
    private String generateKey(Employee employee) {
        return String.format("%s-%s", employee.getFirst_name(), employee.getLast_name());
    }

    public Collection<Employee> getEmployees() {
        return employeesList.values();
    }

    public void checkEmployeeExistence(Employee employee) {
        if (employeesList.containsKey(generateKey(employee))) {
            throw new RuntimeException("This Employee Exists Already");
        }
    }

    public void validateEmployee(Employee employee) {
        employee.validateFirstName();
        employee.validateLastName();
        employee.validateContactNumber();
    }
}
