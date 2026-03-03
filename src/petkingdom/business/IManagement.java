package petkingdom.business;

public interface IManagement<T> {
    boolean add(T item);

    T findById(String id);

}
