package no.ntnu.henrbjoh;

public class SilverMembership extends Membership{

    private final float POINTS_SCALING_FACTOR = 1.2f;

    /**
     * Adds the new bonuspoints to the bonusPointBalance and accounts for the membership-perks
     *  And round to the closest integrer
     * @param bonusPointBalance the original balance of points
     * @param newPoints the new points, before adding the membership-extras
     * @return the new sum of bonuspoints
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints){
        return bonusPointBalance + Math.round(newPoints * POINTS_SCALING_FACTOR);
    }

    /**
     * Returns the grade/name of the membership
     * @return String with membership-name
     */
    @Override
    public String getMembershipName(){
        return "Silver";
    }
}
