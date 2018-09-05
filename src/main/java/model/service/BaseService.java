package model.service;

import java.util.List;

public interface BaseService<T> {
    void saveEntity(T t);

    List<T> getAll();

    void deleteEntity(T t);

    T getInstanceByField(String colName, String value);

    List<T> getListByField(String colName, String value);

    T getEntityById(T t, int id);
}
