package com.roohoo.SpringDatabase

class RolesEnum{
    val admin = Role(2,"admin","this is the admin user");
    val user = Role(1,"user","just a basic user");

    data class Role(val roleNumber:Int, val roleName:String, val description:String)


}