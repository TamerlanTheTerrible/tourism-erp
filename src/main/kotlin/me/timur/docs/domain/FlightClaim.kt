package me.timur.docs.domain

import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Table(name="flight_claim")
@Entity
class FlightClaim : Claim() {

    @OneToMany
    var flights : List<Flight>? = null
}