package com.cmj.commonlib.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "Menses")
data class Menses(

    @PrimaryKey(autoGenerate = true) var userId: Long,

    @ColumnInfo(name = "user_name") var userName: String?,

    @ColumnInfo(defaultValue = "china") var address: String?,

    @Ignore var sex: Boolean?
)