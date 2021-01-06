package com.binitasimbu.assignment5

import android.app.Activity
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.binitasimbu.assignment5.UserModel.ProfileData
import org.w3c.dom.Text

class SignUp_Activity : AppCompatActivity() {
    private val batch = arrayOf("25A","25B","25C","25D","25E")
    private lateinit var   tvRegister : TextView
    private lateinit var   etCuID : EditText
    private lateinit var   etFName : EditText
    private lateinit var  etLName  : EditText
    private lateinit var etUName: EditText
    private lateinit var    spbatch : Spinner
    private lateinit var    etPass : EditText
    private lateinit var   btnregister : Button
    private lateinit var tvlog:TextView

    private val listProfile=ArrayList<ProfileData>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_)
        tvRegister = findViewById(R.id.tvRegister)
        etCuID = findViewById(R.id.etCuID)
        etFName = findViewById(R.id.etFName)
        etLName = findViewById(R.id.etLName)
        etUName = findViewById(R.id.etUName)
        spbatch = findViewById(R.id.spbatch)
        etPass = findViewById(R.id.etPass)
        btnregister = findViewById(R.id.btnregister)
        tvlog=findViewById(R.id.tvlog)


        val adapter=ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1, batch

        )

        spbatch.setAdapter(adapter);
        spbatch.adapter = adapter
        spbatch.onItemSelectedListener=
                object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                    ) {
                        val selectedItem =parent?.getItemAtPosition(position).toString()
                        Toast.makeText(this@SignUp_Activity, selectedItem, Toast.LENGTH_LONG).show()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }
                }

        btnregister.setOnClickListener{
            val id=etCuID.text.toString()
            val profile=ProfileData(id.toInt(),etFName.text.toString(),etLName.text.toString(),etUName.text.toString(),etPass.text.toString(), spbatch.selectedItem.toString())
            val intent=Intent()
            intent.putExtra("userprofilelist",profile)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        tvlog.setOnClickListener {
            val intent = Intent(this, MainActivity ::class.java)
            startActivity(intent)
        }
    }
}