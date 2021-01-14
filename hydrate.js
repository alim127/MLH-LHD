function sendmail(){
    const apiKey = process.env.SENDGRID_API_KEY;
    const sgMail = require('@sendgrid/mail')
    sgMail.setApiKey(apiKey)
    const msg = {
        to: 'UNKNOWNEMAIL', // Change to your recipient
        from: 'UNKNOWNEMAIL', // Change to your verified sender
        subject: 'Just a remainder...💖',
        image: url('https://wallpaperaccess.com/full/676556.jpg')
        text: 'Hey, I know you are busy, but remember to stay hydrated.Keep up the good work!',
    }
    sgMail
    .send(msg)
    .then(() => {
        console.log('Email sent')
    })
    .catch((error) => {
        console.error(error)
    })

}