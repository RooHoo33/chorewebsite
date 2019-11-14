package com.roohoo.SpringDatabase.PreferenceSelection

class CreatePreferenceForm{
    var user_id: Int? = null


    var mondaySweep: Int? = null
    var mondayDishes: Int? = null
    var mondayUpperQuad: Int? = null
    var mondaySpykes: Int? = null
    var mondayLargeDishes: Int? = null
    var mondayTablesUp: Int? = null

    var tuesdaySweep: Int? = null
    var tuesdayDishes: Int? = null
    var tuesdayUpperQuad: Int? = null
    var tuesdaySpykes: Int? = null
    var tuesdayLargeDishes: Int? = null
    var tuesdayTablesUp: Int? = null

    var wednesdaySweep: Int? = null
    var wednesdayDishes: Int? = null
    var wednesdayUpperQuad: Int? = null
    var wednesdaySpykes: Int? = null
    var wednesdayLargeDishes: Int? = null
    var wednesdayTablesUp: Int? = null

    var thursdaySweep: Int? = null
    var thursdayDishes: Int? = null
    var thursdayUpperQuad: Int? = null
    var thursdaySpykes: Int? = null
    var thursdayLargeDishes: Int? = null
    var thursdayTablesUp: Int? = null

    var fridaySweep: Int? = null
    var fridayDishes: Int? = null
    var fridayUpperQuad: Int? = null
    var fridaySpykes: Int? = null
    var fridayLargeDishes: Int? = null
    var fridayTablesUp: Int? = null

    var weekOverride: Boolean = false
    var weekNumber:String? = null
    var chore:String? = null
    fun setChoresList(): String {
        return "$mondaySweep,$mondayDishes,$mondayUpperQuad,$mondaySpykes,$mondayLargeDishes,$mondayTablesUp,$tuesdaySweep,$tuesdayDishes,$tuesdayUpperQuad,$tuesdaySpykes,$tuesdayLargeDishes,$tuesdayTablesUp,$wednesdaySweep,$wednesdayDishes,$wednesdayUpperQuad,$wednesdaySpykes,$wednesdayLargeDishes,$wednesdayTablesUp,$thursdaySweep,$thursdayDishes,$thursdayUpperQuad,$thursdaySpykes,$thursdayLargeDishes,$thursdayTablesUp,$fridaySweep,$fridayDishes,$fridayUpperQuad,$fridaySpykes,$fridayLargeDishes,$fridayTablesUp"
    }

}