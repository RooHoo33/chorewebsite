package com.roohoo.SpringDatabase.PreferenceSelection

import com.roohoo.SpringDatabase.UserRepository
import org.slf4j.Logger

class ChoreService(private val preferenceRepository: PreferenceRepository, private val userRepository: UserRepository, val logger: Logger) {


    private fun createChoreChart(userAndChoresList: MutableList<UserAndChores>): MutableMap<String, MutableMap<String, Int>> {

        val choreList = assembleEachDaysChoresMap()
        var stillPicking = true
        while (stillPicking) {
            userAndChoresList.forEach {
                stillPicking = false
                it.chores.sortBy { chores ->
                    chores.priority
                }
                for (chore in it.chores) {
                    if (choreList.getValue(chore.choreString)[chore.day] == 0) {
                        choreList.getValue(chore.choreString)[chore.day] = it.siteUser.userId
                        stillPicking = true
                        break
                    }

                }
            }
        }
        logger.debug("Monday: " + choreList.getValue("sweepAndMop")["Monday"] + " " + choreList.getValue("dishes")["Monday"])
        logger.debug("Monday: " + choreList.getValue("sweepAndMop")["Tuesday"] + " " + choreList.getValue("dishes")["Tuesday"])
        return choreList

    }

    fun getAllUsersAndTheirPreferences(): MutableMap<String, MutableMap<String, Int>> {
        val users = userRepository.findAll()
        val usersAndPreferences = mutableListOf<UserAndChores>()
        users.forEach {
            val allPreferences = preferenceRepository.findAll()
            val onlyUserPreferences = allPreferences.filter { preferenceFromFilter ->
                preferenceFromFilter.user_id == it.userId
            }
            if (onlyUserPreferences.size > 1) {
                logger.error("There are more than 1 preferences, the size is: " + onlyUserPreferences.size)
            } else if (onlyUserPreferences.isEmpty()) {
                    logger.warn("User does not have any preferences: " + it.userId)

                }else {

                usersAndPreferences.add(UserAndChores(it, onlyUserPreferences[0].getChores()))
            }
        }
        return createChoreChart(usersAndPreferences)
    }


    private fun assembleChoreChartMap() = mutableMapOf("Monday" to 0, "Tuesday" to 0)


    private fun assembleEachDaysChoresMap() = mutableMapOf("sweepAndMop" to assembleChoreChartMap(), "dishes" to assembleChoreChartMap())
}

