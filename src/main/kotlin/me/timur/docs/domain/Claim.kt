package me.timur.docs.domain

import me.timur.docs.enums.ClaimStatus
import javax.persistence.*

open class Claim: BaseLong(){

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name="group_id")
    var group : Group? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status: ClaimStatus = ClaimStatus.SENT

    @Column(name = "comments")
    var comments: String = ""
}