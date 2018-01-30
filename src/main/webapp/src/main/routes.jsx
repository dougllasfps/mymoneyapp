import React from 'react'

import {Router, Route, Redirect, hashHistory} from 'react-router'

import DashBoard from '../dashboard/dashboard'
import BillingCycle from '../billingcycle/billingcycle'

export default props => (
    <Router history={hashHistory}>
        <Route path="/" component={DashBoard} />
        <Route path="/billingcycle" component={BillingCycle} />
        <Redirect from="*" to="/" />
    </Router>
)