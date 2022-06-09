package com.mvvm.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Account(
    var userName : String,
    var phone : String
) : Parcelable
