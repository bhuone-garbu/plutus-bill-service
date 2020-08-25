package com.garbu.plutus.dao;

import com.garbu.plutus.model.Bill;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository("postgres")
public class BillDao implements Dao<Bill> {

  public static final Map<UUID, Bill> BILL_MAP = new HashMap<>();

  static {
    UUID randomId = UUID.randomUUID();
    BILL_MAP.put(
            randomId,
        Bill.builder()
            .id(randomId)
            .amount(new BigDecimal("2.3"))
            .description("this is a test")
            .build());
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
  public Collection<Bill> getAll() {
    return BILL_MAP.values().stream().filter(Objects::nonNull).collect(Collectors.toUnmodifiableList());
    // return BILL_MAP.values();
  }

  @Override
  public Optional<Bill> getOne(UUID id) {
    return Optional.ofNullable(BILL_MAP.get(id));
  }
}
