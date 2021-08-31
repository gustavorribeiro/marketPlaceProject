package com.mercadolivro.controller.response

import com.mercadolivro.enums.CustomerStatus
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id

data class CustomerResponse (

    var id: Int?= null,

    var name: String,

    var email: String,

    var status: CustomerStatus

)
