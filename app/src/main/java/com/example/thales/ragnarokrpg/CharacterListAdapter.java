package com.example.thales.ragnarokrpg;

import android.app.Activity;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CharacterListAdapter extends BaseAdapter{
    private final List<Character> characters;
    private final Activity activity;

    public CharacterListAdapter(List<Character> characters, Activity activity) {
        this.characters = characters;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return characters.size();
    }

    @Override
    public Object getItem(int position) {
        return characters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return characters.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.item, parent, false);
        Character character = characters.get(position);

        ImageView hairstyle = (ImageView) view.findViewById(R.id.item_hairstyle);
        TextView name = (TextView) view.findViewById(R.id.item_name);
        TextView classe = (TextView) view.findViewById(R.id.item_class);
        TextView level = (TextView) view.findViewById(R.id.item_level);

        name.setText(character.getName());
        classe.setText(character.getClasse());
        level.setText(character.getLevelbase()+"/"+character.getLeveljob());

        return view;
    }
}
