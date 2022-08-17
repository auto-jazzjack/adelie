import React from 'react';

import './main.less'
import Insidebar from './in-sidebar/in-sidebar';
import InSection from './in-section/in-section'
import InHeader from './header/in-header'
import InFooter from './footer/footer'
import Http from "../comunicate/http/http";
//import {Editor} from "../comunicate/http";
//import Header from './header/header';


/* Main Compoent */
const MainLayout: React.FC = () => {

    /* Renderer */
    return (
        <div>
            <InHeader/>
            <Insidebar/>
            <InSection children={Http()}/>
            <InFooter/>
        </div>
    );
}

/* Exports */
export default MainLayout;