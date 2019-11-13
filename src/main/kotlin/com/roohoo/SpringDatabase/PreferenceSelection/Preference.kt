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
        val preferenceId: Int = 0,

        @get: NotNull
        val userId: Int = 0,

        @get: NotNull
        val choreYear: Int = 0,

        @get: NotNull
        val weekNumber: Int = 0,

        @get: NotBlank
        val choresList: String = "") {

    fun getChores(): MutableList<Chore> {
        val chores = mutableListOf<Chore>()

        val choresFromSlip = choresList.split(",")

        chores.add(Chore(choreString = "sweepAndMop", day = "Monday", priority = Integer.parseInt(choresFromSlip[0])))
        chores.add(Chore(choreString = "dishes", day = "Monday", priority = Integer.parseInt(choresFromSlip[1])))
        chores.add(Chore(choreString = "sweepAndMop", day = "Tuesday", priority = Integer.parseInt(choresFromSlip[2])))
        chores.add(Chore(choreString = "dishes", day = "Tuesday", priority = Integer.parseInt(choresFromSlip[3])))
        return chores
    }



}