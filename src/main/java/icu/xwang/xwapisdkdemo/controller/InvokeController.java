package icu.xwang.xwapisdkdemo.controller;

import com.xiaowang.easyweb.common.BaseResponse;
import com.xiaowang.easyweb.common.ResultUtils;
import com.xiaowang.easyweb.exception.BusinessException;
import icu.xwang.xwapisdk.client.XwApiClient;
import icu.xwang.xwapisdk.config.XwApiClientConfig;
import icu.xwang.xwapisdk.exception.ApiException;
import icu.xwang.xwapisdk.model.params.*;
import icu.xwang.xwapisdk.model.request.*;
import icu.xwang.xwapisdk.model.response.*;
import icu.xwang.xwapisdk.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Author: xiaowang
 * @Date: 2024年08月20日 23:30
 * @Version: 1.0
 * @Description: Xw-api-sdk调用示例
 */
@RequestMapping("/invoke")
@RestController
@Slf4j
public class InvokeController {
    @Resource
    private ApiService apiService;

    @Resource
    private XwApiClientConfig xwApiClientConfig;

    private XwApiClient getXwApiClient() {
        return new XwApiClient(xwApiClientConfig.getAccessKey(), xwApiClientConfig.getSecretKey());
    }

    /**
     * 随机毒鸡汤
     *
     * @return {@link PoisonousChickenSoupResponse}
     */
    @GetMapping("/getPoisonousChickenSoup")
    public PoisonousChickenSoupResponse getPoisonousChickenSoup() {
        XwApiClient xwApiClient = new XwApiClient(xwApiClientConfig.getAccessKey(), xwApiClientConfig.getSecretKey());
        PoisonousChickenSoupResponse poisonousChickenSoup = null;
        try {
            poisonousChickenSoup = apiService.getPoisonousChickenSoup(xwApiClient);
            System.out.println("poisonousChickenSoup = " + poisonousChickenSoup);
        } catch (ApiException e) {
            log.error(e.getMessage());
        }
        return poisonousChickenSoup;
    }


    /**
     * 随机毒鸡汤
     *
     * @return {@link PoisonousChickenSoupResponse}
     */
    @GetMapping("/getPoisonousChickenSoupKey")
    public PoisonousChickenSoupResponse getPoisonousChickenSoupKey(XwApiClient xwApiClient) {
        PoisonousChickenSoupResponse poisonousChickenSoup = null;
        try {
            poisonousChickenSoup = apiService.getPoisonousChickenSoup(xwApiClient);
            System.out.println("poisonousChickenSoup = " + poisonousChickenSoup);
        } catch (ApiException e) {
            log.error(e.getMessage());
        }
        return poisonousChickenSoup;
    }

