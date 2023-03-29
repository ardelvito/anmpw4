package com.example.anmp_w4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anmp_w4.model.Student

class DetailViewModel: ViewModel() {
    val studentLD = MutableLiveData<ArrayList<Student>>()

    fun fetch(){
        studentLD.value = arrayListOf(
            Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
        )
//        studentLD.value = Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
    }
}