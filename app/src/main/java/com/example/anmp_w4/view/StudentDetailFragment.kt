package com.example.anmp_w4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.example.anmp_w4.R
import com.example.anmp_w4.model.Student
import com.example.anmp_w4.util.loadImage
import com.example.anmp_w4.viewmodel.DetailViewModel
import com.example.anmp_w4.viewmodel.ListViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.student_list_item.*


/**
 * A simple [Fragment] subclass.
 * Use the [StudentDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentDetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private val studentListAdapter = StudentListAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
//        viewModel.fetch()
        val studentId = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
        viewModel.readDetails(studentId)
        observeStudentData()

    }


    private fun observeStudentData() {
        viewModel.studentLD.observe(viewLifecycleOwner){


            val imgStudent = view?.findViewById<ImageView>(R.id.imageViewStudentDetail)
            val txtStudentName = view?.findViewById<TextInputEditText>(R.id.txtEditName)
            val txtStudentId = view?.findViewById<TextInputEditText>(R.id.txtEditId)
            val txtBirthDate = view?.findViewById<TextInputEditText>(R.id.txtEditBirth)
            val txtPhone = view?.findViewById<TextInputEditText>(R.id.txtEditPhone)

//            imgStudent?.setImageResource(it[0].photoUrl)
//            Picasso.get().load(it[0].photoUrl).into(imgStudent)
            txtStudentName?.setText(it.name.toString())
            txtStudentId?.setText(it.id.toString())
            txtBirthDate?.setText(it.dob.toString())
            txtPhone?.setText(it.phone.toString())
            imgStudent?.loadImage(it.photoUrl, progressBarDetail)

        }
    }

}