package icu.xwang.xwapisdkdemo.controller;

import com.xiaowang.easyweb.common.BaseResponse;
import com.xiaowang.easyweb.common.ResultUtils;
import icu.xwang.xwapisdk.model.params.*;
import icu.xwang.xwapisdk.model.request.*;
import icu.xwang.xwapisdk.model.response.*;
import icu.xwang.xwapisdk.service.ApiService;
import icu.xwang.xwapisdkdemo.utils.ApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Author: xiaowang
 * @Date: 2024年10月14日 9:30
 * @Version: 1.0
 * @Description: Xw-api-sdk调用示例
 */
@RequestMapping("/invoke")
@RestController
@Slf4j
public class InvokeController {
    @Resource
    private ApiService apiService;

    @Autowired
    private ApiUtils apiUtils;


    /**
     * 随机毒鸡汤
     *
     * @return {@link PoisonousChickenSoupResponse}
     */
    @GetMapping("/getPoisonousChickenSoup")
    public PoisonousChickenSoupResponse getPoisonousChickenSoup() {
        return apiUtils.handleApiCall(() -> {
            PoisonousChickenSoupResponse response = apiService.getPoisonousChickenSoup(apiUtils.getXwApiClient());
            log.info("poisonousChickenSoup = {}", response);
            return response;
        });
    }

    /**
     * 随机毒鸡汤（使用密钥）
     *
     * @return {@link PoisonousChickenSoupResponse}
     */
    @GetMapping("/getPoisonousChickenSoupKey")
    public PoisonousChickenSoupResponse getPoisonousChickenSoupKey() {
        return apiUtils.handleApiCall(() -> {
            PoisonousChickenSoupResponse response = apiService.getPoisonousChickenSoup(apiUtils.getXwApiClient());
            log.info("poisonousChickenSoup = {}", response);
            return response;
        });
    }

    /**
     * 获取毒鸡汤未设置密钥
     *
     * @return {@link BaseResponse}<{@link PoisonousChickenSoupResponse}>
     */
    @GetMapping("/getPoisonousChickenSoupNotSetKey")
    public BaseResponse<PoisonousChickenSoupResponse> getPoisonousChickenSoupNotSetKey() {
        PoisonousChickenSoupResponse response = apiUtils.handleApiCall(apiService::getPoisonousChickenSoup);
        return ResultUtils.success(response);
    }

    /**
     * 随机土味情话
     *
     * @return {@link BaseResponse}<{@link LoveResponse}>
     */
    @GetMapping("/loveTalk/easyWeb")
    public BaseResponse<LoveResponse> getLoveTalkEasyWeb() {
        LoveResponse response = apiUtils.handleApiCall(apiService::randomLoveTalk);
        return ResultUtils.success(response);
    }

    @GetMapping("/loveTalk")
    public LoveResponse getLoveTalk() {
        return apiUtils.handleApiCall(apiService::randomLoveTalk);
    }

    @GetMapping("/loveTalk/setKey")
    public LoveResponse getLoveTalkSetKey() {
        return apiUtils.handleApiCall(() -> {
            LoveResponse response = apiService.randomLoveTalk(apiUtils.getXwApiClient());
            return response;
        });
    }

    /**
     * 获取星座运势
     *
     * @param horoscopeParams 星座参数
     * @return {@link BaseResponse}<{@link ResultResponse}>
     */
    @GetMapping("/getHoroscopeEasyWeb")
    public BaseResponse<ResultResponse> getHoroscopeEasyWeb(HoroscopeParams horoscopeParams) {
        ResultResponse response = apiUtils.handleApiCall(() -> {
            HoroscopeRequest request = new HoroscopeRequest();
            request.setRequestParams(horoscopeParams);
            return apiService.horoscope(request);
        });
        return ResultUtils.success(response);
    }

    @GetMapping("/getHoroscope")
    public ResultResponse getHoroscope(HoroscopeParams horoscopeParams) {
        HoroscopeRequest request = new HoroscopeRequest();
        request.setRequestParams(horoscopeParams);
        return apiUtils.handleApiCall(() -> apiService.horoscope(request));
    }

