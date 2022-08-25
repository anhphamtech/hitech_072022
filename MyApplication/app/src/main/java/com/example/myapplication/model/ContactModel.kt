package com.example.myapplication.model

data class ContactModel(
    var name: String = "",
    var phone: String = "",
    var image: String = "",
    var idPhoto: String = "",
    var statusLike: Boolean = false
)