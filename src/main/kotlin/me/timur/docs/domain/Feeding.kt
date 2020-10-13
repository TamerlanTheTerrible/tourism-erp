package me.timur.docs.domain

import me.timur.docs.enums.ClaimDetailStatus
import java.sql.Timestamp
import javax.persistence.*

@Table(name = "feeding")
@Entity
class Feeding : BaseLong(){

    @Column(name= "date")
    var date: Timestamp? = null

    @Column(name= "place")
    var place: String = ""

    @Column(name= "restaurant")
    var restaurant: String = ""

    @Column(name="pax")
    var pax: Int? = null

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name="claim_id", nullable = false)
    var claim: FeedingClaim? = null

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    var status: ClaimDetailStatus? = null

    @Column(name= "comments")
    var comments: String = ""

}