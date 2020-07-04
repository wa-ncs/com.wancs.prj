package com.wancs.prj.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //[1]
@EntityListeners(AuditingEntityListener.class)//[2]
public abstract class BaseTimeEntity {

    @CreatedDate//[3]
    private LocalDateTime createdDate;

    @LastModifiedDate//[4]
    private LocalDateTime modifiedDate;
}
/**
 * [1] : JPA Entity클래스들이 BaseTimeEntity을 상속할 경우, 필드들(createdDate, modifiedDate)도
 *      컬럼으로 인식하도록 합니다.
 * [2] : BaseTimeEntity 클래스에 Auditing 기능을 포함시킵니다.
 * [3] : Entity가 생성되어 저장될 때 시간이 자동 저장 됩니다.
 * [4] : 조회한 Entity의 값을 변경할 때 시간이 자동저장 됩니다.
 */