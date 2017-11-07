package com.example.entityloadproblem;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix="neo4j")
@Validated
public class Neo4jProperties {
    @NotNull
    private String user;
    @NotNull
    private String password;
    @NotNull
    private String protocol;
    @NotNull
    private String server;
    @NotNull
    private int port;
    @NotNull
    private int poolSize;
    @NotNull
    private boolean clean;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public boolean clean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public String getUri(){
        return getProtocol()+"://"
                +getUser()
                +":"+getPassword()
                +"@"+getServer()
                +":"+getPort()
                ;
    }
}
