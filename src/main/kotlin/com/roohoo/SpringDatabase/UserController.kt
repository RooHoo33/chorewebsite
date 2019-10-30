package com.roohoo.SpringDatabase

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import org.springframework.web.bind.annotation.GetMapping



@RestController
@RequestMapping("/api")
class UserController(private val userRepository: UserRepository) {



    @GetMapping("/users")
    fun getAllJournals() : List<SiteUser> = userRepository.findAll()

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