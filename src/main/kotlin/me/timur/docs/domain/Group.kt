package me.timur.docs.domain

import me.timur.docs.enums.Country
import me.timur.docs.enums.GroupStatus
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.*
import kotlin.jvm.Transient

@Table(name="groups")
@Entity
class Group : BaseLong() {

    @Column(name = "group_number")
    var groupNumber : String = ""

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="company_id", referencedColumnName = "id")
    //TODO change type to Company
    @Column(name="company")
    var company : String? = null

    @Column(name="country")
    var country : String? = null

    @Column(name="pax")
    var pax : Short = 0

    @Column(name="arrival")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var arrival : Date? = null

    @Transient
    var arrivalInString: String? = null

    @Transient
    var dateCreatedInString: String? = null

    @ManyToOne
    @JoinColumn(name="tour_operator_id", referencedColumnName = "id")
    var tourOperator : User? = null


    //TODO change type to Company
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name="guides")
    @Column(name="guides")
    var guides : String? = null

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    var status : GroupStatus = GroupStatus.BOOKED

    @Column(name="comments")
    var comments : String = ""

    @Column(name="is_active")
    var isActive: Boolean = true

    fun getMonth(date: Date?): Int{
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar.get(Calendar.MONTH)
    }
}