package me.timur.docs.domain

import me.timur.docs.enums.Lang
import java.sql.Timestamp
import javax.persistence.*

@Table(name="guide")
@Entity
class Guide : BaseLong() {

    @Column(name="first_name")
    var firstName: String = ""

    @Column(name="last_name")
    var lastName: String = ""

    @Column(name="working_since")
    var workingSince: Timestamp? = null

    //TODO make list of languages
    @Column(name="languages")
    var languages: String? = null

    //TODO make list of languages
    @Column(name="phone_numbers")
    var phoneNumbers: String? = null
}