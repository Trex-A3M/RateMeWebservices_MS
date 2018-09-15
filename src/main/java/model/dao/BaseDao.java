package model.dao;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseDao<T> {
    int save(T t);

    List<T> getAll();

    List<T> getListByPhrase(String colName, String phrase);

    void delete(T t);

    T getInstanceByField(String tableColName, String value);

    List<T> getListByField(String tableColName, String value);

    void update(T t);

    T getById(T t, int id);

}
