package com.dergruenkohl.commands

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

object PingCommand: ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        event.deferReply().queue()
        event.jda.restPing.queue(
            { ping -> event.hook.editOriginal("Pong! $ping ms").queue() },
            { event.hook.editOriginal("Failed to ping").queue() }
        )
    }
}