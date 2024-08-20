package com.buzzbait.boot001.legacy.biz.member.entity

import jakarta.persistence.*

@Entity
@Table(name = "confirmmember", schema = "kotlin")
class ConfirmMemberEntity(
    @Column(name = "myid", nullable = false)
    var myId : Long,

    @Column(name = "confirmid", nullable = false)
    var confirmid : Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable= false)
    var  id :Long = 0;
}