package example.android.exam.examplelocal1.data.dataremote.response

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class UserResponse(
    @Json(name = "data") val data: User,
    @Json(name = "support") val support: Support,
)

@Keep
data class User(
    @Json(name = "id") val id: Int,
    @Json(name = "email") val email: String,
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    @Json(name = "avatar") val avatar: String,
)

@Keep
data class Support(
    @Json(name = "url") val url: String,
    @Json(name = "text") val text: String,
)
