package com.softhub.attacksound.api.event

import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class AttackSoundCancelEvent(
    val player: Player
)  : Event(false), Cancellable {
    private var cancel = false

    override fun getHandlers(): HandlerList {
        return getHandlerList()
    }

    companion object {
        @JvmStatic
        val HANDLER_LIST = HandlerList()

        @JvmStatic
        fun getHandlerList(): HandlerList {
            return HANDLER_LIST
        }
    }

    override fun isCancelled(): Boolean {
        return this.cancel
    }

    override fun setCancelled(p0: Boolean) {
        this.cancel = p0
    }
}