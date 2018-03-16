import React from 'react'

import '../template/dependencies'

import {bindActionCreators} from 'redux'
import {connect} from 'react-redux'
import {reduxForm, Field} from 'redux-form'

import If from '../operator/if'

import Messages from '../../common/msg/messages'

import './login.css'

import {cadastrarUsuario, logar} from './loginActions'

class LoginForm extends React.Component{

    constructor(props){
        super(props)
        this.state = {loginMode: true}
    }

    changeMode(){
        this.setState({loginMode: !this.state.loginMode})
    }

    onSubmit(values){
        const {cadastrarUsuario,logar} = this.props
        this.state.loginMode ? logar(values) : cadastrarUsuario(values)
    }

    render(){
        const { handleSubmit } = this.props
        
        return(
            <div className="login-box">
                <div className="login-logo">
                    <b>My Money</b>
                </div>
                
                <div className="login-box-body">
                    <p className="login-box-msg">Sign in to start your session</p>

                    <form method="post" onSubmit={handleSubmit(values => this.onSubmit(values))}>

                        <If test={!this.state.loginMode}>
                            <div className="form-group has-feedback">
                                <Field component="input" type="text" className="form-control" placeholder="Digite seu nome" name="nome" />
                                <span className="glyphicon glyphicon-user form-control-feedback"></span>
                            </div>
                        </If>

                        <div className="form-group has-feedback">
                            <Field component="input" type="text" className="form-control" placeholder="Login" name="username" />
                            <span className="glyphicon glyphicon-envelope form-control-feedback"></span>
                        </div>

                        <div className="form-group has-feedback">
                            <Field component="input" type="password" className="form-control" placeholder="Senha" name="password" />
                            <span className="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>

                        <If test={!this.state.loginMode}>
                            <div className="form-group has-feedback">
                                <Field component="input" type="password" className="form-control" placeholder="Repita a Senha" name="passwordMatch" />
                                <span className="glyphicon glyphicon-lock form-control-feedback"></span>
                            </div>
                        </If>

                        <div className="row">
                            <div className="col-xs-8">
                                <div className="checkbox icheck">
                                    <label>
                                        <input type="checkbox"/> Lembrar
                                    </label>
                                </div>
                            </div>
                            <div className="col-xs-4">
                                <button type="submit" className="btn btn-primary btn-block btn-flat">{this.state.loginMode ?  'Entrar' : 'Cadastrar'}</button>
                            </div>
                        </div>

                    </form>

                    <a onClick={() => this.changeMode()} className="pointer">
                        {this.state.loginMode ? 'Novo usuário? Registrar aqui!' :
                            'Já é cadastrado? Entrar aqui!'}
                    </a>


                </div>
            </div>
        )
    }
}

LoginForm = reduxForm({form: 'formLogin'})(LoginForm)
const mapDispatchToProps = dispatch => bindActionCreators({cadastrarUsuario,logar}, dispatch)

export default connect(null, mapDispatchToProps)(LoginForm)