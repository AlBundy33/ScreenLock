package com.github.albundy33.screenlock

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.Toast

object ScreenLockUtil {
    fun lockNow(context: Context, toast: Boolean) {
        val dpm = context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val component = ComponentName(context, ScreenLockDeviceAdminReceiver::class.java)

        if (dpm.isAdminActive(component)) {
            dpm.lockNow()
        } else if (toast) {
            Toast.makeText(context,
                context.getString(R.string.needs_admin_rights_message), Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
                putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, component)
                putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, context.getString(R.string.needs_admin_rights_message))
            }
            context.startActivity(intent)
        }
    }
}
