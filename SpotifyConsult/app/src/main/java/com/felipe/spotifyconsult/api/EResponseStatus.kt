package com.felipe.spotifyconsult.api

enum class EResponseStatus(var value: Int) {

    OK(200),
    FORBIDDEN(403),
    NOT_FOUND(404);

    companion object {
        fun from(value: Int): EResponseStatus {
            return from(value)
        }
    }
}