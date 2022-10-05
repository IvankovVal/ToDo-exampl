package com.example.exampl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.exampl.databinding.DetaileDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DetailsDialog(var itemPosition: Int): BottomSheetDialogFragment() {

    private var binding:DetaileDialogBinding? = null

    private lateinit var model: TaskViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DetaileDialogBinding.inflate(inflater,container,false)


        model = ViewModelProviders.of(requireActivity()).get(TaskViewModel::class.java)

        //binding?.etNametaskDetails?.text = model.allTasks.value!![itemPosition].name.toString()

        //Кнопка выключения диалога
        binding?.btnCancel?.setOnClickListener {
            dialog?.cancel()
        }

        binding?.btnDelete?.setOnClickListener {
            val task = model.allTasks.value!![itemPosition]
            model.delete_task(task = task)
            dialog?.cancel()
        }

        binding?.btnEdit?.setOnClickListener {

            //положили в переменную конкретный пункт списка с которым будем работать
            val task = model.allTasks.value!![itemPosition]
            //в таск кладём id этого task и имя задачи из edittext
            model.update_task(task = Task(task.id, binding?.etNametaskDetails?.text.toString()))

            dialog?.cancel()
        }


        return binding?.root
    }
}