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
public class EProvider {

    @Id
    @GeneratedValue
    private Long providerId;

    private Long serviceId;

    @OneToMany
    @JoinColumn(name = "providerId")
    private List<EApi> eApi;
}
