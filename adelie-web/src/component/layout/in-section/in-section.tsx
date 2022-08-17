import React from 'react';
import {
    Container,
} from 'semantic-ui-react';
import './in-section.less';


const InSection: React.FC = ({children}) => {
    /* Renderer */
    return (
        <div>
            <Container text style={{marginTop: '7em'}}>
                {children}
            </Container>
        </div>
    );
}

export default InSection;