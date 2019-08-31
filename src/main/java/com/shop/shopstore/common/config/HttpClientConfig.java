package com.shop.shopstore.common.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@Configuration
public class HttpClientConfig {
    @Value(value = "${http.maxTotal}")
    private Integer maxTotal;
    @Value("${http.defaultMaxPerRoute}")
    private Integer defaultMaxPerRoute;
    @Value("${http.connectTimeout}")
    private Integer connectTimeout;
    @Value("${http.connectionRequestTimeout}")
    private Integer connectionRequestTimeout;
    @Value("${http.socketTimeout}")
    private Integer socketTimeout;
    @Value("${http.staleConnectionCheckEnabled}")
    private boolean staleConnectionCheckEnabled;

    private static final String HTTP = "http";
    private static final String HTTPS = "https";

    @Bean
    public SSLContextBuilder sslContextBuilder() throws KeyStoreException, NoSuchAlgorithmException {
        SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
        // 全部信任 不做身份鉴定
        sslContextBuilder.loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) {
                return true;
            }
        });
        return sslContextBuilder;
    }
    @Bean
    public SSLConnectionSocketFactory sslConnectionSocketFactory(SSLContextBuilder sslContextBuilder) throws KeyManagementException, NoSuchAlgorithmException {
        sslContextBuilder.build().getSocketFactory();
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContextBuilder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
        return sslConnectionSocketFactory;
    }

    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager(SSLConnectionSocketFactory sslConnectionSocketFactory) {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register(HTTP, new PlainConnectionSocketFactory())
                .register(HTTPS, sslConnectionSocketFactory)
                .build();
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(registry);
        //总连接，不超过 路由*路由最大连接
        poolingHttpClientConnectionManager.setMaxTotal(maxTotal);
        //单个路由最大连接
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        return poolingHttpClientConnectionManager;
    }

    @Bean(name = "httpClientBuilder")
    public HttpClientBuilder httpClientBuilder(PoolingHttpClientConnectionManager poolingHttpClientConnectionManager) {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);
        return httpClientBuilder;
    }

    @Bean
    @Primary
    public CloseableHttpClient getCloseableHttpClient(@Qualifier("httpClientBuilder") HttpClientBuilder httpClientBuilder) {
        return httpClientBuilder.build();
    }

    @Bean(name = "builder")
    public RequestConfig.Builder getBuilder() {
        RequestConfig.Builder builder = RequestConfig.custom();
        return builder.setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setSocketTimeout(socketTimeout);
    }
    @Bean
    public RequestConfig getRequestConfig(@Qualifier("builder") RequestConfig.Builder builder) {
        return builder.build();
    }
}
