package com.asadbek.wheatherexample

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.asadbek.wheatherexample.databinding.ActivityMainBinding
import com.asadbek.wheatherexample.models.Wheather
import com.asadbek.wheatherexample.retrofit.Common
import com.asadbek.wheatherexample.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val TAG = "MainActivity"

/**
 * Owner: @DominicAzimov
 * Using: open weather site
 * Api dagi ma`lumotlarning o`zgaruvchi nomlari bir xil bo`lishi shart
 * https://openweathermap.org/forecast5
 * o`qishingiz kerak bo`lgan narsa: com/asadbek/wheatherexample/zarurboladi
 */
class MainActivity : AppCompatActivity() {
    lateinit var retrofitService: RetrofitService
    lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofitService = Common.retrofitService
        // barcha malumotlarni olish
        retrofitService.getData().enqueue(object :Callback<Wheather>{
            override fun onResponse(call: Call<Wheather>, response: Response<Wheather>) {
                if (response.isSuccessful){
                    Log.d(TAG, "onResponse: ${response.body()?.sunset}")
                    Log.d(TAG, "onCity: ${response.body()!!.city.name}")
                    // country - null kelyabd
                    binding.timezone.text = "Hudud vaqti: ${response.body()!!.list[0].dt_txt}"
                    binding.sunrise.text = "Quyosh chiqishi: ${response.body()!!.sunrise}"
                    binding.sunset.text = "Quyosh botishi: ${response.body()!!.sunset}"
                    binding.name.text = "Hudud: ${response.body()!!.city.name}"
                    binding.obhavo.text = "Ob havo holati: ${response.body()!!.list[0].weather[0].main}"
                    binding.description.text = "Qisqacha: ${response.body()!!.list[0].weather[0].description}"
                    binding.lat.text = "Kenglik/Lat: ${response.body()!!.city.coord.lat}"
                    binding.lon.text = "Uzunlik/lon: ${response.body()!!.city.coord.lon}"

                }
            }
            override fun onFailure(call: Call<Wheather>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })


    }
}
/*
class MainActivity : AppCompatActivity() 
        retrofitService = Common.retrofitService

        // barcha user malumotlarini olib kelish
        retrofitService.getUsers().enqueue(object : Callback<UserResponce>{
            // onResponse - api dan javob muvaffaqiyatli kelganda ushbu funktsiya ishka tushadi
            override fun onResponse(call: Call<UserResponce>, response: Response<UserResponce>) {
                if (response.isSuccessful){
                    Log.d(TAG, "onResponse: ${response.body()}")
                    binding.myTextView.text = "${response.body()}"
                }
            }

            // api dan javob muvaffaqiyatsiz kelganda ushbu funktsiya ishka tushadi
            override fun onFailure(call: Call<UserResponce>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Muammo yuz berdi!", Toast.LENGTH_SHORT).show()
            }

        })


        // id orqali bitta usr ma`lumotini olib kelish tanlab
        retrofitService.getSingleUser(23).enqueue(object :Callback<SingleUserResponse>{
            override fun onResponse(
                call: Call<SingleUserResponse>,
                response: Response<SingleUserResponse>
            ) {
                Log.d(TAG, "responseSingle: ${response.body()?.data}")
            }

            override fun onFailure(call: Call<SingleUserResponse>, t: Throwable) {
                Log.d(TAG, "responseSingle: ${t.message}")
            }

        })

        // post
        val reqUser = ReqUser("Dominic","Developer")
        retrofitService.createUser(reqUser).enqueue(object :Callback<ResUser>{
            override fun onResponse(call: Call<ResUser>, response: Response<ResUser>) {
              if (response.isSuccessful){
                  Log.d(TAG, "onResponseCreate: ${response.body()}")
              }
            }

            override fun onFailure(call: Call<ResUser>, t: Throwable) {

            }

        })
        // update
        val reqUser2 = ReqUser("Bobur","Developer")
        retrofitService.updateUser(2,reqUser2).enqueue(object :Callback<ResUpdateUser>{
            override fun onResponse(call: Call<ResUpdateUser>, response: Response<ResUpdateUser>) {
                if (response.isSuccessful){
                    Log.d(TAG, "update: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<ResUpdateUser>, t: Throwable) {

            }

        })

        // delete
        retrofitService.deleteUser(1).enqueue(object :Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
                    Log.d(TAG, "delete: ${response.body()} ")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }

        })

    }
}
 */