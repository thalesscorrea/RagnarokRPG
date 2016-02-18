package com.example.thales.ragnarokrpg;

import java.io.Serializable;
import java.util.Random;

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

    public String getMeleeDamage() {
        int numberOfDices = Integer.parseInt(this.getStrength())/10+Integer.parseInt(this.getStrength())/100+Integer.parseInt(this.getDexterity())/50+Integer.parseInt(this.getLuck())/50;
        //Need to implements the dices rolls
        return null;
    }

    public String getRangedDamage() {
        //Need to implements the dices rolls
        return null;
    }

    public String getMagicDamage() {
        //Need to implements the dices rolls
        return null;
    }

    public String getPrecision() {
        Random dice = new Random();
        int roll = dice.nextInt(10);
        String precision = String.valueOf(175+(Integer.parseInt(this.getLevelbase())+Integer.parseInt(this.getDexterity())+(Integer.parseInt(this.getLuck())/5)*roll));
        return precision;
    }

    public String getDodge() {
        Random dice = new Random();
        int roll = dice.nextInt(10);
        String dodge = String.valueOf(100 + (Integer.parseInt(this.getLevelbase()) + Integer.parseInt(this.getAgility()) + (Integer.parseInt(this.getLuck()) / 3) * roll));
        return dodge;
    }

    public String getCritical() {
        Random dice = new Random();
        int roll = dice.nextInt(100);
        int critical = (int) (Integer.parseInt(this.getLuck())+0.3);
        if (roll>critical){
            return "Falha";
        } else {
            return "Golpe critico";
        }
    }

    public String getDefense() {
        //Need to implements the dices rolls
        return null;
    }

    public String getMagicalDefense() {
        //Need to implements the dices rolls
        return null;
    }

    public String getPerfectDodge() {
        //Need to implements the dices rolls
        return null;
    }
}
