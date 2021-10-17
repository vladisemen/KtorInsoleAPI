package com.jetbrains.handson.httpapi

import io.ktor.application.Application
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import com.jetbrains.handson.httpapi.routes.registerCustomerRoutes
import com.jetbrains.handson.httpapi.routes.registerOrderRoutes
import com.jetbrains.handson.httpapi.routes.registerUploads
import io.ktor.auth.*
import io.ktor.auth.jwt.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(CORS) {
        anyHost()
    }
    install(ContentNegotiation) {
        json()
    }
    install(Authentication) {
        basic("auth-basic") {
            // Configure basic authentication
        }
        form("auth-form") {
            // Configure form authentication
        }
    }
    registerCustomerRoutes()
    registerOrderRoutes()
    registerUploads()
}
