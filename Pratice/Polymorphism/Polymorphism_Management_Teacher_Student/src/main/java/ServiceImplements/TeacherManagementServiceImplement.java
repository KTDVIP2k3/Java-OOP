package ServiceImplements;

import Model.Teacher;
import ServiceInterfaces.GenericServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class TeacherManagementServiceImplement implements GenericServiceInterface<Teacher> {
    private List<Teacher> teachers = new ArrayList<>();
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
        throw new IllegalArgumentException("Can not find teacher with this id: " + id);
    }

    @Override
    public boolean add(Teacher item) throws Exception {
        if(item == null){
            throw new IllegalArgumentException("Teacher should not be null\n" + "Please init teacher object");
        }

        if(findById(item.getTeacherID()) != null){
            throw new IllegalArgumentException("Teacher Id does exist\n" + "Please input another teacherID");
        }
        if(item.getName().isBlank()){
            throw new IllegalArgumentException("Teacher nem should not be blank\n" + "Please input teacher name");
        }

        if(item.getIdentifiableIdNumber().isBlank()){
            throw new IllegalArgumentException("Teacher identifiable number should not be blank\n" + "Please input identifiable number again");
        }

        if(item.getAge() <= 0){
            throw new IllegalArgumentException("Teacher age should not be under 0 (<=0)\n" + "Please input teacher again");
        }
        return false;
    }

    @Override
    public boolean updateById(Teacher item) throws Exception {
        return false;
    }

    @Override
    public boolean deleteById(String id) throws Exception {
        return false;
    }
}
