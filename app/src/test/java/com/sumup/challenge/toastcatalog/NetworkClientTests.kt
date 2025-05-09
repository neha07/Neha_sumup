package com.sumup.challenge.toastcatalog

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.sumup.challenge.toastcatalog.data.model.Item
import com.sumup.challenge.toastcatalog.data.network.NetworkClient
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import junit.framework.TestCase.fail
import kotlinx.coroutines.*
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.json.JSONException
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.net.HttpURLConnection

class NetworkClientTests {

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

    @Test
    fun `parseToastItems - Happy Path`() {
        // Simulate parsing the JSON into a list of ToastItem objects
        val result = parseToastItems(expectedResponseData)

        // Check that the result is as expected
        assertNotNull(result)
        assertEquals(3, result.size)
        assertEquals("Avocado Toast", result[0].name)
        assertEquals(1, result[0].id)
        assertEquals("5.99", result[0].price)
    }

    @Test
    fun `parseToastItems - Unhappy Path - Invalid JSON`() {
        // Simulate parsing invalid JSON
        val invalidJson = """
            [{
                "name": "Avocado Toast",
                "price": "5.99",
                "id": "wrong_id",  // Invalid field type
                "currency": "EUR",
                "last_sold": "2020-11-28T15:14:22Z"
            }]
        """

        try {
            parseToastItems(invalidJson)
            fail("Expected an exception to be thrown due to invalid JSON")
        } catch (e: Exception) {
            assertTrue(e is JSONException) // Checking for specific exception type
        }
    }

    private fun parseToastItems(json: String): List<Item> {
        // This function should contain the actual parsing logic
        val gson = Gson()  // Assuming you're using Gson to parse the JSON
        return gson.fromJson(json, Array<Item>::class.java).toList()
    }
}
