package com.taxi.dao;

import com.taxi.dao.impl.Pageable;

import java.util.List;

public interface CrudPageableDao<E> extends CrudDao<E> {

    List<E> findAll(int page, int itemsPerPage);

    default Pageable<E> findAll(Page page){
        return null;
    }

    long count();
}
