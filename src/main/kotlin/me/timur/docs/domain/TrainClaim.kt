package me.timur.docs.domain

import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Table(name="train_claim")
@Entity
class TrainClaim : Claim() {

    @OneToMany
    var trains : List<Train>? = null
}
