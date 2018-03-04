import axios from 'axios';
import {toastr} from 'react-redux-toastr'
import {selectTab,showTabs} from '../common/tab/tabActions'

import {reset, initialize} from 'redux-form'

const BASE_URL = process.env.SERVICE_URL;
const INITIAL_VALUES = {credits: [{}], debts: [{}]}


export function getList(){
    let request = axios.get(`${BASE_URL}/api/billingCycles`)
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
    console.log(values, method)
    let id = values.id ? values.id : '';
    return dispatch => {
        axios[method](`${BASE_URL}/api/billingCycles/${id}`, values)
        .then( resp => {
            toastr.success("Sucesso", "Operação realizada com sucesso.")
            dispatch(init())
        }).catch( e => {
            console.log(e, e.response.data, e.response)
            e.response.data.errors.forEach(error => {
                toastr.error("Erro", error)
            });
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
    console.log(billingCycle)
    return[
        showTabs('tabUpdate'),
        selectTab('tabUpdate'),
        initialize('billingCycleForm', billingCycle)
    ]
}

export function showDelete(billingCycle){
    console.log(billingCycle)
    return[
        showTabs('tabDelete'),
        selectTab('tabDelete'),
        initialize('billingCycleForm', billingCycle)
    ]
}