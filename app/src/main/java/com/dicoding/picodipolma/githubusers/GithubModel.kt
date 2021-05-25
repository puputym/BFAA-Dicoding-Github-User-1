package com.dicoding.picodipolma.githubusers

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubModel (
    var username : String = "",
    var name : String = "",
    var location : String = "",
    var repository : String = "",
    var company : String = "",
    var followers : String = "",
    var followings : String = "",
    var avatar : Int = 0
): Parcelable
