package me.timur.docs.domain

import org.hibernate.annotations.Type
import java.time.LocalDate
import javax.persistence.*

@Table(name = "employee")
@Entity
class Employee : BaseLong() {

//    @OneToOne(mappedBy = "employee")
//    var user: User? = null

    @Column(name = "first_name")
    var firstName: String? = null

    @Column(name = "last_name")
    var lastName: String? = null

    @Column(name = "intials")
    var initials: String = ""

    @Column(name = "phone")
    var phone: String = ""

    //TODO other colums
//    @Column(name = "middle_name")
//    var middleName: String = ""

//    @Column(name = "dob")
//    @Convert(converter = LocalDateAttributeConverter::class)
//    var dob: LocalDate = LocalDate.now()
//
//    @Column(name = "photo_url")
//    var photo: String = ""
//
//    @ManyToOne
//    @JoinColumn(name = "employment_status_id")
//    var employmentStatus: EmploymentStatus? = null
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "gender")
//    var gender: EmpGender = EmpGender.MALE
//
//    @Type(type = "jsonb")
//    @Column(name = "passport_json", columnDefinition = "jsonb")
//    var passport: PassportJson? = null
//
//    @Type(type = "jsonb")
//    @Column(name = "contacts_json", columnDefinition = "jsonb")
//    var contacts: List<ContactJson> = ArrayList()
//
//    @Type(type = "jsonb")
//    @Column(name = "family_json", columnDefinition = "jsonb")
//    var familyMembers: List<FamilyMemberJson> = ArrayList()
//
//    @Type(type = "jsonb")
//    @Column(name = "education_history_json", columnDefinition = "jsonb")
//    var educationHistory: List<EducationHistoryJson> = ArrayList()
//
//
//    @ManyToOne
//    @JoinColumn(name = "education_type_id")
//    var educationType: EducationType? = null
//
//    @ManyToOne
//    @JoinColumn(name = "salary_category_id")
//    var salaryCategory: SalaryCategory? = null
//
//    @ManyToOne
//    @JoinColumn(name = "marital_status_id")
//    var maritalStatus: MaritalStatus? = null
//
//    @ManyToOne
//    @JoinColumn(name = "military_rank_id")
//    var militaryRank: MilitaryRank? = null
//
//    @ManyToOne
//    @JoinColumn(name = "political_part_id")
//    var politicalParty: PoliticalParty? = null
//
//
//
//    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
//    val positions: Set<EmployeePosition> = LinkedHashSet()

}