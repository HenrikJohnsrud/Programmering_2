package no.ntnu.henrbjoh;

import java.time.LocalDate;

/**
 * BonusMember class holds the info of each member, keep track of the registration of new points
 * and the membership-level
 */
public class BonusMember{


    private int memberNumber;
    private LocalDate enrolledDate;
    private int bonusPointsBalance = 0;
    private String name;
    private String eMailAddress;
    private String password;
    private Membership membership;
    //skal lage objekter til bacis, silver, gold
    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

    /**
     * Constructor that pares the variables with each parameter
     * @param memberNumber the individual number of each member
     * @param enrolledDate the date with the membership was created
     * @param bonusPoints the start-bonuspoints
     * @param name name of the person that the membership is connected to
     * @param eMailAddress email-adress to the owner of the membership
     */
    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPoints, String name, String eMailAddress){

        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPoints;
        this.name = name;
        this.eMailAddress = eMailAddress;

        checkAndSetMembership();
    }

    /**
     * checkPassword conferms if a given password is equal to the registered to the membership
     * @param password the String that is checked up towards the password
     * @return true, if the check passes. false, if it is not the correct password
     */
    public boolean checkPassword(String password){
        if(password.equals(this.password)){
            return true;
        }
        return false;
    }


    /**
     * The method takes the bonusPointBalance and the points to be added
     *  and sends them both to be registered with the right membership-bonuses
     * @param newPoints the new point to be added to the pointBalance before bonuses are added
     */
    public void registerBonusPoints(int newPoints){
        this.bonusPointsBalance = membership.registerPoints(this.bonusPointsBalance,newPoints);
        checkAndSetMembership();
    }

    /**
     * The method checks the bonusPointBalance to the membership, and puts the membership
     *  on the right membership-level
     */
    public void checkAndSetMembership(){
        if (bonusPointsBalance<SILVER_LIMIT){
            membership = new BasicMembership();
        }
        else if(bonusPointsBalance >= SILVER_LIMIT && bonusPointsBalance < GOLD_LIMIT){
            membership = new SilverMembership();
        }
        else {
            membership = new GoldMembership();
        }
    }

    /**
     * @return The unique member-number registered to the membership
     */
    public int getMemberNumber() {
        return memberNumber;
    }

    /**
     * @return The date which the membership was signed
     */
    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    /**
     * @return The total amount of bonus-points registered to the membership
     */
    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    /**
     * @return The name of the person owning the membership
     */
    public String getName() {
        return name;
    }

    /**
     * @return The eMail to the person owning the membership
     */
    public String geteMailAddress() {
        return eMailAddress;
    }

    /**
     * @return The registered password to the membership
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return The membership-object
     */
    public Membership getMembership() {
        return membership;
    }

    /**
     * @return the point-limit to be a Silver-member
     */
    public static int getSilverLimit() {
        return SILVER_LIMIT;
    }
    /**
     * @return the point-limit to be a Gold-member
     */
    public static int getGoldLimit() {
        return GOLD_LIMIT;
    }

    /**
     * toString that returns the registered info of the membership
     * @return String with all the info
     */
    @Override
    public String toString() {
        return "BonusMember{" +
                ", memberNumber=" + memberNumber +
                ", enrolledDate=" + enrolledDate +
                ", bonusPointsBalance=" + bonusPointsBalance +
                ", name='" + name +
                ", eMailAddress='" + eMailAddress +
                ", membership=" + membership.getMembershipName() +
                "'}\n";
    }
}
