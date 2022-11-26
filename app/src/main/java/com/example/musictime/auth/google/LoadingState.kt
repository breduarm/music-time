package com.example.musictime.auth.google

data class LoadingState(val status: Status, val msg: String? = null) {
    companion object {
        val SUCCESS = LoadingState(Status.SUCCESS)
        val IDLE = LoadingState(Status.IDLE)
        fun error(message: String?) = LoadingState(Status.FAILED, message)
    }
}

enum class Status {
    SUCCESS,
    IDLE,
    FAILED,
}
