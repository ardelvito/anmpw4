package com.example.anmp_w4.view

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.anmp_w4.R
import com.example.anmp_w4.databinding.StudentListItemBinding
import com.example.anmp_w4.model.Student
import com.example.anmp_w4.util.loadImage

class StudentListAdapter(val studentList:ArrayList<Student>): RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(),
    ButtonDetailClickListener {
    class StudentViewHolder(var view: StudentListItemBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater, R.layout.student_list_item, parent, false)
        return  StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

        holder.view.student = studentList[position]
        holder.view.listener = this
//        holder.view.findViewById<TextView>(R.id.txtId).text = studentList[position].id
//        holder.view.findViewById<TextView>(R.id.txtStudentName).text = studentList[position].name
//
//        var imageView = holder.view.findViewById<ImageView>(R.id.imgStudentProfile)
//        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
//        imageView.loadImage(studentList[position].photoUrl, progressBar)
//
//        var studentId = studentList[position].id
//        holder.view.findViewById<Button>(R.id.btnDetail).setOnClickListener{
//
//            val action = StudentListFragmentDirections.actionStudentDetail(studentId.toString())
//            Navigation.findNavController(it).navigate(action)
//        }

    }

    fun updateStudentList(newStudentList:ArrayList<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onButtonDetailClick(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }

}