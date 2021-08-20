package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.request.PostCustomerRequest
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
class CustomerService {

    val customers= mutableListOf<CustomerModel>()

    @GetMapping
    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun create(customer: PostCustomerRequest) {
        var id= if (customers.isEmpty()){
            1
        } else {
            customers.last().id!!.toInt()+1
        }
        customers.add(CustomerModel(id, customer.name, customer.email))
    }

    fun getCustomer(id: Int): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    fun update(customer: CustomerModel) {
        customers.filter { it.id == customer.id }.first().let {
            it.name= customer.name
            it.email= customer.email
        }
    }

    fun delete(id: Int) {
        customers.removeIf { it.id== id }
    }
}