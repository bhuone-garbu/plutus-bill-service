package com.garbu.plutus.service;

import com.garbu.plutus.dao.BillDao;
import com.garbu.plutus.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class BillService {

  private final BillDao billDao;

  @Autowired
  public BillService(@Qualifier("postgres") BillDao billDao) {
    this.billDao = billDao;
  }

  public boolean saveBill(Bill bill) {
    return billDao.save(bill);
  }

  public Bill getBill(UUID id) {
    return billDao.getOne(id).orElse(null);
  }

  public Collection<Bill> getAllBills() {
    return billDao.getAll();
  }
}
