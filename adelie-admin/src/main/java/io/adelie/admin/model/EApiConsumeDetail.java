package io.adelie.admin.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EApiConsumeDetail {

    @Id
    @GeneratedValue
    private Long apiConsumeDetailId;

    private Long apiId;

    private Long consumerId;

    @JoinColumn(
            name = "consumerId",
            insertable = false,
            updatable = false
    )
    @OneToOne(fetch = FetchType.LAZY)
    private EConsumer consumer;

    private Long throttle;


}
