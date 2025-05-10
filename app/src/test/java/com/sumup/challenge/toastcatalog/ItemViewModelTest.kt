package com.sumup.challenge.toastcatalog

import androidx.lifecycle.Observer
import com.sumup.challenge.toastcatalog.data.model.Item
import com.sumup.challenge.toastcatalog.fake.FakeRepository
import com.sumup.challenge.toastcatalog.ui.items.ItemViewModel
import com.sumup.challenge.toastcatalog.ui.items.state.ItemUiState
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class ItemViewModelTest {

    private lateinit var itemViewModel: ItemViewModel
    private lateinit var fakeRepository: FakeRepository
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        // Set the Main dispatcher to the Test dispatcher
        Dispatchers.setMain(dispatcher)

        // Setup mock data
        val mockItems = listOf(
            Item(id = 1, name = "Avocado Toast", price = "5.99", currency = "EUR", lastSold = "2020-11-28T15:14:22Z"),
            Item(id = 2, name = "Bacon Toast", price = "1.99", currency = "EUR", lastSold = "2021-01-30T02:24:04Z"),
            Item(id = 3, name = "Crunchy Toast", price = "0.99", currency = "EUR", lastSold = "2021-03-17T03:45:47Z")
        )

        // Initialize ViewModel with FakeRepository
        fakeRepository = FakeRepository(mockItems)
        itemViewModel = ItemViewModel(fakeRepository)
    }

    @Test
    fun `get items happy path`() = runTest {
        // Act: Trigger loading items
        itemViewModel.loadItems()

        // Advance the dispatcher to process the coroutines
        dispatcher.scheduler.advanceUntilIdle()

        // Assert: Check the final state
        val uiState = itemViewModel.uiState.value
        if (uiState is ItemUiState.Success) {
            assertNotNull(uiState.items)
            assertEquals(3, uiState.items.size)
            assertEquals("Avocado Toast", uiState.items[0].name)
        }
    }

    @Test
    fun `get items sad path`() = runTest {
        // Setup for sad path: Empty data
        fakeRepository = FakeRepository(emptyList())
        itemViewModel = ItemViewModel(fakeRepository)

        // Act: Trigger loading items
        itemViewModel.loadItems()

        // Advance the dispatcher to process the coroutines
        dispatcher.scheduler.advanceUntilIdle()

        // Assert: Check the final state
        val uiState = itemViewModel.uiState.value
        if (uiState is ItemUiState.Error) {
            assertEquals("Failed to load items", uiState.message)
        }
    }

    @After
    fun tearDown() {
        // Reset the Main dispatcher to its original state
        Dispatchers.resetMain()
    }
}