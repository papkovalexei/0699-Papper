package com.itmo.microservices.demo.checkout.impl.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class PickupEntity {

    @Id
    var id: Int? = null
    var address: String? = null

    constructor()

    constructor(id: Int?, address: String?) {
        this.id = id
        this.address = address
    }
}

class MockEntity {
    val allMockEntity: List<PickupEntity> = listOf(
        PickupEntity(1, "Address 1"),
        PickupEntity(2, "Address 2"),
        PickupEntity(3, "Address 3"),
        PickupEntity(4, "Address 4"),
        PickupEntity(5, "Address 5"),
        PickupEntity(6, "Address 6"),
        PickupEntity(7, "Address 7"),
        PickupEntity(8, "Address 8")
    )
}