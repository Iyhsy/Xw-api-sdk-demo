package icu.xwang.xwapisdkdemo.utils;

import com.xiaowang.easyweb.exception.BusinessException;
import icu.xwang.xwapisdk.client.XwApiClient;
import icu.xwang.xwapisdk.config.XwApiClientConfig;
import icu.xwang.xwapisdk.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApiUtils {

    // 使用 Autowired 或 Resource 注入配置
    @Autowired
    private XwApiClientConfig xwApiClientConfig;

    // 获取 XwApiClient
    public XwApiClient getXwApiClient() {
        return new XwApiClient(xwApiClientConfig.getAccessKey(), xwApiClientConfig.getSecretKey());
    }

    // 统一处理 Api 调用及异常
    public <T> T handleApiCall(ApiCallable<T> apiCallable) {
        try {
            return apiCallable.call();
        } catch (ApiException e) {
            log.error(e.getMessage());
            throw new BusinessException(e.getCode(), e.getMessage());
        }
    }

    // 函数接口，兼容 Lambda 表达式
    @FunctionalInterface
    public interface ApiCallable<T> {
        T call() throws ApiException;
    }
}
