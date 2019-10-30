package com.roohoo.SpringDatabase

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity(name = "user_and_id")
data class SiteUser(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val user_id: Int = 0,

        @get: NotBlank
        val userName: String = "",

        @get: NotBlank
        val interestingFact: String = "")
