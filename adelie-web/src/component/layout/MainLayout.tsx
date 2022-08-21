import './main.less'
import Insidebar from './in-sidebar/in-sidebar';
import InSection from './in-section/in-section'
import InHeader from './header/in-header'
import {ReactNode} from "react";
import Footer from  './footer/footer'
//import {Project} from "../comunicate/http";
//import Header from './header/header';

type MainLayoutProps = {
    node: ReactNode
}

/* Main */
const MainLayout = (props: MainLayoutProps) => {

    /* Renderer */
    return (
        <div>
            <InHeader/>
            <Insidebar/>
            <InSection children={props.node}/>
            <Footer/>
        </div>

    );
}

/* Exports */
export default MainLayout;