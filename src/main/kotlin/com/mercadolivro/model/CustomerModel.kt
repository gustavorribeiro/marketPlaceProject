package com.mercadolivro.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name= "customer")
data class CustomerModel (

    @Id
    @GeneratedValue()
    var id: Int?= null,

    var name: String,

    var email: String

)