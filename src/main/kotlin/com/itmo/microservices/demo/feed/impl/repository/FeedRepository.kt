package com.itmo.microservices.demo.feed.impl.repository

import com.itmo.microservices.demo.feed.impl.entity.Card
import org.springframework.data.jpa.repository.JpaRepository

interface FeedRepository: JpaRepository<Card, Int> { }