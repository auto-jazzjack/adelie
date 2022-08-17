package io.adelie.admin.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@MappedSuperclass
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
