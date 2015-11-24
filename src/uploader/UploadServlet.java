package uploader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
@WebServlet("/upload_servlet") // browser path
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*50,      // 50MB
                 maxRequestSize=1024*1024*100)   // 100MB
public class UploadServlet extends HttpServlet {
 
	private static final long serialVersionUID = -3260244466831590625L;
	private static final String SAVE_DIR = "C:\\videoUploads";
	
    /**
     * Saves the file
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // creates the save directory if it does not exists
        File fileSaveDir = new File(SAVE_DIR);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        String fileName = "";
        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
            String filePath = SAVE_DIR + File.separator + fileName;
            part.write(filePath);
        }
        
        request.setAttribute("fileName", fileName);
        getServletContext().getRequestDispatcher("/video.jsp").forward(
                request, response); // forwards to video.jsp
    }
 
    /**
     * Returns the file name based on the HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
            	String filePath=(s.substring(s.indexOf("=") + 2, s.length()-1));
               	Path path = Paths.get(filePath);
               	return path.getFileName().toString();  	 
            }
        }
        return "";
    }
}