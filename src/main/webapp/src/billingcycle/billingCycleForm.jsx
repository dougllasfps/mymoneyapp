import React from 'react'
import {Field, reduxForm} from 'redux-form'
import FormGroup from '../common/form/formGroup'

class BillingCycleForm extends React.Component{

    render(){
        const {handleSubmit} = this.props
        return(
            <form role="form" onSubmit={handleSubmit}>
                <div className="box-body">
                    <Field name="name" component={FormGroup}
                           cols="12 4"
                           label="Nome" type="input" placeholder="Informe o nome" />
                    <Field name="month" component={FormGroup}
                           cols="12 4"
                           label="Mês" type="number" placeholder="Informe o mês"  />
                    <Field name="ano" component={FormGroup} 
                           cols="12 4"
                           label="Ano" type="number" placeholder="Informe o ano" />
                </div>
                <div className="box-footer">
                    <button type="sumit" className="btn btn-default">Submit</button>
                </div>
            </form>
        )
    }
}

export default reduxForm({form: 'billingCycleForm'})(BillingCycleForm)