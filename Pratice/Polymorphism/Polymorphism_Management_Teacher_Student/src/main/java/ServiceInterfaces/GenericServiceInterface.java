package ServiceInterfaces;

import java.util.List;

public interface GenericServiceInterface<T> {
    public List<T> getAll() throws Exception;
    public T findById(String id) throws Exception;
    public boolean add(T item) throws Exception;
    public boolean updateById(T item) throws Exception;
    public boolean deleteById(String id) throws Exception;
}
