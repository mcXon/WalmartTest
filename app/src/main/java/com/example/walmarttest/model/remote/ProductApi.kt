package com.example.walmarttest.model.remote

import com.example.walmarttest.model.ProductResponse
import com.example.walmarttest.util.BASE_URL
import com.example.walmarttest.util.END_POINT
import com.example.walmarttest.util.QUERY_PAGE_NUMBER
import com.example.walmarttest.util.QUERY_PAGE_SIZE
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET(END_POINT)
    suspend fun getProducts(
        @Path(QUERY_PAGE_NUMBER) numberPage: Int = 1,
        @Path(QUERY_PAGE_SIZE) pageSize: Int = 30
    ): Response<ProductResponse>

    companion object{
        val api: ProductApi by lazy {
            initRetrofit()
        }
        private fun initRetrofit(): ProductApi{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                //                .addConverterFactory(MoshiConverterFactory.create().asLenient()) uncomment to have a problem in Retrofit and keep the Loading state
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(ProductApi::class.java)
        }
    }
}