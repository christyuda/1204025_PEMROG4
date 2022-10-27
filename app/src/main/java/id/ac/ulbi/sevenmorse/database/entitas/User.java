package id.ac.ulbi.sevenmorse.database.entitas;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "npm")
    public String NPM;

    @ColumnInfo(name = "nama")
    public String NAMA;

    @ColumnInfo(name = "kelas")
    public String KELAS;

    @ColumnInfo(name = "PRODI")
    public String PRODI;
}
