package com.asadbek.wheatherexample.retrofit

import com.asadbek.wheatherexample.models.Wheather
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    //     // 2.5/forecast?lat=40.478293453610355&lon=71.72109800068034&appid=39b9f5aa8264645a6f5fd95692a9e4c5
    //forecast/daily?lat=44.34&lon=10.99&cnt=7&appid={API key}
    @GET("2.5/forecast?lat=40.478293453610355&lon=71.72109800068034&lang=en&appid=39b9f5aa8264645a6f5fd95692a9e4c5")
    fun getData():Call<Wheather>
}