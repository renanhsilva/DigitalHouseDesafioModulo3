package digitalhouse.desafio.modulo3.Serialized

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Prices (
    @SerializedName("price") val price: String
) : Serializable