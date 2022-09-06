package com.example.animelover.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MemberResponse(

	@field:SerializedName("next")
	val next: String,

	@field:SerializedName("previous")
	val previous: String,

	@field:SerializedName("count")
	val count: Int,

	@field:SerializedName("results")
	val results: List<MemberItem>
) : Parcelable

@Parcelize
data class MemberItem(

	@field:SerializedName("birthday")
	val birthday: String,

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("square_image")
	val squareImage: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("instrument")
	val instrument: String,

	@field:SerializedName("romaji_CV")
	val romajiCV: String,

	@field:SerializedName("i_astrological_sign")
	val iAstrologicalSign: String,

	@field:SerializedName("CV")
	val cV: String,

	@field:SerializedName("food_dislike")
	val foodDislike: String,

	@field:SerializedName("food_like")
	val foodLike: String,

	@field:SerializedName("school")
	val school: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("japanese_name")
	val japaneseName: String,

	@field:SerializedName("i_school_year")
	val iSchoolYear: String,

	@field:SerializedName("i_band")
	val iBand: String
) : Parcelable
