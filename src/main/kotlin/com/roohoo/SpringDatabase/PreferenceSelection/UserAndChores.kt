package com.roohoo.SpringDatabase.PreferenceSelection

import com.roohoo.SpringDatabase.SiteUser

public data class UserAndChores(val siteUser: SiteUser, val chores: MutableList<Chore>)