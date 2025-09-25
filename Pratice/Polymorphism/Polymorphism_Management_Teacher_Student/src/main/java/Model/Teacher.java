package Model;

import java.time.LocalDate;

public class Teacher extends Person{
    private String teacherID;
    private String department;
    private String qualification;
    private LocalDate employmentDate;
    private double salaryScale;

    public Teacher(){

    }

    public Teacher(String identifiableIdNumber, String name, String address, int age,
                    String birthday, String gender, String nationality,
                    String teacherID, String department, String qualification,
                    LocalDate employmentDate, double salaryScale) {


        super(identifiableIdNumber, name, address, age, birthday, gender, nationality);


        this.teacherID = teacherID;
        this.department = department;
        this.qualification = qualification;
        this.employmentDate = employmentDate;
        this.salaryScale = salaryScale;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getSalaryScale() {
        return salaryScale;
    }

    public void setSalaryScale(double salaryScale) {
        this.salaryScale = salaryScale;
    }

    @Override
    public String showInfor() {
        return "\n============= LECTURER RECORD =============" +
                "\n[THÔNG TIN CÁ NHÂN]" +
                "\n" + super.personInfor() +
                "\n" +
                "\n[THÔNG TIN GIẢNG DẠY]" +
                "\nTeacher ID:   " + this.teacherID +
                "\nDepartment:    " + this.department +
                "\nQualification: " + this.qualification +
                "\nEmployment Date: " + this.employmentDate.toString() + // Dùng .toString() cho LocalDate
                "\nSalary Scale:  " + String.format("%.2f", this.salaryScale) +
                "\n=========================================";
    }
}
