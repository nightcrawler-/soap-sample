/*
 * MIT License
 *
 * Copyright (c) 2022  Frederick Nyawaya
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.cafrecode.soapsample.api

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.cafrecode.soapsample.api.request.RequestBody
import com.cafrecode.soapsample.api.request.RequestEnvelope
import com.cafrecode.soapsample.api.request.RequestModel
import com.cafrecode.soapsample.api.response.Envelope
import com.cafrecode.soapsample.api.response.core.ApiResponse
import com.cafrecode.soapsample.util.LiveDataTestUtil.getValue
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.BufferedSource
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets
import java.util.Collections
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.simpleframework.xml.Serializer
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import org.simpleframework.xml.strategy.Strategy
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.lang.reflect.Field

internal class ServiceTest {

    @get:Rule
    var instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var service: Service
    lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        val client = OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .build()

        val strategy: Strategy = AnnotationStrategy()
        val serializer: Serializer = Persister(strategy)

        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(client)
            .build()
            .create(Service::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Throws(IOException::class)
    private fun enqueueResponse(fileName: String) {
        enqueueResponse(fileName, Collections.emptyMap())
    }

    @Test
    fun getResponse() {
        enqueueResponse("response.xml")

        val envelop = RequestEnvelope();
        val body = RequestBody()
        val model = RequestModel()

        body.getWeatherbyCityName = model
        envelop.body = body

        val resp = getResponse(service.getWeatherbyCityName(requestEnvelope = envelop))
        val request = mockWebServer.takeRequest()

        assertThat(request.path, `is`("/getMaritalStatus"))
        assertThat(request.method, `is`("GET"))
        assertThat(resp, `is`(notNullValue()))
        assertThat(resp.body?.getWeatherbyCityNameResponse?.result!!.size, `is`(2))
        //assertThat(resp.data!![0].title, `is`("Single"))
    }

    private fun getResponse(call: LiveData<ApiResponse<Envelope>>): Envelope {
        val response: ApiResponse<Envelope> = getValue(call)

        println(response.toString())

        val body: Field = response.javaClass.getDeclaredField("body")
        body.isAccessible = true
        return body.get(response) as Envelope
    }

    @Throws(IOException::class)
    private fun enqueueResponse(
        fileName: String,
        headers: Map<String, String>
    ) {
        val inputStream: InputStream? =
            javaClass.classLoader?.getResourceAsStream("api-response/$fileName")
        val source: BufferedSource = inputStream!!.source().buffer()
        val mockResponse = MockResponse()
        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }
        mockWebServer.enqueue(
            mockResponse
                .setBody(source.readString(StandardCharsets.UTF_8))
        )
    }
}