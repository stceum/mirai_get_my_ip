import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.console.MiraiConsole
import net.mamoe.mirai.console.plugin.PluginManager.INSTANCE.enable
import net.mamoe.mirai.console.plugin.PluginManager.INSTANCE.load
import net.mamoe.mirai.console.terminal.MiraiConsoleTerminalLoader
import net.mamoe.mirai.utils.BotConfiguration
import okhttp3.internal.platform.AndroidPlatform
import me.stceum.mirai_get_my_ip.PluginMain

suspend fun main() {
    MiraiConsoleTerminalLoader.startAsDaemon()

    PluginMain.INSTANCE.load()
    PluginMain.INSTANCE.enable()

    val bot = MiraiConsole.addBot(2863477503, "Zhou001018") {
        fileBasedDeviceInfo()
        protocol = BotConfiguration.MiraiProtocol.ANDROID_PAD
    }.alsoLogin()

    MiraiConsole.job.join()
}