package me.timur.docs.domain

import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Table(name="transport_claim")
@Entity
class TransportClaim : Claim() {

    @OneToMany
    var transportList: List<Transportation>? = null
}