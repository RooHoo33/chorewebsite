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


        @get: NotBlank
        val weekNumber: String = "",

        @get: NotBlank
        val choresList: String = "") {

    fun getChores(): MutableList<Chore> {
        val chores = mutableListOf<Chore>()

        val choresFromSlip = choresList.split(",")
        var i = 0

        chores.add(Chore(day = "Monday", choreString = "Sweep", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Monday", choreString = "Dishes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Monday", choreString = "UpperQuad", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Monday", choreString = "Spykes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Monday", choreString = "LargeDishes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Monday", choreString = "TablesUp", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Tuesday", choreString = "Sweep", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Tuesday", choreString = "Dishes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Tuesday", choreString = "UpperQuad", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Tuesday", choreString = "Spykes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Tuesday", choreString = "LargeDishes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Tuesday", choreString = "TablesUp", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Wednesday", choreString = "Sweep", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Wednesday", choreString = "Dishes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Wednesday", choreString = "UpperQuad", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Wednesday", choreString = "Spykes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Wednesday", choreString = "LargeDishes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Wednesday", choreString = "TablesUp", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Thursday", choreString = "Sweep", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Thursday", choreString = "Dishes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Thursday", choreString = "UpperQuad", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Thursday", choreString = "Spykes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Thursday", choreString = "LargeDishes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Thursday", choreString = "TablesUp", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Friday", choreString = "Sweep", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Friday", choreString = "Dishes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Friday", choreString = "UpperQuad", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Friday", choreString = "Spykes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Friday", choreString = "LargeDishes", priority = Integer.parseInt(choresFromSlip[i++])))
        chores.add(Chore(day = "Friday", choreString = "TablesUp", priority = Integer.parseInt(choresFromSlip[i])))

        return chores
    }



}