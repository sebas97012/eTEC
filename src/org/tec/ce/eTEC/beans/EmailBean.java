package org.tec.ce.eTEC.beans;

import org.tec.ce.eTEC.logic.EmailSenderService;

import javax.faces.bean.ManagedBean;

/**
 * Created by Arturo on 14/6/2017.
 */
@ManagedBean(name="email")
public class EmailBean {
    private String email;
    private String subject;
    private String message;

    public void sendEmail(){
        EmailSenderService.sendEmail(email, subject, message);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
