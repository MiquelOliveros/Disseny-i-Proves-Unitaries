package services;

import data.DigitalSignature;
import data.MailAdress;

/**
 * External service for sending mails
 */

public interface MailerService {
    void send(MailAdress address, DigitalSignature signature) throws NoMailerServiceException;
}
