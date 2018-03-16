import axios from 'axios'
import {toastr} from 'react-redux-toastr'

import constants from './usuarioConstants'

const BASE_URL = process.env.SERVICE_URL;

export function logar(values){
    return sendRequest(values, `/api/users/auth?username=${values.username}&password=${values.password}`)
}

export function cadastrarUsuario(values){
    return sendRequest(values, '/api/users/signup')
}

export function logout(){
    return {
        type: 'INVALIDATE_USER',
        payload: null
    }
}

function sendRequest(values, url){
    return dispatch => {
        axios.post(`${BASE_URL}${url}`,values)
        .then( response => { 
            let user = response.data.data
            dispatch([{type: 'AUTHENTICATED_USER', payload: user}])
        })
        .catch( err => {
            console.log(`Ocorreu um erro ${err}`)            
        })
    }   
}