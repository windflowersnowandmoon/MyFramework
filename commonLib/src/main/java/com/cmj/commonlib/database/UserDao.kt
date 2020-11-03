package com.cmj.commonlib.database

import androidx.room.Dao
import androidx.room.Query

/**
 *   $
 *   作   者 :彭付林
 *   邮   箱 :pengfl@kingchannels.com
 *   日   期 :2020/11/2
 *   描   述 :个人信息
 */
@Dao
interface UserDao : BaseDao<User>{

    @Query("SELECT * From User WHERE id >= 0")
    fun getUserList() : MutableList<User>
/*
    @Query("")
    fun getUserListTest() : MutableList<User>*/
}