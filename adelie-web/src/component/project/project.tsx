import "./project.less"
import {Button} from "semantic-ui-react";
import {getAllProject} from "../../apis/project/project";
import {fetcher} from "../../apis/apicaller";
import React from "react";


export const Project = () => {


    const [projects, setProjects] = React.useState([])
    fetcher(getAllProject(), () => setProjects)

    //fetch all project list and render it

    return (
        <div className="Project">
            <Button.Group floated="right">
                <Button positive>New Project</Button>
                <Button negative>Delete Project</Button>
            </Button.Group>
            {projects?.map(project => (
                <div>{project}</div>
            ))}
        </div>
    )
}