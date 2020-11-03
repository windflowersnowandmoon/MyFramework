package com.cmj.commonlib.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

/**
 *   $
 *   作   者 :彭付林
 *   邮   箱 :pengfl@kingchannels.com
 *   日   期 :2020/11/2
 *   描   述 :个人信息
 */
@Dao
interface  MensesDao : BaseDao<Menses>{

    @Query("SELECT * from Menses WHERE id = :id ORDER BY id ASC")
    fun getMenses(id:Int) : Menses

    @Query("SELECT * from Menses ORDER BY id ASC")
    fun getMensesList() : MutableList<Menses>

    @Query("UPDATE Menses SET address = :address , user_name = :user_name WHERE id = :id")
    fun updateMenses(id : Int , address : String , user_name : String)

    @Query("UPDATE Menses SET address = :address , user_name = :user_name WHERE id > :id")
    fun updateMensesList(id : Int , address : String , user_name : String)

    @Query("DELETE FROM Menses WHERE id > 30")
    fun deleteList()

    @Query("DELETE FROM Menses")
    fun deleteAll()
}