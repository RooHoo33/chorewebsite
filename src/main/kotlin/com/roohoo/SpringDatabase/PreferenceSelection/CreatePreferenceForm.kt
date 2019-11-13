package com.roohoo.SpringDatabase.PreferenceSelection

class CreatePreferenceForm{
    var user_id: Int? = null
    var mondaySweep: Int? = null
    var mondayDishes: Int? = null
    var tuesdaySweep: Int? = null
    var tuesdayDishes: Int? = null
    var weekOverride: Boolean = false
    var weekNumber:String? = null
    //    var dayOfWeek:String? = null
    var chore:String? = null
    fun setChoresList(): String {
        return "$mondaySweep,$mondayDishes,$tuesdaySweep,$tuesdayDishes"
    }

    override fun toString(): String {
        return "CreatePreferenceForm(userId=$user_id, mondaySweep=$mondaySweep, mondayDishes=$mondayDishes, tuesdaySweep=$tuesdaySweep, tuesdayDishes=$tuesdayDishes, weekOverride=$weekOverride, weekNumber=$weekNumber, chore=$chore)"
    }
}