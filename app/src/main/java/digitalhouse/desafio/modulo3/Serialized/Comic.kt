package digitalhouse.desafio.modulo3.Serialized

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Comic(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("pageCount") val pageCount: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("textObjects") val text: ArrayList<Text>,
    @SerializedName("dates") @Expose val dates: ArrayList<Date>,
    @SerializedName("prices") @Expose val prices: ArrayList<Price>,
    @SerializedName("images") @Expose val images: ArrayList<Image>
) : Serializable