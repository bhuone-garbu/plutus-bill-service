package com.garbu.plutus.api;

import com.garbu.plutus.model.Bill;
import com.garbu.plutus.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class BillController {

  private static List<Bill> bills = new ArrayList<>();
  private static User testUser =
      new User(UUID.randomUUID(), "John Doe", "something@gmail.com", "07123456789");

  static {
    Bill bill =
        Bill.builder()
            .id(UUID.randomUUID())
            .amount(new BigDecimal("2.3"))
            .description("this is a test")
            .paidByUser(testUser)
            .build();
    bills.add(bill);
  }

  @GetMapping("/expenses")
  public List<Bill> getAll(@RequestParam(value = "amount", required = false) String amount) {
    return bills;
  }

  @GetMapping("expenses/{id}")
  public Bill getOne(@PathVariable String id) {
    // TODO: Service method to get an expense from the id
    return bills.get(0);
  }
}
