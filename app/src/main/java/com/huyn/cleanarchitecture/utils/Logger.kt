package com.huyn.cleanarchitecture.utils

import com.huyn.cleanarchitecture.BuildConfig

object Logger {
    private const val LOGGABLE = BuildConfig.LOGGABLE
    private const val TAG = "CUSTOM_TAG"
    init {
        com.orhanobut.logger.Logger.t(TAG)
    }

    fun d(message: String) {
        if (LOGGABLE) {
            com.orhanobut.logger.Logger.d(message)
        }
    }

    fun e(message: String) {
        if (LOGGABLE) {
            com.orhanobut.logger.Logger.e(message)
        }
    }

    fun e(throwable: Throwable, message: String) {
        if (LOGGABLE) {
            com.orhanobut.logger.Logger.e(message)
        }
    }

    fun w(message: String) {
        if (LOGGABLE) {
            com.orhanobut.logger.Logger.w(message)
        }
    }

    fun i(message: String) {
        if (LOGGABLE) {
            com.orhanobut.logger.Logger.i(message)
        }
    }

    fun json(message: String) {
        if (LOGGABLE) {
            com.orhanobut.logger.Logger.json(message)
        }
    }
}