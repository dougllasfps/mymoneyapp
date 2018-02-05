import React from 'react'

import ContentHeader from '../common/template/contentHeader'
import Content from '../common/template/content'
import Tabs from '../common/tab/tabs'
import TabsContent from '../common/tab/tabsContent'

import TabsHeader from '../common/tab/tabsHeader'


export default class BillingCycles extends React.Component{
    render(){
        return (
            <div>
                <ContentHeader title="Ciclo de Pagamentos" small="Cadastro" />
                <Content>
                    <Tabs>
                        <TabsHeader>

                        </TabsHeader>
                        <TabsContent></TabsContent>
                    </Tabs>
                </Content>
            </div>
        )
    }
}