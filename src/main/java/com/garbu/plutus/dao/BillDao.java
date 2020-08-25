package com.garbu.plutus.dao;

import com.garbu.plutus.model.Bill;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class BillDao implements Dao<Bill> {

  public static final Map<UUID, Bill> BILL_MAP = new HashMap<>();

  @Override
  public boolean save(Bill bill) {
    UUID randomId = UUID.randomUUID();
    BILL_MAP.put(
        randomId,
        Bill.builder()
            .id(UUID.randomUUID())
            .amount(new BigDecimal("2.3"))
            .description("this is a test")
            .build());
    return true;
  }

  @Override
  public void update(Bill bill) {}

  @Override
  public void delete(Bill bill) {}

  @Override
  public Collection<Bill> getAll() {
    return BILL_MAP.values().stream().filter(Objects::nonNull).collect(Collectors.toUnmodifiableList());
  }

  @Override
  public Optional<Bill> getOne(UUID id) {
    return Optional.ofNullable(BILL_MAP.get(id));
  }
}
