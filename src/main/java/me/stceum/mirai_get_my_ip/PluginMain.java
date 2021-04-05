package me.stceum.mirai_get_my_ip;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.FriendMessageEvent;

public final class PluginMain extends JavaPlugin {
    public static final PluginMain INSTANCE = new PluginMain(); // 必须 public static, 必须名为 INSTANCE

    private PluginMain() {
        super(new JvmPluginDescriptionBuilder("me.stceum.get_my_ip", "1.0-SNAPSHOT")
                .author("stceum")
                .name("mirai_get_my_ip")
                .info("自动汇报ip地址")
                .build()
        );
    }

    @Override
    public void onEnable() {
        GlobalEventChannel.INSTANCE.subscribeAlways(FriendMessageEvent.class, new CommandListNets());
        reloadPluginConfig(ListNetsConfig.INSTANCE);
    }
}
