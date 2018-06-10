package android.example.com.coroutines.repository.entity

import android.arch.persistence.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomEntity: T)

    @Delete
    fun delete(roomEntity: T)

    @Update
    fun update(roomEntity: T)

}