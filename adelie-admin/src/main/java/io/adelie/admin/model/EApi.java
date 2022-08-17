package io.adelie.admin.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EApi extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long apiId;

    private Long providerId;

    @OneToMany
    @JoinColumn(name = "apiId")
    private List<EApiConsumeDetail> detailApiContexts;
}
