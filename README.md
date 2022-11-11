# Demo Java Play Framework 

Yatzy web-app implemented using Java and Java Play Framework (WIP)

## What's with JavaPlay?

It's open-source!

Uses the SBT SBT (*Scala Build Tool*) which:

- Builds and tests your app
- Runs a server
- Compiles changes on the fly - just refresh your browser :) 
- Integrates well with the IntelliJ IDE. 

## LAN testing with Allowed Hosts 

> Learned using [Play 2.8.x docs](https://www.playframework.com/documentation/2.8.x/AllowedHostsFilter#Allowed-hosts-filter)


By default, your app is in a 'no solicitors' mode where it is only allowed to serve requests from `localhost` or `127.0.0.1`.
This means that only the computer running the app can make a request to the app, even if your port `:9000` is technically open. 

If you want to allow your SBT server to serve remote HTTP requests, you'll need to allow it to respond to requests sent to your public IP address. 

The behaviour settings of your SBT server can be declared within the [conf/application.conf](./diceroller/conf/application.conf)

Whatever settings you specify in your `application.conf` file will override the default settings (found somewhere in the classpath).
An example of these defaults can be found here : [example reference.conf](https://www.playframework.com/documentation/2.8.x/resources/confs/filters-helpers/reference.conf)

There are two easy ways to make you server available on LAN. Either way, you will need your server's local IP address
in order to send a request.

### Knowing your IP

On macOS terminal

```zsh
ifconfig | grep "inet "
```

On windows command line:

```shell
ipconfig #Look for your IPv4 
```

### AllowedHosts - Per Route

In your application.conf file, add a statement to enable the whitelist tag `anyhost`.

```diff
+play.filters.hosts.routeModifiers.whiteList = [anyhost]
```

Now you can use this tag to specify exactly which routes your app is allowed to serve. 

```diff
+anyhost
GET    /                            controllers.HomeController.index()

# This route is still localhost only
GET    /version                     controllers.HomeController.version()
```

## AllowedHosts - Per IP

The default setting in the reference.conf file is

```scala
play.filters.hosts {allowed = ["localhost", ".local", "127.0.0.1"]}
```

In our application.conf, we can override it and add the public ip of our server:

```diff
+play.filters.hosts {allowed = ["localhost", ".local", "127.0.0.1", "192.168.0.42"]}
```

you can also add domain names and specific ports if needed. 

