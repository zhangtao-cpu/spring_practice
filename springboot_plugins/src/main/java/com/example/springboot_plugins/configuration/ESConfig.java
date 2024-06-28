package com.example.springboot_plugins.configuration;


import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.core.CheckedConsumer;
import org.elasticsearch.xcontent.NamedXContentRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author zhangtao
 * @Date 2024/6/28 17:52
 */

@Configuration
public class ESConfig {

    @Value("${es.esip:}")
    private String esIp;
    @Value("${es.port:}")
    private String port;
    @Value("${es.username:}")
    private String username;
    @Value("${es.password:}")
    private String password;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        if (StringUtils.isEmpty(esIp)) {
            esIp = "192.168.137.100";
        }
        int port = 9200;
        if (StringUtils.isNotEmpty(this.port)) {
            try {
                port = Integer.parseInt(this.port);
            } catch (NumberFormatException e) {

            }
        }
        HzRestHighLevelClient restHighLevelClient;
        if (StringUtils.isNotEmpty(this.username) &&  StringUtils.isNotEmpty(this.password)) {
            // 使用 CredentialsProvider 对象登陆
            CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials
                    (AuthScope.ANY, new UsernamePasswordCredentials(this.username, this.password));
            HttpHost http = new HttpHost(esIp, port, "http");
            restHighLevelClient =
                    new HzRestHighLevelClient(RestClient.builder(
                                    http)
                            .setHttpClientConfigCallback(
                                    httpAsyncClientBuilder ->
                                            httpAsyncClientBuilder.disableAuthCaching()
                                                    .setDefaultCredentialsProvider(credentialsProvider)
                            ));
            restHighLevelClient.ip = esIp;
            restHighLevelClient.port = port;
            restHighLevelClient.username = this.username;
            restHighLevelClient.password = this.password;
            restHighLevelClient.needAuth = Boolean.TRUE;
        } else {
            restHighLevelClient =
                    new HzRestHighLevelClient(RestClient.builder(
                            new HttpHost(esIp, port, "http")));
        }
        return restHighLevelClient;
    }

    public static class HzRestHighLevelClient extends RestHighLevelClient {
        @Getter
        private String username;
        @Getter
        private String password;
        @Getter
        private String ip;
        @Getter
        private int port;
        @Getter
        private boolean needAuth;

        public HzRestHighLevelClient(RestClientBuilder restClientBuilder) {
            super(restClientBuilder);
        }

        protected HzRestHighLevelClient(RestClientBuilder restClientBuilder, List<NamedXContentRegistry.Entry> namedXContentEntries) {
            super(restClientBuilder, namedXContentEntries);
        }

        protected HzRestHighLevelClient(RestClient restClient, CheckedConsumer<RestClient, IOException> doClose, List<NamedXContentRegistry.Entry> namedXContentEntries) {
            super(restClient, doClose, namedXContentEntries);
        }
    }

}

