import { combineReducers } from 'redux'
import dashboardReducer from '../dashboard/dashboardReducer'
import tabReducer from '../common/tab/tabReducer'
import billingCycleReducer from '../billingcycle/billingCycleReducer'
import {reducer as formReducer} from 'redux-form'

const rootReducer = combineReducers({
    dashboard: dashboardReducer,
    tab: tabReducer,
    billingCycle: billingCycleReducer,
    form: formReducer
})

export default rootReducer;