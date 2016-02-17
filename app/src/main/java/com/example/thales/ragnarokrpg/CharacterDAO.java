package com.example.thales.ragnarokrpg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CharacterDAO extends SQLiteOpenHelper {
    private static final int VERSAO = 1;
    private static final String DATABASE = "CreateCharacter";
    private static final String TABELA = "Characters";

    public CharacterDAO(Context context){
        super(context, DATABASE, null, VERSAO);
    }

    public void insert(Character character) {
        ContentValues values = new ContentValues();

        values.put("name",character.getName());
        values.put("levelbase",character.getLevelbase());
        values.put("leveljob",character.getLeveljob());
        values.put("strength",character.getStrength());
        values.put("agility",character.getAgility());
        values.put("vitality",character.getVitality());
        values.put("intelligence",character.getIntelligence());
        values.put("dexterity",character.getDexterity());
        values.put("luck",character.getLuck());

        getWritableDatabase().insert(TABELA, null, values);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ddl = "CREATE TABLE " + TABELA
                + " (id INTEGER PRIMARY KEY, "
                + " name TEXT NOT NULL, "
                + " levelbase TEXT, "
                + " leveljob TEXT, "
                + " strength TEXT, "
                + " agility TEXT, "
                + " vitality TEXT, "
                + " intelligence TEXT,"
                + " dexterity TEXT, "
                + " luck TEXT);";

        db.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXSITS " + TABELA;
        db.execSQL(sql);
        onCreate(db);
    }

    public List<Character> getList(){
        List<Character> characters = new ArrayList<>();
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM " + TABELA + ";", null);

        while (c.moveToNext()){
            Character character = new Character();

            character.setId((int) c.getLong(c.getColumnIndex("id")));
            character.setName(c.getString(c.getColumnIndex("name")));
            character.setLevelbase(c.getString(c.getColumnIndex("levelbase")));
            character.setLeveljob(c.getString(c.getColumnIndex("leveljob")));
            character.setStrength(c.getString(c.getColumnIndex("strength")));
            character.setAgility(c.getString(c.getColumnIndex("agility")));
            character.setVitality(c.getString(c.getColumnIndex("vitality")));
            character.setIntelligence(c.getString(c.getColumnIndex("intelligence")));
            character.setDexterity(c.getString(c.getColumnIndex("dexterity")));
            character.setLuck(c.getString(c.getColumnIndex("luck")));

            characters.add(character);
        }
        c.close();
        return characters;
    }

    public void alterate(Character character){
        ContentValues values = new ContentValues();

        values.put("name", character.getName());
        values.put("levelbase", character.getLevelbase());
        values.put("leveljob", character.getLeveljob());
        values.put("strength", character.getStrength());
        values.put("agility", character.getAgility());
        values.put("vitality", character.getVitality());
        values.put("intelligence", character.getIntelligence());
        values.put("dexterity", character.getDexterity());
        values.put("luck", character.getLuck());

        String[] args = { character.getId().toString() };
        getWritableDatabase().update(TABELA, values, "id=?", args);
    }

    public void insertOrAlterate(Character character){
        if(character.getId() == null){
            this.insert(character);
        }else{
            this.alterate(character);
        }
    }

    public void delete(Character character){
        String[] args = {character.getId().toString()};
        getWritableDatabase().delete(TABELA, "id=?", args);
    }
}
