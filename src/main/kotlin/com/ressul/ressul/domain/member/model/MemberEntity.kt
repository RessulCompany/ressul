package com.ressul.ressul.domain.member.model

import com.ressul.ressul.common.type.OAuth2Provider
import com.ressul.ressul.global.entity.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.SQLRestriction

@Entity
@Table(name = "members")
@SQLDelete(sql = "UPDATE members SET is_deleted = true WHERE id = ?")
@SQLRestriction(value = "is_deleted = false")
class MemberEntity(
    @Column(name = "email", nullable = false, unique = true)
    val email: String,

    @Column(name = "nickname", nullable = false)
    var nickname: String,

    @Column(name = "profile_image_url", nullable = false)
    var profileImageUrl: String,

    @Column(name = "thumbnail_image_url", nullable = false)
    var thumbnailImageUrl: String,

    @Enumerated(EnumType.STRING)
    val provider: OAuth2Provider,

    val providerId: String,

    ) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name = "main_resume_id")
    var mainResumeId: Long? = null

    fun update(nickname: String, mainResumeId: Long) {
        this.nickname = nickname
        this.mainResumeId = mainResumeId
    }

}