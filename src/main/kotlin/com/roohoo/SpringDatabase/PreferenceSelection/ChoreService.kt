package com.roohoo.SpringDatabase.PreferenceSelection

import com.roohoo.SpringDatabase.UserRepository
import org.slf4j.Logger

class ChoreService(private val preferenceRepository: PreferenceRepository, private val userRepository: UserRepository, val logger: Logger) {


    private fun createChoreChart(userAndChoresList: MutableList<UserAndChores>) {

        val choreList = assembleChoreChartMap()
        var stillPicking = true
        while (stillPicking) {
            userAndChoresList.forEach {
                stillPicking = false
                it.chores.sortBy { chores ->
                    chores.priority
                }
                for (chore in it.chores) {
                    if (choreList.getValue(chore.day)[chore.choreString] == 0) {
                        choreList.getValue(chore.day)[chore.choreString] = it.siteUser.user_id
                        stillPicking = true
                        break
                    }

                }
            }
        }

        logger.debug("Monday: " + choreList.getValue("Monday")["sweepAndMop"] + " " + choreList.getValue("Monday")["dishes"])
        logger.debug("Tuesday: " + choreList.getValue("Tuesday")["sweepAndMop"] + " " + choreList.getValue("Tuesday")["dishes"])
    }

    fun getAllUsersAndTheirPreferences() {
        val users = userRepository.findAll()
        val usersAndPreferences = mutableListOf<UserAndChores>()
        users.forEach {
            val allPreferences = preferenceRepository.findAll()
            val onlyUserPreferences = allPreferences.filter { preferenceFromFilter ->
                preferenceFromFilter.user_id == it.user_id
            }
            if (onlyUserPreferences.size > 1) {
                logger.error("There are more than 1 preferences, the size is: " + onlyUserPreferences.size)
            }
            if (onlyUserPreferences.isEmpty()) {
                logger.warn("User does not have any preferences: " + it.user_id)
            }
            usersAndPreferences.add(UserAndChores(it,onlyUserPreferences[0].getChores()))
        }
        createChoreChart(usersAndPreferences)
    }


    private fun assembleChoreChartMap() = mapOf("Monday" to assembleEachDaysChoresMap(), "Tuesday" to assembleEachDaysChoresMap())


    private fun assembleEachDaysChoresMap() = mutableMapOf("sweepAndMop" to 0, "dishes" to 0)
}

