//package me.timur.docs.domain
//
//import me.timur.docs.enums.RoomType
//import javax.persistence.*
//
//@Table(name="room_type")
//@Entity
//class Room : BaseLong(){
//
//    @Enumerated(EnumType.STRING)
//    @Column(name="type")
//    var type: RoomType = RoomType.TWIN
//
//    @Column(name="pax")
//    var pax: Short = 0
//
//    @Column(name="early_check_in")
//    var earlyCheckIn: Boolean = false
//
//    @Column(name="late_check_out")
//    var lateCheckOut: Boolean = false
//
//    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
//    @JoinColumn(name="accommodation_id", nullable = false)
//    var accommodation: Accommodation? = null
//
//    @Column(name="comments")
//    var comments: String = ""
//}