export type Schema = {
    currentField: Set<String>
    nextField: Map<String, Schema>
}

export type Pair<K, V> = {
    key: K
    value: V
}

export type Pageable = {
    page?: number,
    size?: number,
    sort?: string[],
};

export type PageRequest<T> = {
    body: T,
    pageable?: Pageable,
}

export type PageResponse<T> = {
    content: T[],
    last: boolean,
    totalPages: number,
    totalElements: number,
    sort: {
        unsorted: boolean,
        sorted: boolean,
        empty: boolean,
    },
    number: number,
    numberOfElements: number,
    first: boolean,
    empty: boolean,
};