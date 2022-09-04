package com.example.animelover.core.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Member(

    val id: Int =0,


    val birthday: String,


    val image: String,


    val squareImage: String,


    val description: String,


    val instrument: String,


    val romajiCV: String,


    val iAstrologicalSign: String,


    val cV: String,


    val foodDislike: String,


    val foodLike: String,


    val school: String,


    val name: String,

    val japaneseName: String,


    val iSchoolYear: String,


    val iBand: String,


    val isFavourite: Boolean
): Parcelable
