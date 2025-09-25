package ServiceImplements;

import ServiceInterfaces.GenericServiceInterface;
import ServiceInterfaces.IDServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class GenericServiceImplement<T extends IDServiceInterface> implements GenericServiceInterface<T> {
    private List<T> tList = new ArrayList<>();
    @Override
    public List<T> getAll() throws Exception{
        return tList;
    }

    @Override
    public T findById(String id) throws Exception{
        for(T item : tList){
            if(item.getId().equalsIgnoreCase(id)){
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean add(T item) throws Exception{
        tList.add(item);
        return true;
    }

    @Override
    public boolean updateById(T item) throws Exception{
        for(int i = 0; i < tList.size(); i++){
            if(tList.get(i).getId().equalsIgnoreCase(item.getId())){
                tList.set(i,item);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        for(int i = 0; i < tList.size(); i++){
            if(tList.get(i).getId().equalsIgnoreCase(id)){
                tList.remove(i);
                return true;
            }
        }
        return false;
    }
}
