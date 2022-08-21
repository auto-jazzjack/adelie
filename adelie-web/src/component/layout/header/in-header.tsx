import {Image, Menu} from 'semantic-ui-react';
import './in-header.less';
import {Link, NavLink} from "react-router-dom";
import React from 'react';

const InHeader = () => {
    return (
        <div>
            <Link to='/'>dasdasd</Link>
            <Menu fixed='top' inverted>
                <Menu.Item as='a' name="home" header to='/'><Image size='mini' src='/logo192.png'
                                                                   style={{marginRight: '1.5em'}}/>Home</Menu.Item>
                <Menu.Item as={NavLink} name="Manage Project" header to='/project'/>
            </Menu>
        </div>

    );
}

/* Exports */
export default InHeader;