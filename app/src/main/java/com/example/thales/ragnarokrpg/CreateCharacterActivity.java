package com.example.thales.ragnarokrpg;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class CreateCharacterActivity extends ActionBarActivity {

    private CharacterCreator creator;
    public static final String SELECTED_CHARACTER = "selectedCharacter";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character);

        creator = new CharacterCreator(this);
        invalidateOptionsMenu();

        final Character characterToEdit = (Character) getIntent().getSerializableExtra(SELECTED_CHARACTER);

        if (characterToEdit != null){
            creator.loadCharacter(characterToEdit);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("Avisos","Menu inflando");
        getMenuInflater().inflate(R.menu.menu_create_character, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.menu_character_creator_confirm:
                Character character = creator.getCharacter();

                if(creator.hasName()) {
                    CharacterDAO dao = new CharacterDAO(CreateCharacterActivity.this);
                    dao.insertOrAlterate(character);
                    dao.close();
                    finish();
                    return true;
                }else{
                    creator.noName();
                }



            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
