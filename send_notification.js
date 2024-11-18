const nodemailer = require('nodemailer');

async function sendEmail() {
    let transporter = nodemailer.createTransport({
        service: 'gmail',
        auth: {
            user: 'your_email@gmail.com',  // Substitua pelo seu e-mail
            pass: 'your_password'         // Substitua pela sua senha ou app password
        },
    });

    let info = await transporter.sendMail({
        from: '"Pipeline Notifier" <your_email@gmail.com>',
        to: "destinatario@gmail.com",
        subject: "Status do Pipeline",
        text: `Workflow: ${process.env.GITHUB_WORKFLOW}
Repository: ${process.env.GITHUB_REPOSITORY}
Status: ${process.env.PIPELINE_STATUS}`,
    });

    console.log("Message sent: %s", info.messageId);
}

sendEmail().catch(console.error);