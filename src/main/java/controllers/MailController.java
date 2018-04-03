package controllers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import ninja.Result;
import ninja.Results;
import ninja.postoffice.Mail;
import ninja.postoffice.Postoffice;

@Singleton
public class MailController {

    @Inject
    Provider<Mail> provider;

    @Inject
    Postoffice postoffice;

    public Result mail() {
        sendMail();
        return Results.text().render("success");
    }

    public void sendMail() {
        Mail mail = provider.get();
        mail.setSubject("hello me");
        mail.setFrom("redtonernd@biz.redtone.com");
        mail.addTo("siewwingfei@hotmail.com");

        mail.setBodyHtml("hello me and again");

        try {
            postoffice.send(mail);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
