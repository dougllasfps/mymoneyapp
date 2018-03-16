import { combineReducers } from 'redux'
import dashboardReducer from '../dashboard/dashboardReducer'
import tabReducer from '../common/tab/tabReducer'
import billingCycleReducer from '../billingcycle/billingCycleReducer'
import {reducer as formReducer} from 'redux-form'
import {reducer as toastrReducer} from 'react-redux-toastr'
import usuarioReducer from '../common/login/usuarioReducer'

const rootReducer = combineReducers({
    dashboard: dashboardReducer,
    tab: tabReducer,
    billingCycle: billingCycleReducer,
    form: formReducer,
    toastr: toastrReducer,
    user: usuarioReducer
})

export default rootReducer;