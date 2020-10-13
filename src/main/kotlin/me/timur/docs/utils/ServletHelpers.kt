package me.timur.docs.utils

import me.timur.docs.model.FilterRequest
import javax.servlet.http.HttpServletRequest

object ServletHelpers {
    fun generateFilterRequest(request: HttpServletRequest): FilterRequest {
        val result = FilterRequest()
        val filters = HashMap<String, String>()
        for (param in request.parameterNames){
            when (param) {
                "page" -> result.pagination.page = request.getParameter(param).toInt()
                "per_page" -> result.pagination.per_page = request.getParameter(param).toInt()
                else -> filters[param] = request.getParameter(param)
            }
        }

        return result
    }
}