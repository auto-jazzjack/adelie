//import React from "react";
//import {Pair, Schema} from "../common/model";
/*import {Parser} from "../common/parser";
import {getSchema} from "../../apis/schema";
import {fetcher, initStatus} from "../../apis/apicaller";
import {ApiStatus} from "../../apis/type";*/

import "./project.less"
import {Button} from "semantic-ui-react";

export const Project = () => {

    //fetch all project list and render it

    return (
        <div className="Project">
            <Button.Group floated="right">
                <Button positive>New Project</Button>
                <Button negative>Delete Project</Button>
            </Button.Group>
        </div>
    )
}