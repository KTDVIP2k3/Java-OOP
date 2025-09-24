package ServiceImplements;

import ServiceInterfaces.GenericServiceInterface;
import ServiceInterfaces.Identifiable;

import java.util.ArrayList;
import java.util.List;

public class GenericServiceImplement <T extends Identifiable> implements GenericServiceInterface<T> {
    protected List<T> list = new ArrayList<>();


    @Override
    public List<T> getAll() throws Exception{
        return list;
    }

    @Override
    public T findById(String id) throws Exception{
        for(T item : list){
            if(item.getId().equalsIgnoreCase(id)){
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean add(T object) throws Exception{
        list.add(object);
        return true;
    }

    @Override
    public boolean update(T object) throws Exception{
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId().equalsIgnoreCase(object.getId())){
                list.set(i,object);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) throws Exception{
        for(T item : list){
            if(item.getId().equalsIgnoreCase(id)){
                list.remove(item);
                return true;
            }
        }
        return false;
    }
}