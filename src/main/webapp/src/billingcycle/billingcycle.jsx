import React from 'react'

import {connect} from 'react-redux'
import {bindActionCreators} from 'redux'

import ContentHeader from '../common/template/contentHeader'
import Content from '../common/template/content'
import Tabs from '../common/tab/tabs'
import TabsContent from '../common/tab/tabsContent'
import TabsHeader from '../common/tab/tabsHeader'
import TabHeader from '../common/tab/tabHeader'
import TabContent from '../common/tab/tabContent'
import List from '../billingcycle/billingCycleList'
import Form from '../billingcycle/billingCycleForm'

import {selectTab, showTabs} from '../common/tab/tabActions'
import {create} from '../billingcycle/billingCycleActions'


class BillingCycles extends React.Component{

    componentWillMount(){
        this.props.selectTab('tabList');
        this.props.showTabs('tabList', 'tabCreate')
    }

    render(){
        return (
            <div>
                <ContentHeader title="Ciclo de Pagamentos" small="Cadastro" />
                <Content>
                    <Tabs>
                        <TabsHeader>
                            <TabHeader label="Listar" icon="bars" target="tabList" />
                            <TabHeader label="Incluir" icon="plus" target="tabCreate" />
                            <TabHeader label="Alterar" icon="pencil" target="tabUpdate" />
                            <TabHeader label="Excluir" icon="trash-o" target="tabDelete" />
                        </TabsHeader>
                        <TabsContent>
                            <TabContent id="tabList">
                                <List />
                            </TabContent>
                            <TabContent id="tabCreate">
                                <Form onSubmit={this.props.create} />
                            </TabContent>
                            <TabContent id="tabUpdate">
                                <Form />
                            </TabContent>
                            <TabContent id="tabDelete"><h1>Excluir</h1></TabContent>
                        </TabsContent>
                    </Tabs>
                </Content>
            </div>
        )
    }
}

const mapDispatchToProps = dispatch => bindActionCreators({selectTab, showTabs,create}, dispatch)

export default connect(null, mapDispatchToProps)(BillingCycles)