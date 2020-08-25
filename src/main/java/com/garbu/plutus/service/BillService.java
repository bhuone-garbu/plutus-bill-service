package com.garbu.plutus.service;

import com.garbu.plutus.dao.BillDao;
import com.garbu.plutus.model.Bill;

public class BillService {

  private final BillDao billDao;

  public BillService(BillDao billDao) {
    this.billDao = billDao;
  }

  public boolean saveBill(Bill bill) {
    return billDao.save(bill);
  }
}
