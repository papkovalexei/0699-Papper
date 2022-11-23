package com.itmo.microservices.demo.feed.api.service;
import com.itmo.microservices.demo.feed.api.model.PaperListResponse;

interface FeedService {
    fun getPaperCatalog(): PaperListResponse
}