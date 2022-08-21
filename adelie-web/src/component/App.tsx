import './App.css';
import store, {history} from '../store/store';

import {Provider} from 'react-redux';
import {Route, Switch} from 'react-router';
import InHeader from "./layout/header/in-header";
import Footer from "./layout/footer/footer";
import {Http} from "./comunicate/http";
import {Project} from "./project";
import {Container, Segment} from 'semantic-ui-react';
import {ConnectedRouter} from "connected-react-router";
import React from 'react';

function App() {
    return (
        <Provider store={store}>
            <ConnectedRouter history={history}>
                <InHeader/>
                <Segment style={{margin: '3em 0em 0em', padding: '5em 0em'}}>
                    <Container text style={{marginTop: '7em'}}>
                        <Switch>
                            <Route component={Http} path="/" exact/>
                            <Route component={Project} path="/project" exact/>
                        </Switch>
                    </Container>
                </Segment>
                <Footer/>
            </ConnectedRouter>
        </Provider>
    );
}

export default App;
