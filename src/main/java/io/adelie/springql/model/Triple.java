package io.adelie.springql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Triple<L, M, R> {
    private L left;
    private M middle;
    private R right;

    public static <L1, M1, R1> Triple<L1, M1, R1> of(L1 left, M1 middle, R1 right) {
        return Triple.<L1, M1, R1>builder()
                .left(left)
                .middle(middle)
                .right(right)
                .build();
    }
}
