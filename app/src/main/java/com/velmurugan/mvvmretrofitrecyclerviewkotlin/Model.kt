package com.velmurugan.mvvmretrofitrecyclerviewkotlin
import com.google.gson.annotations.SerializedName

data class GitHubRepos(
    var id: Int? = null,
    var nodeId: String? = null,
    var name: String? = null,
    var fullName: String? = null,
    var private: Boolean? = null,
    var owner: Owner? = Owner(),
)

data class Owner(
    var login: String? = null,
    var id: Int? = null,
    var nodeId: String? = null,
    var avatarUrl: String? = null,
    var gravatarId: String? = null,
)