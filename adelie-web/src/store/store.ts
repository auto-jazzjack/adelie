import { applyMiddleware, combineReducers, createStore, compose, Middleware} from "redux"
import {connectRouter} from 'connected-react-router'
import { createBrowserHistory } from "history"

export const history = createBrowserHistory()

const root_reducer = combineReducers({
    router : connectRouter(history),
})
const devTools = (window as any).__REDUX_DEVTOOLS_EXTENSION__;


const composeEnhancers = devTools || compose;
const middlewares = [] as Middleware[]; 
const enhancer = composeEnhancers(applyMiddleware(...middlewares))
const initStatus = {}

const store = createStore(root_reducer,initStatus,enhancer)



export default store