package io.adelie.admin.model;


import lombok.*;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EService extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long serviceId;

    private String serviceName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serviceId")
    private EProvider eProvider;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serviceId")
    private EConsumer eConsumer;

}
