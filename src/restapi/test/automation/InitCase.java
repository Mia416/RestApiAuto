package restapi.test.automation;

import static org.testng.Assert.fail;

import java.util.Base64;

public class InitCase extends TestCase{
	
	protected String GETURL =null;
	protected String POSTURL =null;
	protected String GETUSERNAME =null;
	protected String GETPASSWORD =null;
	protected String POSTUSERNAME =null;
	protected String POSTPASSWORD =null;
	protected String GETURL_PARAM =null;
	protected String Header = null;
	
	public void decode()
	{
		byte[] decodedBytes = Base64.getDecoder().decode(GETURL);
		GETURL = new String(decodedBytes);
		
		decodedBytes = Base64.getDecoder().decode(POSTURL);
		POSTURL = new String(decodedBytes);
		
		decodedBytes = Base64.getDecoder().decode(GETUSERNAME);
		GETUSERNAME = new String(decodedBytes);
		
		decodedBytes = Base64.getDecoder().decode(GETPASSWORD);
		GETPASSWORD = new String(decodedBytes);
		
		decodedBytes = Base64.getDecoder().decode(POSTUSERNAME);
		POSTUSERNAME = new String(decodedBytes);
		
		decodedBytes = Base64.getDecoder().decode(POSTPASSWORD);
		POSTPASSWORD = new String(decodedBytes);
		
		decodedBytes = Base64.getDecoder().decode(GETURL_PARAM);
		GETURL_PARAM = new String(decodedBytes);
		
		decodedBytes = Base64.getDecoder().decode(Header);
		Header = new String(decodedBytes);
		 
	}
	

	public void setup()
	{
		if (GETURL_PARAM == null) {
            if(prop.getProperty("GETURL_PARAM") != null) {
            	GETURL_PARAM = prop.getProperty("GETURL_PARAM");
                logger.trace("GETURL_PARAM = " + GETURL_PARAM);
            } else {
                fail("Missing GETURL_PARAM parameter in testng.xml");
            }
        } else {
            logger.trace("GETURL_PARAM has already been initiated");
        }   	 
		
		if (GETURL == null) {
            if(prop.getProperty("GETURL") != null) {
            	GETURL = prop.getProperty("GETURL");
                logger.trace("GETURL = " + GETURL);
            } else {
                fail("Missing GETURL parameter in testng.xml");
            }
        } else {
            logger.trace("GETURL has already been initiated");
        }   	 
		
		if (POSTURL == null) {
	        if(prop.getProperty("POSTURL") != null) {
	        	POSTURL = prop.getProperty("POSTURL");
	            logger.trace("POSTURL = " + POSTURL);
	        } else {
	            fail("Missing POSTURL parameter in testng.xml");
	        }
	    } else {
	        logger.trace("POSTURL has already been initiated");
	    }   	
		
		if (GETUSERNAME == null) {
	        if(prop.getProperty("GETUSERNAME") != null) {
	        	GETUSERNAME = prop.getProperty("GETUSERNAME");
	            logger.trace("GETUSERNAME = " + GETUSERNAME);
	        } else {
	            fail("Missing GETUSERNAME parameter in testng.xml");
	        }
	    } else {
	        logger.trace("GETUSERNAME has already been initiated");
	    }   
		
		if (GETPASSWORD == null) {
	        if(prop.getProperty("GETPASSWORD") != null) {
	        	GETPASSWORD = prop.getProperty("GETPASSWORD");
	            logger.trace("GETPASSWORD = " + GETPASSWORD);
	        } else {
	            fail("Missing GETPASSWORD parameter in testng.xml");
	        }
	    } else {
	        logger.trace("GETPASSWORD has already been initiated");
	    }   
		
		if (POSTUSERNAME == null) {
	        if(prop.getProperty("POSTUSERNAME") != null) {
	        	POSTUSERNAME = prop.getProperty("POSTUSERNAME");
	            logger.trace("POSTUSERNAME = " + POSTUSERNAME);
	        } else {
	            fail("Missing POSTUSERNAME parameter in testng.xml");
	        }
	    } else {
	        logger.trace("POSTUSERNAME has already been initiated");
	    }   

	
	if (POSTPASSWORD == null) {
        if(prop.getProperty("POSTPASSWORD") != null) {
        	POSTPASSWORD = prop.getProperty("POSTPASSWORD");
            logger.trace("POSTPASSWORD = " + POSTPASSWORD);
        } else {
            fail("Missing POSTPASSWORD parameter in testng.xml");
        }
    } else {
        logger.trace("POSTPASSWORD has already been initiated");
    }   
	
	if (Header == null) {
        if(prop.getProperty("Header") != null) {
        	Header = prop.getProperty("Header");
            logger.trace("Header = " + Header);
        } else {
            fail("Missing Header parameter in testng.xml");
        }
    } else {
        logger.trace("Header has already been initiated");
    }   
}
	
	
}
