package com.example.wayangindonesia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wayang(
    var name: String,
    var description: String,
    var photo: Int,
    var country: String,
    var periode: String
) : Parcelable
