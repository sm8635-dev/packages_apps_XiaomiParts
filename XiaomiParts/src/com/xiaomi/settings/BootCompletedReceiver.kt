/*
 * Copyright (C) 2023-2024 Paranoid Android
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.xiaomi.settings

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.UserHandle
import android.util.Log

import com.xiaomi.settings.battery.ChargingLimitService
import com.xiaomi.settings.display.ColorModeService

class BootCompletedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action ?: return
        val ctx = context ?: return

        if (DEBUG) Log.i(TAG, "Received intent: $action")

        when (action) {
            Intent.ACTION_LOCKED_BOOT_COMPLETED -> onLockedBootCompleted(ctx)
            Intent.ACTION_BOOT_COMPLETED -> onBootCompleted(ctx)
        }
    }

    private fun onLockedBootCompleted(context: Context) {
        // Display
        context.startServiceAsUser(
            Intent(context, ColorModeService::class.java),
            UserHandle.CURRENT
        )
        // Battery
        context.startServiceAsUser(
            Intent(context, ChargingLimitService::class.java),
            UserHandle.CURRENT
        )
    }

    private fun onBootCompleted(context: Context) {
    }

    companion object {
        private const val TAG = "XiaomiParts"
        private const val DEBUG = true
    }
}
