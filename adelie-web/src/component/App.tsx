import './App.css';
import store, {history} from '../store/store';

import React from 'react';
import {Provider} from 'react-redux';
import {Route, Switch} from 'react-router';
//import {Editor} from './comunicate/http';
import {ConnectedRouter} from 'connected-react-router';
import Main from "./layout/Main";


function App() {
    return (
        <Provider store={store}>
            <ConnectedRouter history={history}>
                <Switch>
                    <Route component={Main} />
                </Switch>
            </ConnectedRouter>
        </Provider>
    );
}

export default App;
