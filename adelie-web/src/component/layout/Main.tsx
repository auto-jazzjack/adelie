import './main.less'
import Insidebar from './in-sidebar/in-sidebar';
import InSection from './in-section/in-section'
import InHeader from './header/in-header'
import InFooter from './footer/footer'
import * as Http from "http";
import React from "react";
//import {Project} from "../comunicate/http";
//import Header from './header/header';


/* Main Compoent */
const MainLayout: React.FC = () => {

    /* Renderer */
    return (
        <div>
            <InHeader/>
            <Insidebar/>
            <InSection children={Http}/>
            <InFooter/>
        </div>
    );
}

/* Exports */
export default MainLayout;