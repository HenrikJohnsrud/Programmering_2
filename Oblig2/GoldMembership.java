package no.ntnu.henrbjoh;

public class GoldMembership extends Membership{

    private final float POINTS_SCALING_FACTOR_LEVEL1 = 1.3f;
    private final float POINTS_SCALING_FACTOR_LEVEL2 = 1.5f;

    /**
     * Adds the new bonuspoints to the bonusPointBalance and accounts for the membership-perks
     *  And round to the closest integrer
     * @param bonusPointBalance the original balance of points
     * @param newPoints the new points, before adding the membership-extras
     * @return the new sum of bonuspoints
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints){
        if (bonusPointBalance < 90000) {
            return bonusPointBalance + Math.round(newPoints * POINTS_SCALING_FACTOR_LEVEL1);
        }
        return bonusPointBalance + Math.round(newPoints * POINTS_SCALING_FACTOR_LEVEL2);
    }

    /**
     * Returns the grade/name of the membership
     * @return String with membership-name
     */
    @Override
    public String getMembershipName(){
        return "Gold";
    }
}
