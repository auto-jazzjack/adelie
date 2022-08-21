import {Image, Menu} from 'semantic-ui-react';
import './in-header.less';

const InHeader = () => {
    return (
        <div>

                <Menu fixed='top' inverted>

                    <Menu.Item as='a' header to="/"><Image size='mini' src='/logo192.png'
                                                           style={{marginRight: '1.5em'}}/>Home</Menu.Item>
                    <Menu.Item as='a' header to="/project">Manage Project</Menu.Item>
                </Menu>

        </div>

    );
}

/* Exports */
export default InHeader;