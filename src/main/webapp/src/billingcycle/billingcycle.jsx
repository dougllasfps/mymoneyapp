import React from 'react'

import ContentHeader from '../common/template/contentHeader'
import Content from '../common/template/content'
import Tabs from '../common/tab/tabs'
import TabsContent from '../common/tab/tabsContent'

import TabsHeader from '../common/tab/tabsHeader'
import TabHeader from '../common/tab/tabHeader'

export default class BillingCycles extends React.Component{
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
                        <TabsContent></TabsContent>
                    </Tabs>
                </Content>
            </div>
        )
    }
}