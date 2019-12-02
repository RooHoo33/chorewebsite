package com.roohoo.SpringDatabase

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping







//@RestController
////@RequestMapping("/api")
@Controller
class UserController(private val userRepository: UserRepository) {

    val logger = LoggerFactory.getLogger(UserController::class.java)!!


//    @RequestMapping("/login")
//    fun login(model:Model): String{
//        return "login.html"
//    }

    @RequestMapping("/")
    fun home(model:Model): String{
//        val users = userRepository.findAll()
//
//        model.addAttribute("users", users)
        return "main-page"
    }

    @RequestMapping("/403")
    fun error403(): String{
        return "403.html"
    }


    @GetMapping("/login")
    fun login(
            @RequestParam(value = "error", required = false) error: String?,
            @RequestParam(value = "logout", required = false) logout: String?, model:Model): String {

        if (error != null) {
            model.addAttribute("error", "Invalid username and password!")
        }

        if (logout != null) {

            model.addAttribute("msg", "You've been logged out successfully.")
        }


        return "login";

    }

//    @GetMapping("/users")
//    fun getAllJUsers(model: Model): String {
//
//
//        val users = userRepository.findAll()
//
//        model.addAttribute("users", users)
//
//        return "site-users/index"
//    }

    @RequestMapping("/home")
    fun getHome(model: Model): String {
        var auth = false
        if (SecurityContextHolder.getContext().authentication != null && SecurityContextHolder.getContext().authentication.isAuthenticated){
            auth = true;
        }
        model.addAttribute("auth", auth)

//        val users = userRepository.findAll()
//
//        model.addAttribute("users", users)

        return "main-page"
    }

    @PostMapping("/create-user")
    fun createNewUser(siteUser:CreateSiteUser, model: Model): String {

        val passwordEncoder = BCryptPasswordEncoder()
        val hashedPassword = passwordEncoder.encode(siteUser.password)

        logger.debug(siteUser.toString())

        val siteUserHere = SiteUser(firstName = siteUser.first_name!!, brother = siteUser.kappa_sigma != 0, kappaSigma = siteUser.kappa_sigma!!, lastName = siteUser.last_name!!, password = hashedPassword, userName = siteUser.user_name!!)
        userRepository.save(siteUserHere)
        val users = userRepository.findAll()

        model.addAttribute("users", users)

        return "site-users/index"
    }

    @GetMapping("/create-user")
    fun createNewUserPage(model: Model): String {
        model.addAttribute("siteUser", CreateSiteUser())
        return "site-users/new-user"
    }

    @PostMapping("/users")
    fun createNewArticle(@Valid @RequestBody siteUser: SiteUser): SiteUser =
            userRepository.save(siteUser)


    @GetMapping("/users/{id}")
    fun getArticleById(@PathVariable(value = "id") userId: Int): ResponseEntity<SiteUser> {
        return userRepository.findById(userId).map { user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/users/{id}")
    fun updateArticleById(@PathVariable(value = "id") userId: Int,
                          @Valid @RequestBody newSiteUser: SiteUser): ResponseEntity<SiteUser> {

        return userRepository.findById(userId).map { existingUser ->
            val updatedArticle: SiteUser = existingUser
                    .copy(userName = newSiteUser.userName)
            ResponseEntity.ok().body(userRepository.save(updatedArticle))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/users/{id}")
    fun deleteArticleById(@PathVariable(value = "id") userId: Int): ResponseEntity<Void> {

        return userRepository.findById(userId).map { user  ->
            userRepository.delete(user)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }

}