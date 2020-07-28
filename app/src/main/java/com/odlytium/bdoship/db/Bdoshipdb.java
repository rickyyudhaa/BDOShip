package com.odlytium.bdoship.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.odlytium.bdoship.dao.MatsDao;
import com.odlytium.bdoship.dao.OwnedprogressDao;
import com.odlytium.bdoship.dao.ProgressDao;
import com.odlytium.bdoship.dao.ShipDao;
import com.odlytium.bdoship.entity.Material;
import com.odlytium.bdoship.entity.Ownedprogress;
import com.odlytium.bdoship.entity.ProgressEntity;
import com.odlytium.bdoship.entity.Ship;

@Database(entities = {Ship.class, ProgressEntity.class, Material.class, Ownedprogress.class}, version = 5)
public abstract class Bdoshipdb extends RoomDatabase{

    private static Bdoshipdb instance;

    public abstract ShipDao shipDao();

    public abstract ProgressDao progressDao();

    public abstract MatsDao matsDao();

    public abstract OwnedprogressDao ownedprogressDao();

    public static synchronized Bdoshipdb getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    Bdoshipdb.class, "Bdoshipdb")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }


    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void>{
        private ShipDao shipDao;
        private MatsDao matsDao;
        private ProgressDao progressDao;
        private OwnedprogressDao ownedprogressDao;

        private PopulateDBAsyncTask(Bdoshipdb db){
            shipDao = db.shipDao();
            matsDao = db.matsDao();
            progressDao = db.progressDao();
            ownedprogressDao = db.ownedprogressDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
