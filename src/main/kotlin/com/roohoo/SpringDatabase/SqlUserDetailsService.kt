package com.roohoo.SpringDatabase

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

import java.util.Arrays

@Component
class SqlUserDetailsService : UserDetailsService {
    @Autowired
    private val repository: UserRepository? = null

    val logger = LoggerFactory.getLogger(SecurityConfig::class.java)!!

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = repository!!.findByUserName(username) ?: throw UsernameNotFoundException("User not found")

        val authorities = Arrays.asList(SimpleGrantedAuthority("admin"),SimpleGrantedAuthority("user"))
        logger.debug(user.toString())
        val userSpring = User(user.userName, user.password, authorities)
        logger.debug(userSpring.toString())
        return userSpring
    }
}