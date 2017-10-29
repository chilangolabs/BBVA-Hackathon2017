const bodyParser = require('body-parser')
const express = require('express')
let app = express()
const accountSid = ''
const authToken = ''

const Twilio = require('twilio')
let client = new Twilio(accountSid, authToken)
app.use(bodyParser.json())

app.post('/link', async (req, res, next) => {
  try {
    await client.messages.create({
      body: `Hola Chris, vincula tu dispositivo exp://4m-h33.elxris.app.exp.direct:80/+${(0x11111111 + Math.floor(0xeeeeeeee * Math.random())).toString(16)}`,
      to: `+521${req.body.phone}`,
      from: '+15092958538'
    })
    res.sendStatus(200)
  } catch (err) {
    console.error(err)
    res.sendStatus(500)
  }
})

app.post('/notification', async (req, res, next) => {
  try {
    await client.messages.create({
      body: `Hola Chris, tienes una notificacion exp://4m-h33.elxris.app.exp.direct:80/+${(0x11111111 + Math.floor(0xeeeeeeee * Math.random())).toString(16)}`,
      to: `+521${req.body.phone}`,
      from: '+15092958538'
    })
    res.sendStatus(200)
  } catch (err) {
    console.error(err)
    res.sendStatus(500)
  }
})

app.listen('1337')
