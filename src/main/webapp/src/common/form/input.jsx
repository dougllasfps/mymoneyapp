import React from 'react'

import If from '../../common/operator/if'

export default props => (
    <If test={props.render}>
        <input {...props.input}
            placeholder={props.placeholder}
            readOnly={props.readOnly}
            className="form-control"
            type={props.type} />
    </If>
)