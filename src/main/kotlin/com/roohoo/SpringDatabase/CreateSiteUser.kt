package com.roohoo.SpringDatabase

class CreateSiteUser {
    var user_name: String? = null
    var first_name: String? = null
    var last_name: String? = null
    var kappa_sigma: Int? = null
    var brother: Boolean = false
    var password: String? = null
    override fun toString(): String {
        return "CreateSiteUser(userName=$user_name, firstName=$first_name, lastName=$last_name, kappaSigma=$kappa_sigma, brother=$brother, password=$password)"
    }


}