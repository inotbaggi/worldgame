package me.baggi.worldgame.service

import me.baggi.worldgame.exception.RoomCreationException
import me.baggi.worldgame.model.GameStatus
import me.baggi.worldgame.model.Room
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class RoomService {
    val activeRooms = mutableMapOf<String, Room>()

    fun createRoom(owner: UUID): Room {
        if (getRoomByOwnerId(owner) != null || getRoomByMemberId(owner) != null)
            throw RoomCreationException("This user already exists or created room")

        val code = UUID.randomUUID().toString().split("-")[0]
        val roomData = Room(code, GameStatus.WAITING_PLAYERS, owner)

        activeRooms[code] = roomData

        return roomData
    }

    fun getRoomByOwnerId(ownerId: UUID): Room? =
        activeRooms.entries.find { it.value.owner == ownerId }?.value

    fun getRoomByMemberId(memberId: UUID): Room? {
        //TODO ok
        return null
    }
}