package example.android.exam.examplelocal1.data.dataremote.mapper

import example.android.exam.examplelocal1.data.dataremote.response.UserResponse
import example.android.exam.examplelocal1.data.model.User

fun UserResponse.toModel() = User(
    id = data.id, email = data.email
)
