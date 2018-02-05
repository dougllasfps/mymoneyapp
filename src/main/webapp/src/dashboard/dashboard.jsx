import React from 'react'
import ContentHeader from '../common/template/contentHeader'
import Content from '../common/template/content'
import ValueBox from '../common/widget/valuebox'
import Row from '../common/layout/row'

import {getSummary} from './dashboardActions'

import {connect} from 'react-redux'
import {bindActionCreators} from 'redux'

class DashBoard extends React.Component{

    componentWillMount(){
        this.props.getSummary();
    }

    render(){
        const {credit, debt} = this.props.summary;
        return (
            <div>
                <ContentHeader title="DashBoard" small="1.0.0" />
                <Content>
                    <Row>
                        <ValueBox cols="12 4" color="green" icon="bank" value={`R$ ${credit}`} text="Total de Créditos"/>
                        <ValueBox cols="12 4" color="red" icon="credit-card" value={`R$ ${debt}`} text="Total de Débitos"/>
                        <ValueBox cols="12 4" color="blue" icon="money" value={`R$ ${credit - debt}`} text="Valor Consolidado"/>
                    </Row>
                </Content>
            </div>
        )
    }
}

const mapStateToProps = state => ({summary: state.dashboard.summary})
const mapDispatchToProps = dispatch => bindActionCreators({getSummary}, dispatch)

export default connect(mapStateToProps, mapDispatchToProps)(DashBoard)