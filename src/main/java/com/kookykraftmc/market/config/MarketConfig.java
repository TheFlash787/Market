package com.kookykraftmc.market.config;


import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class MarketConfig {

    @Setting(value = "Version", comment = "Do not change this.")
    public double version = 0.2;

    @Setting(value = "Server", comment = "Name of the server to be used when storing data.")
    public String server = "TEST";

    @Setting("Redis")
    public RedisDataStore redis = new RedisDataStore();

    @Setting("MongoDB")
    public MongoDataStore mongo = new MongoDataStore();

    @Setting(value = "Chest-Is-Default", comment = "Should the chest GUI be the default gui instead of the chat gui.")
    public boolean chestDefault = false;


    @ConfigSerializable
    public static class RedisDataStore {

        @Setting("Enabled")
        public boolean enabled = true;

        @Setting("Host")
        public String host = "localhost";

        @Setting("Port")
        public int port = 6379;

        @Setting("Password")
        public String password = "";

        @Setting("Keys")
        public Keys keys = new Keys();

        @ConfigSerializable
        public static class Keys {
            @Setting(value = "UUID-Cache")
            public String uuidCache = "market:uuidcache";
        }
    }

    @ConfigSerializable
    public static class MongoDataStore {
        @Setting(value = "Enabled", comment = "You can have Redis or MongoDB enabled, but not both at the moment.")
        public boolean enabled = false;

        @Setting("Host")
        public String host = "localhost";

        @Setting("Port")
        public int port = 27017;

        @Setting("User")
        public String username = "admin";

        @Setting("Password")
        public String password = "";

        @Setting("DataBase")
        public String database = "database";
    }
}
