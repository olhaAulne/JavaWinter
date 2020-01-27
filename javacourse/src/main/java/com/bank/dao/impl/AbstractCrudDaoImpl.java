package com.bank.dao.impl;

import com.bank.dao.ConnectorDB;
import com.bank.dao.CrudDao;
import com.bank.dao.DataBaseSqlRuntimeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public abstract class AbstractCrudDaoImpl<E> implements CrudDao<E> {
    private static final Logger LOGGER = LogManager.getLogger(AbstractCrudDaoImpl.class);
    protected final ConnectorDB connector;
    private final String findByIdQ;
    private final String findAllQ;
    private final String saveQ;
    private final String updateQ;
    private final String deleteQ;

    public AbstractCrudDaoImpl(ConnectorDB connector, String findByIdQ, String findAllQ, String saveQ, String updateQ, String deleteQ) {
        this.connector = connector;
        this.findByIdQ = findByIdQ;
        this.findAllQ = findAllQ;
        this.saveQ = saveQ;
        this.updateQ = updateQ;
        this.deleteQ = deleteQ;
    }

    protected abstract E mapResultSetToEntity(ResultSet resultSet) throws SQLException;
    protected abstract void prepareStatementForInsert(PreparedStatement statement, E entity) throws SQLException;
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, E entity) throws SQLException;

    @Override
    public void save(E entity) {
        try (final PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement(saveQ)) {
            prepareStatementForInsert(preparedStatement, entity);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            LOGGER.error(e.getMessage());
            throw new DataBaseSqlRuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<E> findById(Integer id) {
        try (final PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement(findByIdQ)) {
            preparedStatement.setInt(1, id);

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapResultSetToEntity(resultSet));
                }
            }

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DataBaseSqlRuntimeException(e.getMessage(), e);
        }

        return Optional.empty();
    }

    @Override
    public void update(E entity) {
        try (final PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement(updateQ)) {
            prepareStatementForUpdate(preparedStatement,entity);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            LOGGER.error(e.getMessage());
            throw new DataBaseSqlRuntimeException(e.getMessage(), e);
        }

    }

    @Override
    public void deleteById(Integer id) {
        Optional<E> entity = findById(id);
        if(entity.isPresent()){
            try (final PreparedStatement preparedStatement =
                         connector.getConnection().prepareStatement(deleteQ)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
            catch (SQLException e){
                LOGGER.error(e.getMessage());
                throw new DataBaseSqlRuntimeException(e.getMessage(), e);
            }

        }

    }


}
