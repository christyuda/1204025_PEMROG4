package id.ac.ulbi.sevenmorse.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

import java.util.List;

import id.ac.ulbi.sevenmorse.database.entitas.User;

@Dao
public interface UserDao {



    @Query("SELECT * FROM user")
    List<User> getAll();


    @Query("INSERT INTO user (npm,nama,kelas,prodi) VALUES (:npm,:nama,:kelas,:prodi)")
    void insertAll(String npm, String nama, String kelas, String prodi);

    @Query("UPDATE user SET npm=:npm, nama=:nama,kelas=:kelas,prodi=:prodi WHERE uid=:uid")
    void update(int uid, String npm,String nama,String kelas,String prodi );

    @Query("SELECT * FROM user WHERE uid=:uid")
    User get(int uid);
    @Delete
    void delete(User user);
}