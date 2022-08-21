import React from 'react';
import {
    Container, Segment,
} from 'semantic-ui-react';
import './in-section.less';


const InSection: React.FC = ({children}) => {
    /* Renderer */
    return (
        <div>
            <Segment style={{margin: '3em 0em 0em', padding: '5em 0em'}}>
                <Container text style={{marginTop: '7em'}}>
                    {children}
                </Container>
            </Segment>
        </div>
    );
}

export default InSection;