package com.roohoo.SpringDatabase

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry






@Configuration
@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {


//    @Bean
//    public override fun userDetailsService(): UserRepository {
//        return UserDetailsServiceImpl()
//    }
//
//    @Autowired
//    private val userRepository: UserRepository? = null
//
//    @Bean
//    fun passwordEncoder(): BCryptPasswordEncoder {
//        return BCryptPasswordEncoder()
//    }
//
//    @Bean
//    fun authenticationProvider(): DaoAuthenticationProvider {
//        val authProvider = DaoAuthenticationProvider()
//        authProvider.setUserDetailsService(userRepository())
//        authProvider.setPasswordEncoder(passwordEncoder())
//        return authProvider
//    }
//
//    override fun configure(auth: AuthenticationManagerBuilder) {
//        auth.authenticationProvider(authenticationProvider())
//    }
//
//    @Throws(Exception::class)
//    override fun configure(http: HttpSecurity) {
//        http
//                .authorizeRequests().antMatchers("/wallPage").hasAnyRole("ADMIN", "USER")
//                .and()
//                .authorizeRequests().antMatchers("/login", "/resource/**").permitAll()
//                .and()
//                .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()
//                .loginProcessingUrl("/doLogin")
//                .successForwardUrl("/postLogin")
//                .failureUrl("/loginFailed")
//                .and()
//                .logout().logoutUrl("/doLogout").logoutSuccessUrl("/logout").permitAll()
//                .and()
//                .csrf().disable()
//    }
//}

    //    @Autowired
//    val logger: org.slf4j.Logger? = null
    @Autowired
    private val userRepository: UserRepository? = null

    @Autowired
    private val sqlUserDetailsService: SqlUserDetailsService? = null

    val logger = LoggerFactory.getLogger(SecurityConfig::class.java)!!

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/create-user").permitAll()
                .antMatchers("/static/css/layout_header.css").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/css/*").permitAll()
                .antMatchers("/images/*").permitAll()
                .antMatchers("/**/*.js", "/**/*.css").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and().sessionManagement().disable()
                .logout()
                .logoutRequestMatcher(AntPathRequestMatcher("/logout"));

    }

//    override fun configure(http: HttpSecurity): Unit {
//        http
//                .authorizeRequests()
//                .antMatchers("/create-user").permitAll()
//                .antMatchers("/**").hasRole("USER")
//                .antMatchers("/chorechart").hasRole("USER")
//                .antMatchers("/admin").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(AntPathRequestMatcher("/logout"));
//
//
////        http.exceptionHandling().accessDeniedPage("/403");
//    }


    fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/img/**",
                "/css/**",
                "/js/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/")
    }

    @Throws(Exception::class)
    public override fun configure(builder: AuthenticationManagerBuilder) {
        logger.debug("we are right here")
        builder.userDetailsService<SqlUserDetailsService>(sqlUserDetailsService)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}

//    @Throws(Exception::class)
//    override fun configure(auth: AuthenticationManagerBuilder) {
//
//        val users = userRepository?.findAll()
//        logger.debug("we are here")
//        logger.debug(users.toString())
//        if (users != null) {
//            for (user in users){
//                logger.debug(user.userName + " : " + user.password)
//                auth.inMemoryAuthentication()
//                        .withUser(user.userName).password("{noop}" + user.password).roles("USER")
//
//            }
//        }

//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}password").roles("ADMIN")

//    }
//
//}


//@Service("userDetailsService")
//class UserDetailsServiceImpl : UserDetailsService {
//    @Autowired
//    private val userRepository: UserRepository? = null
//
//    @Transactional(readOnly = true)
//    @Throws(UsernameNotFoundException::class)
//    override fun loadUserByUsername(username: String): SiteUser {
//        val user = userRepository!!.findByUser_name(username) ?: throw UsernameNotFoundException("User not found.")
//        log.info("loadUserByUsername() : {}", username)
//        return user
//    }
//
//    companion object {
//        private val log = LoggerFactory.getLogger(UserDetailsServiceImpl::class.java)
//    }
//}