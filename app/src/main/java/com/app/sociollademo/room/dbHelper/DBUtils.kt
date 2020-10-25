package com.app.sociollademo.room.dbHelper

class DBUtils {
    companion object {
        const val DATABASE_NAME = "definedlab.db"
        const val DB_VERSION = 7
        const val VENUE_TABLE = "venu_table"


    }


    interface VDENUTABLCONSTANT {
        companion object {
            const val KEY_CITY_UNIQUE_ID = "venu_unique_id"
            const val KEY_CITY_NAME = "city_name"
            const val KEY_CITY_DETAILS = "city_details"

        }
    }


}
