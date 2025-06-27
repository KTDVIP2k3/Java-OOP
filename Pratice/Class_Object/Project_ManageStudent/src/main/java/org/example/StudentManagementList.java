package org.example;

public class StudentManagementList {
    int numberStudentInList;
    Student [] studentList;
    int count = 0;

    public StudentManagementList(int numberStudentInList) {
        this.numberStudentInList = numberStudentInList;
        this.studentList = new Student[numberStudentInList];
    }
    public void showStudentList(){
        if(count == 0){
            System.out.println("Student list is blank!!!");
            return;
        }
        for(int i = 0; i < count; i++){
            studentList[i].showProfile();
        }
    }

    public boolean addStudent(Student student){
        if(count >= numberStudentInList){
            System.out.print("The list is fulled");
            return false;
        }

        studentList[count] = student;
        count++;
        return true;
    }

    public boolean updateStudentById(String studentId){
        for(int i = 0; i < numberStudentInList; i++){
            if(studentList[i].studentId.equalsIgnoreCase(studentId)){
                return true;
            }
        }
        return false;
    }

    public boolean deteletStudentById(String studentId){
        for(int i = 0; i < count; i++){
            if(studentList[i].studentId.equalsIgnoreCase(studentId)){
                for(int j = i; j < numberStudentInList - 1; j++){
                    studentList[j] = studentList[j + 1];
                }
                studentList[numberStudentInList - 1] = null;
                count--;
                return true;
            }
        }
        System.out.println("Student Id not found");
        return false;
    }
}
