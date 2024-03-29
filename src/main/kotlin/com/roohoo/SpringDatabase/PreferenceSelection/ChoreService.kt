package com.roohoo.SpringDatabase.PreferenceSelection

import com.roohoo.SpringDatabase.Committee.CommitteeRepository
import com.roohoo.SpringDatabase.UserRepository
import org.slf4j.Logger

class ChoreService(private val preferenceRepository: PreferenceRepository, private val userRepository: UserRepository, private val committeeRepository: CommitteeRepository, val logger: Logger, private val choreChartModelRepository: ChoreChartModelRepository) {


    private fun createChoreChart(userAndChoresList: MutableList<UserAndPriority>, sortType: String, week:String): MutableMap<String, MutableMap<String, String>> {

        val choreList = assembleEachDaysChoresMap()
        val maintenanceCommittee = committeeRepository.findByCommitteeName("maintenance")


        userAndChoresList.filter { it -> it.user.siteUser.brother && maintenanceCommittee.any { mait -> mait.userId == it.user.siteUser.userId } }.sortedBy { onlyBrothers -> onlyBrothers.user.siteUser.kappaSigma }.forEach {
            it.user.chores.sortBy { chores ->
                chores.priority
            }

            for (chore in it.user.chores) {
                if (choreList.getValue(chore.choreString)[chore.day] == "XXX") {
                    if (it.user.siteUser.brother) {
                        choreList.getValue(chore.choreString)[chore.day] = it.user.siteUser.kappaSigma.toString()
                    } else {
                        choreList.getValue(chore.choreString)[chore.day] = "${it.user.siteUser.firstName} ${it.user.siteUser.lastName}"
                    }
                    break
                }

            }
        }
        logger.debug("first: $choreList.toString()")

        userAndChoresList.filter { it -> !it.user.siteUser.brother && maintenanceCommittee.any { mait -> mait.userId == it.user.siteUser.userId } }.sortedBy { onlyAms -> onlyAms.user.siteUser.big }.forEach {
            it.user.chores.retainAll{goodChore ->
                goodChore.priority != 0
            }
            it.user.chores.sortBy { chores ->
                chores.priority
            }

            for (chore in it.user.chores) {
                if (choreList.getValue(chore.choreString)[chore.day] == "XXX") {
                    if (it.user.siteUser.brother) {
                        choreList.getValue(chore.choreString)[chore.day] = it.user.siteUser.kappaSigma.toString()
                    } else {
                        choreList.getValue(chore.choreString)[chore.day] = "${it.user.siteUser.firstName} ${it.user.siteUser.lastName}"
                    }
                    break
                }

            }
        }
        logger.debug("second: $choreList.toString()")
        logger.debug("This is the sort type: " + sortType)
        when (sortType) {
            "kappaSigma" -> userAndChoresList.sortBy { it -> it.priority }
            "random" -> userAndChoresList.shuffle()
            "reverse" -> userAndChoresList.sortByDescending { it -> it.priority }
        }

        userAndChoresList.filter { it -> maintenanceCommittee.any { mait -> mait.userId != it.user.siteUser.userId } }.forEach {
            it.user.chores.retainAll{goodChore ->
                goodChore.priority != 0
            }
            it.user.chores.sortBy { chores ->
                chores.priority
            }

            for (chore in it.user.chores) {
                if (choreList.getValue(chore.choreString)[chore.day] == "XXX") {
                    if (it.user.siteUser.brother) {
                        choreList.getValue(chore.choreString)[chore.day] = it.user.siteUser.kappaSigma.toString()
                    } else {
                        choreList.getValue(chore.choreString)[chore.day] = "${it.user.siteUser.firstName} ${it.user.siteUser.lastName}"
                    }
                    break
                }

                }
            }


            var stillPicking = true
            while (stillPicking) {
                userAndChoresList.forEach {
                    stillPicking = false
                    it.user.chores.retainAll{goodChore ->
                        goodChore.priority != 0
                    }
                    it.user.chores.sortBy { chores ->
                        chores.priority
                    }
                    for (chore in it.user.chores) {
                        if (choreList.getValue(chore.choreString)[chore.day] == "XXX") {
                            if (it.user.siteUser.brother) {
                                choreList.getValue(chore.choreString)[chore.day] = it.user.siteUser.kappaSigma.toString()
                            } else {
                                choreList.getValue(chore.choreString)[chore.day] = "${it.user.siteUser.firstName} ${it.user.siteUser.lastName}"
                            }
                            stillPicking = true
                            break
                        }

                    }
                }
            }
//            logger.debug("Monday: " + choreList.getValue("Sweep")["Monday"] + " " + choreList.getValue("dishes")["Monday"])
//            logger.debug("Monday: " + choreList.getValue("Sweep")["Tuesday"] + " " + choreList.getValue("dishes")["Tuesday"])
        val list = mutableListOf<String>()
        choreList.forEach{
            k, v ->
            v.forEach{
                kTwo, vTwo ->
                logger.debug("$k: $kTwo: $vTwo")
                list.add(vTwo.toString())

            }
        }
        var i = 0
        val choreChartModel = ChoreChartModel(week_and_year = week,
                sweepMonday =list[i++],
                sweepTuesday =list[i++],
                sweepWednesday =list[i++],
                sweepThursday =list[i++],
                sweepFriday =list[i++],
                dishesMonday =list[i++],
                dishesTuesday =list[i++],
                dishesWednesday =list[i++],
                dishesThursday =list[i++],
                dishesFriday =list[i++],
                upperQuadMonday =list[i++],
                upperQuadTuesday =list[i++],
                upperQuadWednesday =list[i++],
                upperQuadThursday =list[i++],
                upperQuadFriday =list[i++],
                spykesMonday =list[i++],
                spykesTuesday =list[i++],
                spykesWednesday =list[i++],
                spykesThursday =list[i++],
                spykesFriday =list[i++],
                largeDishesMonday =list[i++],
                largeDishesTuesday =list[i++],
                largeDishesWednesday =list[i++],
                largeDishesThursday =list[i++],
                largeDishesFriday =list[i++],
                tablesUpMonday =list[i++],
                tablesUpTuesday =list[i++],
                tablesUpWednesday =list[i++],
                tablesUpThursday =list[i++],
                tablesUpFriday = list[i])
        choreChartModelRepository.save(choreChartModel)

            return choreList

        }

