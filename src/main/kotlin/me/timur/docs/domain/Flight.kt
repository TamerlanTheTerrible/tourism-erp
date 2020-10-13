package me.timur.docs.domain

import me.timur.docs.enums.ClaimDetailStatus
import me.timur.docs.enums.FlightClass
import java.sql.Timestamp
import javax.persistence.*

@Table(name="flight")
@Entity
class Flight : BaseLong(){

    @Column(name="date")
    var date: Timestamp? = null

    @Column(name="flight_detail")
    var flightDetail: String = ""

    @Column(name="direction")
    var direction: String = ""

    @Enumerated(EnumType.STRING)
    @Column(name="flight_class")
    var flightClass: FlightClass = FlightClass.ECONOMY

    @Column(name="pax")
    var pax: Short? = 1

    @Column(name="to_include_guide")
    var toIncludeGuide: Boolean = true

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name="claim_id", nullable = false)
    var claim: FlightClaim? = null

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    var status: ClaimDetailStatus? = null

    @Column(name= "comments")
    var comments: String = ""
}
