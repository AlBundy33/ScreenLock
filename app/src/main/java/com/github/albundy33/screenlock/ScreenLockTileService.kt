package com.github.albundy33.screenlock

import android.service.quicksettings.TileService
import android.service.quicksettings.Tile
import android.graphics.drawable.Icon

class ScreenLockTileService : TileService() {
    override fun onStartListening() {
        qsTile?.apply {
            label = getString(R.string.app_title)
            icon = Icon.createWithResource(this@ScreenLockTileService, R.drawable.rounded_lock_24)
            state = Tile.STATE_INACTIVE
            updateTile()
        }
    }

    override fun onClick() {
        ScreenLockUtil.lockNow(applicationContext, true)
    }
}