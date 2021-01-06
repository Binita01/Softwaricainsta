package com.binitasimbu.assignment5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import  com.binitasimbu.assignment5.UserModel.ProfileData

class MainActivity : AppCompatActivity() {

    private lateinit var etUName : EditText
    private lateinit var etPass : EditText
    private lateinit var  tvforrgetpass : TextView
    private lateinit var btnIdLogin : Button
    private lateinit var tvsignup: TextView
    var etun:String="";
    var etpass:String="";
    var name:String="";
    var etCuID=""
    //    var img:String=""
    val userlist= arrayListOf<ProfileData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etUName =  findViewById(R.id.etUName)
        etPass =  findViewById(R.id.etPass)
        tvforrgetpass =  findViewById(R.id.tvforrgetpass)
        btnIdLogin =  findViewById(R.id.btnIdlogin)
        tvsignup =  findViewById(R.id.tvsignup)


        btnIdLogin.setOnClickListener {
            if (etUName.text.toString() == etun && etPass.text.toString() == etpass) {
                intent.putExtra("name",name)
                intent.putExtra("un",etun)
                val intent= Intent(this,Home_Activity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Welcome $name", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please Enter valid username and password", Toast.LENGTH_LONG)
                    .show()
            }
        }
        tvsignup.setOnClickListener{
            val req=1
            startActivityForResult(Intent(this,SignUp_Activity::class.java),req)

        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK) {
                var profile= data?.getParcelableExtra<ProfileData>("userprofilelist")
                userlist.add(profile!!)
                etCuID=userlist.get(0).cuid.toString()
                etun =userlist.get(0).uname.toString()
                etpass=userlist.get(0).password.toString()
                val fname=userlist.get(0).fname.toString()
                val lname=userlist.get(0).lname.toString()
                name="$fname $lname"
            }
        }
    }
}