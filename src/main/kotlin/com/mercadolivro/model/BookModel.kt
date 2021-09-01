package com.mercadolivro.model

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.Errors
import com.mercadolivro.exception.BadRequestException
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

    @ManyToOne
    @JoinColumn(name= "customer_id")
    var customer: CustomerModel?= null

) {

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus?= null
        set(value) {
            if (field == BookStatus.DELETADO || field== BookStatus.CANCELADO){
                throw BadRequestException (Errors.ML1002.message.format(field), Errors.ML1002.code)
            }
            field= value
        }

    constructor(id: Int?= null,
                name: String,
                price: BigDecimal,
                customer: CustomerModel?= null,
                status: BookStatus?): this(id, name, price, customer) {
        this.status= status
                }

}