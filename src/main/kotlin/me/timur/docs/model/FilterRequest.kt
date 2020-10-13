package me.timur.docs.model

import org.springframework.data.domain.PageRequest
import java.io.Serializable


open class FilterRequest : Serializable{
    var filter: HashMap<String, String> = HashMap()
    var pagination: Pagination = Pagination()

    val pageable: PageRequest
        get() {
            return PageRequest.of(this.pagination.page, this.pagination.per_page)
        }
}

open class Pagination : Serializable {
    var page: Int = 0
    var per_page: Int = 25
}