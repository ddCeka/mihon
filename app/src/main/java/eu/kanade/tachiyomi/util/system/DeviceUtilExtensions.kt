package eu.kanade.tachiyomi.util.system

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import android.provider.Settings
import androidx.core.content.getSystemService
import com.google.android.material.color.DynamicColors

private const val LOW_RAM_THRESHOLD_BYTES = 3L * 1024 * 1024 * 1024 // 3 GB

private var cachedIsLowRam: Boolean? = null

val DeviceUtil.isDynamicColorAvailable by lazy {
    DynamicColors.isDynamicColorAvailable() ||
        (DeviceUtil.isSamsung && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
}

/**
 * Returns true if the device is flagged as low-RAM by the OS (Android Go)
 * or has total physical RAM at or below [thresholdBytes] (default 3 GB).
 * The result is cached in memory for fast repeated lookups.
 */
fun DeviceUtil.isLowRamDevice(
    context: Context,
    thresholdBytes: Long = LOW_RAM_THRESHOLD_BYTES,
): Boolean {
    cachedIsLowRam?.let { return it }

    val activityManager = context.getSystemService<ActivityManager>() ?: return false
    val isLowRam = if (activityManager.isLowRamDevice) {
        true
    } else {
        val memoryInfo = ActivityManager.MemoryInfo()
        activityManager.getMemoryInfo(memoryInfo)
        memoryInfo.totalMem <= thresholdBytes
    }

    cachedIsLowRam = isLowRam
    return isLowRam
}

/**
 * Returns true if the system has globally disabled animator durations
 * via Developer Options or Accessibility settings.
 */
fun DeviceUtil.areAnimationsDisabled(context: Context): Boolean {
    return try {
        Settings.Global.getFloat(
            context.contentResolver,
            Settings.Global.ANIMATOR_DURATION_SCALE,
            1f,
        ) == 0f
    } catch (_: Exception) {
        false
    }
}
