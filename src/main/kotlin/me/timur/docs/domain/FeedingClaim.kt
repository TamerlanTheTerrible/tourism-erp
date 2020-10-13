package me.timur.docs.domain

import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Table(name="feeding_claim")
@Entity
class FeedingClaim : Claim(){

    @OneToMany
    var feedingList: List<Feeding>? = null
}
