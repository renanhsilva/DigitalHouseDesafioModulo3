package digitalhouse.desafio.modulo3.Serialized

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Images (
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
) : Serializable {
    override fun toString() = "$path.$extension".replace("http://", "https://")
}