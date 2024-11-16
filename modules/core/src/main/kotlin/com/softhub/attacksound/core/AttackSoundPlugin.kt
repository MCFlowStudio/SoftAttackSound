package com.softhub.attacksound.core

import com.softhub.attacksound.core.command.AttackSoundCommand
import com.softhub.attacksound.core.listener.PacketListener
import com.softhub.softframework.command.CommandRegister
import org.bukkit.plugin.java.JavaPlugin

class AttackSoundPlugin : JavaPlugin() {
    override fun onEnable() {
        val packetListener = PacketListener(this)
        server.pluginManager.registerEvents(packetListener, this)
        packetListener.registerPacketListener()
        CommandRegister.registerCommands(AttackSoundCommand(this))
    }

    override fun onDisable() {

    }
}