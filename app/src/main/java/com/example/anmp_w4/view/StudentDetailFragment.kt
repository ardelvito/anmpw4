package com.example.anmp_w4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.anmp_w4.R
import com.example.anmp_w4.databinding.FragmentStudentDetailBinding
import com.example.anmp_w4.databinding.StudentListItemBinding
import com.example.anmp_w4.model.Student
import com.example.anmp_w4.util.loadImage
import com.example.anmp_w4.viewmodel.DetailViewModel
import com.example.anmp_w4.viewmodel.ListViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.student_list_item.*
import java.util.concurrent.TimeUnit


class StudentDetailFragment : Fragment(), ButtonUploadClickListener  {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentStudentDetailBinding

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_student_detail, container, false)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(
            inflater, R.layout.fragment_student_detail, container, false)

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val studentId = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
//
//        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
//        viewModel.fetch(studentId)
//
//        observeViewModel(view)

        if(arguments != null) {
            val studentId = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId

            viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            viewModel.readDetails(studentId)

            observeViewModel()

            dataBinding.listenerUpload = this
        }
    }

    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it
        })
    }

    override fun onButtonUploadDetailClick(v: View) {
        TODO("Not yet implemented")
        Toast.makeText(v.context, "Update Success", Toast.LENGTH_SHORT).show()

    }
}
