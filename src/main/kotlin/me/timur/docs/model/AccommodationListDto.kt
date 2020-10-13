package me.timur.docs.model

import me.timur.docs.domain.Accommodation

class AccommodationListDto() {

    val accommodationList = ArrayList<Accommodation>()
    var sgl: Int = 0
    var dbl: Int = 0
    var twn: Int = 0
    var trpl: Int = 0
    var other: Int = 0
    var otherName: String? = ""

//    constructor(size: Int) {
//        for (i in 1..size)
//        addAccommodation(Accommodation())
//    }

    fun addAccommodation(accommodation: Accommodation) {
        accommodationList.add(accommodation)
    }

}