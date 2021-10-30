public class Employee {
    private String first_name;
    private String last_name;
    private String contact_number;

    public Employee(String firstName, String lastName, String contactNumber) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.contact_number = contactNumber;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public void validateFirstName() {
        if (this.first_name.isBlank()) {
            throw new RuntimeException("First Name Cannot Be Empty");
        }
    }

    public void validateLastName() {
        if (this.last_name.isBlank()) {
            throw new RuntimeException("Last Name Cannot Be Empty");
        }
    }

    public void validateContactNumber() {
        if (this.contact_number.isBlank()) {
            throw new RuntimeException("Contact Number Cannot Be Empty");
        }

        if (this.contact_number.length() != 10) {
            throw new RuntimeException("Contact Number Should Be Of Length 10");
        }
    }
}
