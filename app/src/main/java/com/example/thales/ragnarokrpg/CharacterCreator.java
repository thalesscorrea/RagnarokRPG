package com.example.thales.ragnarokrpg;

import android.widget.EditText;

public class CharacterCreator {
    Character character;

    private EditText name;
    private EditText levelbase;
    private EditText leveljob;
    private EditText strength;
    private EditText agility;
    private EditText vitality;
    private EditText intelligence;
    private EditText dexterity;
    private EditText luck;

    public CharacterCreator(CreateCharacterActivity activity){
        character = new Character();

        name = (EditText) activity.findViewById(R.id.creating_name);
        levelbase = (EditText) activity.findViewById(R.id.creating_blvl);
        leveljob = (EditText) activity.findViewById(R.id.creating_jlvl);
        strength = (EditText) activity.findViewById(R.id.creating_str);
        agility = (EditText) activity.findViewById(R.id.creating_agi);
        vitality = (EditText) activity.findViewById(R.id.creating_vit);
        intelligence = (EditText) activity.findViewById(R.id.creating_int);
        dexterity = (EditText) activity.findViewById(R.id.creating_dex);
        luck = (EditText) activity.findViewById(R.id.creating_luk);
    }

    public Character getCharacter(){
        character.setName(name.getText().toString());
        character.setLevelbase(levelbase.getText().toString());
        character.setLeveljob(leveljob.getText().toString());
        character.setStrength(strength.getText().toString());
        character.setAgility(agility.getText().toString());
        character.setVitality(vitality.getText().toString());
        character.setIntelligence(intelligence.getText().toString());
        character.setDexterity(dexterity.getText().toString());
        character.setLuck(luck.getText().toString());

        return character;
    }

    public boolean hasName() {
        return !name.getText().toString().isEmpty();
    }

    public void noName() {
        name.setError("Obrigatório");
    }

    public void loadCharacter(Character character) {
        name.setText(character.getName());
        levelbase.setText(character.getLevelbase());
        leveljob.setText(character.getLeveljob());
        strength.setText(character.getStrength());
        agility.setText(character.getAgility());
        vitality.setText(character.getVitality());
        intelligence.setText(character.getIntelligence());
        dexterity.setText(character.getDexterity());
        luck.setText(character.getLuck());

        this.character = character;
    }
}

