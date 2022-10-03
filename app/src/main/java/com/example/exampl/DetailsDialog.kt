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
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DetailsDialog(var itemPosition: Int): BottomSheetDialogFragment() {

    private lateinit var model: TaskViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.detaile_dialog,container,false)
        val btn_delete: ImageButton = view.findViewById(R.id.btn_delete)
        val btn_edit: ImageButton = view.findViewById(R.id.btn_edit)
        val btn_cancel: ImageButton = view.findViewById(R.id.btn_cancel)
        model = ViewModelProviders.of(requireActivity()).get(TaskViewModel::class.java)

        //Кнопка выключения диалога
        btn_cancel.setOnClickListener {
            dialog?.cancel()
        }

        btn_delete.setOnClickListener {

            model.delete_task(task = model.allTasks.value!![itemPosition])
            dialog?.cancel()
        }

        btn_edit.setOnClickListener {
            Toast.makeText(context,"Редактировать", Toast.LENGTH_LONG).show()
            val update_dialog = EditDialog(itemPosition)
            val manager = (context as FragmentActivity).supportFragmentManager
            update_dialog.show(manager,"update_dialog")

            //val fragmentTransaction = FragmentActivity.
            //update_dialog.replace( ,"update_dialog")
            dialog?.cancel()
        }


        return view
    }
}