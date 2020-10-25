package com.app.sociollademo.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.sociollademo.model.db.VenueEntity


@Dao
interface InterfaceDao {
    @Insert
    fun addSearchCityData(venuEntity: VenueEntity)

    @Query("Select * from  venu_table")
    fun getAllSearchCityData(): List<VenueEntity>

    @Query("Select EXISTS  (SELECT 1 FROM  venu_table WHERE venu_unique_id=:venue_id)")
    fun isFavourite(venue_id: Int): Int

    @Delete
    fun deleteFavouriteItem(favouriteList: VenueEntity)

    @Query("Select * from venu_table where city_name=:cityName")
    fun getPerticularcityData(cityName:String): VenueEntity

}
