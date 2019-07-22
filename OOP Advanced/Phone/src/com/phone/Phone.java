package com.phone;

public abstract class Phone {
    private String versionNumber;
    private int batteryPercentage;
    private String carrier;
    private String ringTone;
    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }
    // abstract method. This method will be implemented by the subclasses
    public abstract void displayInfo();
    // getters and setters removed for brevity. Please implement them yourself
    public abstract String getVersionNumber();
    public abstract int getBatteryPercentage();
    public abstract String getCarrier();
    public abstract String getRingTone();
    public abstract void setVersionNumber(String versionNumber);
    public abstract void setBatteryPercentage(int batteryPercentage);
    public abstract void setCarrier(String carrier);
    public abstract void setRingTone(String ringTone);
}
