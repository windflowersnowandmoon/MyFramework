package com.cmj.commonlib.database

import androidx.room.Query

/**
 *   $
 *   作   者 :彭付林
 *   邮   箱 :pengfl@kingchannels.com
 *   日   期 :2020/11/2
 *   描   述 :个人信息
 */
interface  MensesDao : BaseDao<Menses>{

    @Query("SELECT * from Menses ORDER BY id ASC")
    fun getMensesList() : MutableList<Menses>


}