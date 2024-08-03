package com.asadbek.wheatherexample.retrofit

import com.asadbek.wheatherexample.models.Wheather
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    // lat va lon - lokatsiya
    // lang - til
    // appid - sizga beriladigan api qoyasizlar
    @GET("2.5/forecast?lat=40.478293453610355&lon=71.72109800068034&lang=en&appid=api_key")
    fun getData():Call<Wheather>
}
