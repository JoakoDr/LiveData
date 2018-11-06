package com.example.joaco.livedata

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.Observer
import android.text.BoringLayout
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val trabajo: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


    val edad: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


    val aprobar: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            changeText.text = newName + " tienes trabajo"
        }
        val nameObserver1 = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            changeText2.text = newName + " vas a aprobar"
        }
        val nameObserver2 = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            txtNumeros.setText(editText.text)
        }
         trabajo.observe(this,nameObserver)
        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                trabajo.postValue("Si");
            else
                trabajo.postValue("No");
        }
        aprobar.observe(this,nameObserver1)
        switch2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                aprobar.postValue("Si");
            else
                aprobar.postValue("No");
        }
        edad.observe(this,nameObserver2)
        editText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                txtNumeros.setText("Tu edad es : "+s)
            }
        })




    }



}

