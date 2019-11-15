package com.roohoo.SpringDatabase.PreferenceSelection

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity(name = "complete_chore_charts")
data class ChoreChartModel(

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val chore_chart_id: Int = 0,

        @get: NotBlank
        val week_and_year: String = "",
        @get: NotBlank
        val sweepMonday: String = "",
        @get: NotBlank
        val sweepTuesday: String = "",
        @get: NotBlank
        val sweepWednesday: String = "",
        @get: NotBlank
        val sweepThursday: String = "",
        @get: NotBlank
        val sweepFriday: String = "",
        @get: NotBlank
        val dishesMonday: String = "",
        @get: NotBlank
        val dishesTuesday: String = "",
        @get: NotBlank
        val dishesWednesday: String = "",
        @get: NotBlank
        val dishesThursday: String = "",
        @get: NotBlank
        val dishesFriday: String = "",
        @get: NotBlank
        val upperQuadMonday: String = "",
        @get: NotBlank
        val upperQuadTuesday: String = "",
        @get: NotBlank
        val upperQuadWednesday: String = "",
        @get: NotBlank
        val upperQuadThursday: String = "",
        @get: NotBlank
        val upperQuadFriday: String = "",
        @get: NotBlank
        val spykesMonday: String = "",
        @get: NotBlank
        val spykesTuesday: String = "",
        @get: NotBlank
        val spykesWednesday: String = "",
        @get: NotBlank
        val spykesThursday: String = "",
        @get: NotBlank
        val spykesFriday: String = "",
        @get: NotBlank
        val largeDishesMonday: String = "",
        @get: NotBlank
        val largeDishesTuesday: String = "",
        @get: NotBlank
        val largeDishesWednesday: String = "",
        @get: NotBlank
        val largeDishesThursday: String = "",
        @get: NotBlank
        val largeDishesFriday: String = "",
        @get: NotBlank
        val tablesUpMonday: String = "",
        @get: NotBlank
        val tablesUpTuesday: String = "",
        @get: NotBlank
        val tablesUpWednesday: String = "",
        @get: NotBlank
        val tablesUpThursday: String = "",
        @get: NotBlank
        val tablesUpFriday: String = ""
){

}
