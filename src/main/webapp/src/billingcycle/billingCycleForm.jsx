import React from 'react'
import {Field, reduxForm} from 'redux-form'
import FormGroup from '../common/form/formGroup'

import {connect} from 'react-redux'
import {bindActionCreators} from 'redux'

import {init} from '../billingcycle/billingCycleActions'

class BillingCycleForm extends React.Component{

    render(){
        const {handleSubmit, readOnly, submitClass,submitLabel} = this.props
        return(
            <form role="form" onSubmit={handleSubmit}>
                <div className="box-body">
                    <Field name="name" component={FormGroup} cols="12 4" readOnly={readOnly}
                           label="Nome" type="input" placeholder="Informe o nome" />
                    <Field name="month" component={FormGroup} cols="12 4" readOnly={readOnly}
                           label="Mês" type="number" placeholder="Informe o mês"  />
                    <Field name="ano" component={FormGroup} cols="12 4" readOnly={readOnly}
                           label="Ano" type="number" placeholder="Informe o ano" />
                </div>
                <div className="box-footer">
                    <button type="sumit" className={`btn btn-${submitClass}`}>{submitLabel ? submitLabel : 'Submit'}</button>
                    <button type="button" onClick={this.props.init} className="btn btn-default">Cancel</button>
                </div>
            </form>
        )
    }
}

const reduxFormConfig = {form: 'billingCycleForm', destroyOnUnmount: false};
BillingCycleForm = reduxForm(reduxFormConfig)(BillingCycleForm);

const mapDispatchToProps = dispatch => bindActionCreators({init}, dispatch)

export default connect(null, mapDispatchToProps)(BillingCycleForm)