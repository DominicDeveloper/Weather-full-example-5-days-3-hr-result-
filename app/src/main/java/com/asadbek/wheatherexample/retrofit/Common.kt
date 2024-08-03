package com.asadbek.wheatherexample.retrofit

object Common {
    // https://api.openweathermap.org/data/2.5/forecast?lat=40.478293453610355&lon=71.72109800068034&appid=39b9f5aa8264645a6f5fd95692a9e4c5
    val BASE_URL = "https://api.openweathermap.org/data/"

    val retrofitService:RetrofitService
        get() = RetrofitClient.getRetrofit(BASE_URL).create(RetrofitService::class.java)
}