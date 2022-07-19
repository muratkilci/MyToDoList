package com.example.mytodolist.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat

@Entity(tableName = "task_table")
@Parcelize
data class Task(
    val name: String,
    val important: Boolean = false,
    val completed: Boolean = false,
    val created: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) : Parcelable {
    val createdDateFormatted: String
        get() = DateFormat.getTimeInstance().format(created)
}


/*
Parcelize -> nesneleri bir Parsele seri hale getirmenize ve serisini kaldırmanıza izin veren bir kitaplıktır.
Entity -> Room'ın veritabanı işlemleri için kullanılır.
 */

/*
Eğitim bitince Kalan süreyi yazdırıp gösterecek şekilde eklenti ekle
 */