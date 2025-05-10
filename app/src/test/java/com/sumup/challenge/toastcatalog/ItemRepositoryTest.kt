package com.sumup.challenge.toastcatalog

import com.sumup.challenge.toastcatalog.data.model.Item
import com.sumup.challenge.toastcatalog.fake.FakeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ItemRepositoryTest {

    val repo = FakeRepository()

    @Test
    fun `get items happy path`() = runBlocking {
        val mockItems = listOf(
            Item(id = 1, name = "Avocado Toast", price = "5.99", currency = "EUR", lastSold = "2020-11-28T15:14:22Z"),
            Item(id = 2, name = "Bacon Toast", price = "1.99", currency = "EUR", lastSold = "2021-01-30T02:24:04Z"),
            Item(id = 3, name = "Crunchy Toast", price = "0.99", currency = "EUR", lastSold = "2021-03-17T03:45:47Z")
        )

        val repo = FakeRepository(mockItems)

        val items = repo.fetchItems()

        assert(items.isNotEmpty())
        assert(items.size == 3)
        assert(items[0].name == "Avocado Toast")
        assert(items[1].price == "1.99")
        assert(items[2].id == 3)
    }


    @Test
    fun `get items sad path`() =  runBlocking{
        var items = repo.fetchItems()
        assert(items.isEmpty())

    }
}