    @GetMapping("/getHoroscope/setKey")
    public ResultResponse getHoroscopeSetKey(HoroscopeParams horoscopeParams) {
        HoroscopeRequest request = new HoroscopeRequest();
        request.setRequestParams(horoscopeParams);
        return apiUtils.handleApiCall(() -> apiService.horoscope(apiUtils.getXwApiClient(), request));
    }

    /**
     * 获取天气信息
     *
     * @param weatherParams
     * @return
     */
    @GetMapping("/weatherInfo/EasyWeb")
    public BaseResponse<ResultResponse> getItNewsEasyWeb(WeatherParams weatherParams) {
        ResultResponse response = apiUtils.handleApiCall(() -> {
            WeatherRequest request = new WeatherRequest();
            request.setRequestParams(weatherParams);
            return apiService.getWeatherInfo(request);
        });
        return ResultUtils.success(response);
    }

    /**
     * 获取天气信息（未设置密钥）
     *
     * @param weatherParams
     * @return
     */
    @GetMapping("/weatherInfo")
    public ResultResponse getWeatherInfo(WeatherParams weatherParams) {
        WeatherRequest request = new WeatherRequest();
        request.setRequestParams(weatherParams);
        return apiUtils.handleApiCall(() -> apiService.getWeatherInfo(request));
    }

    /**
     * 获取天气信息（设置密钥）
     *
     * @param weatherParams
     * @return
     */
    @GetMapping("/weatherInfo/setKey")
    public ResultResponse getWeatherInfoSetKey(WeatherParams weatherParams) {
        WeatherRequest request = new WeatherRequest();
        request.setRequestParams(weatherParams);
        return apiUtils.handleApiCall(() -> apiService.getWeatherInfo(apiUtils.getXwApiClient(), request));
    }

    /**
     * 随机壁纸
     *
     * @param randomWallpaperParams
     * @return
     */
    @GetMapping("/randomWallpaper/setKey")
    public RandomWallpaperResponse getRandomWallpaperSetKey(RandomWallpaperParams randomWallpaperParams) {
        return apiUtils.handleApiCall(() -> {
            RandomWallpaperRequest request = new RandomWallpaperRequest();
            request.setRequestParams(randomWallpaperParams);
            return apiService.getRandomWallpaper(apiUtils.getXwApiClient(), request);
        });
    }

    @GetMapping("/randomWallpaper")
    public RandomWallpaperResponse getRandomWallpaper(RandomWallpaperParams randomWallpaperParams) {
        return apiUtils.handleApiCall(() -> {
            RandomWallpaperRequest request = new RandomWallpaperRequest();
            request.setRequestParams(randomWallpaperParams);
            return apiService.getRandomWallpaper(request);
        });
    }

    @GetMapping("/randomWallpaper/easyWeb")
    public BaseResponse<RandomWallpaperResponse> getRandomWallpaperEasyWeb(RandomWallpaperParams randomWallpaperParams) {
        RandomWallpaperResponse response = apiUtils.handleApiCall(() -> {
            RandomWallpaperRequest request = new RandomWallpaperRequest();
            request.setRequestParams(randomWallpaperParams);
            return apiService.getRandomWallpaper(request);
        });
        return ResultUtils.success(response);
    }

    /**
     * It 新闻
     *
     * @param itNewsParams
     * @return
     */
    @GetMapping("/itNews/easyweb")
    public BaseResponse<ResultResponse> getItNewsEasyWeb(ItNewsParams itNewsParams) {
        ResultResponse response = apiUtils.handleApiCall(() -> {
            ItNewsRequest request = new ItNewsRequest();
            request.setRequestParams(itNewsParams);
            return apiService.getItNews(request);
        });
        return ResultUtils.success(response);
    }

    @GetMapping("/itNews")
    public ResultResponse getItNews(ItNewsParams itNewsParams) {
        return apiUtils.handleApiCall(() -> {
            ItNewsRequest request = new ItNewsRequest();
            request.setRequestParams(itNewsParams);
            return apiService.getItNews(request);
        });
    }

    @GetMapping("/itNews/setKey")
    public ResultResponse getItNewsSetKey(ItNewsParams itNewsParams) {
        return apiUtils.handleApiCall(() -> {
            ItNewsRequest request = new ItNewsRequest();
            request.setRequestParams(itNewsParams);
            return apiService.getItNews(apiUtils.getXwApiClient(), request);
        });
    }

