package me.timur.docs.domain

import me.timur.docs.enums.UserRole
import java.util.*
import javax.persistence.*


@Table(name = "user_access")
@Entity
open class User : BaseLong() {

    @Column(name = "username")
    open var username: String = ""

    @Column(name = "password")
    open var password: String = ""

    // TODO make role enumerated
//    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    open var role: String = ""

    @Column(name = "email")
    var email: String = ""

    @Column(name = "is_active")
    var isActive: Boolean = true

//    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
     var employee: Employee? = null


    fun clone(other: User) {
        this.username = other.username
        this.password = other.password
        this.email = other.email
        this.role = other.role
        this.isActive = other.isActive
        this.employee = other.employee
    }

    open fun getRoleList(): String {
        return role.toString()
    }
//    open fun getPermissionList(): List<String?>? {
//        return if (this.roles.length > 0) {
//            Arrays.asList(*this.permissions.split(",".toRegex()).toTypedArray())
//        } else ArrayList()
//    }
}