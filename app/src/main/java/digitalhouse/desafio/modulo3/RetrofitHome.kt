package digitalhouse.desafio.modulo3

import com.google.gson.JsonObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

val urlApi = "https://gateway.marvel.com/v1/public/"

val retrofit = Retrofit.Builder()
    .baseUrl(urlApi)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val marvelApi = retrofit.create(Retrofit::class.java)

interface ServiceAPI{

    @GET("characters/{characterId}/comics")
    suspend fun getResults(
        @Path("characterId") characterId : Int = 1009610,
        @Query("offset")offset: Int,
        @Query("limit")limit: Int,
        @Query("ts") ts: Long,
        @Query("apikey")apiKey: String,
        @Query("hash")hash: String
    ): JsonObject
}