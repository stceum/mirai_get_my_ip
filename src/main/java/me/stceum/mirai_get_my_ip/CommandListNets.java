package me.stceum.mirai_get_my_ip;

import net.mamoe.mirai.event.events.FriendMessageEvent;

import java.net.SocketException;
import java.util.Arrays;
import java.util.function.Consumer;

public class CommandListNets implements Consumer<FriendMessageEvent> {
    @Override
    public void accept(FriendMessageEvent event) {
        if (event.getMessage().contentToString().equals("/ip")) {
            if (ListNetsConfig.INSTANCE.getIds().contains(event.getFriend().getId())) {
                try {
                    event.getFriend().sendMessage(new ListNets().displayAllInterfaceInformation());
                } catch (SocketException e) {
                    e.printStackTrace();
                }
            } else {
                event.getFriend().sendMessage("Permission Denied!");
            }
        }
    }
}
