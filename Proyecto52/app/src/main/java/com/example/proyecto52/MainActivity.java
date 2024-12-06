package com.example.proyecto52;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Persona> listapersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listapersonas=new ArrayList<Persona>();
        listapersonas.add(new Persona("Juan", 'm'));
        listapersonas.add(new Persona("pedro",'m'));
        listapersonas.add(new Persona("luis",'m'));
        listapersonas.add(new Persona("ana",'f'));
        listapersonas.add(new Persona("carla",'f'));
        listapersonas.add(new Persona("maria",'f'));
        listapersonas.add(new Persona("gustavo",'m'));
        listapersonas.add(new Persona("carlos",'m'));
        listapersonas.add(new Persona("marta",'f'));
        listapersonas.add(new Persona("luisa",'f'));
        listapersonas.add(new Persona("fernanda",'f'));
        listapersonas.add(new Persona("jose",'m'));
        AdaptadorPersonas adaptador = new AdaptadorPersonas(this);
        ListView lv1 = (ListView)findViewById(R.id.list1);
        lv1.setAdapter(adaptador);
    }
    class AdaptadorPersonas extends ArrayAdapter<Persona> {
        AppCompatActivity appCompatActivity;
        AdaptadorPersonas(AppCompatActivity context) {
            super(context, R.layout.persona, listapersonas);
            appCompatActivity = context;
        }
        public View getView(int position, View convertView,ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.persona, null);
            TextView textView1 = (TextView)item.findViewById(R.id.textView2);
            textView1.setText(listapersonas.get(position).getNombre());
            ImageView imageView1 =
                    (ImageView)item.findViewById(R.id.imageView2);
            if (listapersonas.get(position).getGenero()=='m')
                imageView1.setImageResource(R.mipmap.h);
            else
                imageView1.setImageResource(R.mipmap.m);
            return(item);
        }
    }
}