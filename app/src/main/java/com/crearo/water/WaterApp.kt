package com.crearo.water

import android.app.Application
import com.crearo.water.zextras.FileLoggingTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import java.io.File

@HiltAndroidApp
class WaterApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree(), FileLoggingTree(File(filesDir, "logs")))
        Timber.i("WaterApp onCreate")
    }
}