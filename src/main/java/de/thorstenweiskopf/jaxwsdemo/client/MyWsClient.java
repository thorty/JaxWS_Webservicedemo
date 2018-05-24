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
    
    
    
    
    public void callWebservice(){
        //Get WS classes
        HelloWorldImplService service = new HelloWorldImplService();
        
        setHandler(service);
        
        HelloWorld helloWorld = service.getHelloWorldImplPort();
        
        //Todo Set Timeout
        //Todo Set Endpoint
        
        //Get the Response from WS
        System.out.println(helloWorld.getHelloWorldAsString("Dude"));
                
        printRequestResponse((BindingProvider)helloWorld);
  
    }
    

    /**
    * Get the original SOAP Request and Response Message
    */
    public void printRequestResponse(BindingProvider bp){                
        if (((BindingProvider)bp).getResponseContext().containsKey("SOAP_MSG_REQ") ){            
            String soapRequestMsg = (String) ((BindingProvider)bp).getResponseContext().get("SOAP_MSG_REQ");            
            System.out.println(soapRequestMsg);
        }
        if ( ((BindingProvider)bp).getResponseContext().containsKey("SOAP_MSG_RESP")){            
            String soapResponseMsg = (String) ((BindingProvider)bp).getResponseContext().get("SOAP_MSG_RESP");            
            System.out.println(soapResponseMsg);
        } 
    }

    private void setHandler(HelloWorldImplService service) {
        //Set the Custom HandlerResolver        
        service.setHandlerResolver(new JaxWsHandlerResolver());               
    }
    
}
