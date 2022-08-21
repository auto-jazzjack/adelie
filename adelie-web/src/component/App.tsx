import './App.css';
import store, {history} from '../store/store';

import {Provider} from 'react-redux';
import {Route, Switch} from 'react-router';
//import {Project} from './comunicate/http';
import {ConnectedRouter} from 'connected-react-router';
import MainLayout from "./layout/MainLayout";
import {Project} from "./project";
import {Http} from "./comunicate/http";

//import {Http} from "./comunicate/http";


function App() {
    return (
        <Provider store={store}>
            <ConnectedRouter history={history}>
                <Switch>
                    <Route render={() => <MainLayout node={Http()}/>} path="/" exact/>
                    <Route render={() => <MainLayout node={Project()}/>} path="/project" exact/>
                </Switch>
            </ConnectedRouter>
        </Provider>
    );
}

export default App;