    /**
     * 获取毒鸡汤未设置密钥
     *
     * @return {@link BaseResponse}<{@link PoisonousChickenSoupResponse}>
     */
    @GetMapping("/getPoisonousChickenSoupNotSetKey")
    public BaseResponse<PoisonousChickenSoupResponse> getPoisonousChickenSoupNotSetKey() {
        PoisonousChickenSoupResponse poisonousChickenSoup = null;
        try {
            poisonousChickenSoup = apiService.getPoisonousChickenSoup();
            System.out.println("poisonousChickenSoup = " + poisonousChickenSoup);
        } catch (ApiException e) {
            throw new com.xiaowang.easyweb.exception.BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(poisonousChickenSoup);
    }

    /**
     * 随机情话
     *
     * @return {@link BaseResponse}<{@link LoveResponse}>
     */
    @GetMapping("/loveTalk/easyWeb")
    public BaseResponse<LoveResponse> getLoveTalkEasyWeb() {
        LoveResponse loveResponse;
        try {
            loveResponse = apiService.randomLoveTalk();
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(loveResponse);
    }

    @GetMapping("/loveTalk")
    public LoveResponse getLoveTalk() {
        LoveResponse loveResponse;
        try {
            loveResponse = apiService.randomLoveTalk();
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return loveResponse;
    }

    @GetMapping("/loveTalk/setKey")
    public LoveResponse getLoveTalkSetKey() {
        LoveResponse loveResponse;
        try {
            XwApiClient xwApiClient = new XwApiClient(xwApiClientConfig.getAccessKey(), xwApiClientConfig.getSecretKey());
            loveResponse = apiService.randomLoveTalk(xwApiClient);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return loveResponse;
    }

    /**
     * 获取星座运势
     *
     * @param horoscopeParams 星座参数
     * @return {@link BaseResponse}<{@link ResultResponse}>
     */
    @GetMapping("/getHoroscopeEasyWeb")
    public BaseResponse<ResultResponse> getHoroscopeEasyWeb(HoroscopeParams horoscopeParams) {
        ResultResponse horoscope;
        try {
            HoroscopeRequest horoscopeRequest = new HoroscopeRequest();
            horoscopeRequest.setRequestParams(horoscopeParams);
            horoscope = apiService.horoscope(horoscopeRequest);
        } catch (ApiException e) {
            throw new com.xiaowang.easyweb.exception.BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(horoscope);
    }

    @GetMapping("/getHoroscope")
    public ResultResponse getHoroscope(HoroscopeParams horoscopeParams) {
        ResultResponse horoscope;
        try {
            HoroscopeRequest horoscopeRequest = new HoroscopeRequest();
            horoscopeRequest.setRequestParams(horoscopeParams);
            horoscope = apiService.horoscope(horoscopeRequest);
        } catch (ApiException e) {
            throw new com.xiaowang.easyweb.exception.BusinessException(e.getCode(), e.getMessage());
        }
        return horoscope;
    }

    @GetMapping("/getHoroscope/setKey")
    public ResultResponse getHoroscopeSetKey(HoroscopeParams horoscopeParams) {
        ResultResponse horoscope;
        XwApiClient xwApiClient = new XwApiClient(xwApiClientConfig.getAccessKey(), xwApiClientConfig.getSecretKey());
        try {
            HoroscopeRequest horoscopeRequest = new HoroscopeRequest();
            horoscopeRequest.setRequestParams(horoscopeParams);
            horoscope = apiService.horoscope(xwApiClient, horoscopeRequest);
        } catch (ApiException e) {
            throw new com.xiaowang.easyweb.exception.BusinessException(e.getCode(), e.getMessage());
        }
        return horoscope;
    }

    /**
     * 获取ip信息
     * <p>
     * // * @param ipInfoParams ip信息参数
     *
     * @return {@link BaseResponse}<{@link ResultResponse}>
     */
    @GetMapping("/ipInfo/easyWeb")
    public BaseResponse<ResultResponse> getIpInfoEasyWeb(XwApiClient xwApiClient, IpInfoParams ipInfoParams) {
        ResultResponse resultResponse;
        try {
            IpInfoRequest ipInfoRequest = new IpInfoRequest();
            ipInfoRequest.setRequestParams(ipInfoParams);
            resultResponse = apiService.getIpInfo(xwApiClient, ipInfoRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(resultResponse);
    }

    @GetMapping("/ipInfo/toEasyWeb")
    public BaseResponse<ResultResponse> getIpInfoEasyWeb(IpInfoParams ipInfoParams) {
        ResultResponse resultResponse;
        try {
            IpInfoRequest ipInfoRequest = new IpInfoRequest();
            ipInfoRequest.setRequestParams(ipInfoParams);
            resultResponse = apiService.getIpInfo(ipInfoRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(resultResponse);
    }

    @GetMapping("/ipInfo")
    public ResultResponse getIpInfo(IpInfoParams ipInfoParams) {
        XwApiClient xwApiClient = new XwApiClient(xwApiClientConfig.getAccessKey(), xwApiClientConfig.getSecretKey());
        ResultResponse resultResponse;
        try {
            IpInfoRequest ipInfoRequest = new IpInfoRequest();
            ipInfoRequest.setRequestParams(ipInfoParams);
            resultResponse = apiService.getIpInfo(xwApiClient, ipInfoRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    /**
     * 获取天气信息
     *
     * @param weatherParams ip信息参数
     * @return {@link BaseResponse}<{@link ResultResponse}>
     */
    @GetMapping("/weatherInfo/EasyWeb")
    public BaseResponse<ResultResponse> getWeatherInfoEasyWeb(WeatherParams weatherParams) {
        ResultResponse resultResponse;
        try {
            WeatherRequest weatherRequest = new WeatherRequest();
            weatherRequest.setRequestParams(weatherParams);
            resultResponse = apiService.getWeatherInfo(weatherRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(resultResponse);
    }

    @GetMapping("/weatherInfo")
    public ResultResponse getWeatherInfo(WeatherParams weatherParams) {
        ResultResponse resultResponse;
        try {
            WeatherRequest weatherRequest = new WeatherRequest();
            weatherRequest.setRequestParams(weatherParams);
            resultResponse = apiService.getWeatherInfo(weatherRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    @GetMapping("/weatherInfo/setKey")
    public ResultResponse getWeatherInfoSetKey(WeatherParams weatherParams) {
        ResultResponse resultResponse;
        XwApiClient xwApiClient = new XwApiClient(xwApiClientConfig.getAccessKey(), xwApiClientConfig.getSecretKey());
        try {
            WeatherRequest weatherRequest = new WeatherRequest();
            weatherRequest.setRequestParams(weatherParams);
            resultResponse = apiService.getWeatherInfo(xwApiClient, weatherRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    @GetMapping("/randomWallpaper/setKey")
    public RandomWallpaperResponse getRandomWallpaperSetKey(RandomWallpaperParams randomWallpaperParams) {
        RandomWallpaperResponse resultResponse;
        XwApiClient xwApiClient = new XwApiClient(xwApiClientConfig.getAccessKey(), xwApiClientConfig.getSecretKey());
        try {
            RandomWallpaperRequest randomWallpaperRequest = new RandomWallpaperRequest();
            randomWallpaperRequest.setRequestParams(randomWallpaperParams);
            resultResponse = apiService.getRandomWallpaper(xwApiClient, randomWallpaperRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    @GetMapping("/randomWallpaper")
    public RandomWallpaperResponse getRandomWallpaper(RandomWallpaperParams randomWallpaperParams) {
        RandomWallpaperResponse resultResponse;
        try {
            RandomWallpaperRequest randomWallpaperRequest = new RandomWallpaperRequest();
            randomWallpaperRequest.setRequestParams(randomWallpaperParams);
            resultResponse = apiService.getRandomWallpaper(randomWallpaperRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    @GetMapping("/randomWallpaper/easyWeb")
    public BaseResponse<RandomWallpaperResponse> getRandomWallpaperEasyWeb(RandomWallpaperParams randomWallpaperParams) {
        RandomWallpaperResponse resultResponse;
        try {
            RandomWallpaperRequest randomWallpaperRequest = new RandomWallpaperRequest();
            randomWallpaperRequest.setRequestParams(randomWallpaperParams);
            resultResponse = apiService.getRandomWallpaper(randomWallpaperRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(resultResponse);
    }
}
