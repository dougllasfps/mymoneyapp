import '../common/template/dependencies'
import React from 'react'

import Header from '../common/template/header'
import SideBar from '../common/template/sidebar'
import Footer from '../common/template/rodape'
import Rotas from './routes'

export default props => (
    <div className='wrapper'>
      <Header />
      <SideBar />
        <div className="content-wrapper">
          <Rotas />
        </div>
      <Footer />
    </div>
)