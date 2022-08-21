import './App.css';
import store, {history} from '../store/store';

import {Provider} from 'react-redux';
import {Route, Switch} from 'react-router';
//import {Project} from './comunicate/http';
import {ConnectedRouter} from 'connected-react-router';
import Main from "./layout/Main";
import {Project} from "./project";


function App() {
    return (
        <Provider store={store}>
            <ConnectedRouter history={history}>
                <Switch>
                    <Route component={Main} path="/" exact/>
                    <Route component={Project} path="/project" exact/>
                </Switch>
            </ConnectedRouter>
        </Provider>
    );
}

export default App;
