package ServiceImplements;

import Model.Person;
import ServiceInterfaces.PersonalRegisterServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class PersonalRegisterServiceImplement implements PersonalRegisterServiceInterface {
    private final List<Person> personList = new ArrayList<>();

    @Override
    public List<Person> getAllPerson() {
        return personList;
    }

    @Override
    public boolean findPersonByIdentifiableNumber(String identifiableNumberID) throws Exception{
        for(Person person : personList){
            if(person.getIdentifiableIdNumber().equalsIgnoreCase(identifiableNumberID)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addPerson(Person person) throws Exception{
        personList.add(person);
        return true;
    }

    @Override
    public boolean updatePerson(Person person) throws Exception {
        for(int i = 0; i < personList.size(); i++){
            if(personList.get(i).getIdentifiableIdNumber().equalsIgnoreCase(person.getIdentifiableIdNumber())){
                personList.set(i, person);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deletePerson(Person person) {
        for(Person person1 : personList){
            if(person1.getIdentifiableIdNumber().equalsIgnoreCase(person.getIdentifiableIdNumber())){
                return personList.remove(person);
            }
        }
        return false;
    }
}
