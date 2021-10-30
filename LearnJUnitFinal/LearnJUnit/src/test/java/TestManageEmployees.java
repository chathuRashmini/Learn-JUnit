import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

public class TestManageEmployees {

    ManageEmployees employees;

    @BeforeAll
    public static void TestBeforeAll () {
        ManageEmployees employees = new ManageEmployees();
        System.out.println("Should print BEFORE executing any other tests");
    }

    @BeforeEach
    public void TestBeforeEach() {
        ManageEmployees employees = new ManageEmployees();
        System.out.println("Execute BEFORE EACH test method");
    }

    @Test
    public void TestBeforeAllSuccess() {
        System.out.println("Should print AFTER executing TestBeforeAll () method");
    }

    @Test
    public void TestAfterEachSuccess() {
        System.out.println("Should print BEFORE executing TestAfterEach () method");
    }

    @AfterEach
    public void TestAfterEach() {
        System.out.println("Should print AFTER the execution of EACH test method.");
    }

    @AfterAll
    public static void TestAfterAll() {
        System.out.println("Should execute AFTER ALL the test methods");
    }

    @Test
    public void TestAddEmployee() {
        ManageEmployees employees = new ManageEmployees();
        employees.addEmployee("Edward", "Cullen", "0123456789");
        Assertions.assertFalse(employees.getEmployees().isEmpty());
        Assertions.assertEquals(1, employees.getEmployees().size());
    }

    @Test
    @DisplayName("Object should not create when first_name is null")
    public void throwRuntimeExceptionWhenFirstNameIsNull() {
        ManageEmployees employees = new ManageEmployees();
        Assertions.assertThrows(RuntimeException.class, () -> {
            employees.addEmployee(null, "Cullen", "0123456789");
        });
        System.out.println("Number of Employees: " + employees.getEmployees().size());
    }

    @Test
    @DisplayName("Object should not create when last_name is null")
    public void throwRuntimeExceptionWhenSecondNameIsNull() {
        ManageEmployees employees = new ManageEmployees();
        Assertions.assertThrows(RuntimeException.class, () -> {
            employees.addEmployee("Edward", null, "0123456789");
        });
        System.out.println("Number of Employees: " + employees.getEmployees().size());
    }

    @Test
    @DisplayName("Object should not create when contact_number is null")
    public void throwRuntimeExceptionWhenContactNumberIsNull() {
        ManageEmployees employees = new ManageEmployees();
        Assertions.assertThrows(RuntimeException.class, () -> {
            employees.addEmployee("Edward", "Cullen", null);
        });
        System.out.println("Number of Employees: " + employees.getEmployees().size());
    }

    @Test
    @DisplayName("Should Be Enabled Only On MAC OS")
    @EnabledOnOs(value = OS.MAC, disabledReason = "Test is only enabled on MAC OS")
    public void TestEnabledOnOS() {
        System.out.println("Tests EnabledOnOs annotation");
    }

    @Test
    @DisplayName("Should Be Disabled On Windows")
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Test is disabled on Windows")
    public void TestDisabledOnOS() {
        System.out.println("Tests DisabledOnOs annotation");
    }

    @DisplayName("Checks the Repeated Tests")
    @RepeatedTest(value = 5, name = "Repeating {currentRepetition} of {totalRepetitions}")
    public void TestRepeatedTest() {
        System.out.println("This is a repetition test");
    }

    @DisplayName("Add Employee for different parameters")
    @ParameterizedTest
    @ValueSource(strings = {"0123456789", "0987654321"})
    public void TestParameterizedTestValueSource(String contact_number) {
        ManageEmployees employees = new ManageEmployees();
        employees.addEmployee("Charlie", "Swan", contact_number);
        Assertions.assertFalse(employees.getEmployees().isEmpty());
        Assertions.assertEquals(1, employees.getEmployees().size());
        System.out.println("Line with the contact number: " + contact_number);
    }

    private static List<String> contactNumbersList() {
        return Arrays.asList("0123456789", "0987654321");
    }

    @DisplayName("Add Employee using MethodSource")
    @ParameterizedTest
    @MethodSource("contactNumbersList")
    public void TestParameterizedTestMethodSource(String contact_number) {
        ManageEmployees employees = new ManageEmployees();
        employees.addEmployee("Bella", "Swan", contact_number);
        Assertions.assertFalse(employees.getEmployees().isEmpty());
        Assertions.assertEquals(1, employees.getEmployees().size());
        System.out.println("Line with the contact number: " + contact_number);
    }

    @DisplayName("Add Employee using CsvSource")
    @ParameterizedTest
    @CsvSource({"0123456789", "0987654321"})
    public void TestParameterizedTestCsvSource(String contact_number) {
        ManageEmployees employees = new ManageEmployees();
        employees.addEmployee("Jacob", "Black", contact_number);
        Assertions.assertFalse(employees.getEmployees().isEmpty());
        Assertions.assertEquals(1, employees.getEmployees().size());
        System.out.println("Line with the contact number: " + contact_number);
    }

    @DisplayName("Add Employee using CsvFileSource")
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void TestParameterizedTestCsvFileSource(String contact_number) {
        ManageEmployees employees = new ManageEmployees();
        employees.addEmployee("Alice", "Cullen", contact_number);
        Assertions.assertFalse(employees.getEmployees().isEmpty());
        Assertions.assertEquals(1, employees.getEmployees().size());
        System.out.println("Line with the contact number: " + contact_number);
    }

    @Nested
    class NestedTestClass {

        @Test
        @DisplayName("Should Be Enabled Only On MAC OS")
        @EnabledOnOs(value = OS.MAC, disabledReason = "Test is only enabled on MAC OS")
        public void TestEnabledOnOS() {
            System.out.println("Tests EnabledOnOs annotation");
        }

        @DisplayName("Add Employee using CsvFileSource")
        @ParameterizedTest
        @CsvFileSource(resources = "/data.csv")
        public void TestParameterizedTestCsvFileSource(String contact_number) {
            ManageEmployees employees = new ManageEmployees();
            employees.addEmployee("Alice", "Cullen", contact_number);
            Assertions.assertFalse(employees.getEmployees().isEmpty());
            Assertions.assertEquals(1, employees.getEmployees().size());
            System.out.println("Line with the contact number: " + contact_number);
        }
    }

    @Test
    @Disabled
    public void TestDisabled() {
        ManageEmployees employees = new ManageEmployees();
        employees.addEmployee("Emmet", "Cullen", "0123458762");
    }
}
