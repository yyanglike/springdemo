package com.example.data.elasticsearch.redisson;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by mic on 2019/7/23.
 */
@ConfigurationProperties(prefix = "spring.redisson",ignoreUnknownFields = false)
public class RedissonProperties {

    private String address; //连接地址

    private int database;

    /**
     * 等待节点回复命令的时间。该时间从命令发送成功时开始计时
     */
    private int timeout;

    private String password;

    // private RedissonPoolProperties pool;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public RedissonPoolProperties getPool() {
    //     return pool;
    // }

    // public void setPool(RedissonPoolProperties pool) {
    //     this.pool = pool;
    // }
}
