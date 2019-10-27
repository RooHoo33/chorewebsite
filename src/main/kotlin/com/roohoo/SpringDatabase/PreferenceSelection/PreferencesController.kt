package com.roohoo.SpringDatabase.PreferenceSelection

import org.slf4j.Logger
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class PreferencesController(private val preferenceRepository: PreferenceRepository, val logger:Logger) {

//    @Autowired
//    private val logger: Logger? = null

    //    @RequestMapping(value="/student", method = arrayOf(RequestMethod.POST))
    @PostMapping("/pref")
    fun addStudent(createPreferenceForm: CreatePreferenceForm, model: Model): String {

        logger.warn("hello")
//        logger.warn(createPreferenceForm.dayOfWeek!!)

//        logger.warn(createPreferenceForm.chore!!)

        logger.warn("hello")

        logger.warn((createPreferenceForm.user_id!!.toInt() is Int).toString())
        logger.warn("goodbye")
//        val userId = createPreferenceForm.user_id!!.toInt()
//        val preference = Preference(user_id = userId, day_of_week = createPreferenceForm.dayOfWeek!!, chore = createPreferenceForm.chore!!)


//        preferenceRepository.save(preference)

        return "redirect:/allprefs"
    }

    @GetMapping("pref")
    fun createStudentPage(model: Model): String {
        model.addAttribute("preferenceForm", CreatePreferenceForm())
        return "preferences/new-preferences-form"
    }

    @GetMapping("allprefs")
    fun getAllPrefs(model:Model):String{
        val prefs = preferenceRepository.findAll()


        model.addAttribute("prefs", prefs)

        return "preferences/index"
    }

}