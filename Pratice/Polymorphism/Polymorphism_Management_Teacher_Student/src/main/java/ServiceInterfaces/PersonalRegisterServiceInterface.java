package ServiceInterfaces;

import Model.Person;

public interface PersonalRegisterServiceInterface {
    public boolean findPersonByIdentifiableNumber(String identifiableNumberID) throws Exception;

    public boolean addPerson(Person person) throws Exception;

    public boolean updatePerson(Person person) throws  Exception;

    public boolean deletePerson(Person person);
}
