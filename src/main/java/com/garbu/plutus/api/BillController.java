package com.garbu.plutus.api;

import com.garbu.plutus.model.Bill;
import com.garbu.plutus.model.User;
import com.garbu.plutus.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/expenses")
@RestController
public class BillController {

  private BillService service;

  @Autowired
  public BillController(BillService service) {
    this.service = service;
  }

  @GetMapping
  public Collection<Bill> getAll(@RequestParam(value = "amount", required = false) String amount) {
    return service.getAllBills();
  }

  @GetMapping(path = "/{id}")
  public Bill getOne(@PathVariable UUID id) {
    // TODO: Service method to get an expense from the id
    return service.getBill(id);
  }

  @PostMapping("expenses")
  public void addBill(@RequestBody Bill bill){

  }
}
