package com.buzzbait.boot001.infrastructure.dbms.master.jpa.entity

import com.buzzbait.boot001.infrastructure.dbms.master.jpa.entity.common.BaseEntity
import com.github.f4b6a3.ulid.UlidCreator
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.util.*


@Entity
@Table(name = "TB_BOARD", schema = "kotlin")
class BoardEntity (

    @Column(name = "NAME", nullable = true)
    var name : String,

) : BaseEntity(){

    @Column(name = "UU_ID", nullable = false,updatable= false,columnDefinition = "uuid")
    val uuid: UUID = UlidCreator.getMonotonicUlid().toUuid()

    @Column(name = "USE_YN", nullable = true)
    var useYN : String = "Y"
}