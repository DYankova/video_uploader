# video_uploader
web site where users can upload videos

The application runs on Java 7+ and Apache Tomcat

## Configuration
videos location is configurable in UploadServlet
```
private static final String SAVE_DIR = "C:\\videoUploads";
```
in server.xml of Tomcat add
```
<Context docBase="C:\videoUploads" path="/videos" />
```
 