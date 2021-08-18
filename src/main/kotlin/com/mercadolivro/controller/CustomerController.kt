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
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
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

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody customer: PostCustomerRequest) {
        customers.filter { it.id == id }.first().let {
            it.name= customer.name
            it.email= customer.email
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        customers.removeIf { it.id== id }
    }
}