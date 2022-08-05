package de.kroko.crack

import spark.Spark

//Connection: https://myth.bodyalhoha.com/check?hwid=
fun main(args: Array<String>) {
    Spark.port(443)
    Spark.secure("crack.jks", "Abc12345", null, null)
    Spark.get("/check") { request, response ->
        println("request")
        return@get "<html>\n" +
                " <body>\n" +
                "  <h1>Ich habe keinen zugriff auf Myth</h1>\n" +
                "  <h2>Reply by cracker</h2>\n" +
                " </body>\n" +
                "</html>"
    }
}