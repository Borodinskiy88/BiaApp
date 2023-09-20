package ru.borodinskiy.aleksei.biaapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey
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
    val complete: Boolean = false,
    val textIncident: String = ""
)
