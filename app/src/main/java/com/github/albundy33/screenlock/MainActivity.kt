package com.github.albundy33.screenlock

import android.app.Activity
import android.os.Bundle

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScreenLockUtil.lockNow(this, false)
        finish()
    }
}