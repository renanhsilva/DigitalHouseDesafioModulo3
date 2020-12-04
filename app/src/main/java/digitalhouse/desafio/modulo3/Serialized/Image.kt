package digitalhouse.desafio.modulo3.Serialized

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Image (
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
) : Serializable