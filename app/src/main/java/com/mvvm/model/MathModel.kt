package com.mvvm.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MathModel (
    var numberA: Float,
    var numberB: Float,
    var result: Float
    ) : Parcelable {
    fun NumberA(): String = "$numberA"
    fun NumberB(): String = "$numberB"
    fun Result(): String = "$result"

}