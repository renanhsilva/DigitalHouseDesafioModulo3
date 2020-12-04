package digitalhouse.desafio.modulo3.Serialized

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Date (
    @SerializedName("date") val date: String,
    @SerializedName("type") val type: String
) : Serializable