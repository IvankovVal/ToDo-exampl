package com.example.exampl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders

class CLickDialog: DialogFragment() {

    private lateinit var model: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    val view: View = inflater.inflate(R.layout.detaile_dialog,container,false)
    val btn_delete: ImageButton = view.findViewById(R.id.btn_delete)
    val btn_edit: ImageButton = view.findViewById(R.id.btn_edit)
    val btn_cancel: Button = view.findViewById(R.id.btn_cancel)
    model = ViewModelProviders.of(this).get(TaskViewModel::class.java)

    //Кнопка отмены
    btn_cancel.setOnClickListener {
        dialog?.cancel()
    }

//    btn_delete.setOnClickListener {
//        //удаление
//        model.delete_task(Task())
//        dialog?.cancel()
//    }

    btn_edit.setOnClickListener {
        //редактирование
        dialog?.cancel()
    }


    return view

}}
