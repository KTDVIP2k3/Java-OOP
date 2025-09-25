package ServiceImplements;

import Model.Teacher;
import ServiceInterfaces.GenericServiceInterface;
import ServiceInterfaces.PersonalRegisterServiceInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherManagementServiceImplement implements GenericServiceInterface<Teacher> {
    private List<Teacher> teachers = new ArrayList<>();
    private PersonalRegisterServiceInterface personalRegisterServiceInterface;

    public TeacherManagementServiceImplement(PersonalRegisterServiceInterface personalRegisterServiceInterface){
        this.personalRegisterServiceInterface = personalRegisterServiceInterface;
    }
    @Override
    public List<Teacher> getAll() throws Exception {
        if(teachers == null){
            throw new IllegalArgumentException("Teacher list should not be null\n" +"Please init teacher list");
        }
        if(teachers.isEmpty()){
            throw new IllegalArgumentException("Teacher List is empty");
        }
        return teachers;
    }

    @Override
    public Teacher findById(String id) throws Exception {
        for(Teacher teacher : teachers){
            if(teacher.getTeacherID().equalsIgnoreCase(id)){
                return teacher;
            }
        }
        return null;
    }

    @Override
    public boolean add(Teacher item) throws Exception {
        if(item == null){
            throw new IllegalArgumentException("Teacher should not be null\n" + "Please init teacher object\n");
        }

        if(findById(item.getTeacherID()) != null){
            throw new IllegalArgumentException("Teacher Id does exist\n" + "Please input another teacherID\n");
        }
        if(item.getName().isBlank()){
            throw new IllegalArgumentException("Teacher name should not be blank\n" + "Please input teacher name\n");
        }

        if(personalRegisterServiceInterface.findPersonByIdentifiableNumber(item.getIdentifiableIdNumber())){
            throw new IllegalArgumentException("Teacher identifiable number existed\n" + "Please input another teacher identifiable number id\n");
        }
        if(item.getIdentifiableIdNumber().isBlank()){
            throw new IllegalArgumentException("Teacher identifiable number should not be blank\n" + "Please input identifiable number again\n");
        }
        if(item.getAge() < 22 || item.getAge() > 60){
            throw new IllegalArgumentException("Teacher age must be between 22 and 60\n" + "Please input teacher age again\n");
        }

        if(item.getBirthday().isBlank()){
            throw new IllegalArgumentException("Teacher birthday should not be blank\n" + "Please input birthday again\n");
        }

        if(item.getGender().isBlank()){
            throw new IllegalArgumentException("Gender should not be blank\n" + "Plesae input gender again\n");
        }

        if(item.getNationality().isBlank()){
            throw new IllegalArgumentException("Nationality should not be blank\n" + "Please input nationality again\n");
        }

        if(item.getDepartment().isBlank()){
            throw new IllegalArgumentException("Teacher department should not be blank\n" + "Please input department name");
        }

        if(item.getAddress().isBlank()){
            throw new IllegalArgumentException("Teacher address should not be blank\n" + "Please input teacher address\n");
        }

        if(item.getQualification().isBlank()){
            throw new IllegalArgumentException("Teacher qualification should not be blank\n" + "Please input teacher qualification (e.g., Thạc sĩ, Tiến sĩ)");
        }

        if(item.getEmploymentDate() == null){
            throw new IllegalArgumentException("Teacher employment date should not be null\n" + "Please input employment date");
        }
        if(item.getEmploymentDate().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Teacher employment date cannot be in the future\n" + "Please input a valid date");
        }
        if(item.getSalaryScale() <= 1.0 || item.getSalaryScale() > 10.0){
            throw new IllegalArgumentException("Teacher salary scale must be between 1.0 and 10.0\n" + "Please input a valid salary scale");
        }

        if( personalRegisterServiceInterface.addPerson(item)){
            System.out.println("Add teacher into personal list successfully");
        }else{
            System.out.println("Add teacher into personal list failed");
        }

        return teachers.add(item);


    }

    @Override
    public boolean updateById(Teacher item) throws Exception {
        if(item == null){
            throw new IllegalArgumentException("Teacher should not be null\n" + "Please init teacher object");
        }

        if(findById(item.getTeacherID()) == null){
            throw new IllegalArgumentException("Teacher Id does not exist\n" + "Please input again teacherID");
        }

        Teacher teacher = findById(item.getTeacherID());

        if(item.getAge() < 22 || item.getAge() > 60){
            throw new IllegalArgumentException("Teacher age must be between 22 and 60\n" + "Please input teacher age again\n");
        }

        if(item.getBirthday().isBlank()){
            throw new IllegalArgumentException("Teacher birthday should not be blank\n" + "Please input birthday again\n");
        }

        if(item.getGender().isBlank()){
            throw new IllegalArgumentException("Gender should not be blank\n" + "Plesae input gender again\n");
        }

        if(item.getNationality().isBlank()){
            throw new IllegalArgumentException("Nationality should not be blank\n" + "Please input nationality again\n");
        }

        if(item.getDepartment().isBlank()){
            throw new IllegalArgumentException("Teacher department should not be blank\n" + "Please input department name");
        }

        if(item.getQualification().isBlank()){
            throw new IllegalArgumentException("Teacher qualification should not be blank\n" + "Please input teacher qualification (e.g., Thạc sĩ, Tiến sĩ)");
        }

        if(item.getEmploymentDate() == null){
            throw new IllegalArgumentException("Teacher employment date should not be null\n" + "Please input employment date");
        }
        if(item.getEmploymentDate().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Teacher employment date cannot be in the future\n" + "Please input a valid date");
        }
        if(item.getSalaryScale() <= 1.0 || item.getSalaryScale() > 10.0){
            throw new IllegalArgumentException("Teacher salary scale must be between 1.0 and 10.0\n" + "Please input a valid salary scale");
        }
        if(item.getAddress().isBlank()){
            throw new IllegalArgumentException("Teacher address should not be blank\n" + "Please input teacher address\n");
        }



        teacher.setName(item.getName());
        teacher.setAddress(item.getAddress());
        teacher.setAge(item.getAge());
        teacher.setBirthday(item.getBirthday());
        teacher.setGender(item.getGender());
        teacher.setNationality(item.getNationality());
        teacher.setDepartment(item.getDepartment());
        teacher.setQualification(teacher.getQualification());
        teacher.setEmploymentDate(teacher.getEmploymentDate());
        teacher.setSalaryScale(item.getSalaryScale());

        for(int i = 0; i < teachers.size(); i++){
            if(teachers.get(i).getTeacherID().equalsIgnoreCase(item.getTeacherID())){
                teachers.set(i, teacher);
                personalRegisterServiceInterface.addPerson(item);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean deleteById(String id) throws Exception {
        if(findById(id) == null){
            throw new IllegalArgumentException("Teacher Id does not exist\n" + "Please input again teacherID");
        }
        return teachers.remove(findById(id));
    }

    public void show(){
        System.out.println("alo");
    }
}
