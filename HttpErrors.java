import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HttpErrors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("HTTP Error Code Description");
        System.out.print("Enter an HTTP error code (e.g., 404): ");
        int errorCode = scanner.nextInt();
        
        String errorDescription = getErrorDescription(errorCode);
        if (errorDescription != null) {
            System.out.println("Error " + errorCode + ": " + errorDescription);
            String possibleFix = getPossibleFix(errorCode);
            if (possibleFix != null) {
                System.out.println("Possible Fix: " + possibleFix);
            }
        } else {
            System.out.println("Invalid HTTP error code.");
        }
        
        scanner.close();
    }
    
    public static String getErrorDescription(int errorCode) {
        Map<Integer, String> errorDescriptions = new HashMap<>();
        errorDescriptions.put(100, "Continue - The server has received the request headers and the client should proceed to send the request body.");
        errorDescriptions.put(101, "Switching Protocols - The server understands and is willing to comply with the client's request for a protocol change.");
        errorDescriptions.put(200, "OK - The request has succeeded.");
        errorDescriptions.put(201, "Created - The request has been fulfilled, and a new resource has been created.");
        errorDescriptions.put(202, "Accepted - The request has been accepted for processing, but the processing has not been completed.");
        errorDescriptions.put(204, "No Content - The request has succeeded, but there is no new information to send back.");
        errorDescriptions.put(300, "Multiple Choices - The requested resource has multiple representations; the user agent must select one.");
        errorDescriptions.put(301, "Moved Permanently - The requested resource has been assigned a new permanent URI.");
        errorDescriptions.put(302, "Found - The requested resource resides temporarily under a different URI.");
        errorDescriptions.put(304, "Not Modified - The resource has not been modified since the specified date.");
        errorDescriptions.put(400, "Bad Request - The server cannot or will not process the request due to a client error.");
        errorDescriptions.put(401, "Unauthorized - The request has not been applied because it lacks valid authentication credentials for the target resource.");
        errorDescriptions.put(403, "Forbidden - The server understood the request but refuses to authorize it.");
        errorDescriptions.put(404, "Not Found - The requested resource could not be found on the server.");
        errorDescriptions.put(500, "Internal Server Error - The server has encountered an unexpected condition that prevented it from fulfilling the request.");
        // Add more error descriptions as needed
        
        return errorDescriptions.get(errorCode);
    }
    
    public static String getPossibleFix(int errorCode) {
        Map<Integer, String> possibleFixes = new HashMap<>();
        possibleFixes.put(100, "Ensure the client proceeds to send the request body.");
        possibleFixes.put(101, "Ensure that the client and server are using compatible protocols.");
        possibleFixes.put(200, "No specific fix required; the request has succeeded.");
        possibleFixes.put(201, "No specific fix required; a new resource has been created.");
        possibleFixes.put(202, "No specific fix required; the processing is not completed.");
        possibleFixes.put(204, "No specific fix required; no new information to send back.");
        possibleFixes.put(300, "The user agent must select one of the resource representations.");
        possibleFixes.put(301, "Update your application to use the new permanent URI.");
        possibleFixes.put(302, "Update your application to use the temporary URI.");
        possibleFixes.put(304, "Use a cached version of the resource if available.");
        possibleFixes.put(400, "Check the request for syntax errors or missing parameters.");
        possibleFixes.put(401, "Provide valid authentication credentials.");
        possibleFixes.put(403, "Check your credentials and permissions to access the resource.");
        possibleFixes.put(404, "Check the URL for typos and ensure that the resource exists on the server.");
        possibleFixes.put(500, "Check server logs for details on the internal server error.");
        // Add more possible fixes as needed
        
        return possibleFixes.get(errorCode);
    }
}
