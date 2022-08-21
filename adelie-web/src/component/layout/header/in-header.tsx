import {Container, Image, Menu} from 'semantic-ui-react';
import './in-header.less';
import {NavLink} from "react-router-dom";

const InHeader = () => {
    return (
        <div>
            <Menu fixed='top' inverted>
                <Container>

                    <Menu.Item as='a' header to="/"><Image size='mini' src='/logo192.png'
                                                           style={{marginRight: '1.5em'}}/>Home</Menu.Item>
                    <Menu.Item as={NavLink} to="/project">
                    </Menu.Item>
                </Container>
            </Menu>
        </div>

    );
}

/* Exports */
export default InHeader;