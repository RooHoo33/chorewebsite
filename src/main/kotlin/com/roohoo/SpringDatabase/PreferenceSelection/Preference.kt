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

        @get: NotBlank
        val year: Int = 0,

        @get: NotBlank
        val week_number: Int = 0,

        @get: NotBlank
        val chores_list: String = ""){
        var choresList:List<String>? = null
        var chores:ArrayList<Chore>?=null
        init {
            choresList = chores_list.split(",")
                chores?.add(Chore(chore = "sweepAndMop", day = "Monday", priority = Integer.parseInt(choresList!![0])))
                chores?.add(Chore(chore = "dishes", day = "Monday", priority = Integer.parseInt(choresList!![1])))
                chores?.add(Chore(chore = "sweepAndMop", day = "Tuesday", priority = Integer.parseInt(choresList!![2])))
                chores?.add(Chore(chore = "dishes", day = "Tuesday", priority = Integer.parseInt(choresList!![3])))


        }
}

