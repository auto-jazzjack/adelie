package io.adelie.springql.core.resolver;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Condition {

    private KeyValue root;

    public void changeRootNode(Object key, Object value, Resolver.DataType dataType) {
        root = KeyValue.of(key, value, dataType);
    }

    public void changeRootNodeKey(Object newKey) {
        if (root != null && !root.type.equals(Resolver.DataType.SINGLE)) {
            switch (root.type) {
                case MAP:
                case LIST:
                    root.key = newKey;
                default:
            }
        }
    }


    public Object getRoot() {
        if (root == null) {
            return null;
        } else {
            switch (root.type) {
                case MAP:
                    ((Map<Object, Object>) root.value).get(root.key);
                case LIST:
                    ((List<Object>) root.value).get((Integer) root.key);
                case SINGLE:
                default:
                    return root.value;
            }
        }
    }

    @AllArgsConstructor(staticName = "of")
    @Data
    static class KeyValue {
        private Object key;
        private Object value;
        private Resolver.DataType type;
    }
}
