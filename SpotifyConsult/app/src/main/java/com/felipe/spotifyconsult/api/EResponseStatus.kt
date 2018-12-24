package com.felipe.spotifyconsult.api

enum class EResponseStatus(var value: Int) {

    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NO_CONTENT(204),
    NOT_MODIFIED(304),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    TOO_MANY_REQUESTS(429),
    INTERNAL_SERVER_ERROR(500),
    BAD_GATEWAY(502),
    SERVICE_UNAVAILABLE(503);

    companion object {
        fun from(value: Int): EResponseStatus {
            return from(value)
        }
    }
}