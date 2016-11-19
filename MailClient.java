
/**
 * A class to model a simple email client. The client is run by a
 * particular user, and sends and retrieves mail via a particular server.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MailClient
{
    // The server used for sending and receiving.
    private MailServer server;
    // The user running this client.
    private String user;
    
    private boolean automaticAnswer;
    private String mensajeRespuestaAutomatica;
    private String asuntoRespuestaAutomatica;
    /**
     * Create a mail client run by user and attached to the given server.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
        mensajeRespuestaAutomatica = "Estoy de vacaciones";
    }

    /**
     * Return the next mail item (if any) for this user.
     */
    public MailItem getNextMailItem()
    {
		MailItem item = server.getNextMailItem(user);
		if (item != null){
            
		    if (automaticAnswer == true){
		        System.out.println(mensajeRespuestaAutomatica + asuntoRespuestaAutomatica);
            }
        }
        return item;
            
        
    }
    

    /**
     * Print the next mail item (if any) for this user to the text 
     * terminal.
     */
    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item == null) {
            System.out.println("No new mail.");
        }
        else {
            item.print();
        }
    }

    /**
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendMailItem(String to, String message, String subject)
    {
        MailItem item = new MailItem(user, to, message, subject);
        server.post(item);
    }
    
    public void devolverCantidadDeEmails()
    {
        System.out.println("Emails pendientes " + 
                           server.howManyMailItems(user));
    }
    
    public void habilitarAutoRespuesta(boolean autoRespuesta, String mensajeRespuestaAutomatica1,String asuntoRespuestaAutomatica1)
    {
        automaticAnswer = autoRespuesta;
        mensajeRespuestaAutomatica = mensajeRespuestaAutomatica1;
        asuntoRespuestaAutomatica = asuntoRespuestaAutomatica1;
    }
    
    
    
}
