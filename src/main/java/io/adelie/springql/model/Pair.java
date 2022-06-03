package io.adelie.springql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pair<K, V> {
    private K key;
    private V value;

    public static <K1, V1> Pair<K1, V1> of(K1 key, V1 value) {
        return Pair.<K1, V1>builder()
                .key(key)
                .value(value)
                .build();
    }
}
