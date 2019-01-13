package services;

import data.DigitalSignature;
import data.Nif;
import data.Party;

import java.util.ArrayList;

public class implElectoralOrganism implements ElectoralOrganism {

    public boolean voterCanVoteBool = true;

    @Override
    public boolean canVote(Nif nif) throws NoElectoralOrganismException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void disableVoter(Nif nif) throws NoElectoralOrganismException {
        voterCanVoteBool = false;
    }

    @Override
    public DigitalSignature askForDigitalSignature(Party party) throws NoElectoralOrganismException, NoSignatureException{
        throw new UnsupportedOperationException();
    }
}
