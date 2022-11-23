package com.itmo.microservices.demo.feed.impl.service
import com.itmo.microservices.demo.feed.api.model.CardResponse
import com.itmo.microservices.demo.feed.api.model.PaperListResponse
import com.itmo.microservices.demo.feed.api.service.FeedService
import com.itmo.microservices.demo.feed.impl.entity.Card
import com.itmo.microservices.demo.feed.impl.repository.FeedRepository
import org.springframework.stereotype.Service

@Service
class DefaultFeedService(private val repository: FeedRepository): FeedService {
    override fun getPaperCatalog(): PaperListResponse {
        var card = Card()
        card.name = "123"
        repository.save(card)

        return PaperListResponse(arrayOf(CardResponse(1, "123", "123", 1, 288)), arrayOf("hui"))
    }
}