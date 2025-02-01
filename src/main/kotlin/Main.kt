package com.dergruenkohl

import dev.minn.jda.ktx.jdabuilder.default
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent

fun main() {
    val builder = JDABuilder.createDefault("token")
    builder.enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS))
    builder.build().awaitReady()

}