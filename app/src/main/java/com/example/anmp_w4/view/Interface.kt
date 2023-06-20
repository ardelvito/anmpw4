package com.example.anmp_w4.view

import android.view.View

interface ButtonDetailClickListener{
    fun onButtonDetailClick(v: View)
}

interface ButtonUploadClickListener{
    fun onButtonUploadDetailClick(v: View)
}

interface TextInputStudentID{
    fun onTextInputStudentID(v: View)
}

interface TextInputStudentName{
    fun onTextInputStudentName(v: View)
}

interface TextInputBirthDate{
    fun onTextInputStudentBirthDate(v: View)
}

interface TextInputPhone{
    fun onTextInputStudentPhone(v: View)
}