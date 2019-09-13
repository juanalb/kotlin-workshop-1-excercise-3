package com.example.workshopexcersise3.interfaces

import com.example.workshopexcersise3.models.ListItemInholland
import retrofit2.Call
import retrofit2.http.GET

interface IListItemInholland {
    @GET("test")
    fun getAllListItems(): Call<List<ListItemInholland>>
}