package org.example;

import Model.Person;
import Model.Student;
import Model.Teacher;
import ServiceImplements.PersonalRegisterServiceImplement;
import ServiceImplements.StudentManagementServiceImplement;
import ServiceImplements.TeacherManagementServiceImplement;
import ServiceInterfaces.GenericServiceInterface;
import ServiceInterfaces.PersonalRegisterServiceInterface;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static  final PersonalRegisterServiceInterface personalRegisterServiceInterface = new PersonalRegisterServiceImplement();
    private static final GenericServiceInterface<Teacher> teacherGenericServiceInterface = new TeacherManagementServiceImplement(personalRegisterServiceInterface);
    private static final GenericServiceInterface<Student> studentGenericServiceInterface = new StudentManagementServiceImplement(personalRegisterServiceInterface);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try{
            boolean flag = true;
            int choice = 0;
            do{
                System.out.println("Main Menu Management");
                System.out.println("1.Teacher Management");
                System.out.println("2.Student Management");
                System.out.println("3.Get all user from personal list");
                System.out.println("4.Exit");
                System.out.print("Please input your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch(choice){
                    case 1:
                        teacherManagementScreen();
                        break;
                    case 2:
                        studentManagementScreen();
                        break;
                    case 3:
                        List<Person> personList = personalRegisterServiceInterface.getAllPerson();
                        if(personalRegisterServiceInterface.getAllPerson().isEmpty()){
                            System.out.println("Personal List is empty");
                        }else{
                            System.out.println("Personal list:");
                            for(Person person : personList){
                                System.out.println(person.showInfor());
                            }
                        }
                        break;
                    case 4:
                        flag = false;
                        System.out.println("Exit.......");
                        break;
                    default:
                        System.out.println("Invalid input");
                        System.out.println("Please choose 1 to 4....");
                        break;
                }
            }while (flag);
        } catch (NumberFormatException numberFormatException){
            System.out.println("Your choice should be digit!!!!");
        }
        catch (IllegalArgumentException illegalArgumentException){
            System.out.println("Error services: " + illegalArgumentException.getMessage());
        }
        catch (Exception e){
            System.out.println("System error: " + e.getMessage());
        }
    }

    private static void teacherManagementScreen(){
        try{
            boolean flag = true;
            int choice = 0;
            do{
                System.out.println("Teacher Management");
                System.out.println("1.Get all teacher");
                System.out.println("2.Find teacher by teacher id");
                System.out.println("3.Create teacher");
                System.out.println("4.Update teacher by id");
                System.out.println("5.Delete teacher by id");
                System.out.println("6.Back to Main Menu Management");
                System.out.print("Please input your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch(choice){
                    case 1:
                        List<Teacher> teacherList = teacherGenericServiceInterface.getAll();
                        if(teacherList.isEmpty()){
                            System.out.println("Teacher list is empty");
                        }else{
                            System.out.println("Teacher List:");
                            for(Teacher teacher : teacherList){
                                System.out.println(teacher.showInfor());
                            }
                        }
                        break;
                    case 2:{
                        System.out.print("Please input teacher ID: ");
                        Teacher teacher = teacherGenericServiceInterface.findById(scanner.nextLine());
                        if(teacher!= null){
                            System.out.println(teacher.showInfor());
                        }else{
                            System.out.println("Teacher id does not exist");
                        }
                    }
                    case 3:
                        try{
                            Teacher teacher = new Teacher();
                            System.out.print("Please input teacher identifiable number Id: ");
                            teacher.setIdentifiableIdNumber(scanner.nextLine());
                            System.out.print("Please input teacher name: ");
                            teacher.setName(scanner.nextLine());
                            System.out.print("Please input teacher address: ");
                            teacher.setAddress(scanner.nextLine());
                            System.out.print("Please input teacher age: ");
                            teacher.setAge(Integer.parseInt(scanner.nextLine()));
                            System.out.print("Please input teacher birthday: ");
                            teacher.setBirthday(scanner.nextLine());
                            System.out.print("Please input teacher gender: ");
                            teacher.setGender(scanner.nextLine());
                            System.out.print("Please input teacher nationality: ");
                            teacher.setNationality(scanner.nextLine());
                            System.out.print("Please input teacher Id: ");
                            teacher.setTeacherID(scanner.nextLine());
                            System.out.print("Please input teacher department: ");
                            teacher.setDepartment(scanner.nextLine());
                            System.out.print("Please input teacher qualification: ");
                            teacher.setQualification(scanner.nextLine());
                            System.out.print("Please input teacher salary scale: ");
                            teacher.setSalaryScale(Double.parseDouble(scanner.nextLine()));
                            teacher.setEmploymentDate(LocalDate.now());
                            if(teacherGenericServiceInterface.add(teacher)){
                                System.out.println("Add teacher successfully");
                            }else{
                                System.out.println("Add teacher failed");
                            }
                        }catch (NumberFormatException numberFormatException){
                            System.out.println(numberFormatException.getMessage());
                        }
                        break;
                    case 4:
                        try{
                            System.out.print("Please input teacher ID: ");
                            Teacher teacher = teacherGenericServiceInterface.findById(scanner.nextLine());
                            if(teacher!= null){
                                System.out.print("Please input new teacher name: ");
                                teacher.setName(scanner.nextLine());
                                System.out.print("Please input new teacher address: ");
                                teacher.setAddress(scanner.nextLine());
                                System.out.print("Please input new teacher age: ");
                                teacher.setAge(Integer.parseInt(scanner.nextLine()));
                                System.out.print("Please input new teacher birthday: ");
                                teacher.setBirthday(scanner.nextLine());
                                System.out.print("Please input new teacher gender: ");
                                teacher.setGender(scanner.nextLine());
                                System.out.print("Please input new teacher nationality: ");
                                teacher.setNationality(scanner.nextLine());
                                System.out.print("Please input new teacher department: ");
                                teacher.setDepartment(scanner.nextLine());
                                System.out.print("Please input new teacher qualification: ");
                                teacher.setQualification(scanner.nextLine());
                                System.out.print("Please input new teacher salary scale: ");
                                teacher.setSalaryScale(Double.parseDouble(scanner.nextLine()));
                                teacher.setEmploymentDate(LocalDate.now());
                                if(teacherGenericServiceInterface.updateById(teacher)){
                                    System.out.println("Update teacher successfully");
                                }else{
                                    System.out.println("Update teacher failed");
                                }

                            }else{
                                System.out.println("Teacher id does not exist");
                            }
                        }catch (NumberFormatException numberFormatException){
                            System.out.println(numberFormatException.getMessage());
                        }
                        break;
                    case 5:
                        System.out.print("Please input teacher ID: ");
                        Teacher teacher = teacherGenericServiceInterface.findById(scanner.nextLine());
                        if(teacher != null){
                            if(teacherGenericServiceInterface.deleteById(teacher.getTeacherID())){
                                System.out.println("Delete teacher successfully");
                            }else{
                                System.out.println("Delete teacher failed");
                            }
                        }
                        break;
                    case 6:
                        flag = false;
                        System.out.println("Back to Main Menu Management.......");
                        break;
                    default:
                        System.out.println("Invalid input");
                        System.out.println("Please choose 1 to 6....");
                        break;
                }
            }while (flag);
        }catch (NumberFormatException numberFormatException){
            System.out.println("Your choice should be digit!!!!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void studentManagementScreen(){
        try{
            boolean flag = true;
            int choice = 0;
            do{
                System.out.println("Student Management");
                System.out.println("1.Get all student");
                System.out.println("2.Find student by student id");
                System.out.println("3.Create student");
                System.out.println("4.Update student by id");
                System.out.println("5.Delete student by id");
                System.out.println("6.Back to Main Menu Management");
                System.out.print("Please input your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch(choice){
                    case 1:
                        List<Student> studentList = studentGenericServiceInterface.getAll();
                        if(studentList.isEmpty()){
                            System.out.println("Student list is empty");
                        }else{
                            System.out.println("Student List:");
                            for(Student student : studentList){
                                System.out.println(student.showInfor());
                            }
                        }
                        break;
                    case 2:{
                        System.out.print("Please input student ID: ");
                        Student student = studentGenericServiceInterface.findById(scanner.nextLine());
                        if(student!= null){
                            System.out.println(student.showInfor());
                        }else{
                            System.out.println("Teacher id does not exist");
                        }
                    }
                    case 3:
                        try{
                            Student student = new Student();
                            System.out.print("Please input student identifiable number Id: ");
                            student.setIdentifiableIdNumber(scanner.nextLine());
                            System.out.print("Please input student name: ");
                            student.setName(scanner.nextLine());
                            System.out.print("Please input student address: ");
                            student.setAddress(scanner.nextLine());
                            System.out.print("Please input student age: ");
                            student.setAge(Integer.parseInt(scanner.nextLine()));
                            System.out.print("Please input student birthday: ");
                            student.setBirthday(scanner.nextLine());
                            System.out.print("Please input student gender: ");
                            student.setGender(scanner.nextLine());
                            System.out.print("Please input student nationality: ");
                            student.setNationality(scanner.nextLine());
                            System.out.print("Please input student Id: ");
                            student.setStudentId(scanner.nextLine());
                            System.out.print("Please input student major: ");
                            student.setMajor(scanner.nextLine());
                            System.out.print("Please input student current year: ");
                            student.setCurrentYear(Integer.parseInt(scanner.nextLine()));
                            System.out.print("Please input student gpa: ");
                            student.setGpa(Double.parseDouble(scanner.nextLine()));
                            System.out.print("Please input student faculty: ");
                            student.setFaculty(scanner.nextLine());
                                if(studentGenericServiceInterface.add(student)){
                                System.out.println("Add student successfully");
                            }else{
                                System.out.println("Add teacher failed");
                            }
                        }catch (NumberFormatException numberFormatException){
                            System.out.println(numberFormatException.getMessage());
                        }
                        break;
                    case 4:
                        try{
                            System.out.print("Please input student ID: ");
                            Student student = studentGenericServiceInterface.findById(scanner.nextLine());
                            if(student!= null){
                                System.out.print("Please input new student name: ");
                                student.setName(scanner.nextLine());
                                System.out.print("Please input new student address: ");
                                student.setAddress(scanner.nextLine());
                                System.out.print("Please input new student age: ");
                                student.setAge(Integer.parseInt(scanner.nextLine()));
                                System.out.print("Please input new student birthday: ");
                                student.setBirthday(scanner.nextLine());
                                System.out.print("Please input new student gender: ");
                                student.setGender(scanner.nextLine());
                                System.out.print("Please input new student nationality: ");
                                student.setNationality(scanner.nextLine());
                                System.out.print("Please input new student major: ");
                                student.setMajor(scanner.nextLine());
                                System.out.print("Please input new student current year: ");
                                student.setCurrentYear(Integer.parseInt(scanner.nextLine()));
                                System.out.print("Please input new student gpa: ");
                                student.setGpa(Double.parseDouble(scanner.nextLine()));
                                System.out.print("Please input new student faculty: ");
                                student.setFaculty(scanner.nextLine());
                                if(studentGenericServiceInterface.updateById(student)){
                                    System.out.println("Update student successfully");
                                }else{
                                    System.out.println("Update student failed");
                                }

                            }else{
                                System.out.println("student id does not exist");
                            }
                        }catch (NumberFormatException numberFormatException){
                            System.out.println(numberFormatException.getMessage());
                        }
                        break;
                    case 5:
                        System.out.print("Please input student ID: ");
                        Student student = studentGenericServiceInterface.findById(scanner.nextLine());
                        if(student != null){
                            if(studentGenericServiceInterface.deleteById(student.getStudentId())){
                                System.out.println("Delete student successfully");
                            }else{
                                System.out.println("Delete student failed");
                            }
                        }
                        break;
                    case 6:
                        flag = false;
                        System.out.println("Back to Main Menu Management.......");
                        break;
                    default:
                        System.out.println("Invalid input");
                        System.out.println("Please choose 1 to 6....");
                        break;
                }
            }while (flag);
        }catch (NumberFormatException numberFormatException){
            System.out.println("Your choice should be digit!!!!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}