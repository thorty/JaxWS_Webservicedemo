package de.thorstenweiskopf.jaxwsdemo.client.handler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class JaxWsHandler implements SOAPHandler<SOAPMessageContext> {

    
        
    
	@Override
	public void close(MessageContext arg0) {
	}

	@Override
	public boolean handleFault(SOAPMessageContext arg0) {
            try {                  
                    //transform message to String
                    SOAPMessage message = arg0.getMessage();                                           
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    message.writeTo(out);
                    String strgMsg = new String(out.toByteArray());
                    
                    //store the response into the responseContext so that tha client can get it
                    //You could also do some kind of logging here
                    arg0.put("SOAP_MSG_RESP", strgMsg);                    
                    arg0.setScope("SOAP_MSG_RESP", MessageContext.Scope.APPLICATION);

                } catch (SOAPException ex) {
			Logger.getLogger(JaxWsHandler.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(JaxWsHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
                return true;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext arg0) {
		try {
                    //transform message to String
                    SOAPMessage message = arg0.getMessage();                    
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    message.writeTo(out);
                    String strgMsg = new String(out.toByteArray());
                    
                    //Check if it is response or request and store it into the responseContext so that tha client can get it
                    //You could also do some kind of logging here
                    boolean isOutboundMessage = (Boolean) arg0.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
                    if (isOutboundMessage) {                      
                        arg0.put("SOAP_MSG_REQ", strgMsg);
                        arg0.setScope("SOAP_MSG_REQ", MessageContext.Scope.APPLICATION);
                    } else {                                                
                        arg0.put("SOAP_MSG_RESP", strgMsg);
                        arg0.setScope("SOAP_MSG_RESP", MessageContext.Scope.APPLICATION);
                    }

                } catch (SOAPException ex) {
			Logger.getLogger(JaxWsHandler.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(JaxWsHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
                return true;
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}