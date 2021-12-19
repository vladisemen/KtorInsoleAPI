package com.jetbrains.handson.httpapi.routes


import com.lordcodes.turtle.shellRun
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import java.io.File

fun Application.registerUploads() {
    routing {
        UploadsRoute()
    }
}

fun Route.UploadsRoute() {
    var fileDescription = ""
    var fileName = ""
    var output = ""
    val namePhoto: MutableList<String> = mutableListOf()

    post("/upload") {
        val multipartData = call.receiveMultipart()

        multipartData.forEachPart { part ->
            when (part) {
                is PartData.FormItem -> {
                    fileDescription = part.value
                }
                is PartData.FileItem -> {
                    fileName = part.originalFileName as String
                    val fileBytes = part.streamProvider().readBytes()
                    File("uploads/$fileName").writeBytes(fileBytes)

                    namePhoto.add(fileName)

                }
            }
        }

        call.respondText("hello")

        output = shellRun("\"D:\\Ktor\\KtorInsoleAPI\\python.bat\"" , listOf(namePhoto[0]))


    }
}