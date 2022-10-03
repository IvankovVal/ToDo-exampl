package com.example.exampl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders

class EditDialog (var itemPosition: Int): DialogFragment() {

    private lateinit var model: TaskViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.edit_dialog,container,false)
        val btn_cancel_update: Button = view.findViewById(R.id.btn_cancel_update)
        val btn_save_update: Button = view.findViewById(R.id.btn_save_update)
        val et_update: EditText = view.findViewById(R.id.et_edit_task)
        model = ViewModelProviders.of(requireActivity()).get(TaskViewModel::class.java)
//_____________________Установим название задачи в editText___________
        et_update.setText("Какой-то текст")

        //Кнопка выключения диалога
        btn_cancel_update.setOnClickListener {
            dialog?.cancel()
        }

        btn_save_update.setOnClickListener {

            model.delete_task(task = model.allTasks.value!![itemPosition]) //переписать на update
            dialog?.cancel()
        }

//        btn_edit.setOnClickListener {
//            Toast.makeText(context,"Пункт $itemPosition нажат", Toast.LENGTH_LONG).show()
//            val update_dialog = UpdateDialog(itemPosition)
//            val manager = supportFragmentManager
//            ditaile_dialog.show(manager,"add_dialog")
//            dialog?.cancel()
//        }


        return view
    }
}