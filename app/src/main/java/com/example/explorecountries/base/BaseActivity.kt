package com.example.explorecountries.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.explorecountries.common.View

open class BaseActivity : AppCompatActivity(), View {
    override fun showLoading() {
       Toast.makeText(this,"Loading ...",Toast.LENGTH_SHORT).show()
    }

    override fun dismissLoading() {
        Toast.makeText(this,"dismissing loading ...",Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: Throwable) {
        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
    }

}