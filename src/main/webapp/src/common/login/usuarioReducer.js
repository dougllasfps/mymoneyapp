
const DEFAULT_STATE = {
    sessionUser : JSON.parse(localStorage.getItem('USER'))
}

export default function (state = DEFAULT_STATE, action){
    console.log(`State user: ${state.user}`)

    switch(action.type){
        case 'AUTHENTICATED_USER':
            localStorage.setItem('USER', JSON.stringify(action.payload) )
            return {...state, sessionUser: action.payload}
        case 'INVALIDATE_USER':
            localStorage.removeItem('USER')
            return {...state, sessionUser: {}}
        default:
            return state;
    }
}