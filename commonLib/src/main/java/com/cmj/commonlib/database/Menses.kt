package com.cmj.commonlib.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "Menses")
data class Menses constructor(var asda: Int) {
    @PrimaryKey(autoGenerate = true)
    var userId: Long? = null
    @ColumnInfo(name = "user_name")
    var userName: String? = null
    @ColumnInfo(defaultValue = "china")
    var address: String? = null
    @Ignore
    var sex: Boolean? = null
}