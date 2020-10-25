package com.app.sociollademo.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.sociollademo.room.dbHelper.DBUtils




@Entity(tableName = DBUtils.VENUE_TABLE)
class VenueEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DBUtils.VDENUTABLCONSTANT.KEY_CITY_UNIQUE_ID)
    var city_unique_id: Int = 0

    @ColumnInfo(name = DBUtils.VDENUTABLCONSTANT.KEY_CITY_NAME)
    var city_name: String = ""

    @ColumnInfo(name = DBUtils.VDENUTABLCONSTANT.KEY_CITY_DETAILS)
    var city_details: String = ""


}