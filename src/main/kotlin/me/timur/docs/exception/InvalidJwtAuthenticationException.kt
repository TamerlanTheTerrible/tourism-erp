package me.timur.docs.exception

import javax.naming.AuthenticationException

class InvalidJwtAuthenticationException(e: String?) : AuthenticationException(e)