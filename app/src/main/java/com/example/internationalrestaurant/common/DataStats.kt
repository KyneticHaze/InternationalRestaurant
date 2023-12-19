package com.example.internationalrestaurant.common

sealed class DataStats<T>(val data : T? = null, val message : String? = null) {
    class Loading<T>(data : T? = null) : DataStats<T>(data)
    class Success<T>(data : T) : DataStats<T>(data)
    class Error<T>(message : String) : DataStats<T>(null, message)
}