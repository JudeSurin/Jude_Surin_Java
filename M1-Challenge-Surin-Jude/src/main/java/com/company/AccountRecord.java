package com.company;

public class AccountRecord {
    private int charge;
    private String chargeDate;

    /**
     * getting the charge
     * @return returns the charge value
     */
    public int getCharge() {
        return charge;
    }

    /**
     * setting the charge
     * @param charge amount account charged
     */
    public void setCharge(int charge) {
        this.charge = charge;
    }

    /**
     *  getting the charge date
     * @return date charge occurred
     */
    public String getChargeDate() {
        return chargeDate;
    }

    /**
     * setting the charge date
     * @param chargeDate date we want to store in account record
     */
    public void setChargeDate(String chargeDate) {
        this.chargeDate = chargeDate;
    }
}
