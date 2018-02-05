import React from 'react'
import MenuItem from './menuitem'
import MenuTree from './menutree'

export default props => (
    <ul className="sidebar-menu">
        <MenuItem path="#" label="Dashboard" icon="dashboard" />
        <MenuTree label="Cadastro" icon="edit">
            <MenuItem path="#/billingcycle" label="Ciclo de Pagamentos" icon="usd" />
        </MenuTree>
    </ul>
)