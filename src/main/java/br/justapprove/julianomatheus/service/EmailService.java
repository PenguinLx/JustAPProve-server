package br.justapprove.julianomatheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
@Service
public class EmailService {
	 @Autowired
	    private JavaMailSender mailSender;
	public void enviarEmail(String para, String assunto, String texto) {
        try {
            // Cria a mensagem MIME
            MimeMessage mensagem = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensagem, true);

            // Configura o destinatário, assunto e texto
            helper.setTo(para);
            helper.setSubject(assunto);
            helper.setText(texto, true); // `true` para HTML, `false` para texto simples
            
            // Configura o remetente com InternetAddress
            helper.setFrom(new InternetAddress("no-reply@justapprove.com", "JustAPProve"));

            // Envia o e-mail
            mailSender.send(mensagem);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao enviar e-mail: " + e.getMessage());
        }
    }
}
