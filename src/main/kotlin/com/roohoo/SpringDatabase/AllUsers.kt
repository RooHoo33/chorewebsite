package com.roohoo.SpringDatabase

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AllUsers(private val userRepository: UserRepository) {

    @GetMapping("/all")
    fun displayAllUsers(model: ModelMap): String {


        val users = userRepository.findAll()

        model.addAttribute("users", users)

        return "site-uers/index"
    }
}

//@GetMapping("/article")
//public AllUsers(Map<String, Object> model) {
//
//
//    @GetMapping("/allusers")
//    fun displayArticle(model: MutableMap<String, Any>): ModelAndView {
//
//        val users = userRepository.findAll()
//
//        model["users"] = users
//
//        return ModelAndView("index", model)
//    }
//}