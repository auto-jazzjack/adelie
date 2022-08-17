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
public class EService {

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
