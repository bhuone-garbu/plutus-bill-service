package com.garbu.plutus.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// generic Dao
public interface Dao<P> {

  // basic CRUD operation
  boolean save(P p);
  void update(P p);
  void delete(P p);

  // Retrieve operation
  List<P> getAll();
  Optional<P> getOne(UUID id);
}
