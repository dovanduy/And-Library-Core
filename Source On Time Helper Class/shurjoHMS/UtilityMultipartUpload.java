package com.library;

import com.sm.cattleshurjohms.model.session.UserSession;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Deprecated
public class UtilityMultipartUpload {
    private HttpURLConnection httpConn;
    private DataOutputStream request;
    private final String boundary = "*****";
    private final String crlf = "\r\n";
    private final String twoHyphens = "--";

    /**
     * This constructor initializes a new HTTP POST request with content type
     * is set to multipart/form-data
     *
     * @param requestURL
     * @throws IOException
     */
    public UtilityMultipartUpload(String requestURL) throws IOException {

        // creates a unique boundary based on time stamp
        URL url = new URL(requestURL);
        httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setUseCaches(false);
        httpConn.setDoOutput(true); // indicates POST method
        httpConn.setDoInput(true);

        ///
        httpConn.setRequestProperty("Authorization", "Token " + UserSession.getApiAuthToken());
        //httpConn.setRequestMethod("POST");
        httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ///

        httpConn.setRequestMethod("POST");
        httpConn.setRequestProperty("Connection", "Keep-Alive");
        httpConn.setRequestProperty("Cache-Control", "no-cache");
        httpConn.setRequestProperty(
                "Content-Type", "multipart/form-data;boundary=" + this.boundary);

        request = new DataOutputStream(httpConn.getOutputStream());
    }

    /**
     * Adds a form field to the request
     *
     * @param name  field name
     * @param value field value
     */
    public void addFormField(String name, String value) throws IOException {
        request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
        request.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + this.crlf);
        request.writeBytes("Content-Type: text/plain; charset=UTF-8" + this.crlf);
        request.writeBytes(this.crlf);
        request.writeBytes(value + this.crlf);
        request.flush();
    }

    public void addHeaderField(String name, String value) throws IOException {
        request.writeBytes(this.twoHyphens + this.boundary + this.crlf);


        //request.writeBytes("Content-Type: application/x-www-form-urlencoded" + this.crlf);
        request.writeBytes(name + ": " + value + this.crlf);

        /*multipartUpload.addHeaderField("Content-Type", "application/x-www-form-urlencoded");
        multipartUpload.addHeaderField("Authorization", "Token " + UserSession.getApiAuthToken());*/
        /*request.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + this.crlf);
        request.writeBytes("Content-Type: text/plain; charset=UTF-8" + this.crlf);*/
        request.writeBytes(this.crlf);
        request.writeBytes(value + this.crlf);
        request.flush();
        //httpConn.setRequestProperty(name, value);
    }

    /**
     * Adds a upload file section to the request
     *
     * @param fieldName  name attribute in <input type="file" name="..." />
     * @param uploadFile a File to be uploaded
     * @throws IOException
     */
    public void addFile(String fieldName, File uploadFile) throws IOException {
        String fileName = uploadFile.getName();
        request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
        request.writeBytes("Content-Disposition: form-data; name=\"" +
                fieldName + "\";filename=\"" +
                fileName + "\"" + this.crlf);
        request.writeBytes(this.crlf);

        //byte[] bytes = Files.readAllBytes(uploadFile.toPath());
        byte[] bytes = fileToByteArray(uploadFile.toString());
        request.write(bytes);
    }

    public byte[] fileToByteArray(String argFilePath) {
        File file = new File(argFilePath);
        int size = (int) file.length();
        byte[] bytes = new byte[size];
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
            buf.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR_FileNotFoundException:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ERROR_IOException:");
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * Completes the request and receives response from the server.
     *
     * @return a list of Strings as response in case the server returned
     * status OK, otherwise an exception is thrown.
     * @throws IOException
     */
    public String finish() throws IOException {
        String response = "";

        request.writeBytes(this.crlf);
        request.writeBytes(this.twoHyphens + this.boundary +
                this.twoHyphens + this.crlf);

        request.flush();
        request.close();

        // checks server's status code first
        int status = httpConn.getResponseCode();
        if (status == HttpURLConnection.HTTP_OK || status != HttpURLConnection.HTTP_OK) {
            InputStream responseStream = new BufferedInputStream(httpConn.getInputStream());

            BufferedReader responseStreamReader = new BufferedReader(new InputStreamReader(responseStream));

            String line = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = responseStreamReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            responseStreamReader.close();

            response = stringBuilder.toString();
            httpConn.disconnect();
        } else {
            throw new IOException("Server returned non-OK status: " + status);
        }

        return response;
    }
}
//https://blog.morizyun.com/blog/android-httpurlconnection-post-multipart/index.html
//https://stackoverflow.com/questions/34915556/post-a-file-with-other-form-data-using-httpurlconnection
//https://stackoverflow.com/questions/11766878/sending-files-using-post-with-httpurlconnection
//https://stackoverflow.com/questions/34276466/simple-httpurlconnection-post-file-multipart-form-data-from-android-to-google-bl/34324886
//https://gist.github.com/Antarix/a36faeaff3092b1fd977
//https://gist.github.com/mcxiaoke/8929954

//https://stackoverflow.com/questions/12732422/adding-header-for-httpurlconnection
//http://qaru.site/questions/177022/simple-httpurlconnection-post-file-multipartform-data-from-android-to-google-blobstore