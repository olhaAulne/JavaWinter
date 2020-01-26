package com.taxi.dao.impl;

import com.taxi.dao.AccountDao;
import com.taxi.dao.ConnectorDB;
import com.taxi.domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class AccountDaoImpl extends AbstractCrudDaoImpl<Account> implements AccountDao {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM accounts WHERE id=?";

    public AccountDaoImpl(ConnectorDB connector) {
        super(connector, FIND_BY_ID_QUERY);
    }

    @Override
    public void save(Account entity) {

    }

    @Override
    public List<Account> findAll(int page, int itemsPerPage) {
        return Collections.emptyList();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void update(Account entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    protected Account mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Account(resultSet.getInt("id"), null, resultSet.getInt("id"));

    }
}
