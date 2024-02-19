package com.ressul.ressul.client.oauth2.kakao.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class KakaoUserProfileResponse(
    val nickname: String,
    val thumbnailImageUrl: String,
    val profileImageUrl: String,
    val isDefaultImage: String,
)