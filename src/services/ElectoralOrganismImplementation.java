package services;

import data.DigitalSignature;
import data.Nif;
import data.Party;
import Exception.NoElectoralOrganismException;
import Exception.NoSignatureException;

public class ElectoralOrganismImplementation implements ElectoralOrganism {

    public boolean voterCanVote = true;

    @Override
    public boolean canVote(Nif nif) throws NoElectoralOrganismException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void disableVoter(Nif nif) throws NoElectoralOrganismException {
        voterCanVote = false;
    }

    @Override
    public DigitalSignature askForDigitalSignature(Party party) throws NoElectoralOrganismException, NoSignatureException{
        throw new UnsupportedOperationException();
    }
}
