package com.roohoo.SpringDatabase

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

//@Repository
//interface UserRepository : JpaRepository<SiteUser, Int>

interface UserRepository : CrudRepository<SiteUser, Int> {
    fun findByUserName(name: String): SiteUser
    fun findByUserId(id: Int):SiteUser
}