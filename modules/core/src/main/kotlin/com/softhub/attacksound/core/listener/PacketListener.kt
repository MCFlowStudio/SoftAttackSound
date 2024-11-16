package com.softhub.attacksound.core.listener

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.ProtocolManager
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketEvent
import com.softhub.attacksound.api.event.AttackSoundCancelEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin

class PacketListener(
    private val plugin: Plugin
) : Listener {
    private val blacklistedSounds = listOf(
        "ENTITY_PLAYER_ATTACK_NODAMAGE",
        "ENTITY_PLAYER_ATTACK_KNOCKBACK",
        "ENTITY_PLAYER_ATTACK_SWEEP",
        "ENTITY_PLAYER_ATTACK_STRONG",
        "ENTITY_PLAYER_ATTACK_CRIT",
        "ENTITY_PLAYER_ATTACK_WEAK"
    )

    fun registerPacketListener() {
        val protocolManager: ProtocolManager = ProtocolLibrary.getProtocolManager()

        protocolManager.addPacketListener(object : PacketAdapter(
            plugin,
            ListenerPriority.NORMAL,
            PacketType.Play.Server.NAMED_SOUND_EFFECT
        ) {
            override fun onPacketSending(event: PacketEvent) {
                val player = event.player
                if (event.packetType == PacketType.Play.Server.NAMED_SOUND_EFFECT) {
                    val soundEffect = event.packet.soundEffects.read(0) as Enum<*>

                    if (blacklistedSounds.contains(soundEffect.name)) {
                        val event = AttackSoundCancelEvent(player)
                        plugin.server.pluginManager.callEvent(event)
                        if (event.isCancelled)
                            return
                        event.isCancelled = true
                    }
                }
            }
        })
    }
}