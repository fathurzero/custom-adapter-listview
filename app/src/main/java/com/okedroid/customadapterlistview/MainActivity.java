package com.okedroid.customadapterlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[][] data = new String[][]{
            {"Toyota, Avanza, G 1.3 A/t 2009",
                    "http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/original/2016/10/25/vH1KWBiydBAtmV8cHaWeWCRieAJ0P_p1.jpg?v=493.33333333333",
                    "Rp. 102.000.000", "Tangerang, Banten"},
            {"Toyota, Camry 2.4 V A/t 2007",
                    "http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/original/2016/10/26/n3hJg_hf3AWUi62M_uAzxlj5w92vu0aG.jpg?v=657.10382513661","Rp. 170.000.000", "Tangerang, Banten"},
            {"Mercedez Benz, E Class E 200 Kompressor 2009",
                    "http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/original/2016/07/22/2016-07-22-IMG-7615_1469170510785.JPG?v=492.82786885246","Rp. 180.000.000", "Jakarta Timur"},
            {"Honda, Jazz, A 1.5 M/T, 2015",
                    "http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/original/2015/06/05/honda-jazz-baru-mobil-dijual-jakarta-barat-img_1-1433491685_1515042903.jpg?v=250","Rp. 207.500.000", "Jakarta Barat"},
            {"Mitsubishi, Outlander, Sport PX, 2015",
                    "http://imgcdn.rajamobil.com:8080/resize2/public/media/images/databasemobil/original/2015/06/05/mitsubishi-outlander-baru-mobil-dijual-tangerang-img_1-1433491064_1220499493.jpg?v=250","Call", "Tangerang"}
    };

    private ListView lvItem;
    private ArrayList listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Daftar Harga Jual Mobil");
        getSupportActionBar().setSubtitle("Modul 4 Dicoding.com(Fathurrahman)");

        lvItem = (ListView)findViewById(R.id.lv_item);
        listItem = new ArrayList<>();

        MobilModel mobil = null;

        for (int i = 0; i < data.length; i++){
            mobil = new MobilModel();
            mobil.setTitle(data[i][0]);
            mobil.setImage(data[i][1]);
            mobil.setHarga(data[i][2]);
            mobil.setLokasi(data[i][3]);

            listItem.add(mobil);
        }

        MobilAdapter adapter = new MobilAdapter(MainActivity.this, listItem);
        lvItem.setAdapter(adapter);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MobilModel mbl = (MobilModel) listItem.get(position);

                Intent intent = new Intent(MainActivity.this, DetailMobilActivity.class);
                intent.putExtra(DetailMobilActivity.KEY_ITEM, mbl);
                startActivityForResult(intent, 0);
            }
        });

    }

}