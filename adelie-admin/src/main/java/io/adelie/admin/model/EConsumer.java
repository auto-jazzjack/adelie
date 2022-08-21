package io.adelie.admin.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EConsumer extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long consumerId;

    private Long projectId;
}
