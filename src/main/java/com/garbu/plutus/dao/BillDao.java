package com.garbu.plutus.dao;

import com.garbu.plutus.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class BillDao implements Dao<Bill> {

  public static final String GET_QUERY =
      "SELECT b.id, b.description, b.amount, b.paid_by_user, b.is_deleted, b.is_paid FROM Bill b";

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

  @Override
  public List<Bill> getAll() {
    return jdbcTemplate.query(
        GET_QUERY,
        (resultSet, i) ->
            new Bill(
                resultSet.getString("id"),
                resultSet.getString("description"),
                new BigDecimal(resultSet.getString("amount")),
                // resultSet.getString("b.paid_by_user"),
                null,
                resultSet.getBoolean("is_paid"),
                resultSet.getBoolean("is_deleted"),
                null,
                null));
  }

  @Override
  public Optional<Bill> getOne(UUID id) {
    final String sql = GET_QUERY + " where b.id = ?";
    Bill bill =
        jdbcTemplate.queryForObject(
            sql,
            new Object[] {id},
            (resultSet, i) ->
                new Bill(
                    resultSet.getString("id"),
                    resultSet.getString("description"),
                    new BigDecimal(resultSet.getString("amount")),
                    // resultSet.getString("b.paid_by_user"),
                    null,
                    resultSet.getBoolean("is_paid"),
                    resultSet.getBoolean("is_deleted"),
                    null,
                    null));

    return Optional.ofNullable(bill);
  }
}
