import React from 'react'
import {Field, reduxForm, formValueSelector} from 'redux-form'
import FormGroup from '../common/form/formGroup'

import {connect} from 'react-redux'
import {bindActionCreators} from 'redux'

import {init} from '../billingcycle/billingCycleActions'
import ItemList from '../billingcycle/itemList'
import Summary from './summary'


class BillingCycleForm extends React.Component{

    calculateSummary() {
        const sum = (t, v) => t + v
        return {
            sumOfCredits: this.props.credits.map(c => +c.value || 0).reduce(sum),
            sumOfDebits: this.props.debits.map(d => +d.value || 0).reduce(sum)
        }
    }

    render(){
        const {handleSubmit, readOnly, submitClass, submitLabel, credits, debits} = this.props
        const {sumOfCredits,sumOfDebits} = this.calculateSummary();
        return(
            <form role="form" onSubmit={handleSubmit}>
                <div className="box-body">
                    <Field name="name" component={FormGroup} cols="12 4" readOnly={readOnly}
                           label="Nome" type="input" placeholder="Informe o nome" />
                    <Field name="month" component={FormGroup} cols="12 4" readOnly={readOnly}
                           label="Mês" type="number" placeholder="Informe o mês"  />
                    <Field name="ano" component={FormGroup} cols="12 4" readOnly={readOnly}
                           label="Ano" type="number" placeholder="Informe o ano" />
                           
                    <Summary credit={sumOfCredits} debit={sumOfDebits} />
                    <ItemList list={credits} readOnly={readOnly} field='credits' legend='Créditos' cols="12 6" />
                    <ItemList list={debits}  readOnly={readOnly} field='debits'  legend='Débitos'  cols="12 6" />
                </div>
                <div className="box-footer">
                    <button type="sumit" className={`btn btn-${submitClass}`}>{submitLabel ? submitLabel : 'Submit'}</button>
                    <button type="button" onClick={this.props.init} className="btn btn-default">Cancel</button>
                </div>
            </form>
        )
    }
}

const selector = formValueSelector('billingCycleForm')
const reduxFormConfig = {form: 'billingCycleForm', destroyOnUnmount: false};

BillingCycleForm = reduxForm(reduxFormConfig)(BillingCycleForm);

const mapDispatchToProps = dispatch => bindActionCreators({init}, dispatch)

const mapStateToProps = state => ({
    credits : selector(state, 'credits'),
    debits : selector(state, 'debits')
})

export default connect(mapStateToProps, mapDispatchToProps)(BillingCycleForm)