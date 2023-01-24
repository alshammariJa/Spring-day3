package com.example.demo.controller;

import com.example.demo.Pojo.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequestMapping("/api/v1")
@RestController
public class Controller_ {

    ArrayList <Customers> customersArray = new ArrayList<>();
    @GetMapping("/customers")
    public  ArrayList <Customers> getCustomersArray(){
        return customersArray;

    }
    @PostMapping("/add")
    public String addCustomers(@RequestBody  Customers customers ){
        customersArray.add(customers);
        return "add done";

    }

     @PostMapping("/update/{index}")
      public String updateCustomers(@PathVariable int index, Customers customers)   {
          customersArray.set(index,customers);
          return "update done";

      }

@DeleteMapping("delete/{index}")
    public String deleteCustomers(@PathVariable int index, Customers customers){
    customersArray.remove(index);
    return " delete done";


}
    @PutMapping("/deposite/{index}")
    public int deposite(@PathVariable int index,@RequestBody Customers customer){
        int newBalance=700;
        newBalance+=customer.getBalance();
        customer.setBalance(newBalance);
        customersArray.set(index,customer);
        return newBalance;
    }

    @PutMapping("/withdraw/{index}")
    public int withdraw(@PathVariable int index,@RequestBody Customers customer){
        int withdraw=200;
        int newBalance;

        if (customer.getBalance()<=withdraw)
            System.out.println("your balance error");

        newBalance=customer.getBalance()-withdraw;
        customer.setBalance(newBalance);

        customersArray.set(index,customer);
        return newBalance;


    }

}
