package com.mercadolivro.controller

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.request.PostCustomerRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController {
    val customers= mutableListOf<CustomerModel>()

    @GetMapping
    fun getCustomer(): MutableList<CustomerModel> {
        return customers
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        var id= if (customers.isEmpty()){
            1
        } else {
            customers.last().id.toInt()+1
        }.toString()
        customers.add(CustomerModel(id, customer.name, customer.email))
    }

}