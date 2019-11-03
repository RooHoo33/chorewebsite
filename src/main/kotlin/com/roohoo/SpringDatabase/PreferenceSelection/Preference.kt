package com.roohoo.SpringDatabase.PreferenceSelection

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity(name = "preferences")
data class Preference(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val preference_id: Int = 0,

        @get: NotNull
        val user_id: Int = 0,

        @get: NotNull
        val chore_year: Int = 0,

        @get: NotNull
        val week_number: Int = 0,

        @get: NotBlank
        val chores_list: String = "") {

    fun getChores(): MutableList<Chore> {
        val chores = mutableListOf<Chore>()

        val choresFromSlip = chores_list.split(",")

        chores.add(Chore(choreString = "sweepAndMop", day = "Monday", priority = Integer.parseInt(choresFromSlip[0])))
        chores.add(Chore(choreString = "dishes", day = "Monday", priority = Integer.parseInt(choresFromSlip[1])))
        chores.add(Chore(choreString = "sweepAndMop", day = "Tuesday", priority = Integer.parseInt(choresFromSlip[2])))
        chores.add(Chore(choreString = "dishes", day = "Tuesday", priority = Integer.parseInt(choresFromSlip[3])))
        return chores
    }



}