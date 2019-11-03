//package com.roohoo.SpringDatabase
//
//
//import org.hibernate.SessionFactory
//import org.hibernate.annotations.FetchMode
//import org.hibernate.annotations.FetchProfile
//import org.hibernate.annotations.FetchProfiles
//import org.hibernate.criterion.Restrictions
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.SpringApplication
//import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//import org.springframework.security.core.GrantedAuthority
//import org.springframework.security.core.authority.SimpleGrantedAuthority
//import org.springframework.security.core.userdetails.User
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
//import org.springframework.stereotype.Controller
//import org.springframework.stereotype.Repository
//import org.springframework.stereotype.Service
//import org.springframework.ui.Model
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RequestMethod
//import javax.persistence.*
//import javax.transaction.Transactional
//
//@Transactional //Have Spring Manage Database Transactions
//@Service //Mark this class as a Service layer class
//class UserService(@Autowired private val userRepository: UserRepository) //Inject UserRepository into this class
//    : UserDetailsService { //To work with Spring Security, it needs to implement UserDetailsService
//
//    //Load a user by user name and call our SiteUser.toUser() method
//    override fun loadUserByUsername(userName: String): UserDetails  = userRepository.loadByUsername(userName).toUser()
//
//    //Saves a new user into the datastore
//    fun saveOrUpdate(user : SiteUser){
//        //Encrypt their password first
//        user.password = BCryptPasswordEncoder().encode(user.password)
//
//        //Then save the user
//        userRepository.saveOrUpdate(user)
//    }
//
//    //Return all users
//    fun allUsers() = userRepository.allUsers()
//}