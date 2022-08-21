import {Image} from 'semantic-ui-react';
import './in-header.less';
import {Link} from "react-router-dom";
import React from 'react';

const InHeader: React.FC = () => {
    return (
        <div className="InHeader">
            <Link to="/">
                <Image size='mini' src='/logo192.png' style={{marginRight: '1.5em'}}/>Home
            </Link>
            <Link to="/project">
                Manage Project
            </Link>


        </div>);
}

/* Exports */
export default InHeader;