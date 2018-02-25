import axios from 'axios';
import {toastr} from 'react-redux-toastr'
import {selectTab,showTabs} from '../common/tab/tabActions'

import {reset} from 'redux-form'

const BASE_URL = process.env.SERVICE_URL;

export function getList(){
    let request = axios.get(`${BASE_URL}/api/billingCycles`)
    return {
        type: 'BILLING_CYCLES_FETCHED',
        payload: request
    }
}

export function create(values){
    console.log(values)
    return dispatch => {
        axios.post(`${BASE_URL}/api/billingCycles`, values)
        .then( resp => {
            toastr.success("Sucesso", "Registro foi salvo com sucesso.")
            dispatch([
                reset('billingCycleForm'),
                getList(),
                selectTab('tabList'),
                showTabs('tabList', 'tabCreate')
            ])
        }).catch( e => {
            e.response.data.errors.forEach(error => {
                toastr.error("Erro", error)
            });
        })
    }
}

export function showUpdate(billingCycle){
    return[
        showTabs('tabUpdate'),
        selectTab('tabUpdate')
    ]
}