package com.example.thales.ragnarokrpg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, CLASSES);
        AutoCompleteTextView characterClass = (AutoCompleteTextView)findViewById(R.id.creating_class);
        characterClass.setAdapter(adapter);
    }

    private static final String[] CLASSES = new String[] {
            "Aprendiz", "Espadachim", "Mago", "Mercador", "Gatuno", "Arqueiro", "Noviço",
            "Cavaleiro", "Templário", "Bruxo", "Sábio", "Ferreiro", "Alquimista",
            "Mercenário", "Arruaceiro", "Caçador", "Bardo", "Odalisca", "Sacerdote", "Monge",
            "Lorde", "Paladino", "Arquimago", "Professor", "Mestre Ferreiro", "Criador",
            "Algoz", "Desordeiro", "Atirador de Elite", "Menestrel", "Cigana", "Sumo Sacerdote", "Mestre",
            "Taekwon", "Mestre Taekwon", "Espiritualista", "Ninja", "Justiceiro"
    };

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
