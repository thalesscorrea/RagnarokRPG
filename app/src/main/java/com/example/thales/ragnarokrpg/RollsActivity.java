package com.example.thales.ragnarokrpg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Need to implements this Activity

public class RollsActivity extends AppCompatActivity {

    public static final String SELECTED_CHARACTER = "selectedCharacter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_rolls);
        final Character character = (Character) getIntent().getSerializableExtra(SELECTED_CHARACTER);
        final TextView rolls_result = (TextView)findViewById(R.id.rolls_result);
        Button meleeRoll = (Button)findViewById(R.id.button_melee_roll);
        Button rangedRoll = (Button)findViewById(R.id.button_ranged_roll);
        Button magicRoll = (Button)findViewById(R.id.button_magic_roll);
        Button precisionRoll = (Button)findViewById(R.id.button_precision_roll);
        Button dodgeRoll = (Button)findViewById(R.id.button_dodge_roll);
        Button criticalRoll = (Button)findViewById(R.id.button_critical_roll);
        Button defenseRoll = (Button)findViewById(R.id.button_defense_roll);
        Button magicDefenseRoll = (Button)findViewById(R.id.button_magic_defense_roll);
        Button dropsRoll = (Button)findViewById(R.id.button_perfect_dodge_roll);

        meleeRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rolls_result.setText(character.getMeleeDamage());
            }
        });

        rangedRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rolls_result.setText(character.getRangedDamage());
            }
        });

        magicRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rolls_result.setText(character.getMagicDamage());
            }
        });

        precisionRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rolls_result.setText(character.getPrecision());
            }
        });

        dodgeRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rolls_result.setText(character.getDodge());
            }
        });

        criticalRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rolls_result.setText(character.getCritical());
            }
        });

        defenseRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rolls_result.setText(character.getDefense());
            }
        });

        magicDefenseRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rolls_result.setText(character.getMagicalDefense());
            }
        });

        dropsRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rolls_result.setText(character.getPerfectDodge());
            }
        });
    }
}
