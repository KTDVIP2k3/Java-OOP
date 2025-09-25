package ServiceImplements;

import Model.Person;
import ServiceInterfaces.PersonalRegisterServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class PersonalRegisterServiceImplement implements PersonalRegisterServiceInterface {
    private final List<Person> personList = new ArrayList<>();

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
}
