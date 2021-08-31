package com.mercadolivro.model

import com.mercadolivro.enums.CustomerStatus
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name= "customer")
data class CustomerModel (

    @Id
    @GeneratedValue()
    var id: Int?= null,

    @Column
    var name: String,

    @Column
    var email: String,

    @Column
    var status: CustomerStatus

)