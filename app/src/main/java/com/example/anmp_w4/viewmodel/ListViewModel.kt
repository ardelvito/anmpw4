package com.example.anmp_w4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.anmp_w4.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListViewModel(application: Application): AndroidViewModel(application){

    val studentsLiveData = MutableLiveData<ArrayList<Student>>()
    val studentsErrorLiveData = MutableLiveData<Boolean>()
    val loadingLiveData = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue:RequestQueue? = null

    fun refresh(){
        loadingLiveData.value = true
        studentsErrorLiveData.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Student>>() { }.type
                val result = Gson().fromJson<List<Student>>(it, sType)
                Log.d("result of student", result.toString())
                studentsLiveData.value = result as ArrayList<Student> /* = java.util.ArrayList<com.example.anmp_w4.model.Student> */
                Log.d("Test", it)

                loadingLiveData.value = false
                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
                studentsErrorLiveData.value = false
                loadingLiveData.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)

//        studentsLiveData.value = arrayListOf(
//            Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff"),
//            Student("13312","Rich","1994/12/14","3925444073","http://dummyimage.com/75x100.jpg/5fa2dd/ffffff"),
//            Student("11204","Dinny","1994/10/07","6827808747","http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1")
//        )
//
//        studentsErrorLiveData.value = false
//        loadingLiveData.value = false
    }
}