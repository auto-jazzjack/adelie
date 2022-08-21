import {apiCaller} from "../apicaller";
import {AxiosPromise} from "axios";
import {ProjectSearchResponse} from "../../component/common/project/project";

export const getAllProject = (): AxiosPromise<ProjectSearchResponse[]> => apiCaller({
    method: "GET",
    url: "/api/project/all"
})