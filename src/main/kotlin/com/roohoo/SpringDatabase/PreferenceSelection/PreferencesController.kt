package com.roohoo.SpringDatabase.PreferenceSelection

import com.roohoo.SpringDatabase.Committee.CommitteeRepository
import com.roohoo.SpringDatabase.UserRepository
import org.slf4j.Logger
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails


@Controller
class PreferencesController(private val preferenceRepository: PreferenceRepository, private val userRepository: UserRepository, val logger: Logger, private val committeeRepository: CommitteeRepository) {

//    @Autowired
//    private val logger: Logger? = null

    //    @RequestMapping(value="/student", method = arrayOf(RequestMethod.POST))
    @PostMapping("/pref")
    fun addStudent(createPreferenceForm: CreatePreferenceForm, model: Model): String {


        val userId = createPreferenceForm.user_id!!.toInt()
        logger.debug(createPreferenceForm.toString())
        logger.debug(createPreferenceForm.weekNumber)
        val preference = Preference(userId = userId, choresList = createPreferenceForm.setChoresList(), weekNumber = createPreferenceForm.weekNumber!!)

        logger.debug(createPreferenceForm.weekOverride.toString())
        preferenceRepository.save(preference)

        return "redirect:/allprefs"
    }

    @GetMapping("pref")
    fun createStudentPage(model: Model): String {

        var auth = false;
        if (SecurityContextHolder.getContext().authentication != null && SecurityContextHolder.getContext().authentication.isAuthenticated){
            auth = true;
        }
        model.addAttribute("preferenceForm", CreatePreferenceForm())
        model.addAttribute("auth", auth)

        return "preferences/new-preferences-form"
    }

    @GetMapping("/allprefs")
    fun getAllPrefs(model: Model): String {
        val principal = SecurityContextHolder.getContext().authentication.principal
        var username:String? = null
        if (principal is UserDetails) {
            username = principal.username
        } else {
            username = principal.toString()
        }

        val userObject = userRepository.findByUserName(username!!)
        logger.debug("this is the user: " + username)
        logger.debug(userObject.toString())

        val prefs = preferenceRepository.findAll()


        model.addAttribute("prefs", prefs)

        return "preferences/index"
    }

    @PostMapping("/chorechart")
    fun createChoreChart(choreChartType: ChoreChartType, model: Model): String {
        var test = ChoreService(preferenceRepository, userRepository, committeeRepository, logger)
//        val choreChartList = choreChartMap.values
        model.addAttribute("choreChartList", test.getAllUsersAndTheirPreferences(choreChartType.type))
        return "preferences/chorechart"
    }

    @GetMapping("/chorechart")
    fun getChoreChart(model: Model): String {
        var test = ChoreService(preferenceRepository, userRepository, committeeRepository, logger)
//        val choreChartList = choreChartMap.values
        model.addAttribute("choreChartType", ChoreChartType())
        return "preferences/select-chore-chart-type"
    }

}