package services;

import data.DigitalSignature;
import data.Nif;
import data.Party;

/**
 * External service for signing votes and manage the electoral roll
 */

public interface ElectoralOrganism {
    boolean canVote(Nif nif) throws NoElectoralOrganismException;
    void disableVoter(Nif nif) throws NoElectoralOrganismException;
    DigitalSignature askForDigitalSignature(Party party) throws NoSignatureException, NoElectoralOrganismException;
}
