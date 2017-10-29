import React from 'react'
import { Linking } from 'react-native'
import { Container, Header, Content, Card, CardItem, Body, Button, Text, Form, Input, Label, Item } from 'native-base';

export default class App extends React.Component {
  constructor (props) {
    super(props)
    Linking.addEventListener('url', async (str) => {
      let data = str.url.split('+').slice(-1).join('')
      if (this.state.seed === null) {
        this.setState((prevstate, props) => {
          this.notification()
          return Object.assign({}, prevstate, {seed: data})
        })
      } else {
        this.setState((prevstate, props) => {
          return Object.assign({}, prevstate, {message: data})
        })
      }
      // alert(data)
    })
    this.state = {
      seed: null,
      message: null
    }
  }
  componentWillMount () {

  }

  componentWillUnmount () {
    if (this.timer) {
      alert('timerout')
      clearTimeout(this.timer)
      this.timer = null
    }
  }

  vinculate () {
    ;(async () => {
      let data = await fetch('https://bd5c0ba9.ngrok.io/link')
      alert('Te llegará un enlace de vinculación')
    })()
  }

  notification () {
    setTimeout(() => {
      fetch('https://bd5c0ba9.ngrok.io/notification', {
        headers: {
          'ETag': null
        }
      })
    }, 1000)
  }

  render() {
    return (
      <Container>
        <Header />
          <Content>
            {!this.state.seed && !this.state.message && 
              <Form>  
                <Card>
              <CardItem header><Text>Vincula tu dispositivo</Text></CardItem>
                  <CardItem><Body>
                    <Item floatingLabel>
                      <Label>Teléfono</Label>
                      <Input keyboardType='phone-pad'  />
                    </Item>
                  </Body></CardItem>
                  <CardItem footer>
                      <Button onPress={() => this.vinculate()}>
                        <Text>Vincular</Text>
                      </Button>
                  </CardItem>
                </Card>
              </Form>
            }
            {this.state.seed && !this.state.message &&
              <Card>
                <CardItem>
                  <Text>Dispositivo Vinculado</Text>
                <CardItem>
              </Card>
            }
            {this.state.seed && this.state.message && 
              <Card>
                <Text>Tienes preaprobado un crédito</Text>
              </Card>
            }
          </Content>
      </Container>
    )
  }
}
