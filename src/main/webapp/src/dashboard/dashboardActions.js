import axios from 'axios'

const BASE_URL = process.env.SERVICE_URL;

export function getSummary(){
    const request = axios.get(`${BASE_URL}/api/billingCycles/summary`)

    return {
        type: 'BILLING_SUMMARY_FETCHED',
        payload: request
    }
}