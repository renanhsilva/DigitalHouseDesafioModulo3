package digitalhouse.desafio.modulo3.Serialized

import com.google.gson.annotations.SerializedName


data class Data (
    @SerializedName("offset") val offset: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: ArrayList<Comic>
)