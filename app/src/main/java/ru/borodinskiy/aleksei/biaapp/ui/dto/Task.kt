package ru.borodinskiy.aleksei.biaapp.ui.dto

data class Task(
    val id: Int,
    val cargoType: String,
    val city: String,
    val date: String,
    val time: String,
    val startPoint: String,
    val finishPoint: String,
    val bodyType: String,
    val detail: String,
    val paymentParam: String,
    val telNumber: String,
    val name: String,
    val currentTask: Boolean = false,
    val complete: Boolean = false
)
