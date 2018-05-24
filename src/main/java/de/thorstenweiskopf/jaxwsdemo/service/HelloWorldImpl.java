/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.thorstenweiskopf.jaxwsdemo.service;


 
import de.thorstenweiskopf.jaxwsdemo.client.HelloWorld;
import javax.jws.WebService;
 
//Service Implementation
@WebService(endpointInterface = "de.thorstenweiskopf.jaxwsdemo.service.HelloWorld")
public class HelloWorldImpl implements HelloWorld{
 
	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World from JAX-WS " + name;
	}
 
}