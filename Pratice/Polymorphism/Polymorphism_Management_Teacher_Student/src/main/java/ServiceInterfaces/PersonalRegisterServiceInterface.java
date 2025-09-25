package ServiceInterfaces;

import Model.Person;

public interface PersonalRegisterServiceInterface {
    public boolean findPersonByIdentifiableNumber(String identifiableNumberID) throws Exception;

    public boolean addPerson(Person person) throws Exception;
}
