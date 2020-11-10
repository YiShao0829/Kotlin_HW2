package com.example.hw4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch

class MainActivity2 : AppCompatActivity() {
    lateinit var send_btn:Button
    lateinit var set_drink:EditText
    lateinit var rg1:RadioGroup
    lateinit var rg2:RadioGroup

    var sugar:String="無糖"
    var ice_opt:String="去冰"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //

        rg1=findViewById(R.id.radioGroup);
        rg1.setOnCheckedChangeListener{_,i->

                when(i)
                {
                    R.id.radioButton1 -> sugar="無糖"
                    R.id.radioButton2 -> sugar="少糖"
                    R.id.radioButton3 -> sugar="半糖"
                    R.id.radioButton4 -> sugar="全糖"
                }
            }



        rg2=findViewById(R.id.radioGroup2);
        rg2.setOnCheckedChangeListener{ _,i->

                when (i)
                {
                    R.id.radioButton5 -> ice_opt = "微冰"
                    R.id.radioButton6 -> ice_opt = "少冰"
                    R.id.radioButton7 -> ice_opt = "正常冰"
                }



        }
        send_btn=findViewById(R.id.btn_send);
        send_btn.setOnClickListener{
            set_drink=findViewById(R.id.ed_drink)
            val drink=set_drink.getText().toString()
            val i = Intent()
            val b = Bundle()
            b.putString("sugar",sugar)
            b.putString("drink",drink)
            b.putString("ice",ice_opt)
            i.putExtras(b)
            setResult(101,i)
            finish()


        }
        }
}