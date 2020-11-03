package com.cmj.commonlib.database

import androidx.room.*

@Entity(tableName = "Menses"/*,
    foreignKeys = @ForeignKey(entity = User::class, parentColumns = "id", childColumns = "userId"*/)

data class Menses(

    /**
     * 如果您在主构造函数中具有@Ignore参数，则可能会发生此错误，即Room期望具有以下任一情况：
    ·  无参数构造函数或
    ·  构造函数，其中所有字段均未标有@Ignore

    如果吧 @Ignore 不写到构造函数中，就不会提示错误了
     */

    @ColumnInfo(name = "user_name") var userName: String?,

    @ColumnInfo(defaultValue = "china") var address: String?,

    @ColumnInfo(name = "userId") var userId: Long

/*    @Ignore var sex: String? = null*/

) {

    @PrimaryKey(autoGenerate = true) var id: Long = 0


    @Ignore
    var sex: String? = null

/*    constructor() : this(1 , "", "", null){

    }*/
}