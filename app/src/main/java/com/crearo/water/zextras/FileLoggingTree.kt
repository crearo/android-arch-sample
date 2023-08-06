package com.crearo.water.zextras

import android.util.Log
import timber.log.Timber
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class FileLoggingTree(private val dir: File) : Timber.Tree() {

    init {
        dir.mkdirs()
    }

    companion object {
        private val timeFormatter =
            DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.systemDefault())
        private val dateFormatter =
            DateTimeFormatter.ofPattern("yyyyMMdd").withZone(ZoneId.systemDefault())
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {

        val logEntry = "[${getCurrentTimestamp()}] [${getLogLevelString(priority)}]: $message\n"

        var fileWriter: FileWriter? = null
        try {
            val logFileDate = dateFormatter.format(Instant.now())
            val logFile = if (priority == Log.VERBOSE) {
                File(dir, "logs-${logFileDate}-verbose.txt")
            } else {
                File(dir, "logs-${logFileDate}.txt")
            }
            fileWriter = FileWriter(logFile, true)
            fileWriter.append(logEntry)
            fileWriter.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            fileWriter?.close()
        }
    }

    private fun getCurrentTimestamp(): String {
        return timeFormatter.format(Instant.now())
    }

    private fun getLogLevelString(priority: Int): String {
        return when (priority) {
            Log.VERBOSE -> "V"
            Log.DEBUG -> "D"
            Log.INFO -> "I"
            Log.WARN -> "W"
            Log.ERROR -> "E"
            else -> "U"
        }
    }
}
