import React from 'react'
import ContentHeader from '../common/template/contentHeader'
import Content from '../common/template/content'
import ValueBox from '../common/widget/valuebox'
import Row from '../common/layout/row'

export default class DashBoard extends React.Component{
    render(){
        return (
            <div>
                <ContentHeader title="DashBoard" small="1.0.0" />
                <Content>
                    <Row>
                        <ValueBox cols="12 4" color="green" icon="bank"
                                    value="R$ 10,00" text="Total de Créditos"/>
                        <ValueBox cols="12 4" color="red" icon="credit-card"
                                    value="R$ 10,00" text="Total de Débitos"/>
                        <ValueBox cols="12 4" color="blue" icon="money"
                                    value="R$ 10,00" text="Valor Consolidado"/>
                    </Row>
                </Content>
            </div>
        )
    }
}