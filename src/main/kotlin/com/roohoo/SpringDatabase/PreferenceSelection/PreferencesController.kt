package com.roohoo.SpringDatabase.PreferenceSelection

import com.roohoo.SpringDatabase.UserRepository
import org.slf4j.Logger
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class PreferencesController(private val preferenceRepository: PreferenceRepository, private val userRepository: UserRepository, val logger:Logger) {

//    @Autowired
//    private val logger: Logger? = null

    //    @RequestMapping(value="/student", method = arrayOf(RequestMethod.POST))
    @PostMapping("/pref")
    fun addStudent(createPreferenceForm: CreatePreferenceForm, model: Model): String {

        logger.warn("hello")
//        logger.warn(createPreferenceForm.dayOfWeek!!)

//        logger.warn(createPreferenceForm.chores!!)

        logger.warn("hello")

        logger.warn((createPreferenceForm.user_id!!.toInt() is Int).toString())
        logger.warn("goodbye")
        val userId = createPreferenceForm.user_id!!.toInt()
        logger.debug(createPreferenceForm.toString())
        val preference = Preference(user_id = userId, chores_list = createPreferenceForm.setChoresList(), week_number = createPreferenceForm.weekNumber!!.toInt(), chore_year = createPreferenceForm.year!!.toInt())

        logger.debug(createPreferenceForm.weekOverride.toString())
        preferenceRepository.save(preference)

        return "redirect:/allprefs"
    }

    @GetMapping("pref")
    fun createStudentPage(model: Model): String {
        model.addAttribute("preferenceForm", CreatePreferenceForm())
        return "preferences/new-preferences-form"
    }

    @GetMapping("/allprefs")
    fun getAllPrefs(model:Model):String{
        val prefs = preferenceRepository.findAll()


        model.addAttribute("prefs", prefs)

        return "preferences/index"
    }
    @GetMapping("/chorechart")
    fun getChoreChart(model:Model):String{
        var test = ChoreService(preferenceRepository, userRepository, logger)
        val choreChartMap = test.getAllUsersAndTheirPreferences()
        val choreChartList = choreChartMap.values
        model.addAttribute("choreChartList", test.getAllUsersAndTheirPreferences())
        return "preferences/chorechart"
    }

}