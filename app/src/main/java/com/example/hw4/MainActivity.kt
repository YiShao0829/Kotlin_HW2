package com.example.hw4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var btn:Button
    lateinit var tv_meal:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        tv_meal=findViewById(R.id.tv_meal)
        //
        btn=findViewById(R.id.btn_choice)
        btn.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode : Int, resultCode : Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (data==null) return
        //
        if (resultCode==101)
        {
            var b = data.extras
            var str1:String? = b?.getString("drink");
            var str2:String?= b!!.getString("sugar");
            var str3:String?= b?.getString("ice");
            tv_meal.text = "飲料: $str1\n\n甜度: $str2\n\n冰塊: $str3\n\n"
        }
    }
}