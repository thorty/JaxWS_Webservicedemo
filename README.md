# JaxWS_Webservicedemo

Simple JAX-WS Project to show howto use a JAX-WS webservice client build with wsimport and howto catch the RAW 
soap XML request and response messages on the WS-Client side.

This Demo is written with netbeans and maven.
It has the server side stuff and a client side stuff included.


## History

On my solution I`m only running the client. And in some cases I have to send the RAW SOAP Request and Response Messages to another system. It was not easy to find a solution for that, so I think this could be helpfull for other too.

## Packages

de.thorstenweiskopf.jaxwsdemo.service : Simple Webservice Server Side. 
de.thorstenweiskopf.jaxwsdemo.client: From wsimport generated client service files and the MyWSClient Impl from myselfe
de.thorstenweiskopf.jaxwsdemo.client.handler: Handler classes that are needed to get the RAW SOAP XML Message

build with sources from herre: http://www.mkyong.com/webservices/jax-ws/jax-ws-hello-world-example/
