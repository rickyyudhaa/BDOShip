package com.example.bdoship;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Ship.class, User.class, Material.class}, version = 1)
public abstract class Bdoshipdb extends RoomDatabase{

    private static Bdoshipdb instance;

    public abstract ShipDao shipDao();

    public static synchronized Bdoshipdb getInstance(Context context){
        if (instance == null){
            Room.databaseBuilder(context.getApplicationContext(),
                    Bdoshipdb.class, "Bdoshipdb")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
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

        private PopulateDBAsyncTask(Bdoshipdb db){
            shipDao = db.shipDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
