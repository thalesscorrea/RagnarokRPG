package com.example.thales.ragnarokrpg;

import java.io.Serializable;

public class Character implements Serializable {
    private Integer id;
    private String name;
    private String levelbase;
    private String leveljob;
    private String strength;
    private String agility;
    private String vitality;
    private String intelligence;
    private String dexterity;
    private String luck;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevelbase() {
        return levelbase;
    }

    public void setLevelbase(String levelbase) {
        this.levelbase = levelbase;
    }

    public String getLeveljob() {
        return leveljob;
    }

    public void setLeveljob(String leveljob) {
        this.leveljob = leveljob;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getAgility() {
        return agility;
    }

    public void setAgility(String agility) {
        this.agility = agility;
    }

    public String getVitality() {
        return vitality;
    }

    public void setVitality(String vitality) {
        this.vitality = vitality;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getDexterity() {
        return dexterity;
    }

    public void setDexterity(String dexterity) {
        this.dexterity = dexterity;
    }

    //We're up all night to
    public String getLuck() {
        return luck;
    }

    public void setLuck(String luck) {
        this.luck = luck;
    }

    public String toString(){
        return id + " - " + name;
    }
}
