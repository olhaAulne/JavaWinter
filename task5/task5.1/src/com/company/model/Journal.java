package com.company.model;

public class Journal {
    private String studentLastName = "";
    private String studentFirstName = "";
    private String studentBirthDate = "";
    private String studentPhone = "";
    private String studentHomeAddress = "";

    public Journal(String lastName, String firstName, String birthDate, String phone, String address){
        studentLastName = lastName;
        studentFirstName = firstName;
        studentBirthDate = birthDate;
        studentPhone = phone;
        studentHomeAddress = address;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentBirthDate() {
        return studentBirthDate;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public String getStudentHomeAddress() {
        return studentHomeAddress;
    }
}
