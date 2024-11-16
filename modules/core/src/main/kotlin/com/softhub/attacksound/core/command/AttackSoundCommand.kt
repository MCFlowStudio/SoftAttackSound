package com.softhub.attacksound.core.command

import com.softhub.attacksound.core.AttackSoundPlugin
import com.softhub.softframework.command.Command
import com.softhub.softframework.command.CommandExecutor
import org.bukkit.command.CommandSender

@Command(name = "attacksound", isOp = true)
class AttackSoundCommand(
    private val plugin: AttackSoundPlugin
) {
    @CommandExecutor(label = "reload", description = "설정값을 다시 불러옵니다.")
    fun onReload(
        sender: CommandSender
    ) {
        sender.sendMessage("§a설정값을 다시 불러왔습니다.")
    }
}