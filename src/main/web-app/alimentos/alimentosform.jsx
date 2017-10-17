import React from 'react';

export default class AlimentosForm extends React.Component{
    render(){
        return (
          <form>
              <label>Label</label>
              <input type="text" placeholder="Campo de texto" />
          </form>
        );
    }
}