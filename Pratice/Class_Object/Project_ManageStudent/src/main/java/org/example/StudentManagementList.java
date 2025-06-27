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

    public void showStudentById(String studentId){
        boolean flag = false;
        for(int i = 0; i < count; i++){
            if(studentList[i].studentId.equalsIgnoreCase(studentId)){
                studentList[i].showProfile();
                flag = true;
                break;
            }
        }
        if(flag == false){
            System.out.println("This student ID does not exist in student list!!!");
        }
    }

    public boolean findStudentById(String studentId){
        for(int i = 0; i < count; i++){
            if(studentList[i].studentId.equalsIgnoreCase(studentId)){
                return true;
            }
        }
        return false;
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

    public boolean updateStudentNameById(String studentId, String name){
        for(int i = 0; i < numberStudentInList; i++){
            if(studentList[i].studentId.equalsIgnoreCase(studentId)){
                studentList[i].name = name;
                return true;
            }
        }
        return false;
    }

    public boolean updateStudentAgeById(String studentId, int age){
        for(int i = 0; i < numberStudentInList; i++){
            if(studentList[i].studentId.equalsIgnoreCase(studentId)){
                studentList[i].age = age;
                return true;
            }
        }
        return false;
    }

    public boolean updateStudentPhoneById(String studentId, String phone){
        for(int i = 0; i < numberStudentInList; i++){
            if(studentList[i].studentId.equalsIgnoreCase(studentId)){
                studentList[i].phone = phone;
                return true;
            }
        }
        return false;
    }

    public boolean updateStudentAddressById(String studentId, String address){
        for(int i = 0; i < numberStudentInList; i++){
            if(studentList[i].studentId.equalsIgnoreCase(studentId)){
                studentList[i].address = address;
                return true;
            }
        }
        return false;
    }

    public boolean updateStudentALlById(String studentId, String name, int age, String phone, String address){
        for(int i = 0; i < numberStudentInList; i++){
            if(studentList[i].studentId.equalsIgnoreCase(studentId)){
                studentList[i].name = name;
                studentList[i].age = age;
                studentList[i].phone = phone;
                studentList[i].address = address;
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
