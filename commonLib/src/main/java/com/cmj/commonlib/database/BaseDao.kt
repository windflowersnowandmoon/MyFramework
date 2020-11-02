package com.cmj.commonlib.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

/**
 *   $
 *   作   者 :彭付林
 *   邮   箱 :pengfl@kingchannels.com
 *   日   期 :2020/11/2
 *   描   述 :个人信息
 */
interface BaseDao<T> {

    @Insert
    fun insertElement(element: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list : MutableList<T>)

    @Delete
    fun deleteElement(element : T)

    @Delete
    fun deleteList(element: MutableList<T>)

    @Delete
    fun deleteSome(vararg elements:T)

    @Update
    fun update(element: T)

    @Update
    fun update(element: MutableList<T>)
}