package io.adelie.springql.core.resolver;

import lombok.Builder;
import lombok.Data;

@Data
public class DataFetchingEnv {

    private KeyValue root;
    private KeyValue nearRoot;

    public void changeRootNode(Object key, Object value) {

       /* switch (root.type) {
            case MAP:
            case LIST:
                root.key = key;
                root.value = value;
                break;
            default:
                root.value = value;
                break;
        }*/

    }


    public Object getConvertedRoot() {
       /* if (root == null) {
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
        }*/
        return null;
    }


    @Data
    @Builder
    static class KeyValue {
        private Object key;
        private Object value;
        //private Resolver.DataType type;

        public static KeyValue of(Object key, Object value/*, Resolver.DataType type*/) {
            return KeyValue.builder()
                    .key(key)
                    .value(value)
                    //.type(type)
                    .build();
        }
    }
}
