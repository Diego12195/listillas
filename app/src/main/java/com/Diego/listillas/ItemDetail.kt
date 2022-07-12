package com.Diego.listillas

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText

class itemDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_detail, container, false)

        val saveButton = view.findViewById<Button>(R.id.saveItemButton)
        val deleteButton = view.findViewById<Button>(R.id.deleteItemButton)
        val cancelButton = view.findViewById<Button>(R.id.cancelItemButton)

        saveButton.setOnClickListener { saveButtonHandler(view) }
        deleteButton.setOnClickListener { deleteButtonHandler(view) }
        cancelButton.setOnClickListener { cancelButtonHandler(view) }

        return view
    }

    fun saveButtonHandler(view: View) {

    }

    fun deleteButtonHandler(view: View) {
        Log.d("ItemDetail", "Click on delete button: ")
    }
    fun cancelButtonHandler(view: View) {
        val title = view.findViewById<TextInputEditText>(R.id.titleField)
        val description = view.findViewById<TextInputEditText>(R.id.descriptionField)

        title.setText("")
        description.setText("")



    }
}