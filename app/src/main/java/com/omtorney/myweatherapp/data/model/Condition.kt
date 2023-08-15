package com.omtorney.myweatherapp.data.model

import kotlinx.serialization.Serializable

@Serializable
class Condition(
    val text: String,
    val icon: String,
//    val code: Int
)
