import '../common/template/dependencies'
import React from 'react'

import Header from '../common/template/header'
import SideBar from '../common/template/sidebar'
import Footer from '../common/template/rodape'
import Rotas from './routes'

import Login from '../common/login/login'

import Messages from '../common/msg/messages'

import {connect} from 'react-redux'

const Aplication = (props) => (
    <div className='wrapper'>
      <Header />
      <SideBar />
        <div className="content-wrapper">
          <Rotas />
        </div>
      <Footer />
      <Messages />
    </div>
)

class App extends React.Component{
    render(){
      console.log(`usuario: ${this.props.user} `);

      if(this.props.user && this.props.user.id){
        return (
          <Aplication />
        )
      }else{
          return (
            <Login />
          )
      }
    }
}

const mapStateToProps = state => ({
    user : state.user.sessionUser
})

export default connect(mapStateToProps)(App)