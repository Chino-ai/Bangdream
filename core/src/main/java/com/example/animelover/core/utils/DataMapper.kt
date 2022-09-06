package com.example.animelover.core.utils


import com.example.animelover.core.data.source.local.entity.MemberEntity
import com.example.animelover.core.data.source.remote.response.MemberItem
import com.example.animelover.core.data.source.remote.response.MemberResponse
import com.example.animelover.core.domain.model.Member

object DataMapper {
    fun mapResponsesToEntities(input: List<MemberItem>): List<com.example.animelover.core.data.source.local.entity.MemberEntity> {
        val memberList = ArrayList<com.example.animelover.core.data.source.local.entity.MemberEntity>()
        input.map {
            val member = com.example.animelover.core.data.source.local.entity.MemberEntity(
                id = it.id,
                birthday = it.birthday,
                image = it.image,
                squareImage = it.squareImage,
                description = it.description,
                instrument = it.instrument,
                romajiCV = it.romajiCV,
                iAstrologicalSign = it.iAstrologicalSign,
                cV = it.cV,
                foodDislike = it.foodDislike,
                foodLike = it.foodLike,
                school = it.school,
                name = it.name,
                japaneseName = it.japaneseName,
                iSchoolYear = it.iSchoolYear,
                iBand = it.iBand,
                isFavourite = false


            )
            memberList.add(member)
        }
        return memberList
    }

    fun mapEntitiesToDomain(input: List<com.example.animelover.core.data.source.local.entity.MemberEntity>): List<Member> =
        input.map {
            Member(
                id = it.id,
                birthday = it.birthday,
                image = it.image,
                squareImage = it.squareImage,
                description = it.description,
                instrument = it.instrument,
                romajiCV = it.romajiCV,
                iAstrologicalSign = it.iAstrologicalSign,
                cV = it.cV,
                foodDislike = it.foodDislike,
                foodLike = it.foodLike,
                school = it.school,
                name = it.name,
                japaneseName = it.japaneseName,
                iSchoolYear = it.iSchoolYear,
                iBand = it.iBand,
                isFavourite = it.isFavourite
            )
        }

    fun mapDomainToEntity(input: Member) =
        com.example.animelover.core.data.source.local.entity.MemberEntity(
            id = input.id,
            birthday = input.birthday,
            image = input.image,
            squareImage = input.squareImage,
            description = input.description,
            instrument = input.instrument,
            romajiCV = input.romajiCV,
            iAstrologicalSign = input.iAstrologicalSign,
            cV = input.cV,
            foodDislike = input.foodDislike,
            foodLike = input.foodLike,
            school = input.school,
            name = input.name,
            japaneseName = input.japaneseName,
            iSchoolYear = input.iSchoolYear,
            iBand = input.iBand,
            isFavourite = input.isFavourite
        )
}
