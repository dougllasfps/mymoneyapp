import axios from 'axios'
import {toastr} from 'react-redux-toastr'
import {selectTab,showTabs} from '../common/tab/tabActions'
import {logout} from '../common/login/loginActions'

import {reset, initialize} from 'redux-form'

const BASE_URL = process.env.SERVICE_URL;
const INITIAL_VALUES = {credits: [{}], debits: [{}]}


export function getList(){
    const user = JSON.parse( localStorage.getItem("USER") )

    if(user === undefined){
        return dispatch => {
            dispatch[logout()]
        }
    }

    const requestUrl = `${BASE_URL}/api/billingCycles/user/${user.id}`

    const requestInstance = axios.create({
        headers: { Authorization: "Bearer " + user.token },
        method: 'GET',
        url: requestUrl
    })

    let request = requestInstance()
        
    return {
        type: 'BILLING_CYCLES_FETCHED',
        payload: request
    }
}

export function create(values){
    return submit(values, 'post')
}

export function update(values){
    return submit(values, 'put')
}

export function remove(values){
    return submit(values, 'delete')
}

function submit(values, method){
    console.log(`values: ${values}`)    
    
    const user = JSON.parse(localStorage.getItem("USER"))
    values.userId = user.id;

    let id = values.id ? values.id : '';

    if(user == undefined){
        return dispatch => {
            dispatch[logout()]
        }
    }

    const requestUrl = `${BASE_URL}/api/billingCycles/${id}`

    return dispatch => {
        axios[method](requestUrl, values, {
            headers: { Authorization: "Bearer " + user.token }
        })
        .then( resp => {
            toastr.success("Sucesso", "Operação realizada com sucesso.")
            dispatch(init())
        }).catch( e => {
            console.log(e, e.response.data, e.response)
            if(e.response.data.errors){
                
                e.response.data.errors.forEach(error => {
                    toastr.error("Erro", error)
                });
            }
        })
    }
}

export function init(){
    return[
        showTabs('tabList','tabCreate'),
        getList(),
        selectTab('tabList'),
        initialize('billingCycleForm', INITIAL_VALUES)
    ]
}

export function showUpdate(billingCycle){
    if(billingCycle.debits== undefined || billingCycle.debits.length == 0){
        billingCycle.debits = [{}];
    }

    if(billingCycle.credits== undefined || billingCycle.credits.length == 0){
        billingCycle.credits = [{}];
    }

    return[
        showTabs('tabUpdate'),
        selectTab('tabUpdate'),
        initialize('billingCycleForm', billingCycle)
    ]
}

export function showDelete(billingCycle){
    return[
        showTabs('tabDelete'),
        selectTab('tabDelete'),
        initialize('billingCycleForm', billingCycle)
    ]
}