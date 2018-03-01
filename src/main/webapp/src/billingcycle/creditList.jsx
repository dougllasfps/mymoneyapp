import React from 'react'

import {connect} from 'react-redux'
import {bindActionCreators} from 'redux'
import {Field, arrayInsert} from 'redux-form'
import Input from '../common/form/input'
import Grid from '../common/layout/grid'

class CreditList extends React.Component{

    add(index, item = {}){
        arrayInsert('billingCyclesForm', 'credits', index, item)
    }

    renderRows(){
        const {list, readOnly} = this.props;
        console.log(list);
        if(!list){
            return;
        }

        return list.map( (item, index) =>{
            <tr key={index}>
                <td>
                    <Field component={Input} readOnly={readOnly} name={`credits[${index}].name`} />
                </td>
                <td>
                    <Field component={Input} readOnly={readOnly} name={`credits[${index}].value`} />
                </td>
                <td>
                    <button type="button" className="btn btn-success" onClick={this.add(index)}>
                        <i className="fa fa-plus"></i>
                    </button>

                    <button type="button" className="btn btn-warning" onClick={this.add(index,item)}>
                        <i className="fa fa-plus"></i>
                    </button>

                    <button type="button" className="btn btn-danger" >
                        <i className="fa fa-trash-o"></i>
                    </button>
                </td>
            </tr>
        })
    }

    render(){
        return(
            <Grid cols={this.props.cols}>
                <fieldset>
                    <legend>Créditos</legend>

                        <table className="table" >
                            <thead>
                                <tr>
                                    <th>Nome</th>
                                    <th>Valor</th>
                                    <th>Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.renderRows()}
                            </tbody>
                        </table>

                </fieldset>
            </Grid>
        )
    }
}

export default CreditList;