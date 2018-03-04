import React from 'react'

export default props => (
    <input {...props.input}
        placeholder={props.placeholder}
        readOnly={props.readOnly}
        className="form-control"
        type={props.type} />
)