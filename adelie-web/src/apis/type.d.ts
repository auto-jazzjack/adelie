export type ApiStatus<T> = {
    data?: T
    loading: boolean
    error?: Error
}

export type Error = {
    status: number
    message: string
}