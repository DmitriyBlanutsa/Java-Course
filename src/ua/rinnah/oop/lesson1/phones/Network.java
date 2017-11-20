package ua.rinnah.oop.lesson1.phones;

import java.util.HashSet;

public class Network{

    private HashSet<String> subscribers = new HashSet<>(100);

    public Network(HashSet<String> subscribers) {
        this.subscribers = subscribers;
    }

    public Network() {
    }

    public HashSet<String> getSubscribers() {
        return subscribers;
    }
}
