package io.adelie.springql.core.resolver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataFetchingEnv {

    private KeyValue<Object, Object> root;
    private KeyValue<Object, Object> nearRoot;

    public DataFetchingEnv setRoot(KeyValue<Object, Object> root) {
        this.root = root;
        return this;
    }

    public DataFetchingEnv setNearRoot(KeyValue<Object, Object> nearRoot) {
        this.nearRoot = nearRoot;
        return this;
    }
}
