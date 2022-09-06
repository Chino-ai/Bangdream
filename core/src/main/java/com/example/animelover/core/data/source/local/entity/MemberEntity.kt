package com.example.animelover.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "member")
data class MemberEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int =0,

    @ColumnInfo(name = "birthday")
    val birthday: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "squareImage")
    val squareImage: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "instrument")
    val instrument: String,

    @ColumnInfo(name = "romajiCV")
    val romajiCV: String,

    @ColumnInfo(name = "iAstrologicalSign")
    val iAstrologicalSign: String,

    @ColumnInfo(name = "cV")
    val cV: String,

    @ColumnInfo(name = "foodDislike")
    val foodDislike: String,

    @ColumnInfo(name = " foodLike")
    val foodLike: String,

    @ColumnInfo(name = "school")
    val school: String,

    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "japaneseName")
    val japaneseName: String,

    @ColumnInfo(name = "iSchoolYear")
    val iSchoolYear: String,

    @ColumnInfo(name = "iBand")
    val iBand: String,

    @ColumnInfo(name = "isFavourite")
    var isFavourite: Boolean = false
)