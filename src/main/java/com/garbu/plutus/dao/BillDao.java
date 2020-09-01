package com.garbu.plutus.dao;

import com.garbu.plutus.model.User;
import com.garbu.plutus.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/***
 * Queries are intentionally written in SQL as opposed to using ORMs for better understanding.
 * Will migrate to ORM when deemed necessary.
 */
@Repository("postgres")
public class BillDao implements Dao<Bill> {

  public static final String GET_QUERY =
      "SELECT b.id as billId, b.description, b.amount, b.created_by_user, b.paid_by_user, b.is_deleted, b.is_paid, " +
          "a.id as userId, a.mobile_no, a.username, a.email FROM bill b JOIN app_User a ON b.paid_by_user=a.id";

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public BillDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public boolean save(Bill bill) {
    return true;
  }

  @Override
  public void update(Bill bill) {}

  @Override
  public void delete(Bill bill) {}

  /**
   * Reusable query ResultSet parser when SELECT'ing Bill entity.
   *
   * @param resultSet result set data from query
   * @return a new Bill object
   * @throws SQLException exception thrown when query cannot be parsed
   */
  private static Bill parseBillQueryResultSet(final ResultSet resultSet) throws SQLException {
    return new Bill(
        resultSet.getString("billId"),
        resultSet.getString("description"),
        new BigDecimal(resultSet.getString("amount")),
        new User(
            resultSet.getString("userId"),
            resultSet.getString("username"),
            resultSet.getString("email"),
            resultSet.getString("mobile_no")),
        resultSet.getBoolean("is_paid"),
        resultSet.getBoolean("is_deleted"),
        null,
        null);
  }

  @Override
  public List<Bill> getAll() {
    return jdbcTemplate.query(
        GET_QUERY, (resultSet, i) -> BillDao.parseBillQueryResultSet(resultSet));
  }

  @Override
  public Optional<Bill> getOne(UUID id) {
    final String sql = GET_QUERY + " where b.id = ?";
    Bill bill =
        jdbcTemplate.queryForObject(
            sql, new Object[] {id}, (resultSet, i) -> BillDao.parseBillQueryResultSet(resultSet));

    return Optional.ofNullable(bill);
  }
}
