package com.javadataframe.models;

public class cars {

    private String buying;
    private String maint;
    private String doors;
    private String persons;
    private String lugBoot;
    private String safety;
    
    public String getBuying() {
        return buying;
    }
    public void setBuying(String buying) {
        this.buying = buying;
    }
    public String getMaint() {
        return maint;
    }
    public void setMaint(String maint) {
        this.maint = maint;
    }
    public String getDoors() {
        return doors;
    }
    public void setDoors(String doors) {
        this.doors = doors;
    }
    public String getPersons() {
        return persons;
    }
    public void setPersons(String persons) {
        this.persons = persons;
    }
    public String getLugBoot() {
        return lugBoot;
    }
    public void setLugBoot(String lugBoot) {
        this.lugBoot = lugBoot;
    }
    public String getSafety() {
        return safety;
    }
    public void setSafety(String safety) {
        this.safety = safety;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((buying == null) ? 0 : buying.hashCode());
        result = prime * result + ((maint == null) ? 0 : maint.hashCode());
        result = prime * result + ((doors == null) ? 0 : doors.hashCode());
        result = prime * result + ((persons == null) ? 0 : persons.hashCode());
        result = prime * result + ((lugBoot == null) ? 0 : lugBoot.hashCode());
        result = prime * result + ((safety == null) ? 0 : safety.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        cars other = (cars) obj;
        if (buying == null) {
            if (other.buying != null)
                return false;
        } else if (!buying.equals(other.buying))
            return false;
        if (maint == null) {
            if (other.maint != null)
                return false;
        } else if (!maint.equals(other.maint))
            return false;
        if (doors == null) {
            if (other.doors != null)
                return false;
        } else if (!doors.equals(other.doors))
            return false;
        if (persons == null) {
            if (other.persons != null)
                return false;
        } else if (!persons.equals(other.persons))
            return false;
        if (lugBoot == null) {
            if (other.lugBoot != null)
                return false;
        } else if (!lugBoot.equals(other.lugBoot))
            return false;
        if (safety == null) {
            if (other.safety != null)
                return false;
        } else if (!safety.equals(other.safety))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "cars [buying=" + buying + ", maint=" + maint + ", doors=" + doors + ", persons=" + persons
                + ", lugBoot=" + lugBoot + ", safety=" + safety + "]";
    }

    
    
}
