package com.huyn.cleanarchitecture.presentation.base

import androidx.appcompat.app.AppCompatActivity
import com.huyn.cleanarchitecture.utils.extension.displayKeyboard

abstract class BaseActivity : AppCompatActivity() {

    override fun onPause() {
        super.onPause()
        displayKeyboard(false)
    }
}