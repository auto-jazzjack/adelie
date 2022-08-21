import {Image, Menu, MenuItem} from 'semantic-ui-react';
import './in-header.less';
import {NavLink} from "react-router-dom";
import React from 'react';

const InHeader: React.FC = () => {
    return (
        <Menu fixed='top' inverted>
            <MenuItem as={NavLink} to="/">
                <Image size='mini' src='/logo192.png' style={{marginRight: '1.5em'}}/>Home
            </MenuItem>
            <MenuItem as={NavLink} to="/project">Manage Project</MenuItem>
        </Menu>);
}

/* Exports */
export default InHeader;