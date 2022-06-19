package io.adelie.springql.core.resolver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataFetchingEnv<K, V> {

    private KeyValue<K, V> root;
    private KeyValue<K, V> nearRoot;


    public DataFetchingEnv<K, V> setRoot(KeyValue<K, V> root) {
        this.root = root;
        return this;
    }

    public DataFetchingEnv<K, V> setNearRoot(KeyValue<K, V> nearRoot) {
        this.nearRoot = nearRoot;
        return this;
    }
}
