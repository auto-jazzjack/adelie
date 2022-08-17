import {apiCaller} from "../apicaller";
import {AxiosPromise} from "axios";

export const getSchema = (): AxiosPromise<string> => apiCaller({
    method: "GET",
    url: "/schema"
})