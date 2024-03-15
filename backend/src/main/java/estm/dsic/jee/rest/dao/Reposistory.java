package estm.dsic.jee.rest.dao;

import java.util.List;


public interface Reposistory<T,I> {
  

    T create(T entity); 
    void delete(T entity);
    T find(T entity);
    List<T> getAll(int id);
    void update(T entity);


}
