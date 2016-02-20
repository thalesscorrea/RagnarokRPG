package com.example.thales.ragnarokrpg;

import android.util.Log;

import java.io.Serializable;
import java.util.Random;

public class Character implements Serializable {
    private Integer id;
    private String name;
    private String classe;
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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
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

    public String getMeleeDamage() {

        int strengthDamage = Integer.parseInt(this.getStrength())/10;
        int strengthBonusDamage = Integer.parseInt(this.getStrength())/100;
        int dexterityDamage = Integer.parseInt(this.getDexterity())/50;
        int luckDamage = Integer.parseInt(this.getLuck())/50;

        int numberOfDices = strengthDamage+strengthBonusDamage+dexterityDamage+luckDamage;

        Random dice = new Random();
        String meleeDamage = null;
        for (int i = 0 ; i<numberOfDices ; i++){
            if(i==0){
                int roll = dice.nextInt(10)+1;
                meleeDamage = String.valueOf(roll);
                i++;
            }
            int roll = dice.nextInt(10)+1;
            meleeDamage = meleeDamage + "+" + String.valueOf(roll);
        }
        return meleeDamage;
    }

    public String getRangedDamage() {
        int strengthDamage = Integer.parseInt(this.getStrength())/50;
        int dexterityDamage = Integer.parseInt(this.getDexterity())/10;
        int dexterityBonusDamage = Integer.parseInt(this.getDexterity())/100;
        int luckDamage = Integer.parseInt(this.getLuck())/50;

        int numberOfDices = strengthDamage+dexterityDamage+dexterityBonusDamage+luckDamage;

        Random dice = new Random();
        String rangedDamage = null;
        for (int i = 0 ; i<numberOfDices ; i++){
            if(i==0){
                int roll = dice.nextInt(10)+1;
                rangedDamage = String.valueOf(roll);
                i++;
            }
            int roll = dice.nextInt(10)+1;
            rangedDamage = rangedDamage + "+" + String.valueOf(roll);
        }
        return rangedDamage;
    }

    public String getMagicDamage() {
        int intelligenceDamage = Integer.parseInt(this.getIntelligence())/10;
        int intelligenceBonusDamage = Integer.parseInt(this.getIntelligence())/20;
        int dexterityDamage = Integer.parseInt(this.getDexterity())/50;
        int luckDamage = Integer.parseInt(this.getLuck())/50;

        int numberOfDices = intelligenceDamage+intelligenceBonusDamage+dexterityDamage+luckDamage;

        Random dice = new Random();
        String magicDamage = null;
        for (int i = 0 ; i<numberOfDices ; i++){
            if(i==0){
                int roll = dice.nextInt(10)+1;
                magicDamage = String.valueOf(roll);
                i++;
            }
            int roll = dice.nextInt(10)+1;
            magicDamage = magicDamage + "+" + String.valueOf(roll);
        }
        return magicDamage;
    }

    public String getPrecision() {
        int dexterityPrecision = Integer.parseInt(this.getDexterity());
        int luckPrecision = Integer.parseInt(this.getLuck())/3;
        int precision = 175+dexterityPrecision+luckPrecision;

        Random dice = new Random();
        int roll = dice.nextInt(10)+1;
        String precisionRoll = String.valueOf(precision*roll);
        return precisionRoll;
    }

    public String getDodge() {
        int agilityDodge = Integer.parseInt(this.getDexterity());
        int luckDodge = Integer.parseInt(this.getLuck())/5;
        int dodge = 100+agilityDodge+luckDodge;

        Random dice = new Random();
        int roll = dice.nextInt(10)+1;
        String dodgeRoll = String.valueOf(dodge*roll);
        return dodgeRoll;
    }

    public String getCritical() {
        Random dice = new Random();
        int roll = dice.nextInt(100)+1;
        int critical = (int) (Integer.parseInt(this.getLuck())*0.3);
        if (roll>critical){
            return "Falha";
        } else {
            return "Critical Hit!";
        }
    }

    public String getDefense() {
        int numberOfDices = Integer.parseInt(this.getVitality())/20+Integer.parseInt(this.getIntelligence())/50;
        Random dice = new Random();
        String defense = null;
        for (int i = 0 ; i<numberOfDices ; i++){
            if(i==0){
                int roll = dice.nextInt(10)+1;
                defense = String.valueOf(roll);
                i++;
            }
            int roll = dice.nextInt(10)+1;
            defense = defense + "+" + String.valueOf(roll);
        }
        return defense;
    }

    public String getMagicalDefense() {
        int numberOfDices = Integer.parseInt(this.getVitality())/50+Integer.parseInt(this.getIntelligence())/20;
        Random dice = new Random();
        String magicDefense = null;
        for (int i = 0 ; i<numberOfDices ; i++){
            if(i==0){
                int roll = dice.nextInt(10)+1;
                magicDefense = String.valueOf(roll);
                i++;
            }
            int roll = dice.nextInt(10)+1;
            magicDefense = magicDefense + "+" + String.valueOf(roll);
        }
        return magicDefense;
    }

    public String getPerfectDodge() {
        Random dice = new Random();
        int roll = dice.nextInt(100);
        int perfectDodge = ((Integer.parseInt(this.getLuck())*Integer.parseInt(this.getLuck()))/360)+Integer.parseInt(this.getLuck())/12;
        if (roll>perfectDodge){
            return "Falha";
        } else {
            return "Luck!";
        }
    }


}
