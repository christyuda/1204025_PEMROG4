package id.ac.ulbi.sevenmorse.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import id.ac.ulbi.sevenmorse.database.dao.UserDao;
import id.ac.ulbi.sevenmorse.database.entitas.User;

@Database(entities = {User.class}, version = 1)
public abstract class Appdatabase extends RoomDatabase {

    private static Appdatabase sInstance;
    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    @VisibleForTesting
    public static final String DATABASE_NAME = "my_database";

    public abstract UserDao userDao();

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

    private void updateDatabaseCreated(final Context context){
        if (context.getDatabasePath(DATABASE_NAME).exists()){
            setDatabaseCreated();
        }
    }

    public static Appdatabase buildDatabase(final Context context){
        return Room.databaseBuilder(context, Appdatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Appdatabase appdatabase = Appdatabase.getInstance(context);
                        appdatabase.setDatabaseCreated();
                    }
                }).allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }
    public static Appdatabase getInstance(final Context context){
        if (sInstance == null){
            synchronized (Appdatabase.class){
                if (sInstance == null){
                    sInstance = buildDatabase(context);
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }return sInstance;
    }



}