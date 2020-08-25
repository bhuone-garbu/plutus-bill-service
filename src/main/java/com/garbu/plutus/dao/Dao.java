package com.garbu.plutus.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

// generic Dao
public interface Dao<T> {

  // CRUD operation
  boolean save(T t);
  void update(T t);
  void delete(T t);

  // Retrieve operation
  Collection<T> getAll();
  Optional<T> getOne(UUID id);
}
