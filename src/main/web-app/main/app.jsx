import React from 'react';
import Header from '../templates/header'
import Footer from '../templates/footer'
import Rotas from './rotas'

export default class App extends React.Component{
    render(){
        return (
            <div className="container">
                <Header/>
                <Rotas/>
                <Footer/>
            </div>
        );
    }
}