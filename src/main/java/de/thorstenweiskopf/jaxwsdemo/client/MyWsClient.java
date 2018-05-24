/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.thorstenweiskopf.jaxwsdemo.client;

import de.thorstenweiskopf.jaxwsdemo.client.handler.JaxWsHandlerResolver;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author MVC6
 */
public class MyWsClient {
    
    public static void main(String[] args) {
        
        //Get WS classes
        HelloWorldImplService service = new HelloWorldImplService();
        
        
        //Set the Custom HandlerResolver        
        service.setHandlerResolver(new JaxWsHandlerResolver());        
        HelloWorld helloWorld = service.getHelloWorldImplPort();
        
        //Get the Response from WS
        System.out.println(helloWorld.getHelloWorldAsString("Dude"));
        //Get the original SOAP Request and Response Message
        System.out.println("");
        
        
        if (((BindingProvider)helloWorld).getResponseContext().containsKey("SOAP_MSG_REQ") ){            
            String soapRequestMsg = (String) ((BindingProvider)helloWorld).getResponseContext().get("SOAP_MSG_REQ");            
            System.out.println(soapRequestMsg);
        }
        if ( ((BindingProvider)helloWorld).getResponseContext().containsKey("SOAP_MSG_RESP")){            
            String soapResponseMsg = (String) ((BindingProvider)helloWorld).getResponseContext().get("SOAP_MSG_RESP");            
            System.out.println(soapResponseMsg);
        }        
        
    }
    

    
}
