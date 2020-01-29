package com.bank.dao.impl;

import com.bank.dao.ConnectorDB;
import com.bank.entity.Account;
import com.bank.dao.AccountDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AccountDaoImpl extends AbstractCrudDaoImpl<Account> implements AccountDao {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM accounts WHERE id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM accounts";
    private static final String SAVE_QUERY = "INSERT INTO accounts (user, money) values(?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE accounts SET user = ?, money = ? WHERE id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM accounts WHERE id = ?";
    private static final Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);


    public AccountDaoImpl(ConnectorDB connector) {
        super(connector, FIND_BY_ID_QUERY, FIND_ALL_QUERY, SAVE_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }


    @Override
    public List<Account> findAll(int page, int itemsPerPage) {
        return Collections.emptyList();
    }




    protected Account mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Account(resultSet.getInt("id"), null, resultSet.getInt("id"));

    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Account entity) throws SQLException {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Account entity) throws SQLException {

    }

    @Override
    public long count() {
        return 0;
    }
}
