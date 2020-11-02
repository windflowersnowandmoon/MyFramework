package com.cmj.commonlib.database

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 *   $
 *   作   者 :彭付林
 *   邮   箱 :pengfl@kingchannels.com
 *   日   期 :2020/11/2
 *   描   述 :个人信息
 */
@Entity
data  class User (
    @PrimaryKey val id: Int,
    val firstName: String?,
    val lastName: String?
    /*@Ignore val picture: Bitmap?*/
){

}