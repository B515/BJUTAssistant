package cn.edu.bjut.bjutassistant.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cn.edu.bjut.bjutassistant.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { onBackPressed() }


    }

}