    /**
     * 手机号码归属地 - EasyWeb 版本
     *
     * @param phone 手机号码
     * @return BaseResponse<ResultResponse>
     */
    @GetMapping("/PhoneInfo/easyweb")
    public BaseResponse<ResultResponse> getPhoneInfoEasyWeb(@RequestParam String phone) {
        PhoneParams phoneParams = new PhoneParams().setPhone(phone);
        ResultResponse response = apiUtils.handleApiCall(() -> {
            PhoneRequest request = new PhoneRequest();
            request.setRequestParams(phoneParams);
            return apiService.getPhoneInfo(request);
        });
        return ResultUtils.success(response);
    }

    /**
     * 手机号码归属地
     *
     * @param phone 手机号码
     * @return ResultResponse
     */
    @GetMapping("/PhoneInfo")
    public ResultResponse getPhoneInfo(@RequestParam String phone) {
        PhoneParams phoneParams = new PhoneParams().setPhone(phone);
        return apiUtils.handleApiCall(() -> {
            PhoneRequest request = new PhoneRequest();
            request.setRequestParams(phoneParams);
            return apiService.getPhoneInfo(request);
        });
    }

    /**
     * 手机号码归属地 - 通过 setKey 调用
     *
     * @param phone 手机号码
     * @return ResultResponse
     */
    @GetMapping("/PhoneInfo/setKey")
    public ResultResponse getPhoneInfoSetKey(@RequestParam String phone) {
        PhoneParams phoneParams = new PhoneParams().setPhone(phone);
        return apiUtils.handleApiCall(() -> {
            PhoneRequest request = new PhoneRequest();
            request.setRequestParams(phoneParams);
            return apiService.getPhoneInfo(apiUtils.getXwApiClient(), request);
        });
    }

    /**
     * 获取操作系统，浏览器，浏览器版本，访客IP地址，访问时间，访客IP地址天气
     *
     * @param visitorParams
     * @return
     */
    @GetMapping("/visitorInfo/easyweb")
    public BaseResponse<ResultResponse> getVisitorInfoEasyWeb(VisitorParams visitorParams) {
        ResultResponse response = apiUtils.handleApiCall(() -> {
            VisitorRequest request = new VisitorRequest();
            request.setRequestParams(visitorParams);
            return apiService.getVisitorInfo(request);
        });
        return ResultUtils.success(response);
    }

    @GetMapping("/visitorInfo")
    public ResultResponse getVisitorInfo(VisitorParams visitorParams) {
        return apiUtils.handleApiCall(() -> {
            VisitorRequest request = new VisitorRequest();
            request.setRequestParams(visitorParams);
            return apiService.getVisitorInfo(request);
        });
    }

    @GetMapping("/visitorInfo/setKey")
    public ResultResponse getVisitorInfoSetKey(VisitorParams visitorParams) {
        return apiUtils.handleApiCall(() -> {
            VisitorRequest request = new VisitorRequest();
            request.setRequestParams(visitorParams);
            return apiService.getVisitorInfo(apiUtils.getXwApiClient(), request);
        });
    }


    /**
     * 获取名称 - 通过 setKey 调用
     *
     * @param name 名字
     * @return NameResponse
     */
    @GetMapping("/getName/setKey")
    public NameResponse getNameInfoSetKey(@RequestParam String name) {
        NameParams nameParams = new NameParams().setName(name);
        return apiUtils.handleApiCall(() -> {
            NameRequest request = new NameRequest();
            request.setRequestParams(nameParams);
            return apiService.getNameInfo(apiUtils.getXwApiClient(), request);
        });
    }

    /**
     * Bilibili热门数据 - EasyWeb版本
     *
     * @param bilibiliHotParams
     * @return
     */
    @GetMapping("/biliHot/easyweb")
    public BaseResponse<ResultResponse> getBilibiliHotEasyWeb(BilibiliHotParams bilibiliHotParams) {
        ResultResponse response = apiUtils.handleApiCall(() -> {
            BilibiliHotRequest request = new BilibiliHotRequest();
            request.setRequestParams(bilibiliHotParams);
            return apiService.getBiliHot(request);
        });
        return ResultUtils.success(response);
    }

