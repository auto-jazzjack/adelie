import {
    Container, Dropdown, Image, Menu
} from 'semantic-ui-react';
import './in-header.less';

const InHeader = () => {

    return (
        <Menu fixed='top' inverted>
            <Container>
                <Menu.Item as='a' header>
                    <Image size='mini' src='/logo192.png' style={{marginRight: '1.5em'}}/>
                    Project Name
                </Menu.Item>
                <Menu.Item as='a' to="/">Home</Menu.Item>
                <Menu.Item as='a'>Manage Project</Menu.Item>

                <Dropdown item simple text='Dropdown'>
                    <Dropdown.Menu>
                        <Dropdown.Item>List Item</Dropdown.Item>
                        <Dropdown.Item>List Item</Dropdown.Item>
                        <Dropdown.Divider/>
                        <Dropdown.Header>Header Item</Dropdown.Header>
                        <Dropdown.Item>
                            <i className='dropdown icon'/>
                            <span className='text'>Submenu</span>
                            <Dropdown.Menu>
                                <Dropdown.Item>List Item</Dropdown.Item>
                                <Dropdown.Item>List Item</Dropdown.Item>
                            </Dropdown.Menu>
                        </Dropdown.Item>
                        <Dropdown.Item>List Item</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>
            </Container>
        </Menu>


    );
}

/* Exports */
export default InHeader;