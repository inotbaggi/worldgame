package me.baggi.worldgame.model

import java.util.UUID

data class Room(
    val code: String,
    val status: GameStatus,

    val owner: UUID,

    // players and other statistics in future
)