    /**
     * Bilibili热门数据 - 默认版本
     *
     * @param bilibiliHotParams
     * @return
     */
    @GetMapping("/biliHot")
    public ResultResponse getBilibiliHot(BilibiliHotParams bilibiliHotParams) {
        return apiUtils.handleApiCall(() -> {
            BilibiliHotRequest request = new BilibiliHotRequest();
            request.setRequestParams(bilibiliHotParams);
            return apiService.getBiliHot(request);
        });
    }

    /**
     * Bilibili热门数据 - 带Key的版本
     *
     * @param bilibiliHotParams
     * @return
     */
    @GetMapping("/biliHot/setKey")
    public ResultResponse getBilibiliHotSetKey(BilibiliHotParams bilibiliHotParams) {
        return apiUtils.handleApiCall(() -> {
            BilibiliHotRequest request = new BilibiliHotRequest();
            request.setRequestParams(bilibiliHotParams);
            return apiService.getBiliHot(apiUtils.getXwApiClient(), request);
        });
    }

    /**
     * 抖音热门数据 - EasyWeb版本
     *
     * @param douYinHotParams
     * @return
     */
    @GetMapping("/douyinHot/easyweb")
    public BaseResponse<ResultResponse> getDouyinHotEasyWeb(DouYinHotParams douYinHotParams) {
        ResultResponse response = apiUtils.handleApiCall(() -> {
            DouYinHotRequest request = new DouYinHotRequest();
            request.setRequestParams(douYinHotParams);
            return apiService.getDouyinHot(request);
        });
        return ResultUtils.success(response);
    }

    /**
     * 抖音热门数据 - 默认版本
     *
     * @param douYinHotParams
     * @return
     */
    @GetMapping("/douyinHot")
    public ResultResponse getDouyinHot(DouYinHotParams douYinHotParams) {
        return apiUtils.handleApiCall(() -> {
            DouYinHotRequest request = new DouYinHotRequest();
            request.setRequestParams(douYinHotParams);
            return apiService.getDouyinHot(request);
        });
    }

    /**
     * 抖音热门数据 - 带Key的版本
     *
     * @param douYinHotParams
     * @return
     */
    @GetMapping("/douyinHot/setKey")
    public ResultResponse getDouyinHotSetKey(DouYinHotParams douYinHotParams) {
        return apiUtils.handleApiCall(() -> {
            DouYinHotRequest request = new DouYinHotRequest();
            request.setRequestParams(douYinHotParams);
            return apiService.getDouyinHot(apiUtils.getXwApiClient(), request);
        });
    }

    /**
     * 微博热门数据 - EasyWeb版本
     *
     * @param wbHotParams
     * @return
     */
    @GetMapping("/wbHot/easyweb")
    public BaseResponse<ResultResponse> getWbHotEasyWeb(WbHotParams wbHotParams) {
        ResultResponse response = apiUtils.handleApiCall(() -> {
            WbHotRequest request = new WbHotRequest();
            request.setRequestParams(wbHotParams);
            return apiService.getWbHot(request);
        });
        return ResultUtils.success(response);
    }

    /**
     * 微博热门数据 - 默认版本
     *
     * @param wbHotParams
     * @return
     */
    @GetMapping("/wbHot")
    public ResultResponse getWbHot(WbHotParams wbHotParams) {
        return apiUtils.handleApiCall(() -> {
            WbHotRequest request = new WbHotRequest();
            request.setRequestParams(wbHotParams);
            return apiService.getWbHot(request);
        });
    }

    /**
     * 微博热门数据 - 带Key的版本
     *
     * @param wbHotParams
     * @return
     */
    @GetMapping("/wbHot/setKey")
    public ResultResponse getWbHotSetKey(WbHotParams wbHotParams) {
        return apiUtils.handleApiCall(() -> {
            WbHotRequest request = new WbHotRequest();
            request.setRequestParams(wbHotParams);
            return apiService.getWbHot(apiUtils.getXwApiClient(), request);
        });
    }


}
