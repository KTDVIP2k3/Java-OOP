package ServiceImplements;

import Model.Student;
import Model.Teacher;
import ServiceInterfaces.GenericServiceInterface;
import ServiceInterfaces.PersonalRegisterServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class StudentManagementServiceImplement implements GenericServiceInterface<Student> {
    private final List<Student> students = new ArrayList<>();
    private PersonalRegisterServiceInterface personalRegisterServiceInterface;

    public StudentManagementServiceImplement(PersonalRegisterServiceInterface personalRegisterServiceInterface){
        this.personalRegisterServiceInterface = personalRegisterServiceInterface;
    }
    @Override
    public List<Student> getAll() throws Exception {
        if(students == null){
            throw new IllegalArgumentException("Student list should not be null\n" + "Please init student list\n");
        }

        if(students.isEmpty()){
            throw new IllegalArgumentException("Student list is empty\n");
        }
        return students;
    }

    @Override
    public Student findById(String id) throws Exception {
        for(Student student : students){
            if(student.getStudentId().equalsIgnoreCase(id)){
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean add(Student item) throws Exception {

        if(findById(item.getStudentId()) != null){
            throw new IllegalArgumentException("Student Id does exist!!\n" + "Please input another student Id\n");
        }

        if(personalRegisterServiceInterface.findPersonByIdentifiableNumber(item.getIdentifiableIdNumber())){
            throw new IllegalArgumentException("Student identifiable number id does exist\n" + "Please input another identifiable number id\n");
        }

        if(item.getIdentifiableIdNumber().isBlank()){
            throw new IllegalArgumentException("Student identifiable number id should not be blank\n" + "Plase input identifiable number id\n");
        }

        if(item.getName().isBlank()){
            throw new IllegalArgumentException("Student name should not be blank\n" + "Please input student name\n");
        }

        if(item.getAddress().isBlank()){
            throw new IllegalArgumentException("Student address should not be blank\n" + "Please inout student address\n");
        }

        if(item.getAge() < 18){
            throw new IllegalArgumentException("Student age of college should above 18 (>=18)" + "Please input student age again\n");
        }

        if(item.getBirthday().isBlank()){
            throw new IllegalArgumentException("Student birthday should not be blank\n" + "Please input student birthday\n");
        }

        if(item.getGender().isBlank()){
            throw new IllegalArgumentException("Student gender should not be blank\n" + "Please input student gender\n");
        }

        if(item.getNationality().isBlank()){
            throw new IllegalArgumentException("Student nationality should not be blank\n" + "Please input student nationality\n");
        }

        if(item.getStudentId().isBlank()){
            throw new IllegalArgumentException("Student Id should not be blank\n" + "Please input student id\n");
        }

        if(item.getMajor().isBlank()){
            throw new IllegalArgumentException("Student major should not be blank\n" + "Please input student major\n");
        }

        if(item.getCurrentYear() <= 0){
            throw new IllegalArgumentException("Student current year should not be under 0 (<=0)\n" + "Please input student current year\n");
        }
        if(item.getFaculty().isBlank()){
            throw new IllegalArgumentException("Student faculty should not be blank\n" + "Please input student faculty\n");
        }

        if(item.getGpa() < 0){
            throw new IllegalArgumentException("Student gpa should not be under 0 (< 0)\n" + "Please input student gpa\n");
        }
        if(personalRegisterServiceInterface.addPerson(item)){
            System.out.println("Add student into personal list successfully");
        }else{
            System.out.println("Add student into personal list failed");
        }
        return students.add(item);
    }

    @Override
    public boolean updateById(Student item) throws Exception {
        Student student = findById(item.getStudentId());

        if(student == null){
            throw new IllegalArgumentException("Student Id does not exist!!\n" + "Please input again student Id\n");
        }
        if(item.getName().isBlank()){
            throw new IllegalArgumentException("Student name should not be blank\n" + "Please input student name\n");
        }

        if(item.getAddress().isBlank()){
            throw new IllegalArgumentException("Student address should not be blank\n" + "Please inout student address\n");
        }

        if(item.getAge() < 18){
            throw new IllegalArgumentException("Student age of college should above 18 (>=18)" + "Please input student age again\n");
        }

        if(item.getBirthday().isBlank()){
            throw new IllegalArgumentException("Student birthday should not be blank\n" + "Please input student birthday\n");
        }

        if(item.getGender().isBlank()){
            throw new IllegalArgumentException("Student gender should not be blank\n" + "Please input student gender\n");
        }

        if(item.getNationality().isBlank()){
            throw new IllegalArgumentException("Student nationality should not be blank\n" + "Please input student nationality\n");
        }

        if(item.getMajor().isBlank()){
            throw new IllegalArgumentException("Student major should not be blank\n" + "Please input student major\n");
        }

        if(item.getCurrentYear() <= 0){
            throw new IllegalArgumentException("Student current year should not be under 0 (<=0)\n" + "Please input student current year\n");
        }
        if(item.getFaculty().isBlank()){
            throw new IllegalArgumentException("Student faculty should not be blank\n" + "Please input student faculty\n");
        }

        if(personalRegisterServiceInterface.updatePerson(item)){
            System.out.println("Update student into personal list successfully");
        }else{
            System.out.println("Update student into personal list failed");
        }
        student.setName(item.getName());
        student.setAddress(item.getAddress());
        student.setAge(item.getAge());
        student.setBirthday(item.getBirthday());
        student.setGender(item.getGender());
        student.setNationality(item.getNationality());
        student.setMajor(item.getMajor());
        student.setCurrentYear(item.getCurrentYear());
        student.setGpa(item.getGpa());
        student.setFaculty(item.getFaculty());
       for(int i = 0; i <= students.size(); i++){
           if(students.get(i).getStudentId().equalsIgnoreCase(item.getStudentId())){
                students.set(i, student);
                return true;
           }
       }
       return false;
    }

    @Override
    public boolean deleteById(String id) throws Exception {
        Student student = findById(id);

        if(student == null){
            throw new IllegalArgumentException("Student Id does not exist!!\n" + "Please input again student Id\n");
        }

        if(personalRegisterServiceInterface.deletePerson(student)){
            System.out.println("Delete student into personal list successfully");
        }else{
            System.out.println("Delete student into personal list failed");
        }
        return students.remove(student);
    }
}
