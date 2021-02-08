package no.ntnu.henrbjoh;

public class BasicMembership extends Membership {

    /**
     * Adds the new bonuspoints to the bonusPointBalance
     *  And round to the closest integrer
     * @param bonusPointBalance the original balance of points
     * @param newPoints the new points to be added to the point-balance
     * @return the new sum of bonuspoints
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints){
        return bonusPointBalance + newPoints;
    }

    /**
     * Returns the grade/name of the membership
     * @return String with membership-name
     */
    @Override
    public String getMembershipName(){
        return "Basic";
    }
}
