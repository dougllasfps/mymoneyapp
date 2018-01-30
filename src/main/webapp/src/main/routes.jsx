import React from 'react'

import {Router, Route, Redirect, hasHistory} from 'react-router'

import DashBoard from '../dashboard/dashboard'
import BillingCycle from '../billingcycle/billingcycle'

export default props => (
    <Router history={hasHistory}>
        <Route path="/" component={DashBoard} />
        <Route path="/billingcycle" component={BillingCycle} />
        <Redirect from="*" to="/" />
    </Router>
)