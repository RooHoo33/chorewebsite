package com.roohoo.SpringDatabase.PreferenceSelection

data class ChoreChartDay(var sweepAndMop:Int = 0,
                         var dishes: Int = 0){
    fun getChore(chore:String): Int{
        if (chore == "sweepAndMop"){
            return sweepAndMop
        } else if (chore == "dishes"){
            return dishes
        }
        throw Throwable(chore)
    }
}