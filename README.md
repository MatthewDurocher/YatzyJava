# Demo Java Play Framework 


## LAN testing with Allowed Hosts 

> Learned using [Play 2.8.x docs](https://www.playframework.com/documentation/2.8.x/AllowedHostsFilter#Allowed-hosts-filter)

To allow remote devices to make HTTP requests, you need to 'allow' you host machine to accept them. 
The behaviour settings of your SBT server can be declared within the [conf/application.conf](./diceroller/conf/application.conf).

Whatever settings you specify in application.conf will override the default settings (that exist somewhere in the classpath).
An example of these defaults can be found [here](https://www.playframework.com/documentation/2.8.x/resources/confs/filters-helpers/reference.conf).

There are two easy ways to make you server available on LAN. Either way, you will need your server's local IP address
in order to send a request.

On macOS terminal

```zsh
ifconfig | grep "inet "
```

On windows command line:

```shell
ipconfig #Look for your IPv4 
```


```
In [conf/routes](./diceroller/conf/routes)


```
