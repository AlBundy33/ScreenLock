package com.github.albundy33.screenlock

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dpm = getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val admin = ComponentName(this, ScreenLockDeviceAdminReceiver::class.java)

        if (dpm.isAdminActive(admin)) {
            dpm.lockNow()
        } else {
            val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
                putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, admin)
                putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "Benötigt Adminrechte zum Sperren des Bildschirms.")
            }
            startActivity(intent)
        }

        finish()
    }
}