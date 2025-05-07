package com.sumup.challenge.toastcatalog

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.sumup.challenge.toastcatalog.data.model.Item
import com.sumup.challenge.toastcatalog.data.network.NetworkClient
import kotlinx.coroutines.*
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.net.HttpURLConnection

class NetworkClientTests {

    /*private lateinit var mockWebServer: MockWebServer
    private lateinit var networkClient: NetworkClient

    private val expectedResponseData = """
        [{
            "name": "Avocado Toast",
            "price": "5.99",
            "id": 1,
            "currency": "EUR",
            "last_sold": "2020-11-28T15:14:22Z"
          },
          {
            "name": "Bacon Toast",
            "id": 2,
            "price": "1.99",
            "currency": "EUR",
            "last_sold": "2021-01-30T02:24:04Z"
          },
          {
            "name": "Crunchy Toast",
            "id": 3,
            "price": "0.99",
            "currency": "EUR",
            "last_sold": "2021-03-17T03:45:47Z"
          }
        ]
    """

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        networkClient = NetworkClient(baseUrl = mockWebServer.url("/").toString())
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun testHappyPathReturnsExpectedItems() = runBlocking {
        // Arrange
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(expectedResponseData)
        )

        val gson = GsonBuilder().create()
        val typeToken = object : TypeToken<List<Item>>() {}.type
        val expectedResponse = gson.fromJson<List<Item>>(expectedResponseData, typeToken)

        // Act
        val result = networkClient.getItems()

        // Assert
        Assert.assertEquals(expectedResponse, result)
    }

    @Test
    fun testUnhappyPathReturnsEmptyListOnServerError() = runBlocking {
        // Arrange
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR)
        )

        // Act
        val result = networkClient.getItems()

        // Assert
        Assert.assertTrue(result.isEmpty())
    }*/
}
