package de.kroko.crack

import club.antiskid.encryption.Launcher
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*


fun main(args: Array<String>) {
    val sc: SSLContext = SSLContext.getInstance("SSL")
    sc.init(null, arrayOf<TrustManager>(
        object : X509TrustManager {
            override fun checkClientTrusted(certs: Array<X509Certificate?>?, authType: String?) {}
            override fun checkServerTrusted(certs: Array<X509Certificate?>?, authType: String?) {}
            override fun getAcceptedIssuers(): Array<X509Certificate>? {
                return null
            }
        }
    ), SecureRandom())

    val allHostsValid: HostnameVerifier = HostnameVerifier { hostname, session -> true }

    HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid)
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
    Launcher.main(args)
}