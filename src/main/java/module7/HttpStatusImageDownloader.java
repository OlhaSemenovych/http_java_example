package module7;

import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws InterruptedException, IOException {
        String imageName = String.format("imageStatus-%s.jpg", code);
        String imageLink = HttpStatusChecker.getStatusImage(code);
        try (InputStream input = new URL(imageLink).openStream()) {
            Files.copy(input, Paths.get("src/main/java/module7/" + imageName));
            log.info("Image downloaded successfully for status code - [{}]", code);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("An error occur while downloading image, please check entered status code");
        }
    }

}