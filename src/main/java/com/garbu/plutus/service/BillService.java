package com.garbu.plutus.service;

import com.garbu.plutus.dao.BillDao;
import com.garbu.plutus.model.Bill;
import com.garbu.plutus.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Service
public class BillService {

  private final BillDao billDao;

//  private static User testUser =
//          new User(UUID.randomUUID(), "John Doe", "something@gmail.com", "07123456789");

  private Map<UUID, Bill> billMap;

  @Autowired
  public BillService(@Qualifier("postgres") BillDao billDao) {
    this.billDao = billDao;
    this.billMap = BillDao.BILL_MAP;
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
