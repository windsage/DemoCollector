package com.chao.democollector

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chao.democollector.myview.act.CustomActivity
import com.chao.democollector.recyclerview.RecyclerActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        caseRecycler.onClick { startActivity<RecyclerActivity>() }
        myView.onClick { startActivity<CustomActivity>() }
    }
}
