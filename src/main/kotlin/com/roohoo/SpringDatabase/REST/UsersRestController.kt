package com.roohoo.SpringDatabase.REST

import com.roohoo.SpringDatabase.SiteUser
import com.roohoo.SpringDatabase.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersRestController(private val userRepository: UserRepository) {

    @GetMapping("/users")
    fun getAllUsers(): MutableIterable<SiteUser> {
        return userRepository.findAll()
    }
}