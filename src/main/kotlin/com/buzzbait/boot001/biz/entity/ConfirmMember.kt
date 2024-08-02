package com.buzzbait.boot001.biz.entity

import jakarta.persistence.*

@Entity
@Table(name = "confirmmember", schema = "kotlin")
class ConfirmMember(
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