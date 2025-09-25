package Model;

public class Student extends Person{
    private String studentId;
    private String major;
    private int currentYear;
    private double gpa;
    private String faculty;

    public Student(){
    }

    public Student(String identifiableIdNumber, String name, String address, int age,
                   String birthday, String gender, String nationality, String studentId,
                   String major, int currentYear, double gpa, String faculty){
        super(identifiableIdNumber, name, address, age, birthday, gender, nationality);
        this.studentId = studentId;
        this.major = major;
        this.currentYear = currentYear;
        this.gpa = gpa;
        this.faculty = faculty;

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String showInfor() {
        String personInfo = String.format(
                "IdentifiableIdNumber: %s, Name: %s, Address: %s, Age: %d, Birthday: %s, Gender: %s, Nationality: %s",
                super.getIdentifiableIdNumber(), super.getName(), super.getAddress(), super.getAddress(), super.getBirthday(), super.getGender(), super.getNationality() // Giả sử các trường này là protected
        );


        return "--- STUDENT RECORD ---\n" +
                personInfo + "\n" +
                "Student ID: " + this.studentId + "\n" +
                "Major: " + this.major + "\n" +
                "Faculty: " + this.faculty + "\n" +
                "Current Year: " + this.currentYear + "\n" +
                "GPA: " + String.format("%.2f", this.gpa) + "\n" +
                "----------------------";
    }
}
