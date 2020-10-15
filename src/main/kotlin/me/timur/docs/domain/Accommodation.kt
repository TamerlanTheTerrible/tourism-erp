package me.timur.docs.domain

import me.timur.docs.enums.ClaimDetailStatus
import java.sql.Timestamp
import javax.persistence.*
import kotlin.jvm.Transient

@Table(name="accommodation")
@Entity
class Accommodation : BaseLong(){

    @Column(name= "arrival")
    var arrival: Timestamp? = null

    @Column(name= "departure")
    var departure: Timestamp? = null

    @Transient
    var checkIn: String? = null

    @Transient
    var checkOut: String? = null

    @Transient
    var arrivalInString: String? =null

    @Transient
    var departureInString: String? =null

    @Column(name= "place")
    var place: String = ""

    @Column(name= "hotel")
    var hotel: String = ""

    //TODO change type
//    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @Column(name="rooms")
    var rooms: String? = null

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name="group_id", nullable = false)
    var group: Group? = null

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    var status: ClaimDetailStatus? = ClaimDetailStatus.CONFIRMED

    @Column(name= "comments")
    var comments: String = ""
}






