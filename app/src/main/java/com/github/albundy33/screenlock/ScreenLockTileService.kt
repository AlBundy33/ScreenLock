package com.github.albundy33.screenlock

import android.service.quicksettings.TileService
import android.service.quicksettings.Tile
import android.graphics.drawable.Icon
import androidx.annotation.RequiresApi
import android.os.Build

@RequiresApi(Build.VERSION_CODES.N)
class ScreenLockTileService : TileService() {
    override fun onStartListening() {
        qsTile?.apply {
            label = "ScreenLock"
            icon = Icon.createWithResource(this@ScreenLockTileService, R.drawable.ic_launcher_foreground)
            state = Tile.STATE_ACTIVE
            updateTile()
        }
    }

    override fun onClick() {
        ScreenLockUtil.lockNow(applicationContext, true)
    }
}