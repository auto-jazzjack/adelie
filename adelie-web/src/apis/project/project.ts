import {apiCaller} from "../apicaller";
import {AxiosPromise} from "axios";
import {ProjectSearchResponse} from "../../component/common/project/project";
import {PageResponse} from "../../component/common/model";

export const getAllProject = (): AxiosPromise<PageResponse<ProjectSearchResponse>> => {
    return apiCaller({
        method: "GET",
        url: "/api/project/all"
    })
}