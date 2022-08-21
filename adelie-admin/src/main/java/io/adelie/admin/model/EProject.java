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
public class EProject extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long projectId;

    @Column(
            nullable = false,
            unique = true
    )
    private String projectName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId")
    private EProvider eProvider;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId")
    private EConsumer eConsumer;

}
