package ServiceInterfaces;

import Model.Person;

import java.util.List;

public interface PersonalRegisterServiceInterface {
    public List<Person> getAllPerson();

    public boolean findPersonByIdentifiableNumber(String identifiableNumberID) throws Exception;

    public boolean addPerson(Person person) throws Exception;

    public boolean updatePerson(Person person) throws  Exception;

    public boolean deletePerson(Person person);
}
