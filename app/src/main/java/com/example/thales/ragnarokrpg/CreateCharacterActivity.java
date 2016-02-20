package com.example.thales.ragnarokrpg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class CreateCharacterActivity extends AppCompatActivity {

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

        Button characterSave = (Button)findViewById(R.id.button_save);
        Button characterRoll = (Button)findViewById(R.id.button_roll);

        characterSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Character character = creator.getCharacter();
                if(creator.hasName()) {
                    CharacterDAO dao = new CharacterDAO(CreateCharacterActivity.this);
                    dao.insertOrAlterate(character);
                    dao.close();
                    finish();
                }else{
                    creator.noName();
                }
            }
        });

        characterRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rolls = new Intent(CreateCharacterActivity.this, RollsActivity.class);
                Character selectedCharacter = characterToEdit;
                rolls.putExtra(CreateCharacterActivity.SELECTED_CHARACTER, selectedCharacter);
                startActivity(rolls);
            }
        });
    }
}
