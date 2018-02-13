package io.pivotal.education.articulate

import groovy.json.JsonSlurper
import okhttp3.OkHttpClient
import okhttp3.Request
import spock.lang.Specification

import javax.net.ssl.*
import java.security.cert.CertificateException
import java.security.cert.X509Certificate

class HealthSpec extends Specification {
  def baseUrl = System.getenv().BASE_URL ?: "http://localhost:8080"

  def "should pass health check"() {
    given:
    def client = httpClient()
    def request = new Request.Builder()
        .header("Accept", "application/json")
        .url("${baseUrl}/health")
        .build()

    and:
    def parser = new JsonSlurper()

    when:
    def response = client.newCall(request).execute()
    def text = response.body().string()
    def json = parser.parseText(text)

    then:
    json.status == "UP"
  }

  def httpClient() {
    new OkHttpClient() {
      @Override
      HostnameVerifier hostnameVerifier() {
        new TrustEverythingHostNameVerifier()
      }

      @Override
      SSLSocketFactory sslSocketFactory() {
        SSLContext sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, [new TrustEverythingTrustManager()] as TrustManager[], null)
        sslContext.getSocketFactory()
      }
    }

  }

  private static final class TrustEverythingHostNameVerifier implements HostnameVerifier {
    @Override
    boolean verify(String s, SSLSession sslSession) {
      true
    }
  }

  private static final class TrustEverythingTrustManager implements X509TrustManager {
    @Override
    void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
    }

    @Override
    void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
    }

    @Override
    X509Certificate[] getAcceptedIssuers() {
      new X509Certificate[0]
    }
  }

}
