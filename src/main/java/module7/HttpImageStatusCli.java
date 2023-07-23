package module7;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

@Slf4j
public class HttpImageStatusCli {

    private static final String EXIT = "q";

    public void askStatus() throws IOException, InterruptedException {
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        Scanner scanner = new Scanner(System.in);
        log.info("Enter HTTP status code OR if you want close program enter a '{}' char:", EXIT);
        do {
            try {
                if (!scanner.hasNext(EXIT)) {
                    int code = scanner.nextInt();
                    downloadImage(downloader, scanner, code);
                }
            } catch (InputMismatchException e) {
                log.info("Please enter valid number OR if you want close program enter a '{}' char:", EXIT);
                scanner.nextLine();
            }
        } while (!scanner.hasNext(EXIT));
    }

    private void downloadImage(HttpStatusImageDownloader downloader, Scanner scanner, int code) throws InterruptedException, IOException {
        try {
            downloader.downloadStatusImage(code);
            log.info("Please enter HTTP status code(1) OR if you want close program enter a '{}' char:", EXIT);
        } catch (InputMismatchException e) {
            log.info("There is not image for HTTP status {}", code);
            log.info("Please enter valid number OR if you want close program enter a '{}' char:", EXIT);
            scanner.nextLine();
        }
    }

}