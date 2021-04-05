package me.stceum.mirai_get_my_ip;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class ListNets {
    private String displayInterfaceInformation(NetworkInterface net_int) throws SocketException {
        StringBuilder info = new StringBuilder();
        info.append("Display name: ").append(net_int.getDisplayName());
        info.append("\n").append("Name: ").append(net_int.getName());
        Enumeration<InetAddress> inetAddresses = net_int.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            info.append("\n").append("InetAddress: ").append(inetAddress);
        }
        return info.toString();
    }
    public String displayAllInterfaceInformation()throws SocketException {
        StringBuilder all_info = new StringBuilder();
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        all_info.append("Lists: ");
        for (NetworkInterface net_int : Collections.list(nets)) {
            all_info.append("\n\n");
            all_info.append(displayInterfaceInformation(net_int));
        }
        return all_info.toString();
    }
}