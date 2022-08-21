import "./project.less"
import {Button, Table} from "semantic-ui-react";
import React from "react";
import {ProjectSearchResponse} from "../common/project/project";
import {fetcher} from "../../apis/apicaller";
import {getAllProject} from "../../apis/project/project";
import {PageResponse} from "../common/model";
import {ApiStatus} from "../../apis/type";

export const Project = () => {


    const [projects, setProjects] = React.useState<ApiStatus<PageResponse<ProjectSearchResponse>>>()

    React.useEffect(() => {
        fetcher(getAllProject(), setProjects);
    }, [])

    return (
        <div className="Project">
            <Button.Group floated="right" className="ProjectButton">
                <Button positive>New Project</Button>
                <Button negative>Delete Project</Button>
            </Button.Group>
            <Table>
                <Table.Header>
                    <Table.Row>
                        <Table.Cell>Name</Table.Cell>
                        <Table.Cell>CreateAt</Table.Cell>
                        <Table.Cell>UpdatedAt</Table.Cell>
                    </Table.Row>

                </Table.Header>
                <Table.Body>
                    {
                        projects?.data?.content
                            .map((k, v) => (
                                <Table.Row key={v}>
                                    <Table.Cell>{k.projectName}</Table.Cell>
                                    <Table.Cell>{k.createAt}</Table.Cell>
                                    <Table.Cell>{k.updatedAt}</Table.Cell>
                                </Table.Row>

                            ))
                    }
                </Table.Body>
            </Table>

        </div>
    )
}