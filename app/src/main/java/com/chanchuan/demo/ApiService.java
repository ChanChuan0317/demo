package com.chanchuan.demo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author : Chanchuan
 * Date       : 2020/12/3/003    下午 1:34
 */
public interface ApiService {
    String gank = "https://gank.io/api/";

    @GET("v2/data/category/Girl/type/Girl/page/{page}/count/10")
    Observable<GankBean> getGirl(@Path("page") int page);
}
