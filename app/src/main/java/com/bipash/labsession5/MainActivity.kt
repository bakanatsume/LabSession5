package com.bipash.labsession5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var rdoStudent : RadioButton
    private lateinit var rdoStaff : RadioButton
    private lateinit var rdoGroup : RadioGroup
    private lateinit var btnRegister : Button
    private  var selector = arrayOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner = findViewById(R.id.spinner)
        rdoStudent = findViewById(R.id.rdoStudent)
        rdoStaff = findViewById(R.id.rdoStaff)
        rdoGroup = findViewById(R.id.rdpGroup)
        btnRegister = findViewById(R.id.btnRegister)

       rdoGroup.setOnCheckedChangeListener(object:RadioGroup.OnCheckedChangeListener{
           override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
               when{
//                       (checkedId==R.id.rdoStaff)->
//(checkedId = R.id.rdoStudent)->
                   }
               }
       })

        val adapter =ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            selector
        )

        spinner.adapter =adapter
        spinner.onItemSelectedListener =
            object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedField = parent?.getItemAtPosition(position).toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }


        btnRegister.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("My Alert")
            builder.setMessage("Confirm Registration")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes"){
                dialogInterface, which ->
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
            }
            builder.setNeutralButton("Cancel"){
                dialogInterface, which ->
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("No"){
                dialogInterface, which ->
                Toast.makeText(this, "No", Toast.LENGTH_SHORT).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }
}