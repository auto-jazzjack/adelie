import axios, {AxiosError, AxiosPromise} from "axios";
import {ApiStatus, Error} from "./type";

export const apiCaller = axios.create()

export function initStatus<T>(): ApiStatus<T> {
    return {
        loading: true
    } as ApiStatus<T>
}

function errorGenerator(error: AxiosError | null): Error {
    if (error == null) {
        return {
            status: 0,
            message: "unknown"
        }
    } else {
        if (error.response != null) {
            return {
                status: error.response?.status,
                message: error.response.data.message

            }
        } else {
            return {
                status: 500,
                message: "unknown"
            }
        }
    }

}

export function fetcher<T>(result: AxiosPromise<T>, stateUpdater: React.Dispatch<React.SetStateAction<ApiStatus<T>>>) {

    result
        .then(res => {
            let value = res.data
            stateUpdater({
                loading: false,
                data: value,
            })
        })
        .catch(throwable => {
            stateUpdater({
                loading: false,
                error: errorGenerator(throwable)
            })
        })

}