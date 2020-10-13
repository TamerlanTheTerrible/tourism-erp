package me.timur.docs.domain

import me.timur.docs.enums.CompanyStatus
import javax.persistence.*

@Table(name="company")
@Entity
class Company : BaseLong(){

    @Column(name="name")
    var name : String = ""

    @Column(name="country")
    var country : String = ""

    @OneToOne
    @JoinColumn(name="tour_operator_id")
    var tourOperator : User? = null

    @Column(name="partnership_status")
    var partnershipStatus : CompanyStatus = CompanyStatus.POTENTIAL_PARTNER
}