        fun getAllUsersAndTheirPreferences(sortType: String, week: String): MutableMap<String, MutableMap<String, String>> {
            val users = userRepository.findAll()
            val usersAndPreferences = mutableListOf<UserAndChores>()
            users.forEach {
                val allPreferences = preferenceRepository.findAll()
                val onlyUserPreferences = allPreferences.filter { preferenceFromFilter ->
                    preferenceFromFilter.userId == it.userId
                }
                when {
                    onlyUserPreferences.size > 1 -> logger.error("There are more than 1 preferences for: " + it.userId + ", the size is: " + onlyUserPreferences.size)
                    onlyUserPreferences.isEmpty() -> logger.warn("User does not have any preferences: " + it.userId)
                    else -> usersAndPreferences.add(UserAndChores(it, onlyUserPreferences[0].getChores()))
                }
            }

            val usersAndPriority = getUserPriority(usersAndPreferences)
            return createChoreChart(usersAndPriority, sortType, week)
        }

        fun getUserPriority(userAndChoresList: MutableList<UserAndChores>): MutableList<UserAndPriority> {

//        val users = userRepository.findAll()
            var usersAndPriority = mutableListOf<UserAndPriority>()

            var i = 1
            userAndChoresList.filter { it -> it.siteUser.brother }.sortedBy { onlyBrothers -> onlyBrothers.siteUser.kappaSigma }.forEach {
                logger.debug("$i:$it")
                usersAndPriority.add(UserAndPriority(it, i))
                i++
            }
            userAndChoresList.filter { it -> !it.siteUser.brother }.sortedBy { onlyAms -> onlyAms.siteUser.big }.forEach {
                usersAndPriority.add(UserAndPriority(it, i))
                logger.debug("$i:$it")
                i++
            }
            return usersAndPriority


        }

//    private fun getPriority(users: Iterable<SiteUser>, pI: Int, pUsersAndPriority: MutableList<UserAndPriority>) {
//        users.filter { it -> it.brother }.sortedBy { onlyBrothers -> onlyBrothers.kappaSigma }.forEach {
//            pUsersAndPriority.add(UserAndPriority(it, i))
//            i++
//        }
//
//    }

        fun assembleChoreChartMap() = mutableMapOf("Monday" to "XXX", "Tuesday" to "XXX", "Wednesday" to "XXX", "Thursday" to "XXX", "Friday" to "XXX")


        fun assembleEachDaysChoresMap() = mutableMapOf("Sweep" to assembleChoreChartMap(), "Dishes" to assembleChoreChartMap(), "UpperQuad" to assembleChoreChartMap(), "Spykes" to assembleChoreChartMap(), "LargeDishes" to assembleChoreChartMap(), "TablesUp" to assembleChoreChartMap())
    }

    data class UserAndPriority(val user: UserAndChores, val priority: Int)


