package me.stceum.mirai_get_my_ip

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.value
import java.util.*

object ListNetsConfig : AutoSavePluginConfig("ListNetsConfig") {
    var ids: MutableList<Long> by value(mutableListOf(-1L))
}