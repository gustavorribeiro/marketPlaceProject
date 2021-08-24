package com.mercadolivro.model

import com.mercadolivro.enums.BookStatus
import java.math.BigDecimal
import java.text.DecimalFormat
import javax.persistence.*

@Entity(name= "book")
data class BookModel (

    @Id
    @GeneratedValue()
    var id: Int?= null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus?= null,

    @ManyToOne
    @JoinColumn(name= "customer_id")
    var customer: CustomerModel?= null

)