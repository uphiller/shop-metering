package com.shop.metering.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
public class CommonEntity {

    @Comment("등록일시")
    @CreationTimestamp
    @Column
    private LocalDateTime regDt;

    @Comment("수정일시")
    @UpdateTimestamp
    @Column
    private LocalDateTime modDt;
}
