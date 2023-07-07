package serialization_poc;


import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import java.io.Serializable;

public class Greetings implements Callable{

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
        // Get the Mule message from the event context
        org.mule.api.MuleMessage muleMessage = eventContext.getMessage();
       


        // Set a session property on the Mule message
        muleMessage.setProperty("propertyName", this, PropertyScope.SESSION);

        // Return the modified Mule message
        System.out.println("Your Message is: " + muleMessage);
        return muleMessage;
    }
}
