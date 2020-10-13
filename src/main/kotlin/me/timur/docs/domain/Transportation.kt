package me.timur.docs.domain

import me.timur.docs.enums.ClaimDetailStatus
import java.sql.Timestamp
import javax.persistence.*

@Table(name="transportation")
@Entity
class Transportation : BaseLong(){
    @Column(name= "date")
    var date: Timestamp? = null

    @Column(name= "place")
    var direction: String = ""

    @Column(name= "program")
    var program: String = ""

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name="claim_id", nullable = false)
    var claim: TransportClaim? = null

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    var status: ClaimDetailStatus? = null

    @OneToOne
    @JoinColumn(name="guide_id")
    var guide: Guide? = null

    @Column(name= "comments")
    var comments: String = ""
}
