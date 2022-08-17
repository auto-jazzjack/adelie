export type Schema = {
    currentField: Set<String>
    nextField: Map<String, Schema>
}

export type Pair<K, V> = {
    key: K
    value: V

}