import React from 'react'
import ReactDOM from 'react-dom'
import App from './main/app'
import reducers from './main/reducers'

import {createStore, applyMiddleware} from 'redux'
import {Provider} from 'react-redux'

import promisse from 'redux-promise'
import thunk from 'redux-thunk'
import multi from 'redux-multi'


const devTools = window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()

const appStore = applyMiddleware(promisse,thunk, multi)(createStore)(reducers, devTools);

ReactDOM.render(
    <Provider store={appStore}>
        <App />
    </Provider>
, document.getElementById('app')
)