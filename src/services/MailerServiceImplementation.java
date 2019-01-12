package services;

import data.DigitalSignature;
import data.MailAdress;
import Exception.NoMailerServiceException;

public class MailerServiceImplementation implements MailerService {

    public boolean mailSended = false;

    @Override
    public void send(MailAdress address, DigitalSignature signature) throws NoMailerServiceException {
        mailSended = true;
    }
}
