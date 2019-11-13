package com.roohoo.SpringDatabase.PreferenceSelection

import com.roohoo.SpringDatabase.SiteUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

//@Repository
////interface PreferenceRepository : JpaRepository<Preference, Int>

interface PreferenceRepository : CrudRepository<Preference, Int> {
    fun findByPreferenceId(id: Int): Preference
    fun findByUserId(id: Int): List<Preference>
}