package com.yourssu.restful_api1

import com.google.gson.annotations.SerializedName

data class All(
        var data: List<CentersData>
)

data class CentersData(
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("centerName")
        val centerName: String= "",
        @SerializedName("sido")
        val sido: String = "",
        @SerializedName("sigungu")
        val sigungu: String = "",
        @SerializedName("facilityName")
        val facilityName: String = "",
        @SerializedName("zipCode")
        val zipCode: String = "",
        @SerializedName("address")
        val address: String = "",
        @SerializedName("lat")
        val lat: String = "",
        @SerializedName("lng")
        val lng: String = "",
        @SerializedName("createdAt")
        val createdAt: String = "",
        @SerializedName("updatedAt")
        val updatedAt: String = "",
        @SerializedName("centerType")
        val centerType: String = "",
        @SerializedName("org")
        val org: String = "",
        @SerializedName("phoneNumber")
        val phoneNumber: String = ""
)
