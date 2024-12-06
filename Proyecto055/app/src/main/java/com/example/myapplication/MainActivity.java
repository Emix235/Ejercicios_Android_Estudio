package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnCamara, btnBuscar;
    ImageView ImageView1;
    EditText et1;
    String rutaImagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCamara = findViewById(R.id.btnCamara);
        btnBuscar = findViewById(R.id.btnBuscar);

        ImageView1 = findViewById(R.id.ImageView1);
        et1= findViewById(R.id.et1);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    abrirCamara();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarImagen();
            }
        });

    }


    private void abrirCamara() throws IOException {
        // PARA CAPTURAR IMAGEN
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File imagenArchivo = null;

        try{
            imagenArchivo = crearImagen();

        }catch (IOException ex){
            Log.e("Error", ex.toString());
        }

        if(imagenArchivo != null)
        {
            Uri fotoUri = FileProvider.getUriForFile(this, "com.example.Proyecto055.fileprovider", imagenArchivo);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
        }
        startActivityForResult(intent, 1);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode ==1 && resultCode == RESULT_OK)
        {
            // Bundle extras = data.getExtras();
            //Bitmap imgBitmap = (Bitmap) extras.get("data");
            Bitmap imgBitmap = BitmapFactory.decodeFile(rutaImagen);

            ImageView1.setImageBitmap(imgBitmap);
        }
    }


    private File crearImagen() throws IOException {

        String nombreImagen = et1.getText().toString();
        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        //File imagen = File.createTempFile(nombreImagen, ".jpg", directorio);
        File imagen= crearArchivo(directorio, nombreImagen,".jpg");


        rutaImagen = imagen.getAbsolutePath();
        return imagen;
    }

    private void buscarImagen() {
        String nombreImagen = et1.getText().toString();
        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imagenBuscada = new File(directorio, nombreImagen + ".jpg");

        if (imagenBuscada.exists()) {
            rutaImagen = imagenBuscada.getAbsolutePath();
            mostrarImagen();
        } else {
            // Manejar el caso en el que la imagen no se encontró
            Log.e("Error", "Imagen no encontrada");
        }
    }
    private void mostrarImagen() {
        if (rutaImagen != null) {
            Bitmap imgBitmap = BitmapFactory.decodeFile(rutaImagen);
            ImageView1.setImageBitmap(imgBitmap);
        } else {
            // Manejar el caso en el que no hay una ruta de imagen válida
            Log.e("Error", "Ruta de imagen no válida");
        }
    }
    private static File crearArchivo(File directorio, String nombreImagen, String extension) {

        // Verificar si el directorio existe o crearlo si no existe
        if (!directorio.exists()) {
            if (!directorio.mkdirs()) {
                System.err.println("Error al crear el directorio.");
                return null;
            }
        }

        // Crear el archivo utilizando el nombre, la extensión y el directorio
        File archivo = new File(directorio, nombreImagen + extension);

        try {
            if (archivo.createNewFile()) {
                return archivo;
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
        return null;
    }
}