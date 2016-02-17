package com.example.thales.ragnarokrpg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListView charactersList;
    private List<Character> characters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        charactersList = (ListView) findViewById(R.id.characters_list);

        registerForContextMenu(charactersList);

        Button create = (Button)findViewById(R.id.creation_button);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, CreateCharacterActivity.class);
                startActivity(intent);
            }
        });

        charactersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent edit = new Intent(ListActivity.this, CreateCharacterActivity.class);
                Character selectedCharacter = (Character)charactersList.getItemAtPosition(position);
                edit.putExtra(CreateCharacterActivity.SELECTED_CHARACTER, selectedCharacter);
                startActivity(edit);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        CharacterDAO dao = new CharacterDAO(this);
        characters = dao.getList();
        dao.close();

        ArrayAdapter<Character> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, characters);

        charactersList.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Character selectedCharacter = (Character) charactersList.getAdapter().getItem(info.position);

        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                CharacterDAO dao = new CharacterDAO(ListActivity.this);
                dao.delete(selectedCharacter);
                dao.close();

                onResume();
                return false;
            }
        });

    }
}
