package com.bank.dao.impl;

import com.bank.dao.ConnectorDB;
import com.bank.dao.UserDao;
import com.bank.dao.exception.DataBaseSqlRuntimeException;
import com.bank.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractCrudDaoImpl<User> implements UserDao {

    private static final String FIND_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM users WHERE id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM users";
    private static final String SAVE_QUERY = "INSERT INTO users (id, email, password) values(?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE users SET email = ?, password = ? WHERE id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM users WHERE id = ?";
    private static final Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);


    public UserDaoImpl(ConnectorDB connector) {
        super(connector, FIND_BY_ID_QUERY, FIND_ALL_QUERY, SAVE_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return findByParam(email, FIND_BY_EMAIL_QUERY, STRING_PARAM_SETTER);
    }


    @Override
    public List<User> findAll(int page, int itemPerPage) {
        try (final PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement(FIND_ALL_QUERY)) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                List<User> users = new ArrayList<>();
                while (resultSet.next()) {
                    final User optionalUser = mapResultSetToEntity(resultSet);
                    users.add(optionalUser);
                }
                return users;
            }

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DataBaseSqlRuntimeException(e.getMessage(), e);
        }
    }


    protected User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .withId(resultSet.getInt("id"))
                .withEmail(resultSet.getString("email"))
                .withPassword(resultSet.getString("password"))
                .withTelephoneNumber(resultSet.getString("phone_number"))
                .build();
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User entity) throws SQLException {
        statement.setInt(1, entity.getId());
        statement.setString(2, entity.getEmail());
        statement.setString(3, entity.getPassword());
        statement.setString(4, entity.getTelephoneNumber());

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User entity) throws SQLException {
        statement.setInt(1, entity.getId());
        statement.setString(2, entity.getEmail());
        statement.setString(3, entity.getPassword());
        statement.setString(4, entity.getTelephoneNumber());
    }

    @Override
    public long count() {
        return 0;
    }
}

