import axios from 'axios';

const BASE_URL = process.env.SERVICE_URL;

export function getList(){
    let request = axios.get(`${BASE_URL}/api/billingCycles`)
    return {
        type: 'BILLING_CYCLES_FETCHED',
        payload: request
    }
}

export function create(values){
    axios.post(`${BASE_URL}/api/billingCycles`, values)
    return {
        type : 'SENT'
    }
}